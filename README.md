# Java Neighborhood library

Welcome to the Neighborhood Library Repository! This project offers a complimentary library service to everyone in your neighborhood, operating on the honor system. Checking out a book is easy—simply enter the book's ID, and you're good to go. The application will keep track of who checks out each book
## Main Class (Home)

This serves as the core of our library project. The Main class coordinates the functionality of all the library's features. Explore the Maven Java folder structure on the left to see how the project is organized.

![Maven](https://github.com/1uckyswish/neighborhood-library/assets/107442415/b54f6b30-04d1-4012-ad58-999115278fca)

## Start of Program

This is the primary screen of the library interface, presenting various options for users to choose from.

![start](https://github.com/1uckyswish/neighborhood-library/assets/107442415/38fdf4dd-baf9-47e7-be85-2839eb53ea3a)

## Option 1: Display All Books in Neighborhood Library

This option presents a detailed list of all available books ready for checkout at the library. Users can easily browse and select their next reading adventure.

![ShowBooks](https://github.com/1uckyswish/neighborhood-library/assets/107442415/0c928f52-6f03-4517-907b-07e239bfd6b0)

## Option 1: Proceed to Check Out a Book

This option enables users to input the ID of an available book they wish to check out. Additionally, users are prompted to provide their name, which will be associated with the checkout record.

![CheckoutBook](https://github.com/1uckyswish/neighborhood-library/assets/107442415/84be4890-6871-439d-a19b-a5e97c5363ff)

## Option 2: Display All Checked out Books in Neighborhood Library

This option displays a detailed list of books currently checked out from the library, along with the names of the individuals who have them checked out. Users can easily view the status of each book and who currently has it borrowed.

![showCheckedout](https://github.com/1uckyswish/neighborhood-library/assets/107442415/25dfed3a-1513-4343-b446-1cb9ba298824)

## Option 1: Proceed to Check In a Book

This option allows users to input the ID of a book they wish to return. Upon returning the book, users are greeted with a thank-you message expressing gratitude for their return.

![CheckInBook](https://github.com/1uckyswish/neighborhood-library/assets/107442415/8b44473d-ff5c-45b4-9b15-9b365013cbed)

## Error Handling Section

### Main Class (Home) Error handle

The main screen of the library interface presents users with various options to choose from. It includes error handling to manage instances where users input an option that is not one of the three displayed.

![ErrorHandleWelcomeScreen](https://github.com/1uckyswish/neighborhood-library/assets/107442415/74c086f3-7b17-4fd4-8ff6-0fc155379c36)

### Error Handling For Checking in a Book Not in Inventory

If a user selects an ID for check-in that is beyond the range of our inventory, an error is triggered indicating that the ID does not exist.

![ErrorHandleWrongID404](https://github.com/1uckyswish/neighborhood-library/assets/107442415/8f643d60-7c19-47d9-8001-4cd51942d836)

### Error Handling For Checking out a Book Already Checked Out

When a user attempts to check out a book using an ID that corresponds to a book already checked out, an error is triggered indicating that the book is currently unavailable for checkout.

![ErrorHandleCheckout](https://github.com/1uckyswish/neighborhood-library/assets/107442415/1b3a0818-4f9a-4135-bc90-b320b2e58fcb)

### Error Handling For Checking out a Book Not Checked Out

If the user attempts to check in a book using an ID that is within the inventory but has not been checked out yet, an error is triggered indicating that the book is still available for checkout.

![ErrorHandleCheckIn](https://github.com/1uckyswish/neighborhood-library/assets/107442415/45109d38-ff7e-43d6-aab3-5e888ef10935)


## Interesting Section of code
### Due Date for Book Returns: 15 Days from Checkout Date

This section of my code is Interesting because it simulates almost real-world library functionality for returning books within a due date. Users are allotted 15 days from the checkout date to return the book. While this piece of code was optional, including this feature enhances the feel of a library system. By using the LocalDate class from Java, I was able to calculate the due date by adding 15 days to the checkout date, providing users with a clear understanding of when their books are due.

![InterestingCode](https://github.com/1uckyswish/neighborhood-library/assets/107442415/b3a4cd8a-c78c-4267-aef9-0542c6978e9b)


---
"Explore the world of knowledge and adventure with our Java Neighborhood Library! Happy reading and discovering, bridging communities through the power of literature and technology📚✨"
