package catalog;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nameOfBook;
    private String authorOfBook;
    private String descriptionOfBook;
    private int numberOfPages;
    private TypeOfBook typeOfBook;

    public Book(String nameOfBook, String authorOfBook, String descriptionOfBook, int numberOfPages, TypeOfBook typeOfBook) {
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.descriptionOfBook = descriptionOfBook;
        this.numberOfPages = numberOfPages;
        this.typeOfBook = typeOfBook;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public String getDescriptionOfBook() {
        return descriptionOfBook;
    }

    public void setDescriptionOfBook(String descriptionOfBook) {
        this.descriptionOfBook = descriptionOfBook;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public TypeOfBook getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(TypeOfBook typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    @Override
    public String toString() {
        return "АВТОР: " + getAuthorOfBook() + " НАЗВАНИЕ КНИГИ: " + getNameOfBook() + " КОЛЛИЧЕСТВО СТРАНИЦ: " + numberOfPages + " " +
                getTypeOfBook().toString() + "\n" + "ОПИСАНИЕ: \n    " + descriptionOfBook;

    }
}
