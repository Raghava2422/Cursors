package cursor;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PutXMLDB {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException {
		
		// connection to DB
		 Class.forName("org.postgresql.Driver");
		 String url = "jdbc:postgresql://localhost:5432/Base1";
		    String user = "postgres";
		    String pass = "2422";
		   
		    //connection
		    Connection con = DriverManager.getConnection(url,user,pass);
		    Statement stat=con.createStatement();
		
		DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
		DocumentBuilder  builder = db.newDocumentBuilder();
		// Fetch XML File
		
		Document doc = builder.parse(new File("C:\\Cursors\\src\\cursor\\dataset.xml"));
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
				
				//String id = element.getAttribute("id");
				String carname = element.getElementsByTagName("carName").item(0).getTextContent();
				String cmy = element.getElementsByTagName("carModelYear").item(0).getTextContent();
				String carown = element.getElementsByTagName("carOwner").item(0).getTextContent();
				String carmodel =  element.getElementsByTagName("carModel").item(0).getTextContent();
				
				int r = stat.executeUpdate("insert into public.xmlf(car_name,car_model_year,car_owner,car_model) values ('"+carname+"','"+cmy+"','"+carown+"','"+carmodel+"')");
				System.out.println("done");
			}
			
			
		}
		
	}

}
