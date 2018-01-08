package simon;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAmanat extends ClickableScreen implements Runnable{
    TextLabel label;
	ButtonInterfaceAmanat[] button;
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
		// TODO Auto-generated method stub
		
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
	}
	

}
