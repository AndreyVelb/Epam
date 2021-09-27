package cases;

import java.io.File;
import java.io.IOException;

public class StudentsCase {

    private String name;



    private String surname;

    private int age;

    private StudyGroup studyGroup;

    public StudentsCase(){};

    public StudentsCase(String name, String surname, int age, StudyGroup studyGroup) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.studyGroup = studyGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }
}
