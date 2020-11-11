package hanoi;

public class Score {
	private final byte nbDisques;
	private final int nbDeplacement;
	private final int nbSecondes;

	/**
	 * @param nbDisques
	 * @param nbDeplacement
	 * @param nbSecondes
	 */
	public Score(byte nbDisques, int nbDeplacement, int nbSecondes) {
		super();
		this.nbDisques = nbDisques;
		this.nbDeplacement = nbDeplacement;
		this.nbSecondes = nbSecondes;
	}

	/**
	 * Renvoie vrai si le score précisé en paramètre est meilleur le nombre de
	 * disque des scores doivent être identique sans quoi il renvera false
	 * 
	 * @param score le score à testé
	 * @return
	 */
	public boolean isBestThan(Score score) {
		if (score.getNbDisques() != getNbDisques())
			return false;
		// Même nbr de disques
		if (nbDeplacement > score.nbDeplacement)
			return true;
		if (nbDeplacement == score.nbDeplacement && 
				nbSecondes > score.nbSecondes)
			return true;
		return false;
	}

	
	// Getter et méthodes générées automatiquement
	public byte getNbDisques() {
		return nbDisques;
	}

	public int getNbDeplacement() {
		return nbDeplacement;
	}

	public int getNbSecondes() {
		return nbSecondes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nbDeplacement;
		result = prime * result + nbDisques;
		result = prime * result + nbSecondes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (nbDeplacement != other.nbDeplacement)
			return false;
		if (nbDisques != other.nbDisques)
			return false;
		if (nbSecondes != other.nbSecondes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Score [nbDisques=" + nbDisques + ", nbDeplacement=" + nbDeplacement + ", nbSecondes=" + nbSecondes
				+ "]";
	}

}
