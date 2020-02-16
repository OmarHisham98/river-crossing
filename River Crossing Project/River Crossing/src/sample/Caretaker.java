package sample;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    ArrayList<Memento> savedArticles = new ArrayList<>();
    private Caretaker(){

    }
    private static Caretaker instance=null;
    public static Caretaker getInstance(){
        if(instance ==null)
            instance = new Caretaker();
        return instance;
    }

    public void addMemento(Memento m){
        savedArticles.add(m);
    }
    public Memento getMemento(int index){
        return savedArticles.get(index);
    }
    public void clearMementos()
    {
        savedArticles.clear();
    }
    public void clearAfterIndex(int index)
    {
        for(int x =index;x<savedArticles.size();x++)
        {
            savedArticles.remove(x);
        }
    }
    public void newstatus(int index)
    {
        Originator originator = Originator.getInstance();
        //originator.set();
       // Memento m = new Memento();
        ArrayList<Memento> newList = new ArrayList<>();
        for(int x = 0;x<index;x++)
        {
            //newList.add(savedArticles.get(x).getSavedArticle());
            originator.set(savedArticles.get(x).getSavedArticle());
            newList.add(originator.storeInMemento());

        }
        savedArticles = newList;
    }
}
