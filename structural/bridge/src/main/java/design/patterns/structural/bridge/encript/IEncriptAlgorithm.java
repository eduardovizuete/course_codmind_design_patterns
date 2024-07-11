package design.patterns.structural.bridge.encript;

public interface IEncriptAlgorithm {
    
    public String encript(String message, String password) throws Exception;
    
}
