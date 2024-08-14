package design.patterns.behavioral.command.impl;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaitAndSayHello extends AsyncCommand {
    
    private static final Logger LOGGER = Logger.getLogger(BaseCommand.class.getName());
    
    public static final String COMMAND_NAME = "waithello";
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void executeOnBackground(String[] args, OutputStream out) {
        if (args == null || args.length < 1) {
            write(out, "Insufficient parameters");
            return;
        }

        Long time = null;
        try {
            time = Long.parseLong(args[0]);
        } catch (Exception e) {
            write(out, "Invalid time");
            return;
        }

        try {
            Thread.sleep(time.longValue());
            write(out, "Hello!!");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    
}
