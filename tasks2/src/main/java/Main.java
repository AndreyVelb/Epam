import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        BufferedReader reader = PublicBufferedReader.reader;
        try {
            String usersChoise = null;
            do{
                System.out.println("Введите 1 если хотите сделать заметку");
                System.out.println("Введите 2 если хотите работать с уже существующими заметками");
                System.out.println("Введите 4 если хотите завершить работу");
                try {
                    usersChoise = reader.readLine();

                    if (usersChoise.equals("1")){
                        fileManager.createNewNotes();
                    }

                    else if (usersChoise.equals("2")){
                        String usersChoise2 = null;
                        do {
                            System.out.println("Если вы хотите искать по одному параметру - введите 1 \n" +
                                               "Если вы хотите искать по многим параметрам - введите 2 \n" +
                                               "Если хотите выйти - введите 4");
                            usersChoise2 = reader.readLine();

                            if(usersChoise2.equals("1")){
                                fileManager.searchAndPrintFoundNotesByOneParameter();
                            }
                            if (usersChoise2.equals("2")){
                                fileManager.searchAndPrintFoundNotesByAllParameters();
                            }
                        }
                        while (usersChoise2.equals("4") != true);
                    }

                } catch (IOException e) {
                    System.out.println("Вы сделали некорректный выбор");
                }
            }
            while (usersChoise.equals("4") != true);
        } finally {
            fileManager.serializeAllNotesToFile();
            PublicBufferedReader.closeReader();
        }

    }
}
