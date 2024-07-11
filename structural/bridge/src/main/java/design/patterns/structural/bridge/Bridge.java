package design.patterns.structural.bridge;

import design.patterns.structural.bridge.impl.DefaultMessageEncryptImpl;
import design.patterns.structural.bridge.impl.IMessageEncrypt;
import design.patterns.structural.bridge.encript.*;

/**
 *
 * @author eduardo
 */
public class Bridge {

    public static void main(String[] args) {
        IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(
                new AESEncriptAlgorithm());
        IMessageEncrypt desImpl = new DefaultMessageEncryptImpl(
                new DESEncriptAlgorithm());
        IMessageEncrypt noImpl = new DefaultMessageEncryptImpl(
                new NoEncriptAlgorithm());
        
        try {
            final String message = "<Person><Name>Oscar Blancarte</Name></Person>";
            String messageAES = aesImpl.encryptMessage(message, "HG58YZ3CR9123456");
            System.out.println("messageAES > " + messageAES + "\n");
            
            String messageDES = desImpl.encryptMessage(message, "XMzDdG4D03CKm2Ix");
            System.out.println("messageDES > " + messageDES + "\n");
            
            String messageNO = noImpl.encryptMessage(message, null);
            System.out.println("messageNO > " + messageNO + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
