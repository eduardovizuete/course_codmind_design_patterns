package design.patterns.structural.observer.impl.observers;

import design.patterns.structural.observer.impl.ConfigurationManager;
import design.patterns.structural.observer.impl.IObserver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyFormatObserver implements IObserver {
    
    private static final Logger logger = Logger.getLogger(MoneyFormatObserver.class.getName());

    @Override
    public void notifyObserver(String command, Object source) {
        if(command.equals("moneyFormat")){        
            ConfigurationManager conf = (ConfigurationManager)source;
            logger.log(Level.INFO, "Observer ==> MoneyFormatObserver.moneyFormatChange > {0}", 
                    conf.getMoneyFormat().format(1.11));
        }
    }
    
}
