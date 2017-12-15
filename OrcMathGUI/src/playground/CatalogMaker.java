package playground;

import java.util.ArrayList;

public class CatalogMaker {
	static ArrayList<Toys> running;
	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		System.out.println(maker.getContent());
	}

	public CatalogMaker() {
		running = new ArrayList<Toys>();

		running.add(new Toys(1,1,1,"sprinter","jogger"));
		running.add(new Toys(2,2,2,"walker","marathon"));
		running.add(new Toys(3,3,3,"limping","idling"));
		running.add(new Toys(4,4,4,"sitting","standing"));
	}
	public String getContent(){
		String data = "";
		for(Toys t:running) {
			data+= t + "\n";
		}
		return data;
	}
}
