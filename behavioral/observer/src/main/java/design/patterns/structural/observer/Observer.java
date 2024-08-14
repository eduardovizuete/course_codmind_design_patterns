package design.patterns.structural.observer;

import design.patterns.structural.observer.impl.observers.MoneyFormatObserver;
import design.patterns.structural.observer.impl.observers.DateFormatObserver;
import design.patterns.structural.observer.impl.ConfigurationManager;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Observer {
    
    private static final Logger logger = Logger.getLogger(DateFormatObserver.class.getName());

    public static void main(String[] args) {
        ConfigurationManager conf = ConfigurationManager.getInstance();
        
        //Se establecen los valores por default.
        conf.setDefaultDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        conf.setMoneyFormat(new DecimalFormat("##.00"));
        logger.log(Level.INFO, "Established configuration");
        
        //Se dan de alta lo observers
        DateFormatObserver dateFormatObserver = new DateFormatObserver();
        MoneyFormatObserver moneyFormatObserver = new MoneyFormatObserver();
        conf.addObserver(dateFormatObserver);
        conf.addObserver(moneyFormatObserver);
        logger.log(Level.INFO, "");
        
        //Se cambia la fonfiguratión
        conf.setDefaultDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,#00.00"));
        logger.log(Level.INFO, "");
        
        //Se realiza otro cambio en la configuración.
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy/dd"));
        conf.setMoneyFormat(new DecimalFormat("###,#00"));
        
        conf.removeObserver(dateFormatObserver);
        conf.removeObserver(moneyFormatObserver);
        logger.log(Level.INFO, "");
        
        //Se realiza otro cambio en la configuración.
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,##0.00"));
    }
    
}
