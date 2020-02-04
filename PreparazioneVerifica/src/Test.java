import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
public class Test{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserire il percorso dei file xml");
		
		Jparser j=new Jparser(sc.nextLine());//C:\Users\Igor\eclipse-workspace\PreparazioneVerifica\src\Tv.xml
		
		try {
			j.parseAndPrint(true);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
	}

}
