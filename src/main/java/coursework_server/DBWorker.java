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

    public List<Faculty> getFaculties() {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT faculty.idFaculty, faculty.Name FROM faculty ORDER BY faculty.Name ASC ;");
            List<Faculty> faculties = new ArrayList<>();
            while (set.next()) {
                Faculty faculty = new Faculty();
                faculty.setId(set.getInt("idFaculty"));
                faculty.setName(set.getString("Name"));
                faculties.add(faculty);
            }
            return faculties;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Faculty> getFacultiesByGroupId(int groupid) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT faculty.idFaculty, faculty.Name FROM faculty \n" +
                    "JOIN cafedra ON cafedra.idFaculty_fk = faculty.idFaculty\n" +
                    "JOIN speciality ON Speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "JOIN groupt ON GroupT.idSpeciality_fk = speciality.idSpeciality\n" +
                    "WHERE groupt.idGroup = ?");
            statement.setInt(1, groupid);
            List<Faculty> faculties = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Faculty faculty = new Faculty();
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

    public List<Group> getAllGroups() {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT groupt.idGroup, groupT.Name FROM groupT ORDER BY GroupT.Name ASC ;");
            List<Group> groups = new ArrayList<>();
            while (set.next()) {
                Group group = new Group();
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

    public List<Group> getGroupsByFacId(int facultyId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT groupt.idGroup, groupt.Name FROM groupt \n" +
                    "JOIN speciality ON groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "JOIN cafedra ON speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "JOIN faculty ON cafedra.idFaculty_fk = faculty.idFaculty\n" +
                    "WHERE idFaculty = ?\n" +
                    "ORDER BY groupT.Name ASC ");
            statement.setInt(1, facultyId);
            List<Group> groups = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Group group = new Group();
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

    public List<Group> getGroupsByCafId(int cafedraId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT groupt.idGroup, groupt.Name FROM groupt \n" +
                    "JOIN speciality ON groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "JOIN cafedra ON speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "WHERE idCafedra = ?\n" +
                    "ORDER BY groupt.Name ASC ");
            statement.setInt(1, cafedraId);
            List<Group> groups = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Group group = new Group();
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

    public List<Group> getGroupsBySpecId(int specialityId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT groupt.idGroup, groupt.Name FROM groupt \n" +
                    "JOIN speciality ON groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "WHERE idSpeciality = ?\n" +
                    "ORDER BY groupt.Name ASC ");
            statement.setInt(1, specialityId);
            List<Group> groups = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Group group = new Group();
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

    public List<Subject> getAllSubjects() {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT idSubject,subject.Name,subject.idTeacher_fk,teacher.SurName,teacher.Name,teacher.Patronymic FROM subject\n" +
                    "JOIN teacher ON idTeacher_fk=teacher.idTeacher");
            List<Subject> subjects = new ArrayList<>();
            while (set.next()) {
                Subject subject = new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<SubjectWithTeachId> getAllSubjectsWithTeachId() {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT subject.idSubject, subject.Name, subject.idTeacher_fk FROM subject");
            List<SubjectWithTeachId> subjects = new ArrayList<>();
            while (set.next()) {
                SubjectWithTeachId subject = new SubjectWithTeachId();
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

    public List<SubjectWithTeacher> getAllSubjectsWithTeacherByGroupId(int groupId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT Subject.idSubject, Subject.Name,teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic\n" +
                    "FROM Subject \n" +
                    "JOIN teacher ON teacher.idTeacher=Subject.idTeacher_fk\n" +
                    "JOIN GroupSubject ON GroupSubject.idSubject = Subject.idSubject\n" +
                    "JOIN GroupT ON GroupSubject.idGroup = GroupT.idGroup\n" +
                    "WHERE GroupT.idGroup = ?");
            statement.setInt(1, groupId);
            ResultSet set = statement.executeQuery();
            List<SubjectWithTeacher> list = new ArrayList<>();
            while (set.next()) {
                SubjectWithTeacher subject = new SubjectWithTeacher();
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

    public List<Subject> getAllSubjectsByFacId(int facId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT  subject.idSubject, subject.Name FROM subject\n" +
                    "JOIN groupSubject ON groupsubject.idSubject = subject.idSubject\n" +
                    "JOIN groupt ON groupsubject.idGroup = groupt.idGroup\n" +
                    "JOIN speciality ON groupt.idSpeciality_fk = speciality.idSpeciality\n" +
                    "JOIN cafedra ON speciality.idCafedra_fk = cafedra.idCafedra\n" +
                    "JOIN faculty ON cafedra.idFaculty_fk = faculty.idFaculty\n" +
                    "WHERE idFaculty = ?\n" +
                    "GROUP BY subject.idSubject");
            statement.setInt(1, facId);
            ResultSet set = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while (set.next()) {
                Subject subject = new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Subject> getAllSubjectsByGroupId(int groupId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT subject.idSubject, Subject.Name FROM Subject \n" +
                    "JOIN GroupSubject ON GroupSubject.idSubject = Subject.idSubject\n" +
                    "JOIN GroupT ON GroupSubject.idGroup = GroupT.idGroup\n" +
                    "WHERE GroupT.idGroup = ?");
            statement.setInt(1, groupId);
            ResultSet set = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while (set.next()) {
                Subject subject = new Subject();
                subject.setId(set.getInt("idSubject"));
                subject.setName(set.getString("Name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Subject> getAllSubjectsByCafId(int cafedraId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT subject.idSubject,subject.Name FROM Subject \n" +
                    "JOIN GroupSubject ON GroupSubject.idSubject = Subject.idSubject\n" +
                    "JOIN GroupT ON GroupT.idGroup = GroupSubject.idGroup       \n" +
                    "JOIN Speciality ON Speciality.idSpeciality = GroupT.idSpeciality_fk\n" +
                    "JOIN Cafedra ON Speciality.idCafedra_fk = Cafedra.idCafedra WHERE Cafedra.idCafedra = ?");
            statement.setInt(1, cafedraId);
            ResultSet set = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while (set.next()) {
                Subject subject = new Subject();
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

    public List<Subject> getAllSubjectsBySpecId(int specId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT subject.idSubject,subject.Name FROM Subject \n" +
                    "JOIN GroupSubject ON GroupSubject.idSubject = Subject.idSubject\n" +
                    "JOIN GroupT ON GroupT.idGroup = GroupSubject.idGroup       \n" +
                    "JOIN Speciality ON Speciality.idSpeciality = GroupT.idSpeciality_fk\n" +
                    "WHERE Speciality.idSpeciality = ?");
            statement.setInt(1, specId);
            ResultSet set = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while (set.next()) {
                Subject subject = new Subject();
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


    public List<Cafedra> getAllCafedras() {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT idCafedra,cafedra.Name,idFaculty_fk,faculty.Name FROM courseworkschema.cafedra\n" +
                    "JOIN faculty ON cafedra.idFaculty_fk=faculty.idFaculty");
            List<Cafedra> cafedras = new ArrayList<>();
            while (set.next()) {
                Cafedra cafedra = new Cafedra();
                cafedra.setId(set.getInt("idCafedra"));
                cafedra.setName(set.getString("cafedra.Name"));
                cafedras.add(cafedra);
            }
            return cafedras;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Cafedra> getCafedrasbyFacId(int facultyId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cafedra WHERE (cafedra.idFaculty_fk = ?)");
            statement.setInt(1, facultyId);
            List<Cafedra> cafedras = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cafedra cafedra = new Cafedra();
                cafedra.setId(resultSet.getInt("idCafedra"));
                cafedra.setName(resultSet.getString("cafedra.Name"));
                cafedras.add(cafedra);
            }
            return cafedras;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Cafedra> getCafedrasbyGroupId(int groupId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT Cafedra.idCafedra, Cafedra.Name FROM Cafedra \n" +
                    "JOIN Speciality ON Speciality.idCafedra_fk = Cafedra.idCafedra\n" +
                    "JOIN GroupT ON GroupT.idSpeciality_fk = Speciality.idSpeciality\n" +
                    "WHERE GroupT.idGroup = ?");
            statement.setInt(1, groupId);
            List<Cafedra> cafedras = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cafedra cafedra = new Cafedra();
                cafedra.setId(resultSet.getInt("idCafedra"));
                cafedra.setName(resultSet.getString("cafedra.Name"));
                cafedras.add(cafedra);
            }
            return cafedras;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Speciality> getAllSpecialitites() {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT speciality.idSpeciality,speciality.Name,speciality.idCafedra_fk,cafedra.Name\n" +
                    "FROM speciality\n" +
                    "JOIN cafedra ON cafedra.idCafedra=speciality.idCafedra_fk");
            List<Speciality> specialities = new ArrayList<>();
            while (set.next()) {
                Speciality speciality = new Speciality();
                speciality.setId(set.getInt("speciality.idSpeciality"));
                speciality.setName(set.getString("speciality.Name"));
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Speciality> getSpecialitites(int cafedraId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT speciality.idSpeciality, speciality.name FROM speciality\n" +
                    "JOIN Cafedra ON Speciality.idCafedra_fk = Cafedra.idCafedra\n" +
                    "WHERE Cafedra.idCafedra = ?");
            statement.setInt(1, cafedraId);
            List<Speciality> specialities = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Speciality speciality = new Speciality();
                speciality.setId(set.getInt("idSpeciality"));
                speciality.setName(set.getString("speciality.Name"));
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Speciality> getSpecialititesByGroupId(int groupId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT Speciality.idSpeciality, Speciality.Name FROM Speciality \n" +
                    "JOIN GroupT ON GroupT.idSpeciality_fk = Speciality.idSpeciality\n" +
                    "WHERE GroupT.idGroup = ?");
            statement.setInt(1, groupId);
            List<Speciality> specialities = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Speciality speciality = new Speciality();
                speciality.setId(set.getInt("idSpeciality"));
                speciality.setName(set.getString("Speciality.Name"));
                specialities.add(speciality);
            }
            return specialities;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Teacher> getTeachersBySubName(String subName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic FROM teacher\n" +
                    "JOIN subject ON subject.idTeacher_fk=teacher.idTeacher\n" +
                    "WHERE subject.Name LIKE ?");
            statement.setString(1, subName);
            List<Teacher> teachers = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Teacher teacher = new Teacher();
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

    public List<Teacher> getTeachersBySubNameAndFacId(String subName, int facultyId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic FROM teacher\n" +
                    "JOIN subject ON subject.idTeacher_fk=teacher.idTeacher\n" +
                    "JOIN groupsubject ON groupsubject.idSubject=subject.idSubject\n" +
                    "JOIN groupt ON groupt.idGroup=groupsubject.idGroup\n" +
                    "JOIN speciality ON groupt.idSpeciality_fk=speciality.idSpeciality\n" +
                    "JOIN cafedra ON speciality.idCafedra_fk=cafedra.idCafedra\n" +
                    "WHERE subject.Name LIKE ? AND cafedra.idFaculty_fk=?");
            statement.setString(1, subName);
            statement.setInt(2, facultyId);
            List<Teacher> teachers = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Teacher teacher = new Teacher();
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

    public List<Teacher> getTeachersBySubNameAndGroupId(String subName, int groupId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT teacher.idTeacher,teacher.Surname,teacher.Name,teacher.Patronymic FROM teacher\n" +
                    "JOIN subject ON subject.idTeacher_fk=teacher.idTeacher\n" +
                    "JOIN groupsubject ON groupsubject.idSubject=subject.idSubject\n" +
                    "WHERE subject.Name LIKE ? AND groupsubject.idGroup=?");
            statement.setString(1, subName);
            statement.setInt(2, groupId);
            List<Teacher> teachers = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Teacher teacher = new Teacher();
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

    public List<Student> getStudentsBySubAndGroup(int subId, int groupId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT Student.idStudent, Student.Surname, Student.Name," +
                    " Student.Patronymic, ProgressStudent.Marks, ProgressStudent.Lections, ProgressStudent.Works," +
                    " AttestationOne.Status, AttestationTwo.Status\n" +
                    "FROM Subject \n" +
                    "JOIN GroupSubject ON GroupSubject.idSubject = Subject.idSubject\n" +
                    "JOIN GroupT ON GroupSubject.idGroup = GroupT.idGroup\n" +
                    "JOIN Student ON Student.idGroup_fk = GroupT.idGroup\n" +
                    "JOIN ProgressStudent ON ProgressStudent.idStudent_fk = Student.idStudent\n" +
                    "LEFT JOIN AttestationOne ON AttestationOne.idStudent_fk = Student.idStudent\n" +
                    "LEFT JOIN AttestationTwo ON AttestationTwo.idStudent_fk = Student.idStudent\n" +
                    "WHERE (GroupT.idGroup = ? AND ProgressStudent.idSubject_fk = ?)");
            statement.setInt(1, groupId);
            statement.setInt(2, subId);
            List<Student> students = new ArrayList<>();
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("Student.idStudent"));
                student.setSurname(set.getString("Student.Surname"));
                student.setName(set.getString("Student.Name"));
                student.setPatronymic(set.getString("Student.Patronymic"));
                student.setMarks(set.getInt("ProgressStudent.Marks"));
                student.setLections(set.getInt("ProgressStudent.Lections"));
                student.setWorks(set.getInt("ProgressStudent.Works"));
                student.setSum(student.getMarks() + student.getWorks() + student.getLections());
                if (set.getString("AttestationOne.Status") == null)
                    student.setAttest1("");
                else
                    student.setAttest1(set.getString("AttestationOne.Status"));
                if (set.getString("AttestationTwo.Status") == null)
                    student.setAttest2("");
                else
                    student.setAttest2(set.getString("AttestationTwo.Status"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
