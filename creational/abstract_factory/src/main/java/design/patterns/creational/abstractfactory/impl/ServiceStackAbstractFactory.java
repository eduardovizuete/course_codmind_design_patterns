package design.patterns.creational.abstractfactory.impl;

import static design.patterns.creational.abstractfactory.impl.ServiceType.RESTFul;
import static design.patterns.creational.abstractfactory.impl.ServiceType.SOAP;
import design.patterns.creational.abstractfactory.services.impl.rest.RestServiceStackImpl;
import design.patterns.creational.abstractfactory.services.impl.ws.WSServiceStackImpl;
import java.io.InputStream;
import java.util.Properties;

public class ServiceStackAbstractFactory {
    
    private static final String CONFIG_PATH = "META-INF/abstractfactory.properties";
    
    public static IServiceStackAbstractFactory createServiceFactory() {
        try {
            Properties props = loadProperties();
            String concreteFactory = props.getProperty("defaultFamily");
            
            IServiceStackAbstractFactory factoryImpl = (IServiceStackAbstractFactory)Class.forName(concreteFactory).newInstance();
            return factoryImpl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static IServiceStackAbstractFactory createServiceFactory(ServiceType type) {
        return switch (type) {
            case RESTFul -> new RestServiceStackImpl();
            case SOAP -> new WSServiceStackImpl();
            default -> null;
        };
    }
    
    private static Properties loadProperties(){
        try {
            Properties p = new Properties();
            InputStream stream = ServiceStackAbstractFactory.class.getClassLoader().getResourceAsStream(CONFIG_PATH);
            p.load(stream);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
