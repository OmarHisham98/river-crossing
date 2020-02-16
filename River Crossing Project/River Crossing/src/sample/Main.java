package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
 public static Stage currentStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main menu.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage = new Stage();
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
