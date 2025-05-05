package lab7;

import java.util.Scanner;
import java.util.Random;

public class ElGamalEncrypt {
    // Fast modular exponentiation: computes (base^exponent) mod modulus efficiently
    public static int modExp(int base, int exponent, int modulus) {
        int result = 1;
        base = base % modulus;
        while (exponent > 0) {
            // If the exponent is odd, multiply result with base
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            // Divide exponent by 2
            exponent = exponent >> 1;
            // Square the base for the next iteration
            base = (base * base) % modulus;
        }
        return result;
    }

    // Encryption function:
    // Given modulus p, generator g, Bob's public key gxmodp (which is g^x mod p), and message m,
    // this method selects a random ephemeral key y, then computes:
    //   c1 = g^y mod p, and
    //   c2 = m * (gxmodp)^y mod p.
    public static String encrypt(int p, int g, int gxmodp, int m) {
        Random rand = new Random();
        // Choose a random ephemeral key y in the range [1, p-2]
        int y = 1 + rand.nextInt(p - 2);
        int c1 = modExp(g, y, p);
        int c2 = (int)(((long) m * modExp(gxmodp, y, p)) % p);
        return "(" + c1 + ", " + c2 + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        // Prompt the user to enter Bob's public key parameters.
        // Note: Although the input is labeled "private key" in the exercise, it actually represents the public key (p, g, g^x mod p).
        System.out.println("Enter Bob's public key (p g gxmodp) separated by spaces:");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
       
        // Parse the public key parameters
        int p = Integer.parseInt(numbers[0]);
        int g = Integer.parseInt(numbers[1]);
        int gxmodp = Integer.parseInt(numbers[2]);
 
        // Prompt the user to enter the message to send
        System.out.println("Enter the message (m):");
        int m = scanner.nextInt();
 
        // Encrypt the message and output the ciphertext
        System.out.println("The ciphertext is: " + encrypt(p, g, gxmodp, m));
        scanner.close();
    }
}

