package no.ntnu.idatg2001.bookProjectMaven.gui;
import no.ntnu.idatg2001.bookProjectMaven.core.BookRegisterUI;
import java.util.Iterator;
import java.util.Scanner;
public class BookRegisterApplication {
    //private BookRegister bookRegister;
    private BookRegisterUI bookRegisterUI;

    public BookRegisterApplication() {
      //  bookRegister = new BookRegister();
        bookRegisterUI = new BookRegisterUI();
    }


    public int showMenu() {
        System.out.println("press 1 to search by title");
        System.out.println("press 2 to search by author");
        System.out.println("press 3 to search by barcode");
        System.out.println("press 4 remove book by barcode");
        System.out.println("press 5 to change the availability of a book by barcode");
        System.out.println("press 6 to add a book to the register");
        System.out.println("press 7 to print all books");
        System.out.println("press 8 to exit Application");
        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()) {
            menuChoice = scanner.nextInt();
        } else {
            System.out.println("Input must be a number.");
        }
        return menuChoice;
    }

    public void start() {
        boolean running = true;
        while(running) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {

                case 1:
                    bookRegisterUI.searchByPartTitleInput();
                    break;
                case 2:
                    bookRegisterUI.searchByPartAuthorInput();
                    break;
                case 3:
                    bookRegisterUI.searchByBarcodeInput();
                    break;
                case 4:
                    bookRegisterUI.removeBookByBarcode();
                    break;
                case 5:
                    bookRegisterUI.changeAvailabilityOfABookInput();
                    break;
                case 6:
                    bookRegisterUI.addBookToRegisterInput();
                    break;
                case 7:
                    bookRegisterUI.listAllBooks();
                    break;
                case 8:
                    System.out.println("Exiting application..");
                    running = false;
                    break;
                default:
                    System.out.println("Please type a number from 1 to 7." + '\n');
            }
        }
    }

    public void init() {
        bookRegisterUI.fill();
    }
}
