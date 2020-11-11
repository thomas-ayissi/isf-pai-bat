package hanoi;

import java.util.Stack;
/**
 * Constructeur
 * @author Didier
 *
 */
public class Piquet {
	private String nom;
	private Stack<Disque> stack = new Stack<>();

	public Piquet(String nom) {
		this.nom = nom;
	}
	
/**
 * Vide le piquet
 */
	public void viderPiquet() {
		stack.clear();
	}
/**
 * Met un disque sur le piquet
 * @param d le disque
 * @throws Exception si le disque ne respecte pas la contrainte de taille
 */
	public void push(Disque d) throws Exception {
		if (!estValide(d))
			throw new Exception("Taille non valable");
		stack.push(d);
		System.out.println("ajoute le disque: " + d + "sur le piquet: " + nom);
	}
/**
 * Retire le disque au sommet du piquet
 * @return le disque
 * @throws Exception si le piquet est vide
 */
	public Disque pop() throws Exception {
		if (stack.empty())
			throw new Exception("Le piquet est vide");
		System.out.println("retire le disque: " + stack.peek() + "du piquet: " + nom);
		return stack.pop();
	}
/**
 * Vérifie si on peut déplacer un disque  sur le piquet
 * @param d un disque
 * @return true/false
 */
	public boolean estValide(Disque d) {
		return d.getTaille() < getTailleTop();
	}
/**
 * Donne la taille du disque au sommet du piquet
 * Si le piquet est vide une valeur maximum sera fournie
 * @return
 */
	public byte getTailleTop() {
		if (stack.isEmpty())
			return Byte.MAX_VALUE;
		else
			return stack.peek().getTaille();
	}

	/**
	 * 
	 * @return nombre de disques
	 */
	public byte getNbDisques() {
		return (byte) stack.size();
	}

	@Override
	public String toString() {
		return "Piquet [nom=" + nom + "]";
	}

}
