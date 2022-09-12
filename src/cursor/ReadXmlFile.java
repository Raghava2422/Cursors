package cursor;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
		DocumentBuilder  builder = db.newDocumentBuilder();
		// Fetch XML File
		
		Document doc = builder.parse(new File("dataset.xml"));
		doc.getDocumentElement().normalize();
		
		//Get root node
		
		Element root = doc.getDocumentElement();
		System.out.println(root.getNodeName());
		 
		//Get all the cars
		
		NodeList nList = doc.getElementsByTagName("cars");
		System.out.println("-------------");
		
		for(int i =0;i<nList.getLength();i++) {
			Node node= nList.item(i);
			System.out.println();
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				
				//print each car details
				
				Element element = (Element) node;
				System.out.println("car id :" + element.getAttribute("id"));
				System.out.println("car Name:" + element.getElementsByTagName("carName").item(0).getTextContent());
				System.out.println("car Model Year :" + element.getElementsByTagName("carModelYear").item(0).getTextContent());
				System.out.println("car Owner :" + element.getElementsByTagName("carOwner").item(0).getTextContent());
				System.out.println("car Model:" + element.getElementsByTagName("carModel").item(0).getTextContent());
			}
			
			
		}
		
	}

}
