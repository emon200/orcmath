package simon;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAmanat extends ClickableScreen implements Runnable {

	public ArrayList<MoveInterfaceAmanat> array;
	public ProgressInterfaceAmanat progress;


	public int roundNum;
	public int sequenceLength;
	public int sequenceWin;
	public boolean input;


	public ButtonInterfaceAmanat[] allButtons;

	public int oldButton;
	Color[] colors;

	public TextLabel displayRound;
	public SimonScreenAmanat(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}


	public void run() {
		input = false;
		sequenceWin++;
		roundNum++;
		array.add(getRandomMove());
		progress.setNum(roundNum, array.size());
		displayRound.setText("Simon's Turn");
		simonInput();
		displayRound.setText("Your Turn");
		sequenceLength=0;
		input = true;

	}

	public void simonInput(){
		ButtonInterfaceAmanat b;
		for(int i = 0; i < array.size(); i++) {
			b = array.get(i).getTheButton();
			b.highlight();
			try {
				Thread.sleep((int)(1000*roundNum));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			b.dim();
		}

	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		array = new ArrayList<MoveInterfaceAmanat>();
		oldButton = -1;
		allButtons = new ButtonInterfaceAmanat[5];
		colors = new Color[5];
		colors[0] = Color.BLACK;
		colors[1] = Color.PINK;
		colors[2] = Color.ORANGE;
		colors[3] = Color.MAGENTA;
		colors[4] = Color.CYAN;

		roundNum = 0;
		sequenceLength = 0;
		sequenceWin= 3;
		input = true;


		displayRound = new TextLabel(200,200,400,200,"How's Your Memory?");
		viewObjects.add(displayRound);

		for (int i = 0;i <allButtons.length;i++) {

			final ButtonInterfaceAmanat button = getButton(i*150+150,350,150,100);
			allButtons[i] = button;
			button.setColor(colors[i]);
			button.setAction(new Action() {

				@Override
				public void act() {
					if (input) {
						Thread light  = new Thread(new Runnable() {

							@Override
							public void run() {
								button.highlight();
								input = false;
								try {
									Thread.sleep(800);
								}catch(InterruptedException e ) {
									e.printStackTrace();
								}
								input = true;
								button.dim();
							}
						});
						light.start();
						if(button == array.get(sequenceLength).getTheButton()) {
							sequenceLength++;
						} else{
							progress.lose();
							input = false;
						}
						if(sequenceLength == array.size()){
							Thread nextRound = new Thread(SimonScreenAmanat.this); 
							nextRound.start(); 
						}
					}

				}
			});
		}

		progress = getProgressBar();
		progress.setNum(roundNum,sequenceWin);
		array.add(getRandomMove());
		array.add(getRandomMove());

		for (int i = 0;i <allButtons.length;i++) {
			System.out.println(allButtons[i]);
			viewObjects.add(allButtons[i]);
		}
		viewObjects.add(progress);
	}

	private MoveInterfaceAmanat getRandomMove() {
		int randomInt = (int)(Math.random()*allButtons.length);
		while (randomInt == oldButton) {
			randomInt = (int)(Math.random()*allButtons.length);
		}
		return new MoveAmanat(allButtons[randomInt]);
	}


	private ProgressInterfaceAmanat getProgressBar() {
		return new ProgressAmanat();
	}




	private ButtonInterfaceAmanat getButton(int x,int y,int w, int h) {
		ButtonAmanat button = new ButtonAmanat(x,y,w,h,"",null);
		return button;
	}



}