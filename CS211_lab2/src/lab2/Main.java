package lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Hex string: ");
        String hex = scanner.nextLine();
        String roman = getRoman(hex);
        System.out.println(roman);
    }

    public static String getRoman(String hex) {
        // Convert hex string to decimal integer
        int number = Integer.parseInt(hex, 16);
        
        // Use StringBuilder for efficient string concatenation
        StringBuilder roman = new StringBuilder();
        
        // Arrays holding the values and corresponding Roman numerals
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        String[] numerals = {"M", "D", "C", "L", "X", "V", "I"};
        
        // Build the Roman numeral representation
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(numerals[i]);
                number -= values[i];
            }
        }
        return roman.toString();
    }
}
