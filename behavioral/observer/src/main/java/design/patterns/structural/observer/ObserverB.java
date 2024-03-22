package design.patterns.structural.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ObserverB implements IObserver {
    
    private static final Logger logger = Logger.getLogger(ObserverB.class.getName());

    @Override
    public void notify(String command, Object source) {
        if(command.equals("moneyFormat")){           
            logger.log(Level.INFO, "Observer B > Money change");
        }
    }
    
}
