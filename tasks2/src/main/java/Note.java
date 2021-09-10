import java.io.Serializable;
import java.util.Objects;

public class Note implements Serializable {
    private String theme;
    private String dateOfCreation;
    private String email;
    private String message;

    public Note(String theme, String dateOfCreation, String email, String message) {
        this.theme = theme;
        this.dateOfCreation = dateOfCreation;
        this.email = email;
        this.message = message;
    }

    public String getFieldByFieldType(FieldType fieldType){
        if(fieldType == fieldType.THEME){
            return getTheme();
        }
        if(fieldType == FieldType.DATEOFCREATION){
            return getDateOfCreation();
        }
        if(fieldType == FieldType.EMAIL){
            return getEmail();
        }
        if (fieldType == FieldType.MESSAGE){
            return getMessage();
        }
        return "Ошибка, тип поля указан неверно!!!";
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Тема: " + theme + '\n' +
                "Дата создания: " + dateOfCreation + '\n'+
                "От: " + email + '\n'+
                "Текст заметки: " + message + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(theme, note.theme) && Objects.equals(dateOfCreation, note.dateOfCreation) && Objects.equals(email, note.email) && Objects.equals(message, note.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theme, dateOfCreation, email, message);
    }
}
