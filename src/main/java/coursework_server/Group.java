package coursework_server;

/**
 * Created by aleks on 11.01.2017.
 */
public class Group {
    private int id;
    private String name;
    private int specialityId;
    private String specilaityName;

    public Group() {
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

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecilaityName() {
        return specilaityName;
    }

    public void setSpecilaityName(String specilaityName) {
        this.specilaityName = specilaityName;
    }
}
