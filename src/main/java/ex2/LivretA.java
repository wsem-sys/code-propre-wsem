package ex2;

/**
 * Représente un livret A, un type de compte bancaire sans découvert
 * et avec rémunération annuelle.
 * Hérite de la classe CompteBancaire.
 *
 * Un livret A ne doit jamais être à découvert.
 *
 * @author DIGINAMIC
 */
public class LivretA extends CompteBancaire {

	/** tauxRemuneration : taux d'intérêt annuel */
	private double tauxRemuneration;

	/**
	 * Constructeur
	 *
	 * @param solde             solde initial
	 * @param tauxRemuneration taux de rémunération annuel
	 */
	public LivretA(double solde, double tauxRemuneration) {
		super(solde);
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * Débite un montant uniquement si cela ne met pas le compte à découvert.
	 *
	 * @param montant le montant à débiter
	 */
	@Override
	public void debiterMontant(double montant) {
		if (this.solde - montant >= 0) {
			this.solde -= montant;
		}
	}

	/**
	 * Applique la rémunération annuelle au solde selon le taux défini.
	 */
	public void appliquerRemuAnnuelle() {
		this.solde += solde * tauxRemuneration / 100;
	}

	/** @return le taux de rémunération */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/** @param tauxRemuneration le nouveau taux à définir */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
}
