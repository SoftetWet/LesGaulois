package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert isforcepositive(force);
		this.nom = nom;
		this.force = force;
	}
	
	public boolean isforcepositive(int force){
		if (force > 0) {
			return true;
		}
		System.out.println("La Force du Romain ne peut être négative");
		return false;
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
		assert isforcepositive(force);
		int force2 = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force-force2 < 0;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("Je suis un Romain");
		minus.recevoirCoup(8);
	}
}
