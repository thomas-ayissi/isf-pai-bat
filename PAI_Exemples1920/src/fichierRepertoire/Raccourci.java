package fichierRepertoire;

import java.time.LocalDateTime;

public class Raccourci extends Element {
	private Element lien;

	public Raccourci(String nom, LocalDateTime date, Element lien) {
		super(nom, date);
		this.lien = lien;
	}

	@Override
	public void supprimer() {
		System.out.println("Suppression du " + this.toString());

	}

	@Override
	public void executer() {
		System.out.print("Raccourci Affiche: ");
		lien.executer();

	}

	@Override
	public String toString() {
		return "Raccourci " + super.toString();
	}
}
