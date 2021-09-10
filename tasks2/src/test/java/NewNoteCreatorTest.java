import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class NewNoteCreatorTest {

    @Test
    public void createNewNote() throws IOException {
        NewNoteCreator newNoteCreator = new NewNoteCreator();

        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine()).thenReturn("Тема заметки","12.12.1999", "name@mail.com", "Содержание заметки");

        Note testNote = new Note("Тема заметки", "12.12.1999", "name@mail.com", "Содержание заметки");

        newNoteCreator.createNewNote(bufferedReader);
        bufferedReader.close();
        Note noteFromNewNoteList = newNoteCreator.getNewNotes().get(0);
        Assert.assertEquals(testNote, noteFromNewNoteList);
    }

}