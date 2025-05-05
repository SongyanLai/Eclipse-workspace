package Collatz;
import java.util.Scanner;

public class extra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a positive integer: ");
        long n = scanner.nextLong();

        // Initialize counter to 1, since we will print the initial number
        int count = 1;

        // Print initial value
        System.out.println(n);

        // Start calculating the Collatz sequence until n becomes 1
        while (n != 1) {
            if (n % 2 == 0) {
            	// 如果n是偶数，除以2	 If n is even, divide by 2
                n = n / 2;
            } else {
            	// 如果n是奇数，乘3加1	If n is odd, multiply by 3 plus 1
                n = 3 * n + 1;
            }
            System.out.println(n);
            count++; // Increment the counter for each printed number
        }

        // Print the total count
        System.out.println("Total numbers printed: " + count);

        scanner.close();
    }
}
