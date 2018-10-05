package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.DaoAdmin;
import A402.dao.DaoException;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Event;
import A402.model.News;
import A402.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoAdminImpl extends AbstractDao implements DaoAdmin {
    private static final String INSERT = "INSERT INTO A402.News(ru_title, ru_description, ru_info, en_title, en_description, en_info, status, dateAdd) values(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT *FROM A402.News";
    private static final String SELECT_ALL_SHOW = "SELECT * FROM A402.News WHERE status LIKE 'show';";
    private static final String UPDATE_NEWS = "UPDATE A402.News SET ru_title = ?, ru_description = ?, ru_info = ?, en_title = ?, en_description = ?, en_info = ?, status = ?, update_date = ? WHERE id = ?";
    private static final String DELETE_NEWS = "DELETE FROM A402.News WHERE id = ? ";

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<Event> listOfEvents() {
        return null;
    }

    @Override
    public boolean addNewEvent(Event event) {
        return false;
    }

    @Override
    public boolean editEvent(Event event) {
        return false;
    }

    @Override
    public boolean removeEvent(Event event) {
        return false;
    }

//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
//    S E C T I O N    O F   N E W S                          *
//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    @Override
    public List<News> listOfNews() {
        List <News> listNews = new LinkedList<News>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setRu_title(resultSet.getString("ru_title"));
                news.setRu_description(resultSet.getString("ru_description"));
                news.setRu_info(resultSet.getString("ru_info"));
                news.setEn_title(resultSet.getString("en_title"));
                news.setEn_description(resultSet.getString("en_description"));
                news.setEn_info(resultSet.getString("en_info"));
                news.setAdded(resultSet.getString("dateAdd"));
                news.setUpdate(resultSet.getString("update_date"));
                news.setStatus(resultSet.getString("status"));

                listNews.add(news);
            }
            return listNews;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<News> listOfNewsShow() {
        List <News> listNews = new LinkedList<News>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_SHOW);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                News news = new News();
                news.setRu_title(resultSet.getString("ru_title"));
                news.setRu_description(resultSet.getString("ru_description"));
                news.setRu_info(resultSet.getString("ru_info"));
                news.setEn_title(resultSet.getString("en_title"));
                news.setEn_description(resultSet.getString("en_description"));
                news.setEn_info(resultSet.getString("en_info"));
                listNews.add(news);
            }
            return listNews;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void addNewNews(News news) {
//        MySQLConnect mySQLConnect = new MySQLConnect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            preparedStatement = mySQLConnect.connect().prepareStatement(INSERT);
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, news.getRu_title());
            preparedStatement.setString(2, news.getRu_description());
            preparedStatement.setString(3, news.getRu_info());
            preparedStatement.setString(4, news.getEn_title());
            preparedStatement.setString(5, news.getEn_description());
            preparedStatement.setString(6, news.getEn_info());
            preparedStatement.setString(7, news.getStatus());
            preparedStatement.setString(8, news.getAdded());
            preparedStatement.executeUpdate();

//            mySQLConnect.disconnect();
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void editNews(News news, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_NEWS);
            preparedStatement.setString(1, news.getRu_title());
            preparedStatement.setString(2, news.getRu_description());
            preparedStatement.setString(3, news.getRu_info());
            preparedStatement.setString(4, news.getEn_title());
            preparedStatement.setString(5, news.getEn_description());
            preparedStatement.setString(6, news.getEn_info());
            preparedStatement.setString(7, news.getStatus());
            preparedStatement.setString(8, news.getUpdate());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void removeNews(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_NEWS);;
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
