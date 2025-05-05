package lab8;
import java.util.*;
import java.io.*;

public class BoggleBoard {
    private static String[][] board = new String[4][4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 16 letters, separated by spaces:");
        String input = scanner.nextLine();
        String[] letters = input.trim().split("\\s+");

        if (letters.length != 16) {
            System.out.println("Error: Enter exactly 16 letters");
            return;
        }

        // Fill the board with letters (case-insensitive)
        for (int i = 0; i < 16; i++) {
            int row = i / 4;
            int col = i % 4;
            board[row][col] = letters[i];
        }

        // Print the board
        System.out.println("Here is the Boggle Board:");
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(board[row][col].toUpperCase() + " ");
            }
            System.out.println();
        }

        // Load dictionary and find words
        Set<String> dictionary = loadDictionary("D:\\words.txt");
        Set<String> foundWords = new HashSet<>();

        // Search from each cell
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                boolean[][] visited = new boolean[4][4];
                dfs(row, col, visited, "", dictionary, foundWords);
            }
        }

        // Sort and display results
        List<String> sortedWords = new ArrayList<>(foundWords);
        Collections.sort(sortedWords);
        System.out.println("\nFound words:");
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }

    private static Set<String> loadDictionary(String filename) {
        Set<String> words = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (line.length() >= 3) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
            System.exit(1);
        }
        return words;
    }

    private static void dfs(int row, int col, boolean[][] visited, String currentWord,
                            Set<String> dictionary, Set<String> foundWords) {
        // Check boundaries
        if (row < 0 || row >= 4 || col < 0 || col >= 4) return;
        
        // Check if cell already visited
        if (visited[row][col]) return;

        // Create a copy of visited to avoid modifying the original
        boolean[][] newVisited = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(visited[i], 0, newVisited[i], 0, 4);
        }
        newVisited[row][col] = true;

        // Build current word (convert to lowercase for dictionary match)
        String newWord = currentWord + board[row][col].toLowerCase();

        // Check if word is valid
        if (newWord.length() >= 3 && dictionary.contains(newWord)) {
            foundWords.add(newWord);
        }

        // Explore all 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            dfs(newRow, newCol, newVisited, newWord, dictionary, foundWords);
        }
    }
}