package coursework_server;

/**
 * Created by aleks on 14.01.2017.
 */
public class SubjectWithTeachId {
    private int id;
    private String name;
    private int teacherId;

    public SubjectWithTeachId() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
