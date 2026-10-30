package model;

import java.util.ArrayList;

public class Faculty extends UniversityMember implements Feedback {
  private String department;
  private ArrayList<String> feedbacks;

  public Faculty(String id, String name, String department, String email) {
    super(id, name, email);
    this.department = department.trim();
    this.feedbacks = new ArrayList<>();
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public void display() {
    System.out.println("ID: " + id + " |Name: " + name + " |Department: " + department + " |Email: " + email);
  }

  @Override
  public void giveFeedback(String comment) {
    feedbacks.add(comment.trim());
    System.out.println("Feedback added for " + name);
  }

  @Override
  public void showFeedback() {
    System.out.println("Feedback for " + name);
    if (feedbacks.isEmpty()) {
      System.out.println("There is no feedback!");
      return;
    }
    for (String f : feedbacks) {
      System.out.println(f);
    }
  }

}
