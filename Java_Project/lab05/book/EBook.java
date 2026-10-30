package lab05.book;

public class EBook extends Book {
    private double fileSizeMB;
    private String fileFormat;

    public EBook(String title, String author, String isbn, double price, String category, double fileSizeMB, String fileFormat) {
        super(title, author, isbn, price, category);
        this.fileSizeMB = fileSizeMB;
        this.fileFormat = fileFormat;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("  Type: E-Book | Size: " + fileSizeMB + "MB | Format: " + fileFormat);
    }
}
