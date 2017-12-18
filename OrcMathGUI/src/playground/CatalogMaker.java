package playground;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {
	static ArrayList<Toys> running;
	private String a;
	private String b;
	private String c;
	private String d;

	
	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		System.out.println(maker.getContent());
	}

	public CatalogMaker() {
		running = new ArrayList<Toys>();
		makeSuperHero();
				}
	public void makeSuperHero() {
		Scanner in = new Scanner(System.in);
		System.out.println("Create your own superhero.");
		System.out.println("Enter the first name of your superhero");
		a = in.nextLine();
		System.out.println("Enter the last name of your superhero");
		b = in.nextLine();
		System.out.println("What's his/her alias?");
		c = in.nextLine();
		System.out.println("What's his/her superpower?");
		d = in.nextLine();
		System.out.println("Would you like to add another?");
		String e=in.nextLine();

		if(e.toLowerCase().contains("yes")){
			running.add(new Toys(a,b,c,d));
			makeSuperHero();
			}
		else {	
			running.add(new Toys(a,b,c,d));
	}
		}
	
	public String getContent(){
		String data = "";
		for(Toys t:running) {
			data+= t + "\n";
		}
		return data;
	}
}
