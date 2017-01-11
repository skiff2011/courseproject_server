package coursework_server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleks on 11.01.2017.
 */
public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/courseworkschema";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public DBWorker() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection.isClosed());
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Faculty> getFaculties(){
        try{
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT * FROM faculty");
            List<Faculty> faculties=new ArrayList<>();
            while (set.next()){
                Faculty faculty=new Faculty();
                faculty.setId(set.getInt("idFaculty"));
                faculty.setName(set.getString("Name"));
                faculties.add(faculty);
            }
            return faculties;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Group> getAllGroups(){
        try{
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT idGroup,groupt.Name,idSpeciality_fk,speciality.Name AS spec_name FROM groupt\n" +
                    "JOIN speciality ON groupt.idSpeciality_fk=speciality.idSpeciality");
            List<Group> groups=new ArrayList<>();
            while (set.next()){
                Group group=new Group();
                group.setId(set.getInt("idGroup"));
                group.setName(set.getString("Name"));
                group.setSpecialityId(set.getInt("idSpeciality_fk"));
                group.setSpecilaityName(set.getString("spec_name"));
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Subject> getAllSubjects(){
        try{
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("select idSubject,subject.Name,subject.idTeacher_fk,teacher.SurName,teacher.Name,teacher.Patronymic from subject\n" +
                    "join teacher on idTeacher_fk=teacher.idTeacher");
            List<Subject> subjects=new ArrayList<>();
            while (set.next()){
                Subject subject=new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setTeacherId(set.getInt("idTeacher_fk"));
                subject.setSubjectName(set.getString("subject.Name"));
                subject.setSurname(set.getString("teacher.SurName"));
                subject.setName(set.getString("teacher.Name"));
                subject.setPatronymic("teacher.Patronymic");
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Cafedra> getAllCafedras(){
        try {
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT idCafedra,cafedra.Name,idFaculty_fk,faculty.Name FROM courseworkschema.cafedra\n" +
                    "JOIN faculty ON cafedra.idFaculty_fk=faculty.idFaculty");
            List<Cafedra> cafedras=new ArrayList<>();
            while (set.next()){
                Cafedra cafedra=new Cafedra();
                cafedra.setId(set.getInt("idCafedra"));
                cafedra.setFacultyId(set.getInt("idFaculty_fk"));
                cafedra.setName(set.getString("cafedra.Name"));
                cafedra.setFacultyName("faculty.Name");
                cafedras.add(cafedra);
            }
            return cafedras;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Speciality> getAllSpecialitites(){
        try{
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT speciality.idSpeciality,speciality.Name,speciality.idCafedra_fk,cafedra.Name\n" +
                    "FROM speciality\n" +
                    "JOIN cafedra ON cafedra.idCafedra=speciality.idCafedra_fk");
            List<Speciality> specialities=new ArrayList<>();
            while (set.next()){
                Speciality speciality=new Speciality();
                speciality.setId(set.getInt("speciality.idSpeciality"));
                speciality.setName(set.getString("speciality.Name"));
                speciality.setCafedraId(set.getInt("speciality.idCafedra_fk"));
                speciality.setCafedraName(set.getString("cafedra.Name"));
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
           return null;
        }
    }

}
