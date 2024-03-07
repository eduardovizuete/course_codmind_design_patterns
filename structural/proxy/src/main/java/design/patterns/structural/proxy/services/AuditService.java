package design.patterns.structural.proxy.services;

import design.patterns.structural.proxy.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditService {
    
    private static final Logger logger = Logger.getLogger(AuditService.class.getName());
    
    public void auditServiceUsed(String user, String service){
        SimpleDateFormat formater= new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        logger.log(Level.INFO, "{0} used the service > {1}, at {2}", 
                new Object[]{user, service, formater.format(new Date())});
    }
    
}
