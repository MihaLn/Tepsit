import java.io.*;
import javax.xml.*;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class Parsing 
{	
	public static Document builder(String filename) throws ParserConfigurationException,SAXException,IOException
	{
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document document;
		
		factory=DocumentBuilderFactory.newInstance();
		builder=factory.newDocumentBuilder();
		document=builder.parse(filename);
		
		return document;
	}
}
