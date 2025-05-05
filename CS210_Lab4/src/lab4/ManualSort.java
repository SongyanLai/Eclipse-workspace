package lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class ManualSort {

    public static void main(String[] args) {
        // 读取用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入单词的数量: ");
        int n = scanner.nextInt(); // 读取单词数量
        scanner.nextLine(); // 清空换行符

        ArrayList<String> words = new ArrayList<>(); // 创建存储单词的列表

        // 读取每个单词
        System.out.println("请输入单词:");
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        // 按规则排序单词
        bubbleSort(words); // 自定义冒泡排序

        // 输出排序结果
        System.out.println("按规则排序后的单词:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    /**
     * 自定义冒泡排序，按长度优先、字母顺序次之排序单词
     *
     * @param words 要排序的单词列表
     */
    public static void bubbleSort(ArrayList<String> words) {
        int n = words.size(); // 获取列表大小

        // 冒泡排序
        for (int i = 0; i < n - 1; i++) { // 外层循环控制总轮数
            for (int j = 0; j < n - 1 - i; j++) { // 内层循环比较相邻元素
                // 比较当前单词和下一个单词
                String word1 = words.get(j);
                String word2 = words.get(j + 1);

                // 判断是否需要交换顺序
                if (shouldSwap(word1, word2)) {
                    // 交换两个单词的位置
                    words.set(j, word2);
                    words.set(j + 1, word1);
                }
            }
        }
    }

    /**
     * 判断两个单词是否需要交换顺序
     *
     * @param word1 第一个单词
     * @param word2 第二个单词
     * @return 如果需要交换顺序返回 true，否则返回 false
     */
    public static boolean shouldSwap(String word1, String word2) {
        // 按长度比较
        if (word1.length() != word2.length()) {
            return word1.length() > word2.length(); // 长度较大的排在后面
        }

        // 长度相同时按字母顺序比较
        return word1.compareTo(word2) > 0; // 字母顺序较大的排在后面
    }
}
