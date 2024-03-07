package design.patterns.structural.proxy.impl;

import design.patterns.structural.proxy.services.AuditService;
import design.patterns.structural.proxy.services.SecurityService;

public class ProcessExecutorProxy implements IProcessExecutor {

    @Override
    public void executeProcess(int idProcess, String user, String password) throws Exception {
        
        SecurityService securityService = new SecurityService();
        if(!securityService.authorization(user, password)){
            throw new Exception("The user '"+user
                    +"' does not have privileges to execute the process");
        }
        
        DefaultProcessExecutor ejecutorProcess = new DefaultProcessExecutor();
        ejecutorProcess.executeProcess(idProcess, user, password);
        
        AuditService audit = new AuditService();
        audit.auditServiceUsed(user, DefaultProcessExecutor.class.getName());
    }
    
}
