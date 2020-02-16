package sample;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class Boat {
    private static Boat instance = null;

    private Boat(){}

    public static Boat getInstance()
    {
        if (instance == null)
            instance = new Boat();

        return instance;
    }
    public BufferedImage getImage(){
        BufferedImage image=null;
        File file = new File("");
        try {
            image = ImageIO.read(file);
        }catch(Exception e)
        {
            System.out.println("Could not find boat image");
        }
        return image;
    }
    public void setMembers(ICrosser ob1, ICrosser ob2)
    {
        ob1.getImages();
        ob2.getImages();
    }
}