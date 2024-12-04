package no.ntnu.idatg2001.bookProjectMaven.core;
import java.util.Iterator;
import no.ntnu.idatg2001.bookProjectMaven.core.BookRegister;
import no.ntnu.idatg2001.bookProjectMaven.core.Book;
import java.util.Scanner;

public class BookRegisterUI {
        private Scanner scanner;
        private BookRegister bookRegister;

    public BookRegisterUI() {
    scanner = new Scanner(System.in);
    bookRegister = new BookRegister();
}

    public String getInputString() {
        boolean running = true;
        String inputString = null;
        while (running) {
            inputString = scanner.nextLine();
            if (inputString.length() >= 1) {
                running = false;
            } else {
                System.out.println("You have to type something!");
            }
        }
        return inputString;
    }

    public int getInputInt() {
        boolean running = true;
        int inputInt = 0;
        while (running) {
            if (scanner.hasNextInt()) {
                inputInt = scanner.nextInt();
                if (inputInt >= 0) {
                    running = false;
                } else {
                    System.out.println("Invalid input - The number can't be negative.");
                }
            } else {
                System.out.println("Invalid input - Please enter a number.");
                scanner.next();
            }
        }
        return inputInt;
    }

    public long getInputLong() {
        long inputLong = 0L;
        boolean running = true;
        while (running) {
            if (scanner.hasNextLong()) {
                inputLong = scanner.nextLong();
                String barcodeToString = String.valueOf(inputLong);
                if (inputLong >= 0 && barcodeToString.length() == 13) {
                    scanner.nextLine(); // Hvorfor må denne være der?????
                    running = false;
                } else {
                    System.out.println("\t" + "Invalid input. Please enter a valid barcode, consisting of 13 digits." + '\n');
                }
            } else {
                System.out.println("\t" + "Invalid input. Barcodes can only consist of numbers" + '\n');
                scanner.next();
            }
        }
        return inputLong;
    }

    public long getInputLongTest() {
        boolean running = true;
        long inputLong = 0L;
        while (running) {
            if (scanner.hasNextLong()) {
                inputLong = scanner.nextLong();
                String barcodeToString = String.valueOf(inputLong);
                if ((inputLong >= 0) && barcodeToString.length() == 13 && bookRegister.checkBarcode(inputLong)) {
                    scanner.nextLine();// Hvorfor må denne være der?????
                    running = false;
                } else {
                    System.out.println("\t" + "Invalid input. Please enter a valid barcode, consisting of 13 digits." + '\n' +
                            "\t" + "Make sure the barcode is not in use.");
                }
            } else {
                System.out.println("\t" + "Invalid input. Barcodes can only consist of numbers" + '\n');
                scanner.next();
            }
        }
        return inputLong;
    }

    public void listAllBooks() {
        Iterator<Book> it = this.bookRegister.getIterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.toString());
        }
    }

    public void searchByPartTitleInput() {
        System.out.println("\t" + "Please type the title of a book: ");
        String inputString = getInputString();
        bookRegister.printArrayList(bookRegister.searchByPartTitle(inputString));
    }

    public void searchByPartAuthorInput() {
        System.out.println("\t" + "Please type the name of an author: ");

        String inputString = getInputString();
        bookRegister.printArrayList(bookRegister.searchByPartAuthor(inputString));
    }

    public void searchByBarcodeInput() {
        System.out.println("\t" + "Please type the barcode of a book: ");
        long inputLong = getInputLong();
        bookRegister.printArrayList(bookRegister.searchByBarcode(inputLong));
    }


    public void changeAvailabilityOfABookInput() {
        System.out.println("\t" + "Please type the barcode of the the lent/returned book: ");
        long inputLong = getInputLong();
        bookRegister.changeAvailabilityOfBookByBarcode(inputLong);

    }

    public void addBookToRegisterInput() {
        System.out.println("Title: ");
        String title = getInputString();
        System.out.println("Author: ");
        String author = getInputString();
        System.out.println("Number of pages: ");
        int numberOfPages = getInputInt();
        System.out.println("Barcode: ");
        long barcode = getInputLongTest();

        bookRegister.addTypedBook(title, author, numberOfPages, barcode, false);
        System.out.println("\n" + "'" + title + "'" +  " has been added to the book register." + '\n' +
                           "It was book number " + bookRegister.getArrayList().size() + " to be added.");
        System.out.println("\n");
        //scanner.nextLine();
    }

    public void removeBookByBarcode() {
        System.out.println("Please enter the barcode of a book you want to remove from the register: ");
        long inputLong = getInputLong();
        bookRegister.removeBookByBarcode(inputLong);
    }

    public void fill() {
        bookRegister.addBook(new Book("Harry Potter og de vises stein", "J. K. Rowling", 281, 1234567890123L, false));
        bookRegister.addBook(new Book("Harry Potter og mysteriekammeret", "J. K. Rowling", 306, 1234567890134L, false));
        bookRegister.addBook(new Book("Harry Potter og fangen fra Azkaban", "J. K. Rowling", 386, 1234567890145L, false));
        bookRegister.addBook(new Book("Harry Potter og ildbegeret", "J. K. Rowling", 647, 1234567890156L, false));
        bookRegister.addBook(new Book("Harry Potter og fønixordenen", "J. K. Rowling", 875, 1234567890167L, false));
    }
}
