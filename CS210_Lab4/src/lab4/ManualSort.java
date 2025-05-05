package lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class ManualSort {

    public static void main(String[] args) {
        // ��ȡ�û�����
        Scanner scanner = new Scanner(System.in);
        System.out.print("�����뵥�ʵ�����: ");
        int n = scanner.nextInt(); // ��ȡ��������
        scanner.nextLine(); // ��ջ��з�

        ArrayList<String> words = new ArrayList<>(); // �����洢���ʵ��б�

        // ��ȡÿ������
        System.out.println("�����뵥��:");
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        // ���������򵥴�
        bubbleSort(words); // �Զ���ð������

        // ���������
        System.out.println("�����������ĵ���:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    /**
     * �Զ���ð�����򣬰��������ȡ���ĸ˳���֮���򵥴�
     *
     * @param words Ҫ����ĵ����б�
     */
    public static void bubbleSort(ArrayList<String> words) {
        int n = words.size(); // ��ȡ�б��С

        // ð������
        for (int i = 0; i < n - 1; i++) { // ���ѭ������������
            for (int j = 0; j < n - 1 - i; j++) { // �ڲ�ѭ���Ƚ�����Ԫ��
                // �Ƚϵ�ǰ���ʺ���һ������
                String word1 = words.get(j);
                String word2 = words.get(j + 1);

                // �ж��Ƿ���Ҫ����˳��
                if (shouldSwap(word1, word2)) {
                    // �����������ʵ�λ��
                    words.set(j, word2);
                    words.set(j + 1, word1);
                }
            }
        }
    }

    /**
     * �ж����������Ƿ���Ҫ����˳��
     *
     * @param word1 ��һ������
     * @param word2 �ڶ�������
     * @return �����Ҫ����˳�򷵻� true�����򷵻� false
     */
    public static boolean shouldSwap(String word1, String word2) {
        // �����ȱȽ�
        if (word1.length() != word2.length()) {
            return word1.length() > word2.length(); // ���Ƚϴ�����ں���
        }

        // ������ͬʱ����ĸ˳��Ƚ�
        return word1.compareTo(word2) > 0; // ��ĸ˳��ϴ�����ں���
    }
}
