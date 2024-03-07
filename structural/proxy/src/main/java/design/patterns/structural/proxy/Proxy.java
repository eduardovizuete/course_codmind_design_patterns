package design.patterns.structural.proxy;

import design.patterns.structural.proxy.factory.ServiceFactory;
import design.patterns.structural.proxy.impl.IProcessExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proxy {
    
    private static final Logger logger = Logger.getLogger(Proxy.class.getName());

    public static void main(String[] args) {
        IProcessExecutor process = ServiceFactory.createProcessExecutor();
        try {
            process.executeProcess(1, "usuario", "1234");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
}
