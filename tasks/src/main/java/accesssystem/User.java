package accesssystem;

import catalog.Book;
import catalog.BookCatalog;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {
    private String userLogin;
    private String userPassword;
    private String email;
    private int numberOfUserInSystem;

    public String getEmail() {
        return email;
    }

    private BookCatalog bookCatalog = new BookCatalog();

    public void searchBook() throws IOException {
        String soughtNameOfBook = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите название книги которую хотите найти: ");
            soughtNameOfBook = reader.readLine();
        } catch (IOException e) {
            System.out.println("Вы неправильно произвели ввод данных");
        }
        Book soughtBook = bookCatalog.searchByNameOfBook(soughtNameOfBook);
        if (soughtBook == null) {
            System.out.println("Такая книга не найдена");
        } else {
            System.out.println("Книга найдена");
            System.out.println(soughtBook.toString());
        }
    }

    public List<Book> reviewCatalog() {
        List<Book> bookList = bookCatalog.getBookCatalog();

        if (bookList != null) {
            return bookList;
        } else return null;
    }

    public void registrationUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MessageDigest messageDigest;
        try {
            System.out.println("Введите логин под которых хотите зарегестрироваться");
            this.userLogin = reader.readLine();
            System.out.println("Введите пароль под которым будете заходить в систему");
            this.userPassword = reader.readLine();
            System.out.println("Введите ваш email на который будет происходить рассылка");
            this.email = reader.readLine();
        } catch (IOException e) {
            System.out.println("При регистрации вы ввели неправильные данные, Вы не можете быть зарегестрированы");
        }
        writeEmailToFile(this.email);
        byte[] userHash;

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] password = userPassword.getBytes(StandardCharsets.UTF_8);
            byte[] login = userLogin.getBytes(StandardCharsets.UTF_8);
            messageDigest.update(password);
            messageDigest.update(login);
            userHash = messageDigest.digest();

            FileOutputStream fos = new FileOutputStream("src/main/resources/Files/usersdata.txt", true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.write(userHash);

            dos.close();
            fos.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verificationUser() {
        int countUser = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MessageDigest messageDigest;

        String verificationLogin;
        String verificationPass;

        try {
            System.out.println("Введите ваш логин");
            verificationLogin = reader.readLine();
            System.out.println("Введите ваш пароль");
            verificationPass = reader.readLine();
        } catch (IOException e) {
            System.out.println("Вы вводите некорректные данные");
            return false;
        }

        byte[] verPass = verificationPass.getBytes(StandardCharsets.UTF_8);
        byte[] verLogin = verificationLogin.getBytes(StandardCharsets.UTF_8);

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(verPass);
            messageDigest.update(verLogin);
            byte[] verificationDigest = messageDigest.digest();
            FileInputStream fis = new FileInputStream("src/main/resources/Files/usersdata.txt");
            DataInputStream dis = new DataInputStream(fis);
            byte[] byteArray = new byte[32];

            for (int i = 0; i <= dis.available(); i++) {
                for (int j = 0; j < 32; j++) {
                    byteArray[j] = dis.readByte();
                }
                if (MessageDigest.isEqual(verificationDigest, byteArray) == true) {
                    dis.close();
                    fis.close();
                    this.numberOfUserInSystem = countUser;  //инициализация переменной countUser, которая необходима для поиска email пользователя
                    return true;
                }
                i += 31;
                countUser ++;
            }
            dis.close();
            fis.close();
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void askAddBook(){
        String bookForAdding = new String();
        String userEmailPass = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите название книги которую вы хотели бы видеть в библиотеке");
            bookForAdding = reader.readLine();
            System.out.println("Введите пароль от вашей почты которую вы использовали при регистрации");
            userEmailPass = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendMailToAdmin(bookForAdding, userEmailPass);
    }

    private void sendMailToAdmin(String bookForAdding, String userEmailPass){
        String userEmail;
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

        userEmail = allEmails[numberOfUserInSystem];

        Sender sender = new Sender(userEmail, userEmailPass);
        sender.send("Предложение по добавлению книги", "Добавьте пожалуйста в библиотеку книгу " + bookForAdding, "ВАШ ПАРОЛЬ АДМИНИСТРАТОРА");
    }

    private void writeEmailToFile(String email){
        try {
            FileWriter fw = new FileWriter("src/main/resources/Files/emails.txt", true);
            fw.write(email + "/");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}