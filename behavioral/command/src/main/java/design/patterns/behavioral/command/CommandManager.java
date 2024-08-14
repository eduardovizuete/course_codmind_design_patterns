package design.patterns.behavioral.command;

import design.patterns.behavioral.command.impl.BatchCommand;
import design.patterns.behavioral.command.impl.DateTimeCommand;
import design.patterns.behavioral.command.impl.ExitCommand;
import design.patterns.behavioral.command.impl.CommandNotFound;
import design.patterns.behavioral.command.impl.DirCommand;
import design.patterns.behavioral.command.impl.EchoCommand;
import design.patterns.behavioral.command.impl.ErrorCommand;
import design.patterns.behavioral.command.impl.FileCommand;
import design.patterns.behavioral.command.impl.MemoryCommand;
import design.patterns.behavioral.command.impl.NotFoundCommand;
import design.patterns.behavioral.command.impl.WaitAndSayHello;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandManager {
    
    private static Logger LOGGER = Logger.getLogger(CommandManager.class.getName());
  
    private static CommandManager commandManager;
    
    private static final Map<String, Class<? extends ICommand>> COMMANDS = new HashMap<>();
    
    private CommandManager() {
        registerCommand(EchoCommand.COMMAND_NAME, EchoCommand.class);
        registerCommand(DirCommand.COMMAND_NAME, DirCommand.class);
        registerCommand(DateTimeCommand.COMMAND_NAME, DateTimeCommand.class);
        registerCommand(MemoryCommand.COMMAND_NAME, MemoryCommand.class);
        registerCommand(FileCommand.COMMAND_NAME, FileCommand.class);
        registerCommand(ExitCommand.COMMAND_NAME, ExitCommand.class);
        registerCommand(BatchCommand.COMMAND_NAME, BatchCommand.class);
        registerCommand(WaitAndSayHello.COMMAND_NAME, WaitAndSayHello.class);
    }
    
    public static synchronized CommandManager getInstance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        } 
        
        return commandManager;
    }
    
    public ICommand getCommand(String commandName) {
        if (COMMANDS.containsKey(commandName)) {
            try {
                return COMMANDS.get(commandName).newInstance();
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
                return new ErrorCommand();
            }
        } else {
            return new NotFoundCommand();
        }
    }
    
    public void registerCommand(String commandName, Class<? extends ICommand> clazz){
       COMMANDS.put(commandName, clazz);
    }
    
}
