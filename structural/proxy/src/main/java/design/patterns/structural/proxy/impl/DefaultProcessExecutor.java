package design.patterns.structural.proxy.impl;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DefaultProcessExecutor implements IProcessExecutor {

    private static final Logger logger = Logger.getLogger(DefaultProcessExecutor.class.getName());
    
    @Override
    public void executeProcess(int idProcess, String user, String password) throws Exception {
        logger.log(Level.INFO, "processes {0} in action", idProcess);
        logger.log(Level.INFO, "processes {0} finished", idProcess);
    }
    
}
