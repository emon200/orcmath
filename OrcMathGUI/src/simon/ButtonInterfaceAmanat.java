package simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceAmanat extends Clickable{

	void setColor(Color color);

	void dim();

	void highlight();

	public void setAction(Action a);

}
