import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a Prime number: ");
        BigInteger p = sc.nextBigInteger(); // First prime number

        System.out.print("Enter another Prime number: ");
        BigInteger q = sc.nextBigInteger(); // Second prime number

        BigInteger n = p.multiply(q); // n = p * q
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // φ(n)

        BigInteger e = generateE(phi); // Public exponent
        BigInteger d = e.modInverse(phi); // Private exponent

        System.out.println("Encryption keys are: (" + e + ", " + n + ")");
        System.out.println("Decryption keys are: (" + d + ", " + n + ")");
    }

    public static BigInteger generateE(BigInteger phi) {
        Random rand = new Random();
        BigInteger e;
        do {
            e = new BigInteger(phi.bitLength(), rand);
        } while (e.compareTo(BigInteger.TWO) <= 0 || !phi.gcd(e).equals(BigInteger.ONE));
        return e;
    }
}
