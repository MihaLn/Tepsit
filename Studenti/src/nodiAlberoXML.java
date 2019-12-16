import java.io.*;
import javax.xml.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class nodiAlberoXML 
{
	Document XML;
	static Element root;
	public void pars() throws ParserConfigurationException, SAXException, IOException
	{
		XML = Parsing.builder("/Volumes/SPINASD/JAVA TEPSIT/Studenti/src/studenti.xml");
	}
	
	public void stampa() 
	throws ParserConfigurationException, SAXException, IOException 
	{	
		root = XML.getDocumentElement();
		NodeList studenti;
		studenti=root.getElementsByTagName("studente");
		System.out.println(studenti.getLength());
		if(studenti != null && studenti.getLength()>0)
		{
			System.out.println(studenti.getLength());
			for(int i=0;i<studenti.getLength();i++) 
			{
				System.out.println(i);
				Element element=(Element)studenti.item(i);
				System.out.print(element.getAttributeNode("nome")+"\n");
				System.out.print(element.getAttributeNode("cognome")+"\n \n");
			}
		}
	
	}
	
	public void aggiuniStudente(String nomestud,String cognomestud)
	{
		Element studente= XML.createElement("studente");
		Element nome = XML.createElement("nome");
		Element cognome = XML.createElement("cognome");
		Text textNome=XML.createTextNode(nomestud);
		Text textCognome=XML.createTextNode(cognomestud);
		
		nome.appendChild(textNome);
		
		cognome.appendChild(textCognome);
		
		studente.appendChild(nome);
		
		studente.appendChild(cognome);
		
		root.appendChild(studente);
		
	}
	
	public void aggiungiVoti(String nome,String cognome,String materiavot,String votomat)
	{
		NodeList studenti=root.getElementsByTagName("studente");
		for(int i=0;i<studenti.getLength();i++) 
		{
			Element element=(Element)studenti.item(i);
			if(element.getAttributeNode("nome").equals(nome) && element.getAttributeNode("cognome").equals(cognome))
			{
				Element voti= XML.createElement("voti");
				Element voto= XML.createElement("voto");
				Text materia= XML.createTextNode(materiavot);
				Text votomateria= XML.createTextNode(votomat);
				
				voto.appendChild(materia);
				voto.appendChild(votomateria);
				voti.appendChild(voto);
				studenti.item(i).appendChild(voti);
				
			}
		}
	}
	
}
