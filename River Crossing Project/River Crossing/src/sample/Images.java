package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class Images {
    public static Image getLeftImage(BufferedImage[] images)
    {
        Image img = SwingFXUtils.toFXImage(images[0],null);
        return img;
    }
    public static Image getRightImage(BufferedImage[] images)
    {
        Image img = SwingFXUtils.toFXImage(images[1],null);
        return img;
    }
}
