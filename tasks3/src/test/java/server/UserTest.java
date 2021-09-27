package server;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    String s = "1";
    @Test
    void returnChosenCase(String s) {
        ArchiveAdmin archiveAdmin = new ArchiveAdmin();
        String actualResult = archiveAdmin.returnChosenCase(s);
        String expectedResult = "<cases.StudentsCase>\n" +
                "  <name>Andrey</name>\n" +
                "  <surname>Velb</surname>\n" +
                "  <age>25</age>\n" +
                "  <studyGroup>A1</studyGroup>\n" +
                "</cases.StudentsCase>";
        assertEquals(expectedResult, actualResult);
    }
}