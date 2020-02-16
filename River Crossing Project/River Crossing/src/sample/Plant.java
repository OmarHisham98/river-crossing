package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Plant implements ICrosser{
    double weight;
    public Plant(double weight){
        this.weight = weight;
    }
 //   public Plant(IDisplayLabel type)
    //{
   //     this.type = type;
    //}
    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return 0;
    }

    @Override
    public BufferedImage[] getImages()
    {
        BufferedImage[] images = new BufferedImage[2];
        File file1 = new File("lettuce.png");
        File file2 = new File("lettuce.png");
        try{
            images[0] = ImageIO.read(file1);
            images[1] = ImageIO.read(file2);
        }catch(Exception e)
        {
            System.out.println("Goat images not found");
        }
        return images;
    }

    @Override
    public ICrosser makeCopy() {
        Plant newPlant= new Plant(weight);
        newPlant.setLabelToBeShown(label);
        return newPlant;
    }

    String label;
    @Override
    public void setLabelToBeShown(String label) {
        this.label = label;
    }

    @Override
    public String getLabelToBeShown() {
        System.out.println("Label:   "+label);
        if(label.equals("weight"))
            return String.valueOf(getWeight());
        else if (label.equals("eating rank"))
            return String.valueOf(getEatingRank());
        else
            return null;
    }
}
