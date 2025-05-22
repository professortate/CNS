import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.util.Base64;

public class DESExample {
    public static void main(String[] args) throws Exception {
        // Read input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String plaintext = scanner.nextLine();

        // Generate DES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56); // DES uses 56-bit key
        SecretKey secretKey = keyGenerator.generateKey();

        // Create DES cipher instance and initialize for encryption
        Cipher cipher = Cipher.getInstance("DES");
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
