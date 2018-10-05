package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.DaoException;
import A402.dao.EventDao;
import A402.dao.ResultSetConverter;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDaoImpl extends AbstractDao implements EventDao {

    private static final String SELECT_ALL =
            "select id, name_en, name_ru, day_of_month, month_number, day_of_week_number, \n" +
                    "\t\tyear, start_time, end_time, location_en, location_ru," +
                    "\t\t\taddress_en, address_ru, description_en, description_ru, price\n" +
                    "    from A402.events";

    private static final String SELECT_BY_ID =
            "select id, name_en, name_ru, day_of_month, month_number, day_of_week_number, \n" +
                    "\t\tyear, start_time, end_time, location_en, location_ru," +
                    "\t\t\taddress_en, address_ru, description_en, description_ru, price\n" +
                    "    from A402.events " +
                    "\twhere id = ?";

    private static final String INSERT =
            "insert into A402.events (name_en, name_ru, day_of_month, month_number, day_of_week_number, " +
                    "\t\tyear, start_time, end_time, location_en, location_ru," +
                    "\t\t\taddress_en, address_ru, description_en, description_ru, price)\n" +
                    "\tvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE = "update A402.events " +
            "set day_of_month = ?, month_number = ?, day_of_week_number = ?, year = ?, start_time = ?, end_time = ?, " +
            "location_en = ?, location_ru = ?, address_en = ?, address_ru = ?, name_en = ?, name_ru = ?, description_en = ?, " +
            "description_ru = ?, price = ? " +
            "where id = ?";

    private static final String DELETE_BY_ID = "delete from A402.events where id = ?";

    @Override
    public List<Event> listOfEvents() {
        List<Event> events = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL);

            while(resultSet.next()) {
                Event event = ResultSetConverter.convertToEvent(resultSet);
                events.add(event);
            }

            connection.setAutoCommit(true);
            return events;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            this.closeDBResources(connection, statement, resultSet);
        }
    }

    @Override
    public Event getEventById(int eventId) {
        Event event = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, eventId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                event = ResultSetConverter.convertToEvent(resultSet);
            }

            connection.setAutoCommit(true);
            return event;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            this.closeDBResources(connection, statement, resultSet);
        }
    }

    @Override
    public Event storeEvent(Event event) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, event.getNameEn());
            statement.setString(2, event.getNameRu());
            statement.setInt(3, event.getDayOfMonth());
            statement.setInt(4, event.getMonthNumber());
            statement.setInt(5, event.getDayOfWeekNumber());
            statement.setInt(6, event.getYear());
            statement.setTime(7, new Time(event.getStartTime().getTime()));
            statement.setTime(8, new Time(event.getEndTime().getTime()));
            statement.setString(9, event.getLocationEn());
            statement.setString(10, event.getLocationRu());
            statement.setString(11, event.getAddressEn());
            statement.setString(12, event.getAddressRu());
            statement.setString(13, event.getDescriptionEn());
            statement.setString(14, event.getDescriptionRu());
            statement.setDouble(15, event.getPrice());
            statement.executeUpdate();

            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                event.setId(generatedKeys.getInt(1));
            }
            else {
                throw new DaoException("Creating event failed, no ID obtained.");
            }

            return event;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, statement);
        }
    }

    @Override
    public void updateEvent(Event event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, event.getDayOfMonth());
            preparedStatement.setInt(2, event.getMonthNumber());
            preparedStatement.setInt(3, event.getDayOfWeekNumber());
            preparedStatement.setInt(4, event.getYear());
            preparedStatement.setTime(5, new Time(event.getStartTime().getTime()));
            preparedStatement.setTime(6, new Time(event.getEndTime().getTime()));
            preparedStatement.setString(7, event.getLocationEn());
            preparedStatement.setString(8, event.getLocationRu());
            preparedStatement.setString(9, event.getAddressEn());
            preparedStatement.setString(10, event.getAddressRu());
            preparedStatement.setString(11, event.getNameEn());
            preparedStatement.setString(12, event.getNameRu());
            preparedStatement.setString(13, event.getDescriptionEn());
            preparedStatement.setString(14, event.getDescriptionRu());
            preparedStatement.setDouble(15, event.getPrice());
            preparedStatement.setInt(16, event.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void deleteEvent(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);;
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement);
        }
    }

}
