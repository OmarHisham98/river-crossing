package sample;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

public class xmlFileStory1 {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("Game"); //seeb
            doc.appendChild(rootElement);

            //  story element
            Element story1 = doc.createElement("story");    //seeb
            rootElement.appendChild(story1);

            // setting attribute to element
            Attr attr1 = doc.createAttribute("number");  //seeb
            attr1.setValue("1");
            story1.setAttributeNode(attr1);

            // moves element
            Element moves1 = doc.createElement("moves"); //seeb
            moves1.appendChild(doc.createTextNode("7")); // el create text node hata5od el get counter
            story1.appendChild(moves1);

            // position element
            Element raftpos1 = doc.createElement("raftpos");
            raftpos1.appendChild(doc.createTextNode("Left"));
            story1.appendChild(raftpos1);

            //obj on raft element
            Element onraft1 = doc.createElement("onraft");
            onraft1.appendChild(doc.createTextNode("Farmer"));
            story1.appendChild(onraft1);

            //obj on left bank element
            Element onleft1 = doc.createElement("onleft");
            onleft1.appendChild(doc.createTextNode("Lettuce and Wolf"));
            story1.appendChild(onleft1);

            //obj on right bank element
            Element onright1 = doc.createElement("onright");
            onright1.appendChild(doc.createTextNode("Sheep"));
            story1.appendChild(onright1);


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("./writeStory1.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File inputFile = new File("writeStory1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("story");
            System.out.println("----------------------------");
            System.out.println(nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Story number : " + eElement.getAttribute("number"));

                    System.out.println("Number of Moves : " + eElement.getElementsByTagName("moves").item(temp).getTextContent());

                    System.out.println("Position of Raft : " + eElement.getElementsByTagName("raftpos").item(temp).getTextContent());

                    System.out.println("Objects on raft : " + eElement.getElementsByTagName("onraft").item(temp).getTextContent());
                    System.out.println("Farmers: "+ eElement.getElementsByTagName("Farmer").item(0));

                    System.out.println("Objects on Left Bank : " + eElement.getElementsByTagName("onleft").item(temp).getTextContent());

                    System.out.println("Objects on Right Bank : " + eElement.getElementsByTagName("onright").item(temp).getTextContent());
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}