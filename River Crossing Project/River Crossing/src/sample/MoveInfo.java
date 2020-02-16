package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MoveInfo {
    private List<ICrosser> leftBankCrossers= new ArrayList<>();
    private List<ICrosser> rightBankCrossers=new ArrayList<>();
 //   private List<ImageView> leftBankImages;
   // private List<ImageView> rightBankImages;
    private Point2D position;
    private boolean boatOnLeft;
    private ICrossingStrategy story;
    int moves;
    public MoveInfo(){

    }
    public MoveInfo(List<ICrosser> leftCrossers,List<ICrosser> rightCrossers,int moves,boolean boatOnLeft,ICrossingStrategy story)
    {
        for(int x = 0;x<leftCrossers.size();x++)
        {
            leftBankCrossers.add(leftCrossers.get(x).makeCopy());
        }
        for(int x =0;x<rightCrossers.size();x++)
        {
            rightBankCrossers.add(rightCrossers.get(x).makeCopy());
        }
       // this.leftBankCrossers = leftBankCrossers;
        this.boatOnLeft = boatOnLeft;
        this.moves = moves;
        this.story = story;
       // this.rightBankCrossers = rightBankCrossers;
    //    this.leftBankImages = leftBankImages;
      //  this.rightBankImages=rightBankImages;
    }


    public List<ICrosser> getLeftBankCrossers() {
        return leftBankCrossers;
    }

    public List<ICrosser> getRightBankCrossers() {
        return rightBankCrossers;
    }

    public boolean isBoatOnLeft() {
        return boatOnLeft;
    }

    public ICrossingStrategy getStory() {
        return story;
    }

    public int getMoves() {
        return moves;
    }

    public void setLeftBankCrossers(List<ICrosser> leftBankCrossers) {
        this.leftBankCrossers = leftBankCrossers;
    }

    public void setRightBankCrossers(List<ICrosser> rightBankCrossers) {
        this.rightBankCrossers = rightBankCrossers;
    }

    public void setBoatOnLeft(boolean boatOnLeft) {
        this.boatOnLeft = boatOnLeft;
    }

    public void setStory(ICrossingStrategy story) {
        this.story = story;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
/*
    public List<ImageView> getLeftBankImages() {
        return leftBankImages;
    }

    public void setLeftBankImages(List<ImageView> leftBankImages) {
        this.leftBankImages = leftBankImages;
    }

    public List<ImageView> getRightBankImages() {
        return rightBankImages;
    }

    public void setRightBankImages(List<ImageView> rightBankImages) {
        this.rightBankImages = rightBankImages;
    }*/

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
