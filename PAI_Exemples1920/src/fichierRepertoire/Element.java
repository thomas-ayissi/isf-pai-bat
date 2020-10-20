package fichierRepertoire;

import java.time.LocalDateTime;

public abstract class Element {
 private String nom;
 private LocalDateTime date;
 
 public Element(String nom, LocalDateTime date) {
	this.nom = nom;
	this.date = date;
}

public abstract void supprimer();

public abstract void executer();

public String getNom() {
	return nom;
}

public LocalDateTime getDate() {
	return date;
}

protected void setDate(LocalDateTime date) {
	this.date=date;
}

@Override
public String toString() {
	return "[nom=" + nom + ", date=" + date + "]";
}

}
