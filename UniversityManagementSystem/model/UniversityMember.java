package model;

public abstract class UniversityMember {
  protected String id;
  protected String name;
  protected String email;

  public UniversityMember(String id, String name, String email) {
    this.id = id.trim();
    this.name = name.trim();
    this.email = email.trim();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public abstract void display();
}
