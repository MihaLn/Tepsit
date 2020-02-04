import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Jparser {
	
	private String[] filename;
	
	public Jparser(String file1)//costruttore a cui viene passato il nome dei due file 
	{
		this.filename = new String[2];
		this.filename[0] = file1;
	}
	private Document parseFile(String filename) throws ParserConfigurationException, SAXException, IOException // metodo per il parsing del documento
	{
		DocumentBuilderFactory factory;// per il parsing
		DocumentBuilder builder; //per il parsing
		Document doc;// conterrà la struttura ad albero generata dal parsing
		
		factory = DocumentBuilderFactory.newInstance();// parsing
		builder = factory.newDocumentBuilder();// parsing
		doc = builder.parse(filename);// genera una struttura ad albero e la mette nella variabile doc
		
		return doc;//ritorna la struttura ad albero
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
	private void mergeFiles(Element root1, Document doc1)//aggiunge in root1 i figli di root 2 (profondità: primo figlio della radice)
	{	
		NodeList films = root1.getElementsByTagName("Film");
		
		if(films != null && films.getLength()>0)
		{
			for(int i=0; i<films.getLength(); i++)
			{
				Element e = doc1.createElement("Film");//creo un elemento con tag Film
				
				Element title = doc1.createElement("Titolo");//creo un elemento con tag Titolo
				Element category = doc1.createElement("Genere");//creo un elemento con tag Genere
				Element time = doc1.createElement("Ora");//creo un elemento con tag Ora
				
				Element ee = (Element) films.item(i);
				
				Text textTitle = doc1.createTextNode(ee.getElementsByTagName("Titolo").item(0).getFirstChild().getNodeValue());//Creo un nodo testuale che avrà valore la variabile titolo passata come parametro
				Text textGenere = doc1.createTextNode(ee.getElementsByTagName("Genere").item(0).getFirstChild().getNodeValue());//Creo un nodo testuale che avrà valore la variabile genere passata come parametro
				Text textOra = doc1.createTextNode(ee.getElementsByTagName("Ora").item(0).getFirstChild().getNodeValue());//Creo un nodo testuale che avrà valore la variabile ora passata come parametro
				
				title.appendChild(textTitle);//aggiungo all'elemento con tag Titolo un figlio con valore testuale
				category.appendChild(textGenere);//aggiungo all'elemento con tag Genere un figlio con valore testuale
				time.appendChild(textOra);//aggiungo all'elemento con tag Ora un figlio con valore testuale
				
				e.appendChild(title);
				e.appendChild(category);
				e.appendChild(time);
				
				root1.appendChild(e);// aggiungo il nuovo elemento film nell'ultima posizione della radice
			}
		}
		
	}
	public void parseAndPrint(boolean save) throws ParserConfigurationException, SAXException, IOException //INIZIA DA QUI
	{
		Document[] docs = new Document[1];
		Element[] roots = new Element[1];
		String salvataggio = "<Canale>\n";
		
		for(int i=0; i<1; i++)//genera i due alberi
		{
			docs[i] = parseFile(this.filename[i]);
			roots[i] = docs[i].getDocumentElement();
		}
		
		addChild("Pinocchio","Animazione","20:30",docs[0],roots[0]);
		
		NodeList canale = roots[0].getElementsByTagName("Film");//collection di nodi che contiene tutti gli elementi con tag film e anche i tag figli ecc..
		
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
				
				salvataggio += "<Film>\n<Titolo>\n" + titolo.getFirstChild().getNodeValue()+"\n</Titolo>\n<Genere>\n"+genere.getFirstChild().getNodeValue()+"\n</Genere>\n<Ora>\n"+ora.getFirstChild().getNodeValue()+"</Ora>\n</Film>\n";
			}
			
			salvataggio += "</Canale>";
		}
		
		if(save)
		{
			save(salvataggio);
		}
		
		
	}
	public void save(String valore) throws IOException
	{
		Saver s = new Saver("file","xml",false);
		s.saveOnFile(valore);
		s.close();
	}


}
//C:\Users\Igor\eclipse-workspace\PreparazioneVerifica\src
