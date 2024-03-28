package design.patterns.structural.objectpool.impl;

import design.patterns.structural.objectpool.impl.factory.IPoolableObjectFactory;
import design.patterns.structural.objectpool.impl.poolable.ExecutorTask;

public class ExecutorThreadPool extends AbstractObjectPool<ExecutorTask> {

    public ExecutorThreadPool(int minInstances, int maxInstances, int waitTime, 
            IPoolableObjectFactory<ExecutorTask> poolableObjectFactory) {
        super(minInstances, maxInstances, waitTime, poolableObjectFactory);
    }
    
}