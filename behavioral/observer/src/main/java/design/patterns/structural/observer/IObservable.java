package design.patterns.structural.observer;

public interface IObservable {
    
    public void addObserver(IObserver observer);
    
    public void removeObserver(IObserver observer);
    
    public void notityAllObserver(String command, Object source);
    
}
