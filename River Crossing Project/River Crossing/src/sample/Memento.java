package sample;

public class Memento {
    private MoveInfo article;
    public Memento(MoveInfo articleSave){
        article = articleSave;
    }
    public MoveInfo getSavedArticle(){
        return article;
    }
}
