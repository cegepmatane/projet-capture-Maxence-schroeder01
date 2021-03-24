package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.TemperatureDAO;
import modele.TemperatureAnnee;
import modele.TemperatureMois;
import vue.Navigateur;
import vue.VueAnnee;
import vue.VueCaptures;
import vue.VueMois;

public class ControleurJournee extends Controleur{

	public ControleurJournee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJournee()");
	}
	
	public void clicAccueil()
	{
		Navigateur.getInstance().afficherVue(VueCaptures.getInstance());
		
	}
	
	public void clicMois()
	{
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
		
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("mois");
		List<TemperatureMois> HMois = TDAO.DecoderXMLMois();
		VueMois.getInstance().afficherMois(HMois);
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
