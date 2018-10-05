package A402.dao;

import A402.model.Event;

import java.util.List;

public interface EventDao {
    List<Event> listOfEvents();
    Event getEventById(int eventId);
    Event storeEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(int id);
}
