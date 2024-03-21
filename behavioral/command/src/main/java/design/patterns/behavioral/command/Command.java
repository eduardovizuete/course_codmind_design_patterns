package design.patterns.behavioral.command;

import design.patterns.behavioral.command.util.CommandUtil;
import java.util.Arrays;
import java.util.Scanner;

public class Command {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CommandManager commandManger = CommandManager.getInstance();
        
        while(true){
            String newLine = scanner.nextLine();
            if(newLine.trim().isEmpty()){
                continue;
            }
            
            String[] commandArgs = CommandUtil.tokenizerArgs(newLine);
            String commandName = commandArgs[0];
            String[] commandArgs2 = null;
            if(commandArgs.length > 1){
                commandArgs2 = Arrays.copyOfRange(commandArgs, 1, commandArgs.length);
            }
            ICommand command = commandManger.getCommand(commandName);
            command.execute(commandArgs2, System.out);
        }
    }
    
}



