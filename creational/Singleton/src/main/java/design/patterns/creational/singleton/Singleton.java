package design.patterns.creational.singleton;

public class Singleton {

    public static void main(String[] args) {
        Configuration config1 = Configuration.getInstance();
        Configuration config2 = Configuration.getInstance();
        
        System.out.println("Test => " + (config1 == config2));
        
        System.out.println("config1.appName => " + config1.getAppName());
        System.out.println("config2.appName => " + config2.getAppName());
        
        config1.setAppName("New App name");
        
        System.out.println("config1.appName => " + config1.getAppName());
        System.out.println("config2.appName => " + config2.getAppName());
        
        config1 = null;
        config2 = null;
        
        config1 = Configuration.getInstance();
        config2 = Configuration.getInstance();
        
        System.out.println("config1.appName => " + config1.getAppName());
        System.out.println("config2.appName => " + config2.getAppName());
    }
}
