package lab5;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // 压入元素到栈中
        stack.push(20);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(30);
        
        // 弹出栈顶元素，并删除
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        
        // 查看栈顶元素，但不删除
        int peekedElement = stack.peek();
        System.out.println("Peeked element: " + peekedElement);
        
        // 判断栈是否为空
        boolean empty = stack.isEmpty();
        System.out.println("Is the stack empty? " + empty);
        
        // 搜索元素在栈中的位置
        int position = stack.search(20);
        System.out.println("Position of 20 in the stack: " + position);
    }
}

