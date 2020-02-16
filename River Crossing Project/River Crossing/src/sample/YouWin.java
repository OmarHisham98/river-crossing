package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import static sample.GamePlay.moves;
import static sample.Main.currentStage;


public class YouWin implements Initializable {
    @FXML ImageView star1;
    @FXML ImageView star2;
    @FXML ImageView star3;
    public void closeButtonClicked(ActionEvent event)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("choose story.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();
        GamePlay.winStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image imgstar = new Image("star.png");
        star1.setImage(imgstar);
        star2.setImage(imgstar);
        star3.setImage(imgstar);
        if (moves<10)
        {
            star1.setVisible(true);
            star2.setVisible(true);
            star3.setVisible(true);
        }
        else if (moves>10 && moves<15)
        {
            star1.setVisible(true);
            star2.setVisible(true);
            star3.setVisible(false);
        }
        else
        {
            star1.setVisible(true);
            star2.setVisible(false);
            star3.setVisible(false);
        }

    }
}