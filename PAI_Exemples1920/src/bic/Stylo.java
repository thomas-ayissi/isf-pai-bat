package bic;

public class Stylo extends SystemeEcriture {

	private Cartouche cartouche = null;

	// Constructeur
	public Stylo(String marque) {
		super(null, marque);
	}

	@Override
	public int getNiveau() {
		// retourne 0 si pas de cartouche sinon le niveau de la cartouche
		return cartouche == null ? 0 : cartouche.getNiveau();
	}

	@Override
	protected void diminueNiveau() throws Exception {
		if (cartouche == null)
			throw new Exception("Pas de Cartouche");
		cartouche.diminueNiveau(1);
	}

//Retire la cartouche du stylo
	public Cartouche removeCartouche() {
		System.out.println("retire la cartouche");
		Cartouche c = cartouche;
		cartouche = null;// plus de cartouche
		setCouleurCourante(null);// plus de couleur
		return c;
	}

// Ajoute une cartouche au stylo
	public void setCartouche(Cartouche cartouche) {
		if (cartouche != null) {
			System.out.println("Chargement d'une cartouche "+cartouche);
			this.cartouche = cartouche;
			// la couleur courante devient celle de la cartouche
			setCouleurCourante(cartouche.getCouleur());
		}
	}

}
