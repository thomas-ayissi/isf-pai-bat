package medecin;

/**
 * Test avec la version où opérer est défini au sein de la classe générale
 * 
 * @author Didier
 *
 */
public class Test3 {
	public static void main(String[] args) {

		Generaliste poste1; // Ne permet pas d'opérer
		poste1 = new Generaliste();
		poste1.prendreTension();
		poste1.suturer();
		if (poste1 instanceof Specialiste)
			poste1.operer();

		System.out.println("--------------------");

		Generaliste poste2; // Ne permet pas d'opérer
		poste2 = new Specialiste();
		poste2.prendreTension();
		System.out.println("Polymorphisme en action pour suturer");
		poste2.suturer();
		poste2.operer();

	}

}
