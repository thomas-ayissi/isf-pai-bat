package bic;

public class Cartouche {
	private final String couleur;
	private Integer niveau;

	// Constructeur
	public Cartouche(String couleur, Integer niveau) {
		this.couleur = couleur;
		this.niveau = niveau;
	}

	// getter
	public Integer getNiveau() {
		return niveau;
	}

	public String getCouleur() {
		return couleur;
	}

	// permet de diminuer le niveau
	public void diminueNiveau(Integer qt) throws Exception {
		if (niveau < qt)
			throw new Exception("Pas assez d'encre");
		this.niveau = niveau - qt;
	}

	@Override
	public String toString() {

		return " coul: " + couleur + " Niv: " + niveau;
	}
	//appelé par le garbage collector gc
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Destruction de la cartouche coul:"+couleur);
	}
	
	

}
