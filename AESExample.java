import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.util.Base64;

public class AESExample {
    public static void main(String[] args) throws Exception {
        // Read input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String plaintext = scanner.nextLine();

        // Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // 256-bit AES key
        SecretKey secretKey = keyGenerator.generateKey();

        // Create AES cipher instance and initialize for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted text: " + encryptedText);

        // Initialize cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypt the text
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted text: " + decryptedText);

        // Close scanner
        scanner.close();
    }
}
