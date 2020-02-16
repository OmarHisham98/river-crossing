package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Wolf extends Carnivorous {
    double weight;
    public Wolf(double weight)
    {
        this.weight = weight;
    }
    public BufferedImage[] getImages()
    {
        BufferedImage[] images = new BufferedImage[2];
        File file1 = new File("fox.png");
        File file2 = new File("fox.png");
        try{
            images[0] = ImageIO.read(file1);
            images[1] = ImageIO.read(file2);
        }catch(Exception e)
        {
            System.out.println("Wolf images not found");
        }
        return images;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank() {
        return super.getEatingRank();
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
    public ICrosser makeCopy() {

       Wolf newWolf = new Wolf(weight);
       newWolf.setLabelToBeShown(label);
       return newWolf;
    }
}
