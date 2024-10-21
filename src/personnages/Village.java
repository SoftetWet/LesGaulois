package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}

	public Gaulois trouverHabitant(int num�ro) {
		return villageois[num�ro];
	}

	public void afficherVillageois() {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les l�gendaires gaulois :\n");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom() + "\n");
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		On obtient une erreur car le nb maximum �tatnt 30 alors trouverhabitant(30) sors du tableau de villageois.
		Chef abraracourcix = new Chef("Abraracourcis", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Ici les instructions renvoit null car ast�rix est a la case 0 du tableau car le chef n'est pas consid�rer un villageois et donc n'est pas dans le tableau
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
