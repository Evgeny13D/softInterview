package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.DaoException;
import A402.dao.EventDao_NV;
import A402.dao.ResultSetConverter;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Event_NV;
import A402.model.Participant;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kapliarchuk_Y on 08/08/2018.
 */
public class EventDaoImpl_NV extends AbstractDao implements EventDao_NV {
    private static final String SELECT_ALL_SHOW = "SELECT * FROM PAYHALL.events WHERE status LIKE 'show' ORDER BY year, month_number, day_of_month, day_of_week_number DESC;";

    private static final String SELECT_ALL =
            "select id, name_en, name_ru, day_of_month, month_number, day_of_week_number, \n" +
                    "\t\tyear, start_time, end_time, location_en, location_ru, \n" +
                    "\t\t\taddress_en, address_ru, description_en, description_ru, price, priceS16, priceS712, priceS13, priceS14, \n" +
                    "          r1s1, r1s2, r1s3, r1s4, r1s5, r1s6, r1s7, r2s1, r2s2, r2s3, r2s4, r2s5, r2s6, r2s7, status, type, imageLink\n" +
                    "    from PAYHALL.events";


    private static final String SELECT_BY_ID_ARRAY =
            "select * from PAYHALL.events where ";

    private static final String SELECT_BY_ID =
            "select id, name_en, name_ru, day_of_month, month_number, day_of_week_number, year, start_time, end_time, " +
                    "location_en, location_ru, address_en, address_ru, description_en, description_ru, price, priceS16, " +
                    "priceS712, priceS13, priceS14, r1s1, r1s2, r1s3, r1s4, r1s5, r1s6, r1s7, r2s1, r2s2, r2s3, r2s4, " +
                    "r2s5, r2s6, r2s7, status, type, imageLink from PAYHALL.events where id = ?";

    private static final String INSERT =
            "insert into PAYHALL.events (name_en, name_ru, day_of_month, month_number, day_of_week_number, " +
                    "\t\tyear, start_time, end_time, location_en, location_ru, \n" +
                    "\t\t\taddress_en, address_ru, description_en, description_ru, price, status, type, priceS16, priceS712, priceS13, priceS14, imageLink)\n" +
                    "\tvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_PRIVATE =
            "insert into PAYHALL.events (name_en, name_ru, day_of_month, month_number, day_of_week_number, " +
                    "\t\tyear, location_en, location_ru, \n" +
                    "\t\t\taddress_en, address_ru, description_en, description_ru, price, status, type, imageLink)\n" +
                    "\tvalues (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    private static final String UPDATE = "update PAYHALL.events set type = ?, status = ?, day_of_month = ?, " +
            "month_number = ?, day_of_week_number = ?, year = ?, start_time = ?, end_time = ?, location_en = ?, " +
            "location_ru = ?, address_en = ?, address_ru = ?, name_en = ?, name_ru = ?, description_en = ?, " +
            "description_ru = ?, priceS16 = ?, priceS712 = ?, priceS13 = ?, priceS14 = ?, price = ?, r1s1 = ?, " +
            "r1s2 = ?, r1s3 = ?, r1s4 = ?, r1s5 = ?, r1s6 = ?, r1s7 = ?, r2s1 = ?, r2s2 = ?, r2s3 = ?, r2s4 = ?, " +
            "r2s5 = ?, r2s6 = ?, r2s7 = ?, imageLink = ? where id = ?";

    private static final String UPDATE_PRIVATE = "update PAYHALL.events set type = ?, status = ?, day_of_month = ?, " +
            "month_number = ?, day_of_week_number = ?, year = ?, location_en = ?, " +
            "location_ru = ?, address_en = ?, address_ru = ?, name_en = ?, name_ru = ?, description_en = ?, " +
            "description_ru = ?, price = ?, imageLink = ? where id = ?";

    private static final String UPDATE_MANAGE_ARTICLES = "UPDATE PAYHALL.events SET name_ru = ?, status = ? WHERE id = ?";

    private static final String DELETE_BY_ID = "delete from PAYHALL.events where id = ?";

    @Override
    public List<Event_NV> listOfEvents() {
        List<Event_NV> events = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_SHOW);

