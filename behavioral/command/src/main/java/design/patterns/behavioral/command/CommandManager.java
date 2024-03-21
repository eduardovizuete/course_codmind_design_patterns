package design.patterns.behavioral.command;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandManager {
  
    private static CommandManager commandManager;
    
    private static Map<String, Class<? extends ICommand>> commands = new HashMap<>();
    
    private static Logger logger = Logger.getLogger(CommandManager.class.getName());
    
    private CommandManager() {
        register(ExitCommand.COMMAND_NAME, ExitCommand.class);
        register(DateCommand.COMMAND_NAME, DateCommand.class);
    }
    
    public synchronized static CommandManager getInstance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        } 
        
        return commandManager;
    }
    
    public void register(String commandName, Class<? extends ICommand> clazz){
       commands.put(commandName, clazz);
    }
    
    public ICommand getCommand(String command) {
        if (!commands.containsKey(command)) {
            return new CommandNotFound();
        }
        try {
            ICommand iCommand = (ICommand)commands.get(command).newInstance();
            return iCommand;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
