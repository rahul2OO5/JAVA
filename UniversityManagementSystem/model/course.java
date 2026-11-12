package model;

import java.util.ArrayList;
import java.io.Serializable;

public class course implements Feedback, Serializable {
  private static final long serialVersionUID = 1L;
  private String code;
  private String name;
  private int credits;
  private int maxCapacity;
  private Faculty instructor;
  private ArrayList<String> feedbacks;

  public course(String code, String name, int credits, int maxCapacity) {
    this.code = code.trim().toUpperCase();
    this.name = name.trim();
    this.credits = credits;
    this.maxCapacity = maxCapacity;
    this.instructor = null;
    this.feedbacks = new ArrayList<>();

  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public int getCredits() {
    return credits;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public Faculty getInstructor() {
    return instructor;
  }

  public void setInstructor(Faculty instructor) {
    this.instructor = instructor;
  }

  public void display() {
    String inst = (instructor != null) ? instructor.getName() + "(" + instructor.getId() + ")" : "Not assign";
    System.out.println("Code: " + code + " | Name: " + name + " | Credits: " + credits + " | Capacity: " + maxCapacity
        + " |Instructor: " + inst);
  }

  @Override
  public void giveFeedback(String comment) {
    feedbacks.add(comment.trim());
    System.out.println("Feedback for course " + name + "has submitted");
  }

  @Override
  public void showFeedback() {
    System.out.println("Feedback for course " + name);
    if (feedbacks.isEmpty()) {
      System.out.println("There is no feedbacks related to this course.");
      return;
    }

    for (String f : feedbacks) {
      System.out.println(f);
    }
  }

}
