package design.patterns.creational.factorymethod.factory;

import design.patterns.creational.factorymethod.enums.DBType;
import java.io.InputStream;
import java.util.Properties;

public class DBAdapterFactory {

    private static final String DB_TYPE = "dbadaptertype";
    
    public static IDBAdapter getAdapter(DBType type){
        switch (type){
            case ORACLE:
                return new OracleAdapter();
            case MYSQL:
                return new MySQLAdapter();
            default:
                return null;
        }
    }
    
    public static IDBAdapter getAdapter(){
        try {
            Properties p = loadProperties();
            String dbType = p.getProperty(DB_TYPE);
            return (IDBAdapter)Class.forName(dbType).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static Properties loadProperties(){
        try {
            Properties p = new Properties();
            InputStream stream = DBAdapterFactory.class.getClassLoader().getResourceAsStream("META-INF/dbadapter.properties");
            p.load(stream);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
