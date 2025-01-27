package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users = new User[10];
    //users and book count variables added to help keep trach of how many non null values
    private int userCount = 0;
    private int bookCount = 0;

    // no variables ot intialize
    public BookStore(){

    }
    // returns list of the users in the bookstore
    public User[] getUsers(){
        return users;
    }

    // sets new list of users for book store
    public void setUsers(User[] users){
        this.users = users;
        //updates user count of how many users
        userCount = users.length; 
    }
    // returns list of books in store
    public Book[] getBooks(){
        return books;
    }
    // adds another user to the list using usercount
    public void addUser(User user){
         users[userCount] = user;
         userCount++;
    }
    public int getCount(){
        return userCount;
    }
    // removes users
    public void removeUser(User user){
        //create new array that will not contain the removed user
        User[] users2 = new User[users.length];
        //create index to ensure new array is consolidated correctly
        int index = 0;
        for(int i=0;i<users.length;i++){  
            //if the users at the index is not the user that shoud be removed, user is added ot new list
            if(!(users[i] == user)){
                //uses index for seocnd list to ensure that there are no empty spaces in second array
                users2[index] = users[i];
                index++;
            }
        }
        //updates usercount
        userCount--;
        //sets old list to new list to ensure it is updated
        users = users2;
    }
    // public void consolidateUsers(){}
    public void consolidateUsers(){
        //creates new list based on user length
        User[] users2 = new User[users.length];
        //creaes index to accruaetly update new list
        int index = 0;
        for(int i=0;i<users.length;i++){
            //if the value at that index is not null, add it to the new list
            if(!(users[i] == null)){
                //new list uses the index variable to avoid having blank spots inbetween
                users2[index] = users[i];
                //updates index
                index++;
            }
        }
        //updates old list ot new updated list
        users = users2;
    }
    // adds new book
    public void addBook(Book book){
        //creates new book wiht updated amount
        Book[] books2 = new Book[bookCount +1 ];
        //transcribes old book to new list using old count since old count is all books before the enw boook
        for(int i=0;i<bookCount;i++){
            books2[i] = books[i];
        }
        //sets last index to the new book
        books2[bookCount ] = book;
        //updates orignial list
        books = books2;
        //updates count of all boooks
        bookCount++;
      
    }
    // inserts a new book at given index
    public void insertBook(Book book, int index){
        //creates new array with updated length
        Book[] books2 = new Book[bookCount +1 ];
        //first for loop updates books before the given index
        for(int i=0;i<index;i++){
            books2[i] = books[i];
        }
       //sets the index to the inserted book
        books2[index] = book;
        //increase amount of books
        bookCount++;
        //uses slightly adjusted for loop to keep count the same, uses i-1 since new list is one index ahead of old list
        for(int i = index + 1;i<bookCount;i++){
            books2[i] = books[i-1];

        }
        //sets orignial array to new updated array
        books = books2;
    }  
    //removes book
    public void removeBook(Book book){
        //first checks if there is more than one book to remove
        if(book.getQuantity() > 1){
            //searches to find said book in array and to reduce qunatity by 1
            for(int i=0;i<books.length;i++){
                if(books[i] == book){
                    books[i].setQuantity(book.getQuantity()-1);
                }
            }
        }else{
            //if only one book left, it wil remove the book,sets new array to be one less since book is being removed
            Book[] books2 = new Book[bookCount -1];
            //sets index to correctly update new list
            int index = 0;
            for(int i =0;i<books.length;i++){
                //if the book at that index is not the book to be removed, the old book is added to the enw list
                if(!(books[i] == book)){
                    //udpates based on the index variable to ensure taht the length is correct for new list
                    books2[index] = books[i];
                    //updates index appropiatley
                    index++;
                }
            }
            //updates book count
            bookCount--;
            //sets old list to corrected list
            books = books2;
        }
    }
    public  String bookStoreBookInfo(){
        String ret = "";
        for(int i =0;i<books.length;i++){
            ret += books[i].bookInfo() + "\n";
        }
        return ret;
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){
        String ret = "";
        for(int i =0;i<userCount;i++){
            ret += users[i].userInfo();
        }
        return ret;
    } //you are not tested on this method but use it for debugging purposes

}