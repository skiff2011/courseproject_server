package coursework_server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void putAttest(int marks, int lection, int works, int attest, Connection connection,int subId){
        try {
            PreparedStatement statement1=connection.prepareStatement("update AttestationOne set Status=? where(idStudent_fk=? AND idSubject_fk=?)");
            PreparedStatement statement2=connection.prepareStatement("update AttestationTwo set Status=? where(idStudent_fk=? AND idSubject_fk=?)");
            statement1.setInt(2,id);
            statement2.setInt(2,id);
            statement1.setInt(3,subId);
            statement2.setInt(3,subId);
            if(this.marks>=marks&&this.lections>=lection&&this.works>=works){
                if(attest==1) {
                    this.attest1 = "C";
                    statement1.setString(1,"C");
                    statement1.execute();
                } else {
                    this.attest2 = "C";
                    statement2.setString(1,"C");
                    statement2.execute();
                }
            }else {
                if(attest==1) {
                    this.attest1 = "NC";
                    statement1.setString(1,"NC");
                    statement1.execute();
                } else {
                    this.attest2 = "NC";
                    statement2.setString(1,"NC");
                    statement2.execute();
                }
            }
            statement1.close();
            statement2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", marks=" + marks +
                ", lections=" + lections +
                ", works=" + works +
                ", attest1='" + attest1 + '\'' +
                ", attest2='" + attest2 + '\'' +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student student=(Student)obj;
        if(id!=student.id)
            return false;
        return true;
    }
}
