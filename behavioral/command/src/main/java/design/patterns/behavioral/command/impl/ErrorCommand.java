package design.patterns.behavioral.command.impl;

import java.io.OutputStream;

public class ErrorCommand extends BaseCommand {
    
    public static final String COMMAND_NAME = "ERROR";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        String message = "Invocation error";
        write(out, message);
    }
    
}
