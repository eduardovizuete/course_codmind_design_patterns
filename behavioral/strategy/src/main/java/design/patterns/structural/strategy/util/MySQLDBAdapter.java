package design.patterns.structural.strategy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDBAdapter {
    
    private static final Logger logger = Logger.getLogger(MySQLDBAdapter.class.getName());

    private static final String DB_PROPERTIES = "META-INF/DBMySQL.properties";

    //Propiedades de los archivos properties
    private static final String DB_NAME_PROP = "dbname";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    static {
        //Bloque para registrar el Driver de MySQL
        try {
            new com.mysql.cj.jdbc.Driver();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            logger.log(Level.INFO, "Connection class ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password + "&serverTimezone=UTC";
        logger.log(Level.INFO, "ConnectionString ==> " + connectionString);
        return connectionString;
    }
    
}
