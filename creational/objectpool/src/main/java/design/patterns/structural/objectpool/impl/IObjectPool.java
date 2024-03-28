package design.patterns.structural.objectpool.impl;

import design.patterns.structural.objectpool.impl.poolable.IPooledObject;

public interface IObjectPool<T extends IPooledObject> {
    
    public T getObject() throws PoolException;
    
    public void releaseObject(T pooledObject);

}
