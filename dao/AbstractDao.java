package A402.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Evgeny on 5/9/18.
 */
public class AbstractDao {
    public AbstractDao() {
    }

    protected void closeResultSet(ResultSet resultSet) throws DaoException {
        try {
            if(resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException var3) {
            throw new DaoException(var3);
        }
    }

    protected void closeStatement(Statement statement) throws DaoException {
        try {
            if(statement != null) {
                statement.close();
            }

        } catch (SQLException var3) {
            throw new DaoException(var3);
        }
    }

    protected void closeConnection(Connection connection) throws DaoException {
        try {
            if(connection != null) {
                connection.close();
            }

        } catch (SQLException var3) {
            throw new DaoException(var3);
        }
    }

    protected void closeDBResources(Connection connection, Statement statement, ResultSet resultSet) throws DaoException {
        this.closeResultSet(resultSet);
        this.closeStatement(statement);
        this.closeResultSet(resultSet);
    }

    protected void closeDBResources(Connection connection, Statement statement) {
        this.closeDBResources(connection, statement, (ResultSet)null);
    }
}
