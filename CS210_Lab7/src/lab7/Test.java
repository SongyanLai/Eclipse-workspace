package lab7;

import java.util.Scanner;

// 表示链表中单个节点的类
class Link {
    String name; // 人员姓名
    int age; // 人员年龄
    String degree; // 所学学位
    int yearOfStudy; // 学习年份
    Link next; // 指向下一个节点的引用

    // 构造方法，用于初始化节点的属性
    public Link(String name, int age, String degree, int yearOfStudy) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.yearOfStudy = yearOfStudy;
        this.next = null; // 默认情况下，next 设为 null
    }

    // 重写 toString 方法，返回节点数据的字符串表示形式
    @Override
    public String toString() {
        return name + ", " + age + ", " + degree + ", " + yearOfStudy;
    }
}

// 表示链表的类
class LinkedList {
    private Link head; // 链表头节点的引用

    // 向链表末尾添加一个新的节点
    public void add(String name, int age, String degree, int yearOfStudy) {
        Link newLink = new Link(name, age, degree, yearOfStudy);
        if (head == null) {
            head = newLink; // 如果链表为空，则将新节点设为头节点
        } else {
            Link current = head;
            while (current.next != null) { // 遍历链表找到最后一个节点
                current = current.next;
            }
            current.next = newLink; // 将新节点添加到链表末尾
        }
    }

    // 打印链表中所有节点的信息
    public void printList() {
        Link current = head;
        if (current == null) {
            System.out.println("链表为空！");
            return;
        }
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    // 根据属性和值查找并打印符合条件的节点
    public void findAndPrint(String attribute, String value) {
        Link current = head;
        while (current != null) {
            // 检查当前节点是否匹配给定的属性和值
            if ((attribute.equalsIgnoreCase("name") && current.name.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("age") && Integer.toString(current.age).equals(value)) ||
                (attribute.equalsIgnoreCase("degree") && current.degree.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(current.yearOfStudy).equals(value))) {
                System.out.println(current.toString());
                return; // 找到并打印后返回
            }
            current = current.next;
        }
        System.out.println("未找到匹配的节点！");
    }

    // 根据属性和值移除第一个符合条件的节点
    public void remove(String attribute, String value) {
        if (head == null) {
            System.out.println("链表为空！");
            return;
        }

        // 检查是否需要移除头节点
        if ((attribute.equalsIgnoreCase("name") && head.name.equalsIgnoreCase(value)) ||
            (attribute.equalsIgnoreCase("age") && Integer.toString(head.age).equals(value)) ||
            (attribute.equalsIgnoreCase("degree") && head.degree.equalsIgnoreCase(value)) ||
            (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(head.yearOfStudy).equals(value))) {
            head = head.next; // 移除头节点
            return;
        }

        // 遍历链表找到并移除匹配的节点
        Link current = head;
        while (current.next != null) {
            // 检查当前节点的下一个节点是否匹配
            if ((attribute.equalsIgnoreCase("name") && current.next.name.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("age") && Integer.toString(current.next.age).equals(value)) ||
                (attribute.equalsIgnoreCase("degree") && current.next.degree.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(current.next.yearOfStudy).equals(value))) {
                current.next = current.next.next; // 跳过匹配的节点
                return;
            }
            current = current.next;
        }

        System.out.println("未找到匹配的节点！");
    }
}

// 处理用户输入和链表操作的主类
public class Test {

    // 处理用户命令的方法，用于打印、移除或打印整个链表
    public void processCommand(String attribute, String value, String action, LinkedList list) {
        if (attribute.equalsIgnoreCase("PrintList")) {
            // 特殊情况：打印整个链表
            list.printList();
        } else if (action.equalsIgnoreCase("print")) {
            // 根据指定的属性和值查找并打印节点
            list.findAndPrint(attribute, value);
        } else if (action.equalsIgnoreCase("remove")) {
            // 根据指定的属性和值移除节点
            list.remove(attribute, value);
        } else {
            // 处理无效操作
            System.out.println("未知操作！请使用 'print', 'remove' 或 'PrintList'。");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        // 初始化链表，添加一些样本数据
        list.add("Bunny", 26, "CSSE", 2);
        list.add("Larry", 18, "ARTS", 1);
        list.add("Steve", 32, "ComputationalThinking", 4);

        Test demo = new Test();

        System.out.println("欢迎使用链表管理程序！请输入命令与链表进行交互。");
        while (true) {
            System.out.println("\n输入 'PrintList' 以打印所有节点，或按如下格式指定操作：");
            System.out.println("1) 属性（name, age, degree, yearOfStudy）或 'PrintList'");
            String attribute = scanner.nextLine().trim();

            if (attribute.equalsIgnoreCase("PrintList")) {
                // 调用打印整个链表的方法
                demo.processCommand(attribute, null, null, list);
                continue;
            }

            System.out.println("2) 指定属性的值：");
            String value = scanner.nextLine().trim();

            System.out.println("3) 操作（print/remove）：");
            String action = scanner.nextLine().trim();

            // 使用用户输入的参数调用方法
            demo.processCommand(attribute, value, action, list);

            System.out.println("\n是否继续操作？（Y/N）：");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        scanner.close();
        System.out.println("再见！");
    }
}
