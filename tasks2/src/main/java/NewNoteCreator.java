import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewNoteCreator {
    private List<Note> newNotes = new LinkedList<Note>();

    public void createNewNote(BufferedReader bufferedReader){
        String theme;
        String dateOfCreation;
        String email;
        String message;

        Note newNote;

        try {
            System.out.println("Введите тему заметки: ");
            theme = bufferedReader.readLine().trim();
            System.out.println("Введите дату заметки в формате DD.MM.YYYY: ");
            dateOfCreation = bufferedReader.readLine().trim();
            System.out.println("Введите email: ");
            email = bufferedReader.readLine().trim();
            System.out.println("Введите содержание заметки: ");
            message = bufferedReader.readLine().trim();

            if(newNoteValidation(theme,dateOfCreation,email,message)){
                newNote = new Note(theme, dateOfCreation, email, message);
                newNotes.add(newNote);
            }
            else{
                System.out.println("Вы ввели неправильные данные. Заметка не создана");
                return;
            }
        } catch (IOException e) {
            System.out.println("Данные введены некорректно. Заметка не создана");
            return;
        }
    }

    public void serialize(File notepad) {
        try {
            FileOutputStream fos = new FileOutputStream(notepad,true); ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < newNotes.size(); i++) {
                    oos.writeObject(newNotes.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean newNoteValidation(String theme, String dateOfCreation, String email, String message){
        if(themeValidation(theme) && dateValidation(dateOfCreation) && emailValidation(email) && messageValidtion(message)){
            return true;
        }
        else return false;
    }

    private boolean themeValidation(String theme){
        return theme.matches("^[a-zA-Zа-яА-ЯёЁ1-9\\ \\.\\,\\-\\!\\&\\?]+$");
    }

    private boolean dateValidation(String dateOfCreation){
        return dateOfCreation.matches("^((([0-2]{0,1})([1-9]{1}))|(3{1}[0-1]{1}))\\.{1}((0{1}[1-9]{1})|(1{1}[1-2]{1}))\\.\\d{4}$");
    }

    private boolean emailValidation(String email){
        return email.matches("^[a-zA-Z1-9\\.\\,\\-\\_]+[@]{1}\\w+[\\.]{1}\\w{2,4}$");
    }

    private boolean messageValidtion(String message){
        return message.matches("^[a-zA-Zа-яА-ЯёЁ1-9\\ \\.\\,\\-\\!\\&\\?]+$");
    }

    public List<Note> getNewNotes() {
        return newNotes;
    }

    public Note getNote(int i){
        return newNotes.get(i);
    }
}
