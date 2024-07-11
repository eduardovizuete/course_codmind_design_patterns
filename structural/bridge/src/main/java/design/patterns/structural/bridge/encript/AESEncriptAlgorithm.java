package design.patterns.structural.bridge.encript;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncriptAlgorithm implements IEncriptAlgorithm {

    @Override
    public String encript(String message, String password) throws Exception {
        Key key = new SecretKeySpec(password.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        
        byte[] encVal = c.doFinal(message.getBytes());
        String encryptedValue = new String(Base64.getEncoder().encode(encVal));
        
        return encryptedValue;
    }
    
}
