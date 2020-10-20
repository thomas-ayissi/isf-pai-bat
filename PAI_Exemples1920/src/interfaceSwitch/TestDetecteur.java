package interfaceSwitch;

public class TestDetecteur {
	
	public static void main(String[] args) {
     Lampe lampe= new Lampe();
     Detecteur detecteur= new Detecteur();
	 try {
		System.out.println("detecte sans Lampe");
		detecteur.detect();
		
		System.out.println("assigne une lampe");
		detecteur.setElem(lampe);
		System.out.println("detection1 avec Lampe");
		detecteur.detect();
		System.out.println("detection2 avec Lampe");
		detecteur.detect();
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}	
	}
}
