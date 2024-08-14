package design.patterns.structural.strategy.impl.providers;

import design.patterns.structural.strategy.impl.IAuthenticationStrategy;
import design.patterns.structural.strategy.impl.Principal;
import design.patterns.structural.strategy.util.MySQLDBAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLAuthenticationProvider implements IAuthenticationStrategy {

    private static final Logger logger = Logger.getLogger(SQLAuthenticationProvider.class.getName());

    private static final String USER_QUERY = "SELECT userName, rol from users where userName='%s' and password = '%s'";
    
    private MySQLDBAdapter mysqlAdapter;
    
    public SQLAuthenticationProvider(){
        mysqlAdapter = new MySQLDBAdapter();
    }
    
    @Override
    public Principal authenticate(String user, String password) {
        try {
            Connection connection = mysqlAdapter.getConnection();
            Statement statement = connection.createStatement();
            String queryUser = String.format(USER_QUERY, user, password);
            ResultSet query = statement.executeQuery(queryUser);
            while(query.next()){
                return new Principal(query.getString("userName"),
                        query.getString("rol"));
            }
            
            return null;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }       
    }
    
}
