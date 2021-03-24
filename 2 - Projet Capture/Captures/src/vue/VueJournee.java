package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.TemperatureJour;
import outil.Journal;
import controleur.ControleurJournee;

public class VueJournee extends Vue {

	protected static VueJournee instance = null; 
	public static VueJournee getInstance() {if(null==instance)instance = new VueJournee();return VueJournee.instance;}; 

	protected ControleurJournee controleur = null;
	public ControleurJournee getControleur() {return this.controleur;}
	
	private VueJournee() 
	{
		super("journee.fxml"); 
		super.controleur = this.controleur = new ControleurJournee();
		Logger.logMsg(Logger.INFO, "new VueJournee()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		Button actionAccueil = (Button)lookup("#menu-accueil");
		
		actionAccueil.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicAccueil();
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

	public void afficherJour(List<TemperatureJour> LHJ)
	{		
		Journal.ecrire(3, "Etape void afficher");
		VBox vueHJourM = (VBox)lookup("#vb-heure");
		VBox vueHJourMin = (VBox)lookup("#vb-min");
		VBox vueHJourMax = (VBox)lookup("#vb-max");
		VBox vueHJourMoy = (VBox)lookup("#vb-moy");
		vueHJourMoy.getChildren().clear();
		vueHJourM.getChildren().clear();
		vueHJourMin.getChildren().clear();
		vueHJourMax.getChildren().clear();
		for(TemperatureJour hj: LHJ) {

			Logger.logMsg(Logger.INFO, "TemperatureJour : " + hj.getId());
			System.out.println(hj.getId());
			
			Journal.ecrire(3, "Etape Temperature for 2");
			
			
			vueHJourM.getChildren().add(new Label (Integer.toString(hj.getId())));
			vueHJourMin.getChildren().add(new Label (Integer.toString(hj.getMin())));
			vueHJourMax.getChildren().add(new Label (Integer.toString(hj.getMax())));
			vueHJourMoy.getChildren().add(new Label (Integer.toString(hj.getMoy())));
		}
	}
}
