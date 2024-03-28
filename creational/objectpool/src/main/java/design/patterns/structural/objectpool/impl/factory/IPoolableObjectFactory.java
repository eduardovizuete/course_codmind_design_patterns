package design.patterns.structural.objectpool.impl.factory;

import design.patterns.structural.objectpool.impl.poolable.IPooledObject;

public interface IPoolableObjectFactory<T extends IPooledObject> {
    
    public T createNew();

}
