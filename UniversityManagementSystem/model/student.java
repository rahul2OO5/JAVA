package model;

public class student extends UniversityMember {
  private String program;

  public student(String id, String name, String program, String email) {
    super(id, name, email);
    this.program = program.trim();
  }

  public String getProgram() {
    return program;
  }

  @Override
  public void display() {
    System.out.println("ID: " + id + " | Name: " + name + " | Program: " + program + " | Email: " + email);
  }
}
