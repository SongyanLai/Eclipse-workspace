package lab7;

import java.util.Random;
import java.util.Scanner;

public class ElGamal {
    
    public static int modExp(int base, int exp, int p) {
        int result = 1;
        base = base % p;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (int)((long)result * base % p);
            }
            base = (int)((long)base * base % p);
            exp >>= 1;
        }
        return result;
    }
    

    public static String encrypt(int p, int g, int gxmodp, int m) {
        Random random = new Random();
        int y = 1 + random.nextInt(p - 2);
        
        int c1 = modExp(g, y, p);
        
        int gxy = modExp(gxmodp, y, p);
        
        long temp = (long)m * gxy;
        int c2 = (int)(temp % p);
        
        return "(" + c1 + ", " + c2 + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input line and split by spaces
        System.out.println("Enter the public key (p, g, g^x mod p), separated by spaces:");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        // Parse numbers
        int p = Integer.parseInt(numbers[0]);
        int g = Integer.parseInt(numbers[1]);
        int gxmodp = Integer.parseInt(numbers[2]);

        // Read the message
        System.out.println("Now enter the message to encrypt:");
        int m = scanner.nextInt();
        
        // Perform ElGamal encryption
        String ciphertext = encrypt(p, g, gxmodp, m);
        
        // Print the resulting ciphertext
        System.out.println("The ciphertext is: " + ciphertext);

        scanner.close();
    }
}




