package design.patterns.structural.observer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Observer {
    
    private static final Logger logger = Logger.getLogger(ObserverA.class.getName());

    public static void main(String[] args) {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat moneyFormat = new DecimalFormat("###,##0.00");
        
        ObserverA a = new ObserverA();
        ObserverB b = new ObserverB();
        
        manager.addObserver(a);
        manager.addObserver(b);
        
        manager.setDateFormat(dateFormat);
        manager.setMoneyFormat(moneyFormat);
                
        logger.log(Level.INFO, "Fin");
    }
    
}
