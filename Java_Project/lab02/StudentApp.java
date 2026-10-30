package lab02;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        
        System.out.print("Enter Roll Number: ");
        student.setRollNumber(scanner.nextInt());
        scanner.nextLine();
        
        System.out.print("Enter Name: ");
        student.setStudentName(scanner.nextLine());
        
        System.out.print("Enter Branch: ");
        student.setBranchName(scanner.nextLine());
        
        System.out.print("Enter Semester: ");
        student.setSemester(scanner.nextInt());
        
        System.out.print("Enter CGPA: ");
        student.setCgpa(scanner.nextDouble());
        
        student.displayStudentDetails();
        
        scanner.close();
    }
}