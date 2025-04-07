package ex2;

/**
 * Classe abstraite représentant un compte bancaire de base.
 * Elle définit les méthodes communes à tous les types de comptes.
 *
 * @author DIGINAMIC
 */
public abstract class CompteBancaire {

	/** solde : montant actuel disponible sur le compte */
	protected double solde;

	/**
	 * Constructeur
	 * @param solde le solde initial du compte
	 */
	public CompteBancaire(double solde) {
		this.solde = solde;
	}

	/**
	 * Permet d'ajouter un montant au solde du compte.
	 *
	 * @param montant le montant à ajouter
	 */
	public void ajouterMontant(double montant) {
		this.solde += montant;
	}

	/**
	 * Méthode abstraite à redéfinir pour débiter un montant du compte,
	 * selon les règles spécifiques à chaque type de compte.
	 *
	 * @param montant le montant à débiter
	 */
	public abstract void debiterMontant(double montant);

	/** @return le solde actuel du compte */
	public double getSolde() {
		return solde;
	}

	/** @param solde le nouveau solde à définir */
	public void setSolde(double solde) {
		this.solde = solde;
	}
}
