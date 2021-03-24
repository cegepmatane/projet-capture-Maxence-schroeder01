package controleur;

import donnee.MeteoDAO;
import vue.Vue;
import vue.VueCaptures;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		MeteoDAO etudiantDAO = new MeteoDAO();
		VueCaptures.getInstance().afficherCaptures(etudiantDAO.listerExoplanetes());
		return VueCaptures.getInstance();
	}		
}