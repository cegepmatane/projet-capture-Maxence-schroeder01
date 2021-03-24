package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurCaptures;

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
		
		/*
		Button actionCalculatrice = (Button) lookup("#action-calculatrice");
		actionCalculatrice.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Calculatrice activ��");
            	controleur.notifierEvenement(ActionNavigation.CALCULATRICE);
            }
        });
		*/

	}
}
