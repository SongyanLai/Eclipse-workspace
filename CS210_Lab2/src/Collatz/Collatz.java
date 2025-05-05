package Collatz;
import java.util.Scanner;

public class Collatz {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a positive integer��");
        long n = scanner.nextLong();

        // Print initial value
        System.out.println(n);

        // Start calculating the Collatz sequence until n becomes 1
        while (n != 1) {
            if (n % 2 == 0) {
                // ���n��ż��������2	If n is even, divide by 2
                n = n / 2;
            } else {
                // ���n����������3��1	If n is odd, multiply by 3 plus 1
                n = 3 * n + 1;
            }
            System.out.println(n);
        }
        scanner.close();
    }
}
