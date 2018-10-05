package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.DaoException;
import A402.dao.ResultSetConverter;
import A402.dao.SeatDao;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeatDaoImpl extends AbstractDao implements SeatDao {

    private static final String SELECT_ALL =
            "select id, row_number, seat_number, price, event_id, participant_id " +
                    "from A402.seats where event_id = ?";
    private static final String INSERT = "insert into A402.seats (row_number, seat_number, price, event_id) " +
            "values (?, ?, ?, ?)";
    private static final String UPDATE_PARTICIPANT_ID = "update A402.seats set participant_id = ? " +
            "where id in (%s)";

    private static final String UPDATE_PRICE = "update A402.seats set price = ? " +
            "where event_id = ?";

    @Override
    public List<Seat> listOfSeatsByEvent(int eventId) {
        List<Seat> seats = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SELECT_ALL);
            statement.setInt(1, eventId);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Seat seat = ResultSetConverter.convertToSeat(resultSet);
                seats.add(seat);
            }

            connection.setAutoCommit(true);
            return seats;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            this.closeDBResources(connection, statement, resultSet);
        }
    }

    @Override
    public Seat storeSeat(Seat seat) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, seat.getRowNumber());
            statement.setInt(2, seat.getSeatNumber());
            statement.setDouble(3, seat.getPrice());
            statement.setInt(4, seat.getEventId());
            //statement.setInt(5, seat.getParticipantId());
            statement.executeUpdate();

            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                seat.setId(generatedKeys.getInt(1));
            }
            else {
                throw new DaoException("Creating event failed, no ID obtained.");
            }

            return seat;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, statement);
        }
    }

    @Override
    public void updateParticipant(int[] seatIds, int participantId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = String.format(UPDATE_PARTICIPANT_ID, preparePlaceholders(seatIds.length));

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, participantId);
            setIntValues(statement, 2, seatIds);
            statement.executeUpdate();
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, statement);
        }
    }

    public void updatePrice(int eventId, double price) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_PRICE);
            statement.setInt(1, eventId);
            statement.setDouble(2, price);
            statement.executeUpdate();
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, statement);
        }
    }

    private String preparePlaceholders(int number) {
        return String.join(",", Collections.nCopies(number, "?"));
    }

    private void setIntValues(PreparedStatement statement, int startValueNumber, int ... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setInt(startValueNumber + i, values[i]);
        }
    }

}
