import java.util.Scanner;

public class caesarCipher{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Encrypts the message using the Caesar Cipher with a shift key
    public static String encrypt(String message, int shiftKey) {
        StringBuilder cipherText = new StringBuilder();
        message = message.toLowerCase();

        for (char c : message.toCharArray()) {
            int charPosition = ALPHABET.indexOf(c);
            if (charPosition != -1) {  // Ensure it's a letter
                int keyVal = (shiftKey + charPosition) % 26;
                cipherText.append(ALPHABET.charAt(keyVal));
            } else {
                cipherText.append(c);  // Non-letter characters remain unchanged
            }
        }
        return cipherText.toString();
    }

    // Decrypts the message using the Caesar Cipher with a shift key
    public static String decrypt(String message, int shiftKey) {
        StringBuilder plainText = new StringBuilder();
        message = message.toLowerCase();

        for (char c : message.toCharArray()) {
            int charPosition = ALPHABET.indexOf(c);
            if (charPosition != -1) {  // Ensure it's a letter
                int keyVal = (charPosition - shiftKey + 26) % 26;  // Adjust for negative values
                plainText.append(ALPHABET.charAt(keyVal));
            } else {
                plainText.append(c);  // Non-letter characters remain unchanged
            }
        }
        return plainText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the action choice from the user
        System.out.print("Choose an option:\n1. Encrypt\n2. Decrypt\nEnter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter the String: ");
        sc.nextLine();  // To consume the newline character after the integer input
        String message = sc.nextLine();  // Read the entire message

        System.out.print("Enter Shift Key: ");
        int key = sc.nextInt();

        // Process based on the user's choice
        if (choice == 1) {
            // Encryption
            String encryptedMessage = encrypt(message, key);
            System.out.println("\nEncrypted msg: " + encryptedMessage);
        } else if (choice == 2) {
            // Decryption
            String decryptedMessage = decrypt(message, key);
            System.out.println("\nDecrypted msg: " + decryptedMessage);
        } else {
            // ❌ Fixed the formatting here
            System.out.println("Invalid choice. Please enter 1 for encryption or 2 for decryption.");
        }
    }
}
