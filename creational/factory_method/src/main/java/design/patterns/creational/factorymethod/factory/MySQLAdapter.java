package design.patterns.creational.factorymethod.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLAdapter implements IDBAdapter {
    
    static{
        try {
            new com.mysql.cj.jdbc.Driver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = getConnectionString();
            String user = "root";
            String password = "rootroot";
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    private String getConnectionString(){
        return "jdbc:mysql://localhost:3306/design_patterns?useSSL=false";
    }
    
}
