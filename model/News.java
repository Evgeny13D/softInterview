package A402.model;

public class News {
    private int id;
    private String ru_title;
    private String ru_description;
    private String ru_info;
    private String en_title;
    private String en_description;
    private String en_info;
    private String added;
    private String update;
    private String status;

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRu_title() {
        return ru_title;
    }

    public void setRu_title(String ru_title) {
        this.ru_title = ru_title;
    }

    public String getRu_description() {
        return ru_description;
    }

    public void setRu_description(String ru_description) {
        this.ru_description = ru_description;
    }

    public String getRu_info() {
        return ru_info;
    }

    public void setRu_info(String ru_info) {
        this.ru_info = ru_info;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getEn_description() {
        return en_description;
    }

    public void setEn_description(String en_description) {
        this.en_description = en_description;
    }

    public String getEn_info() {
        return en_info;
    }

    public void setEn_info(String en_info) {
        this.en_info = en_info;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", ru_title='" + ru_title + '\'' +
                ", ru_description='" + ru_description + '\'' +
                ", ru_info='" + ru_info + '\'' +
                ", en_title='" + en_title + '\'' +
                ", en_description='" + en_description + '\'' +
                ", en_info='" + en_info + '\'' +
                ", added='" + added + '\'' +
                ", update='" + update + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
