package sample;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.currentStage;


public class ChooseStory implements Initializable {
    @FXML Button back2Main;
    @FXML ImageView balance;
    @FXML ImageView image3;
    @FXML ImageView image4;
    //    Image story4Image = new Image("C:\\Users\\HP\\IdeaProjects\\River Crossing\\src\\friendship.png");

//    Image story3Image = new Image("C:\\Users\\HP\\IdeaProjects\\River Crossing\\src\\fatman.png");
    GamePlay gameController=GamePlay.getInstance();
    ICrossingStrategy story1 = new Story1();
    ICrossingStrategy story2 = new Story2();
    ICrossingStrategy story3 = new Story3();
    ICrossingStrategy story4 = new Story4();
    public  void story1Click (ActionEvent event)throws Exception{
        //gameController.newGame(story1);
        GamePlay.isNewGame=true;
        gameController.setStory(story1);
        Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }

    public  void story2Click (ActionEvent event)throws Exception{
       // gameController.newGame(story2);
        gameController.setStory(story2);
        GamePlay.isNewGame = true;
        Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }
    public  void story3Click (ActionEvent event)throws Exception{
        // gameController.newGame(story3);
        GamePlay.isNewGame = true;
        gameController.setStory(story3);
        Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }


    public  void story4Click (ActionEvent event)throws Exception{
        // gameController.newGame(story4);
        GamePlay.isNewGame = true;
        gameController.setStory(story4);
        Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }

    public  void back2Menu (ActionEvent event)throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("main menu.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();
        /*Line line = new Line();           //for moving object a pattern
        Circle circle = new Circle(100);
        line.setStartX(0.0);
        line.setEndX(100.0);
        line.setStartY(0.0);
        line.setEndY(100.0);
        PathTransition transition = new PathTransition();
        transition.setNode(balance);
        transition.setDuration(Duration.seconds(3));
        transition.setPath(circle);
        //transition.setOnFinished();
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.play();*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    //    image4.setImage(story4Image);

  //      image3.setImage(story3Image);
    }
}
