package medecin;

public class Test2 {
	/**
	 * Test avec des référents du type "Généraliste" et des objets Généraliste et
	 * Spécialiste
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Generaliste poste1; // Ne permet pas d'opérer
		poste1 = new Generaliste();
		poste1.prendreTension();
		poste1.suturer();
		// Ici je ne peux pas faire un type cast ==> BOOUM
		if (poste1 instanceof Specialiste)
			((Specialiste) poste1).operer();
		else
			System.out.println("Je ne suis pas un spécialiste!!!");

		System.out.println("--------------------");

		Generaliste poste2; // Ne permet pas d'opérer
		poste2 = new Specialiste();
		poste2.prendreTension();
		System.out.println("Polymorphisme en action pour suturer");
		poste2.suturer();
		// Sachant que l'objet est un spécialiste
		// je peux faire un typecasting mais je dois etre certain
		// que c'est un spécialiste sinon BOOUM
		System.out.println("Grace au type casting");
		if (poste2 instanceof Specialiste)
			((Specialiste) poste2).operer();
		else
			System.out.println("Je ne suis pas un spécialiste!!!");

	}

}
