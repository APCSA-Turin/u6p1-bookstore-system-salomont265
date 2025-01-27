package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;
    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    public Book(String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }
    
    // returns title of book
    public String getTitle(){
        return title;
    }
    //  sets title of the book
    public void setTitle(String title  ){
        this.title =title;
    }
    // return author of book
    public String getAuthor(){
        return author;
    }
    //  sets author of the book
    public void setAuthor(String author){
        this.author = author;
    }
    // returns the year it waas published
    public int getYearPublished(){
        return yearPublished;
    }
    // sets year it was published
    public void setYearPublished(int year){
        yearPublished = year;
    }
    // returns isbn
    public String getIsbn(){
        return isbn;
    }
    // sets isbn
    public void setIsbn(String Isbn){
        isbn =Isbn;
    }
    // returns quantity
    public int getQuantity(){
        return quantity;
    }
    // set quantity
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    // returns key ifno about book: title,author,year published, isbn, quantity
    public String bookInfo(){
        return "Title: " + title +", Author: " + author +", Year: " + yearPublished + ", ISBN: " + isbn +", Quantity: " + quantity; 
    }
       
}