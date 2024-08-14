package design.patterns.structural.observer.impl.observers;

import design.patterns.structural.observer.impl.ConfigurationManager;
import design.patterns.structural.observer.impl.IObserver;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateFormatObserver implements IObserver {
    
    private static final Logger logger = Logger.getLogger(DateFormatObserver.class.getName());

    @Override
    public void notifyObserver(String command, Object source) {
        if(command.equals("defaultDateFormat")){
            ConfigurationManager conf = (ConfigurationManager)source;
            logger.log(Level.INFO, "Observer ==> DateFormatObserver.dateFormatChange > {0}", 
                    conf.getDefaultDateFormat().format(new Date()));
        }
    }
    
}
