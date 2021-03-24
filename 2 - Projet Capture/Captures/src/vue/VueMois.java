package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import outil.Journal;
import controleur.ControleurMois;
import modele.TemperatureMois;

public class VueMois extends Vue {

	protected static VueMois instance = null; 
	public static VueMois getInstance() {if(null==instance)instance = new VueMois();return VueMois.instance;}; 

	protected ControleurMois controleur = null;
	public ControleurMois getControleur() {return this.controleur;}
	
	private VueMois() 
	{
		super("mois.fxml"); 
		super.controleur = this.controleur = new ControleurMois();
		Logger.logMsg(Logger.INFO, "new VueAnnee()");
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
		
		Button actionJournee = (Button)lookup("#menu-journee");
		
		actionJournee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicJournee();
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

	public void afficherMois(List<TemperatureMois> LHM)
	{		
		Journal.ecrire(3, "Etape void afficher");
		VBox vueVM = (VBox)lookup("#vb-jour");
		VBox vueVMin = (VBox)lookup("#vb-min");
		VBox vueVMax = (VBox)lookup("#vb-max");
		VBox vueVMoy = (VBox)lookup("#vb-moy");
		vueVM.getChildren().clear();
		vueVMin.getChildren().clear();
		vueVMax.getChildren().clear();
		vueVMoy.getChildren().clear();
		for(TemperatureMois hm: LHM) {

			Logger.logMsg(Logger.INFO, "TemperatureMois : " + hm.getId());
			System.out.println(hm.getId());
			
			
			vueVM.getChildren().add(new Label (Integer.toString(hm.getId())));
			vueVMin.getChildren().add(new Label (Integer.toString(hm.getMin())));
			vueVMax.getChildren().add(new Label (Integer.toString(hm.getMax())));
			vueVMoy.getChildren().add(new Label (Integer.toString(hm.getMoy())));
		}
	}
}
