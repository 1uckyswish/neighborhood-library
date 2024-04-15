package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    static Book[] bookInventory = new Book[20];
    public static void main(String[] args) {
        preLoadBooks();
        displayHomeScreen();

    }

    public static void displayHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************** Welcome to Javapedia Library ***************");
        System.out.println("What can we help you with today? ");
        System.out.println("-(1)- Show Available Books\n-(2)- Show Checked Out Books\n-(3)- Exit");
        System.out.print("Enter your command: ");
        String userOption = scanner.nextLine();
        switch (userOption) {
            case "1":
                showAvailableBooks(scanner);
                break;
            case "2":
//                showCheckedOutBooks();
                break;
            case "3":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option! Please choose again.\n");
                displayHomeScreen(); // Display the home screen again for invalid input
                break;
        }
    }

    public static void showAvailableBooks(Scanner scanner){
        System.out.println("Available Javapedia Books:");
        for(Book book : bookInventory){
            if(!book.isCheckedOut()){
                System.out.printf("Title: %s - ID: %d  - ISBN: %s \n", book.getTitle(), book.getId(), book.getIsbn());
            }
            }

        System.out.println("Did you see a book your interested in within our Javapedia Libary?");
        System.out.println("What would you like to do? ");
        System.out.println("-(1)- Check out a book\n-(2)- Go back home?");
        System.out.print("Enter your command: ");
        String userChoice = scanner.nextLine();
        switch (userChoice){
            case "1": checkoutBook(scanner); break;
            case "2": displayHomeScreen(); break;
            default:
                System.out.println("Invalid option! Please choose again.\n");
                showAvailableBooks(scanner); // Display the books screen again for invalid input
                break;
        }
    }
    // TODO: FINISH METHOD FOR CHECKOUT
    // TODO: PDF FILE 3/5
    public static void checkoutBook(Scanner scanner) {

    }

    public static void preLoadBooks(){
        bookInventory[0] = new Book(1, "9780684801469", "To Kill a Mockingbird", true, "Jesus Christ");
        bookInventory[1] = new Book(2, "9780061122415", "1984", true, "Kanye West");
        bookInventory[2] = new Book(3, "9781451673319", "The Great Gatsby", true, "Lebron James");
        bookInventory[3] = new Book(4, "9780385514236", "The Catcher in the Rye", false, "");
        bookInventory[4] = new Book(5, "9780743273565", "The Da Vinci Code", false, "");
        bookInventory[5] = new Book(6, "9780140275343", "Think and Grow Rich", false, "");
        bookInventory[6] = new Book(7, "9780307269991", "The Alchemist", false, "");
        bookInventory[7] = new Book(8, "9781455508966", "Fifty Shades of Grey", false, "");
        bookInventory[8] = new Book(9, "9780590353427", "Harry Potter and the Sorcerer's Stone", false, "");
        bookInventory[9] = new Book(10, "9780345803481", "Fahrenheit 451", false, "");
        bookInventory[10] = new Book(11, "9780060256654", "Where the Wild Things Are", false, "");
        bookInventory[11] = new Book(12, "9780593139134", "Where the Crawdads Sing", false, "");
        bookInventory[12] = new Book(13, "9780060256579", "Goodnight Moon", false, "");
        bookInventory[13] = new Book(14, "9780312195516", "The Road Less Traveled", false, "");
        bookInventory[14] = new Book(15, "9780743247543", "The Secret", false, "");
        bookInventory[15] = new Book(16, "9780061120084", "The Sun Also Rises", false, "");
        bookInventory[16] = new Book(17, "9780345339683", "The Stand", false, "");
        bookInventory[17] = new Book(18, "9780143120834", "Wild: From Lost to Found on the Pacific Crest Trail", false, "");
        bookInventory[18] = new Book(19, "9781250107817", "Educated: A Memoir", false, "");
        bookInventory[19] = new Book(20, "9780671027032", "Angels & Demons", false, "");
    }
}
