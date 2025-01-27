package com.example.project;
import java.util.Scanner;

public class trying{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        //create variabel to end while loop
        boolean finished = false;
        //intalize a bookstore
        BookStore store = new BookStore();
        System.out.println("WELCOME TO THE LIBARY \n");
        while(!finished){
            //add pizzaz and make it look good
            System.out.println("Press 0 To Quit");
            System.out.println("Press 1 To add book to library");
            System.out.println("Press 2 To add more of the book ot library");
            System.out.println("Press 3 To search for a book");
            System.out.println("Press 5 To register a student");
            System.out.println("Press 6 To show all students");
            System.out.println("Press 7 To check out a book");
            System.out.println("Press 8 To check in a book");



            //take input on what chocie user wants to make
            int input = scan.nextInt();
            //if chooses to exit end while loop
            if(input == 0){
                finished = true;
            }

            //set up new book choice
            if(input == 1){
                //take input for title
                
                System.out.print("What's the title of the book?");
                String title = scan.next();
                
                //take input for author
                System.out.print("What's the name of the author of the book?");
                String author = scan.next();
                //take input for the year published
                System.out.print("What's the year the book was published?");
                int year = scan.nextInt();
                scan.nextLine();
                //take input for the isbn
                System.out.print("What's the isbn of the book?");
                String isbn = scan.nextLine();
              
                //take input for number of copies
                System.out.print("How many copies of the book are being added?");
                int amount = scan.nextInt();
                //crearte new book object and add it
                Book book = new Book(title, author, year, isbn, amount);
                store.addBook(book);


            }
            //upgrade qunatity using book id
    
            if(input == 2){
                //take input for book id
                System.out.print("Whats the id of the book?");
                String id = scan.next();

                System.out.print("How many copies of the book do you want to add?");
                int copies = scan.nextInt();
                //get list of books
                
                Book[] books = store.getBooks();
                for(int i =0;i<books.length;i++){
                    //find book using id, and set new qunatiy to old plus new
                    if(books[i].getIsbn().equals(id)){
                        books[i].setQuantity(books[i].getQuantity() + copies);

                    }
                }
                

            }
            if(input == 3){
                //take input for book id
                System.out.print("Whats the id of the book?");
                String id = scan.next();

                //set boolean to see if book is there
                boolean have = false;
                //set index of book wanted
                int index = 0;

                //display info for that book
                //get list of book
                Book[] books = store.getBooks();
                for(int i =0;i<books.length;i++){
                    //find book using id, and set new qunatiy to old plus new
                    if(books[i].getIsbn().equals(id)){
                       have = true;
                       //set index of book they want
                       index = i;

                    }
                }
                if(have){
                    System.out.println("We have that book, here is the info!");
                    System.out.println();
                    System.out.print(books[index].bookInfo());
                }else{
                    System.out.println("Sorry we dont have that book");

                }
            }

            if(input == 4){
                //display all books
                System.out.println(store.bookStoreBookInfo());
            }
            if(input ==5){
                //register students
                //take name
                System.out.print("Whats the name of the user?");
                String name = scan.next();
                //generate id
                IdGenerate.generateID();
                String id = IdGenerate.getCurrentId();
                
                User user = new User(name,id);
                store.addUser(user);
               
            }
            if(input == 6){
                //display all users
                System.out.println(store.bookStoreUserInfo());
            }

            if(input == 7){
                //first check if registered user
                System.out.print("To take a book, you need to be a registered student,what's your name?");
                String name = scan.next();
                //make boolean to check
                boolean haveName = false;
                //create index to acsess the user account
                int userIndex = -1;
                for(int i=0;i<store.getCount();i++){
                    if(store.getUsers()[i].getName().equals(name)){
                        haveName = true;
                        userIndex = i;
                   }
                }
                //if registered
                if(haveName){
                User user = store.getUsers()[userIndex];

                // search for book
                System.out.print("Whats the id of the book?");
                String id = scan.next();

                //set boolean to see if book is there
                boolean have = false;
                //set index of book wanted
                int index = 0;

                //display info for that book
                //get list of book
                Book[] books = store.getBooks();
                for(int i =0;i<books.length;i++){
                    //find book using id, and set new qunatiy to old plus new
                    if(books[i].getIsbn().equals(id)){
                       have = true;
                       //set index of book they want
                       index = i;

                    }
                }
                //if the book is there add it to their list
                if(have){
                    //create book variable using index
                    Book bookWanted = books[index];
                    bookWanted.setQuantity(1);
                    System.out.println("We have that book!");
                    //create book list of user
                    Book[] booksUser = user.getBooks();
                 
                    Book[] books2 = new Book[5 ];
                    //transcribes old book to new list using old count since old count is all books before the enw boook
                    for(int i=0;i<booksUser.length;i++){
                        books2[i] = books[i];
                    }
                    //sets last index to the new book
                    books2[booksUser.length ] = bookWanted;
                    //updates orignial list
                    user.setBooks(books2);
                    //updates quantity of book in library
                    if(store.getBooks()[index].getQuantity()>1){
                        store.getBooks()[index].setQuantity(store.getBooks()[index].getQuantity()-1);
                    }else{
                        store.removeBook(bookWanted);
                    }
                    //check
                    System.out.println(store.bookStoreBookInfo());
                    System.out.println(store.bookStoreUserInfo());

                    
                }else{
                    System.out.println("Sorry we dont have that book");

                }
                }else{
                    //if not registered
                    System.out.println("Sorry you are not registered, please register to take a book out");
                }
            }
            if(input == 8){
                //first check if registered user
                System.out.print("To return a book, you need to be a registered student,what's your name?");
                String name = scan.next();
                //make boolean to check
                boolean haveName = false;
                //create index to acsess the user account
                int userIndex = -1;
                for(int i=0;i<store.getCount();i++){
                    if(store.getUsers()[i].getName().equals(name)){
                        haveName = true;
                        userIndex = i;
                   }
                }
                //if registered
                if(haveName){
                User user = store.getUsers()[userIndex];

                // search for book
                System.out.print("Whats the id of the book?");
                String id = scan.next();

                //set boolean to see if book is there
                boolean have = false;
                //set index of book wanted
                int index = 0;

                //display info for that book
                //get list of book
                Book[] books = store.getBooks();
                for(int i =0;i<books.length;i++){
                    //find book using id, and set new qunatiy to old plus new
                    if(books[i].getIsbn().equals(id)){
                       have = true;
                       //set index of book they want
                       index = i;

                    }
                }
                //if the book is there onyl change qunaitiy
                if(have){
                    //set librabry qunatiy up by 1
                    books[index].setQuantity(books[index].getQuantity()+1);
               
            
                    //create book list of user to update
                    Book[] booksUser = user.getBooks();
                 
                    Book[] books2 = new Book[5 ];
                    //transcribes old book to new list using old count since old count is all books before the enw boook
                    for(int i=0;i<booksUser.length;i++){
                        if(books[index] != booksUser[i]){
                            books2[i] = books[i];
                        }else{
                            books2[i] = null;
                        }
                    }
                    
                    //updates orignial list
                    user.setBooks(books2);
                    
                    //check
                    System.out.println(store.bookStoreBookInfo());
                    System.out.println(store.bookStoreUserInfo());

                    
                }else{
                    //if we dont have it, add it
                    //take input for title
                    User user2 = store.getUsers()[userIndex];

                    System.out.print("What's the title of the book?");
                    String title = scan.next();
                    
                    //take input for author
                    System.out.print("What's the name of the author of the book?");
                    String author = scan.next();
                    //take input for the year published
                    System.out.print("What's the year the book was published?");
                    int year = scan.nextInt();
                    scan.nextLine();
                    //take input for the isbn
                    System.out.print("What's the isbn of the book?");
                    String isbn = scan.nextLine();
                
                    //take input for number of copies
                    System.out.print("How many copies of the book are being added?");
                    int amount = scan.nextInt();
                    //crearte new book object and add it
                    Book book = new Book(title, author, year, isbn, amount);
                    store.addBook(book);
                    //update user book list
                    Book[] booksUser = user.getBooks();
                    Book[] books2 = new Book[5 ];
                    //transcribes old book to new list using old count since old count is all books before the enw boook
                    for(int i=0;i<store.getCount();i++){
                        if(books[index] != booksUser[i]){
                            books2[i] = books[i];
                        }else{
                            books2[i] = null;
                        }
                    }
                    
                    //updates orignial list
                    user.setBooks(books2);

                    System.out.println(store.bookStoreBookInfo());
                    System.out.println(store.bookStoreUserInfo());
                }
                }else{
                    //if not registered
                    System.out.println("Sorry you are not registered, please register to take a book out");
                }
            }
            }

        }
        }
