package A402.model;

import A402.controller.exception.InvalidParameterException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Kapliarchuk_Y on 08/08/2018.
 */
public class Event_NV {
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
    private String type;
    private String status;
    private String linkOfImage;
    private double price;
    private double priceS16;
    private double priceS712;
    private double priceS13;
    private double priceS14;
    private int r1s1;
    private int r1s2;
    private int r1s3;
    private int r1s4;
    private int r1s5;
    private int r1s6;
    private int r1s7;
    private int r2s1;
    private int r2s2;
    private int r2s3;
    private int r2s4;
    private int r2s5;
    private int r2s6;
    private int r2s7;

    public String getLinkOfImage() {
        return linkOfImage;
    }

    public void setLinkOfImage(String linkOfImage) {
        this.linkOfImage = linkOfImage;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceS16() {
        return priceS16;
    }

    public void setPriceS16(double priceS16) {
        this.priceS16 = priceS16;
    }

    public double getPriceS712() {
        return priceS712;
    }

    public void setPriceS712(double priceS712) {
        this.priceS712 = priceS712;
    }

    public double getPriceS13() {
        return priceS13;
    }

    public void setPriceS13(double priceS13) {
        this.priceS13 = priceS13;
    }

    public double getPriceS14() {
        return priceS14;
    }

    public void setPriceS14(double priceS14) {
        this.priceS14 = priceS14;
    }

    public int getR1s1() {
        return r1s1;
    }

    public void setR1s1(int r1s1) {
        this.r1s1 = r1s1;
    }

    public int getR1s2() {
        return r1s2;
    }

    public void setR1s2(int r1s2) {
        this.r1s2 = r1s2;
    }

    public int getR1s3() {
        return r1s3;
    }

    public void setR1s3(int r1s3) {
        this.r1s3 = r1s3;
    }

    public int getR1s4() {
        return r1s4;
    }

    public void setR1s4(int r1s4) {
        this.r1s4 = r1s4;
    }

    public int getR1s5() {
        return r1s5;
    }

    public void setR1s5(int r1s5) {
        this.r1s5 = r1s5;
    }

    public int getR1s6() {
        return r1s6;
    }

    public void setR1s6(int r1s6) {
        this.r1s6 = r1s6;
    }

    public int getR1s7() {
        return r1s7;
    }

    public void setR1s7(int r1s7) {
        this.r1s7 = r1s7;
    }

    public int getR2s1() {
        return r2s1;
    }

    public void setR2s1(int r2s1) {
        this.r2s1 = r2s1;
    }

    public int getR2s2() {
        return r2s2;
    }

    public void setR2s2(int r2s2) {
        this.r2s2 = r2s2;
    }

    public int getR2s3() {
        return r2s3;
    }

    public void setR2s3(int r2s3) {
        this.r2s3 = r2s3;
    }

    public int getR2s4() {
        return r2s4;
    }

    public void setR2s4(int r2s4) {
        this.r2s4 = r2s4;
    }

    public int getR2s5() {
        return r2s5;
    }

    public void setR2s5(int r2s5) {
        this.r2s5 = r2s5;
    }

    public int getR2s6() {
        return r2s6;
    }

    public void setR2s6(int r2s6) {
        this.r2s6 = r2s6;
    }

    public int getR2s7() {
        return r2s7;
    }

    public void setR2s7(int r2s7) {
        this.r2s7 = r2s7;
    }

    @Override
    public String toString() {
        return "Event_NV{" +
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
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", linkOfImage='" + linkOfImage + '\'' +
                ", price=" + price +
                ", priceS16=" + priceS16 +
                ", priceS712=" + priceS712 +
                ", priceS13=" + priceS13 +
                ", priceS14=" + priceS14 +
                ", r1s1=" + r1s1 +
                ", r1s2=" + r1s2 +
                ", r1s3=" + r1s3 +
                ", r1s4=" + r1s4 +
                ", r1s5=" + r1s5 +
                ", r1s6=" + r1s6 +
                ", r1s7=" + r1s7 +
                ", r2s1=" + r2s1 +
                ", r2s2=" + r2s2 +
                ", r2s3=" + r2s3 +
                ", r2s4=" + r2s4 +
                ", r2s5=" + r2s5 +
                ", r2s6=" + r2s6 +
                ", r2s7=" + r2s7 +
                '}';
    }

    public int getSeat(String seatColumn) {
        switch (seatColumn) {
            case "r1s1":
                return r1s1;
            case "r1s2":
                return r1s2;
            case "r1s3":
                return r1s3;
            case "r1s4":
                return r1s4;
            case "r1s5":
                return r1s5;
            case "r1s6":
                return r1s6;
            case "r1s7":
                return r1s7;
            case "r2s1":
                return r2s1;
            case "r2s2":
                return r2s2;
            case "r2s3":
                return r2s3;
            case "r2s4":
                return r2s4;
            case "r2s5":
                return r2s5;
            case "r2s6":
                return r2s6;
            case "r2s7":
                return r2s7;
            default:
                return -1;
        }
    }

    public void setSeat(String seatColumn, int value) {
        switch (seatColumn) {
            case "r1s1":
                r1s1 = value;
                return;
            case "r1s2":
                r1s2 = value;
                return;
            case "r1s3":
                r1s3 = value;
                return;
            case "r1s4":
                r1s4 = value;
                return;
            case "r1s5":
                r1s5 = value;
                return;
            case "r1s6":
                r1s6 = value;
                return;
            case "r1s7":
                r1s7 = value;
                return;
            case "r2s1":
                r2s1 = value;
                return;
            case "r2s2":
                r2s2 = value;
                return;
            case "r2s3":
                r2s3 = value;
                return;
            case "r2s4":
                r2s4 = value;
                return;
            case "r2s5":
                r2s5 = value;
                return;
            case "r2s6":
                r2s6 = value;
                return;
            case "r2s7":
                r2s7 = value;
                return;
        }
    }

    public double getSeatPrice(String seatCode) {
        switch (seatCode) {
            case "r1s1":
                return priceS16;
            case "r1s2":
                return priceS16;
            case "r1s3":
                return priceS16;
            case "r1s4":
                return priceS16;
            case "r1s5":
                return priceS16;
            case "r1s6":
                return priceS16;
            case "r1s7":
                return priceS712;
            case "r2s1":
                return priceS712;
            case "r2s2":
                return priceS712;
            case "r2s3":
                return priceS712;
            case "r2s4":
                return priceS712;
            case "r2s5":
                return priceS712;
            case "r2s6":
                return priceS13;
            case "r2s7":
                return priceS14;
            default:
                throw new InvalidParameterException(String.format("incorrect seat code [%s]", seatCode));
        }
    }

    public List<Integer> getSeatParticipants() {
        return Arrays.asList(
                r1s1,
                r1s2,
                r1s3,
                r1s4,
                r1s5,
                r1s6,
                r1s7,
                r2s1,
                r2s2,
                r2s3,
                r2s4,
                r2s5,
                r2s6,
                r2s7
        );

    }
}
