package lab04;

import java.util.Scanner;

class Book {
  private String title;
  private String author;
  private String isbn;
  private double price;
  private String category;

  public Book(String title, String author, String isbn, double price, String category) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.price = price;
    this.category = category;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }
}

public class BookMain {
  public static void main(String[] args) {
    Book[] books = new Book[4];
    books[0] = new Book("The Great Ruler", "Rahul Ranjan", "123", 5000, "Fiction");
    books[1] = new Book("The Art of Time pass ", "Raghav", "456", 2000.3, "Slice of Life");
    books[2] = new Book("Art of Sleeping", "Samarth", "420", 400.5, "Slice of Life");
    books[3] = new Book("Art of Computer Programming", "Donald.E Knuth", "101", 25000, "Computer Science");

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Title or Author: ");
    String keyword = sc.nextLine().toLowerCase();
    System.out.println("Search Results:");
    for (Book b : books) {
      if (b != null) {
        if (b.getTitle().toLowerCase().contains(keyword) ||
            b.getAuthor().toLowerCase().contains(keyword)) {
          System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }
      }
    }

    StringBuffer bookList = new StringBuffer();
    bookList.append("\nComplete Book List:\n");
    for (Book b : books) {
      if (b != null) {
        bookList.append("Title: ").append(b.getTitle())
            .append(", Author: ").append(b.getAuthor()).append("\n");
      }
    }
    System.out.println(bookList.toString());

    System.out.println("String Immutability");
    String originalTitle = books[0].getTitle();
    System.out.println("Original String: " + originalTitle);

    String modifiedTitle = originalTitle.toUpperCase();

    System.out.println("Operation: originalTitle.toUpperCase()");
    System.out.println("String: " + modifiedTitle);
    System.out.println("Original String after operation: " + originalTitle);

    sc.close();
  }
}
