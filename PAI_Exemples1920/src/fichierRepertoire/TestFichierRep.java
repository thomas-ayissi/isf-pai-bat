package fichierRepertoire;

import java.time.LocalDateTime;

public class TestFichierRep {

	public static void main(String[] args) {
		Element f1 = new Fichier("F1", LocalDateTime.now(), "blabla F1");
		System.out.println(f1);
		Element f2 = new Fichier("F2", LocalDateTime.now(), "blabla F2");
		System.out.println(f2);
		Repertoire r1 = new Repertoire("R1", LocalDateTime.now());
		System.out.println(r1);
		Repertoire r2 = new Repertoire("R2", LocalDateTime.now());
		System.out.println(r2);
		Element rc1 = new Raccourci("Rc1", LocalDateTime.now(), f2);
		System.out.println(rc1);

		r1.ajoutElem(f1);
		r1.ajoutElem(r2);
		r2.ajoutElem(f2);
		r2.ajoutElem(rc1);
		System.out.println("==== Exécute Répertoire R1    =============");
		r1.executer();
		System.out.println("==== Exécute Répertoire R2    =============");
		r2.executer();
		System.out.println("==== Execute le fichier F1    =============");
		f1.executer();
		System.out.println("==== Execute le raccourci rc1 =============");
		rc1.executer();
		System.out.println("===== Supprime le répertoire R1 (tout) ====");
		r1.supprimer();
	}

}
