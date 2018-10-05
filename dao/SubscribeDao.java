package A402.dao;

import A402.model.Subscribe;

import java.util.List;

/**
 * Created by Kapliarchuk_Y on 06/08/2018.
 */
public interface SubscribeDao {
    public void addSubscribe(Subscribe subscribe);
    public void removeSubscribe(int id);
    public List<Subscribe> listOfSubscribes();
    public Subscribe getSubscriberByEmail(String email);
}
