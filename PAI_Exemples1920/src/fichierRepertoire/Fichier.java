package fichierRepertoire;

import java.time.LocalDateTime;

public class Fichier extends Element {

	private String contenu;

	public Fichier(String nom, LocalDateTime date, String contenu) {
		super(nom, date);
		this.contenu = contenu;
	}

	@Override
	public void supprimer() {
		System.out.println("Suppression du " + toString());
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
		super.setDate(LocalDateTime.now());
	}

	

	@Override
	public void executer() {
		System.out.println("Affiche "+ contenu);
		
	}

	@Override
	public String toString() {
		return "Fichier " + super.toString();
	}
}
