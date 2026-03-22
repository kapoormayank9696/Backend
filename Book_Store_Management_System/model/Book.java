package Book_Store_Management_System;

public class Book {
    // Private Access Modifier And Data Members
    private int id;
    private String title;
    private String author;
    private double price;
    private int stock;

    // Default Constructor
    public Book(){};

    // Parameterized Constructor
    public Book(String title,String author,double price,int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    // Setters
    public void setId(int id) {
        this.id=id;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public void setAuthor(String author) {
        this.author=author;
    }
    public void setPrice(double price) {
        this.price=price;
    }
    public void setStock(int stock) {
        this.stock=stock;
    }

    // Getters
    public int getId() {
        return id;
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
    public int getStock() {
        return stock;
    }
}
