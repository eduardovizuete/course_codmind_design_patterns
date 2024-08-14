package design.patterns.structural.strategy.impl.providers;

import design.patterns.structural.strategy.impl.IAuthenticationStrategy;
import design.patterns.structural.strategy.impl.Principal;
import design.patterns.structural.strategy.util.OnMemoryDataBase;
import design.patterns.structural.strategy.util.User;

public class OnMemoryAuthenticationProvider implements IAuthenticationStrategy {

    @Override
    public Principal authenticate(String userName, String password) {
        User user = OnMemoryDataBase.findUserByName(userName);
        if(user!=null && user.getPassword().equals(password)){
            return new Principal(user.getUserName(), user.getRol());
        }
        
        return null;
    }
    
}
