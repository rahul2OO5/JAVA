package model;

public class Enrollment {
  private student std;
  private course crs;

  public Enrollment(student std, course crs) {
    this.std = std;
    this.crs = crs;
  }

  public student getStudent() {
    return std;
  }

  public course getCourse() {
    return crs;
  }
}
