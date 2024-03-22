package design.patterns.structural.strategy.util;

import design.patterns.structural.strategy.impl.IAuthStrategy;
import design.patterns.structural.strategy.impl.Principal;

public class XMLAuthStrategy implements IAuthStrategy {


    @Override
    public Principal authenticate(String userName, String password) {
        String rol = XMLUserUtil.getRolByPrincipal(userName, password);
        
        if(rol.trim().isEmpty()){
            return null;
        }else{
            return new Principal(userName, rol);
        }
    }
    
}
