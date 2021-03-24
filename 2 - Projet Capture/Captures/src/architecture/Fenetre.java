package architecture;

import javafx.stage.Stage;
//import javafx.stage.StageStyle;
import vue.VueCaptures;

public class Fenetre extends Navigateur {

	@Override
	public void start(Stage stade) throws Exception {
		//stade.initStyle(StageStyle.UNDECORATED);
		stade.setScene(VueCaptures.getInstance()); // une vue est appliqu??e ?? la fen??tre
		stade.show();
		this.stade = stade;
	}
}
