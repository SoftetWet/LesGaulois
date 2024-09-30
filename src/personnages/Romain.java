package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isforcepositive();
		equipements = new Equipement[2];
	}

	public boolean isforcepositive() {
		return force > 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		int forceInitiale = force;
		force -= forceCoup;
		assert isforcepositive();
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force - forceInitiale < 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé");
			break;
		case 1:
			if (equipements[0].toString() != null && equipements[0].toString().equals(equipement.toString())) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString());
			} else {
				ajouterEquipement(equipement);
			}
			break;
		default:
			ajouterEquipement(equipement);
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.parler("Je suis un Romain");
		minus.recevoirCoup(8);
	}
}
