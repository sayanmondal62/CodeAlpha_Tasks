package com.codealpha.studentgradetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Student Details");
            System.out.println("4. Display Summary Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addGrade();
                    break;

                case 3:
                    displayStudents();
                    break;

                case 4:
                    displaySummary();
                    break;

                case 5:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // Add student
    public static void addStudent() {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(name);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Add grade
    public static void addGrade() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        displayStudentNames();

        System.out.print("Select student number: ");
        int studentNumber = scanner.nextInt();

        if (studentNumber < 1 || studentNumber > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }

        Student student = students.get(studentNumber - 1);

        student.addGrade(grade);

        System.out.println("Grade added successfully!");
    }

    // Display student names
    public static void displayStudentNames() {

        System.out.println("\nStudents:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
    }

    // Display all students
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== STUDENT DETAILS ==========");

        for (Student student : students) {

            System.out.println("\nStudent Name: " + student.getName());

            System.out.println("Grades: " + student.getGrades());

            System.out.printf(
                    "Average: %.2f%n",
                    student.calculateAverage()
            );

            System.out.printf(
                    "Highest Grade: %.2f%n",
                    student.getHighestGrade()
            );

            System.out.printf(
                    "Lowest Grade: %.2f%n",
                    student.getLowestGrade()
            );
        }
    }

    // Summary report
    public static void displaySummary() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double totalGrades = 0;
        int gradeCount = 0;

        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        String highestStudent = "";
        String lowestStudent = "";

        for (Student student : students) {

            for (double grade : student.getGrades()) {

                totalGrades += grade;
                gradeCount++;

                if (grade > highest) {
                    highest = grade;
                    highestStudent = student.getName();
                }

                if (grade < lowest) {
                    lowest = grade;
                    lowestStudent = student.getName();
                }
            }
        }

        System.out.println("\n========== SUMMARY REPORT ==========");

        System.out.println("Total Students: " + students.size());

        if (gradeCount == 0) {
            System.out.println("No grades entered yet.");
            return;
        }

        double overallAverage = totalGrades / gradeCount;

        System.out.printf(
                "Overall Average: %.2f%n",
                overallAverage
        );

        System.out.printf(
                "Highest Score: %.2f (%s)%n",
                highest,
                highestStudent
        );

        System.out.printf(
                "Lowest Score: %.2f (%s)%n",
                lowest,
                lowestStudent
        );
    }
}