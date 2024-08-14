package design.patterns.structural.strategy.impl.providers;

import design.patterns.structural.strategy.impl.Principal;
import design.patterns.structural.strategy.impl.IAuthenticationStrategy;
import design.patterns.structural.strategy.util.XMLUserUtil;

public class XMLAuthenticationProvider implements IAuthenticationStrategy {


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
