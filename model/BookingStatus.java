package A402.model;

import A402.controller.exception.InvalidParameterException;
//import com.sun.javaws.exceptions.InvalidArgumentException;

public enum BookingStatus {
    BOOKED("B","Booked"),
    PAYED("P","Payed");

    private String dbRepresentation;
    private String viewRepresentation;

    BookingStatus(String dbRepresentation, String viewRepresentation) {
        this.dbRepresentation = dbRepresentation;
        this.viewRepresentation = viewRepresentation;
    }

    public String getDbRepresentation() {
        return dbRepresentation;
    }

    public String getViewRepresentation() {
        return viewRepresentation;
    }

    public static BookingStatus findByDbRepresentation(String value) {
        if ("B".equals(value)) {
            return BOOKED;
        } else if ("P".equals(value)) {
            return PAYED;
        }else {
            throw new InvalidParameterException(String.format("Illegal enum value [%s, %s]", BookingStatus.class, value));
        }
    }
}
