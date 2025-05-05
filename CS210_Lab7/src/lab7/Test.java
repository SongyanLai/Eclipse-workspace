package lab7;

import java.util.Scanner;

// ��ʾ�����е����ڵ����
class Link {
    String name; // ��Ա����
    int age; // ��Ա����
    String degree; // ��ѧѧλ
    int yearOfStudy; // ѧϰ���
    Link next; // ָ����һ���ڵ������

    // ���췽�������ڳ�ʼ���ڵ������
    public Link(String name, int age, String degree, int yearOfStudy) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.yearOfStudy = yearOfStudy;
        this.next = null; // Ĭ������£�next ��Ϊ null
    }

    // ��д toString ���������ؽڵ����ݵ��ַ�����ʾ��ʽ
    @Override
    public String toString() {
        return name + ", " + age + ", " + degree + ", " + yearOfStudy;
    }
}

// ��ʾ�������
class LinkedList {
    private Link head; // ����ͷ�ڵ������

    // ������ĩβ���һ���µĽڵ�
    public void add(String name, int age, String degree, int yearOfStudy) {
        Link newLink = new Link(name, age, degree, yearOfStudy);
        if (head == null) {
            head = newLink; // �������Ϊ�գ����½ڵ���Ϊͷ�ڵ�
        } else {
            Link current = head;
            while (current.next != null) { // ���������ҵ����һ���ڵ�
                current = current.next;
            }
            current.next = newLink; // ���½ڵ���ӵ�����ĩβ
        }
    }

    // ��ӡ���������нڵ����Ϣ
    public void printList() {
        Link current = head;
        if (current == null) {
            System.out.println("����Ϊ�գ�");
            return;
        }
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    // �������Ժ�ֵ���Ҳ���ӡ���������Ľڵ�
    public void findAndPrint(String attribute, String value) {
        Link current = head;
        while (current != null) {
            // ��鵱ǰ�ڵ��Ƿ�ƥ����������Ժ�ֵ
            if ((attribute.equalsIgnoreCase("name") && current.name.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("age") && Integer.toString(current.age).equals(value)) ||
                (attribute.equalsIgnoreCase("degree") && current.degree.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(current.yearOfStudy).equals(value))) {
                System.out.println(current.toString());
                return; // �ҵ�����ӡ�󷵻�
            }
            current = current.next;
        }
        System.out.println("δ�ҵ�ƥ��Ľڵ㣡");
    }

    // �������Ժ�ֵ�Ƴ���һ�����������Ľڵ�
    public void remove(String attribute, String value) {
        if (head == null) {
            System.out.println("����Ϊ�գ�");
            return;
        }

        // ����Ƿ���Ҫ�Ƴ�ͷ�ڵ�
        if ((attribute.equalsIgnoreCase("name") && head.name.equalsIgnoreCase(value)) ||
            (attribute.equalsIgnoreCase("age") && Integer.toString(head.age).equals(value)) ||
            (attribute.equalsIgnoreCase("degree") && head.degree.equalsIgnoreCase(value)) ||
            (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(head.yearOfStudy).equals(value))) {
            head = head.next; // �Ƴ�ͷ�ڵ�
            return;
        }

        // ���������ҵ����Ƴ�ƥ��Ľڵ�
        Link current = head;
        while (current.next != null) {
            // ��鵱ǰ�ڵ����һ���ڵ��Ƿ�ƥ��
            if ((attribute.equalsIgnoreCase("name") && current.next.name.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("age") && Integer.toString(current.next.age).equals(value)) ||
                (attribute.equalsIgnoreCase("degree") && current.next.degree.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(current.next.yearOfStudy).equals(value))) {
                current.next = current.next.next; // ����ƥ��Ľڵ�
                return;
            }
            current = current.next;
        }

        System.out.println("δ�ҵ�ƥ��Ľڵ㣡");
    }
}

// �����û�������������������
public class Test {

    // �����û�����ķ��������ڴ�ӡ���Ƴ����ӡ��������
    public void processCommand(String attribute, String value, String action, LinkedList list) {
        if (attribute.equalsIgnoreCase("PrintList")) {
            // �����������ӡ��������
            list.printList();
        } else if (action.equalsIgnoreCase("print")) {
            // ����ָ�������Ժ�ֵ���Ҳ���ӡ�ڵ�
            list.findAndPrint(attribute, value);
        } else if (action.equalsIgnoreCase("remove")) {
            // ����ָ�������Ժ�ֵ�Ƴ��ڵ�
            list.remove(attribute, value);
        } else {
            // ������Ч����
            System.out.println("δ֪��������ʹ�� 'print', 'remove' �� 'PrintList'��");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        // ��ʼ���������һЩ��������
        list.add("Bunny", 26, "CSSE", 2);
        list.add("Larry", 18, "ARTS", 1);
        list.add("Steve", 32, "ComputationalThinking", 4);

        Test demo = new Test();

        System.out.println("��ӭʹ������������������������������н�����");
        while (true) {
            System.out.println("\n���� 'PrintList' �Դ�ӡ���нڵ㣬�����¸�ʽָ��������");
            System.out.println("1) ���ԣ�name, age, degree, yearOfStudy���� 'PrintList'");
            String attribute = scanner.nextLine().trim();

            if (attribute.equalsIgnoreCase("PrintList")) {
                // ���ô�ӡ��������ķ���
                demo.processCommand(attribute, null, null, list);
                continue;
            }

            System.out.println("2) ָ�����Ե�ֵ��");
            String value = scanner.nextLine().trim();

            System.out.println("3) ������print/remove����");
            String action = scanner.nextLine().trim();

            // ʹ���û�����Ĳ������÷���
            demo.processCommand(attribute, value, action, list);

            System.out.println("\n�Ƿ������������Y/N����");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        scanner.close();
        System.out.println("�ټ���");
    }
}
