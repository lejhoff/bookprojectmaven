package no.ntnu.idatg2001.bookProjectMaven.core;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


/**
 * The type Book register.
 */
public class BookRegister {
    private ArrayList<Book> theActualListOfBooks;

    /**
     * Instantiates a new Book register.
     */
    public BookRegister() {
        theActualListOfBooks = new ArrayList<>();
    }


    /**
     * List all books.
     */
    public void listAllBooks() {
    }

    /**
     * Add book.
     *
     * @param book the book
     */
    public void addBook(Book book) {

        theActualListOfBooks.add(book);

    }


    /**
     * Check barcode boolean.
     *
     * @param bookBarcode the book barcode
     * @return the boolean
     */
    public boolean checkBarcode(long bookBarcode) {
        Iterator<Book> it = theActualListOfBooks.iterator();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getBarcode() == bookBarcode) {
                return false;
            }
        }
        return true;
    }

    /**
     * Search by part title array list.
     *
     * @param partTitle the part title
     * @return the array list
     */
    public ArrayList<Book> searchByPartTitle(String partTitle) {
        Iterator<Book> it = theActualListOfBooks.iterator();
        ArrayList<Book> temporaryBookList = new ArrayList<>();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getTitle().contains(partTitle)) {
                temporaryBookList.add(currentBook);
            }
        }
        return temporaryBookList;
    }

    /**
     * Search by part author array list.
     *
     * @param partAuthor the part author
     * @return the array list
     */
    public ArrayList<Book> searchByPartAuthor(String partAuthor) {
        Iterator<Book> it = theActualListOfBooks.iterator();
        ArrayList<Book> temporaryBookList = new ArrayList<>();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getAuthor().contains(partAuthor)) {
                temporaryBookList.add(currentBook);
            }
        }
        return temporaryBookList;
    }

    /**
     * Search by barcode array list.
     *
     * @param barcode the barcode
     * @return the array list
     */
    public ArrayList<Book> searchByBarcode(long barcode) {
        Iterator<Book> it = theActualListOfBooks.iterator();
        ArrayList<Book> temporaryBookList = new ArrayList<>();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getBarcode() == barcode) {
                temporaryBookList.add(currentBook);
            }
        }
        return temporaryBookList;
    }

    /**
     * Remove book by barcode.
     *
     * @param barcode the barcode
     */
    public void removeBookByBarcode(long barcode) {
        Iterator<Book> it = theActualListOfBooks.iterator();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getBarcode() == barcode) {
                it.remove();
                System.out.println("'" + currentBook.getTitle() + "'" + "with barcode: " + "'" + currentBook.getBarcode() + "'" + " has been removed." + '\n');
            }
        }
    }

    /**
     * Change availability of book by barcode.
     *
     * @param barcode the barcode
     */
    public void changeAvailabilityOfBookByBarcode(long barcode) {
        Iterator<Book> it = theActualListOfBooks.iterator();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getBarcode() == barcode) {
                currentBook.flipIsBorrowed();
                if (currentBook.getIsBorrowed() == true) {
                    System.out.println("\t" + "'" + currentBook.getTitle() + "'" + " with barcode: " + "'" + currentBook.getBarcode() + "'" + " has been borrowed." + '\n');
                } else if (currentBook.getIsBorrowed() == false) {
                    System.out.println("\t" + "'" + currentBook.getTitle() + "'" + " with barcode: " + "'" + currentBook.getBarcode() + "'" + " has been returned." + '\n');
                }
            }
        }
    }

    /**
     * Add typed book.
     *
     * @param title         the title
     * @param author        the author
     * @param numberOfPages the number of pages
     * @param barcode       the barcode
     * @param isBorrowed    the is borrowed
     */
    public void addTypedBook(String title, String author, int numberOfPages, long barcode, boolean isBorrowed) {
        theActualListOfBooks.add(new Book(title, author, numberOfPages, barcode, isBorrowed));
    }

    /**
     * Gets iterator.
     *
     * @return the iterator
     */
    public Iterator<Book> getIterator() {
        return this.theActualListOfBooks.iterator();
    }

    /**
     * Gets array list.
     *
     * @return the array list
     */
    public ArrayList<Book> getArrayList() {
        return theActualListOfBooks;
    }

    /**
     * Print array list.
     *
     * @param list the list
     */
    public void printArrayList(ArrayList<Book> list) {
        if (list.isEmpty()) {
            System.out.println("No results...");
        }
        Iterator<Book> it = list.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.toString());
        }
    }



}
