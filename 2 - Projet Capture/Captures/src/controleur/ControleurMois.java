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
		
		TemperatureDAO HDAO = new TemperatureDAO();
		HDAO.recupTemperature("jour");
		List<TemperatureJour> HJour = HDAO.DecoderXMLJour();
		VueJournee.getInstance().afficherJour(HJour);	
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
