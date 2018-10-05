package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.DaoException;
import A402.dao.SubscribeDao;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Subscribe;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kapliarchuk_Y on 06/08/2018.
 */
public class SubscribeDaoIml extends AbstractDao implements SubscribeDao {

    private static final String INSERT = "INSERT INTO A402.subscribers(email, date_add) values(?, ?)";

    private static final String SELECT_ALL = "SELECT * FROM A402.subscribers";

    @Override
    public void addSubscribe(Subscribe subscribe) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Cursor cursor;
        try {
//            preparedStatement = mySQLConnect.connect().prepareStatement(INSERT);
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, subscribe.getEmail());
            preparedStatement.setString(2, String.valueOf(new Date()));
            preparedStatement.executeUpdate();

//            mySQLConnect.disconnect();
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void removeSubscribe(int id) {

    }

    @Override
    public List<Subscribe> listOfSubscribes() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subscribe> subscribes = new ArrayList<>();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subscribes.add(mapRowToSubscriber(resultSet));
            }
        } catch (SQLException | ConnectionPoolException var10) {
            throw new DaoException(var10);
        } finally {
            this.closeDBResources(connection, preparedStatement, resultSet);
        }

        return subscribes;
    }

    public Subscribe getSubscriberByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Subscribe subscribe = new Subscribe();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM A402.subscribers WHERE email = ?; ");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subscribe.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException | ConnectionPoolException var10) {
            throw new DaoException(var10);
        } finally {
            this.closeDBResources(connection, preparedStatement, resultSet);
        }

        return subscribe;
    }

    public Subscribe mapRowToSubscriber(ResultSet rs) throws SQLException {
        Subscribe s = new Subscribe();
        s.setId(rs.getInt("id"));
        s.setDateAdd(rs.getString("date_add"));
        s.setEmail(rs.getString("email"));
        return s;
    }
}
