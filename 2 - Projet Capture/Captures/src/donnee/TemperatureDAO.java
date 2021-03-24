package donnee;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.TemperatureAnnee;
import modele.TemperatureJour;
import modele.TemperatureMois;
import outil.Journal;
import outil.JournalDesactivable;



public class TemperatureDAO {
	protected String xml = "";
	
	
	public String recupTemperature(String quelTemperature) {
		//lecture
		String URL_Temperature = "";
		switch (quelTemperature) {
        case "jour":  URL_Temperature = "http://57.161.33.187/sdd/jour";
                 break;
        case "mois":  URL_Temperature = "http://57.161.33.187/sdd/mois";
                 break;
        case "annee":  URL_Temperature = "http://57.161.33.187/sdd/annee";

    }
		
		String derniereBalise = "</temperature>";
		

		try {
			this.xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			URL urlListePensees = new URL(URL_Temperature);
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise);
			this.xml = lecteur.next() + derniereBalise;
			lecteur.close();
			this.xml = new String(this.xml.getBytes("UTF-8"), "ISO-8859-1");
			
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		//System.out.println(this.xml);
		

		return this.xml;
	}
	
	public List<TemperatureJour> DecoderXMLJour() {
		JournalDesactivable.ecrire("decoderListe()");
		List<TemperatureJour> listeTemperatureJour = new ArrayList<TemperatureJour>();

		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(this.xml)); //mettre à la place du fichier xml
			String racine = document.getDocumentElement().getNodeName();
			Journal.ecrire(3, "Racine=" + racine);
					
			NodeList listeNoeudsTemperatureJour = document.getElementsByTagName("heure");
			for(int position = 0; position < listeNoeudsTemperatureJour.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudTemperatureJour = (Element)listeNoeudsTemperatureJour.item(position);
				String id = noeudTemperatureJour.getElementsByTagName("valeur").item(0).getTextContent();
				String min = noeudTemperatureJour.getElementsByTagName("min").item(0).getTextContent();
				String moyenne = noeudTemperatureJour.getElementsByTagName("moyenne").item(0).getTextContent();
				String max = noeudTemperatureJour.getElementsByTagName("max").item(0).getTextContent();
				
				Journal.ecrire(3,"Id : " + id);
				Journal.ecrire(3,"min : " + min);
				Journal.ecrire(3,"max : " + max);
				Journal.ecrire(3,"moyenne : " + moyenne);
				TemperatureJour TemperatureJour = new TemperatureJour(id,min,max,moyenne);
				listeTemperatureJour.add(TemperatureJour);
			}
		} 
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return listeTemperatureJour;
	}
	
	
	
	public List<TemperatureAnnee> DecoderXMLAnnee() {

		JournalDesactivable.ecrire("decoderListe()");
		List<TemperatureAnnee> listeTemperatureAnnee = new ArrayList<TemperatureAnnee>();

		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(this.xml)); //mettre à la place du fichier xml
			String racine = document.getDocumentElement().getNodeName();
			Journal.ecrire(3, "Racine=" + racine);
					
			NodeList listeNoeudsTemperatureAnnee = document.getElementsByTagName("mois");
			for(int position = 0; position < listeNoeudsTemperatureAnnee.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudTemperatureAnnee = (Element)listeNoeudsTemperatureAnnee.item(position);
				String id = noeudTemperatureAnnee.getElementsByTagName("valeur").item(0).getTextContent();
				String min = noeudTemperatureAnnee.getElementsByTagName("min").item(0).getTextContent();
				String moyenne = noeudTemperatureAnnee.getElementsByTagName("moyenne").item(0).getTextContent();
				String max = noeudTemperatureAnnee.getElementsByTagName("max").item(0).getTextContent();
				
				Journal.ecrire(3,"Id : " + id);
				Journal.ecrire(3,"min : " + min);
				Journal.ecrire(3,"max : " + max);
				Journal.ecrire(3,"moyenne : " + moyenne);
				TemperatureAnnee TemperatureAnnee = new TemperatureAnnee(id,min,max,moyenne);
				listeTemperatureAnnee.add(TemperatureAnnee);
			}
		} 
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return listeTemperatureAnnee;
	}
	
	
	public List<TemperatureMois> DecoderXMLMois() {
		// Parsing
		//File fichierXML = new File("C:\\Users\\Simon\\git\\devoir-capture-2020-guillaume-esteban-simon\\src\\donnee\\EchafaudXmlMois.xml"); //echafaud fichier xml pour tester
		JournalDesactivable.ecrire("decoderListe()");
		List<TemperatureMois> listeTemperatureMois = new ArrayList<TemperatureMois>();

		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(this.xml)); //mettre à la place du fichier xml
			String racine = document.getDocumentElement().getNodeName();
			Journal.ecrire(3, "Racine=" + racine);
					
			NodeList listeNoeudsTemperatureMois = document.getElementsByTagName("jour");
			for(int position = 0; position < listeNoeudsTemperatureMois.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudTemperatureMois = (Element)listeNoeudsTemperatureMois.item(position);
				String id = noeudTemperatureMois.getElementsByTagName("valeur").item(0).getTextContent();
				String min = noeudTemperatureMois.getElementsByTagName("min").item(0).getTextContent();
				String moyenne = noeudTemperatureMois.getElementsByTagName("moyenne").item(0).getTextContent();
				String max = noeudTemperatureMois.getElementsByTagName("max").item(0).getTextContent();
				
				Journal.ecrire(3,"Id : " + id);
				Journal.ecrire(3,"min : " + min);
				Journal.ecrire(3,"max : " + max);
				Journal.ecrire(3,"moyenne : " + moyenne);
				TemperatureMois temperatureMois = new TemperatureMois(id,min,max,moyenne);
				listeTemperatureMois.add(temperatureMois);
			}
		} 
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return listeTemperatureMois;
	}
	
	


}




