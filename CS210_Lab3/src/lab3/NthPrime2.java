package lab3;

import java.util.Scanner;
//modify the code to print out the Nth prime number and the 2*Nth prime number

public class NthPrime2 {
    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;  // Numbers less than 2 are not prime
        for (int i = 2; i <= Math.sqrt(num); i++) { // Check up to the square root of the number
            if (num % i == 0) return false; // If divisible, it's not a prime
        }
        return true; // Otherwise it's a prime number
    }

    // Function to find the Nth prime number
    public static int findNthPrime(int N) {
        int count = 0;  // Number of primes found
        int num = 1;    
        while (count < N) {  // Loop until we find N primes
            num++;
            if (isPrime(num)) {
                count++;  // If the number is prime, increase the count
            }
        }
        return num;  // Return the Nth prime number
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer N: ");
        int N = scanner.nextInt();
        scanner.close();

        // Find and print the Nth prime number
        int nthPrime = findNthPrime(N);
        System.out.println("The " + N + "th prime number is: " + nthPrime);

        // Find and print the 2*Nth prime number
        int doubleNthPrime = findNthPrime(2 * N);
        System.out.println("The " + 2 * N + "th prime number is: " + doubleNthPrime);
    }
}




