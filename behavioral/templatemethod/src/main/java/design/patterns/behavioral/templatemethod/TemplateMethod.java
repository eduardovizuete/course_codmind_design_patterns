package design.patterns.behavioral.templatemethod;

import design.patterns.behavioral.templatemethod.impl.DrugstoreFileProcess;
import design.patterns.behavioral.templatemethod.impl.GroceryFileProcess;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TemplateMethod extends TimerTask {

    private static final String[] PATHS = 
        new String[]{"src/main/resources/files/drugstore", "src/main/resources/files/grocery"};
    
    private static final String LOG_DIR = "src/main/resources/files/logs";
    
    private static final String PROCESS_DIR = "src/main/resources/files/process";

    public static void main(String[] args) {
        new TemplateMethod().start();
    }

    public void start() {
        try {
            Timer timer = new Timer();
            timer.schedule(this, new Date(), (long) 1000 * 10);
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("> Monitoring start");
        File f = new File(PATHS[0]);
        if(!f.exists()){
            throw new RuntimeException("El path '"+PATHS[0]+"' no existe");
        }
        System.out.println("> Read Path " + PATHS[0]);
        File[] drugstoreFiles = f.listFiles();
        for (File file : drugstoreFiles) {
            try {
                System.out.println("> File found > " + file.getName());
                new DrugstoreFileProcess(file,LOG_DIR,PROCESS_DIR).execute();
                System.out.println("Processed file > " + file.getName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
        f = new File(PATHS[1]);
        if(!f.exists()){
            throw new RuntimeException("El path '"+PATHS[1]+"' no existe");
        }
        System.out.println("> Read Path " + PATHS[1]);
        File[] groceryFiles = f.listFiles();
        for (File file : groceryFiles) {
            try {
                System.out.println("> File found > " + file.getName());
                new GroceryFileProcess(file,LOG_DIR,PROCESS_DIR).execute();
                System.out.println("Processed file > " + file.getName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
}
