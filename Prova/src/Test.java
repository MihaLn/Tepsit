import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Test{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		Scanner sc= new Scanner(System.in);
		Scanner scString= new Scanner(System.in);
		Albero film= new Albero();
		film.pars();
		film.pars();
		
		while(true) 
		{
	System.out.println("1. aggiungi nuovo film \n 2.stampa lista film  \n ");
			int scelta=sc.nextInt();
			switch(scelta)
			{
				case 1:
				{
					System.out.println("titolo :");
					String titolo=scString.nextLine();
					System.out.println("genere :");
					String genere=scString.nextLine();
					System.out.println("ora  :");
					String ora=scString.nextLine();
					film.aggiungiFilm(titolo,genere,ora);
					break;
				}
				case 2:
				{
					film.stampa();
					film.stampa();
					break;
				}
				
			}
		}
	
		
	}

}
