package lab02;
import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Name: ");
        String studentName = scanner.nextLine();
        
        System.out.print("Enter Branch: ");
        String branchName = scanner.nextLine();
        
        System.out.print("Enter Semester: ");
        int semester = scanner.nextInt();
        
        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        
        System.out.println("\nStudent Details");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + studentName);
        System.out.println("Branch      : " + branchName);
        System.out.println("Semester    : " + semester);
        System.out.println("CGPA        : " + cgpa);
        
        scanner.close();
    }
}