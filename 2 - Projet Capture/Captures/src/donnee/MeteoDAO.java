package donnee;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import modele.meteo;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MeteoDAO {
	public String SQL_LISTER_ETUDIANTS = "SELECT * from public";	

	public List<meteo> listerExoplanetes()
	{
		List<meteo> listeExoplanetes =  new ArrayList<meteo>();			
		Connection connection = BaseDeDonnees.getInstance().getConnection();

		String URL_LISTE_ETUDIANTS = "http://51.161.33.187/sdd/liste-meteo.php";

		String xml = "";
		try {
			URL url = new URL(URL_LISTE_ETUDIANTS);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			xml = lecteur.next();
			lecteur.close();

			xml = new String(xml.getBytes("UTF-8"), "ISO-8859-1");
			//System.out.println(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			NodeList noeudsEtudiants = document.getElementsByTagName("etudiant");
			for(int position = 0; position < noeudsEtudiants.getLength(); position++)
			{	
				Element noeudEtudiant = (Element)noeudsEtudiants.item(position);
				String id = noeudEtudiant.getElementsByTagName("id").item(0).getTextContent();
				String jour = noeudEtudiant.getElementsByTagName("nom").item(0).getTextContent();
				String mois = noeudEtudiant.getElementsByTagName("etoile").item(0).getTextContent();
				String annee = noeudEtudiant.getElementsByTagName("masse").item(0).getTextContent();
				String temps = noeudEtudiant.getElementsByTagName("rayon").item(0).getTextContent();
				String vent = noeudEtudiant.getElementsByTagName("flux").item(0).getTextContent();
				String temperature = noeudEtudiant.getElementsByTagName("temperature").item(0).getTextContent();
				String humidite = noeudEtudiant.getElementsByTagName("periode").item(0).getTextContent();
	
				System.out.println(id + " - " + temps);
				
				meteo exoplanete = new meteo ();
				exoplanete.setId(Integer.parseInt(id));
				exoplanete.setjour(jour);
				exoplanete.setmois(mois);
				exoplanete.setannee(annee);
				exoplanete.settemps(temps);
				exoplanete.setvent(vent);
				exoplanete.setTemperature(temperature);
				exoplanete.sethumidite(humidite);
				
				listeExoplanetes.add(exoplanete);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return listeExoplanetes;
		}
	}