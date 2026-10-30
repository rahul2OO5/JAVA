package lab05.book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String category;
    private List<Review> reviews;

    public Book(String title, String author, String isbn, double price, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
        this.reviews = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    public void displayBookInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Price: Rs." + price + " | Category: " + category);
    }

    public void addReview(String reviewerName, int rating, String comment) {
        reviews.add(new Review(reviewerName, rating, comment));
    }

    public void displayReviews() {
        System.out.println("Reviews for " + title + ":");
        if (reviews.isEmpty()) {
            System.out.println("  No reviews yet.");
        } else {
            for (Review r : reviews) {
                r.displayReview();
            }
        }
    }

   
    public class Review {
        private String reviewerName;
        private int rating;
        private String comment;

        public Review(String reviewerName, int rating, String comment) {
            this.reviewerName = reviewerName;
            this.rating = rating;
            this.comment = comment;
        }

        public void displayReview() {
            System.out.println("  [Book: " + Book.this.title + "] " + reviewerName + " rated " + rating + "/5 - " + comment);
        }
    }
}
