package cs210;
import java.util.Scanner;

public class LuhnAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input credit card number£º");
        String cardNumber = scanner.nextLine();

        if (isValidCard(cardNumber) == true) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }

        scanner.close();
    }


    public static boolean isValidCard(String cardNumber) {
        int sum = 0; // Stores the sum of all numbers
        boolean alternate = false; // Used to mark whether or not to double

        // ±éÀú Iterate through the credit card numbers from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            // Get the current bit number
            int n = Character.getNumericValue(cardNumber.charAt(i));

            if (alternate == true) {
                n = n * 2; 
                if (n > 9) { //add the first and second digits
                    n = n - 9;
                }
            }

            // Add the processed number to sum
            sum = sum + n;
            // Mark if the next number needs to be doubled
            alternate = !alternate;
        }

        // Determine whether sum modulo 10 is 0.
        return (sum % 10 == 0);
    }
}
