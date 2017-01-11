package coursework_server;

/**
 * Created by aleks on 11.01.2017.
 */
public class Speciality {
    private int id;
    private int cafedraId;
    private String name;

    public String getCafedraName() {
        return cafedraName;
    }

    public void setCafedraName(String cafedraName) {
        this.cafedraName = cafedraName;
    }

    private String cafedraName;

    public Speciality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCafedraId() {
        return cafedraId;
    }

    public void setCafedraId(int cafedraId) {
        this.cafedraId = cafedraId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
