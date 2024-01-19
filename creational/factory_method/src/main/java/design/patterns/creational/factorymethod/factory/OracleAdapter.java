package design.patterns.creational.factorymethod.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

public class OracleAdapter implements IDBAdapter {

    static {
        try {
            new OracleDriver();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Connection getConnection() {
        try {
            String urlConnection = getConnectionUrl();
            String user = "system";
            String password = "oracle";
            Connection connection = DriverManager.getConnection(urlConnection, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(OracleAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String getConnectionUrl() {
        return "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
    }
    
}
