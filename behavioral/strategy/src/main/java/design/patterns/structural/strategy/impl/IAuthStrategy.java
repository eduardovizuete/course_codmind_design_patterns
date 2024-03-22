package design.patterns.structural.strategy.impl;

public interface IAuthStrategy {
    
    public Principal authenticate(String userName, String password);
    
}
