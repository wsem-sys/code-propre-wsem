package ex5;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe {@code Inventaire} représente un inventaire composé de plusieurs caisses.
 *
 * <p>Chaque caisse est responsable de déterminer si elle peut accepter un item en fonction de son poids.
 * Pour cela, chaque caisse est instanciée avec des critères de poids spécifiques :
 * <ul>
 *   <li><strong>Petits objets</strong> : poids dans l'intervalle [0, 5) kg.</li>
 *   <li><strong>Moyens objets</strong> : poids dans l'intervalle [5, 20) kg.</li>
 *   <li><strong>Grands objets</strong> : poids à partir de 20 kg.</li>
 * </ul>
 * </p>
 *
 * <p>La méthode {@code addItem(Item item)} recherche la caisse qui accepte l'item et l'y ajoute.</p>
 * @author wsem
 * @see Caisse
 */
public class Inventaire {

	/** Liste des caisses constituant l'inventaire */
	private List<Caisse> caisses;

	/**
	 * Constructeur de la classe {@code Inventaire}.
	 * Initialise l'inventaire avec trois caisses correspondant aux différents intervalles de poids.
	 */
	public Inventaire() {
		caisses = new ArrayList<>();
		// Instanciation des caisses avec des critères de poids :
		// Pour les "Grands objets", on utilise Double.POSITIVE_INFINITY pour représenter l'absence de borne supérieure.
		caisses.add(new Caisse("Petits objets", 0, 5)); // accepte les items de poids [0, 5)
		caisses.add(new Caisse("Moyens objets", 5, 20)); // accepte les items de poids [5, 20)
		caisses.add(new Caisse("Grands objets", 20, Double.POSITIVE_INFINITY)); // accepte les items de poids >= 20
	}

	/**
	 * Ajoute un item dans la caisse appropriée de l'inventaire.
	 * La caisse qui accepte l'item (selon son poids) est recherchée parmi les caisses.
	 *
	 * @param item l'item à ajouter ; s'il est {@code null}, il ne sera pas ajouté
	 */
	public void addItem(Item item) {
		if (item == null) {
			return;
		}
		// Parcourt toutes les caisses et ajoute l'item dans la première caisse qui l'accepte.
		for (Caisse caisse : caisses) {
			if (caisse.peutAccepter(item)) {
				caisse.ajouterItem(item);
				// Une fois ajouté, on sort de la boucle.
				break;
			}
		}
	}

	/**
	 * Calcule la taille totale de l'inventaire, c'est-à-dire le nombre total d'items dans toutes les caisses.
	 *
	 * @return le nombre total d'items dans l'inventaire
	 */
	public int taille() {
		int total = 0;
		for (Caisse caisse : caisses) {
			total += caisse.getItems().size();
		}
		return total;
	}

	/**
	 * Retourne la liste des caisses composant l'inventaire.
	 *
	 * @return la liste des caisses
	 */
	public List<Caisse> getCaisses() {
		return caisses;
	}

	/**
	 * Définit la liste des caisses composant l'inventaire.
	 * Attention, cette opération écrase la liste existante.
	 *
	 * @param caisses la nouvelle liste de caisses
	 */
	public void setCaisses(List<Caisse> caisses) {
		this.caisses = caisses;
	}
}
