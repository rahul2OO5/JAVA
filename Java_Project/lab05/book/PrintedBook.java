package lab05.book;

public class PrintedBook extends Book {
    private int numberOfPages;

    public PrintedBook(String title, String author, String isbn, double price, String category, int numberOfPages) {
        super(title, author, isbn, price, category);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("  Type: Printed Book | Pages: " + numberOfPages);
    }
}
