package design.patterns.behavioral.command.impl;

import design.patterns.behavioral.command.ICommand;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseCommand implements ICommand {
    
    private static final Logger LOGGER = Logger.getLogger(BaseCommand.class.getName());
    
    @Override
    public abstract String getCommandName();

    @Override
    public abstract void execute(String[] args, OutputStream out);
    
    public void write(OutputStream stream, String message){
        try {
            stream.write(message.getBytes());   
            stream.flush();
        } catch (Exception ex) { 
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    
}
