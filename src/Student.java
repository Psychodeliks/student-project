 import java.util.Objects;

public class Student {

    private String lastName;
    private boolean needsDorm;
    private String previousEdu;
    private String language;


    public Student() {
        this.lastName = "Неизвестно";
        this.needsDorm = false;
        this.previousEdu = "Неизвестно";
        this.language = "Неизвестно";
    }


    public Student(String lastName, boolean needsDorm, String previousEdu, String language) {
        setLastName(lastName);
        setNeedsDorm(needsDorm);
        setPreviousEdu(previousEdu);
        setLanguage(language);
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName;
        } else {
            this.lastName = "Иванов";
        }
    }

    public boolean isNeedsDorm() {
        return needsDorm;
    }

    public void setNeedsDorm(boolean needsDorm) {
        this.needsDorm = needsDorm;
    }

    public String getPreviousEdu() {
        return previousEdu;
    }

    public void setPreviousEdu(String previousEdu) {
        if (previousEdu != null && !previousEdu.trim().isEmpty()) {
            this.previousEdu = previousEdu;
        } else {
            this.previousEdu = "Школа";
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (language != null && !language.trim().isEmpty()) {
            this.language = language;
        } else {
            this.language = "Английский";
        }
    }


    @Override
    public String toString() {
        return String.format("Студент: %-10s | Общежитие: %-3s | Окончил: %-15s | Язык: %-10s",
                lastName, (needsDorm ? "Да" : "Нет"), previousEdu, language);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }
}