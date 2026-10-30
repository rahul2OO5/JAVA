package service;

import java.util.ArrayList;
import model.student;
import model.course;
import model.Enrollment;
import model.Faculty;
import model.Feedback;
import model.UniversityMember;

public class UniversityManger {
  private ArrayList<student> students;
  private ArrayList<course> courses;
  private ArrayList<Enrollment> enrollments;
  private ArrayList<UniversityMember> members;

  public UniversityManger() {
    students = new ArrayList<>();
    courses = new ArrayList<>();
    enrollments = new ArrayList<>();
    members = new ArrayList<>();
  }

  private student findStudent(String id) {
    id = id.trim();
    for (student s : students) {
      if (s.getId().equalsIgnoreCase(id)) {
        return s;
      }
    }
    return null;
  }

  private course findCourse(String code) {
    code = code.trim();
    for (course c : courses) {
      if (c.getCode().equalsIgnoreCase(code)) {
        return c;
      }
    }
    return null;
  }

  private int getEnrolledCount(String courseCode) {
    int count = 0;
    for (Enrollment e : enrollments) {
      if (e.getCourse().getCode().equalsIgnoreCase(courseCode)) {
        count++;
      }
    }
    return count;
  }

  public void addStudent(String id, String name, String program, String email) {
    if (findStudent(id) != null) {
      System.out.println("Student with ID " + id.trim() + " already exists.");
      return;
    }
    student s = new student(id, name, program, email);
    students.add(s);
    members.add(s);
    System.out.println("Student added successfully.");
  }

  public void removeStudent(String id) {
    student s = findStudent(id);
    if (s == null) {
      System.out.println("Student not found.");
      return;
    }
    for (int i = enrollments.size() - 1; i >= 0; i--) {
      if (enrollments.get(i).getStudent().getId().equalsIgnoreCase(s.getId())) {
        enrollments.remove(i);
      }
    }
    students.remove(s);
    members.remove(s);
    System.out.println("Student removed successfully.");
  }

  public void displayAllStudents() {
    if (students.isEmpty()) {
      System.out.println("No students registered in the system.");
      return;
    }
    for (student s : students) {
      s.display();
    }
  }

  public void addCourse(String code, String name, int credits, int maxCapacity) {
    if (findCourse(code) != null) {
      System.out.println("Course with code " + code.trim() + " already exists.");
      return;
    }
    courses.add(new course(code, name, credits, maxCapacity));
    System.out.println("Course added successfully.");
  }

  public void removeCourse(String code) {
    course c = findCourse(code);
    if (c == null) {
      System.out.println("Course not found.");
      return;
    }
    for (int i = enrollments.size() - 1; i >= 0; i--) {
      if (enrollments.get(i).getCourse().getCode().equalsIgnoreCase(c.getCode())) {
        enrollments.remove(i);
      }
    }
    courses.remove(c);
    System.out.println("Course removed successfully.");
  }

  public void displayAllCourses() {
    if (courses.isEmpty()) {
      System.out.println("No courses available in the system.");
      return;
    }
    for (course c : courses) {
      c.display();
    }
  }

  public void searchStudentById(String id) {
    student s = findStudent(id);
    if (s == null) {
      System.out.println("No student found with ID: " + id);
    } else {
      s.display();
    }
  }

