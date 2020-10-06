package testBic;

import bic.Bic;
import bic.Cartouche;
import bic.Stylo;
import bic.SystemeEcriture;

public class TestToString {

	public static void main(String[] args) throws InterruptedException {
		SystemeEcriture s1 = new Stylo("Parker");
		System.out.println("Nb SE: " + SystemeEcriture.getNbSystemeEcriture() + " " + s1);
		SystemeEcriture b1 = new Bic("Rouge", "Bic");
		System.out.println("Nb SE: " + SystemeEcriture.getNbSystemeEcriture() + " " + b1);

		if (s1 instanceof Stylo)
			((Stylo) s1).setCartouche(new Cartouche("Cyan", 16));
		System.out.println("Nb SE: " + SystemeEcriture.getNbSystemeEcriture() + " " + s1);
		// perte de s1 ==> destruction
		System.out.println("Perte de s1");
		s1 = null;
		System.gc();
		Thread.sleep(3000);
		System.out.println("Nb SE: " + SystemeEcriture.getNbSystemeEcriture());
	}

}
