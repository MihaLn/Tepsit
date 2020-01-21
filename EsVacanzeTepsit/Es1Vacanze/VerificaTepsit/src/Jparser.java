import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Jparser 
{
	private String filename;//percorso del file
	
	public Jparser(String file)//costruttore a cui viene passato il nome del file
	{
		this.filename=file;
	}
	
	public void parseFile() throws ParserConfigurationException, SAXException, IOException // metodo per il parsing del documento
	{
		DocumentBuilderFactory factory;// per il parsing
		DocumentBuilder builder; //per il parsing
		Document doc;// conterrà la struttura ad albero generata dal parsing
		
		factory = DocumentBuilderFactory.newInstance();// parsing
		builder = factory.newDocumentBuilder();// parsing
		doc = builder.parse(filename);// genera una struttura ad albero e la mette nella variabile doc
		valueGeneratorAndPrint(doc);	// metodo creato da me per manipolare l'albero e stampare i valori
	}
	
	private void addChild(String titolo, String genere, String ora, Document doc, Element root)
	{
		Element film = doc.createElement("Film");//creo un elemento con tag Film
		Element title = doc.createElement("Titolo");//creo un elemento con tag Titolo
		Element category = doc.createElement("Genere");//creo un elemento con tag Genere
		Element time = doc.createElement("Ora");//creo un elemento con tag Ora
		
		Text textTitle = doc.createTextNode(titolo);//Creo un nodo testuale che avrà valore la variabile titolo passata come parametro
		Text textGenere = doc.createTextNode(genere);//Creo un nodo testuale che avrà valore la variabile genere passata come parametro
		Text textOra = doc.createTextNode(ora);//Creo un nodo testuale che avrà valore la variabile ora passata come parametro
		
		title.appendChild(textTitle);//aggiungo all'elemento con tag Titolo un figlio con valore testuale
		category.appendChild(textGenere);//aggiungo all'elemento con tag Genere un figlio con valore testuale
		time.appendChild(textOra);//aggiungo all'elemento con tag Ora un figlio con valore testuale
		
		//aggiungo gli elementi creati prima all'elemento con tag Film mettendo un nodo vuoto nelle posizione pari
		//film.appendChild(doc.createElement("null"));// serve perchè altrimenti dovrei cambiare il ciclo che stampa i valori
		film.appendChild(title);
		//film.appendChild(doc.createElement("null"));// serve perchè altrimenti dovrei cambiare il ciclo che stampa i valori
		film.appendChild(category);
		//film.appendChild(doc.createElement("null"));// serve perchè altrimenti dovrei cambiare il ciclo che stampa i valori
		film.appendChild(time);
		
		root.appendChild(film);// aggiungo il nuovo elemento film nell'ultima posizione della radice
	}
	
	
	private void valueGeneratorAndPrint(Document doc)
	{
		Element root = doc.getDocumentElement();//contiene l'elemento radice dell'albero
		addChild("Pinocchio","Animazione","20:30",doc,root);//metodo creato da me che aggiunge un nuovo figlio alla radice
		//prende come parametri i dati in formato stringa del film da aggiungere, l'intero albero e l'elemento radice
		
		NodeList canale = root.getElementsByTagName("Film");//collection di nodi che contiene tutti gli elementi con tag film e anche i tag figli ecc..
		
		if(canale != null && canale.getLength()>0)//controlla che la collection non sia cuota
		{
			for(int i=0; i<canale.getLength();i++)//scorre la collection
			{
				Element film = (Element) canale.item(i);//siccome anche film contiene dei tag figli lo metto in una nedelist
				Element titolo = (Element) film.getElementsByTagName("Titolo").item(0);//prendo gli elementi dispari perchè contengono il valore (visto col debugger)
				Element genere = (Element) film.getElementsByTagName("Genere").item(0);//e li metto in variabili di tipo Element perchè detta un po' male: i loro figli non hanno figli
				Element ora = (Element) film.getElementsByTagName("Ora").item(0);
				
				//stampo prendento il primo figlio che equivale al valore testuale e poi lo trasformo in stringa con .getNodeValue
				System.out.println(titolo.getFirstChild().getNodeValue()+"\n"+genere.getFirstChild().getNodeValue()+"\n"+ora.getFirstChild().getNodeValue()+"\n");
			}
		}
	}

}