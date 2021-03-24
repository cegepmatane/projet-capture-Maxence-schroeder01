package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.TemperatureDAO;
import modele.TemperatureJour;
import modele.TemperatureMois;
import outil.Journal;
import vue.Navigateur;
import vue.VueCaptures;
import vue.VueJournee;
import vue.VueMois;

public class ControleurAnnee extends Controleur{

	public ControleurAnnee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurAnnee()");
		Journal.ecrire(3, "Etape c");
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
		List<TemperatureJour> HJour = TDAO.DecoderXMLJour();
		VueJournee.getInstance().afficherJour(HJour);	
	}
	
	public void clicMois()
	{
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
		
		TemperatureDAO TDAO = new TemperatureDAO();
		TDAO.recupTemperature("mois");
		List<TemperatureMois> TMois = TDAO.DecoderXMLMois();
		VueMois.getInstance().afficherMois(TMois);
	}	
}
