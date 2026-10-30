package application;

import java.util.Scanner;
import service.UniversityManger;

public class UniversityApp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    UniversityManger manager = new UniversityManger();

    while (true) {
      System.out.println("\n1. Add Student");
      System.out.println("2. Remove Student");
      System.out.println("3. Display All Students");
      System.out.println("4. Add Course");
      System.out.println("5. Remove Course");
      System.out.println("6. Display All Courses");
      System.out.println("7. Search Student by ID");
      System.out.println("8. Search Student by Name");
      System.out.println("9. Search Course by Code/Name");
      System.out.println("10. Register Student for Course");
      System.out.println("11. Withdraw Student from Course");
      System.out.println("12. View Courses of a Student");
      System.out.println("13. View Students in a Course");
      System.out.println("14. Filter Students by Program");
      System.out.println("15. Filter Courses by Credits");
      System.out.println("16. Display Statistics");
      System.out.println("17. Add Faculty");
      System.out.println("18. Remove Faculty");
      System.out.println("19. Display All Faculty");
      System.out.println("20. Display All Members");
      System.out.println("21. Search Member by ID or Name");
      System.out.println("22. Assign/Change Course Instructor");
      System.out.println("23. View Courses Assigned to a Faculty");
      System.out.println("24. View Courses Without Instructor");
      System.out.println("25. Give/View Feedback (Interface)");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Student ID: ");
          String id = sc.nextLine();
          System.out.print("Name: ");
          String name = sc.nextLine();
          System.out.print("Program: ");
          String prog = sc.nextLine();
          System.out.print("Email: ");
          String email = sc.nextLine();
          manager.addStudent(id, name, prog, email);
          break;

        case 2:
          System.out.print("Student ID to remove: ");
          manager.removeStudent(sc.nextLine());
          break;

        case 3:
          manager.displayAllStudents();
          break;

        case 4:
          System.out.print("Course Code: ");
          String code = sc.nextLine();
          System.out.print("Course Name: ");
          String cname = sc.nextLine();
          System.out.print("Credits: ");
          int credits = sc.nextInt();
          System.out.print("Max Capacity: ");
          int cap = sc.nextInt();
          sc.nextLine();
          manager.addCourse(code, cname, credits, cap);
          break;

        case 5:
          System.out.print("Course Code to remove: ");
          manager.removeCourse(sc.nextLine());
          break;

        case 6:
          manager.displayAllCourses();
          break;

        case 7:
          System.out.print("Enter Student ID: ");
          manager.searchStudentById(sc.nextLine());
          break;

        case 8:
          System.out.print("Enter Student Name: ");
          manager.searchStudentByName(sc.nextLine());
          break;

        case 9:
          System.out.print("Enter Course Code or Name: ");
          manager.searchCourse(sc.nextLine());
          break;

        case 10:
          System.out.print("Student ID: ");
          String regSid = sc.nextLine();
          System.out.print("Course Code: ");
          String regCcode = sc.nextLine();
          manager.registerStudentForCourse(regSid, regCcode);
          break;

        case 11:
          System.out.print("Student ID: ");
          String wSid = sc.nextLine();
          System.out.print("Course Code: ");
          String wCcode = sc.nextLine();
          manager.withdrawStudentFromCourse(wSid, wCcode);
          break;

        case 12:
          System.out.print("Student ID: ");
          manager.displayCoursesForStudent(sc.nextLine());
          break;

        case 13:
          System.out.print("Course Code: ");
          manager.displayStudentsInCourse(sc.nextLine());
          break;

        case 14:
          System.out.print("Enter Program: ");
          manager.filterStudentsByProgram(sc.nextLine());
          break;

        case 15:
          System.out.print("Min Credits: ");
          int min = sc.nextInt();
          System.out.print("Max Credits: ");
          int max = sc.nextInt();
          sc.nextLine();
          manager.filterCoursesByCredits(min, max);
          break;

        case 16:
          manager.displayStatistics();
          break;

        case 17:
          System.out.print("Faculty ID: ");
          String fid = sc.nextLine();
          System.out.print("Name: ");
          String fname = sc.nextLine();
          System.out.print("Department: ");
          String dept = sc.nextLine();
          System.out.print("Email: ");
          String femail = sc.nextLine();
          manager.addFaculty(fid, fname, dept, femail);
          break;

        case 18:
          System.out.print("Faculty ID to remove: ");
          manager.removeFaculty(sc.nextLine());
          break;

        case 19:
          manager.displayAllFaculty();
          break;

        case 20:
          manager.displayAllMembers();
          break;

        case 21:
          System.out.print("Search by (1) ID or (2) Name: ");
          int sType = sc.nextInt();
          sc.nextLine();
          if (sType == 1) {
            System.out.print("Enter Member ID: ");
            manager.searchMemberById(sc.nextLine());
          } else {
            System.out.print("Enter Member Name: ");
            manager.searchMemberByName(sc.nextLine());
          }
          break;

        case 22:
          System.out.print("Faculty ID: ");
          String instId = sc.nextLine();
          System.out.print("Course Code: ");
          String instCourse = sc.nextLine();
          manager.assignInstructorToCourse(instId, instCourse);
          break;

        case 23:
          System.out.print("Faculty ID: ");
          manager.displayCoursesByFaculty(sc.nextLine());
          break;

        case 24:
          manager.displayCoursesWithoutInstructor();
          break;

        case 25:
          System.out.print("1. Give Feedback  2. View Feedback: ");
          int fbChoice = sc.nextInt();
          sc.nextLine();
          System.out.print("Enter Faculty ID or Course Code: ");
          String target = sc.nextLine();
          if (fbChoice == 1) {
            System.out.print("Enter Comment: ");
            manager.giveFeedbackToTarget(target, sc.nextLine());
          } else {
            manager.viewFeedbackOfTarget(target);
          }
          break;

        case 0:
          System.out.println("Exiting...");
          sc.close();
          return;

        default:
          System.out.println("Invalid choice.");
      }
    }
  }
}
