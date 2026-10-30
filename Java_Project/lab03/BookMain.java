package lab03;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

public class BookMain {
    public static void main(String[] args) {
        Book[] books = new Book[8];

        books[0] = new Book("The Great Ruler", "Rahul Ranjan", "9780743273565", 15.99, "Fiction");
        books[1] = new Book("82", "George", "9780451524935", 12.99, "Fiction");
        books[2] = new Book("Art of Time pass", "Samarth", "9780062316097", 22.50, "Fiction");
        books[3] = new Book("Art of Sleeping", "raghav", "9781524763138", 19.99, "Autobiography");
        books[4] = new Book("Dune", "Frank", "9780441172719", 10.99, "Sci-Fi");
        books[5] = new Book("Animal ", "George", "9780451526342", 9.99, "Fiction");
        books[6] = new Book("Master Time pass", "Rahul Ranjan", "9780399590504", 17.50, "Autobiography");
        books[7] = new Book("Art of Computer Programming ", "Donould D.Kunth", "9781984819192", 14.99, "Computer-Science");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter author name: ");
        String searchAuthor = sc.nextLine();
        for (Book b : books) {
            if (b != null && b.getAuthor().compareTo(searchAuthor) == 0) {
                System.out.println(b.getTitle());
            }
        }

        System.out.print("Enter category: ");
        String searchCategory = sc.nextLine();
        for (Book b : books) {
            if (b != null && b.getCategory().compareTo(searchCategory) == 0) {
                System.out.println(b.getTitle());
            }
        }

        System.out.print("Enter maximum price: ");
        double maxPrice = sc.nextDouble();
        for (Book b : books) {
            if (b != null && b.getPrice() <= maxPrice) {
                System.out.println(b.getTitle());
            }
        }

        sc.close();
    }
}