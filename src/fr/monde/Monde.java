package fr.monde;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.personnage.Monstre;
import fr.personnage.Personnage;
import fr.utilitaire.Tool;

public class Monde {
	
	public static String[] debutNom = new String[] {"chien", "loup", "bandit", "magicien"};
	public static String[] finNom = new String[] {"mechant", "de feu", "des bois", "des t�n�bres"};

	private static List<Personnage> personnages = new ArrayList<>();
	private static List<Monstre> monstres = new ArrayList<>();

	private static Random random = new Random();
	
	private Monde() {

	}

	/**
	 * Cr�er un personnage avec tous ses attributs. Demande a l'utilisateur d'entrer
	 * le nom du personnage. Le personnage est ajout� � la liste des personnages du
	 * monde
	 * 
	 * @return une instance de la classe Personnage correctement instanci�.
	 */
	public static Personnage personnageFactory() {

		String nom = Tool.demanderString("Entrer le nom de votre personnage :");

		Personnage personnage = new Personnage(nom, 50, 5);

		personnages.add(personnage);

		return personnage;
	}
	
	/**
	 * Cr�er un monstre avec tous ses attributs. Son nom et ses attributs son g�n�r�s al�atoirement.
	 * Le monstre est ajout� � la liste des personnages du monde.
	 * 
	 * @return une instance de la classe Monstre correctement instanci�.
	 */
	public static Monstre monstreFactory() {

		String nom = debutNom[random.nextInt(debutNom.length)] + finNom[random.nextInt(finNom.length)];

		Monstre monstre = new Monstre(nom, random.nextInt(65) + 10, random.nextInt(10) + 5);

		monstres.add(monstre);

		return monstre;
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
