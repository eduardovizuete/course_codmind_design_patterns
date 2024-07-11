package design.patterns.structural.bridge.encript;

public class NoEncriptAlgorithm implements IEncriptAlgorithm {

    @Override
    public String encript(String message, String password) throws Exception {
        return message;
    }
    
}
