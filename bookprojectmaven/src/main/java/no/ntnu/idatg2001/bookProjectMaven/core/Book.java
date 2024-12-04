package no.ntnu.idatg2001.bookProjectMaven.core;
/**
 * The type Book.
 * This line is from the develop branch
 *
 *
 *
 */
public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private Long barcode;
    private boolean isBorrowed;

    /**
     * Instantiates a new Book.
     *
     * @param title         the title
     * @param author        the author
     * @param numberOfPages the number of pages
     * @param barcode       the barcode
     * @param isBorrowed    the is borrowed
     */
    public Book(String title, String author, int numberOfPages, Long barcode, boolean isBorrowed) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setNumberOfPages(numberOfPages);
        this.setBarcode(barcode);
        this.setIsBorrowed(isBorrowed);
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        if ((title == null) || (title.trim().isEmpty())) {
            this.title = "INVALID TITLE";
        } else {
            this.title = title;
        }
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        if ((author == null) || (author.trim().isEmpty())) {
            this.author = "INVALID AUTHOR";
        } else {
            this.author = author;
        }
    }

    /**
     * Gets number of pages.
     *
     * @return the number of pages
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Sets number of pages.
     *
     * @param numberOfPages the number of pages
     */
    public void setNumberOfPages(int numberOfPages) {
        if ((numberOfPages < 0)) {
            this.numberOfPages = 0;
        } else {
            this.numberOfPages = numberOfPages;
        }


    }

    /**
     * Gets barcode.
     *
     * @return the barcode
     */
    public Long getBarcode() {
        return barcode;
    }

    /**
     * Sets barcode.
     *
     * @param barcode the barcode
     */
    public void setBarcode(Long barcode) {
        if ((barcode > 1000000000000L) || (barcode < 9999999999999L)) {
            this.barcode = barcode;
        } else {
            this.barcode = 0L;
        }

    }

    /**
     * Gets is borrowed.
     *
     * @return the is borrowed
     */
    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    /**
     * Sets is borrowed.
     *
     * @param isBorrowed the is borrowed
     */
    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    /**
     * Flip is borrowed.
     */
    public void flipIsBorrowed() {
        isBorrowed = !isBorrowed;
    }
    @Override
    public String toString() {
        return  "\t#" + "###################################### " + '\n' +
                "\t#" + "# Title: " + title + '\n' +
                "\t#" + "# Author: " + author + '\n' +
                "\t#" + "# Number Of Pages: " + numberOfPages + '\n' +
                "\t#" + "# Barcode: " + barcode + '\n' +
                "\t#" + "# Book is Borrowed: " + isBorrowed + '\n' +
                "\t#" + "######################################" + '\n';
    }
}
