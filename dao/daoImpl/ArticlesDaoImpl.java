package A402.dao.daoImpl;

import A402.dao.AbstractDao;
import A402.dao.ArticlesDao;
import A402.dao.DaoException;
import A402.dao.ResultSetConverter;
import A402.dao.db.connectionpool.ConnectionPool;
import A402.dao.db.connectionpool.ConnectionPoolException;
import A402.model.Articles;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Kapliarchuk_Y on 24/07/2018.
 */
public class ArticlesDaoImpl extends AbstractDao implements ArticlesDao {
    private static final String SELECT_ALL = "SELECT *FROM A402.articles ";
    private static final String SELECT_ALL_SORT = "SELECT *FROM A402.articles ORDER BY views DESC LIMIT 7";
    private static final String SELECT_ALL_SHOW = "SELECT * FROM A402.articles WHERE category LIKE 'Show';";
    private static final String INSERT = "INSERT INTO A402.articles(ru_title, ru_description, ru_content, en_title, en_description, en_content, category, ru_linkAtach, en_linkAtach, link_ofImage, views, dateAdd) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ADD_VIEWS = "UPDATE A402.articles SET views = views + 1 WHERE id = ?";
    private static final String UPDATE_ARTICLES = "UPDATE A402.articles SET ru_title = ?, ru_description = ?, ru_content = ?, en_title = ?, en_description = ?, en_content = ?, category = ?, ru_linkAtach=?, en_linkAtach = ?, link_ofImage = ?, updateArticle = ? WHERE id = ?";
    private static final String UPDATE_MANAGE_ARTICLES = "UPDATE A402.articles SET ru_title = ?, category = ?, updateArticle = ? WHERE id = ?";
    private static final String DELETE_ARTICLES = "DELETE FROM A402.articles WHERE id = ? ";
    private static final String SELECT_BY_ID = "SELECT id, ru_title, ru_description, ru_content, en_title, en_description, en_content, category, ru_linkAtach, en_linkAtach, link_ofImage, dateAdd, views from A402.articles WHERE id = ?";
    @Override
    public List<Articles> listOfArticles() {
        List <Articles> articlesList = new LinkedList<Articles>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_SHOW);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Articles articles = new Articles();
                articles.setId(resultSet.getInt("id"));
                articles.setRu_title(resultSet.getString("ru_title"));
                articles.setRu_description(resultSet.getString("ru_description"));
                articles.setRu_content(resultSet.getString("ru_content"));
                articles.setEn_title(resultSet.getString("en_title"));
                articles.setEn_description(resultSet.getString("en_description"));
                articles.setEn_content(resultSet.getString("en_content"));
                articles.setDate(resultSet.getString("dateAdd"));
                articles.setRu_linkAtach(resultSet.getString("ru_linkAtach"));
                articles.setEn_linkAtach(resultSet.getString("en_linkAtach"));
                articles.setViews(resultSet.getInt("views"));
                if (!resultSet.getString("link_ofImage").equals("no_image")) {
                    articles.setLink_ofImage("/ImageGetter?link_ofImage=" + getFileName(resultSet.getString("link_ofImage")));
                    articles.setCategory(resultSet.getString("category"));
                }else {
                    articles.setCategory(resultSet.getString("category"));
                }



