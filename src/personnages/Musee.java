package personnages;

public class Musee {

	private Trophee[] trophee = new Trophee[200];
	private int nbTrophee;

	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee donnation = new Trophee(gaulois, equipement);
		trophee[nbTrophee] = donnation;
		nbTrophee = nbTrophee + 1;

	}

	public String extraireInstructionOcaml() {
		String declarationOcaml = " let musee = [ \n";
		for (int i = 0; i < nbTrophee; i++) {
			declarationOcaml += "'" + trophee[i].donnerNom() + "'" + ", '" + trophee[i].stringEquipement() + "';\n";
		}
		declarationOcaml += "]";
		return declarationOcaml;
	}
}