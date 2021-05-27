
//3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
//из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
//номеров групп студентов, имеющих оценки, равные только 9 или 10.

public class ProtozoaClassesAndObj3 {
    public static void main(String[] args) {
        Student ivanov = new Student("Ivanov A.B.", 1, new int[]{9, 10, 9, 10, 10});
        Student avdeev = new Student("Avdeev V.A.", 2, new int[]{8, 7, 6, 9, 10});
        Student kruglikov = new Student("Kruglikov S.V.", 1, new int[]{10, 9, 9, 10, 10});
        Student petrov = new Student("Petrov A.A.", 2, new int[]{4,2,6,10,7});
        Student sergeev = new Student("Sergeev S.A.", 1, new int[]{4,7,9,10,7});
        Student kapustina = new Student("Kapustina A.I.", 2, new int[]{10,10,10,10,10});
        Student ololoeva = new Student("Ololoeva O.O.", 1, new int[]{4,9,5,10,7});
        Student sivuho = new Student("Sivuho I.A.", 2, new int[]{1,2,3,2,4});
        Student aleksandrov = new Student("Alexandrov A.A.", 1, new int[]{3,2,7,10,7});
        Student gorunov = new Student("Gorunov V.A.", 2, new int[]{9,9,9,9,9});

        Student [] students = new Student[]{ivanov, avdeev, kruglikov,kapustina,aleksandrov,
                                            petrov,ololoeva, sivuho,gorunov,sergeev};

        for (int i = 0; i < students.length; i++){
            excellentStudents(students[i].surnameAndInitials, students[i].groupsNumber, students[i].studentProgress);
        }

    }
    public static void excellentStudents(String surnameAndInitials, int groupsNumber, int[] studentProgress){
            boolean isExcellentStudent = true;
            for (int j = 0; j < studentProgress.length; j++){
                if(studentProgress[j] < 9){
                    isExcellentStudent = false;
                    continue;
                }
            }
            if(isExcellentStudent){
                System.out.println("Student " + surnameAndInitials + " from " + groupsNumber + " group studying excellent");
            }

    }
}
class Student{
    public String surnameAndInitials;
    public int groupsNumber;
    public int [] studentProgress = new int[5];
    public Student (String surnameAndInitials, int groupsNumber, int[] studentProgress){
        this.surnameAndInitials = surnameAndInitials;
        this.groupsNumber = groupsNumber;
        this.studentProgress = studentProgress;

    }
}

