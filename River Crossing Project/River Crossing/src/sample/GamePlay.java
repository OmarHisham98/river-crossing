package sample;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swt.SWTFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

import static sample.Main.currentStage;

public class GamePlay implements IRiverCrossingController,Initializable {

    public static boolean isNewGame = true;
    private static MoveInfo info;
    List<ICrosser> crossers;
    TranslateTransition trans1 = new TranslateTransition();
    TranslateTransition trans2 = new TranslateTransition();
    TranslateTransition trans3 = new TranslateTransition();
    TranslateTransition trans4 = new TranslateTransition();
    TranslateTransition trans5 = new TranslateTransition();

    boolean fromLeftToRightBank= true;
    public static ICrossingStrategy story;
    List<ICrosser> leftBankCrossers = new ArrayList<>();
    List<ICrosser> boatCrossers = new ArrayList<>();
    List<ICrosser> rightBankCrossers = new ArrayList<>();
    List<BufferedImage[]> bufferedImages = new ArrayList<BufferedImage[]>();
    List<Image[]> images = new ArrayList<Image[]>();
    Image[][] img = new Image[7][2];
    BufferedImage[][] bimg = new BufferedImage[7][2];
    List<ImageView> leftBankImages = new ArrayList<>();
    List<ImageView> rightBankImages = new ArrayList<>();
    List<ImageView> onBoatImages = new ArrayList<>();
    List<Label> leftBankLabels = new ArrayList<>();
    List<Label> rightBankLabels = new ArrayList<>();
    List<Label> onBoatLabels = new ArrayList<>();
    Stack<MoveInfo> moveInfos = new Stack<>();
    Point2D position;
    @FXML Label leftLabel1;
    @FXML Label leftLabel2;
    @FXML Label leftLabel3;
    @FXML Label leftLabel4;
    @FXML Label leftLabel5;
    @FXML Label leftLabel6;
    @FXML Label leftLabel7;

    @FXML Label rightLabel1;
    @FXML Label rightLabel2;
    @FXML Label rightLabel3;
    @FXML Label rightLabel4;
    @FXML Label rightLabel5;
    @FXML Label rightLabel6;
    @FXML Label rightLabel7;
    @FXML Label boatLabel1;
    @FXML Label boatLabel2;

    @FXML AnchorPane raftAnchorPane;
    @FXML ImageView raft;
    @FXML Label moveCounter;
    @FXML Button moveRift;
    @FXML ImageView left1;
    @FXML ImageView left2;
    @FXML ImageView left3;
    @FXML ImageView left4;
    @FXML ImageView left5;
    @FXML ImageView left6;
    @FXML ImageView left7;
    @FXML ImageView right6;
    @FXML ImageView right7;

    @FXML ImageView boatCrosser1;
    @FXML ImageView boatCrosser2;
    @FXML ImageView right1;
    @FXML ImageView right2;
    @FXML ImageView right3;
    @FXML ImageView right4;
    @FXML ImageView right5;
    @FXML Button undoButton;
    @FXML Button redoButton;
    int saveFiles = 0,currentArticle =0;
    public static int moves;
    static boolean onLeft;
    //int moves=0;
    int flag =0;
    double startX=0;
    double startY=0;
    double endX =140;
    double endY = -50;
    public static GamePlay instance = null;
    public GamePlay(){}
    public static GamePlay getInstance(){
        if(instance == null)
            instance = new GamePlay();
        return instance;
    }

