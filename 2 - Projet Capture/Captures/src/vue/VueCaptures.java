package vue;
import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCaptures;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueCaptures extends Vue {

	protected ControleurCaptures controleur;
	protected static VueCaptures instance = null; 
	public static VueCaptures getInstance() {if(null==instance)instance = new VueCaptures();return VueCaptures.instance;}; 
	
	private VueCaptures() 
	{
		super("captures.fxml"); 
		super.controleur = this.controleur = new ControleurCaptures();
		Logger.logMsg(Logger.INFO, "new VueCaptures()");
	}
		
	public void activerControles()
	{
		super.activerControles();

		Button actionJournee = (Button)lookup("#menu-journee");
		
		actionJournee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicJournee();
			}
		});

		Button actionMois = (Button)lookup("#menu-mois");
		
		actionMois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicMois();
			}
		});

		Button actionAnnee = (Button)lookup("#menu-annee");
		
		actionAnnee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicAnnee();
			}
		});

	}
}
