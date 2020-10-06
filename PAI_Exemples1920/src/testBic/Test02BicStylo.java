package testBic;

import bic.Bic;
import bic.Cartouche;
import bic.Stylo;
import bic.SystemeEcriture;

public class Test02BicStylo {
	
	public static void main(String[] args) {
		SystemeEcriture se1= new Stylo("Parker");
		SystemeEcriture se2= new Bic("Rose","Isfce");
		Cartouche tmp;
		Cartouche cr=new Cartouche("Rouge", 15);
		Cartouche cn=new Cartouche("Noir", 10);
		try {//avec le styl0
			System.out.println("------------------Avec un stylo");
			se1.ecrire();
			se1.ouvrir();
			se1.ecrire();
			if ( se1 instanceof Stylo)
				((Stylo)se1).setCartouche(cr);
			se1.ecrire();
			if ( se1 instanceof Stylo)
				tmp=((Stylo)se1).removeCartouche();
			se1.ecrire();
			if ( se1 instanceof Stylo)
				((Stylo)se1).setCartouche(cn);
			se1.ecrire();
			//Même code avec Bic
			System.out.println("----------------Idem avec un bic");
			se2.ecrire();
			se2.ouvrir();
			se2.ecrire();
			if ( se2 instanceof Stylo)
				((Stylo)se2).setCartouche(cr);
			se2.ecrire();
			if ( se2 instanceof Stylo)
				tmp=((Stylo)se2).removeCartouche();
			se2.ecrire();
			if ( se2 instanceof Stylo)
				((Stylo)se2).setCartouche(cn);
			se2.ecrire();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
