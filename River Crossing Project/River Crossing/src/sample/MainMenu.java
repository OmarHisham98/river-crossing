package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import static sample.Main.*;
import static sample.Main.currentStage;

public class MainMenu {

    GamePlay gameController =GamePlay.getInstance();

    public  void newGameClick (ActionEvent event)throws Exception{
        Caretaker caretaker = Caretaker.getInstance();
        caretaker.clearMementos();
        Parent root = FXMLLoader.load(getClass().getResource("choose story.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }

    public  void loadGameClick (ActionEvent event)throws Exception{


        ICommand load = new LoadFromFile(new Save());
        Invoker invoker = new Invoker(load);
        invoker.press();

     //   load.execute();


       /*   MoveInfo moveInfo= Save.loadFromFile();
       // GamePlay.setStory(moveInfo.getStory());
        GamePlay.isNewGame=false;
        GamePlay.setMoveInfo(moveInfo);
        Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();*/


    }

}
