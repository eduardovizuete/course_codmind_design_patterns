package design.patterns.structural.proxy.services;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityService {
    
    private static final Logger logger = Logger.getLogger(SecurityService.class.getName());
    
    public boolean authorization(String user,String password){
        if(user.equals("usuario") && password.equals("1234")){
            logger.log(Level.INFO, "User {0} authorized", user);
            return true;
        }else{
            logger.log(Level.INFO, "User {0} no authorized", user);
            return false;
        }
    }
    
}
