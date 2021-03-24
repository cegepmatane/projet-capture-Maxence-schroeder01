package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.ActionCellule;
import vue.Vue;
import controleur.ControleurCaptures;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.meteo;

public class VueCaptures extends Vue{
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
		
	}
	
	public void afficherCaptures(List<meteo> etudiants)
	{	
		// Recuperation de l'objet dans lequel afficher
		TableView tableau = (TableView)lookup("#liste-exoplanetes");
		
		// Association des champs de l'objet avec les colonnes du tableau		
		TableColumn colonneNom = (TableColumn) tableau.getColumns().get(0);
		TableColumn colonneEtoile = (TableColumn) tableau.getColumns().get(1);
		TableColumn colonneMasse = (TableColumn) tableau.getColumns().get(2);
		TableColumn colonneRayon = (TableColumn) tableau.getColumns().get(3);
		TableColumn colonneFlux = (TableColumn) tableau.getColumns().get(4);
		TableColumn colonneTemperature = (TableColumn) tableau.getColumns().get(5);
		TableColumn colonnePeriode = (TableColumn) tableau.getColumns().get(6);
		TableColumn colonneDistance = (TableColumn) tableau.getColumns().get(7);
		
		colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colonneEtoile.setCellValueFactory(new PropertyValueFactory<>("etoile"));
		colonneMasse.setCellValueFactory(new PropertyValueFactory<>("masse"));
		colonneRayon.setCellValueFactory(new PropertyValueFactory<>("rayon"));
		colonneFlux.setCellValueFactory(new PropertyValueFactory<>("flux"));
		colonneTemperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
		colonnePeriode.setCellValueFactory(new PropertyValueFactory<>("periode"));
		colonneDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
		
		// Ajout des donnees
		for(meteo etudiant : etudiants)
		{
			System.out.println(etudiant.getjour());
			tableau.getItems().add(etudiant);
		}
	}

}