    Originator originator = Originator.getInstance();
    Caretaker caretaker = Caretaker.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO: left bank crossers to be viewed on left bank
        if(isNewGame) {
     //       onLeft = true;
            newGame(story);
        }
            else {
            if(onLeft)
            {
                raftAnchorPane.relocate(130,210);

                endX = 140;
                endY = -50;
                startX = 0;
                startY = 0;
            }
            else{
                raftAnchorPane.relocate(270,160);
                startX = -140;
                startY = 50;
                endX = 0;
                endY = 0;
            }


/*
            String label=null;
            System.out.println("came hereeeeeee");
if(story==null)
    System.out.println("NULL");

            if(story.getClass().equals(Story1.class))
                label = "eating rank";
            else if(story.getClass().equals(Story2.class)|| story.getClass().equals(Story3.class))
                label = "weight";
            System.out.println("here 2222");
            for(int x=0;x<leftBankCrossers.size();x++)
                leftBankCrossers.get(x).setLabelToBeShown(label);
            for(int x=0;x<rightBankCrossers.size();x++)
                rightBankCrossers.get(x).setLabelToBeShown(label);*/

    //        System.out.println("HELLOOOO");
            loadGame();
            //loadMoveInfo();
            caretaker.clearMementos();
            currentArticle=0;
            originator.set(new MoveInfo(leftBankCrossers,rightBankCrossers,moves,true,story));
            caretaker.addMemento(originator.storeInMemento());

        }}


    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        //this.story = gameStrategy;
      //  raftAnchorPane.relocate(130,210);
        onLeft = true;
        int j;
        Image[] i;
        Image imgraft = new Image("WoodenRaft.png");
        moves = 0;
        raft.setImage(imgraft);
        crossers = story.getInitialCrossers();
        leftBankCrossers = crossers;
        boatCrosser1.setImage(null);
        boatCrosser2.setImage(null);
        leftBankImages.add(left1);
        leftBankImages.add(left2);
        leftBankImages.add(left3);
        leftBankImages.add(left4);
        leftBankImages.add(left5);
        leftBankImages.add(left6);
        leftBankImages.add(left7);
        rightBankImages.add(right1);
        rightBankImages.add(right2);
        rightBankImages.add(right3);
        rightBankImages.add(right4);
        rightBankImages.add(right5);
        rightBankImages.add(right6);
        rightBankImages.add(right7);
        onBoatImages.add(boatCrosser1);
        onBoatImages.add(boatCrosser2);
        onBoatLabels.add(boatLabel1);
        onBoatLabels.add(boatLabel2);
        leftBankLabels.add(leftLabel1);
        leftBankLabels.add(leftLabel2);
        leftBankLabels.add(leftLabel3);
        leftBankLabels.add(leftLabel4);
        leftBankLabels.add(leftLabel5);
        leftBankLabels.add(leftLabel6);
        leftBankLabels.add(leftLabel7);
        rightBankLabels.add(rightLabel1);
        rightBankLabels.add(rightLabel2);
        rightBankLabels.add(rightLabel3);
        rightBankLabels.add(rightLabel4);
        rightBankLabels.add(rightLabel5);
        rightBankLabels.add(rightLabel6);
        rightBankLabels.add(rightLabel7);
        boatLabel2.setDisable(true);
        boatLabel1.setDisable(true);
        for(int x=0;x<rightBankLabels.size();x++)
        {
            rightBankLabels.get(x).setDisable(true);
            leftBankLabels.get(x).setDisable(true);
        }
        for(j =0;j<crossers.size();j++)
        {
            bimg[j] = crossers.get(j).getImages();
            img[j][0] = SwingFXUtils.toFXImage(bimg[j][0],null);
            img[j][1] = SwingFXUtils.toFXImage(bimg[j][1],null);
            images.add(img[j]);
            bufferedImages.add(bimg[j]);
        }
        for(int x = 0;x<crossers.size();x++)
        {
            i = images.get(x);
            System.out.println(crossers.get(x).getLabelToBeShown());
            leftBankLabels.get(x).setText(crossers.get(x).getLabelToBeShown());
            leftBankLabels.get(x).setUserData(crossers.get(x));
            leftBankImages.get(x).setImage(i[0]);
            leftBankImages.get(x).setUserData(crossers.get(x));
        }
        originator.set(new MoveInfo(leftBankCrossers,rightBankCrossers,moves,true,story));
        caretaker.addMemento(originator.storeInMemento());
        //saveFiles++;
        //currentArticle++;
    }

    @Override
    public void resetGame() {
       // raftAnchorPane.relocate(130,210);
       onLeft = false;
        clearView();
         moves = 0;
         newGame(story);
         rightBankCrossers.clear();
        //System.out.println("left                "+leftBankCrossers);
        //System.out.println(rightBankCrossers);
  //      rightBankCrossers.clear();
    //    rightBankImages.clear();
      //  leftBankImages.clear();
        //rightBankImages= null;
      //  boatCrossers.clear();
        //onBoatImages = null;

    }

    @Override
    public String[] getInstructions() {
        Button closeButton = new Button("Close");
        ListView instructionsList = new ListView();
        Label instructionsLabel = new Label();
        ObservableList<String> instructions = FXCollections.observableArrayList();
        instructionsList.setItems(instructions);
        instructionsLabel.setVisible(false);
        for(int i = 0;i<story.getInstructions().length;i++)
            instructionsList.getItems().add(i,story.getInstructions()[i]);

        Stage stage = new Stage();
        stage.setTitle("Instructions");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(600);
        stage.setMaxHeight(200);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(instructionsList,closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        closeButton.setOnAction(e -> stage.close());
        stage.setScene(scene);
        stage.showAndWait();

        return story.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        /*List<ICrosser> list = new ArrayList<>();
        for(int i=0;i<crossers.size();i++)
        {
            if(img[i][0]==left1.getImage())
            {
                for(int j =0;j<crossers.size();j++)
                {
                    if
                }
            }
        }*/
    return leftBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        //TODO: check if boat is at initial x, y
        return onLeft;
    }

    @Override
    public int getNumberOfSails() {
        return moves;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        //TODO: what is difference between canMove and isValid functions

        return story.isValid(rightBankCrossers,leftBankCrossers,boatCrossers);
//    return true;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {


            if (canMove(crossers, fromLeftToRightBank)) {
                moveRift.setDisable(true);
                undoButton.setDisable(false);
                if (onLeft) {
                  //  Line line = new Line();
                  //  PathTransition path = new PathTransition(new Line());
                    trans1.setDuration(Duration.seconds(1));
                    trans1.setToX(endX);
                    trans1.setToY(endY);
                    trans1.setNode(raftAnchorPane);
                    trans1.setAutoReverse(true);
                    trans1.play();
                    moves++;

                    trans1.setOnFinished(e -> {

                        moveCounter.setText(String.valueOf(getNumberOfSails()));
                        putCrossersOnRightBank(boatCrossers);
                        moveRift.setDisable(false);
                        if(leftBankCrossers.size()==0 && boatCrossers.size() == 0){
                            try {
                                winGame();
                            }
                            catch (IOException ee)
                            {
                                System.out.println("File not found");
                            }
                        }
                        originator.set(new MoveInfo(leftBankCrossers,rightBankCrossers,moves,false,story));
                        caretaker.addMemento(originator.storeInMemento());
                        saveFiles++;
                        currentArticle++;
                        caretaker.clearAfterIndex(currentArticle+1);
                     //   if(flag ==1)
                       // caretaker.newstatus(currentArticle+1);
                        //flag =0;
                        saveFiles= currentArticle;
                    });
                    onLeft = false;
                } else {

                    trans1.setDuration(Duration.seconds(1));
                    trans1.setToX(startX);
                    trans1.setToY(startY);
                    trans1.setNode(raftAnchorPane);
                    trans1.play();
                    moves++;

                    trans1.setOnFinished(e -> {
                        moveCounter.setText(String.valueOf(getNumberOfSails()));
                        putCrossersOnLeftBank(boatCrossers);
                        moveRift.setDisable(false);
                        originator.set(new MoveInfo(leftBankCrossers,rightBankCrossers,moves,true,story));
                        caretaker.addMemento(originator.storeInMemento());
                        saveFiles++;
                        currentArticle++;
                        caretaker.clearAfterIndex(currentArticle+1);
                        //if(flag ==1)
                        //caretaker.newstatus(currentArticle+1);
                      //  flag = 0;
                        saveFiles = currentArticle;
                    });
                    onLeft = true;
                   // MoveInfo obj = new MoveInfo(leftBankCrossers,rightBankCrossers,moves,true,story);
               //     moveInfos.push(new MoveInfo(leftBankCrossers,rightBankCrossers,moves,true,story));
                  //  originator.set(new MoveInfo(leftBankCrossers,rightBankCrossers,moves,true,story));
                //    caretaker.addMemento(originator.storeInMemento());
                }
            }
        else
            errorWindow();
    }

    @Override
    public boolean canUndo() {
        if(currentArticle>=1)
        {
            return true;
        }
        else {
            //TODO: set undo button disabled
            return false;
        }
    }

    @Override
    public boolean canRedo() {
        if((saveFiles)>currentArticle){
            return true;

            //currentArticle++;
        }

        else {
            //TOD
            return false;
        }
    }
    @Override
    public void undo() {

        /*for(int x=0;x<leftBankImages.size();x++)
        {
            leftBankImages.get(x).setUserData(null);
            leftBankImages.get(x).setImage(null);
            rightBankImages.get(x).setUserData(null);
            rightBankImages.get(x).setImage(null);
        }*/
        //setMoveInfo(moveInfos.pop());
        currentArticle--;
        System.out.println("ldkf"+leftBankCrossers);
        MoveInfo tempInfo = info;
        System.out.println(originator.restoreFromMemento(caretaker.getMemento(currentArticle)).getLeftBankCrossers());
        MoveInfo z = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
        System.out.println(" oh jh             "+ z.equals(tempInfo));
        if(!z.equals(tempInfo)) {
            clearView();
            setMoveInfo(z);
            loadGame();
            if (currentArticle == 0) {
                undoButton.setDisable(true);
            }
            redoButton.setDisable(false);
        }
        flag =1;
        //TODO: set redo enabled

        //loadMoveInfo();
    }

    @Override
    public void redo() {
        clearView();
        currentArticle++;
        MoveInfo z = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
        setMoveInfo(z);
        loadGame();
        if(currentArticle==saveFiles) {
            redoButton.setDisable(true);
        }
        undoButton.setDisable(false);
        //TODO: sha3'al el undo
    }

    @Override
    public void saveGame() {
        System.out.println("before saving :  "+ caretaker.getMemento(currentArticle).getSavedArticle().getLeftBankCrossers());
        System.out.println(caretaker.getMemento(currentArticle).getSavedArticle().isBoatOnLeft());
        ICommand save = new SaveToFile(new Save(),caretaker.getMemento(currentArticle).getSavedArticle());
        Invoker invoker = new Invoker(save);
        invoker.press();

        //Save.saveToFile(caretaker.getMemento(currentArticle).getSavedArticle());
    }

    @Override
    public void loadGame() {
      //  setMoveInfo(info);
        loadMoveInfo();
    //    caretaker.clearAfterIndex(currentArticle+1);
        System.out.println();
        System.out.println(info.isBoatOnLeft());
        System.out.println("info    "+ onLeft);
     /*   if(onLeft)
        {
            raftAnchorPane.relocate(130,210);

            endX = 140;
            endY = -50;
            startX = 0;
            startY = 0;
        }
        else{
            raftAnchorPane.relocate(270,160);
            startX = -140;
            startY = 50;
            endX = 0;
            endY = 0;
        }*/
        boatCrossers.clear();
        boatCrosser1.setImage(null);
        boatCrosser2.setImage(null);
        leftBankImages.add(left1);
        leftBankImages.add(left2);
        leftBankImages.add(left3);
        leftBankImages.add(left4);
        leftBankImages.add(left5);
        leftBankImages.add(left6);
        leftBankImages.add(left7);
        rightBankImages.add(right1);
        rightBankImages.add(right2);
        rightBankImages.add(right3);
        rightBankImages.add(right4);
        rightBankImages.add(right5);
        rightBankImages.add(right6);
        rightBankImages.add(right7);
        onBoatImages.add(boatCrosser1);
        onBoatImages.add(boatCrosser2);
        onBoatLabels.add(boatLabel1);
        onBoatLabels.add(boatLabel2);
        leftBankLabels.add(leftLabel1);
        leftBankLabels.add(leftLabel2);
        leftBankLabels.add(leftLabel3);
        leftBankLabels.add(leftLabel4);
        leftBankLabels.add(leftLabel5);
        leftBankLabels.add(leftLabel6);
        leftBankLabels.add(leftLabel7);
        rightBankLabels.add(rightLabel1);
        rightBankLabels.add(rightLabel2);
        rightBankLabels.add(rightLabel3);
        rightBankLabels.add(rightLabel4);
        rightBankLabels.add(rightLabel5);
        rightBankLabels.add(rightLabel6);
        rightBankLabels.add(rightLabel7);
        boatLabel2.setDisable(true);
        boatLabel1.setDisable(true);

        String label=null;
        System.out.println("came hereeeeeee");
        if(story.getClass().equals(Story1.class))
            label = "eating rank";
        else if(story.getClass().equals(Story2.class)|| story.getClass().equals(Story3.class))
            label = "weight";
        for(int x=0;x<leftBankCrossers.size();x++)
            leftBankCrossers.get(x).setLabelToBeShown(label);
        for(int x=0;x<rightBankCrossers.size();x++)
            rightBankCrossers.get(x).setLabelToBeShown(label);


        int j=0;
        Image imgraft = new Image("WoodenRaft.png");
        raft.setImage(imgraft);
        crossers = story.getInitialCrossers();
        moveCounter.setText(String.valueOf(getNumberOfSails()));
        for(int x=0;x<leftBankCrossers.size();x++)
        {
            BufferedImage[] n = leftBankCrossers.get(x).getImages();
            Image l = SwingFXUtils.toFXImage(n[0],null);
            leftBankImages.get(x).setImage(l);
            leftBankImages.get(x).setUserData(leftBankCrossers.get(x));
            leftBankLabels.get(x).setText(leftBankCrossers.get(x).getLabelToBeShown());
        }
        for(int x =0;x<rightBankCrossers.size();x++)
        {
            BufferedImage[] n = rightBankCrossers.get(x).getImages();
            Image l = SwingFXUtils.toFXImage(n[0],null);
            rightBankImages.get(x).setImage(l);
            rightBankImages.get(x).setUserData(rightBankCrossers.get(x));
            rightBankLabels.get(x).setText(rightBankCrossers.get(x).getLabelToBeShown());
        }
        for(int x = 0;x<rightBankLabels.size();x++)
        {
            rightBankLabels.get(x).setDisable(true);
            leftBankLabels.get(x).setDisable(true);
        }
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    public  void moveRift (ActionEvent event)throws Exception{
            doMove(leftBankCrossers,onLeft);
    }
    public void left1Clicked(MouseEvent onClicked)throws Exception{
        if(left1.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left1.getUserData());
            boatCrossers.add((ICrosser)left1.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left1);
            left1.setImage(null);
            leftLabel1.setText(null);
        }
    }
    public void left2Clicked(MouseEvent onClicked)throws Exception{
        if(left2.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left2.getUserData());
            boatCrossers.add((ICrosser)left2.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left2);
            left2.setImage(null);
            leftLabel2.setText(null);
        }
    }
    public void left3Clicked(MouseEvent onClicked)throws Exception{
        if(left3.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left3.getUserData());
            boatCrossers.add((ICrosser)left3.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left3);
            left3.setImage(null);
            leftLabel3.setText(null);
        }
    }
    public void left4Clicked(MouseEvent onClicked)throws Exception{
        if(left4.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left4.getUserData());
            boatCrossers.add((ICrosser)left4.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left4);
            left4.setImage(null);

            leftLabel4.setText(null);
        }
    }
    public void left5Clicked(MouseEvent onClicked)throws Exception{
        if(left5.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left5.getUserData());
            boatCrossers.add((ICrosser)left5.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left5);
            left5.setImage(null);
            leftLabel5.setText(null);
        }
    }
    public void left6Clicked(MouseEvent onClicked)throws Exception{
        if(left6.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left6.getUserData());
            boatCrossers.add((ICrosser)left6.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left6);
            left6.setImage(null);
            leftLabel6.setText(null);
        }
    }
    public void left7Clicked(MouseEvent onClicked)throws Exception{
        if(left7.getImage()!=null && boatCrossers.size()<2 && onLeft) {
            leftBankCrossers.remove(left7.getUserData());
            boatCrossers.add((ICrosser)left7.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,left7);
            left7.setImage(null);
            leftLabel7.setText(null);
        }
    }
    public void boatCrosser1Clicked(MouseEvent onClicked)throws Exception{
        if(boatCrosser1.getImage()!=null)
        {
            if(onLeft) {
                for (int i = 0; i < leftBankImages.size(); i++) {
                    if (leftBankImages.get(i).getUserData()== boatCrosser1.getUserData()) {
                        leftBankImages.get(i).setImage(boatCrosser1.getImage());
                        leftBankLabels.get(i).setText(((ICrosser)boatCrosser1.getUserData()).getLabelToBeShown());
                        boatCrossers.remove(boatCrosser1.getUserData());
                        leftBankCrossers.add((ICrosser)boatCrosser1.getUserData());
                        boatCrosser1.setImage(null);
                        boatLabel1.setText(null);
                        break;
                    }
                }
            }
            else
            {
                for(int i = 0;i<rightBankImages.size();i++)
                {
                    if(rightBankImages.get(i).getUserData()==boatCrosser1.getUserData())
                    {
                        rightBankImages.get(i).setImage(boatCrosser1.getImage());
                        rightBankLabels.get(i).setText(((ICrosser)boatCrosser1.getUserData()).getLabelToBeShown());
                        boatCrossers.remove(boatCrosser1.getUserData());
                        rightBankCrossers.add((ICrosser)boatCrosser1.getUserData());
                        boatCrosser1.setImage(null);
                        boatLabel1.setText(null);
                        break;
                    }
                }
            }
        }
    }
    public void boatCrosser2Clicked(MouseEvent onClicked)throws Exception{
        if(boatCrosser2.getImage()!=null)
        {
            if(onLeft) {
                for (int i = 0; i < leftBankImages.size(); i++) {
                    if (leftBankImages.get(i).getUserData() == boatCrosser2.getUserData()) {
                        leftBankImages.get(i).setImage(boatCrosser2.getImage());
                        leftBankLabels.get(i).setText(((ICrosser)boatCrosser2.getUserData()).getLabelToBeShown());
                        boatCrossers.remove(boatCrosser2.getUserData());
                        leftBankCrossers.add((ICrosser)boatCrosser2.getUserData());
                        boatCrosser2.setImage(null);
                        boatLabel2.setText(null);
                        break;
                    }
                }
            }
            else
            {
                for(int i = 0;i<rightBankImages.size();i++)
                {
                    if(rightBankImages.get(i).getUserData() == boatCrosser2.getUserData())
                    {
                        rightBankImages.get(i).setImage(boatCrosser2.getImage());
                        rightBankLabels.get(i).setText(((ICrosser)boatCrosser2.getUserData()).getLabelToBeShown());
                        boatCrossers.remove(boatCrosser2.getUserData());
                        rightBankCrossers.add((ICrosser)boatCrosser2.getUserData());
                        boatCrosser2.setImage(null);
                        boatLabel2.setText(null);
                        break;
                    }
                }
            }
        }
    }
    public void right1Clicked(MouseEvent onClicked)throws Exception{
        if(right1.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right1.getUserData());
            boatCrossers.add((ICrosser)right1.getUserData());
            showBoatCrossers(boatCrossers,onLeft,right1);
            right1.setImage(null);
            rightLabel1.setText(null);
        }
    }
    public void right2Clicked(MouseEvent onClicked)throws Exception{
        if(right2.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right2.getUserData());
            boatCrossers.add((ICrosser)right2.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,right2);
            right2.setImage(null);
            rightLabel2.setText(null);
        }
    }
    public void right3Clicked(MouseEvent onClicked)throws Exception{
        if(right3.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right3.getUserData());
            boatCrossers.add((ICrosser)right3.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,right3);
            right3.setImage(null);
            rightLabel3.setText(null);
        }
    }
    public void right4Clicked(MouseEvent onClicked)throws Exception{
        if(right4.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right4.getUserData());
            boatCrossers.add((ICrosser)right4.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,right4);
            right4.setImage(null);
            rightLabel4.setText(null);
        }
    }
    public void right5Clicked(MouseEvent onClicked)throws Exception{
        if(right5.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right5.getUserData());
            boatCrossers.add((ICrosser)right5.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,right5);
            right5.setImage(null);
            rightLabel5.setText(null);
        }
    }
    public void right6Clicked(MouseEvent onClicked)throws Exception{
        if(right6.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right6.getUserData());
            boatCrossers.add((ICrosser)right6.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,right6);
            right6.setImage(null);
            rightLabel6.setText(null);
        }
    }
    public void right7Clicked(MouseEvent onClicked)throws Exception{
        if(right7.getImage()!=null && boatCrossers.size()<2 &&!onLeft) {
            rightBankCrossers.remove(right7.getUserData());
            boatCrossers.add((ICrosser)right7.getUserData());
            showBoatCrossers(boatCrossers,fromLeftToRightBank,right7);
            right7.setImage(null);
            rightLabel7.setText(null);
        }
    }
    private void showBoatCrossers(List<ICrosser> boatCrosser, boolean fromLeftToRightBank, ImageView imageView)
    {
            for(int i=0;i<2;i++)
            {
                if(onBoatImages.get(i).getImage()==null)
                {
                    onBoatImages.get(i).setVisible(true);
                    onBoatImages.get(i).setImage(imageView.getImage());
                    onBoatImages.get(i).setUserData(imageView.getUserData());
                    onBoatLabels.get(i).setText(((ICrosser)imageView.getUserData()).getLabelToBeShown());
                    break;
                }
            }
    }
    private void putCrossersOnLeftBank(List<ICrosser> boatCrosser)
    {
        int j =0;
        if(boatCrosser.size()==1)
        {
            for(int i = 0;i<5;i++)
            {
                if(leftBankImages.get(i).getImage()==null)
                {
                    for(j=0;j<2;j++) {
                        if(onBoatImages.get(j).getImage()!=null){
                            leftBankImages.get(i).setImage(onBoatImages.get(j).getImage());
                            leftBankImages.get(i).setUserData(onBoatImages.get(j).getUserData());
                            leftBankImages.get(i).setVisible(true);
                            leftBankLabels.get(i).setText(((ICrosser)onBoatImages.get(j).getUserData()).getLabelToBeShown());
                            onBoatImages.get(j).setImage(null);
                            onBoatLabels.get(j).setText(null);
                            leftBankCrossers.add((ICrosser)onBoatImages.get(j).getUserData());
                            boatCrossers.remove(onBoatImages.get(j).getUserData());
                            break;
                        }
                    }
                }
            }
        }
        else if(boatCrosser.size()==2)
        {
            for(int i = 0;i<5;i++)
            {
                if(leftBankImages.get(i).getImage()==null)
                {
                    leftBankImages.get(i).setImage(onBoatImages.get(j).getImage());
                    onBoatImages.get(j).setImage(null);
                    leftBankLabels.get(i).setText(((ICrosser)onBoatImages.get(j).getUserData()).getLabelToBeShown());
                    leftBankImages.get(i).setUserData(onBoatImages.get(j).getUserData());
                    leftBankImages.get(i).setVisible(true);
                    onBoatLabels.get(j).setText(null);
                    leftBankCrossers.add((ICrosser)onBoatImages.get(j).getUserData());
                    boatCrossers.remove(onBoatImages.get(j).getUserData());
                    j++;
                    if(j==2)
                        break;
                }
            }
        }
    }
    private void putCrossersOnRightBank(List<ICrosser> boatCrosser)
    {
        int j =0;
        if(boatCrosser.size()==1)
        {
            for(int i = 0;i<5;i++)
            {
                if(rightBankImages.get(i).getImage()==null)
                {
                    for(j=0;j<2;j++) {
                        if(onBoatImages.get(j).getImage()!=null){

                        rightBankImages.get(i).setImage(onBoatImages.get(j).getImage());
                        rightBankImages.get(i).setUserData(onBoatImages.get(j).getUserData());
                        rightBankLabels.get(i).setText(((ICrosser)onBoatImages.get(j).getUserData()).getLabelToBeShown());
                        rightBankImages.get(i).setVisible(true);
                        onBoatImages.get(j).setImage(null);
                        onBoatLabels.get(j).setText(null);
                        rightBankCrossers.add((ICrosser)onBoatImages.get(j).getUserData());
                        boatCrossers.remove(onBoatImages.get(j).getUserData());
                        break;
                    }
                    }
                }
            }
        }
        else if(boatCrosser.size()==2)
        {
            for(int i = 0;i<5;i++)
            {
                if(rightBankImages.get(i).getImage()==null)
                {
                   // leftBankImages.indexOf()

                    rightBankImages.get(i).setImage(onBoatImages.get(j).getImage());
                    onBoatImages.get(j).setImage(null);
                    rightBankImages.get(i).setUserData(onBoatImages.get(j).getUserData());
                    rightBankImages.get(i).setVisible(true);
                    onBoatLabels.get(j).setText(null);
                    rightBankLabels.get(i).setText(((ICrosser)onBoatImages.get(j).getUserData()).getLabelToBeShown());
                    rightBankCrossers.add((ICrosser)onBoatImages.get(j).getUserData());
                    boatCrossers.remove(onBoatImages.get(j).getUserData());
                    j++;
                    if(j==2)
                        break;
                }
            }
        }
    }
    public static void setStory(ICrossingStrategy story1){
        story = story1;
    }

    public  void showInstructions (ActionEvent event)throws Exception{
        getInstructions();

    }

    public  void undo (ActionEvent event)throws Exception{
        /* undo method*/
        if(canUndo())
            undo();
        else
            errorWindow2("Can not undo!");

    }
    public  void redo (ActionEvent event)throws Exception{

        /* redo method */
        if(canRedo())
            redo();
        else
            errorWindow2("Can not redo!");

    }

    public  void exitGame (ActionEvent event)throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("main menu.fxml"));
        Scene scene = new Scene(root,607,403);
        currentStage.setTitle("River Crossing");
        currentStage.setScene(scene);
        currentStage.show();

    }
