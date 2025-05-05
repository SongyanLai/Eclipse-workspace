package lab2;

import java.util.Scanner;

public class HexToRoman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Hex string: ");
        String hex = scanner.nextLine().toUpperCase(); // Convert to capitalization
        String roman = getRoman(hex);
        System.out.println(roman);
        scanner.close();
    }

    public static String getRoman(String hex) {
        int decimal = Integer.parseInt(hex, 16); // Convert hexadecimal to decimal
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int count = decimal / values[i];
            if (count > 0) {
                roman.append(symbols[i].repeat(count)); // Directly append the number of repetitions of the corresponding symbol
                decimal %= values[i]; // Update remaining values
            }
        }
        return roman.toString();
    }
}