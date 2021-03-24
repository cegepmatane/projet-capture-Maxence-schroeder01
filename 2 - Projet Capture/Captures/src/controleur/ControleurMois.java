package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.TemperatureDAO;
import modele.TemperatureAnnee;
import modele.TemperatureJour;
import vue.Navigateur;
import vue.VueAnnee;
import vue.VueCaptures;
import vue.VueJournee;
import vue.VueMois;

public class ControleurMois extends Controleur{

	public ControleurMois()
	{
		Logger.logMsg(Logger.INFO, "new ControleurAnnee()");
	}
	
	public void clicAccueil()
	{
		Navigateur.getInstance().afficherVue(VueCaptures.getInstance());
		
	}
	
	public void clicJournee()
	{
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
		
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("jour");
		List<TemperatureJour> TJour = TDAO.DecoderXMLJour();
		VueJournee.getInstance().afficherJour(TJour);	
	}
	
	public void clicAnnee()
	{
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
		
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("annee");
		List<TemperatureAnnee> HAnnee = TDAO.DecoderXMLAnnee();
		VueAnnee.getInstance().afficherAnnee(HAnnee);
	}
	
}
