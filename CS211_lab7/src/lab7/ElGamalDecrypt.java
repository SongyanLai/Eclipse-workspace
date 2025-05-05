package lab7;

import java.util.Scanner;

public class ElGamalDecrypt {
    // Fast modular exponentiation: computes (base^exponent) mod modulus efficiently
    public static int modExp(int base, int exponent, int modulus) {
        int result = 1;
        base = base % modulus;
        while (exponent > 0) {
            // If the exponent is odd, multiply the result by the base
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            // Divide the exponent by 2
            exponent = exponent >> 1;
            // Square the base for the next iteration
            base = (base * base) % modulus;
        }
        return result;
    }
    
    // Extended Euclidean Algorithm to compute the modular inverse of a modulo m
    // It finds an integer x such that (a * x) mod m = 1.
    public static int modInverse(int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;
        
        if (m == 1)
            return 0;
        
        while (a > 1) {
            // q is the quotient
            q = a / m;
            t = m;
            // m becomes the remainder of a divided by m
            m = a % m;
            a = t;
            t = x0;
            // Update x0 and x1 using the quotient q
            x0 = x1 - q * x0;
            x1 = t;
        }
        
        // Ensure x1 is positive
        if (x1 < 0)
            x1 += m0;
        
        return x1;
    }
    
    // Decryption function:
    // Given modulus p, Bob's private key x, and ciphertext (c1, c2),
    // compute the shared secret k = c1^x mod p.
    // Then, find the modular inverse of k (denoted kInverse),
    // and finally recover the original message using m = c2 * kInverse mod p.
    public static int decrypt(int p, int x, int c1, int c2) {
        int k = modExp(c1, x, p);
        int kInverse = modInverse(k, p);
        int m = (int)(((long)c2 * kInverse) % p);
        return m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Prompt the user to enter Bob's private key parameters.
        // Here, Bob's private key is x, and p is the modulus.
        System.out.println("Enter Bob's private key parameters:");
        System.out.print("Enter p: ");
        int p = scanner.nextInt();
        System.out.print("Enter private key x: ");
        int x = scanner.nextInt();
       
        // Prompt the user to enter the ciphertext (two numbers: c1 and c2)
        System.out.println("Enter the ciphertext (two numbers separated by space):");
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
       
        // Decrypt the ciphertext and output the original message
        int m = decrypt(p, x, c1, c2);
        System.out.println("The decrypted message is: " + m);
        scanner.close();
    }
}

