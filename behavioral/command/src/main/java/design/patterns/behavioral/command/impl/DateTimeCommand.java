package design.patterns.behavioral.command.impl;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeCommand extends BaseCommand {

    public static final String COMMAND_NAME = "date";
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        SimpleDateFormat dateFormat = null;
        
        if(args == null || args.length == 0 ){
            dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        }else{
            try {
                 dateFormat = new SimpleDateFormat(args[0]);
            } catch  (Exception e) {
                write(out, "invalid format");
                return;
            }
            dateFormat = new SimpleDateFormat(args[0]);           
        }
        
        String fDate = dateFormat.format(new Date());
        write(out, fDate);
    }
    
}
