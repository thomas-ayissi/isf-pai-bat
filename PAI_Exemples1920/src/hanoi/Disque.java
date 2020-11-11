package hanoi;

public class Disque {

	private final byte taille;

	public Disque(byte taille) {
		this.taille = taille;
	}

	public byte getTaille() {
		return taille;
	}

	@Override
	public String toString() {
		return "Disque [taille=" + taille + "]";
	}

}
