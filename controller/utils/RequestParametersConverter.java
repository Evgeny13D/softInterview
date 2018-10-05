package A402.controller.utils;

import A402.controller.exception.InvalidParameterException;
import A402.model.Event;
import A402.model.Event_NV;
import A402.model.Participant;
import A402.utils.RequestToInstanceMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RequestParametersConverter {

    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";
    private static final String PHONE_NUM_PARAM_NAME = "phoneNumber";
    private static final String EMAIL_PARAM_NAME = "email";
    private static final String NAME_EN_PARAM_NAME = "nameEn";
    private static final String NAME_RU_PARAM_NAME = "nameRu";
    private static final String DAY_OF_MONTH_PARAM_NAME = "dayOfMonth";
    private static final String MONTH_PARAM_NAME = "month";
    private static final String YEAR_PARAM_NAME = "year";
    private static final String DAY_OF_WEEK_PARAM_NAME = "dayOfWeek";
    private static final String START_TIME_PARAM_NAME = "startTime";
    private static final String END_TIME_PARAM_NAME = "endTime";
    private static final String LOCATION_EN_PARAM_NAME = "locationEn";
    private static final String LOCATION_RU_PARAM_NAME = "locationRu";
    private static final String ADDRESS_EN_PARAM_NAME = "addressEn";
    private static final String ADDRESS_RU_PARAM_NAME = "addressRu";
    private static final String DESCRIPTION_EN_PARAM_NAME = "descriptionEn";
    private static final String DESCRIPTION_RU_PARAM_NAME = "descriptionRu";

    private static final String TIME_FORMAT = "HH:mm";

    public static Event convertToEvent(Map<String, String[]> parameters) {
        Event event = new Event();

        String nameEn = parameters.get(NAME_EN_PARAM_NAME)[0];
        if (nameEn.isEmpty()) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        String nameRu = parameters.get(NAME_RU_PARAM_NAME)[0];
        if (nameRu.isEmpty()) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        String dayOfMonthString = parameters.get(DAY_OF_MONTH_PARAM_NAME)[0];
        if (dayOfMonthString.isEmpty()) {
            throw new InvalidParameterException("Day of month cannot be empty");
        }
        String monthNumberString = parameters.get(MONTH_PARAM_NAME)[0];
        if (monthNumberString.isEmpty()) {
            throw new InvalidParameterException("Month number cannot be empty");
        }
        String yearString = parameters.get(YEAR_PARAM_NAME)[0];
        if (yearString.isEmpty()) {
            throw new InvalidParameterException("Year cannot be empty");
        }
        String dayOfWeekNumberString = parameters.get(DAY_OF_WEEK_PARAM_NAME)[0];
        if (dayOfWeekNumberString.isEmpty()) {
            throw new InvalidParameterException("Day of week cannot be empty");
        }
        String startTimeString = parameters.get(START_TIME_PARAM_NAME)[0];
        if (startTimeString.isEmpty()) {
            throw new InvalidParameterException("Start time cannot be empty");
        }
        String endTimeString = parameters.get(END_TIME_PARAM_NAME)[0];
        if (endTimeString.isEmpty()) {
            throw new InvalidParameterException("End time cannot be empty");
        }
        String locationEn = parameters.get(LOCATION_EN_PARAM_NAME)[0];
        if (locationEn.isEmpty()) {
            throw new InvalidParameterException("Location cannot be empty");
        }
        String locationRu = parameters.get(LOCATION_RU_PARAM_NAME)[0];
        if (locationRu.isEmpty()) {
            throw new InvalidParameterException("Location cannot be empty");
        }
        String addressEn = parameters.get(ADDRESS_EN_PARAM_NAME)[0];
        if (addressEn.isEmpty()) {
            throw new InvalidParameterException("Address cannot be empty");
        }
        String addressRu = parameters.get(ADDRESS_RU_PARAM_NAME)[0];
        if (addressRu.isEmpty()) {
            throw new InvalidParameterException("Address cannot be empty");
        }
        String descriptionEn = parameters.get(DESCRIPTION_EN_PARAM_NAME)[0];
        String descriptionRu = parameters.get(DESCRIPTION_RU_PARAM_NAME)[0];

        int dayOfMonth;
        int monthNumber;
        int year;
        int dayOfWeekNumber;
        try {
            dayOfMonth = Integer.parseInt(dayOfMonthString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Day of month must be a numeric value", e);
        }
        try {
            monthNumber = Integer.parseInt(monthNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Month number must be a numeric value", e);
        }
        try {
            year = Integer.parseInt(yearString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Year must be a numeric value", e);
        }
        try {
            dayOfWeekNumber = Integer.parseInt(dayOfWeekNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Day of week must be a numeric value", e);
        }
        Date startTime;
        Date endTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        try {
            startTime = dateFormat.parse(startTimeString);
            endTime = dateFormat.parse(endTimeString);

        } catch (ParseException e) {
            throw new InvalidParameterException("Invalid date format", e);
        }

        event.setNameEn(nameEn);
        event.setNameRu(nameRu);
        event.setDayOfMonth(dayOfMonth);
        event.setMonthNumber(monthNumber);
        event.setYear(year);
        event.setDayOfWeekNumber(dayOfWeekNumber);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setLocationEn(locationEn);
        event.setLocationRu(locationRu);
        event.setAddressEn(addressEn);
        event.setAddressRu(addressRu);
        event.setDescriptionEn(descriptionEn);
        event.setDescriptionRu(descriptionRu);

        return event;
    }

//    private static final String FIRST_NAME_PARAM_NAME_VN = "firstName";
//    private static final String LAST_NAME_PARAM_NAME_VN = "lastName";
//    private static final String PHONE_NUM_PARAM_NAME_VN = "phoneNumber";
//    private static final String EMAIL_PARAM_NAME = "email";
    private static final String NAME_EN_PARAM_NAME_VN = "name_en";
    private static final String NAME_RU_PARAM_NAME_VN = "name_ru";
    private static final String DAY_OF_MONTH_PARAM_NAME_VN = "day_of_month";
    private static final String MONTH_PARAM_NAME_VN = "month_number";
    private static final String YEAR_PARAM_NAME_VN = "year";
    private static final String DAY_OF_WEEK_PARAM_NAME_VN = "day_of_week_number";
    private static final String START_TIME_PARAM_NAME_VN = "start_time";
    private static final String END_TIME_PARAM_NAME_VN = "end_time";
    private static final String LOCATION_EN_PARAM_NAME_VN = "location_en";
    private static final String LOCATION_RU_PARAM_NAME_VN = "location_ru";
    private static final String ADDRESS_EN_PARAM_NAME_VN = "address_en";
    private static final String ADDRESS_RU_PARAM_NAME_VN = "address_ru";
    private static final String DESCRIPTION_EN_PARAM_NAME_VN = "description_en";
    private static final String DESCRIPTION_RU_PARAM_NAME_VN = "description_ru";


    public static Event_NV convertToEvent_NV(Map<String, String[]> parameters) {
        Event_NV event = new Event_NV();

        String nameEn = parameters.get(NAME_EN_PARAM_NAME_VN)[0];
        if (nameEn.isEmpty()) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        String nameRu = parameters.get(NAME_RU_PARAM_NAME_VN)[0];
        if (nameRu.isEmpty()) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        String dayOfMonthString = parameters.get(DAY_OF_MONTH_PARAM_NAME_VN)[0];
        if (dayOfMonthString.isEmpty()) {
            throw new InvalidParameterException("Day of month cannot be empty");
        }
        String monthNumberString = parameters.get(MONTH_PARAM_NAME_VN)[0];
        if (monthNumberString.isEmpty()) {
            throw new InvalidParameterException("Month number cannot be empty");
        }
        String yearString = parameters.get(YEAR_PARAM_NAME_VN)[0];
        if (yearString.isEmpty()) {
            throw new InvalidParameterException("Year cannot be empty");
        }
        String dayOfWeekNumberString = parameters.get(DAY_OF_WEEK_PARAM_NAME_VN)[0];
        if (dayOfWeekNumberString.isEmpty()) {
            throw new InvalidParameterException("Day of week cannot be empty");
        }
        String startTimeString = parameters.get(START_TIME_PARAM_NAME_VN)[0];
        if (startTimeString.isEmpty()) {
            throw new InvalidParameterException("Start time cannot be empty");
        }
        String endTimeString = parameters.get(END_TIME_PARAM_NAME_VN)[0];
        if (endTimeString.isEmpty()) {
            throw new InvalidParameterException("End time cannot be empty");
        }
        String locationEn = parameters.get(LOCATION_EN_PARAM_NAME_VN)[0];
        if (locationEn.isEmpty()) {
            throw new InvalidParameterException("Location cannot be empty");
        }
        String locationRu = parameters.get(LOCATION_RU_PARAM_NAME_VN)[0];
        if (locationRu.isEmpty()) {
            throw new InvalidParameterException("Location cannot be empty");
        }
        String addressEn = parameters.get(ADDRESS_EN_PARAM_NAME_VN)[0];
        if (addressEn.isEmpty()) {
            throw new InvalidParameterException("Address cannot be empty");
        }
        String addressRu = parameters.get(ADDRESS_RU_PARAM_NAME_VN)[0];
        if (addressRu.isEmpty()) {
            throw new InvalidParameterException("Address cannot be empty");
        }
        String descriptionEn = parameters.get(DESCRIPTION_EN_PARAM_NAME_VN)[0];
        String descriptionRu = parameters.get(DESCRIPTION_RU_PARAM_NAME_VN)[0];

        int dayOfMonth;
        int monthNumber;
        int year;
        int dayOfWeekNumber;
        try {
            dayOfMonth = Integer.parseInt(dayOfMonthString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Day of month must be a numeric value", e);
        }
        try {
            monthNumber = Integer.parseInt(monthNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Month number must be a numeric value", e);
        }
        try {
            year = Integer.parseInt(yearString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Year must be a numeric value", e);
        }
        try {
            dayOfWeekNumber = Integer.parseInt(dayOfWeekNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Day of week must be a numeric value", e);
        }
        Date startTime;
        Date endTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        try {
            startTime = dateFormat.parse(startTimeString);
            endTime = dateFormat.parse(endTimeString);

        } catch (ParseException e) {
            throw new InvalidParameterException("Invalid date format", e);
        }

        event.setNameEn(nameEn);
        event.setNameRu(nameRu);
        event.setDayOfMonth(dayOfMonth);
        event.setMonthNumber(monthNumber);
        event.setYear(year);
        event.setDayOfWeekNumber(dayOfWeekNumber);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setLocationEn(locationEn);
        event.setLocationRu(locationRu);
        event.setAddressEn(addressEn);
        event.setAddressRu(addressRu);
        event.setDescriptionEn(descriptionEn);
        event.setDescriptionRu(descriptionRu);

        return event;
    }

    public static Participant convertToParticipant(Map<String, String[]> parameters) {
        Participant participant = RequestToInstanceMapper.createInstance(Participant.class, parameters);

        if(participant == null) throw new InvalidParameterException("Cannot build participant");
        checkParticipantParameters(participant);

        return participant;
    }

    private static boolean isEmpty(String value){
        if (value == null){
            return true;
        }else {
            return value.isEmpty();
        }
    }

    private static void checkParticipantParameters(Participant participant) {
        if (isEmpty(participant.getFirstName())) {
            throw new InvalidParameterException(FIRST_NAME_PARAM_NAME + " cannot be empty");
        }
        if (isEmpty(participant.getLastName())) {
            throw new InvalidParameterException(LAST_NAME_PARAM_NAME + " cannot be empty");
        }
        if (isEmpty(participant.getPhoneNumber())) {
            throw new InvalidParameterException(PHONE_NUM_PARAM_NAME + " cannot be empty");
        }
        if (isEmpty(participant.getEmail())) {
            throw new InvalidParameterException(EMAIL_PARAM_NAME + " cannot be empty");
        }
    }
}
