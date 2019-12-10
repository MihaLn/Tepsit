import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
public class Xml {

	Document document;
	
	public Xml(List studenti) throws ParserConfigurationException
	{
		createDOMTree(studenti);
	}
	
	private void createDOMTree(List studenti)
	throws ParserConfigurationException{
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Element root;
		Iterator iterator;
		Element element;
		
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.newDocument();
		//crea il nodo radice
		root = document.createElement("studenti");
		document.appendChild(root);
		//per ogni oggetto Studente crea un nodo figlio del nodo radice
		iterator = studenti.iterator();
		while (iterator.hasNext()) {
			studente = (Studente)it.next();
			element = createStudenteElement(studente);
			root.appendChild(element);
		}
	}
}



