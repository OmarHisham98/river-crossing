package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Boy implements ICrosser {

    double weight;
    public Boy(double weight)
    {
        this.weight = weight;
    }
   /* public Boy(int weight, IDisplayLabel type)
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
        return 0;
    }

    @Override
    public int getEatingRank() {
        return 1;
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
            System.out.println("boy's images not found");
        }
        return images;
    }

    @Override
    public ICrosser makeCopy() {
        Boy newBoy = new Boy(weight);
        newBoy.setLabelToBeShown(label);
        return newBoy;
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