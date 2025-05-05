package cs210;
import java.util.Scanner;
//Explanation:
//The original Luhn Algorithm uses sum % 10 == 0 to determine if the card number is valid.
//In this modified version, the check has been updated to sum % 5 == 0, which changes the validation logic.
//Instead of checking if the sum ends in 0, the new algorithm will check if the sum ends in a 0 or 5, 
//indicating a multiple of 5.
//Example Inputs and Outputs:
//1.	Valid Input 1: 4532015112830366
//o	Explanation: When the sum of processed digits is calculated and divided by 5, the remainder is 0.
//2.	Valid Input 2: 6011514433546201
//o	Explanation: Similar to the previous case, the sum divided by 5 has a remainder of 0.
//3.	Invalid Input 1: 1234567890123456
//o	Explanation: The sum of processed digits, when divided by 5, has a remainder different from 0, making it invalid.
//4.	Invalid Input 2: 111111111111111
//o	Explanation: Similar to the previous case

public class Modification {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Input credit card number:");
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

	        // Iterate through the credit card numbers from right to left
	        for (int i = cardNumber.length() - 1; i >= 0; i--) {
	            // Get the current digit
	            int n = Character.getNumericValue(cardNumber.charAt(i));

	            if (alternate == true) {
	                n = n * 2; 
	                if (n > 9) { // If the doubled value is greater than 9, subtract 9 (same as summing the digits)
	                    n = n - 9;
	                }
	            }

	            // Add the processed number to sum
	            sum = sum + n;
	            // Toggle for the next digit
	            alternate = !alternate;
	        }

	        // Determine whether sum modulo 5 is 0.
	        return (sum % 5 == 0);
	    }
	

}
