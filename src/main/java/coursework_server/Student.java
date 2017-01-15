package coursework_server;

/**
 * Created by aleks on 15.01.2017.
 */
public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int marks;
    private int lections;
    private int works;
    private String attest1;
    private String attest2;
    private int sum;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getLections() {
        return lections;
    }

    public void setLections(int lections) {
        this.lections = lections;
    }

    public int getWorks() {
        return works;
    }

    public void setWorks(int works) {
        this.works = works;
    }

    public String getAttest1() {
        return attest1;
    }

    public void setAttest1(String attest1) {
        this.attest1 = attest1;
    }

    public String getAttest2() {
        return attest2;
    }

    public void setAttest2(String attest2) {
        this.attest2 = attest2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
