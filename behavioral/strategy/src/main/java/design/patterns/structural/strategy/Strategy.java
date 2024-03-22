package design.patterns.structural.strategy;

import design.patterns.structural.strategy.impl.OnMemoryAuthStrategy;
import design.patterns.structural.strategy.impl.Principal;
import design.patterns.structural.strategy.impl.SQLAuthStrategy;
import design.patterns.structural.strategy.util.AuthProvider;
import design.patterns.structural.strategy.util.XMLAuthStrategy;
import design.patterns.structural.strategy.util.XMLUserUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Strategy {
    
    private static final Logger logger = Logger.getLogger(Strategy.class.getName());

    public static void main(String[] args) {
        AuthProvider provider = new AuthProvider(new XMLAuthStrategy());
        
        String userName = "oblancarte";
        String password = "1234";
        
        Principal principal = provider.authenticate(userName, password);
        logger.log(Level.INFO, principal.toString());
        
        provider.setAuthStrategy(new OnMemoryAuthStrategy());
        principal = provider.authenticate(userName, password);
        logger.log(Level.INFO, principal.toString());
        
        provider.setAuthStrategy(new SQLAuthStrategy());
        principal = provider.authenticate(userName, password);
        logger.log(Level.INFO, principal.toString());
    }
    
}
