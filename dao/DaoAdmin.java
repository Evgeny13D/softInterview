package A402.dao;

import A402.model.Event;
import A402.model.News;
import A402.model.User;

import java.util.List;

public interface DaoAdmin {
    public List<User> getAllUsers();

    public List<Event> listOfEvents();
    public boolean addNewEvent(Event event);
    public boolean editEvent(Event event);
    public boolean removeEvent(Event event);

    public List<News> listOfNews();
    public List<News> listOfNewsShow();
    public void addNewNews(News news);
    public void editNews(News news, int id);
    public void removeNews(int id);

}
