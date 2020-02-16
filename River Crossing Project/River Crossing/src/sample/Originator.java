package sample;

import com.sun.management.VMOption;

public class Originator {
    private Originator()
    {

    }
    private MoveInfo article;
    private static Originator instance=null;
    public static Originator getInstance(){
        if(instance ==null)
            instance = new Originator();
        return instance;
    }
    public void set(MoveInfo newArticle){
        this.article = newArticle;
    }
    public Memento storeInMemento(){
        return  new Memento(article);
    }
    public MoveInfo restoreFromMemento(Memento memento){
        article = memento.getSavedArticle();
        return article;
    }
}
