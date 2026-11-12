package model;

import java.io.Serializable;

public class Enrollment implements Serializable {
  private static final long serialVersionUID = 1L;
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
