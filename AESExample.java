import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import javax.crypto.spec.SecretKeySpec; 
import java.util.Base64; 
public class AESExample { 
// Method to generate a secret key 
public static SecretKey generateKey(int n) throws Exception { 
KeyGenerator keyGenerator = KeyGenerator.getInstance("AES"); 
keyGenerator.init(n); 
SecretKey secretKey = keyGenerator.generateKey(); 
return secretKey; 
} 
// Method to encrypt a plaintext using a secret key 
public static String encrypt(String plainText, SecretKey secretKey) throws Exception { 
Cipher cipher = Cipher.getInstance("AES"); 
cipher.init(Cipher.ENCRYPT_MODE, secretKey); 
byte[] encryptedBytes = cipher.doFinal(plainText.getBytes()); 
return Base64.getEncoder().encodeToString(encryptedBytes); 
} 
// Method to decrypt a ciphertext using a secret key 
public static String decrypt(String cipherText, SecretKey secretKey) throws Exception 
{ 
Cipher cipher = Cipher.getInstance("AES"); 
cipher.init(Cipher.DECRYPT_MODE, secretKey); 
byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText)); 
return new String(decryptedBytes); 
} 
// Main method to demonstrate encryption and decryption 
public static void main(String[] args) { 
try { 
String plainText = "Hello, this is a secret message!"; 
SecretKey secretKey = generateKey(128); 
String encryptedText = encrypt(plainText, secretKey); 
System.out.println("Encrypted Text: " + encryptedText); 
String decryptedText = decrypt(encryptedText, secretKey); 
System.out.println("Decrypted Text: " + decryptedText); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
}  