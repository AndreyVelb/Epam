package accesssystem;

import catalog.Book;
import catalog.BookCatalog;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private int adminPassword = "adminPass111".hashCode();
    private BookCatalog bookCatalog = new BookCatalog();

    public void addBook() {
        Book bookForAddition = bookCatalog.createBookForAddition();
        bookCatalog.addBookToCatalog(bookForAddition);
        sendEmailToUsers(bookForAddition.getNameOfBook(), bookForAddition.getDescriptionOfBook());
    }

    public void printBookCatalog() {
        bookCatalog.printAllCatalog();
    }

    public void removeBook() {
        bookCatalog.removeBookFromCatalog();
    }

    public boolean verificationAdminPass(String password){
        if(password.hashCode() == adminPassword) return true;
        else return false;
    }

    public void sendEmailToUsers(String nameOfBook, String descriptionOfBook){
        String[] allEmails = readEmailsFromFile();
        Sender sender = new Sender("ВАШ ПАРОЛЬ АДМИНИСТРАТОРА", "ПАРОЛЬ ОТ НЕГО");
        for (String email : allEmails){
            sender.send("Книга " + nameOfBook + " появилась в библиотеке", descriptionOfBook, email);
        }
    }

    private String[] readEmailsFromFile(){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileReader fr = new FileReader("src/main/resources/Files/emails.txt");
            int c;
            while((c=fr.read())!=-1){
                stringBuilder.append((char)c);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String allEmailsToOneString = stringBuilder.toString();
        String [] allEmails = allEmailsToOneString.split("/");
        return allEmails;
    }
}
