package personnages;

public class Gaulois {
	private String nom;
	private int Force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		Force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", Force=" + Force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois Bernede = new Gaulois("Bernede", 6);
		Bernede.parler("Je suis un Gaulois");
		System.out.println(Bernede);
	}
}
