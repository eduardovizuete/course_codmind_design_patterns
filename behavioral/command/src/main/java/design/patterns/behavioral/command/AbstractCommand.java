package design.patterns.behavioral.command;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractCommand implements ICommand {
    
    private static final Logger logger = Logger.getLogger(AbstractCommand.class.getName());
    
    @Override
    public abstract String getCommandName();

    @Override
    public abstract void execute(String[] args, OutputStream out);
    
    public void write(OutputStream stream, String message){
        try {
            stream.write(message.getBytes());   
        } catch (Exception ex) { 
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
}
