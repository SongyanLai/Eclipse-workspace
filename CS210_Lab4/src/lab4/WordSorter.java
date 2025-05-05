package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WordSorter {

    public static void main(String[] args) {
        // ��ȡ����
        // Read input
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // ��ȡ������ Read the number of words
        scanner.nextLine(); // ������з� Clear the newline character

        ArrayList<String> words = new ArrayList<>(); // ����һ���ַ����б� Create a list to store words

        // ���ж�ȡ���ʲ������б�
        // Read each word and add to the list
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        // �Ե��ʽ������� Sort the words
        sortWords(words);

        // ��ӡ������ Print sorted result
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    /**
     * ���յ��ʳ��Ⱥ���ĸ˳�������б�
     * Sort the list of words by length and then by alphabetical order
     * 
     * @param words Ҫ����ĵ����б� List of words to sort
     */
    public static void sortWords(ArrayList<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                // ���ȸ��ݳ��Ƚ��бȽ� First, compare by length
                if (word1.length() != word2.length()) {
                    return word1.length() - word2.length();
                }
                // ���������ͬ������ĸ˳��Ƚ� If lengths are the same, compare alphabetically
                return word1.compareTo(word2);
            }
        });
    }
}


