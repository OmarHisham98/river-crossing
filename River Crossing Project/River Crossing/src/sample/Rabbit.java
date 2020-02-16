package sample;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Rabbit extends Herbivorous {
    double weight;
    public Rabbit(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public BufferedImage[] getImages()
    {
        BufferedImage[] images = new BufferedImage[2];
        File file1 = new File("rabbit.png");
        File file2 = new File("rabbit.png");
        try{
            images[0] = ImageIO.read(file1);
            images[1] = ImageIO.read(file2);
        }catch(Exception e)
        {
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
    public ICrosser makeCopy() {
        Rabbit newRabbit = new Rabbit(weight);
        newRabbit.setLabelToBeShown(label);
        return newRabbit;
    }
}
