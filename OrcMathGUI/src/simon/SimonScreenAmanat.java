package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAmanat extends ClickableScreen implements Runnable{
    TextLabel label;
    ButtonInterfaceAmanat[] button = new ButtonInterfaceAmanat[5]; ;
	ProgressInterfaceAmanat info;
	ArrayList<MoveInterfaceAmanat> store;
	public int roundNumber;
	public boolean acceptingInput;
	public int sequenceIndex;
	int lastSelectedButton;
	
	public SimonScreenAmanat(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		store.add(randomMove());
		changeText("Simons turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput= true;
		sequenceIndex =0;
	}

	private void playSequence() {
		ButtonInterfaceAmanat b = null;
		for(int i =0; i< store.size(); i++) {
			if(!(b == null)) {
				b.dim();
				b = getAButton();
				b.highlight();
				int sleeptime = (int)(1000/(roundNumber));
				//make sleep
				b.dim();
			}
		}
	}

	private void changeText(String string) {
		Thread go = new Thread();
		go.start();
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceAmanat b: button){ 
		    viewObjects.add(b); 
		}
		info = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		store = new ArrayList<MoveInterfaceAmanat>();
		//add 2 moves to start
		lastSelectedButton = -1;
		store.add(randomMove());
		store.add(randomMove());
		roundNumber = 0;
		viewObjects.add(info);
		viewObjects.add(label);		
	}

	private MoveInterfaceAmanat randomMove() {
		int bIndex = (int)(Math.random()*button.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*button.length);
	    }
	    return getMove(bIndex);
	}

	private MoveInterfaceAmanat getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	private ProgressInterfaceAmanat getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 5;
		Color[] colors = {Color.red, Color.green, Color.pink, Color.blue};
		for(int i=0; i<numberOfButtons;i++) {
			final ButtonInterfaceAmanat b = getAButton();
			button[i] = b;
			b.setColor(colors[i]);
			b.setX(150);
		    b.setY(150);
		    b.setAction(new Action(){
		    	public void act() {
		    		if(acceptingInput) {
		    			Thread blink = new Thread(new Runnable(){

		    				public void run(){
		    					b.highlight();
		    					try {
		    						Thread.sleep(800);
		    					} catch (InterruptedException e) {
		    						
		    						e.printStackTrace();
		    						}
		    					b.dim();
		    				}

		    				});
		    			blink.start();
		    			if(b == store.get(sequenceIndex).getButton()) {
		    				sequenceIndex++;
		    			}
		    			else {
		    				info.gameOver();
		    			}
		    			if(sequenceIndex == store.size()){ 
		    			    Thread nextRound = new Thread((Runnable) SimonScreenAmanat.this); 
		    			    nextRound.start(); 
		    			}
		    		}
		    	}
		    });
		}
	}

	private ButtonInterfaceAmanat getAButton() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
