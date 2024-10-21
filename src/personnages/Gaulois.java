package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " << " + texte + ">>");
	}

//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoi un grand coup dans la machoire de " + romain.getNom() );
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] recompense = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; recompense != null && i < recompense.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = recompense[i];
		}
	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Duide, je sens que ma force est " + forcePotion + " fois décuplée");
	}

	public void faireUneDonnation(Musee musee) {
		System.out.println("Le gaulois " + nom + " : << Je donne au musse tous mes trophees :");
		for (int i = 0; i < nbtrophees; i++) {
			if (trophees[i] == null) {
				continue;
			} else {
				if (i == nbtrophees - 1) {
					System.out.println("- " + trophees[i] + " >>");
				} else {
					System.out.println("- " + trophees[i]);
				}
				musee.donnerTrophee(this, trophees[i]);
			}
		}
	}

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("asterix", 80);
		Romain cesar = new Romain("cesar", 10);
		cesar.sEquiper(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.CASQUE);
		Druide paroramix = new Druide("Paroramix", 5, 10);
		paroramix.preparerPotion();
		Musee musee1 = new Musee();
		asterix.parler("Le vent se leve, il faut tenter de vivre");
		asterix.frapper(cesar);
		asterix.faireUneDonnation(musee1);

	}

}