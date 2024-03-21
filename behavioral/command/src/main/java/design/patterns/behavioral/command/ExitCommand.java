package design.patterns.behavioral.command;

import java.io.OutputStream;
import org.w3c.dom.views.AbstractView;

public class ExitCommand extends AbstractCommand {

    public static final String COMMAND_NAME = "exit";
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        write(out, "Saliendo de la linea de comandos ...");
        System.exit(0);
    }
    
    
    
}
