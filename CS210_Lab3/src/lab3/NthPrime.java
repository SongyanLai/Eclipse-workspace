package lab3;

import java.util.Scanner;

public class NthPrime {
    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;  // Numbers less than 2 are not prime
        for (int i = 2; i <= Math.sqrt(num); i++) { // 质数的判断,检查到平方根 Check to square root
            if (num % i == 0) return false; // If it is divisible, then it is not prime
        }
        return true; // Otherwise it's a prime number.
    }


    // Function to find the Nth prime number
    public static int findNthPrime(int N) {
        int count = 0;  // The number of primes found
        int num = 1;    
        while (count < N) {  // When the number of primes found is less than N, the loop continues.
            num++; 
            if (isPrime(num)) {  
                count++;  // If the number is prime, add one.
            }
        }
        return num;  // Returns the nth prime number
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Please enter an integer N: ");  
        int N = scanner.nextInt(); 
        scanner.close(); 

        // Calls the findNthPrime function and outputs the Nth prime number
        System.out.println("The " + N + "th prime number is: " + findNthPrime(N));
    }
}
