package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.TemperatureDAO;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.TemperatureJour;
import modele.TemperatureMois;
import modele.TemperatureAnnee;
import outil.Journal;
import vue.Navigateur;
import vue.VueJournee;
import vue.VueMois;
import vue.VueAnnee;

public class ControleurCaptures extends Controleur{

	public ControleurCaptures()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCaptures()");
	}
	
	public void clicJournee()
	{
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
			
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("jour");
		List<TemperatureJour> TJour = TDAO.DecoderXMLJour();
		VueJournee.getInstance().afficherJour(TJour);	
	}
	
	public void clicMois()
	{
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
		
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("mois");
		List<TemperatureMois> TMois = TDAO.DecoderXMLMois();
		VueMois.getInstance().afficherMois(TMois);	
	}
	
	public void clicAnnee()
	{
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
		
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("annee");
		List<TemperatureAnnee> TAnnee = TDAO.DecoderXMLAnnee();
		VueAnnee.getInstance().afficherAnnee(TAnnee);
	}
}
