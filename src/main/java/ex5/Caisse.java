package ex5;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe {@code Caisse} représente une caisse qui contient une collection d'items
 * et accepte uniquement les items dont le poids se situe dans un intervalle spécifié.
 *
 * <p>
 * Chaque caisse est caractérisée par :
 * <ul>
 *   <li>un nom,</li>
 *   <li>une liste d'items,</li>
 *   <li>un poids minimum accepté (inclus),</li>
 *   <li>un poids maximum accepté (exclus).</li>
 * </ul>
 * </p>
 *
 * <p>
 * Exemple d'utilisation :
 * <pre>
 *     // Création d'une caisse acceptant les items dont le poids est entre 0 (inclus) et 5 (exclus)
 *     Caisse caisse = new Caisse("Petits objets", 0, 5);
 *     if (caisse.peutAccepter(item)) {
 *         caisse.ajouterItem(item);
 *     }
 * </pre>
 * </p>
 *
 * @author wsem
 */
public class Caisse {

	/** Nom de la caisse */
	private String nom;

	/** Liste des items contenus dans la caisse */
	private List<Item> items;

	/** Poids minimum accepté (inclus) pour un item */
	private double poidsMin;

	/** Poids maximum accepté (exclus) pour un item */
	private double poidsMax;

	/**
	 * Constructeur de la classe {@code Caisse} sans restriction de poids.
	 * La caisse sera considérée comme acceptant tous les items.
	 *
	 * @param nom le nom de la caisse
	 */
	public Caisse(String nom) {
		this.nom = nom;
		this.items = new ArrayList<>();
		// Par défaut, la caisse n'impose aucune restriction de poids.
		this.poidsMin = Double.NEGATIVE_INFINITY;
		this.poidsMax = Double.POSITIVE_INFINITY;
	}

	/**
	 * Constructeur de la classe {@code Caisse} avec un intervalle de poids.
	 * La caisse acceptera uniquement les items dont le poids est compris entre
	 * {@code poidsMin} (inclus) et {@code poidsMax} (exclus).
	 *
	 * @param nom      le nom de la caisse
	 * @param poidsMin le poids minimum accepté (inclus)
	 * @param poidsMax le poids maximum accepté (exclus)
	 */
	public Caisse(String nom, double poidsMin, double poidsMax) {
		this.nom = nom;
		this.items = new ArrayList<>();
		this.poidsMin = poidsMin;
		this.poidsMax = poidsMax;
	}

	/**
	 * Retourne le nom de la caisse.
	 *
	 * @return le nom de la caisse
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom de la caisse.
	 *
	 * @param nom le nouveau nom de la caisse
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne la liste des items contenus dans la caisse.
	 *
	 * <p>
	 * Note : La liste retournée est modifiable. Pour modifier la collection de manière plus sécurisée,
	 * il est recommandé d'utiliser les méthodes {@link #ajouterItem(Item)} et {@link #retirerItem(Item)}.
	 * </p>
	 *
	 * @return la liste des items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Remplace la liste des items par une nouvelle liste.
	 *
	 * <p>
	 * Attention, cette opération écrase la liste existante.
	 * </p>
	 *
	 * @param items la nouvelle liste d'items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * Ajoute un item à la caisse si celui-ci est accepté (selon son poids).
	 *
	 * @param item l'item à ajouter ; s'il est {@code null} ou non accepté, il ne sera pas ajouté
	 */
	public void ajouterItem(Item item) {
		if (item != null && peutAccepter(item)) {
			this.items.add(item);
		}
	}

	/**
	 * Retire un item de la caisse.
	 *
	 * @param item l'item à retirer
	 * @return {@code true} si l'item a été retiré avec succès, {@code false} sinon
	 */
	public boolean retirerItem(Item item) {
		return this.items.remove(item);
	}

	/**
	 * Vérifie si l'item peut être accepté par cette caisse en fonction de son poids.
	 *
	 * @param item l'item à vérifier
	 * @return {@code true} si le poids de l'item est compris entre {@code poidsMin} (inclus) et {@code poidsMax} (exclus),
	 *         {@code false} sinon.
	 */
	public boolean peutAccepter(Item item) {
		double poids = item.getPoids();
		return (poids >= this.poidsMin && poids < this.poidsMax);
	}

	/**
	 * Retourne le poids minimum accepté.
	 *
	 * @return le poids minimum
	 */
	public double getPoidsMin() {
		return poidsMin;
	}

	/**
	 * Définit le poids minimum accepté.
	 *
	 * @param poidsMin le nouveau poids minimum
	 */
	public void setPoidsMin(double poidsMin) {
		this.poidsMin = poidsMin;
	}

	/**
	 * Retourne le poids maximum accepté.
	 *
	 * @return le poids maximum
	 */
	public double getPoidsMax() {
		return poidsMax;
	}

	/**
	 * Définit le poids maximum accepté.
	 *
	 * @param poidsMax le nouveau poids maximum
	 */
	public void setPoidsMax(double poidsMax) {
		this.poidsMax = poidsMax;
	}
}
