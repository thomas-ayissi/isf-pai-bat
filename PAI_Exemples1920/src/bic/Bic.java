package bic;

/**
 * 
 * @author Didier
 * @version 3 héritage
 */
public class Bic extends SystemeEcriture {
	private int niveau;

	public Bic(String couleur, String marque) {
		// Appel le constructeur parent (Systeme Ecriture)
		super(couleur, marque);
		this.niveau = 10;
		//System.out.println("Création d'un Bic. Nb Systèmes d'écriture: " + getNbSystemeEcriture());
	}

	@Override
	public int getNiveau() {
		return niveau;
	}

	@Override
	protected void diminueNiveau() throws Exception {
		if (niveau > 0)
			niveau--;
		else
			throw new Exception("Plus d'encre");
	}

	@Override
	public String toString() {
		
		return "Création d'un Bic Niv: "+niveau+" "+super.toString();
	}
	
	

}
