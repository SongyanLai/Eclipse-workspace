package lab5;

import java.util.Scanner;

public class DirectionReversal {

    // Custom stack class for managing direction instructions
    public static class MyStack {
        private Node top; // ջ��Ԫ�� Top element of the stack

        // ջ�Ľڵ���
        // Node class for the stack
        private class Node {
            String value;
            Node next;

            Node(String value) {
                this.value = value;
            }
        }

        // ���췽������ʼ��ջ
        // Constructor to initialize the stack
        public MyStack() {
            top = null;
        }

        // ��ָ������ջ��
        // Method to push instructions onto the stack
        public void push(String direction) {
            Node newNode = new Node(direction);
            newNode.next = top;
            top = newNode;
        }

        // ����ջ��ָ�����
        // Method to pop the top instruction from the stack
        public String pop() {
            if (top == null) {
                return null; // ���� null ��ʾջΪ�� Return null if stack is empty
            }
            String value = top.value;
            top = top.next;
            return value;
        }

        // �ж�ջ�Ƿ�Ϊ��
        // Method to check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }
    }

    // �Զ��� DirectionStack �࣬ʹ�� MyStack ��Ϊ�ڲ�ջʵ��
    // Custom DirectionStack class using MyStack as the internal stack implementation
    public static class DirectionStack {
        private MyStack stack;

        // ���췽������ʼ��ջ
        // Constructor to initialize the stack
        public DirectionStack() {
            stack = new MyStack();
        }

        // ��ָ������ջ��
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

        // ��ӡ���շ�ת��ָ������
        // Method to print the final reversed sequence of instructions
        public void printReversedDirections() {
            while (!stack.isEmpty()) {
                System.out.println(reverseDirection(stack.pop()));
            }
        }
    }

    // �Զ�������࣬���ڰ�ԭʼ˳���ӡָ��
    // Custom queue class to print instructions in the original order
    public static class MyQueue {
        private Node front, rear; // ���׺Ͷ�βԪ�� Front and rear elements of the queue

        // ���еĽڵ���
        // Node class for the queue
        private class Node {
            String value;
            Node next;

            Node(String value) {
                this.value = value;
                this.next = null;
            }
        }

        // ���췽������ʼ������
        // Constructor to initialize the queue
        public MyQueue() {
            front = rear = null;
        }

        // ��Ӳ�������ָ������β
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

        // ��˳���ӡ����ָ��
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
                // ����Чָ������ջ�Ͷ���
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
