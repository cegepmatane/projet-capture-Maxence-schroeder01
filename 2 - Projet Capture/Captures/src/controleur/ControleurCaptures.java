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
			
		TemperatureDAO HDAO = new TemperatureDAO();
		HDAO.recupTemperature("jour");
		List<TemperatureJour> HJour = HDAO.DecoderXMLJour();
		VueJournee.getInstance().afficherJour(HJour);	
	}
	
	public void clicMois()
	{
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
		
		TemperatureDAO HDAO = new TemperatureDAO();
		HDAO.recupTemperature("mois");
		List<TemperatureMois> HMois = HDAO.DecoderXMLMois();
		VueMois.getInstance().afficherMois(HMois);	
	}
	
	public void clicAnnee()
	{
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
		
		TemperatureDAO HDAO = new TemperatureDAO();
		HDAO.recupTemperature("annee");
		List<TemperatureAnnee> HAnnee = HDAO.DecoderXMLAnnee();
		VueAnnee.getInstance().afficherAnnee(HAnnee);
	}
}
