package playground;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Toys extends AnimatedComponent{
	private String first;
	private String second;
	private String third;
	private String fourth;
	
	public Toys(String first, String second, String third, String fourth) {	
		super(40,40,160,225);
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth =  fourth;
	
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
		return first + "," + second + "," + third + "," + fourth;
	}

}
