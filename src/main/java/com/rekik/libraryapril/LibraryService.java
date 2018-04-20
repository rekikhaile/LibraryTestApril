package com.rekik.libraryapril;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryService {
    Scanner reader = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Book> availableBookList = new ArrayList<>();
    ArrayList<Book> borrowedBookList = new ArrayList<>();

    Book book;
    boolean bookDone = true;
    String bookAnswer = "";
    boolean borrowDone = true;
    String borrowAnswer = "";
    boolean returnDone = true;
    String returnAnswer = "";
    String borrowname = "";
    String returnname = "";
    int count=0;
    int count2 = 0;




    // A method to have a preloaded data of books. They are added to the arraylist of books and available books as they are available.
    public void testLibrary() {
        Book testBoook1 = new Book("Book1", "author1", 2015, "ISBN1", true);
        Book testBoook2 = new Book("Book2", "author2", 2016, "ISBN2", true);
        Book testBoook3 = new Book("Book3", "author3", 2017, "ISBN3", true);
        Book testBoook4 = new Book("Book4", "author4", 2018, "ISBN4", true);
        bookList.add(testBoook1);
        bookList.add(testBoook2);
        bookList.add(testBoook3);
        bookList.add(testBoook4);

        availableBookList.add(testBoook1);
        availableBookList.add(testBoook2);
        availableBookList.add(testBoook3);
        availableBookList.add(testBoook4);

    }


    // A method to display menu items
    public void showMenu() {

        System.out.println("1 : List books\n" +
                "\n" +
                "2 : Add a book\n" +
                "\n" +
                "3 : Borrow a book\n" +
                "\n" +
                "4 : Return a book");
        System.out.println();
    }

    // A method to dispaly all the available books and their information
    public void listBooks() {

        if (!bookList.isEmpty()) {
            for (Book eachBook : bookList
                    ) {
                System.out.println("Title: "+eachBook.getTitle());
                System.out.println("Author: "+eachBook.getAuthor());
                System.out.println("ISBN: "+eachBook.getIsbn());
                System.out.println("Publication Year: "+eachBook.getYearPub());
                String status = eachBook.isAvailable() == true ? "Is Available" : "Is Borrowed";
                System.out.println("Availability Status: " + status);
                System.out.println("=================================================================");
            }
        } else System.out.println("There are no books available");
    }


    //A method to add a book information
    public void AddBook() {

        do {
            book = new Book();
            System.out.println("Enter title of the book");
            book.setTitle(reader.nextLine());

            System.out.println("Enter author of the book");
            book.setAuthor(reader.nextLine());

            System.out.println("Enter year  of the publication");
            book.setYearPub(reader.nextLong());
            reader.nextLine();

            System.out.println("Enter ISBN number");
            book.setIsbn(reader.nextLine());

            System.out.println("Is the book available?(answer available/yes or borrowed/no)");
            String borrowed = reader.nextLine();

            if(borrowed.equalsIgnoreCase("available") || borrowed.equalsIgnoreCase("yes")  || borrowed.equalsIgnoreCase("y")  ){
                book.setAvailable(true);
            }else book.setAvailable(false);

            bookList.add(book);

            if(book.isAvailable()==true) {
                availableBookList.add(book);
            }

            System.out.println("Do you want to add another book");
            bookAnswer = reader.nextLine();

            if (bookAnswer.equalsIgnoreCase("no") || bookAnswer.equalsIgnoreCase("n"))
                bookDone = false;
            else bookDone = true;

        } while (bookDone);
    }



    // A method that allows to borrow books i.e. change the availability status of the book
    public void borrowBook() {

        if(!availableBookList.isEmpty()) {
            do{

                 //  System.out.println(availableBookList.isEmpty());
                   for (Book eachBook : availableBookList
                           ) {

                       System.out.println("Title: "+eachBook.getTitle());
                       System.out.println("Author: "+eachBook.getAuthor());
                       System.out.println("ISBN: "+eachBook.getIsbn());
                       System.out.println("Publication Year: "+eachBook.getYearPub());
                       String status = eachBook.isAvailable() == true ? "Is Available" : "Is Borrowed";
                       System.out.println("Availability Status: " + status);
                       System.out.println("=================================================================");


                   }

                if(!availableBookList.isEmpty()) {

                   System.out.println("Enter the title of the book you want to borrow?");
                   borrowname = reader.nextLine();


                    for (Book eachBook : availableBookList
                            ) {

                        if (borrowname.equalsIgnoreCase(eachBook.getTitle()) ) {


                            eachBook.setAvailable(false);
                            borrowedBookList.add(eachBook);

                            count++;

                            System.out.println("You have borrowed " + eachBook.getTitle() + " by " + eachBook.getAuthor());
                        }
                    }

                    //removing from the available list as removing from availableBookList while looping through availableBookList is not allowed

                    for (Book eachBook : bookList
                            ) {

                        if (borrowname.equalsIgnoreCase(eachBook.getTitle()) ) {

                            availableBookList.remove(eachBook);

                        }
                    }


                }


                if(count == 0){
                    System.out.println("There is no available book called "+ borrowname);
                }

                count = 0;

                if(!availableBookList.isEmpty()) {


                   System.out.println("Do you want to borrow another book");
                   borrowAnswer = reader.nextLine();

                   if (borrowAnswer.equalsIgnoreCase("no") || borrowAnswer.equalsIgnoreCase("n"))
                       borrowDone = false;
                   else borrowDone = true;
               }else {
                    System.out.println("No more books available to borrow");
                       borrowDone=false;
                   }

        } while (borrowDone);
       // }

        } else System.out.println("There are no books available to borrow");
    }


    // A method that allows to return books i.e. change the availability status of the book

    public void returnBook() {

        if(!borrowedBookList.isEmpty()) {
            do{
            for (Book eachBook : borrowedBookList
                    ) {

                System.out.println("Title: "+eachBook.getTitle());
                System.out.println("Author: "+eachBook.getAuthor());
                System.out.println("ISBN: "+eachBook.getIsbn());
                System.out.println("Publication Year: "+eachBook.getYearPub());
                String status = eachBook.isAvailable() == true ? "Is Available" : "Is Borrowed";
                System.out.println("Availability Status: " + status);
                System.out.println("=================================================================");
            }

            System.out.println("Enter the title of the book you want to return?");
            returnname = reader.nextLine();
            for (Book eachBook : borrowedBookList
                    ) {

                if (returnname.equalsIgnoreCase(eachBook.getTitle())) {
                    eachBook.setAvailable(true);
                    availableBookList.add(eachBook);
                    System.out.println("You have returned " + eachBook.getTitle() + " by " + eachBook.getAuthor());
                    count2++;
                }
            }

                if (count2 == 0) {
                    System.out.println("You have not borrowed a book with the title " + returnname);
                }

                count2 = 0;

            // removing the returned list from the borrowed book list
                for (Book eachBook : bookList
                        ) {

                    if (returnname.equalsIgnoreCase(eachBook.getTitle())) {
                        borrowedBookList.remove(eachBook);
                    }
                }


                //System.out.println("The size of borrowed list "+ borrowedBookList.size());

                if(!borrowedBookList.isEmpty()) {

                    System.out.println("Do you want to return another book");
                    returnAnswer = reader.nextLine();

                    if (returnAnswer.equalsIgnoreCase("no") || returnAnswer.equalsIgnoreCase("n"))
                        returnDone = false;
                    else returnDone = true;
                }else {
                    System.out.println("You have returned all books");
                    returnDone=false;
                }

        }while (returnDone);

        } else System.out.println("You have not borrowed any book yet");

    }

}
