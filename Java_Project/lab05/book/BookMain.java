package lab05.book;

import lab05.book.Book;
import lab05.book.PrintedBook;
import lab05.book.EBook;

public class BookMain {

  public static void searchBook(Book[] books, String keyword) {
    System.out.println("\nSearch Results for keyword '" + keyword + "':");
    for (Book b : books) {
      if (b != null && (b.getTitle().toLowerCase().contains(keyword.toLowerCase())
          || b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))) {
        b.displayBookInfo();
      }
    }
  }

  public static void searchBook(Book[] books, double maxPrice) {
    System.out.println("\nSearch Results for max price Rs." + maxPrice + ":");
    for (Book b : books) {
      if (b != null && b.getPrice() <= maxPrice) {
        b.displayBookInfo();
      }
    }
  }

  public static void searchBook(Book[] books, String author, String category) {
    System.out.println("\nSearch Results for Author '" + author + "' & Category '" + category + "':");
    for (Book b : books) {
      if (b != null && b.getAuthor().equalsIgnoreCase(author) && b.getCategory().equalsIgnoreCase(category)) {
        b.displayBookInfo();
      }
    }
  }

  public static void main(String[] args) {
    Book[] books = new Book[4];
    books[0] = new PrintedBook("The Great Ruler", "Rahul Ranjan", "123", 5000, "Fiction", 450);
    books[1] = new EBook("The Art of Time pass", "Raghav", "456", 2000.3, "Slice of Life", 5.2, "PDF");
    books[2] = new EBook("Art of Sleeping", "Samarth", "420", 400.5, "Slice of Life", 2.1, "EPUB");
    books[3] = new PrintedBook("Art of Computer Programming", "Donald.E Knuth", "101", 25000, "Computer Science", 3168);

    System.out.println(" All Books ");
    for (Book b : books) {
      b.displayBookInfo();
    }

    books[0].addReview("Alice", 5, "Amazing storyline!");
    books[0].addReview("Bob", 4, "Great read.");
    books[3].addReview("Charlie", 5, "A masterpiece.");

    System.out.println("\nReviews");
    books[0].displayReviews();
    books[3].displayReviews();

    searchBook(books, "Art");
    searchBook(books, 2500.0);
    searchBook(books, "Samarth", "Slice of Life");
  }
}
