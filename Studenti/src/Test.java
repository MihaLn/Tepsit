import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Test {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		Scanner sc= new Scanner(System.in);
		nodiAlberoXML studenti= new nodiAlberoXML();
		studenti.pars();
		while(true) 
		{
			studenti.stampa();
			String nome=sc.nextLine();
			String cognome=sc.nextLine();
			studenti.aggiuniStudente(nome, cognome);
			studenti.aggiungiVoti("manuel", "eteri", "tepsit", "8,5");
		}
		
	}

}
