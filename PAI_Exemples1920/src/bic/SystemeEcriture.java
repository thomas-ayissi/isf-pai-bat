package bic;

public abstract class SystemeEcriture {
	private static int nbSystemesEcriture = 0;
	private final String marque;
	private boolean etat;
	// Couleur courante
	private String couleurCourante;

	/**
	 * 
	 * @param marque
	 * @param couleur si elle est connue sinon null
	 */
	public SystemeEcriture(String couleurCourante, String marque) {
		this.marque = marque;
		this.etat = false;
		this.couleurCourante = couleurCourante;
		nbSystemesEcriture++;
	}

	public static int getNbSystemeEcriture() {
		return nbSystemesEcriture;
	}

	// Ecrire
	public void ecrire() throws Exception {
		if (!etat)
			System.out.println("Fermé");
		else if (getNiveau() <= 0)
			System.out.println("vide");
		else {// Ecrire
			diminueNiveau();
			System.out.println("Ecriture en " + couleurCourante + " niv: " + getNiveau());
		}
	}

//Getter
	public String getMarque() {
		return marque;
	}

	public boolean isEtat() {
		return etat;
	}

	public String getCouleur() {
		return couleurCourante;
	}

	/**
	 * permet de définir la couleur actuelle
	 * 
	 * @param couleur une couleur ou null
	 */
	protected void setCouleurCourante(String couleur) {
		this.couleurCourante = couleur;
	}

	public void ouvrir() {
		etat = true;
		System.out.println("Etat Ouvert");
	}

	public void fermer() {
		etat = false;
		System.out.println("Etat Fermé");
	}

	// méthode abstraite ==> à redéfinir
	public abstract int getNiveau();

	protected abstract void diminueNiveau() throws Exception;


}
