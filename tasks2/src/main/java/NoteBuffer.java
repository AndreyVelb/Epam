import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NoteBuffer {
    private ArrayList <Note> notesBuffer;

    public NoteBuffer(){
        notesBuffer = new ArrayList<Note>();
    }

    public void serialize(File notepad) {
        try {
            FileOutputStream fos = new FileOutputStream(notepad);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < notesBuffer.size(); i++) {
                    oos.writeObject(notesBuffer.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize(File notepad) {
        try (FileInputStream fis = new FileInputStream(notepad); ObjectInputStream ois = new ObjectInputStream(fis)){
            while (ois.available() >= -1) {
                this.notesBuffer.add((Note) ois.readObject());
            }
        }catch (EOFException e){
            return;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Note> search(ArrayList<Note> notesForSearch, String soughtString, FieldType fieldType){
        ArrayList<Note> foundNotes = new ArrayList<>();
        Pattern soughtPattern = Pattern.compile("[" + soughtString + "]+", Pattern.CASE_INSENSITIVE);
        for(int i = 0; i < notesForSearch.size(); i++){
            Matcher matcher = soughtPattern.matcher(notesForSearch.get(i).getFieldByFieldType(fieldType));
            if(matcher.find()){
                foundNotes.add(notesForSearch.get(i));
            }
        }
        return foundNotes;
    }

    public void add(Note note){
        notesBuffer.add(note);
    }

    public List<Note> getNotesBuffer() {
        return notesBuffer;
    }

}
