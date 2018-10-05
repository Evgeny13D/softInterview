package A402.dao;

import A402.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetConverter {

    public static Event convertToEvent(ResultSet resultSet) {
        Event event = new Event();

        try {
            event.setId(resultSet.getInt("id"));
            event.setDayOfMonth(resultSet.getInt("day_of_month"));
            event.setMonthNumber(resultSet.getInt("month_number"));
            event.setDayOfWeekNumber(resultSet.getInt("day_of_week_number"));
            event.setYear(resultSet.getInt("year"));
            event.setStartTime(resultSet.getTime("start_time"));
            event.setEndTime(resultSet.getTime("end_time"));
            event.setLocationEn(resultSet.getString("location_en"));
            event.setLocationRu(resultSet.getString("location_ru"));
            event.setAddressEn(resultSet.getString("address_en"));
            event.setAddressRu(resultSet.getString("address_ru"));
            event.setNameEn(resultSet.getString("name_en"));
            event.setNameRu(resultSet.getString("name_ru"));
            event.setDescriptionEn(resultSet.getString("description_en"));
            event.setDescriptionRu(resultSet.getString("description_ru"));
            event.setPrice(resultSet.getDouble("price"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return event;
    }

    public static Event_NV convertToEvent_NV(ResultSet resultSet) {
        Event_NV event = new Event_NV();

        try {
            event.setId(resultSet.getInt("id"));
            event.setStatus(resultSet.getString("status"));
            event.setType(resultSet.getString("type"));
            event.setDayOfMonth(resultSet.getInt("day_of_month"));
            event.setMonthNumber(resultSet.getInt("month_number"));
            event.setDayOfWeekNumber(resultSet.getInt("day_of_week_number"));
            event.setYear(resultSet.getInt("year"));
            event.setStartTime(resultSet.getTime("start_time"));
            event.setEndTime(resultSet.getTime("end_time"));
            event.setLocationEn(resultSet.getString("location_en"));
            event.setLocationRu(resultSet.getString("location_ru"));
            event.setAddressEn(resultSet.getString("address_en"));
            event.setAddressRu(resultSet.getString("address_ru"));
            event.setNameEn(resultSet.getString("name_en"));
            event.setNameRu(resultSet.getString("name_ru"));
            event.setDescriptionEn(resultSet.getString("description_en"));
            event.setDescriptionRu(resultSet.getString("description_ru"));
            event.setPrice(resultSet.getDouble("price"));
            event.setPriceS16(resultSet.getDouble("priceS16"));
            event.setPriceS712(resultSet.getDouble("priceS712"));
            event.setPriceS13(resultSet.getDouble("priceS13"));
            event.setPriceS14(resultSet.getDouble("priceS14"));
            event.setR1s1(resultSet.getInt("r1s1"));
            event.setR1s2(resultSet.getInt("r1s2"));
            event.setR1s3(resultSet.getInt("r1s3"));
            event.setR1s4(resultSet.getInt("r1s4"));
            event.setR1s5(resultSet.getInt("r1s5"));
            event.setR1s6(resultSet.getInt("r1s6"));
            event.setR1s7(resultSet.getInt("r1s7"));
            event.setR2s1(resultSet.getInt("r2s1"));
            event.setR2s2(resultSet.getInt("r2s2"));
            event.setR2s3(resultSet.getInt("r2s3"));
            event.setR2s4(resultSet.getInt("r2s4"));
            event.setR2s5(resultSet.getInt("r2s5"));
            event.setR2s6(resultSet.getInt("r2s6"));
            event.setR2s7(resultSet.getInt("r2s7"));
            event.setType(resultSet.getString("type"));
            event.setStatus(resultSet.getString("status"));
            event.setLinkOfImage(resultSet.getString("imageLink"));
//            event.setLinkOfImage("/ImageGetterForEvents?link_ofImageEvent=" + new File(resultSet.getString("imageLink")));
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return event;
    }

    public static Seat convertToSeat(ResultSet resultSet) {
        Seat seat = new Seat();

        try {
            seat.setId(resultSet.getInt("id"));
            seat.setRowNumber(resultSet.getInt("row_number"));
            seat.setSeatNumber(resultSet.getInt("seat_number"));
            seat.setPrice(resultSet.getDouble("price"));
            seat.setEventId(resultSet.getInt("event_id"));
            seat.setParticipantId(resultSet.getInt("participant_id"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return seat;
    }

    public static Articles convertToArticle(ResultSet resultSet) {
        Articles articles = new Articles();

        try {
            articles.setId(resultSet.getInt("id"));
            articles.setRu_title(resultSet.getString("ru_title"));
            articles.setRu_description(resultSet.getString("ru_description"));
            articles.setRu_content(resultSet.getString("ru_content"));
            articles.setEn_title(resultSet.getString("en_title"));
            articles.setEn_description(resultSet.getString("en_description"));
            articles.setEn_content(resultSet.getString("en_content"));
            articles.setRu_linkAtach(resultSet.getString("ru_linkAtach"));
            articles.setEn_linkAtach(resultSet.getString("en_linkAtach"));
            articles.setLink_ofImage(resultSet.getString("link_ofImage"));
            articles.setDate(resultSet.getString("dateAdd"));
            articles.setCategory(resultSet.getString("category"));
            articles.setViews(resultSet.getInt("views"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return articles;
    }

    public static Participant convertToParticipant(ResultSet resultSet) {
        try {
            Participant participant = new Participant();
            participant.setId(resultSet.getInt("id"));
            participant.setFirstName(resultSet.getString("first_name"));
            participant.setLastName(resultSet.getString("last_name"));
            participant.setPhoneNumber(resultSet.getString("phone_number"));
            participant.setEmail(resultSet.getString("email"));
            participant.setEventId(resultSet.getInt("event_id"));
            participant.setTotal_price(resultSet.getDouble("total_price"));
            participant.setBookingStatus(BookingStatus.findByDbRepresentation(resultSet.getString("booking_status")));
            return participant;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

