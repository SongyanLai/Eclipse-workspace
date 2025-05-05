package lab5;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // ѹ��Ԫ�ص�ջ��
        stack.push(20);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(30);
        
        // ����ջ��Ԫ�أ���ɾ��
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        
        // �鿴ջ��Ԫ�أ�����ɾ��
        int peekedElement = stack.peek();
        System.out.println("Peeked element: " + peekedElement);
        
        // �ж�ջ�Ƿ�Ϊ��
        boolean empty = stack.isEmpty();
        System.out.println("Is the stack empty? " + empty);
        
        // ����Ԫ����ջ�е�λ��
        int position = stack.search(20);
        System.out.println("Position of 20 in the stack: " + position);
    }
}

