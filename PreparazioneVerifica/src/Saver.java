import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Saver 
{
	PrintWriter saver;
	
	public Saver(String nome, String estensione, boolean sovrascrivi) throws IOException
	{
		saver = new PrintWriter(new FileWriter(nome + "." + estensione, sovrascrivi));
	}
	
	public void saveOnFile(String s) throws IOException
	{
		saver.println(s);
	}
	
	public void close()
	{
		saver.close();
	}
}
