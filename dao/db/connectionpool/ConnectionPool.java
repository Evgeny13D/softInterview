package A402.dao.db.connectionpool;

/**
 * Created by Evgeny on 5/9/18.
 */

import A402.dao.db.config.DBConfig;
import A402.dao.db.config.ReadDBConfigException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectionPool {
    private static ConnectionPool INSTANCE;
    private List<Connection> connections = new ArrayList();
    private String url;
    private String username;
    private String password;

    private Properties properties;
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("URL", url);
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("useUnicode","true");
            properties.setProperty("characterEncoding","UTF-8");
        }
        return properties;
    }

    public static ConnectionPool getInstance() throws ConnectionPoolException {
        if(INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }

        return INSTANCE;
    }

    private ConnectionPool() throws ConnectionPoolException {
        String driverClassName = null;

        try {
            DBConfig e = DBConfig.getInstance();
            this.url = e.getUrl();
            this.username = e.getUsername();
            this.password = e.getPassword();
            driverClassName = e.getDriverClassName();
        } catch (ReadDBConfigException var4) {
            throw new ConnectionPoolException("Errors during reading configuration", var4);
        }

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException var3) {
            throw new ConnectionPoolException("No such driver class", var3);
        }
    }

    public synchronized Connection getConnection() throws ConnectionPoolException {
        Connection connection = null;
        if(this.connections.isEmpty()) {
            connection = this.createConnection();
        } else {
            connection = (Connection)this.connections.remove(this.connections.size() - 1);
        }

        return connection;
    }

    public synchronized int availableConnections() {
        return this.connections.size();
    }

    private Connection createConnection() throws ConnectionPoolException {
        try {
            Connection e = DriverManager.getConnection(url, getProperties());
            return new ReusableConnection(e);
        } catch (SQLException var2) {
            throw new ConnectionPoolException("Errors during creation of a new connection", var2);
        }
    }

    class ReusableConnection implements Connection {
        Connection connection;

        ReusableConnection(Connection connection) {
            this.connection = connection;
        }

        public synchronized void close() throws SQLException {
            if(!this.connection.isClosed()) {
                ConnectionPool.this.connections.add(this.connection);
            }

        }

        void realClose() throws SQLException {
            this.connection.close();
        }

        public void abort(Executor executor) throws SQLException {
            this.connection.abort(executor);
        }

        public void clearWarnings() throws SQLException {
            this.connection.clearWarnings();
        }

        public void commit() throws SQLException {
            this.connection.commit();
        }

        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return this.connection.createArrayOf(typeName, elements);
        }

        public Blob createBlob() throws SQLException {
            return this.connection.createBlob();
        }

        public Clob createClob() throws SQLException {
            return this.connection.createClob();
        }

        public NClob createNClob() throws SQLException {
            return this.connection.createNClob();
        }

        public SQLXML createSQLXML() throws SQLException {
            return this.connection.createSQLXML();
        }

        public Statement createStatement() throws SQLException {
            return this.connection.createStatement();
        }

        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return this.connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return this.connection.createStatement(resultSetType, resultSetConcurrency);
        }

        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return this.connection.createStruct(typeName, attributes);
        }

        public boolean getAutoCommit() throws SQLException {
            return this.connection.getAutoCommit();
        }

        public String getCatalog() throws SQLException {
            return this.connection.getCatalog();
        }

        public Properties getClientInfo() throws SQLException {
            return this.connection.getClientInfo();
        }

        public String getClientInfo(String name) throws SQLException {
            return this.connection.getClientInfo(name);
        }

        public int getHoldability() throws SQLException {
            return this.connection.getHoldability();
        }

        public DatabaseMetaData getMetaData() throws SQLException {
            return this.connection.getMetaData();
        }

        public int getNetworkTimeout() throws SQLException {
            return this.connection.getNetworkTimeout();
        }

        public String getSchema() throws SQLException {
            return this.connection.getSchema();
        }

        public int getTransactionIsolation() throws SQLException {
            return this.connection.getTransactionIsolation();
        }

        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return this.connection.getTypeMap();
        }

        public SQLWarning getWarnings() throws SQLException {
            return this.connection.getWarnings();
        }

        public boolean isClosed() throws SQLException {
            return this.connection.isClosed();
        }

        public boolean isReadOnly() throws SQLException {
            return this.connection.isReadOnly();
        }

        public boolean isValid(int timeout) throws SQLException {
            return this.connection.isValid(timeout);
        }

        public boolean isWrapperFor(Class<?> arg0) throws SQLException {
            return this.connection.isWrapperFor(arg0);
        }

        public String nativeSQL(String sql) throws SQLException {
            return this.connection.nativeSQL(sql);
        }

        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return this.connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return this.connection.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        public CallableStatement prepareCall(String sql) throws SQLException {
            return this.connection.prepareCall(sql);
        }

        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
        }

        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return this.connection.prepareStatement(sql, autoGeneratedKeys);
        }

        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return this.connection.prepareStatement(sql, columnIndexes);
        }

        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return this.connection.prepareStatement(sql, columnNames);
        }

        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return this.connection.prepareStatement(sql);
        }

        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            this.connection.releaseSavepoint(savepoint);
        }

        public void rollback() throws SQLException {
            this.connection.rollback();
        }

        public void rollback(Savepoint savepoint) throws SQLException {
            this.connection.rollback(savepoint);
        }

        public void setAutoCommit(boolean autoCommit) throws SQLException {
            this.connection.setAutoCommit(autoCommit);
        }

        public void setCatalog(String catalog) throws SQLException {
            this.connection.setCatalog(catalog);
        }

        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            this.connection.setClientInfo(properties);
        }

        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            this.connection.setClientInfo(name, value);
        }

        public void setHoldability(int holdability) throws SQLException {
            this.connection.setHoldability(holdability);
        }

        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            this.connection.setNetworkTimeout(executor, milliseconds);
        }

        public void setReadOnly(boolean readOnly) throws SQLException {
            this.connection.setReadOnly(readOnly);
        }

        public Savepoint setSavepoint() throws SQLException {
            return this.connection.setSavepoint();
        }

        public Savepoint setSavepoint(String name) throws SQLException {
            return this.connection.setSavepoint(name);
        }

        public void setSchema(String schema) throws SQLException {
            this.connection.setSchema(schema);
        }

        public void setTransactionIsolation(int level) throws SQLException {
            this.connection.setTransactionIsolation(level);
        }

        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            this.connection.setTypeMap(map);
        }

        public <T> T unwrap(Class<T> arg0) throws SQLException {
            return this.connection.unwrap(arg0);
        }
    }
}
