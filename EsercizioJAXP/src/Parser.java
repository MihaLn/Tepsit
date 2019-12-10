import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {
	private List Studenti;
	
	public Parser() {
		Studenti = new ArrayList();
	}
	public List parseDocument (String filename)throws ParserConfigurationException, SAXException, IOException 
	{
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document document;
		Element root, element;
		NodeList nodelist;
		//creazione dell'albero DOM dal documento XML
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.parse(filename);
		root = document.getDocumentElement();
		//generazione della lista degli elementi "studente"
		nodelist = root.getElementsByTagName("studente");
		if (nodelist != null && nodelist.getLength()>0) {
			for(int i=0; i<nodelist.getLength();i++) {
				element = (Element)nodelist.item(i);

			}
		}
		return Studenti;
	}
}
