package A402.model;

import java.util.Date;
import java.util.Objects;

public class Event {
    private int id;
    private int dayOfMonth;
    private int monthNumber;
    private int dayOfWeekNumber;
    private int year;
    private Date startTime;
    private Date endTime;
    private String locationEn;
    private String locationRu;
    private String addressEn;
    private String addressRu;
    private String nameEn;
    private String nameRu;
    private String descriptionEn;
    private String descriptionRu;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getDayOfWeekNumber() {
        return dayOfWeekNumber;
    }

    public void setDayOfWeekNumber(int dayOfWeekNumber) {
        this.dayOfWeekNumber = dayOfWeekNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocationEn() {
        return locationEn;
    }

    public void setLocationEn(String locationEn) {
        this.locationEn = locationEn;
    }

    public String getLocationRu() {
        return locationRu;
    }

    public void setLocationRu(String locationRu) {
        this.locationRu = locationRu;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public String getAddressRu() {
        return addressRu;
    }

    public void setAddressRu(String addressRu) {
        this.addressRu = addressRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                dayOfMonth == event.dayOfMonth &&
                monthNumber == event.monthNumber &&
                dayOfWeekNumber == event.dayOfWeekNumber &&
                year == event.year &&
                Double.compare(event.price, price) == 0 &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(endTime, event.endTime) &&
                Objects.equals(locationEn, event.locationEn) &&
                Objects.equals(locationRu, event.locationRu) &&
                Objects.equals(addressEn, event.addressEn) &&
                Objects.equals(addressRu, event.addressRu) &&
                Objects.equals(nameEn, event.nameEn) &&
                Objects.equals(nameRu, event.nameRu) &&
                Objects.equals(descriptionEn, event.descriptionEn) &&
                Objects.equals(descriptionRu, event.descriptionRu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dayOfMonth, monthNumber, dayOfWeekNumber, year, startTime, endTime, locationEn, locationRu, addressEn, addressRu, nameEn, nameRu, descriptionEn, descriptionRu, price);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", dayOfMonth=" + dayOfMonth +
                ", monthNumber=" + monthNumber +
                ", dayOfWeekNumber=" + dayOfWeekNumber +
                ", year=" + year +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", locationEn='" + locationEn + '\'' +
                ", locationRu='" + locationRu + '\'' +
                ", addressEn='" + addressEn + '\'' +
                ", addressRu='" + addressRu + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", nameRu='" + nameRu + '\'' +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", price=" + price +
                '}';
    }
}
