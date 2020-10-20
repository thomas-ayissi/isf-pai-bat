package fichierRepertoire;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Repertoire extends Element {
	// Un dictionnaire nomElement ==> un élément
	private Map<String, Element> elements = new HashMap<>();

	public Repertoire(String nom, LocalDateTime date) {
		super(nom, date);
	}

	public void ajoutElem(Element elem) {
		// Rajoute l'élément s'il n'existe pas (le nom) dans la map
		if (!elements.containsKey(elem.getNom()))
			elements.put(elem.getNom(), elem);
	}
/**
 * Permet de supprimer un élément d'un répertoire
 * @param elem
 */
	public void supprimerElem(Element elem) {
		elements.remove(elem.getNom());
	}
/**
 * Suppression du répertoire et de son contenu
 */
	@Override
	public void supprimer() {
		//supprime tous les éléments du répertoire
		elements.forEach((k, e) -> e.supprimer());
		elements.clear();// vide la map
		// suppression du répertoire
		System.out.println("Suppression du " + toString());
	}

	@Override
	public void executer() {
		System.out.println("Contenu du "+toString());
		elements.forEach((k, e) -> System.out.println(" " + e.toString()));
		System.out.println("--------------------");
	}

	@Override
	public String toString() {
		return "Repertoire " + super.toString();
	}

}
