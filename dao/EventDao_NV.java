package A402.dao;

import A402.model.Event_NV;
import A402.model.Participant;

import java.util.List;
import java.util.Map;

/**
 * Created by Kapliarchuk_Y on 08/08/2018.
 */
public interface EventDao_NV {
    List<Event_NV> listOfEvents();
    List<Event_NV> listOfEventsJust();
    Event_NV getEventById(int eventId);
    Event_NV getEventByIdJustForRemove(int eventId);
    Event_NV storeEvent(Event_NV event);

    Map<Integer, Event_NV> getEventByIds(Integer[] ids);
    void addPrivateEvent(Event_NV event);
    void updateEvent(Event_NV event);
    void updatePrivateEvent(Event_NV event);
    void deleteEvent(int id);

    void editManageEvent(int id, Event_NV event_nv);
}
