package ex5;

/**
 * La classe {@code Item} représente un objet caractérisé par un nom et un poids.
 * Elle est utilisée dans le cadre de l'inventaire pour identifier et manipuler des items.
 *
 * <p>
 * Exemple d'utilisation :
 * <pre>
 *     // Création d'un item "Clé USB" pesant 1 kg
 *     Item item = new Item("Clé USB", 1);
 * </pre>
 * </p>
 *
 * @author wsem
 */
public class Item {

	/** Nom de l'item */
	private String nom;

	/** Poids de l'item (en kg) */
	private int poids;

	/**
	 * Constructeur par défaut.
	 */
	public Item() {
		// Constructeur vide
	}

	/**
	 * Constructeur permettant de créer un item avec un nom et un poids.
	 *
	 * @param nom le nom de l'item
	 * @param poids le poids de l'item (en kg)
	 */
	public Item(String nom, int poids) {
		this.nom = nom;
		this.poids = poids;
	}

	/**
	 * Retourne le nom de l'item.
	 *
	 * @return le nom de l'item
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom de l'item.
	 *
	 * @param nom le nouveau nom de l'item
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne le poids de l'item.
	 *
	 * @return le poids de l'item (en kg)
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * Définit le poids de l'item.
	 *
	 * @param poids le nouveau poids de l'item (en kg)
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * Retourne une représentation textuelle de l'item.
	 *
	 * @return une chaîne de caractères décrivant l'item
	 */
	@Override
	public String toString() {
		return "Item [nom=" + nom + ", poids=" + poids + "]";
	}
}
