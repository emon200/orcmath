package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import com.itextpdf.text.Font;

import guiTeacher.components.Component;

public class ProgressAmanat extends Component implements ProgressInterfaceAmanat {
	private int roundNum;
	private int sequenceNum;
	private boolean loss;


	public ProgressAmanat() {
		super(250,50,600,400);
	}

	@Override
	public void lose() {
		loss = true;
		update();
	} 

	@Override 
	public void update(Graphics2D g) {
		clear();
		if(loss) {
			g.setColor(Color.black);
			g.drawString("Round: "+roundNum,200,200);
			g.drawString("Sequence: "+sequenceNum,220,250);
			g.drawString("GAME OVER!",240,300);
		}else {
			g.setColor(Color.black);
			g.drawString("Round: "+roundNum,200,200);
			g.drawString("Current Sequence Length: "+sequenceNum,220,250);
		}

	}
	@Override
	public void setNum(int round,int seq) {
		roundNum = round;
		sequenceNum = seq;
		update();

	}
}