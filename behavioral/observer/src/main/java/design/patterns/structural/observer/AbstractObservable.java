package design.patterns.structural.observer;

import java.util.ArrayList;
import java.util.List;

public class AbstractObservable implements IObservable {

    private final List<IObserver> observers = new ArrayList<>();
    
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notityAllObserver(String command, Object source) {
        for(IObserver observer : observers){
            observer.notify(command, source);
        }
    }
    
}
