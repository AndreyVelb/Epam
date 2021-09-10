import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
    private File notepad = new File("C:\\Users\\home\\notepad.txt");
    private NoteBuffer notesBuffer = new NoteBuffer();
    private NewNoteCreator newNotes = new NewNoteCreator();;

    public FileManager(){
        if(notepad.exists() == false){
            createNewFile();
            notesBuffer = new NoteBuffer();
        }
        else {
            notesBuffer.deserialize(notepad);
        }
    }

    public void searchAndPrintFoundNotesByAllParameters(){
            ArrayList<Note> foundByTheme;
            System.out.println("Введите тему которую хотите найти, или ведите \"-\" если хотите пропустить этот параметр в поиске ");
            String theme = inputSearchQuery();
            if (theme != null && !theme.equals("-")) {
                foundByTheme = NoteBuffer.search((ArrayList<Note>) notesBuffer.getNotesBuffer(), theme, FieldType.THEME);
            }
            else {
                foundByTheme = (ArrayList<Note>) notesBuffer.getNotesBuffer();
            }

            ArrayList<Note> foundByDateOfCreation;
            System.out.println("Введите дату создания которую хотите найти, или ведите \"-\" если хотите пропустить этот параметр в поиске ");
            String dateOfCreation = inputSearchQuery();
            if (dateOfCreation != null && !dateOfCreation.equals("-")) {
                foundByDateOfCreation = NoteBuffer.search(foundByTheme, dateOfCreation, FieldType.DATEOFCREATION);
            }
            else {
                foundByDateOfCreation = foundByTheme;
            }

            ArrayList<Note> foundByEmail;
            System.out.println("Введите почту которую хотите найти, или ведите \"-\" если хотите пропустить этот параметр в поиске ");
            String email = inputSearchQuery();
            if (email != null && !email.equals("-")) {
                foundByEmail = NoteBuffer.search(foundByDateOfCreation, email, FieldType.EMAIL);
            }
            else {
                foundByEmail = foundByDateOfCreation;
            }

            ArrayList<Note> foundByMessage;
            System.out.println("Введите текст заметки которую хотите найти, или ведите \"-\" если хотите пропустить этот параметр в поиске ");
            String message = inputSearchQuery();
            if (message != null && !message.equals("-")) {
                foundByMessage = NoteBuffer.search(foundByEmail, message, FieldType.MESSAGE);
            }
            else {
                foundByMessage = foundByEmail;
            }
            printArrayListOfNotes(foundByMessage);
    }

    public void searchAndPrintFoundNotesByOneParameter(){
        ArrayList<Note> foundNotes;
        FieldType fieldType = inputFieldTypeForSearching();
        String searchQuery = inputSearchQuery();
        foundNotes = NoteBuffer.search((ArrayList<Note>) notesBuffer.getNotesBuffer(), searchQuery, fieldType);
        printArrayListOfNotes(foundNotes);
    }

    public void serializeAllNotesToFile(){
        if(notesBuffer != null){
            notesBuffer.serialize(notepad);
        }
    }

    public void createNewNotes(){
        BufferedReader bufferedReader = PublicBufferedReader.reader;
        newNotes.createNewNote(bufferedReader);
        notesBuffer.add(newNotes.getNote(newNotes.getNewNotes().size() - 1));
    }

    private void createNewFile(){
        try {
            notepad.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Файл по какой-то причине не создан");
        }
    }

    private String inputSearchQuery(){
        String usersSearchQuere = null;
        BufferedReader reader = PublicBufferedReader.reader;
        try {
            System.out.println("Введите запрос для поиска: ");
            usersSearchQuere = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return usersSearchQuere;
    }

    private FieldType inputFieldTypeForSearching(){
        FieldType fieldType = null;
        String userChoise;
        BufferedReader reader = PublicBufferedReader.reader;
        try {
            do {
                System.out.println("Если вы хотите произвести поиск по теме - введите 1 \n" +
                        "Если вы хотите произвести поиск по дате создания - введите 2 \n" +
                        "Если вы хотите произвести поиск по почте - введите 3 \n" +
                        "Если вы хотите произвести поиск по содержимому заметки - введите 4 \n");

                userChoise = reader.readLine();

                switch (userChoise) {
                    case "1" -> fieldType = FieldType.THEME;
                    case "2" -> fieldType = FieldType.DATEOFCREATION;
                    case "3" -> fieldType = FieldType.EMAIL;
                    case "4" -> fieldType = FieldType.MESSAGE;
                }
            }
            while (fieldType == null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return fieldType;
    }

    private void printArrayListOfNotes(ArrayList<Note> arrayList){
        for (Note note : arrayList){
            System.out.println(note.toString());
        }
    }


}
