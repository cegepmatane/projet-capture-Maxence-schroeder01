
import architecture.Fenetre;
import donnee.MeteoDAO;

public class App {

	public static void main(String[] parametres) {
		
		MeteoDAO etudiantDAO = new MeteoDAO();
		etudiantDAO.listerExoplanetes();
		
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
