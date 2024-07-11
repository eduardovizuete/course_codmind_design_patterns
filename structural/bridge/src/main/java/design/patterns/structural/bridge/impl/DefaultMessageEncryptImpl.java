package design.patterns.structural.bridge.impl;

import design.patterns.structural.bridge.encript.IEncriptAlgorithm;

public class DefaultMessageEncryptImpl implements IMessageEncrypt {

    private IEncriptAlgorithm encryptAlgorithm;

    public DefaultMessageEncryptImpl(IEncriptAlgorithm encryptAlgorithm) {
        this.encryptAlgorithm = encryptAlgorithm;
    }
    
    @Override
    public String encryptMessage(String message, String password) throws Exception {
        return encryptAlgorithm.encript(message, password);
    }
    
}
