package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LeftHandWordFinder {

    public static void main(String[] args) {
        File file = new File("D:\\wordFrequencies.txt"); // Update the file path
        List<WordFrequency> leftHandWords = new ArrayList<>();
        Set<Character> allowedChars = new HashSet<>();
        // Add all allowed lowercase letters for left-hand typing
        char[] allowedLetters = {'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v', 'b'};
        for (char c : allowedLetters) {
            allowedChars.add(c);
        }

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    continue; // Skip invalid lines
                }
                String word = parts[0];
                String freqStr = parts[1];
                boolean isValid = true;
                // Check each character in the word
                for (char c : word.toCharArray()) {
                    if (!allowedChars.contains(Character.toLowerCase(c))) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    try {
                        int frequency = Integer.parseInt(freqStr);
                        leftHandWords.add(new WordFrequency(word, frequency));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid frequency for word: " + word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found");
            return;
        }

        // Sort the list in descending order of frequency
        Collections.sort(leftHandWords);

        // Print the sorted words
        System.out.println("Valid left-hand words sorted by frequency (descending):");
        System.out.println("Total words found: " + leftHandWords.size());
        for (WordFrequency wf : leftHandWords) {
            System.out.printf("%s %d%n", wf.word, wf.frequency);
        }
    }

    static class WordFrequency implements Comparable<WordFrequency> {
        String word;
        int frequency;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(WordFrequency other) {
            return Integer.compare(other.frequency, this.frequency); // Descending order
        }
    }
}