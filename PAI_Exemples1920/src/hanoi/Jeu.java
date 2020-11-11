package hanoi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Jeu {

	private List<Piquet> piquets;

	private int nbDeplacements;
	private byte nbDisques; // Nombre de disque de la partie
	private boolean finPartie;// Partie finie
	private Chrono chrono;
	// Liste de joueurs
	// Map<String, Joueur> joueurs = new Hashtable<>();
	// Le joueur qui joue la partie
	private Joueur joueur;

	private Score scoreBest;

	/**
	 * Création du jeu
	 */
	public Jeu() {
		piquets = Arrays.asList(new Piquet("PD"), new Piquet("PI"), new Piquet("PA"));
		chrono = new Chrono();
		finPartie = true;
	}

	/**
	 * Péparer un jeu avec n disques sur le piquet de départ
	 * 
	 * @param n
	 * @param alias l'alias du joueur
	 */
	public void initPartie(byte n, String alias) {
		nbDisques = n;
		// Vider les piquets
		for (Piquet p : piquets)
			p.viderPiquet();
		System.out.println("Création des " + n + " disques sur le piquet de départ");
		nbDeplacements = 0;
		try {
			// Création des n disques sur le piquet de départ
			for (byte i = n; i > 0; i--) {
				piquets.get(0).push(new Disque(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finPartie = false;
		// Récupère la liste des joueurs
		Map<String, Joueur> joueurs = Joueur.getJoueurs();

		// Recheche ou crée le joueur
		if (joueurs.containsKey(alias)) {
			// le joueur existe
			joueur = joueurs.get(alias);
		} else {// on crée le joueur
			joueur = new Joueur(alias);
			joueurs.put(alias, joueur);
		}
		scoreBest = joueur.getScore(n);

		// affiche son score actuel s'il en a un
		if (scoreBest != null)
			System.out.println("Votre meilleur score actuel est de " + scoreBest.getNbDeplacement()
					+ " déplacements en " + scoreBest.getNbSecondes() + " secondes");
		else
			System.out.println("Vous n'avez pas encore de score pour ce niveau!");

		// Initialise le chronomètre
		chrono.reset();
		chrono.start();
	}

	/**
	 * Déplace le disque au sommet du piquet de départ vers le piquet d'arrivée
	 * 
	 * @param depart
	 * @param arrivée
	 */
	public void deplacer(byte numPD, byte numPA) {
		if (finPartie)
			return;// Sort si la partie est déjà terminée

		// J'obtiens les piquets à partie de leur code
		Piquet depart, arrivée;
		depart = piquets.get(numPD);
		arrivée = piquets.get(numPA);

		Disque d = null;
		try {
			nbDeplacements++;
			d = depart.pop();
			arrivée.push(d);
			// Test si gagné
			finPartie = (piquets.get(2).getNbDisques() == nbDisques);
			if (finPartie)
				traitementFinPartie();

		} catch (Exception e) {
			try {
				if (d != null)
					depart.push(d);
				System.out.println("!!!!!deplacement impossible du " + d + " sur " + arrivée);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	// Affiche le résultat de fin de partie
	private void traitementFinPartie() {
		chrono.stop();
		// gestion du score
		Score newScore = new Score(nbDisques, nbDeplacements, chrono.getNbSecondes());
		boolean meilleur = joueur.setNewScore(newScore);
		if (meilleur) {
			System.out.println("Bravo pour votre nouveau score");
			sauvegarde();
		}
		System.out.println("Gagné en " + nbDeplacements + " déplacements et " + chrono.getNbSecondes() + " secondes");
		System.out.println("Le nombre de déplacements minimum étant: " + (Math.pow(2, nbDisques) - 1));
	}

//sauve sur un fichier le  joueur
	private void sauvegarde() {
		// TODO

	}

	/**
	 * Algorithme récursif
	 * 
	 * Déplace nb disques du piquet d vers a Comme je code chaque piquet par un
	 * nombre: (0,1,2), le piquet intérmédière est calculé par (3-d-a)
	 * 
	 * @param nb nbre de disques
	 * @param d  piquet départ
	 * @param a  piquet arrivée
	 */
	private void deplace(byte nb, byte d, byte a) {

		if (nb == 1) //déplacement réel
			deplacer(d, a);
		else {//appels récursifs
			deplace((byte) (nb - 1), d, (byte) (3 - d - a));
			deplace((byte) (1), d, (byte) (a));
			deplace((byte) (nb - 1), (byte) (3 - d - a), a);
		}
	}

	/**
	 * Lance une partie avec l'algo récursif
	 * 
	 * @param n
	 */
	public void animation(byte n) {
		System.out.println("==============================================");
		// Réinitialise les 3 piquets avec n disques
		initPartie(n, "Computer");
		System.out.println("==============================================");
		// Déplacement de n disques du piquet 0 au piquet 2
		deplace( n, (byte) 0, (byte) 2);

	}

	/**
	 * 
	 * @return nombre de Deplacements
	 */
	public int getNbDeplacements() {
		return nbDeplacements;
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//p0 désignera le piquet 0, p1 le piquet 1 et p2 le piquet 2
		byte p0=0;
		byte p1=1;
		byte p2=2;
		
		System.out.println("------------");

		Jeu j = new Jeu();

		// Appel de l'algorithme récursif pour déplacer 10 disques
		// j.animation((byte) 3);

		/* Autre exemple en mode manuel */
		System.out.println("==============================================");
		j.initPartie((byte) 3, "VO");
		System.out.println("==============================================");
		j.deplacer( p0,  p2);
		j.deplacer( p2,  p0);
		j.deplacer( p0,  p2);
		j.deplacer( p0,  p1);
		j.deplacer( p2,  p1);
		j.deplacer( p0,  p2);
		j.deplacer( p1,  p0);
		j.deplacer( p1,  p2);
		j.deplacer( p0,  p2);
		System.out.println("==============================================");
		j.initPartie((byte) 3, "VO");
		System.out.println("==============================================");
		j.deplacer( p0,  p2);
		j.deplacer( p0,  p1);
		j.deplacer( p2,  p1);
		j.deplacer( p0,  p2);
		j.deplacer( p1,  p0);
		j.deplacer( p1,  p2);
		j.deplacer( p0,  p2);
	}

}
