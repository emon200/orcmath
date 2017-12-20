package playground;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiPlayer.Book;
import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {
	private TextField descriptionField;
	private TextArea text;
	private Button button;
	private FileOpenButton openButton;
	private CatalogMaker Book;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Book = new CatalogMaker();
		descriptionField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		descriptionField = new TextField(40,40,200,30,"Text goes here","Description");
		viewObjects.add(descriptionField);
		descriptionField = new TextField(40,100,200,30,"Text goes here","Description");
		viewObjects.add(descriptionField);
		descriptionField = new TextField(40,160,200,30,"Text goes here","Description");
		viewObjects.add(descriptionField);
		text = new TextArea(40,200 ,200 ,30 , "Enter Text...");
		viewObjects.add(text);
		button = new Button(0, 300, 100, 40, "delete", new Action() {

			@Override
			public void act() {
				deleteClicked();
			}
		});
		viewObjects.add(button);
		button = new Button(100, 300, 100, 40, "save", new Action() {

			@Override
			public void act() {
				saveClicked();
			}
		});
		viewObjects.add(button);
		button = new Button(200, 300, 100, 40, "add", new Action() {

			@Override
			public void act() {
				addClicked();
			}
		});
		viewObjects.add(button);
		openButton = new FileOpenButton(300, 300, 100, 40, null, this);
		viewObjects.add(openButton);
	}


	protected void saveClicked() {
		text.setText("Your text has been saved");
		
	}

	protected void deleteClicked() {
		text.setText("");
		
	}

	protected void addClicked() {
		Book b = new Book(descriptionField.getText(),descriptionField.getText(),Integer.parseInt(descriptionField.getText()));
		text.setText("It has been added" + b);
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
