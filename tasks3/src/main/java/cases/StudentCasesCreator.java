package cases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentCasesCreator {
    public static void main(String[] args) {
        StudentsCase studentsCase = new StudentsCase("Andrey", "Velb", 25, StudyGroup.A1);
        MarshallerToXML.marshaleCaseToXML(studentsCase);
        StudentsCase studentsCase1 = new StudentsCase("Victor", "Ivanov", 22, StudyGroup.A2);
        MarshallerToXML.marshaleCaseToXML(studentsCase1);
        StudentsCase studentsCase2 = new StudentsCase("Evgeniy", "Shepelev", 21, StudyGroup.A1);
        MarshallerToXML.marshaleCaseToXML(studentsCase2);
        StudentsCase studentsCase3 = new StudentsCase("Victoria", "Burova", 23, StudyGroup.B4);
        MarshallerToXML.marshaleCaseToXML(studentsCase3);
        StudentsCase studentsCase4 = new StudentsCase("Alesya", "Petrova", 22, StudyGroup.A2);
        MarshallerToXML.marshaleCaseToXML(studentsCase4);

    }
    synchronized public static void createStudentCase(String name, String surname, int age, StudyGroup studyGroup){
        StudentsCase studentsCase = new StudentsCase(name, surname, age, studyGroup);
        MarshallerToXML.marshaleCaseToXML(studentsCase);
    }

    public static boolean ageCheck(String age){
        if (age.matches("(([1][0-4][0-9])3|([0-9][0-9]))")){
            return true;
        }
        return false;
    }
}
