package A402.dao.db.config;

/**
 * Created by Evgeny on 5/9/18.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {
    private static final String URL_PROPERTY_NAME = "url";
    private static final String USERNAME_PROPERTY_NAME = "user";
    private static final String PASSWORD_PROPERTY_NAME = "password";
    private static final String DRIVER_CLASS_NAME_PROPERTY_NAME = "driverClassName";
    
    private static DBConfig INSTANCE;
    private static String dbConfigFilePath;

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public static DBConfig getInstance() throws ReadDBConfigException {
        if(INSTANCE == null) {
            INSTANCE = new DBConfig();
        }

        return INSTANCE;
    }

    private DBConfig() throws ReadDBConfigException {
        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(dbConfigFilePath);
            properties.load(inputStream);
            this.url = properties.getProperty(URL_PROPERTY_NAME);
            this.username = properties.getProperty(USERNAME_PROPERTY_NAME);
            this.password = properties.getProperty(PASSWORD_PROPERTY_NAME);
            this.driverClassName = properties.getProperty(DRIVER_CLASS_NAME_PROPERTY_NAME);
        } catch (IOException var4) {
            throw new ReadDBConfigException(var4);
        }
    }
    
    public static void defineDBConfigFilePath(String dbConfigFilePath) {
    	DBConfig.dbConfigFilePath = dbConfigFilePath;
    }
    
    public String getDbConfigFilePath() {
    	return dbConfigFilePath;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDriverClassName() {
        return this.driverClassName;
    }
}