  public void searchStudentByName(String keyword) {
    String key = keyword.trim().toLowerCase();
    boolean found = false;
    for (student s : students) {
      if (s.getName().toLowerCase().contains(key)) {
        s.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No student found matching name: " + keyword);
    }
  }

  public void searchCourse(String keyword) {
    String key = keyword.trim().toLowerCase();
    boolean found = false;
    for (course c : courses) {
      if (c.getCode().toLowerCase().contains(key) || c.getName().toLowerCase().contains(key)) {
        c.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No course found matching: " + keyword);
    }
  }

  public void registerStudentForCourse(String studentId, String courseCode) {
    student s = findStudent(studentId);
    if (s == null) {
      System.out.println("Student not found.");
      return;
    }
    course c = findCourse(courseCode);
    if (c == null) {
      System.out.println("Course not found.");
      return;
    }

    for (Enrollment e : enrollments) {
      if (e.getStudent().getId().equalsIgnoreCase(s.getId()) &&
          e.getCourse().getCode().equalsIgnoreCase(c.getCode())) {
        System.out.println("Student is already registered in this course.");
        return;
      }
    }

    int currentEnrolled = getEnrolledCount(c.getCode());
    if (currentEnrolled >= c.getMaxCapacity()) {
      System.out.println("Registration failed. Course is full.");
      return;
    }

    enrollments.add(new Enrollment(s, c));
    System.out.println("Student " + s.getName() + " registered for " + c.getCode() + " successfully.");
  }

  public void withdrawStudentFromCourse(String studentId, String courseCode) {
    for (int i = 0; i < enrollments.size(); i++) {
      Enrollment e = enrollments.get(i);
      if (e.getStudent().getId().equalsIgnoreCase(studentId.trim()) &&
          e.getCourse().getCode().equalsIgnoreCase(courseCode.trim())) {
        enrollments.remove(i);
        System.out.println("Student withdrawn from course successfully.");
        return;
      }
    }
    System.out.println("Enrollment record not found.");
  }

  public void displayCoursesForStudent(String studentId) {
    student s = findStudent(studentId);
    if (s == null) {
      System.out.println("Student not found.");
      return;
    }
    boolean found = false;
    System.out.println("Courses registered by " + s.getName() + ":");
    for (Enrollment e : enrollments) {
      if (e.getStudent().getId().equalsIgnoreCase(s.getId())) {
        e.getCourse().display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No courses registered.");
    }
  }

  public void displayStudentsInCourse(String courseCode) {
    course c = findCourse(courseCode);
    if (c == null) {
      System.out.println("Course not found.");
      return;
    }
    boolean found = false;
    System.out.println("Students enrolled in " + c.getName() + " (" + c.getCode() + "):");
    for (Enrollment e : enrollments) {
      if (e.getCourse().getCode().equalsIgnoreCase(c.getCode())) {
        e.getStudent().display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No students enrolled in this course.");
    }
  }

  public void filterStudentsByProgram(String program) {
    String prog = program.trim();
    boolean found = false;
    for (student s : students) {
      if (s.getProgram().equalsIgnoreCase(prog)) {
        s.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No students found in program: " + program);
    }
  }

  public void filterCoursesByCredits(int minCredits, int maxCredits) {
    boolean found = false;
    for (course c : courses) {
      if (c.getCredits() >= minCredits && c.getCredits() <= maxCredits) {
        c.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No courses found with credits between " + minCredits + " and " + maxCredits + ".");
    }
  }

  public void displayStatistics() {
    System.out.println("\n University Statistics ");
    System.out.println("Total Students: " + students.size());
    System.out.println("Total Courses: " + courses.size());

    ArrayList<String> programs = new ArrayList<>();
    for (student s : students) {
      boolean exists = false;
      for (String p : programs) {
        if (p.equalsIgnoreCase(s.getProgram())) {
          exists = true;
          break;
        }
      }
      if (!exists) {
        programs.add(s.getProgram());
      }
    }

    System.out.println("\nStudents per Program:");
    if (programs.isEmpty()) {
      System.out.println("None");
    } else {
      for (String p : programs) {
        int count = 0;
        for (student s : students) {
          if (s.getProgram().equalsIgnoreCase(p)) {
            count++;
          }
        }
        System.out.println(p + ": " + count);
      }
    }

    System.out.println("\nCourse Enrollment Stats:");
    if (courses.isEmpty()) {
      System.out.println("No courses available.");
    } else {
      for (course c : courses) {
        int enrolled = getEnrolledCount(c.getCode());
        int available = c.getMaxCapacity() - enrolled;
        System.out.println(
            c.getCode() + " (" + c.getName() + ") -> Enrolled: " + enrolled + " | Available Seats: " + available);
      }
    }

    System.out.println("\nCourses with 0 Registered Students:");
    boolean emptyFound = false;
    for (course c : courses) {
      if (getEnrolledCount(c.getCode()) == 0) {
        System.out.println(c.getCode() + " - " + c.getName());
        emptyFound = true;
      }
    }
    if (!emptyFound) {
      System.out.println("None");
    }
  }

  private UniversityMember findMember(String id) {
    id = id.trim();
    for (UniversityMember m : members) {
      if (m.getId().equalsIgnoreCase(id)) {
        return m;
      }
    }
    return null;
  }

  private Faculty findFaculty(String id) {
    UniversityMember m = findMember(id);
    if (m instanceof Faculty) {
      return (Faculty) m;
    }
    return null;
  }

  public void addFaculty(String id, String name, String department, String email) {
    if (findMember(id) != null) {
      System.out.println("Faculty member already exists!");
      return;
    }
    members.add(new Faculty(id, name, department, email));
    System.out.println("Faulty added sucessfully!!");
  }

  public void removeFaculty(String id) {
    Faculty f = findFaculty(id);
    if (f == null) {
      System.out.println("faculty does not exists");
      return;
    }
    for (course c : courses) {
      if (c.getInstructor() != null && c.getInstructor().getId().equalsIgnoreCase(f.getId())) {
        c.setInstructor(null);
      }
    }
    members.remove(f);
    System.out.println("Faculty remove sucessfully");
  }

  public void displayAllMembers() {
    if (members.isEmpty()) {
      System.out.println("No university member registered!");
    }
    for (UniversityMember m : members) {
      m.display();
    }
  }

  public void displayAllFaculty() {
    boolean found = false;
    for (UniversityMember m : members) {
      if (m instanceof Faculty) {
        m.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("There is no member exists in the Faculty!");
    }
  }

  public void searchMemberById(String id) {
    UniversityMember m = findMember(id);
    if (m == null) {
      System.out.println("No member found!");
    } else {
      m.display();
    }
  }

  public void searchMemberByName(String name) {
    String key = name.trim().toLowerCase();
    boolean found = false;
    for (UniversityMember m : members) {
      if (m.getName().toLowerCase().contains(key)) {
        m.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No member found !");
    }

  }

  public void assignInstructorToCourse(String facultyId, String courseCode) {
    Faculty f = findFaculty(facultyId);
    if (f == null) {
      System.out.println("No insturctor present!");
      return;
    }
    course c = findCourse(courseCode);
    if (c == null) {
      System.out.println("No couse present!");
      return;
    }
    c.setInstructor(f);
  }

  public void displayCoursesByFaculty(String facultyId) {
    Faculty f = findFaculty(facultyId);
    if (f == null) {
      System.out.println("Faculty member not found.");
      return;
    }
    boolean found = false;
    System.out.println("Courses assigned to Prof. " + f.getName() + ":");
    for (course c : courses) {
      if (c.getInstructor() != null && c.getInstructor().getId().equalsIgnoreCase(f.getId())) {
        c.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No courses assigned to this faculty member.");
    }
  }

  public void displayCoursesWithoutInstructor() {
    boolean found = false;
    System.out.println("Courses without an assigned instructor:");
    for (course c : courses) {
      if (c.getInstructor() == null) {
        c.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("All courses have an assigned instructor.");
    }
  }

  public void giveFeedbackToTarget(String idOrCode, String comment) {
    Feedback target = findFaculty(idOrCode);
    if (target == null) {
      target = findCourse(idOrCode);
    }
    if (target == null) {
      System.out.println("No Faculty or Course found with ID or course Code: " + idOrCode);
      return;
    }
    target.giveFeedback(comment);
  }

  public void viewFeedbackOfTarget(String idOrCode) {
    Feedback target = findFaculty(idOrCode);
    if (target == null) {
      target = findCourse(idOrCode);
    }
    if (target == null) {
      System.out.println("No Faculty or Course found with ID or course Code: " + idOrCode);
      return;
    }
    target.showFeedback();
  }
}
