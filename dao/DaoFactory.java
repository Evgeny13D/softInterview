package A402.dao;

import A402.dao.daoImpl.*;

/**
 * Created by Evgeny on 5/9/18.
 */
public class DaoFactory {
    public DaoFactory() {
    }

//    public static UserDao createUserDao() {
//        return new UserDaoImpl();
//    }
    public static DaoAdmin createAdminDao(){
        return new DaoAdminImpl();
    }

    public static EventDao createEventDao() {
        return new EventDaoImpl();
    }
    public static EventDao_NV createEventDao_NV() {
        return new EventDaoImpl_NV();
    }

    public static SeatDao createSeatDao() {
        return new SeatDaoImpl();
    }

    public static ParticipantDao createParticipantDao() {
        return new ParticipantDaoImpl();
    }

    public static ArticlesDao createArticlesDao(){ return  new ArticlesDaoImpl();}

    public static SubscribeDao createSubscribeDao(){
        return new SubscribeDaoIml();
    }
}
