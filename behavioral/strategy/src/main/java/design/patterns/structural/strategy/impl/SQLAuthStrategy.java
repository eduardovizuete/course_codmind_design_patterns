package design.patterns.structural.strategy.impl;

import design.patterns.structural.strategy.util.MySQLDBAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLAuthStrategy implements IAuthStrategy {

    private static final Logger logger = Logger.getLogger(SQLAuthStrategy.class.getName());

    @Override
    public Principal authenticate(String userName, String password) {
        try {
            MySQLDBAdapter adapter = new MySQLDBAdapter();
            Connection connection = adapter.getConnection();

            String queryString = "SELECT userName,rol from users where userName='%s' and password = '%s'";
            String query = String.format(queryString, userName, password);

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            if(results.next()){
                return new Principal(results.getString("userName"), results.getString("rol"));
                
            }else{
                return null;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
}
