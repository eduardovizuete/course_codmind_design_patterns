package design.patterns.structural.prototype.impl;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {
    
    private static final Map<String, IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }
    
    public static void addPrototype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName, prototype);
    }
    
}
