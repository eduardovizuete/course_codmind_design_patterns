package design.patterns.structural.strategy.impl;

public interface IAuthenticationStrategy {
    
    public Principal authenticate(String userName, String password);
    
}
