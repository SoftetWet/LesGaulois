package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois Asterix = new Gaulois("Asterix", 8);
		Romain Minus = new Romain("Minus",6);
		Asterix.parler("Bonjour a tous");
		Minus.parler("UN GAU... UN GAUGAU...");
		Asterix.frapper(Minus);
		Asterix.frapper(Minus);
		Asterix.frapper(Minus);
	}

}
