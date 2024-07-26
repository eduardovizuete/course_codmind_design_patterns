package design.patterns.behavioral.iterator.impl;

public interface IIterator<T> {
    
    public boolean hasNext();
    
    public T next();
    
}
