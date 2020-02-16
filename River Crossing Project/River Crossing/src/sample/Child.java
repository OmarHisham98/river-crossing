package sample;

import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Child implements ICrosser{
    double weight;
    String label;

    public Child(double weight){
        this.weight = weight;
    }
    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 99;
    }

    @Override
    public BufferedImage[] getImages() {

        File file1 = new File("kid1.png");
        File file2 = new File("kid1.png");
        BufferedImage[] images = new BufferedImage[2];
        try {
            images[0] = ImageIO.read(file1);
            images[1] = ImageIO.read(file2);
        }catch(Exception e)
        {
            System.out.println("Child images not found");
        }
        return images;
    }

    @Override
    public ICrosser makeCopy() {
        Child newChild = new Child(weight);
        newChild.setLabelToBeShown(label);
        return newChild;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public String getLabelToBeShown() {
        System.out.println("bjggj hbhjbhj "+label);
        if(label.equals("weight"))
            return String.valueOf(getWeight());
        else if (label.equals("eating rank"))
            return String.valueOf(getEatingRank());
        else
            return null;
    }
}