/*
    public void winGame() throws IOException {
        Stage window1 = new Stage();

        window1.setTitle("Congratulations!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);

        Label label = new Label();
        label.setText("You Won!");
        label.setFont(new Font("Verdana",15));
        label.setTextFill(Color.web("#b22222"));
        Button closeButton = new Button("Close");
        MainMenu m = new MainMenu();
        closeButton.setOnAction(e -> {
            window1.close();
            try{
                Parent root = FXMLLoader.load(getClass().getResource("choose story.fxml"));
                Scene scene = new Scene(root,607,403);
                currentStage.setTitle("River Crossing");
                currentStage.setScene(scene);
                currentStage.show();
            }
            catch (Exception ee)
            {
                System.out.println("File not found");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.show();
    }*/
    public void errorWindow(){
        Stage window1 = new Stage();

        window1.setTitle("Error!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);
        Label label1 = new Label();
        Label label2 = new Label();
        label1.setText("Invalid move!");
        label1.setFont(new Font("Verdana",15));
        label1.setTextFill(Color.web("#b22222"));
        label2.setText("Please check instructions.");
        label2.setFont(new Font("Verdana",15));
        label2.setTextFill(Color.web("#b22222"));
        Button closeButton = new Button("Close");
        MainMenu m = new MainMenu();
        closeButton.setOnAction(e ->window1.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2,closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.show();
    }

    public void errorWindow2(String message){
        Stage window1 = new Stage();

        window1.setTitle("Error!");
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setMinWidth(300);
        window1.setMinHeight(200);
        Label label1 = new Label();
        Label label2 = new Label();
        label1.setText(message);
        label1.setFont(new Font("Verdana",15));
        label1.setTextFill(Color.web("#b22222"));
        Button closeButton = new Button("Close");
        MainMenu m = new MainMenu();
        closeButton.setOnAction(e ->window1.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2,closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window1.setScene(scene);
        window1.show();
    }

    public static Stage winStage;
    public void winGame() throws IOException {
        winStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("you win.fxml"));
        Scene scene = new Scene(root,340,200);
        winStage.setTitle("Congratulations!");
        winStage.setScene(scene);
        winStage.show();
    }
    public void saveButtonClicked(ActionEvent event)throws Exception{
        saveGame();
    }
    private void loadMoveInfo()
    {
       // System.out.println("here 2    ;");
        story = info.getStory();
        onLeft = info.isBoatOnLeft();
        rightBankCrossers = info.getRightBankCrossers();
        leftBankCrossers = info.getLeftBankCrossers();
       // position = info.getPosition();
        moves = info.getMoves();
      //  leftBankImages = info.getLeftBankImages();
     //   rightBankImages = info.getRightBankImages();
        //loadGame();


    }
    public static void setMoveInfo(MoveInfo newInfo)
    {
        info = newInfo;
        onLeft = info.isBoatOnLeft();
    }
    public void resetButtonClicked(ActionEvent event)throws Exception{
        //raftAnchorPane.relocate(130,210);
        if(!onLeft)
        {
            trans3.setDuration(Duration.millis(1));
            trans3.setToX(startX);
            trans3.setToY(startY);
            trans3.setNode(raftAnchorPane);
            trans3.play();
        }
        resetGame();
    }
    private void clearView(){
        if(!onLeft)
        {
            trans2.setDuration(Duration.millis(1));
            trans2.setToX(startX);
            trans2.setToY(startY);
            trans2.setNode(raftAnchorPane);
            trans2.play();
            onLeft = true;
        }
        else
        {
            trans2.setDuration(Duration.millis(1));
            trans2.setToX(endX);
            trans2.setToY(endY);
            trans2.setNode(raftAnchorPane);
            trans2.play();
            onLeft = false;
        }
        for(int x =0;x<rightBankImages.size();x++){
            leftBankImages.get(x).setImage(null);
            leftBankImages.get(x).setUserData(null);
            leftBankLabels.get(x).setText(null);
            rightBankImages.get(x).setImage(null);
            rightBankImages.get(x).setUserData(null);
            rightBankLabels.get(x).setText(null);
        }
        for(int x= 0;x<onBoatLabels.size();x++)
        {
            onBoatLabels.get(x).setText(null);
            onBoatImages.get(x).setImage(null);
            onBoatImages.get(x).setUserData(null);
        }
        leftBankLabels.clear();
        rightBankLabels.clear();
       // leftBankCrossers.clear();
       // rightBankCrossers.clear();
        rightBankImages.clear();
        leftBankImages.clear();
        boatCrossers.clear();
        onBoatImages.clear();
        onBoatLabels.clear();
        moveCounter.setText(String.valueOf(0));
    }
}

