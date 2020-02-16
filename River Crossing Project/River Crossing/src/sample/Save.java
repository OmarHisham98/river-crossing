package sample;

import com.sun.org.apache.bcel.internal.generic.IXOR;
import com.sun.xml.internal.fastinfoset.Encoder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static sample.Main.currentStage;

public class Save {
    public static void saveToFile(MoveInfo data) {

        System.out.println(data.getLeftBankCrossers() + "6666666666666666666666");
        System.out.println(data.getRightBankCrossers() + "6666666666666666666666");
       /* try {
            FileOutputStream fos = new FileOutputStream(new File("./ourfile.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
       //     System.out.println(info.rightBankCrossers);
            encoder.writeObject(info);
            encoder.close();
            fos.close();
        }catch (IOException ex)
        {
            System.out.println("catch");
            ex.printStackTrace();
        }
        }
    public static MoveInfo loadFromFile()
    {
        MoveInfo info = new MoveInfo();
        try {
            FileInputStream fis = new FileInputStream(new File("./ourfile.xml"));
            XMLDecoder decoder = new XMLDecoder(fis);
            info = (MoveInfo)decoder.readObject();
            //System.out.println(info.moves);
            //System.out.println(info.getLeftBankCrossers());
            //System.out.println(info.getLeftBankImages());
            //System.out.println(info.getStory());
            //System.out.println(info.getRightBankCrossers());
            //System.out.println(info.getRightBankImages());
            //System.out.println(info.isBoatOnLeft());
            System.out.println("bahahaha" +info.isBoatOnLeft());
            fis.close();
        } catch (Exception e) {
            System.out.println("File Error");
            e.printStackTrace();
        }
        return info;

    }*/

        try {

            //MoveInfo data = new MoveInfo();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("Game"); //seeb
            doc.appendChild(rootElement);

            //  story element
            Element story = doc.createElement("Story");    //seeb
            if (data.getStory().getClass().equals(Story1.class)) {

                story.appendChild(doc.createTextNode("1")); //seeb
                rootElement.appendChild(story);
                /*Attr attr = doc.createAttribute("Number");  //seeb
                attr.setValue("1");
                story.setAttributeNode(attr);*/

            } else if (data.getStory().getClass().equals(Story2.class)) {

                story.appendChild(doc.createTextNode("2")); //seeb
                rootElement.appendChild(story);
                /*Attr attr = doc.createAttribute("Number");  //seeb
                attr.setValue("2");
                story.setAttributeNode(attr);*/
            } else if (data.getStory().getClass().equals(Story3.class)) {

                story.appendChild(doc.createTextNode("3")); //seeb
                rootElement.appendChild(story);
                /*Attr attr = doc.createAttribute("Number");  //seeb
                attr.setValue("3");
                story.setAttributeNode(attr);*/
            } else if (data.getStory().getClass().equals(Story4.class)) {

                story.appendChild(doc.createTextNode("4"));
                rootElement.appendChild(story);
                /*Attr attr = doc.createAttribute("Number");  //seeb
                attr.setValue("4");
                story.setAttributeNode(attr);*/
            }

            // moves element
            Element moves = doc.createElement("Moves"); //seeb
            moves.appendChild(doc.createTextNode(String.valueOf(data.getMoves()))); // el create text node hata5od el get counter
            rootElement.appendChild(moves);

            // position element
            Element raftpos = doc.createElement("raftPosition");
            if (data.isBoatOnLeft()) {

                raftpos.appendChild(doc.createTextNode("Left"));
                rootElement.appendChild(raftpos);
            } else if (!data.isBoatOnLeft()) {

                raftpos.appendChild(doc.createTextNode("Right"));
                rootElement.appendChild(raftpos);
            }

            //obj on raft element
            /*Element onraft = doc.createElement("onraft");
            onraft1.appendChild(doc.createTextNode("Farmer"));
            story.appendChild(onraft1);*/

            //obj on left bank element
            Element onleft = doc.createElement("onLeft");
            int sizeL = data.getLeftBankCrossers().size();
            for (int i = 0; i < sizeL; i++) {

                if (data.getLeftBankCrossers().get(i).getClass().equals(Farmer.class)) {

                    Element first = doc.createElement("farmer");
                    first.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(first);
                    /*Attr attr1 = doc.createAttribute("Weight");
                    attr1.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    first.setAttributeNode(attr1);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Wolf.class)) {

                    Element second = doc.createElement("wolf");
                    second.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(second);
                   /* Attr attr2 = doc.createAttribute("Weight");
                    attr2.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    second.setAttributeNode(attr2);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Plant.class)) {

                    Element third = doc.createElement("plant");
                    third.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(third);
                   /* Attr attr3 = doc.createAttribute("Weight");
                    attr3.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    third.setAttributeNode(attr3);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Goat.class)) {

                    Element fourth = doc.createElement("goat");
                    fourth.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(fourth);
                    /*Attr attr4 = doc.createAttribute("Weight");
                    attr4.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    fourth.setAttributeNode(attr4);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Child.class)) {

                    Element fifth = doc.createElement("child");
                    fifth.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(fifth);
                   /* Attr attr5 = doc.createAttribute("Weight");
                    attr5.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    fifth.setAttributeNode(attr5);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Girl.class)) {

                    Element sixth = doc.createElement("girl");
                    sixth.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(sixth);
                   /* Attr attr6 = doc.createAttribute("Weight");
                    attr6.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    sixth.setAttributeNode(attr6);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Rabbit.class)) {

                    Element seventh = doc.createElement("rabbit");
                    seventh.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(seventh);
                   /* Attr attr7 = doc.createAttribute("Weight");
                    attr7.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    seventh.setAttributeNode(attr7);*/

                } else if (data.getLeftBankCrossers().get(i).getClass().equals(Boy.class)) {

                    Element eighth = doc.createElement("boy");
                    eighth.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(i).getWeight())));
                    onleft.appendChild(eighth);
                   /* Attr attr7 = doc.createAttribute("Weight");
                    attr7.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    seventh.setAttributeNode(attr7);*/

                }
                rootElement.appendChild(onleft);
            }


            //obj on right bank element
            Element onright = doc.createElement("onRight");
            int sizeR = data.getRightBankCrossers().size();

            for (int j = 0; j < sizeR; j++) {

                if (data.getRightBankCrossers().get(j).getClass().equals(Farmer.class)) {

                    Element one = doc.createElement("farmer");
                    one.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(one);
                        /*Attr attr8 = doc.createAttribute("Weight");
                        attr8.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        one.setAttributeNode(attr8);*/

                } else if (data.getRightBankCrossers().get(j).getClass().equals(Wolf.class)) {

                    Element two = doc.createElement("wolf");
                    two.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(two);
                        /*Attr attr9 = doc.createAttribute("Weight");
                        attr9.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        two.setAttributeNode(attr9);*/

                } else if (data.getRightBankCrossers().get(j).getClass().equals(Plant.class)) {

                    Element three = doc.createElement("plant");
                    three.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(three);
                        /*Attr attr10 = doc.createAttribute("Weight");
                        attr10.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        three.setAttributeNode(attr10);*/

                } else if (data.getRightBankCrossers().get(j).getClass().equals(Goat.class)) {

                    Element four = doc.createElement("goat");
                    four.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(four);
                        /*Attr attr11 = doc.createAttribute("Weight");
                        attr11.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        four.setAttributeNode(attr11);*/

                } else if (data.getRightBankCrossers().get(j).getClass().equals(Child.class)) {

                    Element five = doc.createElement("child");
                    five.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(five);
                       /* Attr attr12 = doc.createAttribute("Weight");
                        attr12.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        five.setAttributeNode(attr12);*/

                } else if (data.getRightBankCrossers().get(j).getClass().equals(Girl.class)) {

                    Element six = doc.createElement("girl");
                    six.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(six);
                        /*Attr attr13 = doc.createAttribute("Weight");
                        attr13.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        six.setAttributeNode(attr13);*/

                } else if (data.getRightBankCrossers().get(j).getClass().equals(Rabbit.class)) {

                    Element seven = doc.createElement("rabbit");
                    seven.appendChild(doc.createTextNode(String.valueOf(data.getRightBankCrossers().get(j).getWeight())));
                    onright.appendChild(seven);
                        /*Attr attr14 = doc.createAttribute("Weight");
                        attr14.setValue(String.valueOf(data.getLeftBankCrossers().get(j).getWeight()));
                        seven.setAttributeNode(attr14);*/

                } else if (data.getLeftBankCrossers().get(j).getClass().equals(Boy.class)) {

                    Element eight = doc.createElement("boy");
                    eight.appendChild(doc.createTextNode(String.valueOf(data.getLeftBankCrossers().get(j).getWeight())));
                    onleft.appendChild(eight);
                   /* Attr attr7 = doc.createAttribute("Weight");
                    attr7.setValue(String.valueOf(data.getLeftBankCrossers().get(i).getWeight()));
                    seventh.setAttributeNode(attr7);*/

                }

                rootElement.appendChild(onright);
            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("./writeStory.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Story1 story1 = new Story1();
    Story2 story2 = new Story2();
    Story3 story3 = new Story3();
    Story4 story4 = new Story4();

    public void loadFromFile()
    {
        MoveInfo info = new MoveInfo();
        try {
            //FileInputStream fis = new FileInputStream(new File("./ourfile.xml"));
            //XMLDecoder decoder = new XMLDecoder(fis);
            //info = (MoveInfo)decoder.readObject();
            //System.out.println(info.moves);
            //System.out.println(info.getLeftBankCrossers());
            //System.out.println(info.getLeftBankImages());
            //System.out.println(info.getStory());
            //System.out.println(info.getRightBankCrossers());
            //System.out.println(info.getRightBankImages());
            //System.out.println(info.isBoatOnLeft());
            //System.out.println("bahahaha" +info.isBoatOnLeft());
            File inputFile = new File("./writeStory.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Story");
            System.out.println("----------------------------");
            System.out.println(nList.getLength());
            Element root = doc.getDocumentElement();
            ArrayList<ICrosser> Lefftt = new ArrayList<>();
            ArrayList<ICrosser> Rightt = new ArrayList<>();
            System.out.println("help   "+root.getElementsByTagName("Story").item(0).getTextContent().equals("1"));
            System.out.println(root.getElementsByTagName("Story").item(0).getTextContent());


            if( root.getElementsByTagName("Story").item(0).getTextContent().equals("1")){
                //Story
                info.setStory(story1);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").item(0).getTextContent().equals("Left"))
                    info.setBoatOnLeft(true);
                else
                    info.setBoatOnLeft(false);
                //moves
                info.setMoves(Integer.valueOf(root.getElementsByTagName("Moves").item(0).getTextContent()));
                System.out.println("this is the moves"+info.getMoves());
                //crossers
                NodeList onLeftList = doc.getElementsByTagName("onLeft");
                System.out.println("this is the length"+onLeftList.getLength());
                for(int j = 0; j < onLeftList.getLength() ; j++ ){
                    NodeList childList = onLeftList.item(j).getChildNodes();
                    System.out.println("this is the childlist length "+childList.getLength());
                    for(int i = 0; i< childList.getLength();i++){
                        Node childNode = childList.item(i);
                        if ("farmer".equals(childNode.getNodeName())) {
                            //Farmer farmer = new Farmer();
                            //           int x = (Long)Double.valueOf(childNode.getTextContent());
                            Lefftt.add(new Farmer(Double.valueOf(childNode.getTextContent())));
                            System.out.println("farmerrrrrr");
                        }
                        else if ("goat".equals(childNode.getNodeName())){
                            // Goat goat = new Goat();
                            Lefftt.add(new Goat(Double.valueOf(childNode.getTextContent())));
                            System.out.println("goooaaaat");
                        }
                        else if("plant".equals(childNode.getNodeName())){
                            // Plant plant = new Plant();
                            System.out.println(" h bh rjk ijhgjh     "+childNode.getTextContent());
                            Lefftt.add(new Plant(10));
                            System.out.println("plantttt");
                        }
                        else if("wolf".equals(childNode.getNodeName())){
                            // Wolf wolf = new Wolf();
                            Lefftt.add(new Wolf(Double.valueOf(childNode.getTextContent())));
                            System.out.println("wolff");
                        }
                    }
                }
                NodeList onRightList = doc.getElementsByTagName("onRight");
                for(int k = 0; k < onRightList.getLength() ; k++ ){
                    NodeList childList2 = onRightList.item(k).getChildNodes();
                    for(int y = 0; y< childList2.getLength();y++){
                        Node childNode = childList2.item(y);
                        if ("farmer".equals(childNode.getNodeName())) {
                            //Farmer farmer = new Farmer();
                            Rightt.add(new Farmer(Double.valueOf(childNode.getTextContent())));
                        }
                        else if ("goat".equals(childNode.getNodeName())){
                            //Goat goat = new Goat();
                            Rightt.add(new Goat(Double.valueOf(childNode.getTextContent())));
                        }
                        else if("plant".equals(childNode.getNodeName())){
                            //Plant plant = new Plant();
                            Rightt.add(new Plant(Double.valueOf(childNode.getTextContent())));
                        }
                        else if("wolf".equals(childNode.getNodeName())){
                            //Wolf wolf = new Wolf();
                            Rightt.add(new Wolf(Double.valueOf(childNode.getTextContent())));
                        }
                    }
                }
                info.setLeftBankCrossers(Lefftt);
                info.setRightBankCrossers(Rightt);
            }
            else if( root.getElementsByTagName("Story").item(0).getTextContent().equals("2")){
                //Story
                info.setStory(story2);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").item(0).getTextContent().equals("Left"))
                    info.setBoatOnLeft(true);
                else
                    info.setBoatOnLeft(false);
                //moves
                info.setMoves(Integer.valueOf(root.getElementsByTagName("Moves").item(0).getTextContent()));
                //crossers
                NodeList onLeftList = doc.getElementsByTagName("onLeft");
                for(int j = 0; j < onLeftList.getLength() ; j++ ){
                    NodeList childList = onLeftList.item(j).getChildNodes();
                    for(int i = 0; i< childList.getLength();i++){
                        Node childNode = childList.item(i);
                        if ("farmer".equals(childNode.getNodeName())) {
                            //Farmer farmer = new Farmer();
                            Lefftt.add(new Farmer(Double.valueOf(childNode.getTextContent())));
                        }
                        else if("rabbit".equals(childNode.getNodeName())){
                            //Rabbit rabbit = new Rabbit();
                            Lefftt.add(new Rabbit(Double.valueOf(childNode.getTextContent())));
                        }
                    }
                }
                NodeList onRightList = doc.getElementsByTagName("onRight");
                for(int k = 0; k < onRightList.getLength() ; k++ ){
                    NodeList childList = onRightList.item(k).getChildNodes();
                    for(int y = 0; y< childList.getLength();y++){
                        Node childNode = childList.item(y);
                        if ("farmer".equals(childNode.getNodeName())) {
                            //Farmer farmer = new Farmer();
                            Rightt.add(new Farmer(Double.valueOf(childNode.getTextContent())));
                        }
                        else if("rabbit".equals(childNode.getNodeName())){
                            //Rabbit rabbit = new Rabbit();
                            Rightt.add(new Rabbit(Double.valueOf(childNode.getTextContent())));
                        }
                    }
                }
                info.setLeftBankCrossers(Lefftt);
                info.setRightBankCrossers(Rightt);

            }
            else if( root.getElementsByTagName("Story").item(0).getTextContent().equals("3")){
                //Story
                info.setStory(story3);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").item(0).getTextContent().equals("Left"))
                    info.setBoatOnLeft(true);
                else
                    info.setBoatOnLeft(false);
                //moves
                info.setMoves(Integer.valueOf(root.getElementsByTagName("Moves").item(0).getTextContent()));
                System.out.println("this is the moves"+info.getMoves());
                //crossers
                NodeList onLeftList = doc.getElementsByTagName("onLeft");
                System.out.println("this is the length"+onLeftList.getLength());
                for(int j = 0; j < onLeftList.getLength() ; j++ ){
                    NodeList childList = onLeftList.item(j).getChildNodes();
                    System.out.println("this is the childlist length "+childList.getLength());
                    for(int i = 0; i< childList.getLength();i++){
                        Node childNode = childList.item(i);
                        if ("farmer".equals(childNode.getNodeName())) {
                            //Farmer farmer = new Farmer();
                            //           int x = (Long)Double.valueOf(childNode.getTextContent());
                            Lefftt.add(new Farmer(Double.valueOf(childNode.getTextContent())));
                            System.out.println("farmerrrrrr     s3");
                        }
                        else if ("child".equals(childNode.getNodeName())){
                            // Goat goat = new Goat();
                            Lefftt.add(new Child(Double.valueOf(childNode.getTextContent())));
                            System.out.println(" Child    s3");
                        }
                    }
                }
                NodeList onRightList = doc.getElementsByTagName("onRight");
                for(int k = 0; k < onRightList.getLength() ; k++ ){
                    NodeList childList2 = onRightList.item(k).getChildNodes();
                    for(int y = 0; y< childList2.getLength();y++){
                        Node childNode = childList2.item(y);
                        if ("farmer".equals(childNode.getNodeName())) {
                            //Farmer farmer = new Farmer();
                            Rightt.add(new Farmer(Double.valueOf(childNode.getTextContent())));
                        }
                        else if ("child".equals(childNode.getNodeName())){
                            // Goat goat = new Goat();
                            Rightt.add(new Child(Double.valueOf(childNode.getTextContent())));
                            System.out.println(" Child    s3");
                        }
                    }
                }
                info.setLeftBankCrossers(Lefftt);
                info.setRightBankCrossers(Rightt);
            }
            else if( root.getElementsByTagName("Story").item(0).getTextContent().equals("4")){
                //Story
                info.setStory(story4);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").item(0).getTextContent().equals("Left"))
                    info.setBoatOnLeft(true);
                else
                    info.setBoatOnLeft(false);
                //moves
                info.setMoves(Integer.valueOf(root.getElementsByTagName("Moves").item(0).getTextContent()));
                System.out.println("this is the moves"+info.getMoves());
                //crossers
                NodeList onLeftList = doc.getElementsByTagName("onLeft");
                System.out.println("this is the length"+onLeftList.getLength());
                for(int j = 0; j < onLeftList.getLength() ; j++ ){
                    NodeList childList = onLeftList.item(j).getChildNodes();
                    System.out.println("this is the childlist length "+childList.getLength());
                    for(int i = 0; i< childList.getLength();i++){
                        Node childNode = childList.item(i);
                        if ("boy".equals(childNode.getNodeName())) {
                            Lefftt.add(new Boy(Double.valueOf(childNode.getTextContent())));
                            System.out.println("boy     s4");
                        }
                        else if ("girl".equals(childNode.getNodeName())){
                            Lefftt.add(new Girl(Double.valueOf(childNode.getTextContent())));
                            System.out.println(" Girl    s4");
                        }
                    }
                }
                NodeList onRightList = doc.getElementsByTagName("onRight");
                for(int k = 0; k < onRightList.getLength() ; k++ ){
                    NodeList childList2 = onRightList.item(k).getChildNodes();
                    for(int y = 0; y< childList2.getLength();y++){
                        Node childNode = childList2.item(y);
                        if ("boy".equals(childNode.getNodeName())) {
                            Rightt.add(new Boy(Double.valueOf(childNode.getTextContent())));
                        }
                        else if ("girl".equals(childNode.getNodeName())){
                            Rightt.add(new Girl(Double.valueOf(childNode.getTextContent())));
                            System.out.println(" Girl    s4");
                        }
                    }
                }
                info.setLeftBankCrossers(Lefftt);
                info.setRightBankCrossers(Rightt);
            }


            /*else if(root.getElementsByTagName("story").equals("3")){
                //Story
                info.setStory(story3);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").equals("left"))
                    info.setBoatOnLeft(true);
                else
                    info.setBoatOnLeft(false);
                //moves
                info.setMoves(Integer.valueOf(String.valueOf(root.getElementsByTagName("Moves"))));
                //crossers
            }
            else{
                //Story
                info.setStory(story4);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").equals("left"))
                    info.setBoatOnLeft(true);
                else
                    info.setBoatOnLeft(false);
                //moves
                info.setMoves(Integer.valueOf(String.valueOf(root.getElementsByTagName("Moves"))));
            }*/
            System.out.println(info.getLeftBankCrossers()+"<--left bank"+info.getRightBankCrossers()+"<==right bank"+info.getMoves());
        } catch (Exception e) {
            System.out.println("File Error");
            e.printStackTrace();
        }


        try {
            GamePlay.isNewGame = false;
            GamePlay.setMoveInfo(info);
            Parent root = FXMLLoader.load(getClass().getResource("game play.fxml"));
            Scene scene = new Scene(root, 607, 403);
            currentStage.setTitle("River Crossing");
            currentStage.setScene(scene);
            currentStage.show();
            Caretaker caretaker = Caretaker.getInstance();
            caretaker.clearMementos();
            Originator originator = Originator.getInstance();
            originator.set(info);
            caretaker.addMemento(originator.storeInMemento());
        }catch(IOException e)
        {

            System.out.println("Loading failed!!!!");
            e.printStackTrace();
        }


    }

}