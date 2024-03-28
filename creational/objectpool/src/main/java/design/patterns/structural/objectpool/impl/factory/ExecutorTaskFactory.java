package design.patterns.structural.objectpool.impl.factory;

import design.patterns.structural.objectpool.impl.poolable.ExecutorTask;

public class ExecutorTaskFactory implements IPoolableObjectFactory<ExecutorTask>{
    
    @Override
    public ExecutorTask createNew(){
        return new ExecutorTask();
    }
    
}
