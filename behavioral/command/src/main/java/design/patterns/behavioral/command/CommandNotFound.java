package design.patterns.behavioral.command;

import java.io.OutputStream;

public class CommandNotFound extends AbstractCommand {
    
    public static final String COMMAND_NAME = "Not_Found";
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        write(out, "Command not found..");
    }
    
}
