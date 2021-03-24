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
}
