package A402.dao;

import A402.model.Articles;

import java.util.List;

/**
 * Created by Kapliarchuk_Y on 24/07/2018.
 */
public interface ArticlesDao {
    List<Articles> listOfArticles();
    List<Articles> listOfArticlesJust();
    List<Articles> listManageArticles();
    void addArticles(Articles articles);
    void editArticles(int id, Articles articles);
    void editManageArticles(int id, Articles articles);
    void removeArticles(int id);
    Articles getArticleById(int id);
    List<Articles> listPopularArticles();
    void addViews(int id);
}