            while (resultSet.next()) {
                Event_NV event = ResultSetConverter.convertToEvent_NV(resultSet);
//                event.setLinkOfImage("/ImageGetterForEvents?link_ofImage=" + getFileName(resultSet.getString("imageLink")));
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
    public List<Event_NV> listOfEventsJust() {
        List<Event_NV> events = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {
                Event_NV event = ResultSetConverter.convertToEvent_NV(resultSet);
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
    public Event_NV getEventById(int eventId) {
        Event_NV event = null;
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
                event = ResultSetConverter.convertToEvent_NV(resultSet);
                event.setLinkOfImage("/ImageGetter?link_ofImage=" + getFileName(resultSet.getString("imageLink")));
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
    public Event_NV getEventByIdJustForRemove(int eventId) {
        Event_NV event = null;
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
                event = ResultSetConverter.convertToEvent_NV(resultSet);
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
    public Event_NV storeEvent(Event_NV event) {
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
            statement.setString(16, event.getStatus());
            statement.setString(17, event.getType());
            statement.setDouble(18, event.getPriceS16());
            statement.setDouble(19, event.getPriceS712());
            statement.setDouble(20, event.getPriceS13());
            statement.setDouble(21, event.getPriceS14());
            statement.setString(22, event.getLinkOfImage());

            statement.executeUpdate();

            return event;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeDBResources(connection, statement);
        }
    }

    @Override
    public Map<Integer, Event_NV> getEventByIds(Integer[] ids) {
        Event_NV event = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);


            StringBuilder sql_builder = new StringBuilder(SELECT_BY_ID_ARRAY);
            for(int i = 0; i < ids.length; i++){
                if(i == 0){
                    sql_builder.append("id = ? ");
                }else{
                    sql_builder.append("or id = ? ");
                }
            }
            statement = connection.prepareStatement(sql_builder.toString());

            for(int i = 0; i < ids.length; i++){
                statement.setInt(i+1, ids[i]);
            }

            resultSet = statement.executeQuery();

            HashMap<Integer, Event_NV> events = new HashMap<>();
            while (resultSet.next()) {
                event = ResultSetConverter.convertToEvent_NV(resultSet);
                event.setLinkOfImage("/ImageGetter?link_ofImage=" + getFileName(resultSet.getString("imageLink")));
                events.put(event.getId(), event);
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
    public void addPrivateEvent(Event_NV event) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_PRIVATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, event.getNameEn());
            statement.setString(2, event.getNameRu());
            statement.setInt(3, event.getDayOfMonth());
            statement.setInt(4, event.getMonthNumber());
            statement.setInt(5, event.getDayOfWeekNumber());
            statement.setInt(6, event.getYear());
            statement.setString(7, event.getLocationEn());
            statement.setString(8, event.getLocationRu());
            statement.setString(9, event.getAddressEn());
            statement.setString(10, event.getAddressRu());
            statement.setString(11, event.getDescriptionEn());
            statement.setString(12, event.getDescriptionRu());
            statement.setDouble(13, 13.11);
            statement.setString(14, event.getStatus());
            statement.setString(15, event.getType());
            statement.setString(16, event.getLinkOfImage());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeDBResources(connection, statement);
        }
    }

    @Override
    public void updateEvent(Event_NV event) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, event.getType());
            statement.setString(2, event.getStatus());
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
            statement.setString(13, event.getNameEn());
            statement.setString(14, event.getNameRu());
            statement.setString(15, event.getDescriptionEn());
            statement.setString(16, event.getDescriptionRu());
            statement.setDouble(17, event.getPriceS16());
            statement.setDouble(18, event.getPriceS712());
            statement.setDouble(19, event.getPriceS13());
            statement.setDouble(20, event.getPriceS14());
            statement.setDouble(21, event.getPrice());
            statement.setInt(22, event.getR1s1());
            statement.setInt(23, event.getR1s2());
            statement.setInt(24, event.getR1s3());
            statement.setInt(25, event.getR1s4());
            statement.setInt(26, event.getR1s5());
            statement.setInt(27, event.getR1s6());
            statement.setInt(28, event.getR1s7());
            statement.setInt(29, event.getR2s1());
            statement.setInt(30, event.getR2s2());
            statement.setInt(31, event.getR2s3());
            statement.setInt(32, event.getR2s4());
            statement.setInt(33, event.getR2s5());
            statement.setInt(34, event.getR2s6());
            statement.setInt(35, event.getR2s7());
            // remove url data from link
            if(event.getLinkOfImage() != null && event.getLinkOfImage().startsWith("/ImageGetter?link_ofImage=") ){
                event.setLinkOfImage(event.getLinkOfImage().substring("/ImageGetter?link_ofImage=".length()));
            }
            statement.setString(36, event.getLinkOfImage());
            statement.setInt(37,event.getId());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    @Override
    public void updatePrivateEvent(Event_NV event) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_PRIVATE);
            statement.setString(1, event.getType());
            statement.setString(2, event.getStatus());
            statement.setInt(3, event.getDayOfMonth());
            statement.setInt(4, event.getMonthNumber());
            statement.setInt(5, event.getDayOfWeekNumber());
            statement.setInt(6, event.getYear());
            statement.setString(7, event.getLocationEn());
            statement.setString(8, event.getLocationRu());
            statement.setString(9, event.getAddressEn());
            statement.setString(10, event.getAddressRu());
            statement.setString(11, event.getNameEn());
            statement.setString(12, event.getNameRu());
            statement.setString(13, event.getDescriptionEn());
            statement.setString(14, event.getDescriptionRu());
            statement.setDouble(15, 13.11);
            statement.setString(16, event.getLinkOfImage());
            statement.setInt(17,event.getId());

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeStatement(statement);
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

    @Override
    public void editManageEvent(int id, Event_NV event_nv) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_MANAGE_ARTICLES);
            preparedStatement.setString(1, event_nv.getNameRu());
            preparedStatement.setString(2, event_nv.getStatus());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }
    private String getFileName(String filePath){
        if (filePath == null) return null;
        File f = new File(filePath);
        return f.getName();
    }
}
