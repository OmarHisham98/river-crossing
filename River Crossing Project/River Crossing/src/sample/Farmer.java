package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Farmer implements ICrosser {
    double weight;
  //  public Farmer(){

    //}
    public Farmer(double weight)
    {
        this.weight = weight;
    }/*
    public Farmer(int weight, IDisplayLabel type)
    {
        this.weight = weight;
        this.type = type;
    }*/
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
        File file1 = new File("farmermale.png");
        File file2 = new File("farmermale.png");
        BufferedImage[] images = new BufferedImage[2];
       try {
           images[0] = ImageIO.read(file1);
           images[1] = ImageIO.read(file2);
       }catch(Exception e)
       {
           System.out.println("Farmer images not found");
       }
        return images;
    }

    @Override
    public ICrosser makeCopy() {
        Farmer newFarmer = new Farmer(weight);
        newFarmer.setLabelToBeShown(label);
        return newFarmer;
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
}
