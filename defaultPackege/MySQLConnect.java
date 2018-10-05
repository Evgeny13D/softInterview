package A402.defaultPackege;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnect {
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DATABASE_URL = "jdbc:mysql://node50680-env-6294273.mircloud.host:11140/platform";
    private static final String DATABASE_URL = "jdbc:mysql://node57365-env-7443538.mircloud.host/A402";
//    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/A402";
    private static final String USERNAME = "root";
//    private static final String PASSWORD = "rootroot";
    private static final String PASSWORD = "GGKqfa51594";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("URL", DATABASE_URL);
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useUnicode","true");
            properties.setProperty("characterEncoding","UTF-8");
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("problems with connection to DB");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
