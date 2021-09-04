package accesssystem;

import catalog.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleUserInterface {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String entrance = null;

        start:
        do{
            System.out.println("Войти в учетную запись как");
            System.out.println("Администратор - нажмите 1");
            System.out.println("Пользователь - нажмите 2");
            System.out.println("Если хотите выйти - нажмите 4");
            try {
                entrance = reader.readLine();
                if (entrance.equals("1")){               //Вход Admina
                    Admin admin = new Admin();
                    String adminPassword;

                    do {
                        System.out.println("Введите пароль администатора");
                        System.out.println("Чтобы выйти обратно в меню входа нажмите 4");

                        adminPassword = reader.readLine();

                        if(admin.verificationAdminPass(adminPassword) == true){   // Admin вошел в систему
                            String choiseAdmin;
                            do{
                                System.out.println("Добавить книгу в библиотеку - нажмите 1");
                                System.out.println("Удалить книгу из библиотеки - нажмите 2");
                                System.out.println("Если хотите выйти - нажмите 4");

                                choiseAdmin = reader.readLine();

                                if(choiseAdmin.equals("1")){
                                    admin.addBook();
                                }
                                else if(choiseAdmin.equals("2")){
                                    admin.removeBook();
                                }
                            }
                            while (choiseAdmin.equals("4") == false);
                        }
                        else if (adminPassword.equals("4")){
                            break;
                        }
                    }
                    while (admin.verificationAdminPass(adminPassword) == false);
                }
                else if(entrance.equals("2")){             //Вход Usera
                    User user = new User();
                    String choiseUser ;
                    do {
                        System.out.println("Если вы зарегестрированы, чтобы войти в систему - Нажмите 1");
                        System.out.println("Если вы не зарегестрированы, чтобы пройти регистрацию - Нажмите 2");
                        System.out.println("Выйти - Нажмите 4");

                        choiseUser = reader.readLine();

                        if(choiseUser.equals("1")) {

                                if (user.verificationUser() == true) {

                                    String choiseVerificationUser;
                                    do {
                                        System.out.println("Искать книгу по названию в каталоге - Нажмите 1");
                                        System.out.println("Просмотреть весь каталог по страницам - Нажмите 2");
                                        System.out.println("Попросить администратора добавить книгу в каталог - Нажмите 3");
                                        System.out.println("Выйти - Нажмите 4");

                                        choiseVerificationUser = reader.readLine();

                                        if (choiseVerificationUser.equals("1")) {
                                            user.searchBook();
                                        } else if (choiseVerificationUser.equals("2")) {
                                            List<Book> catalog;
                                            int page = 0;
                                            if (user.reviewCatalog() != null) {
                                                catalog = user.reviewCatalog();
                                            } else {
                                                System.out.println("Каталог пуст");
                                                break;
                                            }

                                            System.out.println(catalog.get(page).toString());
                                            String choiseUserInCatalog;
                                            do {
                                                System.out.println("Чтобы перейти на следующую страницу - Нажмите 1");
                                                System.out.println("Чтобы вернуться на предыдущую страницу - Нажмите 2");
                                                System.out.println("Чтобы выйти - Нажмите 4");

                                                choiseUserInCatalog = reader.readLine();

                                                if (choiseUserInCatalog.equals("1")) {
                                                    page++;
                                                    if(page == catalog.size()){
                                                        page = 0;
                                                    }
                                                    System.out.println(catalog.get(page).toString());
                                                } else if (choiseUserInCatalog.equals("2")) {
                                                    page--;
                                                    if(page < 0){
                                                        page = catalog.size() - 1;
                                                    }
                                                    System.out.println(catalog.get(page).toString());
                                                }
                                            }
                                            while (choiseUserInCatalog.equals("4") == false);
                                        }
                                        else if (choiseVerificationUser.equals("3")){
                                            user.askAddBook();
                                        }
                                    }
                                    while (choiseVerificationUser.equals("4") == false);
                                } else
                                    System.out.println("Такого пользователя нет. Возможно вы ошиблись с паролем или еще не зарегестрированы");

                        }
                        else if(choiseUser.equals("2")) {
                            user.registrationUser();
                        }
                    }
                    while (choiseUser.equals("4") == false);
                }

                else if (entrance.equals("4")){
                    reader.close();
                    System.exit(0);                             //Выход из программы
                }
            } catch (IOException e) {
                System.out.println("Вы ввели некорректные данные. Попробуйте еще раз");
            } catch (NumberFormatException e){
                System.out.println("Вы ввели не число, попробуйте еще раз");
                continue start;
            }
        }
        while (true);


    }
}
