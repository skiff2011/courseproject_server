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

}
