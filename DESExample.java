import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
public class DESExample{
public static void main(String[] args) throws IOException, NoSuchAlgorithmException,
InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException,
IllegalBlockSizeException, BadPaddingException {
// String we want to encrypt
String message = "This is a confidential message.";
byte[] myMessage = message.getBytes(); // string to byte array as DES works on bytes
// Generating Key (Alternatively, you could use a custom key as commented out)
KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
SecretKey myDesKey = keyGenerator.generateKey();
// Initializing cipher (DES)
Cipher myCipher = Cipher.getInstance("DES");
// Encryption process
myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
byte[] encryptedBytes = myCipher.doFinal(myMessage);
// Decryption process
myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
byte[] decryptedBytes = myCipher.doFinal(encryptedBytes);
// Convert encrypted and decrypted bytes to Base64 strings for readability
String encryptedData = Base64.getEncoder().encodeToString(encryptedBytes);
String decryptedData = new String(decryptedBytes);
// Output the result

System.out.println("Original Message: " + message);
System.out.println("Encrypted Message (Base64): " + encryptedData);
System.out.println("Decrypted Message: " + decryptedData);
}
}