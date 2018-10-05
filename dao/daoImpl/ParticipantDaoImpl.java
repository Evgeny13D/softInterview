package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.DaoException;
import A402.dao.ParticipantDao;
import A402.dao.ResultSetConverter;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Participant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDaoImpl extends AbstractDao implements ParticipantDao {

    private static final String INSERT = "insert into PAYHALL.participants (first_name, last_name, phone_number, email, event_id, total_price, booking_status) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL = "select id, first_name, last_name, phone_number, email, event_id, total_price, booking_status from PAYHALL.participants";

    @Override
    public Participant storeParticipant(Participant participant) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, participant.getFirstName());
            statement.setString(2, participant.getLastName());
            statement.setString(3, participant.getPhoneNumber());
            statement.setString(4, participant.getEmail());
            statement.setInt(5, participant.getEventId());
            statement.setDouble(6, participant.getTotal_price());
            statement.setString(7, participant.getBookingStatus().getDbRepresentation());

            statement.executeUpdate();

            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                participant.setId(generatedKeys.getInt(1));
            } else {
                throw new DaoException("Creating event failed, no ID obtained.");
            }

            return participant;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeDBResources(connection, statement);
        }
    }

    @Override
    public List<Participant> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL);

            try (ResultSet rs = statement.executeQuery()) {
                ArrayList<Participant> participants = new ArrayList<>();
                while (rs.next()) {
                    Participant participant = ResultSetConverter.convertToParticipant(rs);
                    participants.add(participant);
                }
                return participants;
            }

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeDBResources(connection, statement);
        }
    }
}
