package server;

import java.io.*;

public interface User {

    default String returnChosenCase(String clientMessage){
        File chosenFile = returnChosenFile(clientMessage);
        if(chosenFile.equals(null)){
            return "There's a no such case in the archive!";
        }
        try (Reader reader = new FileReader(chosenFile);
             BufferedReader br = new BufferedReader(reader);){

            String str;
            StringBuffer stringBuffer = new StringBuffer();
            while ((str = br.readLine()) != null){
                stringBuffer.append(str + "\n");
            }
            return stringBuffer.toString();
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "There's a no such case in the archive";
    }

    default String returnAllArchivedCasesNames(){
        File[] archiveFiles = returnAllArchivedCases();
        String [] archiveFileNames = new String[archiveFiles.length];
        for (int i = 0; i  <archiveFiles.length; i++){
            archiveFileNames[i] = archiveFiles[i].getName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < archiveFileNames.length; i++) {
            stringBuffer.append(i + ". " + archiveFileNames[i] + "\n");
        }
        return stringBuffer.toString();
    }

    default File [] returnAllArchivedCases(){
        File folder = new File("src/main/resources/archive");
        File [] archiveFiles = folder.listFiles();
        return archiveFiles;
    }

    default File returnChosenFile(String clientMessage){
        try {
            int caseNumber = Integer.parseInt(clientMessage);
            File [] archiveFiles = returnAllArchivedCases();
            if (caseNumber > archiveFiles.length - 1){
                return null;
            }
            return archiveFiles[caseNumber];
        }catch (NumberFormatException e){
            return null;
        }
    }
}
