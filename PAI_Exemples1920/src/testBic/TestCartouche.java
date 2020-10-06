package testBic;

import bic.Cartouche;

public class TestCartouche {

	public static void main(String[] args) {
		Cartouche c1 = new Cartouche("Rouge", 20);
		System.out.println(c1.getCouleur());
		
		try {
			c1.diminueNiveau(5);
			System.out.println(c1.getNiveau());
			c1.diminueNiveau(13);
			System.out.println(c1.getNiveau());
			c1.diminueNiveau(5);
			System.out.println(c1.getNiveau());
		} catch (Exception e) {
			System.err.println(e.getMessage()+" niv: "+c1.getNiveau());
		}
		
	}

}
