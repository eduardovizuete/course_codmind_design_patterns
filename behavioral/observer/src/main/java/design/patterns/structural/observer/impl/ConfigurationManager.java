package design.patterns.structural.observer.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class ConfigurationManager extends AbstractObservable {

    private static ConfigurationManager configurationManager;
    
    private SimpleDateFormat defaultDateFormat;
    
    private NumberFormat moneyFormat;
    
    private ConfigurationManager(){}
    
    public synchronized static ConfigurationManager getInstance(){
        if(configurationManager == null){
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }
    
    public SimpleDateFormat getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public void setDefaultDateFormat(SimpleDateFormat defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
        super.notityAllObserver("defaultDateFormat", this);
    }

    public NumberFormat getMoneyFormat() {
        return moneyFormat;
    }

    public void setMoneyFormat(NumberFormat moneyFormat) {
        this.moneyFormat = moneyFormat;
        super.notityAllObserver("moneyFormat", this);
    }
    
}