                articlesList.add(articles);
            }
            return articlesList;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Articles> listOfArticlesJust() {
        List <Articles> articlesList = new LinkedList<Articles>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Articles articles = new Articles();
                articles.setId(resultSet.getInt("id"));
                articles.setRu_title(resultSet.getString("ru_title"));
                articles.setRu_description(resultSet.getString("ru_description"));
                articles.setRu_content(resultSet.getString("ru_content"));
                articles.setEn_title(resultSet.getString("en_title"));
                articles.setEn_description(resultSet.getString("en_description"));
                articles.setEn_content(resultSet.getString("en_content"));
                articles.setDate(resultSet.getString("dateAdd"));
                articles.setRu_linkAtach(resultSet.getString("ru_linkAtach"));
                articles.setEn_linkAtach(resultSet.getString("en_linkAtach"));
                articles.setLink_ofImage(resultSet.getString("link_ofImage"));
                articles.setViews(resultSet.getInt("views"));
                articles.setCategory(resultSet.getString("category"));

                articlesList.add(articles);
            }
            return articlesList;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Articles> listManageArticles() {
        List <Articles> articlesList = new LinkedList<Articles>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Articles articles = new Articles();
                articles.setId(resultSet.getInt("id"));
                articles.setRu_title(resultSet.getString("ru_title"));
//                articles.setEn_title(resultSet.getString("en_title"));
                articles.setDate(resultSet.getString("dateAdd"));
                articles.setUpdateDate(resultSet.getString("updateArticle"));
                articles.setViews(resultSet.getInt("views"));
                articles.setCategory(resultSet.getString("category"));

                articlesList.add(articles);
            }
            return articlesList;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void addArticles(Articles articles) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            preparedStatement = mySQLConnect.connect().prepareStatement(INSERT);
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, articles.getRu_title());
            preparedStatement.setString(2, articles.getRu_description());
            preparedStatement.setString(3, articles.getRu_content());
            preparedStatement.setString(4, articles.getEn_title());
            preparedStatement.setString(5, articles.getEn_description());
            preparedStatement.setString(6, articles.getEn_content());
            preparedStatement.setString(7, articles.getCategory());
            preparedStatement.setString(8, articles.getRu_linkAtach());
            preparedStatement.setString(9, articles.getEn_linkAtach());
            preparedStatement.setString(10, articles.getLink_ofImage());
            preparedStatement.setInt(11, articles.getViews());
            preparedStatement.setString(12, String.valueOf(new Date()));
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
    public void editArticles(int id, Articles articles) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_ARTICLES);
            preparedStatement.setString(1, articles.getRu_title());
            preparedStatement.setString(2, articles.getRu_description());
            preparedStatement.setString(3, articles.getRu_content());
            preparedStatement.setString(4, articles.getEn_title());
            preparedStatement.setString(5, articles.getEn_description());
            preparedStatement.setString(6, articles.getEn_content());
            preparedStatement.setString(7, articles.getCategory());
            preparedStatement.setString(8, articles.getRu_linkAtach());
            preparedStatement.setString(9, articles.getEn_linkAtach());
            preparedStatement.setString(10, articles.getLink_ofImage());
            preparedStatement.setString(11, String.valueOf(new Date()));
            preparedStatement.setInt(12, id);
            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void editManageArticles(int id, Articles articles) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_MANAGE_ARTICLES);
            preparedStatement.setString(1, articles.getRu_title());
            preparedStatement.setString(2, articles.getCategory());
            preparedStatement.setString(3, String.valueOf(new Date()));
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public void removeArticles(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_ARTICLES);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public Articles getArticleById(int articleId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setTransactionIsolation(8);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, articleId);
            resultSet = preparedStatement.executeQuery();

            Articles article = null;

            if (resultSet.next()) {
                article = ResultSetConverter.convertToArticle(resultSet);
            }
            connection.setAutoCommit(true);
            return article;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        } finally {
            this.closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Articles> listPopularArticles() {
        List <Articles> articlesList = new LinkedList<Articles>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_SORT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Articles articles = new Articles();
                articles.setId(resultSet.getInt("id"));
                articles.setRu_title(resultSet.getString("ru_title"));
//                articles.setRu_description(resultSet.getString("ru_description"));
//                articles.setRu_content(resultSet.getString("ru_content"));
                articles.setEn_title(resultSet.getString("en_title"));
//                articles.setEn_description(resultSet.getString("en_description"));
//                articles.setEn_content(resultSet.getString("en_content"));
                articles.setDate(resultSet.getString("dateAdd"));
                if (!resultSet.getString("link_ofImage").equals("no_image")) {
                    articles.setLink_ofImage("/ImageGetter?link_ofImage=" + getFileName(resultSet.getString("link_ofImage")));
                    articles.setCategory(resultSet.getString("category"));
                }else {
                    articles.setCategory(resultSet.getString("category"));
                }

                articlesList.add(articles);
            }
            return articlesList;
        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeDBResources(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void addViews(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(ADD_VIEWS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException var9) {
            throw new DaoException(var9);
        }finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }


    private String getFileName(String filePath){
        File f = new File(filePath);
        return f.getName();
    }
}
