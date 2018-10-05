package A402.model;

import java.util.Objects;

public class Seat {
    private int id;
    private int rowNumber;
    private int seatNumber;
    private double price;
    private int eventId;
    private int participantId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id &&
                rowNumber == seat.rowNumber &&
                seatNumber == seat.seatNumber &&
                Double.compare(seat.price, price) == 0 &&
                eventId == seat.eventId &&
                participantId == seat.participantId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rowNumber, seatNumber, price, eventId, participantId);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", eventId=" + eventId +
                ", participantId=" + participantId +
                '}';
    }
}
