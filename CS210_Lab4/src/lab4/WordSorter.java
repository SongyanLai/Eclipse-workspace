package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WordSorter {

    public static void main(String[] args) {
        // 读取输入
        // Read input
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取单词数 Read the number of words
        scanner.nextLine(); // 清除换行符 Clear the newline character

        ArrayList<String> words = new ArrayList<>(); // 创建一个字符串列表 Create a list to store words

        // 逐行读取单词并加入列表
        // Read each word and add to the list
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        // 对单词进行排序 Sort the words
        sortWords(words);

        // 打印排序结果 Print sorted result
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    /**
     * 按照单词长度和字母顺序排序列表
     * Sort the list of words by length and then by alphabetical order
     * 
     * @param words 要排序的单词列表 List of words to sort
     */
    public static void sortWords(ArrayList<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                // 首先根据长度进行比较 First, compare by length
                if (word1.length() != word2.length()) {
                    return word1.length() - word2.length();
                }
                // 如果长度相同，则按字母顺序比较 If lengths are the same, compare alphabetically
                return word1.compareTo(word2);
            }
        });
    }
}


