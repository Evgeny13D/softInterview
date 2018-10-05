package A402.model;

/**
 * Created by Kapliarchuk_Y on 24/07/2018.
 */
public class Articles {
    private int id;
    private String ru_title;
    private String en_title;
    private String ru_description;
    private String en_description;
    private String ru_content;
    private String en_content;
    private String date;
    private String updateDate;
    private String category;
    private String ru_linkAtach;
    private String en_linkAtach;
    private String link_ofImage;

    private int likes;
    private int views;

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

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getRu_description() {
        return ru_description;
    }

    public void setRu_description(String ru_description) {
        this.ru_description = ru_description;
    }

    public String getEn_description() {
        return en_description;
    }

    public void setEn_description(String en_description) {
        this.en_description = en_description;
    }

    public String getRu_content() {
        return ru_content;
    }

    public void setRu_content(String ru_content) {
        this.ru_content = ru_content;
    }

    public String getEn_content() {
        return en_content;
    }

    public void setEn_content(String en_content) {
        this.en_content = en_content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRu_linkAtach() {
        return ru_linkAtach;
    }

    public void setRu_linkAtach(String ru_linkAtach) {
        this.ru_linkAtach = ru_linkAtach;
    }

    public String getEn_linkAtach() {
        return en_linkAtach;
    }

    public void setEn_linkAtach(String en_linkAtach) {
        this.en_linkAtach = en_linkAtach;
    }

    public String getLink_ofImage() {
        return link_ofImage;
    }

    public void setLink_ofImage(String link_ofImage) {
        this.link_ofImage = link_ofImage;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", ru_title='" + ru_title + '\'' +
                ", en_title='" + en_title + '\'' +
                ", ru_description='" + ru_description + '\'' +
                ", en_description='" + en_description + '\'' +
                ", ru_content='" + ru_content + '\'' +
                ", en_content='" + en_content + '\'' +
                ", date='" + date + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", category='" + category + '\'' +
                ", ru_linkAtach='" + ru_linkAtach + '\'' +
                ", en_linkAtach='" + en_linkAtach + '\'' +
                ", link_ofImage='" + link_ofImage + '\'' +
                ", likes=" + likes +
                ", views=" + views +
                '}';
    }
}
