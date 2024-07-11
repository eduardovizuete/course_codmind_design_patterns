package design.patterns.structural.bridge.encript;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESEncriptAlgorithm implements IEncriptAlgorithm {

    @Override
    public String encript(String message, String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(message.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);

        //Encode the string into bytes using utf-8
        byte[] utf8 = message.getBytes("UTF8");
        //Encrypt
        byte[] enc = desCipher.doFinal(utf8);
       
        return new String(Base64.getEncoder().encode(enc));
    }

}
