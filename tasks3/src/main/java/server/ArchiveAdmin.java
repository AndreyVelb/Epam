package server;

import cases.MarshallerToXML;
import cases.StudentsCase;

import java.io.*;

class ArchiveAdmin implements User{
    boolean authorizeArchiveAdmin(String login, String password){
        try ( DataInputStream dis = new DataInputStream(new FileInputStream("src/main/resources/userdata/ArchiveAdmins.txt"));
	  BufferedReader br = new BufferedReader(new InputStreamReader(dis))){
	      String allAdminsAsString = br.readLine();
	      String [] archiveAdmins = allAdminsAsString.split("(\\:|\\/\\/)");
		for (int i = 0; i < archiveAdmins.length; i = i + 2){
		    if(archiveAdmins[i].equals(login)){
			  if(archiveAdmins[i+1].equals(password)){
			      return true;
			  }
		    }
		}
	  } catch (FileNotFoundException e) {
		  e.printStackTrace();
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  return false;
    }

    synchronized public StudentsCase makeChangeableStudentsCase(String clientAnswer){
	  StudentsCase studentsCase = MarshallerToXML.demarshaleCaseFromXml(returnChosenFile(clientAnswer));
	  return studentsCase;
    }

    synchronized public void makeChangingStudentCase(StudentsCase studentsCase, String clientAnswer){
        File file = returnChosenFile(clientAnswer);
        if (file.delete()){
            MarshallerToXML.marshaleCaseToXML(studentsCase);
	  }
    }
}
