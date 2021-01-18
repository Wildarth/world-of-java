package fr.monde;

import java.util.ArrayList;
import java.util.List;

import fr.personnage.Personnage;
import fr.utilitaire.Tool;

public class Monde {

	private static List<Personnage> personnages = new ArrayList<>();

	private Monde() {

	}

	/**
	 * Créer un personnage avec tous ses attributs. Demande a l'utilisateur d'entrer
	 * le nom du personnage. Le personnage est ajouté à la liste des personnages du
	 * monde
	 * 
	 * @return une instance de la classe Personnage correctement instancié.
	 */
	public static Personnage personnageFactory() {

		String nom = Tool.demanderString("Entrer le nom de votre personnage :");

		Personnage personnage = new Personnage(50, 5, nom);

		personnages.add(personnage);

		return personnage;
	}

	/**
	 * affiche toutes les infos concernant le monde (personnage)
	 */
	public static void afficherInformations() {
		afficherInformationsPersonnages();
	}

	/**
	 * affiche les infos concernant les personnages du monde
	 */
	private static void afficherInformationsPersonnages() {
		System.out.println("Dans le monde il y a " + personnages.size() + " personnage(s), qui sont :");
		for (Personnage personnage : personnages) {
			System.out.println(personnage);
		}
	}
}
