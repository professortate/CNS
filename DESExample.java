import javax.crypto.*;
import java.security.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class DESExample {
    public static void main(String[] args) throws Exception {
        String message = "This is a confidential message.";
        byte[] myMessage = message.getBytes(StandardCharsets.UTF_8);

        // Generate DES Key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey myDesKey = keyGenerator.generateKey();

        // Initialize Cipher
        Cipher myCipher = Cipher.getInstance("DES");

        // Encrypt
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] encryptedBytes = myCipher.doFinal(myMessage);

        // Decrypt
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] decryptedBytes = myCipher.doFinal(encryptedBytes);

        // Encode/Decode Base64 for readability
        String encryptedData = Base64.getEncoder().encodeToString(encryptedBytes);
        String decryptedData = new String(decryptedBytes, StandardCharsets.UTF_8);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message (Base64): " + encryptedData);
        System.out.println("Decrypted Message: " + decryptedData);
    }
}