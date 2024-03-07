package design.patterns.structural.proxy.factory;

import design.patterns.structural.proxy.impl.IProcessExecutor;
import design.patterns.structural.proxy.impl.ProcessExecutorProxy;

public class ServiceFactory {

    public static IProcessExecutor createProcessExecutor(){
        return new ProcessExecutorProxy();
    }
    
}
