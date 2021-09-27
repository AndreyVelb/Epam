package cases;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.security.NoPermission;

import java.io.*;
import java.nio.file.Path;

public class MarshallerToXML {
    private static XStream xStream = new XStream();


    public static void marshaleCaseToXML(StudentsCase studentsCase){
        Path path = createXMLFile(studentsCase);
        String xml = xStream.toXML(studentsCase);
        xStream.allowTypeHierarchy(StudentsCase.class);


        try {
            FileWriter writer = new FileWriter(path.toString());
            writer.write(xml);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentsCase demarshaleCaseFromXml(File file){
        xStream.allowTypeHierarchy(StudentsCase.class);
        StudentsCase studentsCase = (StudentsCase) xStream.fromXML(file);      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        return studentsCase;
    }

    private static Path createXMLFile(StudentsCase studentsCase){
        String casename = studentsCase.getName() + studentsCase.getSurname() + ".xml";
        File studentCase = new File("src/main/resources/archive", casename);
        try {
            studentCase.createNewFile();
        } catch (IOException e) {
            System.out.println("File not created");
            e.printStackTrace();
        }
        return studentCase.toPath();
    }
}
