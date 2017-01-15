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
            ResultSet set=statement.executeQuery("Select faculty.idFaculty, faculty.Name from faculty order by faculty.Name desc;");
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

    public List<Faculty> getFacultiesByGroupId(int groupid){
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT faculty.idFaculty, faculty.Name FROM faculty \n" +
                    "JOIN cafedra ON cafedra.idFaculty_fk = faculty.idFaculty\n" +
                    "JOIN speciality ON Speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "JOIN groupt ON GroupT.idSpeciality_fk = speciality.idSpeciality\n" +
                    "WHERE groupt.idGroup = ?");
            statement.setInt(1,groupid);
            List<Faculty> faculties=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Faculty faculty=new Faculty();
                faculty.setId(set.getInt("idFaculty"));
                faculty.setName(set.getString("faculty.Name"));
                faculties.add(faculty);
            }
            return faculties;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Group> getAllGroups(){
        try{
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("Select groupt.idGroup, groupT.Name from groupT order by GroupT.Name desc;");
            List<Group> groups=new ArrayList<>();
            while (set.next()){
                Group group=new Group();
                group.setId(set.getInt("idGroup"));
                group.setName(set.getString("Name"));
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Group> getGroupsByFacId(int facultyId){
        try{
            PreparedStatement statement=connection.prepareStatement("select groupt.idGroup, groupt.Name from groupt \n" +
                    "join speciality on groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "join cafedra on speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "join faculty on cafedra.idFaculty_fk = faculty.idFaculty\n" +
                    "where idFaculty = ?\n" +
                    "order by groupT.Name desc");
            statement.setInt(1,facultyId);
            List<Group> groups=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Group group=new Group();
                group.setId(set.getInt("idGroup"));
                group.setName(set.getString("Name"));
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Group> getGroupsByCafId(int cafedraId){
        try{
            PreparedStatement statement=connection.prepareStatement("select groupt.idGroup, groupt.Name from groupt \n" +
                    "join speciality on groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "join cafedra on speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "where idCafedra = ?\n" +
                    "order by groupt.Name desc");
            statement.setInt(1,cafedraId);
            List<Group> groups=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Group group=new Group();
                group.setId(set.getInt("idGroup"));
                group.setName(set.getString("Name"));
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Group> getGroupsBySpecId(int specialityId){
        try{
            PreparedStatement statement=connection.prepareStatement("select groupt.idGroup, groupt.Name from groupt \n" +
                    "join speciality on groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "where idSpeciality = ?\n" +
                    "order by groupt.Name desc");
            statement.setInt(1,specialityId);
            List<Group> groups=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Group group=new Group();
                group.setId(set.getInt("idGroup"));
                group.setName(set.getString("Name"));
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
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<SubjectWithTeachId> getAllSubjectsWithTeachId(){
        try{
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("select subject.idSubject, subject.Name, subject.idTeacher_fk from subject");
            List<SubjectWithTeachId> subjects=new ArrayList<>();
            while (set.next()){
                SubjectWithTeachId subject=new SubjectWithTeachId();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subject.setTeacherId(set.getInt("idTeacher_fk"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<SubjectWithTeacher> getAllSubjectsWithTeacherByGroupId(int groupId){
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT Subject.idSubject, Subject.Name,teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic\n" +
                    "FROM Subject \n" +
                    "JOIN teacher ON teacher.idTeacher=Subject.idTeacher_fk\n" +
                    "JOIN GroupSubject ON GroupSubject.idSubject = Subject.idSubject\n" +
                    "JOIN GroupT ON GroupSubject.idGroup = GroupT.idGroup\n" +
                    "WHERE GroupT.idGroup = ?");
            statement.setInt(1,groupId);
            ResultSet set=statement.executeQuery();
            List<SubjectWithTeacher> list=new ArrayList<>();
            while (set.next()){
                SubjectWithTeacher subject=new SubjectWithTeacher();
                subject.setIdS(set.getInt("idSubject"));
                subject.setNameS(set.getString("Subject.Name"));
                subject.setId(set.getInt("idTeacher"));
                subject.setSurname((set.getString("Surname")));
                subject.setName(set.getString("teacher.Name"));
                subject.setPatronymic(set.getString("Patronymic"));
                list.add(subject);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

       public List<Subject> getAllSubjectsByFacId(int facId){
        try{
            PreparedStatement statement=connection.prepareStatement("Select  subject.idSubject, subject.Name from subject\n" +
                    "join groupSubject on groupsubject.idSubject = subject.idSubject\n" +
                    "join groupt on groupsubject.idGroup = groupt.idGroup\n" +
                    "join speciality on groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "join cafedra on speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "join faculty on cafedra.idFaculty_fk = faculty.idFaculty\n" +
                    "where idFaculty = ?\n" +
                    "group by subject.idSubject");
            statement.setInt(1,facId);
            ResultSet set=statement.executeQuery();
            List<Subject> subjects=new ArrayList<>();
            while (set.next()){
                Subject subject=new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Subject> getAllSubjectsByGroupId(int groupId){
        try{
            PreparedStatement statement=connection.prepareStatement("select subject.idSubject, Subject.Name from Subject \n" +
                    "join GroupSubject on GroupSubject.idSubject = Subject.idSubject\n" +
                    "join GroupT on GroupSubject.idGroup = GroupT.idGroup\n" +
                    "where GroupT.idGroup = ?");
            statement.setInt(1,groupId);
            ResultSet set=statement.executeQuery();
            List<Subject> subjects=new ArrayList<>();
            while (set.next()){
                Subject subject=new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Subject> getAllSubjectsByCafId(int cafedraId){
        try{
            PreparedStatement statement=connection.prepareStatement("select subject.idSubject,subject.Name from Subject \n" +
                    "join GroupSubject on GroupSubject.idSubject = Subject.idSubject\n" +
                    "join GroupT on GroupT.idGroup = GroupSubject.idGroup       \n" +
                    "join Speciality on Speciality.idSpeciality = GroupT.idSpeciality_fk\n" +
                    "join Cafedra on Speciality.idCafedra_fk = Cafedra.idCafedra where Cafedra.idCafedra = ?");
            statement.setInt(1,cafedraId);
            ResultSet set=statement.executeQuery();
            List<Subject> subjects=new ArrayList<>();
            while (set.next()){
                Subject subject=new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Subject> getAllSubjectsBySpecId(int specId){
        try{
            PreparedStatement statement=connection.prepareStatement("select subject.idSubject,subject.Name from Subject \n" +
                    "join GroupSubject on GroupSubject.idSubject = Subject.idSubject\n" +
                    "join GroupT on GroupT.idGroup = GroupSubject.idGroup       \n" +
                    "join Speciality on Speciality.idSpeciality = GroupT.idSpeciality_fk\n" +
                    "where Speciality.idSpeciality = ?");
            statement.setInt(1,specId);
            ResultSet set=statement.executeQuery();
            List<Subject> subjects=new ArrayList<>();
            while (set.next()){
                Subject subject=new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            e.printStackTrace();
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
                cafedra.setName(set.getString("cafedra.Name"));
                cafedras.add(cafedra);
            }
            return cafedras;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Cafedra> getCafedrasbyFacId(int facultyId){
        try {
            PreparedStatement statement=connection.prepareStatement("select * from cafedra where (cafedra.idFaculty_fk = ?)");
            statement.setInt(1,facultyId);
            List<Cafedra> cafedras=new ArrayList<>();
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Cafedra cafedra=new Cafedra();
                cafedra.setId(resultSet.getInt("idCafedra"));
                cafedra.setName(resultSet.getString("cafedra.Name"));
                cafedras.add(cafedra);
            }
            return cafedras;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Cafedra> getCafedrasbyGroupId(int groupId){
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT Cafedra.idCafedra, Cafedra.Name FROM Cafedra \n" +
                    "JOIN Speciality ON Speciality.idCafedra_fk = Cafedra.idCafedra\n" +
                    "JOIN GroupT ON GroupT.idSpeciality_fk = Speciality.idSpeciality\n" +
                    "WHERE GroupT.idGroup = ?");
            statement.setInt(1,groupId);
            List<Cafedra> cafedras=new ArrayList<>();
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Cafedra cafedra=new Cafedra();
                cafedra.setId(resultSet.getInt("idCafedra"));
                cafedra.setName(resultSet.getString("cafedra.Name"));
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
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
           return null;
        }
    }

    public List<Speciality> getSpecialitites(int cafedraId){
        try{
            PreparedStatement statement=connection.prepareStatement("select speciality.idSpeciality, speciality.name from speciality\n" +
                    "join Cafedra on Speciality.idCafedra_fk = Cafedra.idCafedra\n" +
                    "where Cafedra.idCafedra = ?");
            statement.setInt(1,cafedraId);
            List<Speciality> specialities=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Speciality speciality=new Speciality();
                speciality.setId(set.getInt("idSpeciality"));
                speciality.setName(set.getString("speciality.Name"));
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Speciality> getSpecialititesByGroupId(int groupId){
        try{
            PreparedStatement statement=connection.prepareStatement("select Speciality.idSpeciality, Speciality.Name from Speciality \n" +
                    "join GroupT on GroupT.idSpeciality_fk = Speciality.idSpeciality\n" +
                    "where GroupT.idGroup = ?");
            statement.setInt(1,groupId);
            List<Speciality> specialities=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Speciality speciality=new Speciality();
                speciality.setId(set.getInt("idSpeciality"));
                speciality.setName(set.getString("Speciality.Name"));
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Teacher> getTeachersBySubName(String subName){
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic FROM teacher\n" +
                    "JOIN subject ON subject.idTeacher_fk=teacher.idTeacher\n" +
                    "WHERE subject.Name LIKE ?");
            statement.setString(1,subName);
            List<Teacher> teachers=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Teacher teacher=new Teacher();
                teacher.setId(set.getInt("teacher.idTeacher"));
                teacher.setSurname(set.getString("teacher.Surname"));
                teacher.setName(set.getString("teacher.Name"));
                teacher.setPatronymic(set.getString("teacher.Patronymic"));
                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Teacher> getTeachersBySubNameAndFacId(String subName,int facultyId){
        try{
            PreparedStatement statement=connection.prepareStatement("select distinct teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic from teacher\n" +
                    "join subject on subject.idTeacher_fk=teacher.idTeacher\n" +
                    "join groupsubject on groupsubject.idSubject=subject.idSubject\n" +
                    "join groupt on groupt.idGroup=groupsubject.idGroup\n" +
                    "join speciality on groupt.idSpeciality_fk=speciality.idSpeciality\n" +
                    "join cafedra on speciality.idCafedra_fk=cafedra.idCafedra\n" +
                    "where subject.Name like ? and cafedra.idFaculty_fk=?");
            statement.setString(1,subName);
            statement.setInt(2,facultyId);
            List<Teacher> teachers=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Teacher teacher=new Teacher();
                teacher.setId(set.getInt("teacher.idTeacher"));
                teacher.setSurname(set.getString("teacher.Surname"));
                teacher.setName(set.getString("teacher.Name"));
                teacher.setPatronymic(set.getString("teacher.Patronymic"));
                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Teacher> getTeachersBySubNameAndGroupId(String subName,int groupId){
        try{
            PreparedStatement statement=connection.prepareStatement("select distinct teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic from teacher\n" +
                    "join subject on subject.idTeacher_fk=teacher.idTeacher\n" +
                    "join groupsubject on groupsubject.idSubject=subject.idSubject\n" +
                    "where subject.Name like ? and groupsubject.idGroup=?");
            statement.setString(1,subName);
            statement.setInt(2,groupId);
            List<Teacher> teachers=new ArrayList<>();
            ResultSet set=statement.executeQuery();
            while (set.next()){
                Teacher teacher=new Teacher();
                teacher.setId(set.getInt("teacher.idTeacher"));
                teacher.setSurname(set.getString("teacher.Surname"));
                teacher.setName(set.getString("teacher.Name"));
                teacher.setPatronymic(set.getString("teacher.Patronymic"));
                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            return null;
        }
    }

}
