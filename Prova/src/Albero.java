import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Albero {

	private Document XML1,XML2; // <---crazione della radice 
	private static Element nodo; // <---creazione di un elemento dell nodo 
	public void pars() throws ParserConfigurationException, SAXException, IOException
	{
		XML1 = Parser.builder("Film.xml");//<--- parsing del file xml denominato Film.xml implementato
		nodo = XML1.getDocumentElement();
		XML2 = Parser.builder("Film2.xml");
		nodo = XML2.getDocumentElement(); // <---prende i elementi della radice e li assenga al elemento nodo
	}
	public void stampa() throws ParserConfigurationException, SAXException, IOException 
	{
		NodeList canali;// <---Lista di nodi presa dal file xml implementato
		canali = nodo.getElementsByTagName("film"); // <---prende gli elementi del nodo con il nome film
		canali = nodo.getElementsByTagName("film");
		// cicla l'albero e stampa gli elementi presenti nell albero
		//->
		if(canali != null && canali.getLength()>0) 
		{
			System.out.println(canali.getLength());
			for(int i=0;i<canali.getLength();i++) 
			{
				
				Node node=(Node)canali.item(i);
				// stampa il primo nodo del elemento film
				System.out.print("Titolo  : "+node.getChildNodes().item(1).getChildNodes().item(0).getTextContent()+"\n");
				//stampa  il 3 nodo del elemento film
				System.out.print("Genere  : "+node.getChildNodes().item(3).getChildNodes().item(0).getTextContent()+"\n \n");
				//stampa il 5 nodo del elemento film
				System.out.print("Ora  : "+node.getChildNodes().item(5).getChildNodes().item(0).getTextContent()+"\n \n \n");
			}
		}
		//<-}
	}
	public void aggiungiFilm(String titolofilm,String generefilm,String orafilm )
	{
		//Creazione di elementi da aggiungere per inserire un altro film
		//{->
		Element film= XML1.createElement("film");
		Element titolo = XML1.createElement("titolo");
		Element genere = XML1.createElement("genere");
		Element ora = XML1.createElement("ora");
		//<-}
		//Creazione di contenuti testuali da aggiungere per inserire un altro film
		//{->
		Text texttitolo=XML1.createTextNode(titolofilm);
		Text textgenere=XML1.createTextNode(generefilm);
		Text textora=XML1.createTextNode(orafilm);
		//<-}
		
		// stampa dei figli della radice 
		//{->
		titolo.appendChild(texttitolo);
		
		genere.appendChild(textgenere);
			
		ora.appendChild(textora);
		
		film.appendChild(XML1.createElement("null"));
		
		film.appendChild(titolo);
		
		film.appendChild(XML1.createElement("null"));
		
		film.appendChild(genere);
		
		film.appendChild(XML1.createElement("null"));
		
		film.appendChild(ora);
		
		nodo.appendChild(film);
		//<-}
	}
	
}
