package lab6;

import java.util.Scanner;

public class CustomPriorityQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the priority queue
        System.out.println("Enter the size of the priority queue:");
        int queueSize = scanner.nextInt();
        PriorityQueue priorityQueue = new PriorityQueue(queueSize);

        // Prompt the user to enter numbers or commands
        System.out.println("Enter numbers or 'REMOVE'. Type 'STOP' to end:");
        while (true) {
            String input = scanner.next();

            if (input.equalsIgnoreCase("STOP")) {
                // End the loop when the user enters 'STOP'
                break;
            } else if (input.equalsIgnoreCase("REMOVE")) {
                // Remove the highest priority element and reinsert it at the end
                priorityQueue.removeAndReinsert();
            } else {
                try {
                    // Try to convert the input to an integer and insert it into the priority queue
                    int value = Integer.parseInt(input);
                    priorityQueue.insert(value);
                } catch (NumberFormatException e) {
                    // Prompt the user when the input is not a valid number
                    System.out.println("Invalid input. Please enter a number or 'REMOVE'.");
                }
            }
        }

        // Print the final contents of the priority queue
        System.out.println("Final Priority Queue contents:");
        priorityQueue.printQueue();

        scanner.close();
    }
}

class PriorityQueue {
    private int[] queue;  // Array to store the priority queue
    private int maxSize;  // Maximum size of the priority queue
    private int currentSize;  // Current size of the priority queue

    public PriorityQueue(int size) {
        this.maxSize = size;
        this.queue = new int[size];
        this.currentSize = 0;  // Initialize currentSize to 0
    }

    // Insert an element into the priority queue in sorted order
    public void insert(int value) {
        if (isFull()) {
            // Prompt the user when the queue is full and cannot insert
            System.out.println("Priority Queue is full. Cannot insert " + value);
            return;
        }

        int i;
        // Move elements to find the correct position for the new element
        for (i = currentSize - 1; i >= 0; i--) {
            if (queue[i] > value) {
                queue[i + 1] = queue[i];
            } else {
                break;
            }
        }
        // Insert the new element into the correct position
        queue[i + 1] = value;
        currentSize++;
    }

    // Remove the highest priority (smallest) element and reinsert it at the end
    public void removeAndReinsert() {
        if (isEmpty()) {
            // Prompt the user when the queue is empty and cannot remove
            System.out.println("Priority Queue is empty. Cannot remove.");
            return;
        }

        // Remove the smallest element
        int removedValue = queue[0];
        for (int i = 0; i < currentSize - 1; i++) {
            queue[i] = queue[i + 1];
        }
        currentSize--;

        // Increment the removed value to be greater than the current maximum
        int newValue = getMaxValue() + 3;  // Increment the removed value sufficiently
        insert(newValue);

        System.out.println("Removed " + removedValue + " and reinserted as " + newValue);
    }

    // Get the maximum value in the queue
    private int getMaxValue() {
        if (isEmpty()) {
            return 0;  // Default maximum value when the queue is empty
        }
        return queue[currentSize - 1];  // The largest value is at the end of the sorted array
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Print the contents of the priority queue
    public void printQueue() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queue[i]);
            if (i < currentSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
