package lab03;
class Student {
    private String studentName;
    private int rollNumber;
    private static String universityName = "South Asian University";
    private static int totalStudents = 0;

    public Student(String studentName, int rollNumber) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        totalStudents++;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public void display() {
        System.out.println(studentName + "," + rollNumber + "," + universityName);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student("Rahul", 101);
        Student s2 = new Student("Done", 102);
        Student s3 = new Student("Raghav", 103);

        s1.display();
        s2.display();
        s3.display();

        System.out.println("Total Students Registered: " + Student.getTotalStudents());
    }
}