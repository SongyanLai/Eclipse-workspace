package lab5;

import java.util.Scanner;

public class DirectionReversal {

    // Custom stack class for managing direction instructions
    public static class MyStack {
        private Node top; // 栈顶元素 Top element of the stack

        // 栈的节点类
        // Node class for the stack
        private class Node {
            String value;
            Node next;

            Node(String value) {
                this.value = value;
            }
        }

        // 构造方法，初始化栈
        // Constructor to initialize the stack
        public MyStack() {
            top = null;
        }

        // 将指令推入栈中
        // Method to push instructions onto the stack
        public void push(String direction) {
            Node newNode = new Node(direction);
            newNode.next = top;
            top = newNode;
        }

        // 弹出栈顶指令并返回
        // Method to pop the top instruction from the stack
        public String pop() {
            if (top == null) {
                return null; // 返回 null 表示栈为空 Return null if stack is empty
            }
            String value = top.value;
            top = top.next;
            return value;
        }

        // 判断栈是否为空
        // Method to check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }
    }

    // 自定义 DirectionStack 类，使用 MyStack 作为内部栈实现
    // Custom DirectionStack class using MyStack as the internal stack implementation
    public static class DirectionStack {
        private MyStack stack;

        // 构造方法，初始化栈
        // Constructor to initialize the stack
        public DirectionStack() {
            stack = new MyStack();
        }

        // 将指令推入栈中
        // Method to push instructions onto the stack
        public void push(String direction) {
            stack.push(direction);
        }

        // Method to handle "Go Back" by undoing the last direction
        public void goBack() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        // Method to reverse directions: North <-> South, East <-> West
        private String reverseDirection(String direction) {
            switch (direction) {
                case "Go North": return "Go South";
                case "Go South": return "Go North";
                case "Go East": return "Go West";
                case "Go West": return "Go East";
                default: return "error";
            }
        }

        // 打印最终反转的指令序列
        // Method to print the final reversed sequence of instructions
        public void printReversedDirections() {
            while (!stack.isEmpty()) {
                System.out.println(reverseDirection(stack.pop()));
            }
        }
    }

    // 自定义队列类，用于按原始顺序打印指令
    // Custom queue class to print instructions in the original order
    public static class MyQueue {
        private Node front, rear; // 队首和队尾元素 Front and rear elements of the queue

        // 队列的节点类
        // Node class for the queue
        private class Node {
            String value;
            Node next;

            Node(String value) {
                this.value = value;
                this.next = null;
            }
        }

        // 构造方法，初始化队列
        // Constructor to initialize the queue
        public MyQueue() {
            front = rear = null;
        }

        // 入队操作，将指令加入队尾
        // Method to add instructions to the end of the queue
        public void enqueue(String direction) {
            Node newNode = new Node(direction);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        // 按顺序打印所有指令
        // Method to print all instructions in order
        public void printOriginalDirections() {
            Node current = front;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectionStack directionStack = new DirectionStack();
        MyQueue directionQueue = new MyQueue();

        // Loop to read input until encountering "Arrived"
        while (scanner.hasNextLine()) {
            String instruction = scanner.nextLine();

            if (instruction.equals("Arrived")) {
                break; // End input
            } else if (instruction.equals("Go Back")) {
                // Undo the last instruction when "Go Back" is encountered
                directionStack.goBack();
                directionQueue.enqueue(instruction);
            } else {
                // 将有效指令推入栈和队列
                // Push valid instructions onto the stack and enqueue them
                directionStack.push(instruction);
                directionQueue.enqueue(instruction);
            }
        }

        System.out.println("Original Directions:");
        directionQueue.printOriginalDirections();

        System.out.println("\nReversed Directions:");
        directionStack.printReversedDirections();

        scanner.close();
    }
}
