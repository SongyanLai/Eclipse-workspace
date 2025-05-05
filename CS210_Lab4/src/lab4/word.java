package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class word {

    public static void main(String[] args) {
        // Read input
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read the number of words
        scanner.nextLine(); // Clear the newline character

        ArrayList<String> words = new ArrayList<>(); // Create a list to store words

        // Read each word and add to the list
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        // Sort words in normal order and display the result
        sortWords(words);
        System.out.println("Sorted in normal order:");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        // Sort words in reverse order and display the result
        sortWordsReversed(words);
        System.out.println("Sorted in reverse order:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    /**
     * Sort the list of words by length and then by alphabetical order
     * 
     * @param words List of words to sort
     */
    
    public static void sortWords(ArrayList<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                // First, compare by length
                if (word1.length() != word2.length()) {
                    return word1.length() - word2.length();
                }
                // If lengths are the same, compare alphabetically
                return word1.compareTo(word2);
            }
        });
    }

    /**
     * Sort the list of words by length in descending order and then by reverse alphabetical order
     * 
     * @param words List of words to sort in reverse
     */
    
    public static void sortWordsReversed(ArrayList<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                // First, compare by length in descending order
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                }
                // If lengths are the same, compare in reverse alphabetical order
                return word2.compareTo(word1);
            }
        });
    }
}
