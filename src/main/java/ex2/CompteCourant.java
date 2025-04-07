package ex2;

/**
 * Représente un compte courant qui autorise un découvert.
 * Hérite de la classe CompteBancaire.
 *
 * @author DIGINAMIC
 */
public class CompteCourant extends CompteBancaire {

    /** decouvert : montant de découvert autorisé */
    private double decouvert;

    /**
     * Constructeur
     *
     * @param solde     solde initial du compte
     * @param decouvert découvert autorisé
     */
    public CompteCourant(double solde, double decouvert) {
        super(solde);
        this.decouvert = decouvert;
    }

    /**
     * Débite un montant du compte si le découvert autorisé n'est pas dépassé.
     *
     * @param montant le montant à débiter
     */
    @Override
    public void debiterMontant(double montant) {
        if (this.solde - montant >= -decouvert) {
            this.solde -= montant;
        }
    }

    /** @return le découvert autorisé */
    public double getDecouvert() {
        return decouvert;
    }

    /** @param decouvert le nouveau découvert à définir */
    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
