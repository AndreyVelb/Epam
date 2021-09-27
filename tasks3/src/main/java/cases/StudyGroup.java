package cases;

import com.thoughtworks.xstream.core.util.Pool;

public enum StudyGroup {
    A1, A2, A3, A4, B1, B2, B3, B4;

    public static StudyGroup factoryStudyOfGroup(String clientMessage){
        switch (clientMessage){
            case "1" -> {
                return StudyGroup.A1;
            }
            case "2" -> {
                return StudyGroup.A2;
            }
            case "3" -> {
                return StudyGroup.A3;
            }
            case "4" -> {
                return StudyGroup.A4;
            }
            case "5" -> {
                return StudyGroup.B1;
            }
            case "6" -> {
                return StudyGroup.B2;
            }
            case "7" -> {
                return StudyGroup.B3;
            }
            case "8" -> {
                return StudyGroup.B4;
            }
        }
        return null;
    }
}
