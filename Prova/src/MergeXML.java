import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class MergeXML {
	
	private Document XMLMERGE;
	private static Element root1,root2,root3;
	
	public void MergeFile(Document XML1,Document XML2)
	{
		root1 = XML1.getDocumentElement();
		root2 = XML2.getDocumentElement();
		root3 = XMLMERGE.getDocumentElement();
		NodeList films1 = root1.getElementsByTagName("film");
		NodeList films2 = root2.getElementsByTagName("film");
		
	if (films1 !=null && films1.getLength()>0 && films2 !=null && films2.getLength()>0)
	{
		for(int i=0;i<films1.getLength();i++)
		{
			Element film = (Element)films1.item(i);
			Node titotlo =  (Node) XMLMERGE.importNode(film.getElementsByTagName("titolo").item(0),true);
			Node genere =  (Node) XMLMERGE.importNode(film.getElementsByTagName("genere").item(0),true);
			Node ore =  (Node) XMLMERGE.importNode(film.getElementsByTagName("ore").item(0),true);
			Element FilmMerge = XMLMERGE.createElement(film);
			FilmMerge.appendChild(titolo);
			FilmMerge.appendChild(genere);
			FilmMerge.appendChild(ora);
			root3.appendChild(FilmMerge);
		}
		for(int i=0;i<films2.getLength();i++)
		{
			Element film = (Element)films2.item(i);
			Node titolo = (Node) XMLMERGE.importNode(film.getElementsByTagName("titolo").item(0),true);
			Node genere = (Node) XMLMERGE.importNode(film.getElementsByTagName("genere").item(0),true);
			Node ora = (Node) XMLMERGE.importNode(film.getElementsByTagName("ore").item(0),true);
			Element FilmMerge = XMLMERGE.createElement("film");
			FilmMerge.appendChild(titolo);
			FilmMerge.appendChild(genere);
			FilmMerge.appendChild(ora);
			root3.appendChild(FilmMerge);
			
		}
	}
	}

}
