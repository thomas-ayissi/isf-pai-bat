package medecin;

public class Test1 {
/**
 * Test avec des référents du même type que les objets associés
 * 
 * @param args
 */
	public static void main(String[] args) {
		
		Generaliste poste1; // Ne permet pas d'opérer
		poste1=new Generaliste();
		poste1.prendreTension();
		poste1.suturer();
		
		System.out.println("--------------------");
	
		Specialiste poste2; //permet d'opérer
		poste2=new Specialiste();
		poste2.prendreTension();
		poste2.suturer();
		poste2.operer();
		
	}

}
