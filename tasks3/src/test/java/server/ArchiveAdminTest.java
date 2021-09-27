package server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveAdminTest {

    @Test
    void authorizeArchiveAdmin() {
        ArchiveAdmin archiveAdmin = new ArchiveAdmin();

        String login = "admin111";
        String password = "adminpass111";

        boolean result = archiveAdmin.authorizeArchiveAdmin(login, password);
        assertEquals(true, result);
    }
}