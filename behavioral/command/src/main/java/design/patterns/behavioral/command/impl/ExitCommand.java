package design.patterns.behavioral.command.impl;

import design.patterns.behavioral.command.ICommand;
import java.io.OutputStream;

public class ExitCommand implements ICommand {

    public static final String COMMAND_NAME = "exit";
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        System.exit(0);
    }
    
}
