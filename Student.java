import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Student {

    static class StudentInfo {
        String name;
        double grade;

        StudentInfo(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        String getLetterGrade() {
            if (grade >= 90) return "A";
            else if (grade >= 80) return "B";
            else if (grade >= 70) return "C";
            else if (grade >= 60) return "D";
            else return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<StudentInfo> students = new ArrayList<>(); // Ensure this is a List<StudentInfo>

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            double grade;
            while (true) {
                System.out.print("Enter the grade of student " + (i + 1) + " (0-100): ");
                grade = scanner.nextDouble();
                if (grade >= 0 && grade <= 100) {
                    break; // Valid grade
                } else {
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                }
            }
            scanner.nextLine(); // Consume the newline
            students.add(new StudentInfo(name, grade));
        }

        // Sort the students by grade in descending order
        Collections.sort(students, Comparator.comparingDouble((StudentInfo s) -> s.grade).reversed());

        double average = calculateAverage(students);

        System.out.println("\nStudent Grade Report:");
        System.out.println("----------------------");
        for (StudentInfo student : students) {
            System.out.printf("%s: %.2f (%s)%n", student.name, student.grade, student.getLetterGrade());
        }

        System.out.printf("\nAverage Grade: %.2f\n", average);
    }

    private static double calculateAverage(List<StudentInfo> students) {
        double sum = 0.0;
        for (StudentInfo student : students) {
            sum += student.grade;
        }
        return sum / students.size();
    }
}