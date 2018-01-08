package simon;

import guiPlayer.CatalogMakerGUI;
import guiTeacher.GUIApplication;

public class SimonGameAmanat extends GUIApplication{

	public SimonGameAmanat(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		CatalogMakerGUI catalog = new CatalogMakerGUI(800, 550);
		Thread runner = new Thread(catalog);
		runner.start();
	}

	@Override
	public void initScreen() {
		SimonScreenAmanat screen = new SimonScreenAmanat(getWidth(), getHeight());
		setScreen(screen);
		
	}

}
