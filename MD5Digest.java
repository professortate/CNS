import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Scanner; 
 
public class MD5Digest { 
 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
 
        // Input the text from the user 
        System.out.println("Enter the text to calculate its MD5 digest:"); 
        String text = scanner.nextLine(); 
// Calculate the MD5 digest 
String md5Digest = calculateMD5(text); 
// Display the result 
System.out.println("MD5 Digest: " + md5Digest); 
} 
private static String calculateMD5(String text) { 
try { 
// Create a MessageDigest instance for MD5 
MessageDigest md = MessageDigest.getInstance("MD5"); 
// Digest the input text and get the byte array 
byte[] digestBytes = md.digest(text.getBytes(StandardCharsets.UTF_8)); 
// Convert the byte array to a hexadecimal string 
StringBuilder sb = new StringBuilder(); 
for (byte b : digestBytes) { 
sb.append(String.format("%02x", b)); 
} 
return sb.toString(); 
} catch (NoSuchAlgorithmException e) { 
throw new RuntimeException("MD5 algorithm not found", e); 
} 
} 
} 
    

