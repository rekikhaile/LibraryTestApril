package com.rekik.libraryapril;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        boolean libraryDone = true;
        String libraryAnswer = "";

        LibraryService libraryService = new LibraryService();

        //load testlibrary data
        libraryService.testLibrary();

        do {

            libraryService.showMenu();
            System.out.println("Enter a number of your choice (input number (1 - 4))");
            int choice = reader.nextInt();
            reader.nextLine();

            if (choice == 1) {
                libraryService.listBooks();
            }

            else if (choice == 2) {
                libraryService.AddBook();
            }

            else if (choice == 3) {
            libraryService.borrowBook();
            }

            else if (choice == 4) {
                libraryService.returnBook();
            }

            System.out.println("Do you want to see the menu again");
            libraryAnswer = reader.nextLine();

            if (libraryAnswer.equalsIgnoreCase("no") || libraryAnswer.equalsIgnoreCase("n"))
                libraryDone = false;
            else libraryDone = true;


        }while (libraryDone) ;




    }
}
