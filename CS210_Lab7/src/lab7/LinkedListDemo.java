package lab7;

import java.util.Scanner;

// Class representing a single node in the linked list
class Link {
    String name; // Person's name
    int age; // Person's age
    String degree; // Degree pursued by the person
    int yearOfStudy; // Current year of study
    Link next; // Reference to the next node

    // Constructor to initialize the node with provided attributes
    public Link(String name, int age, String degree, int yearOfStudy) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.yearOfStudy = yearOfStudy;
        this.next = null;
    }

    // Returns a string representation of the node's data
    @Override
    public String toString() {
        return name + ", " + age + ", " + degree + ", " + yearOfStudy;
    }
}

// Class representing a linked list
class LinkedList {
    private Link head; // Reference to the head node of the list

    // Adds a new node with the given attributes to the end of the list
    public void add(String name, int age, String degree, int yearOfStudy) {
        Link newLink = new Link(name, age, degree, yearOfStudy);
        if (head == null) {
            head = newLink; // If the list is empty, set the new node as the head
        } else {
            Link current = head;
            while (current.next != null) { // Traverse to the end of the list
                current = current.next;
            }
            current.next = newLink; // Append the new node
        }
    }

    // Inserts a new node at the specified position in the linked list
    public void insertAtPosition(String name, int age, String degree, int yearOfStudy, int position) {
        Link newLink = new Link(name, age, degree, yearOfStudy);

        if (position < 1) {
            System.out.println("Position must be 1 or greater!");
            return;
        }

        if (position == 1) {
            newLink.next = head; // Insert at the beginning
            head = newLink;
            return;
        }

        Link current = head;
        int count = 1;

        // Traverse the list to find the insertion point
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position exceeds the size of the list! Adding at the end.");
            add(name, age, degree, yearOfStudy); // Add at the end if position exceeds list size
            return;
        }

        // Insert the new node
        newLink.next = current.next;
        current.next = newLink;
    }

    // Prints all nodes in the linked list
    public void printList() {
        Link current = head;
        if (current == null) {
            System.out.println("The list is empty!");
            return;
        }
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    // Finds and prints a node that matches the specified attribute and value
    public void findAndPrint(String attribute, String value) {
        Link current = head;
        while (current != null) {
            if ((attribute.equalsIgnoreCase("name") && current.name.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("age") && Integer.toString(current.age).equals(value)) ||
                (attribute.equalsIgnoreCase("degree") && current.degree.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(current.yearOfStudy).equals(value))) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }
        System.out.println("No matching node found!");
    }

    // Removes the first node that matches the specified attribute and value
    public void remove(String attribute, String value) {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        // Check if the head node needs to be removed
        if ((attribute.equalsIgnoreCase("name") && head.name.equalsIgnoreCase(value)) ||
            (attribute.equalsIgnoreCase("age") && Integer.toString(head.age).equals(value)) ||
            (attribute.equalsIgnoreCase("degree") && head.degree.equalsIgnoreCase(value)) ||
            (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(head.yearOfStudy).equals(value))) {
            head = head.next; // Remove the head node
            return;
        }

        // Traverse the list to find and remove the matching node
        Link current = head;
        while (current.next != null) {
            if ((attribute.equalsIgnoreCase("name") && current.next.name.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("age") && Integer.toString(current.next.age).equals(value)) ||
                (attribute.equalsIgnoreCase("degree") && current.next.degree.equalsIgnoreCase(value)) ||
                (attribute.equalsIgnoreCase("yearOfStudy") && Integer.toString(current.next.yearOfStudy).equals(value))) {
                current.next = current.next.next; // Skip the matching node
                return;
            }
            current = current.next;
        }

        System.out.println("No matching node found!");
    }
}

// Main class to handle user input and linked list operations
public class LinkedListDemo {

    // Method to process user commands for printing, removing, adding, or finding nodes
    public void processCommand(String action, LinkedList list, Scanner scanner) {
        if (action.equalsIgnoreCase("PrintList")) {
            list.printList(); // Print the entire list
        } else if (action.equalsIgnoreCase("Add")) {
            System.out.println("Enter name:");
            String name = scanner.nextLine().trim();

            System.out.println("Enter age:");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Enter degree:");
            String degree = scanner.nextLine().trim();

            System.out.println("Enter year of study:");
            int yearOfStudy = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Enter position in the list:");
            int position = Integer.parseInt(scanner.nextLine().trim());

            list.insertAtPosition(name, age, degree, yearOfStudy, position); // Add node at position
        } else if (action.equalsIgnoreCase("Find")) {
            System.out.println("Enter attribute (name, age, degree, yearOfStudy):");
            String attribute = scanner.nextLine().trim();

            System.out.println("Enter value for the attribute:");
            String value = scanner.nextLine().trim();

            list.findAndPrint(attribute, value); // Find and print node by attribute
        } else if (action.equalsIgnoreCase("Remove")) {
            System.out.println("Enter attribute (name, age, degree, yearOfStudy):");
            String attribute = scanner.nextLine().trim();

            System.out.println("Enter value for the attribute:");
            String value = scanner.nextLine().trim();

            list.remove(attribute, value); // Remove node by attribute
        } else {
            System.out.println("Unknown action! Please use 'PrintList', 'Add', 'Find', or 'Remove'.");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        // Initialize the linked list with some sample data
        list.add("Bunny", 26, "CSSE", 2);
        list.add("Larry", 18, "ARTS", 1);
        list.add("Steve", 32, "ComputationalThinking", 4);

        LinkedListDemo demo = new LinkedListDemo();

        System.out.println("Welcome! Enter commands to interact with the linked list.");
        while (true) {
            System.out.println("\nAvailable actions: 'PrintList', 'Add', 'Find', 'Remove'");
            String action = scanner.nextLine().trim();

            demo.processCommand(action, list, scanner);

            System.out.println("\nDo you want to continue? (Y/N):");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
