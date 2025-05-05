package project;

import java.util.Scanner;

class Student {  
    String id;  
    String name;  

    public Student(String id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
  
}  
  
class Teacher {  
    String id;  
    String name;  
  
    public Teacher(String id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
  
}  
  
class Course {  
    String code;  
    String name;  
  
    public Course(String code, String name) {  
        this.code = code;  
        this.name = name;  
    }  
  
}
public class f1 {
	private static Student[] students = new Student[100]; // 假设最多100个学生  
    private static Teacher[] teachers = new Teacher[100]; // 假设最多100个教师  
    private static Course[] courses = new Course[100]; // 假设最多100门课程  
    private static int studentCount = 0;  
    private static int teacherCount = 0;  
    private static int courseCount = 0;  
    private static Scanner scanner = new Scanner(System.in);  
  
    public static void main(String[] args) {  
        boolean exit = false;  
        while (!exit) {  
            displayMenu();  
            int choice = scanner.nextInt();  
            switch (choice) {  
                case 1:  
                    addStudent();  
                    break;  
                case 2:  
                    showStudents();  
                    break;  
                case 3:  
                    addTeacher();  
                    break;  
                case 4:  
                    showTeachers();  
                    break;  
                case 5:  
                    addCourse();  
                    break;  
                case 6:  
                    showCourses();  
                    break;  
                case 7:  
                    exit = true;  
                    System.out.println("Exiting the system...");  
                    break;  
                default:  
                    System.out.println("Invalid choice. Please try again.");  
            }  
        }  
        scanner.close();  
    }  
  
    private static void showCourses() {
		// TODO 自动生成的方法存根
		
	}

	private static void addCourse() {
		// TODO 自动生成的方法存根
		
	}

	private static void showTeachers() {
		// TODO 自动生成的方法存根
		
	}

	private static void addTeacher() {
		// TODO 自动生成的方法存根
		
	}

	private static void displayMenu() {  
        System.out.println("--- Education Management System Menu ---");  
        System.out.println("1. Add Student");  
        System.out.println("2. Show Students");  
        System.out.println("3. Add Teacher");  
        System.out.println("4. Show Teachers");  
        System.out.println("5. Add Course");  
        System.out.println("6. Show Courses");  
        System.out.println("7. Exit");  
        System.out.print("Enter your choice: ");  
    }  
  
    private static void addStudent() {  
        if (studentCount >= students.length) {  
            System.out.println("Cannot add more students. Array is full.");  
            return;  
        }  
        System.out.print("Enter student ID: ");  
        String id = scanner.next();  
        System.out.print("Enter student name: ");  
        String name = scanner.next();  
        students[studentCount++] = new Student(id, name);  
        System.out.println("Student added successfully.");  
    }  
  
    private static void showStudents() {  
        if (studentCount == 0) {  
            System.out.println("No students to show.");  
            return;  
        }  
        System.out.println("Students:");  
        for (int i = 0; i < studentCount; i++) {  
            System.out.println("ID: " + students[i].id + ", Name: " + students[i].name);  
        }  
    }  
}