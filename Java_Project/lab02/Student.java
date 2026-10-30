package lab02;

public class Student {
  private int rollNumber;
  private String studentName;
  private String branchName;
  private int semester;
  private double cgpa;

  public void setRollNumber(int rollNumber) {
    this.rollNumber = rollNumber;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }

  public int getRollNumber() {
    return rollNumber;
  }

  public String getStudentName() {
    return studentName;
  }

  public String getBranchName() {
    return branchName;
  }

  public int getSemester() {
    return semester;
  }

  public double getCgpa() {
    return cgpa;
  }

  public void displayStudentDetails() {
    System.out.println("\nStudent Details");
    System.out.println("Roll Number : " + rollNumber);
    System.out.println("Name        : " + studentName);
    System.out.println("Branch      : " + branchName);
    System.out.println("Semester    : " + semester);
    System.out.println("CGPA        : " + cgpa);
  }
}
