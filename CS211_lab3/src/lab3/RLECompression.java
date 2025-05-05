package lab3;

import java.util.Scanner;

public class RLECompression {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the string to be compressed: ");
	        String input = scanner.nextLine();
	        String compressed = compress(input);
	        System.out.println("Compressed as: " + compressed);
	        
	        if (input.isEmpty()) {
	            System.out.println("0.0%");
	        } else {
	            double ratio = (double) compressed.length() / input.length() * 100;
	            System.out.printf("%.1f%%\n", ratio);
	        }
	        scanner.close();
	    }

	    public static String compress(String input) {
	        if (input == null || input.isEmpty()) {
	            return "";
	        }
	        StringBuilder compressed = new StringBuilder();
	        char currentChar = input.charAt(0);
	        int count = 1;
	        
	        for (int i = 1; i < input.length(); i++) {
	            if (input.charAt(i) == currentChar) {
	                count++;
	            } else {
	                compressed.append(count).append(currentChar);
	                currentChar = input.charAt(i);
	                count = 1;
	            }
	        }
	        compressed.append(count).append(currentChar);
	        return compressed.toString();
	    }
	}

