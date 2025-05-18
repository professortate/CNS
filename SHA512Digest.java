import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Scanner; 
 
public class SHA512Digest { 
 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
 
        // Input the text from the user 
        System.out.println("Enter the text to calculate its SHA-512 digest:"); 
        String text = scanner.nextLine(); 
 
        // Calculate the SHA-512 digest 
        String sha512Digest = calculateSHA512(text); 
 
        // Display the result 
        System.out.println("SHA-512 Digest: " + sha512Digest); 
    } 
 
    private static String calculateSHA512(String text) { 
        try { 
            // Create a MessageDigest instance for SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
 
            // Digest the input text and get the byte array 
            byte[] digestBytes = md.digest(text.getBytes(StandardCharsets.UTF_8)); 
 
            // Convert the byte array to a hexadecimal string 
            StringBuilder sb = new StringBuilder(); 
            for (byte b : digestBytes) { 
                sb.append(String.format("%02x", b)); 
            } 
 
            return sb.toString(); 
 
        } catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException("SHA-512 algorithm not found", e); 
        } 
    } 
} 