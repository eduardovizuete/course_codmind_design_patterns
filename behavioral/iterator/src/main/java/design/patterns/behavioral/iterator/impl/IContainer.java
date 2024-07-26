package design.patterns.behavioral.iterator.impl;

public interface IContainer<T> {
    
    public IIterator<T> createIterator();
    
}
