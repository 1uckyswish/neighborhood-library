package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NeighborhoodLibrary {
    // Initialize an array of Books of the class book of size 20
    static Book[] bookInventory = new Book[20];

    public static void main(String[] args) {
        // Populate books to an array
        preLoadBooks();
        // Run Program
        displayHomeScreen();
    }

    public static void displayHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        // Ask the user for two options
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
                showCheckedOutBooks(scanner);
                break;
            case "3":
                System.out.println("Exiting...");
                break;
            // If user types in wrong option it returns the method again
            default:
                System.out.println("Invalid option! Please choose again.\n");
                displayHomeScreen(); // Display the home screen again for invalid input
                break;
        }
    }

    public static void showAvailableBooks(Scanner scanner) {
        System.out.println("\nAvailable Javapedia Books:");
        System.out.println("****************************************************");
        // Make a MAX starting variable
        int amountOfCheckedOutBooks = 20;
        for (Book book : bookInventory) {
            if (!book.isCheckedOut()) {
                // Decrement everytime a book shows up available
                amountOfCheckedOutBooks--;
                System.out.printf("Title: %s - ID: %d  - ISBN: %s \n", book.getTitle(), book.getId(), book.getIsbn());
                System.out.println("****************************************************");
            }
        }

        // Prompt user if no books are available
        if (amountOfCheckedOutBooks == 20) {
            System.out.println("it seems like all books have been checked out");
            System.out.println("Please come back again later and see if we have books available");
            System.out.println("What would you like to do? ");
            System.out.println("-(1)- Check in a book\n-(2)- Go back home?");
            System.out.print("Enter your command: ");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    showCheckedOutBooks(scanner);
                    break;
                case "2":
                    displayHomeScreen();
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.\n");
                    showCheckedOutBooks(scanner); // Display the books screen again for invalid input
                    break;
            }
        }

        // If there are enough books for checkout prompt user what to do
        System.out.println("Did you see a book your interested in within our Javapedia Libary?");
        System.out.println("What would you like to do? ");
        System.out.println("-(1)- Check out a book\n-(2)- Go back home?");
        System.out.print("Enter your command: ");
        String userChoice = scanner.nextLine();
        switch (userChoice) {
            case "1":
                checkoutBook(scanner);
                break;
            case "2":
                displayHomeScreen();
                break;
            default:
                System.out.println("Invalid option! Please choose again.\n");
                showAvailableBooks(scanner); // Display the books screen again for invalid input
                break;
        }
    }

    public static void showCheckedOutBooks(Scanner scanner) {
        System.out.println("\nAll Checked Out Javapedia Books:");
        System.out.println("****************************************************");
        // Make a starting variable for books
        int amountOfCheckedOutBooks = 0;
        for (Book book : bookInventory) {
            if (book.isCheckedOut()) {
                // Increment everytime a book shows up available
                amountOfCheckedOutBooks++;
                System.out.printf("Title: %s - ID: %d  - ISBN: %s \n", book.getTitle(), book.getId(), book.getIsbn());
                System.out.printf("%s has this book checked out currently\n", book.getCheckedOutTo());
                System.out.println("****************************************************");
            }
        }
        // Prompt user if no books are checked out
        if (amountOfCheckedOutBooks == 0) {
            System.out.println("it seems like no books have been checked out yet. How about you check one out?");
            System.out.println("What would you like to do? ");
            System.out.println("-(1)- Check out a book\n-(2)- Go back home?");
            System.out.print("Enter your command: ");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    showAvailableBooks(scanner);
                    break;
                case "2":
                    displayHomeScreen();
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.\n");
                    showCheckedOutBooks(scanner); // Display the books screen again for invalid input
                    break;
            }
        }

        System.out.println("What would you like to do? ");
        System.out.println("-(1)- Check in a book\n-(2)- Go back home?");
        System.out.print("Enter your command: ");
        String userChoice = scanner.nextLine();
        switch (userChoice) {
            case "1":
                checkInBook(scanner);
                break;
            case "2":
                displayHomeScreen();
                break;
            default:
                System.out.println("Invalid option! Please choose again.\n");
                showCheckedOutBooks(scanner); // Display the books screen again for invalid input
                break;
        }
    }

    public static void checkInBook(Scanner scanner) {
        // Ask user for the ID of the book they want to check in
        System.out.print("What is (ID) of the book you want to Check in?: ");
        int bookIdChoosen = scanner.nextInt();
        scanner.nextLine(); // catch scanner buffer
        String bookTitle = "";
        // Check if book has been checked in and also if it exists
        boolean updateIsCheckedIn = true;
        Boolean checkIfBookIDExists = false;

        // loop through the array to update checkIfBookIDExists
        for (Book book : bookInventory) {
            if (bookIdChoosen == book.getId()) {
                bookTitle = book.getTitle();
                checkIfBookIDExists = true; // Set to true when book is found
                break;
            }
        }

        // Loop through to see if INPUTTED ID matches any books Id that is checked out
        for (Book book : bookInventory) {
            if (bookIdChoosen == book.getId() && book.isCheckedOut()) {
                // Update the two variables
                updateIsCheckedIn = false;
                checkIfBookIDExists = true;
                System.out.printf("The Book: %s has been checked in \n", book.getTitle());
                System.out.printf("Thank you %s for turning it in on time", book.getCheckedOutTo());
                // Update the setters for that class
                book.setCheckedOutTo("");
                book.setCheckedOut(updateIsCheckedIn);
                System.out.println();
                // Get Current date
                LocalDate currentDate = LocalDate.now();
                // Define the date format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
                // Format the dates
                String formattedCurrentDate = currentDate.format(formatter);
                // Thank the user
                System.out.println("****** Check-In Book Summary ******");
                System.out.printf("Title: %s - ID: %d  - Checked-in on: %s \n", book.getTitle(), book.getId(),
                        formattedCurrentDate);
            }
        }

        // Error handle if user types an ID that doesn't exist in inventory
        if (!checkIfBookIDExists) {
            System.out.printf("Sorry the book of ID: %d does not exist in our inventory\n", bookIdChoosen);
        } else if (updateIsCheckedIn) {
            // Error handle if user types in a book ID that hasn't been checked out yet
            System.out.printf("Sorry the book of ID: %d - Title: %s has not been checked out yet!\n", bookIdChoosen,
                    bookTitle);
        }
        // Prompt the user a thank-you and repeat program
        askUserAgain(scanner);

    }

    public static void checkoutBook(Scanner scanner) {
        // Ask user for the ID of the book they want to check out
        System.out.print("What is (ID) of the book you want to checkout?: ");
        int bookIdChoosen = scanner.nextInt();
        scanner.nextLine(); // catch scanner buffer
        String bookTitle = "";
        // Check if book has not been checked in and also if it exists
        boolean updateIsCheckedOut = false;
        Boolean checkIfBookIDExists = false;

        // loop through the array to update checkIfBookIDExists
        for (Book book : bookInventory) {
            if (bookIdChoosen == book.getId()) {
                bookTitle = book.getTitle();
                checkIfBookIDExists = true; // Set to true when book is found
                break;
            }
        }

        // Loop through to see if INPUTTED ID matches any book ID that has not been
        // checked out yet.
        for (Book book : bookInventory) {
            if (bookIdChoosen == book.getId() && !book.isCheckedOut()) {
                // Update the two variables
                updateIsCheckedOut = true;
                checkIfBookIDExists = true;
                System.out.printf("The Book: %s is Avaliable for checkout \n", book.getTitle());
                System.out.print("May I have your name for checkout, please? ");
                // Update the setters for that class
                book.setCheckedOutTo(scanner.nextLine());
                book.setCheckedOut(updateIsCheckedOut);
                System.out.println();
                // Get Current date
                LocalDate currentDate = LocalDate.now();
                // Add 15 days to the current date
                LocalDate futureDate = currentDate.plusDays(15);
                // Define the date format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
                // Format the dates
                String formattedCurrentDate = currentDate.format(formatter);
                String formattedFutureDate = futureDate.format(formatter);
                // Thank the user and show the summary
                System.out.println("****** Checkout Book Summary ******");
                System.out.printf("Title: %s - ID: %d  - Checked Out to: %s \n", book.getTitle(), book.getId(),
                        book.getCheckedOutTo());
                System.out.println("Book is due in 15 days from today's date");
                System.out.printf("Please return by %s\n", futureDate);
            }
        }

        // Error handle if user types an ID that doesn't exist in inventory
        if (!checkIfBookIDExists) {
            System.out.printf("Sorry the book of ID: %d does not exist in our inventory\n", bookIdChoosen);
        } else if (!updateIsCheckedOut) {
            // Error handle if user types in a book ID that has been checked out
            System.out.printf("Sorry the book of ID: %d - Title: %s is checked out already sorry!\n", bookIdChoosen,
                    bookTitle);
        }

        // Prompt the user a thank you and repeat program
        askUserAgain(scanner);

    }

    public static void askUserAgain(Scanner scanner) {
        // Thank the user
        System.out.print("Thank you for visting Javapedia can we help you with anything else? (yes/no): ");
        String userChoice = scanner.nextLine().toLowerCase();
        // Check what the user typed
        switch (userChoice) {
            case "yes":
                displayHomeScreen();
                break;
            case "no":
                System.out.println("Bye now thanks for visting Javapedia EST 1995");
            default:
                // Prompt user again if they type something wrong
                System.out.println("Sorry please say (yes/no)");
                askUserAgain(scanner);
                break;
        }

    }

    public static void preLoadBooks() {
        // Manually preload the Books array of Class Book
        bookInventory[0] = new Book(1, "9780684801469", "To Kill a Mockingbird", true, "Lionel Messi");
        bookInventory[1] = new Book(2, "9780061122415", "Diary of a Wimpy Kid", false, "");
        bookInventory[2] = new Book(3, "9781451673319", "The Great Gatsby", true, "Lebron James");
        bookInventory[3] = new Book(4, "9780385514236", "The Catcher in the Rye", false, "");
        bookInventory[4] = new Book(5, "9780743273565", "The Da Vinci Code", true, "Kanye West");
        bookInventory[5] = new Book(6, "9780140275343", "Think and Grow Rich", true, "Elon Musk");
        bookInventory[6] = new Book(7, "9780307269991", "The Alchemist", false, "");
        bookInventory[7] = new Book(8, "9781455508966", "Fifty Shades of Grey", true, "Leonardo DiCaprio");
        bookInventory[8] = new Book(9, "9780590353427", "Harry Potter and the Sorcerer's Stone", false, "");
        bookInventory[9] = new Book(10, "9780345803481", "Fahrenheit 451", true, "Anakin Skywalker");
        bookInventory[10] = new Book(11, "9780060256654", "The Lorax", false, "");
        bookInventory[11] = new Book(12, "9780593139134", "Charlotte's Web", false, "");
        bookInventory[12] = new Book(13, "9780060256579", "Goodnight Moon", false, "");
        bookInventory[13] = new Book(14, "9780312195516", "The Road Less Traveled", false, "");
        bookInventory[14] = new Book(15, "9780743247543", "The Secret", false, "");
        bookInventory[15] = new Book(16, "9780061120084", "The Sun Also Rises", false, "");
        bookInventory[16] = new Book(17, "9780345339683", "The Stand", false, "");
        bookInventory[17] = new Book(18, "9780143120834", "Python For Dummies", false, "");
        bookInventory[18] = new Book(19, "9781250107817", "The Wizard of OZ", false, "");
        bookInventory[19] = new Book(20, "9780671027032", "The Very Hungry Caterpillar", true, "Travis Scott");
    }
}
