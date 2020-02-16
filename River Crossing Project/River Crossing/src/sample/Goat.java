package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;

import java.awt.image.BufferedImage;

public class Goat extends Herbivorous {
    double weight;
    public Goat(double weight)
    {
        this.weight = weight;
    }
    public BufferedImage[] getImages() {
        BufferedImage[] images = new BufferedImage[2];
        File file1 = new File("goat.png");
        File file2 = new File("goat.png");
        try {
            images[0] = ImageIO.read(file1);
            images[1] = ImageIO.read(file2);
        } catch (Exception e) {
            System.out.println("Goat images not found");
        }
        return images;
    }

    String label;
    @Override
    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public String getLabelToBeShown() {
        if(label.equals("weight"))
            return String.valueOf(getWeight());
        else if (label.equals("eating rank"))
            return String.valueOf(getEatingRank());
        else
            return null;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public ICrosser makeCopy() {
        Goat newGoat = new Goat(weight);
        newGoat.setLabelToBeShown(label);
        return newGoat;
    }
}
/**
 GamePlay.isNewGame = false;
 GamePlay.setMoveInfo(info);
 Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
 Scene scene = new Scene(root, 607, 403);
 currentStage.setTitle("River Crossing");
 currentStage.setScene(scene);
 currentStage.show();
 Caretaker caretaker = Caretaker.getInstance();
 caretaker.clearMementos();
 Originator originator = Originator.getInstance();
 originator.set(info);
 caretaker.addMemento(originator.storeInMemento());
 */
