package server;

import java.io.*;

public class ArchiveUser implements User{
    boolean authorizeArchiveUser(String login, String password){
	  try (DataInputStream dis = new DataInputStream(new FileInputStream("src/main/resources/userdata/ArchiveUser.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(dis))){
		String allUsersAsString = br.readLine();
		String [] archiveUsers = allUsersAsString.split("(\\:|\\/\\/)");
		for (int i = 0; i < archiveUsers.length; i++){
		    System.out.println(archiveUsers[i]);
		}
		for (int i = 0; i < archiveUsers.length; i = i + 2){
		    if(archiveUsers[i].equals(login)){
			  if(archiveUsers[i+1].equals(password)){
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
}
