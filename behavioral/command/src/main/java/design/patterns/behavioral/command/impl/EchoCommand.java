package design.patterns.behavioral.command.impl;

import java.io.OutputStream;
import java.util.Arrays;

public class EchoCommand extends BaseCommand {
    
    public static final String COMMAND_NAME = "echo";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        String message = getCommandName() + " " + Arrays.toString(args);
        write(out, message);
    }
    
}
