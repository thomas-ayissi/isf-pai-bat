package hanoi;

import java.util.Hashtable;
import java.util.Map;

public class Joueur {
	private static Map<String,Joueur> joueurs=new Hashtable<>();
	
	private final String alias;
	private Map<Byte, Score> scores = new Hashtable<>();

	/**
	 * @param alias
	 */
	public Joueur(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	/**
	 * Renvoie le score actuel du joueur pour n disques et null s'il n'a pas encore
	 * de score
	 * 
	 * @param n
	 * @return
	 */
	public Score getScore(Byte n) {
		return scores.get(n);
	}

	/**
	 * Verifie si le nouveau score est meilleur et si tel est le cas, on le mémorise
	 * 
	 * @param newScore
	 * @return true si le score est meilleur que l'ancien
	 */
	public boolean setNewScore(Score newScore) {
		if (newScore == null)
			return false;
		// retrouve le score actuel du joueur
		Score scoreAct = scores.get(newScore.getNbDisques());
		//vérifie si le nouveau score est meilleur que l'ancien
		if (scoreAct == null || (newScore.isBestThan(scoreAct))) {
			scores.put(newScore.getNbDisques(), newScore);
			return true;
		}
		return false;
	}
/**
 * Permet de retrouver les joueurs
 * @return
 */
	public static Map<String, Joueur> getJoueurs() {
		return joueurs;
	}

@Override
public String toString() {
	return "Joueur [alias=" + alias + "]";
}

}
