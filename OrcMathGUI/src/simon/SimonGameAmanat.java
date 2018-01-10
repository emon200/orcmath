package simon;

import guiTeacher.GUIApplication;

public class SimonGameAmanat extends GUIApplication {
	
	public static SimonGameAmanat sample;
	public static SimonScreenAmanat simon;
	
	public SimonGameAmanat(int width, int height) {
		super(width,height);
		setVisible(true);
	}
	 
	public static void main(String[] args){
		sample = new SimonGameAmanat(1000, 1000);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	
	
	public void initScreen() {
		simon = new SimonScreenAmanat(getWidth(), getHeight());
		setScreen(simon);
	}

}