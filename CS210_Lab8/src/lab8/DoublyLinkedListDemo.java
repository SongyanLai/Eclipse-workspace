package lab8;

// Class representing a node in the doubly linked list
class DoublyLink {
    String data; // Data stored in the node
    DoublyLink next; // Pointer to the next node
    DoublyLink prev; // Pointer to the previous node

    // Constructor to initialize the node with provided data
    public DoublyLink(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Class representing a doubly linked list
class DoublyLinkedList {
    private DoublyLink head; // Reference to the head node of the list

    // Adds a new node with the given data to the end of the list
    public void add(String data) {
        DoublyLink newNode = new DoublyLink(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
        } else {
            DoublyLink current = head;
            while (current.next != null) { // Traverse to the end of the list
                current = current.next;
            }
            current.next = newNode; // Set the new node as the next of the last node
            newNode.prev = current; // Set the last node as the previous of the new node
        }
    }

    // Creates a loop in the list by connecting the last node to a node at the specified position
    public void createLoop(int position) {
        if (position < 1) {
            System.out.println("Invalid position for creating a loop!");
            return;
        }

        DoublyLink loopNode = head;
        int count = 1;

        // Traverse the list to find the node at the specified position
        while (loopNode != null && count < position) {
            loopNode = loopNode.next;
            count++;
        }

        if (loopNode == null) {
            System.out.println("Position exceeds the size of the list! Loop not created.");
            return;
        }

        DoublyLink current = head;
        while (current.next != null) { // Traverse to the last node
            current = current.next;
        }

        current.next = loopNode; // Create the loop
        loopNode.prev = current; // Set the previous pointer for reverse connection
        System.out.println("Loop created! The last node now points to: " + loopNode.data);
    }

    // Detects a loop in the list using Floyd's Cycle Detection Algorithm
    public void detectAndFixLoop() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        DoublyLink slow = head; // Slow pointer moves one step at a time
        DoublyLink fast = head; // Fast pointer moves two steps at a time

        // Detect loop using the two-pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                System.out.println("Loop detected!");
                fixLoop(slow); // Call method to fix the loop
                return;
            }
        }

        System.out.println("No loop detected in the list.");
    }

    // Fixes the loop by identifying its starting point
    private void fixLoop(DoublyLink meetingPoint) {
        DoublyLink start = head;

        // Find the starting point of the loop
        while (start != meetingPoint) {
            start = start.next;
            meetingPoint = meetingPoint.next;
        }

        System.out.println("The loop starts at the node with data: " + start.data);

        // Break the loop by setting the next of the last node to null
        DoublyLink current = start;
        while (current.next != start) {
            current = current.next;
        }

        current.next = null; // Break the forward loop
        start.prev = null; // Break the backward connection
        System.out.println("Loop fixed.");
    }

    // Prints the list's data
    public void printList() {
        DoublyLink current = head;

        if (current == null) {
            System.out.println("The list is empty!");
            return;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate the doubly linked list with loop handling
public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Add nodes to the list
        list.add("Node1");
        list.add("Node2");
        list.add("Node3");
        list.add("Node4");
        list.add("Node5");
        list.add("Node6");

        // Print the initial list
        System.out.println("Initial List:");
        list.printList();

        // Create a loop by connecting the last node to the 3rd node
        list.createLoop(3);

        // Detect and fix the loop
        list.detectAndFixLoop();

        // Print the list after fixing the loop
        System.out.println("List after fixing the loop:");
        list.printList();
    }
}
