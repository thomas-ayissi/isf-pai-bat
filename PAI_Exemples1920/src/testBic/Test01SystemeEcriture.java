package testBic;

import bic.Bic;
import bic.SystemeEcriture;

/**
 * 
 * @author Didier
 * @version 01
 */
public class Test01SystemeEcriture {

	public static void main(String[] args) {
		SystemeEcriture bic1 = new Bic("Bleu", "Bic");
		bic1.ecrire();
		bic1.ouvrir();
		bic1.ecrire();
		
		
		
		System.out.println("----------------------------");
		SystemeEcriture bic2 = new Bic("Rouge", "Bic");
		bic2.ecrire();
		bic2.ouvrir();
		bic2.ecrire();
	}

}
