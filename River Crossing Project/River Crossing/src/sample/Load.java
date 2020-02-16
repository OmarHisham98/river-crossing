package sample;

import com.sun.org.apache.bcel.internal.generic.IXOR;
import com.sun.xml.internal.fastinfoset.Encoder;
//import org.w3c.dom.*;

import javax.xml.parsers.*;
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
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;
import java.util.ArrayList;

public class Load {

    Story1 story1 = new Story1();
    Story2 story2 = new Story2();
    Story3 story3 = new Story3();
    Story4 story4 = new Story4();

    public MoveInfo loadFromFile()
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
                if(root.getElementsByTagName("raftPosition").item(0).getTextContent().equals("left"))
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
                            Lefftt.add(new Goat(Integer.valueOf(childNode.getTextContent())));
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
            else if( root.getElementsByTagName("story").item(0).getTextContent().equals("2")){
                //Story
                info.setStory(story2);
                //RAFT POSITION
                if(root.getElementsByTagName("raftPosition").item(0).getTextContent().equals("left"))
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

        return info;
    }
}
