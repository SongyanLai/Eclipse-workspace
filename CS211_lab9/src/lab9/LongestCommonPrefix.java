package lab9;

import java.util.Scanner;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter words separated by spaces:");
        String inputLine = scanner.nextLine();

        // Split the line into an array of words
        String[] words = inputLine.trim().split("\\s+");

        String result = findLongestCommonPrefix(words);

        System.out.println("Longest Common Prefix: " + result);

    }

    public static String findLongestCommonPrefix(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        String firstStr = array[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char currentChar = firstStr.charAt(i);
            for (int j = 1; j < array.length; j++) {
                String currentWord = array[j];
                if (i >= currentWord.length() || currentWord.charAt(i) != currentChar) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
}
