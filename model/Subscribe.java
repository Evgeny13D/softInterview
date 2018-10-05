package A402.model;

/**
 * Created by Kapliarchuk_Y on 06/08/2018.
 */
public class Subscribe {
    private int id;
    private String email;
    private String dateAdd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", dateAdd='" + dateAdd + '\'' +
                '}';
    }
}
