package server;

import cases.StudentCasesCreator;
import cases.StudentsCase;
import cases.StudyGroup;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerClientThread extends Thread{
    private Socket serverClient;
    private int clientNumber;

    ServerClientThread(Socket serverClient, int counter){
        this.serverClient = serverClient;
        clientNumber = counter;
    }

    @Override
    public void run(){
        try (DataInputStream dis = new DataInputStream(serverClient.getInputStream());
        DataOutputStream dos = new DataOutputStream(serverClient.getOutputStream())){
            String clientMessage = "";
            String serverMessage = "";

            while (clientMessage.equalsIgnoreCase("exit") == false){
                serverMessage = "How want you enter to the server? \n"
                              + " - press 1 to enter as Archive Administrator \n"
                              + " - press 2 to enter as Archive User";

                dos.writeUTF(serverMessage);
                dos.flush();
                clientMessage = dis.readUTF();
                String login;
                String password;

                serverMessage = "Enter your login: ";
                dos.writeUTF(serverMessage);
                dos.flush();

                login = dis.readUTF();

                serverMessage = "Enter your password: ";
                dos.writeUTF(serverMessage);
                dos.flush();

                password = dis.readUTF();

                User user = authorizeUser(clientMessage, login, password);
                if (user instanceof ArchiveAdmin){
                    user = new ArchiveAdmin();

                    while (clientMessage.equals("4") == false) {
                        serverMessage = "- Press 1 if you wanna request to view a students case \n"
                                    + "- Press 2 if you wanna make changes in a student case \n"
                                    + "- Press 3 if you wanna create a new student case \n"
                                    + "- Press 4 if you wanna go back through the menu \n"
                                    + "- Press \"exit\" if you wanna finish a work";
                        dos.writeUTF(serverMessage);
                        dos.flush();
                        clientMessage = dis.readUTF();

                        if(clientMessage.equals("4")){
                            break;
                        }

                        if(clientMessage.equals("1")){
                            serverMessage = user.returnAllArchivedCasesNames();
                            dos.writeUTF(serverMessage);
                            dos.flush();

                            String clientAnswer = dis.readUTF();
                            serverMessage = user.returnChosenCase(clientAnswer) + "\n Press \"4\" for finish work ";
                            dos.writeUTF(serverMessage);
                            dos.flush();
                        }

                        if(clientMessage.equals("2")){
                            serverMessage = user.returnAllArchivedCasesNames();
                            dos.writeUTF(serverMessage);
                            dos.flush();

                            String clientAnswer = dis.readUTF();
                            StudentsCase studentsCase = ((ArchiveAdmin) user).makeChangeableStudentsCase(clientAnswer);

                            serverMessage = "Choose a parameter which you want changing \n"
                            + "if you wanna change: \n"
                            + "name - \"1\"\n"
                            + "surname - \"2\"\n"
                            + "age - \"3\"\n"
                            + "study group - \"4\"\n";
                            dos.writeUTF(serverMessage);
                            dos.flush();

                            clientMessage = dis.readUTF();
                            while (true) {
                                String parameter;
                                if (clientMessage.equals("1")) {
                                    serverMessage = "Enter the new name";
                                    dos.writeUTF(serverMessage);
                                    dos.flush();
                                    parameter = dis.readUTF();

                                    studentsCase.setName(parameter);
                                }
                                if (clientMessage.equals("2")) {
                                    serverMessage = "Enter the new surname";
                                    dos.writeUTF(serverMessage);
                                    dos.flush();
                                    parameter = dis.readUTF();

                                    studentsCase.setSurname(parameter);
                                }
                                if (clientMessage.equals("3")) {
                                    serverMessage = "Enter the new age";
                                    dos.writeUTF(serverMessage);
                                    dos.flush();
                                    parameter = dis.readUTF();
                                    if(StudentCasesCreator.ageCheck(parameter) != true){
                                        serverMessage = "You entered incorrectly information";
                                        dos.writeUTF(serverMessage);
                                        dos.flush();
                                        break;
                                    }
                                    int newAge = Integer.parseInt(parameter);
                                    studentsCase.setAge(newAge);
                                }
                                if (clientMessage.equals("4")) {
                                    serverMessage = "\"Enter the new study group: \n" +
                                            "study group A1 - press 1 \n" +
                                            "study group A2 - press 2 \n" +
                                            "study group A3 - press 3 \n" +
                                            "study group A4 - press 4 \n" +
                                            "study group B1 - press 5 \n" +
                                            "study group B2 - press 6 \n" +
                                            "study group B3 - press 7 \n" +
                                            "study group B4 - press 8 \n";
                                    dos.writeUTF(serverMessage);
                                    dos.flush();

                                    parameter = dis.readUTF();
                                    int studyGroupNumber;
                                    try {
                                        studyGroupNumber = Integer.parseInt(parameter);
                                    } catch (NumberFormatException e) {
                                        serverMessage = "You entered incorrectly information";
                                        dos.writeUTF(serverMessage);
                                        dos.flush();
                                        break;
                                    }
                                    if ( studyGroupNumber > 8){
                                        serverMessage = "You entered incorrectly information";
                                        dos.writeUTF(serverMessage);
                                        dos.flush();
                                        break;
                                    }
                                    StudyGroup studyGroup = StudyGroup.factoryStudyOfGroup(parameter);
                                    studentsCase.setStudyGroup(studyGroup);
                                }
                                ((ArchiveAdmin) user).makeChangingStudentCase(studentsCase,clientAnswer);
                                break;
                            }
                        }
                        if(clientMessage.equals("3")){
                            String name;
                            String surname;
                            int age = -1;
                            StudyGroup studyGroup = null;

                            while (true) {
                                serverMessage = "Enter the name of new students case";
                                dos.writeUTF(serverMessage);
                                dos.flush();
                                name = dis.readUTF();

                                serverMessage = "Enter the surname of new students case";
                                dos.writeUTF(serverMessage);
                                dos.flush();
                                surname = dis.readUTF();;

                                serverMessage = "Enter the age of new students case";
                                dos.writeUTF(serverMessage);
                                dos.flush();
                                String ageOfString = dis.readUTF();
                                if(StudentCasesCreator.ageCheck(ageOfString) == false){
                                    serverMessage = "Student case is not created. Parameter age entered incorrectly";
                                    dos.writeUTF(serverMessage);
                                    dos.flush();
                                    break;
                                }
                                else {
                                    age = Integer.parseInt(ageOfString);
                                }

                                serverMessage = "Enter the study group of new students case \n"
                                + "study group A1 - press 1 \n"
                                + "study group A2 - press 2 \n"
                                + "study group A3 - press 3 \n"
                                + "study group A4 - press 4 \n"
                                + "study group B1 - press 5 \n"
                                + "study group B2 - press 6 \n"
                                + "study group B3 - press 7 \n"
                                + "study group B4 - press 8 \n";
                                dos.writeUTF(serverMessage);
                                dos.flush();
                                if (StudyGroup.factoryStudyOfGroup(dis.readUTF()).equals(null)){
                                    serverMessage = "Student case is not created. Parameter study group entered incorrectly";
                                    dos.writeUTF(serverMessage);
                                    dos.flush();
                                    break;
                                }
                                else {
                                    studyGroup = StudyGroup.factoryStudyOfGroup(clientMessage);
                                }
                                break;
                            }
                            StudentCasesCreator.createStudentCase(name, surname, age, studyGroup);

                        }
                    }
                }
                if(user instanceof ArchiveUser) {
                    user = new ArchiveUser();
                    while (clientMessage.equals("4") == false) {
                        serverMessage = "- Press 1 if you wanna request to view a students case \n"
                                + "- Press 4 if you wanna go back through the menu \n"
                                + "- Press \"exit\" if you wanna finish a work";
                        dos.writeUTF(serverMessage);
                        dos.flush();

                        clientMessage = dis.readUTF();

                        if (clientMessage.equals("4")){
                            break;
                        }

                        if (clientMessage.equals("1")) {
                            serverMessage = user.returnAllArchivedCasesNames();
                            dos.writeUTF(serverMessage);
                            dos.flush();

                            clientMessage = dis.readUTF();
                            serverMessage = user.returnChosenCase(clientMessage) + "\n Press \"4\" for finish work ";
                            dos.writeUTF(serverMessage);
                            dos.flush();
                        }
                    }
                }
            }
            serverClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Client № " + clientNumber + " passed out");
        }
    }

    private User authorizeUser(String clientMessage, String login, String password){
        User user = null;
        switch (clientMessage){
            case "1" -> {
                ArchiveAdmin archiveAdmin = new ArchiveAdmin();
                if(archiveAdmin.authorizeArchiveAdmin(login, password)){
                    user =  archiveAdmin;
                    return user;
                }
                else {
                    return null;
                }
            }
            case "2" -> {
                ArchiveUser archiveUser = new ArchiveUser();
                if(archiveUser.authorizeArchiveUser(login, password)){
                    user =  archiveUser;
                    return user;
                }
                else {
                    return null;
                }
            }
        }
        return null;
    }
}
