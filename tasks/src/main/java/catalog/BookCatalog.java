package catalog;

import accesssystem.Sender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    File bookCatalogFile = new File("src/main/resources/Files/bookcatalog.txt");
    private List<Book> bookCatalog = new ArrayList<>();

    public Book createBookForAddition(){
        Book newBook;
        String nameOfBook = null;
        String authorOfBook = null;
        String descriptionOfBook = null;
        int numberOfPages = 0;
        TypeOfBook typeOfBook = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите название книги: ");
            nameOfBook = reader.readLine();
            System.out.println("Введите фамилию и инициалы автора книги: ");
            authorOfBook = reader.readLine();
            System.out.println("Введите описание книги: ");
            descriptionOfBook = reader.readLine();
            if(isNull(nameOfBook) || isNull(authorOfBook) || isNull(descriptionOfBook)){
                System.out.println("Вы ввели неправильные данные. Книга не добавилась в каталог");
                return null;
            }
            System.out.println("Введите колличество страниц книги (целым числом): ");
            numberOfPages = Integer.parseInt(reader.readLine());
            if(numberOfPages <= 0){
                System.out.println("Вы ввели неправильные данные. Книга не добавилась в каталог");
                return null;
            }
            System.out.println("Выберите тип книги - \"бумажная\" или \"электронная\": ");
            System.out.println(" Нажмите 1 - если книга бумажная \n Нажмите 2 - если книга электронная ");
            int temp = Integer.parseInt(reader.readLine());
            if (temp == 1) {
                typeOfBook = TypeOfBook.PAPER;
            }
            else if (temp == 2) {
                typeOfBook = TypeOfBook.ELECTRONIC;
            }
            else {
                System.out.println("Вы ввели неправильные данные. Книга не добавилась в каталог");
                return null;
            }
        }
        catch (IOException e){
            System.out.println("Вы ввели неправильные данные. Книга не добавилась в каталог");
            return null;
        }
        catch (NumberFormatException e){
            System.out.println("Вы ввели неправильные данные (необходимо было ввести число). Книга не добавилась в каталог");
            return null;
        }
        newBook = new Book(nameOfBook,authorOfBook,descriptionOfBook,numberOfPages,typeOfBook);
        return newBook;
    }

    public void addBookToCatalog(Book bookForAddition){
        bookCatalog = deserialize();
        bookCatalog.add(bookForAddition);
        serialize(bookCatalog);
    }

    public void removeBookFromCatalog(){
        String nameOfBook = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите название книги которую хотите удалить: ");
            nameOfBook = reader.readLine();
            if(isFileEmpty(bookCatalogFile) == false) {
                bookCatalog = deserialize();
            }
            else {
                System.out.println("Каталог книг пуст. Чтобы что-то удалить для начала необходимо ввести данные");
                return;
            }
        }
        catch (IOException e) {
            System.out.println("Вы неправильно произвели ввод данных");
        }
        Book bookForDelete = searchByNameOfBook(nameOfBook);
        if(bookForDelete == null){
            System.out.println("Такая книга в каталоге не найдена");
            return;
        }
        else {
            bookCatalog.remove(bookForDelete);
        }
    }

    public Book searchByNameOfBook(String soughtNameOfBook){
        if(isFileEmpty(bookCatalogFile) == false) {
                bookCatalog = deserialize();
            for (Book book : bookCatalog){
                if(book.getNameOfBook() == soughtNameOfBook){
                return book;
            }
            else return null;
            }
        }
        return null;
    }

    public void printAllCatalog(){  // ТЕСТ МЕТОД
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Files/bookcatalog.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookCatalog = (List<Book>) ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не может быть найден");
        } catch (IOException e) {
            System.out.println("Файл не может быть прочитан");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Book book : bookCatalog){
            System.out.println(book);
        }
    }

    public List<Book> getBookCatalog(){
        if (isFileEmpty(bookCatalogFile) == false){
            return deserialize();
        }
        else return null;
    }

    private void serialize(List<Book> catalogForSerialize){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("src/main/resources/Files/bookcatalog.txt"); // не пишу true потому что буду еще делать СОРТИРОВКУ
            oos = new ObjectOutputStream(fos);                       // поэтому файл будет каждый раз при добавлении записываться заново
            oos.writeObject(catalogForSerialize);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует");
        } catch (EOFException e){
            try {
                oos.close();
                fos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода. Проверьте входные данные");
        }
    }

    private List<Book> deserialize(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> deserializeCatalog = new ArrayList<>();
        try {
            fis = new FileInputStream("src/main/resources/Files/bookcatalog.txt");
            ois = new ObjectInputStream(fis);
            deserializeCatalog = (List<Book>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (EOFException e){
            try {
                ois.close();
                fis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializeCatalog;
    }

    private boolean isNull(String s){
        if(s.equals(null)){
            return true;
        }
        else return false;
    }

    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
}
