package playground;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Toys extends AnimatedComponent{
	private int first = 0;
	private int second = 0;
	private int third = 0;
	private String why;
	private String how;
	
	public Toys(int first, int second, int third, String why, String how) {	
		super(40,40,160,225);
		this.first = first;
		this.second = second;
		this.third = third;
		this.why = why;
		this.how=how;
	
		addSequence("resources/running.png", 150, 9, 67, 159, 223, 9);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}
	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.green);
		super.update(g);
	}
	
	public String toString() {
		return first + "," + second + "," + third;
	}

}
