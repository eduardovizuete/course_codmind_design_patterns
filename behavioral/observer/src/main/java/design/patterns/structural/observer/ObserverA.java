package design.patterns.structural.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ObserverA implements IObserver {
    
    private static final Logger logger = Logger.getLogger(ObserverA.class.getName());

    @Override
    public void notify(String command, Object source) {
        if(command.equals("dateFormat")){
            logger.log(Level.INFO, "Observer A > Date change");
        }
    }
    
}
