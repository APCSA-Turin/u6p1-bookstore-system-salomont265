package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    private Book[] book = new Book[0];
    //requires 1 contructor with two parameters that will initialize the name and id
 
    public User(String name, String Id){
        this.name = name;
        this.Id = Id;
    }
    // returns the name
    public String getName(){
        return name;
    }
    //sets the name to something new
    public void setName(String newName){
        name = newName;
    }
    // returns the id
    public String getId(){
        return Id;
    
    }
    // sets the id 
    public void setId(String newId){
        Id = newId;
    }
    // returns list of books for the user
    public Book[] getBooks(){
        return book;
    }
    //sets list of books to something new
    public void setBooks(Book[] books){
        this.book = books;
    }
    // displayys info about the user and their books
    public String userInfo(){
        String bookList = "";

        //checks if the book is there or if is empty
        for(int i=0;i<5;i++){
            if((book.length != 0)&& (book[i] != null)){
                bookList +=  book[i].bookInfo() + "\n";
            }else{
                bookList += "empty\n";
            }
        }
        return "Name: " + name  + "\nId: " + Id + "\nBooks: \n" +bookList  ;
    } 
       
}