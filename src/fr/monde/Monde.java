package fr.monde;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.attaque.Attaque;
import fr.attaque.BasicAttaque;
import fr.classe.Classe;
import fr.personnage.Combattant;
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

		List<Attaque> attaques = new ArrayList<>();
		attaques.add(new BasicAttaque("Boule de feu", 15, "Une petite boule de feu, forte chance de touch�.", 90.0));
		attaques.add(new BasicAttaque("Grosse boule de glace", 30, "Une grosse boule de glace, chance moyenne de touch�.", 50.0));
		Classe mage = new Classe("Mage", attaques);
		
		Personnage personnage = new Personnage(nom, 50, 5, mage);

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

		String nom = debutNom[random.nextInt(debutNom.length)] + " " + finNom[random.nextInt(finNom.length)];

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
	
	/**
	 * Fait combattre un personnage contre un monstre.
	 * @param personnage
	 * @param monstre
	 */
	public static void combat(Combattant personnage, Combattant monstre) {
		boolean turn = true;
		while(stillAlive(personnage, monstre)) {
			if(turn) {
				personnage.attaquer(monstre);
				turn = !turn;
			} else {
				monstre.attaquer(personnage);
				turn = !turn;
			}
		}
		
		if(stillAlive(personnage)) {
			System.out.println("\nVictoire !!!");
			afficherDefaite(personnage, monstre);
		} else {
			System.out.println("\nD�faite ...");
			afficherDefaite(monstre, personnage);
		}
	}
	
	
	/**
	 * Affiche un message lors de la victoire d'un combat.
	 * @param gagant Un combattant qui a gagn�.
	 * @param perdant Un combattant qui a perdu.
	 */
	private static void afficherDefaite(Combattant gagant, Combattant perdant) {
		System.out.println(gagant.getNom() + " a gagn� contre " + perdant.getNom() + " !!");
	}

	/**
	 * V�rifie si les 2 combattants sont toujours vivant.
	 * @param personnage Un personnage
	 * @param monstre Un monstre
	 * @return Retourne un bool�en. "true" si les 2 sont toujours vivant, "false" sinon.  
	 */
	private static boolean stillAlive(Combattant personnage, Combattant monstre) {
		return stillAlive(personnage) && stillAlive(monstre);
	}
	
	/**
	 * V�rifie si un combattant est toujours vivant.
	 * @param combattant Une instance d'une classe h�ritant de AbstractCombattant.
	 * @return Retourne un bool�en. "true" si le combattant est vivant, "false" sinon.  
	 */
	private static boolean stillAlive(Combattant combattant) {
		return combattant.getPointDeVie() > 0;
	}
}
