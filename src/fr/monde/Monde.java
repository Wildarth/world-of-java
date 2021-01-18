package fr.monde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import fr.attaque.Attaque;
import fr.attaque.BasicAttaque;
import fr.classe.Classe;
import fr.personnage.Combattant;
import fr.personnage.Monstre;
import fr.personnage.Personnage;
import fr.personnage.groupe.Groupe;
import fr.utilitaire.Tool;

public class Monde {

	public static String[] debutNom = new String[] { "chien", "loup", "bandit", "magicien" };
	public static String[] finNom = new String[] { "mechant", "de feu", "des bois", "des ténèbres" };

	public static Map<String, Classe> dictionnaire = new HashMap<>();

	private static List<Personnage> personnages = new ArrayList<>();
	private static List<Monstre> monstres = new ArrayList<>();
	private static List<Attaque> attaques = new ArrayList<>();

	private static Random random = new Random();

	private Monde() {

	}

	/**
	 * Affiche un menu de sélection initial.
	 */
	public static void genese() {
		System.out.println("---***--- Bonjour ---***---");
		System.out.println("Choisir une option:");
		System.out.println("1: Lancer un combat 1v1");
		System.out.println("2: Lancer un combat de groupe");
		System.out.println("3: One vs World Hardcore Edition");
		System.out.println("4: Informations");
		System.out.println("----------------------------");

		choixJoueur();
	}

	private static void choixJoueur() {
		int retour = -1;
		while (retour <= 0 || retour >= 5) {
			retour = Tool.demanderInt(">>>");
		}

		switch (retour) {
		case 1:
			combat1v1();
			break;

		case 2:
			combatGroupe(Tool.demanderInt("Quelle taille pour le groupe de personnage ?"),
					Tool.demanderInt("Quelle taille pour le groupe de monstre ?"));
			break;

		case 3:
			combatSolo(Tool.demanderInt("Quelle taille pour le groupe de monstre ?"));
			break;

		case 4:
			afficherInformations();
			break;

		default:
			break;

		}

	}

	/**
	 * Lance un combat entre un personnage et un monstre.
	 */
	public static void combat1v1() {
		combat(personnageFactory(), monstreFactory());
	}

	/**
	 * Lance un combat entre un groupe de personnages et un groupe de monstres.
	 * 
	 * @param tailleGroupePersonnage
	 * @param tailleGroupeMonstre
	 */
	public static void combatGroupe(int tailleGroupePersonnage, int tailleGroupeMonstre) {
		Groupe personnages = new Groupe();
		Groupe monstres = new Groupe();

		for (int i = 0; i < tailleGroupePersonnage; i++) {
			personnages.addCombattant(personnageFactory());
		}

		for (int i = 0; i < tailleGroupeMonstre; i++) {
			monstres.addCombattant(monstreFactory());
		}

		combat(personnages, monstres);
	}

	/**
	 * Lance un combat entre un personnage et un groupe de monstres.
	 * 
	 * @param tailleGroupeMonstre
	 */
	public static void combatSolo(int tailleGroupeMonstre) {
		Groupe monstres = new Groupe();

		for (int i = 0; i < tailleGroupeMonstre; i++) {
			monstres.addCombattant(monstreFactory());
		}

		combat(personnageFactory(), monstres);
	}

	/**
	 * Initialise le monde.
	 */
	public static void initialiseMonde() {
		creerAttaques();
		creerClasses();
		creerMonstres(5);	
	}

	private static void creerAttaques() {
		attaques.add(new BasicAttaque("Boule de feu", 15, "Une petite boule de feu, forte chance de touché.", 90.0));
		attaques.add(new BasicAttaque("Grosse boule de glace", 30,
				"Une grosse boule de glace, chance moyenne de touché.", 50.0));
		attaques.add(new BasicAttaque("Coup d'épée", 10, "Un simple coup d'épée, très forte chance de touché.", 95.0));
		attaques.add(
				new BasicAttaque("Lancer de hache", 35, "Lance une petite hachette, faible chance de touché.", 25.0));
		attaques.add(new BasicAttaque("Coup de dague", 8, "Un simple coup de dague, ne rate jamais.", 100.0));
		attaques.add(
				new BasicAttaque("Lancer de couteau", 25, "Lance un petit couteau, chance de touché élevé.", 80.0));
	}

	private static void creerMonstres(int nombreMonstre) {
		for (int i = 0; i < nombreMonstre; i++) {
			monstres.add(monstreFactory());
		}
	}

	private static void creerClasses() {
		creerMage();
		creerGuerrier();
		creerVoleur();
	}

	private static void creerMage() {
		List<Attaque> listAttaques = new ArrayList<>();
		listAttaques.add(attaques.get(0));
		listAttaques.add(attaques.get(1));
		dictionnaire.put("Mage", new Classe("Mage", listAttaques));
	}

	private static void creerGuerrier() {
		List<Attaque> listAttaques = new ArrayList<>();
		listAttaques.add(attaques.get(2));
		listAttaques.add(attaques.get(3));
		dictionnaire.put("Guerrier", new Classe("Guerrier", listAttaques));
	}

	private static void creerVoleur() {
		List<Attaque> listAttaques = new ArrayList<>();
		listAttaques.add(attaques.get(4));
		listAttaques.add(attaques.get(5));
		dictionnaire.put("Voleur", new Classe("Voleur", listAttaques));
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

		Personnage personnage = new Personnage(nom, 50, 5, demanderClasse());

		personnages.add(personnage);

		return personnage;
	}

	/**
	 * Demande à l'utilisateur le nom de classe qu'il veut.
	 * 
	 * @return Renvoie la classe que l'utilisateur a choisi.
	 */
	private static Classe demanderClasse() {

		System.out.println("Les classes suivantes sont disponibles :");
		for (String nom : dictionnaire.keySet()) {
			System.out.println(nom);
		}

		Classe classe = null;

		while (classe == null) {
			classe = dictionnaire.get(Tool.demanderString("Quel classe choisis-tu ?"));
			if (classe == null)
				System.out.println("Nom invalide !");
		}

		return classe;
	}

	/**
	 * Créer un monstre avec tous ses attributs. Son nom et ses attributs son
	 * générés aléatoirement. Le monstre est ajouté à la liste des personnages du
	 * monde.
	 * 
	 * @return une instance de la classe Monstre correctement instancié.
	 */
	public static Monstre monstreFactory() {

		String nom = debutNom[random.nextInt(debutNom.length)] + " " + finNom[random.nextInt(finNom.length)];

		Monstre monstre = new Monstre(nom, random.nextInt(65) + 10, random.nextInt(10) + 5);

		return monstre;
	}

	/**
	 * affiche toutes les infos concernant le monde (monstre et classe)
	 */
	public static void afficherInformations() {
		// afficherInformationsPersonnages();

		afficherInformationMonstres();
		afficherInformationClasse();
	}

	/**
	 * Affiche toutes les infos concernant les classes.
	 */
	private static void afficherInformationClasse() {
		System.out.println("Dans le monde il existe " + dictionnaire.size() + " classes, qui sont :");
		for (String classe : dictionnaire.keySet()) {
			System.out.println(dictionnaire.get(classe));
		}
	}

	/**
	 * Affiche toutes les infos concernant les monstres.
	 */
	private static void afficherInformationMonstres() {
		System.out.println("Dans le monde il existe " + monstres.size() + " monstres, qui sont :");
		for (Monstre monstre : monstres) {
			System.out.println(monstre);
		}
	}

	/**
	 * Fait combattre un personnage contre un monstre.
	 * 
	 * @param personnage
	 * @param monstre
	 */
	public static void combat(Combattant personnage, Combattant monstre) {
		boolean turn = true;
		while (stillAlive(personnage, monstre)) {
			if (turn) {
				personnage.attaquer(monstre);
				turn = !turn;
			} else {
				monstre.attaquer(personnage);
				turn = !turn;
			}
		}

		quiGagne(personnage, monstre);
	}

	/**
	 * Affiche le gagant du combat
	 * 
	 * @param personnage
	 * @param monstre
	 */
	private static void quiGagne(Combattant personnage, Combattant monstre) {
		if (stillAlive(personnage)) {
			System.out.println("\nVictoire !!!");
			afficherDefaite(personnage, monstre);
		} else {
			System.out.println("\nDéfaite ...");
			afficherDefaite(monstre, personnage);
		}
	}

	/**
	 * Affiche un message lors de la victoire d'un combat.
	 * 
	 * @param gagant  Un combattant qui a gagné.
	 * @param perdant Un combattant qui a perdu.
	 */
	private static void afficherDefaite(Combattant gagant, Combattant perdant) {
		System.out.println(gagant.getNom() + " a gagné contre " + perdant.getNom() + " !!");
	}

	/**
	 * Vérifie si les 2 combattants sont toujours vivant.
	 * 
	 * @param personnage Un personnage
	 * @param monstre    Un monstre
	 * @return Retourne un booléen. "true" si les 2 sont toujours vivant, "false"
	 *         sinon.
	 */
	private static boolean stillAlive(Combattant personnage, Combattant monstre) {
		return stillAlive(personnage) && stillAlive(monstre);
	}

	/**
	 * Vérifie si un combattant est toujours vivant.
	 * 
	 * @param combattant Une instance d'une classe héritant de AbstractCombattant.
	 * @return Retourne un booléen. "true" si le combattant est vivant, "false"
	 *         sinon.
	 */
	private static boolean stillAlive(Combattant combattant) {
		return combattant.getPointDeVie() > 0;
	}

	/**
	 * Renvoie la Classe correspondant au nom donné.
	 * 
	 * @param nom Le nom d'une classe
	 * @return La Classe demandé.
	 */
	public static Classe getClasse(String nom) {
		return dictionnaire.get(nom);
	}

	/**
	 * Créer un groupe de monstre sélectionné aléatoirement de la taille donné en
	 * paramètre.
	 * 
	 * @param nombreMonstre Le nombre de monstre dans le groupe.
	 * @return La groupe de monstre généré.
	 */
	public Groupe creationGroupeMonstre(int nombreMonstre) {
		Groupe groupe = new Groupe();
		for (int i = 0; i < nombreMonstre; i++) {
			groupe.addCombattant(monstres.get(random.nextInt(monstres.size())));
		}
		return groupe;
	}

	/**
	 * Créer un groupe de personnage de la taille donné en paramètre, le joueur créé
	 * chacun des personnages.
	 * 
	 * @param nombrePersonnage
	 * @return La groupe de personnage créé.
	 */
	public Groupe creationGroupePersonnage(int nombrePersonnage) {
		Groupe groupe = new Groupe();
		for (int i = 0; i < nombrePersonnage; i++) {
			groupe.addCombattant(personnageFactory());
		}
		return groupe;
	}

	/**
	 * Crée une classe
	 * @return la classe créé
	 */
	public static Classe creationClasse() {
		String nom = Tool.demanderString("Donner un nom à la classe :");
		
		Classe classe = new Classe(nom, genererListAttaque());
		
		dictionnaire.put(nom, classe);
		
		return classe;
	}

	private static List<Attaque> genererListAttaque() {
		
		List<Attaque> listAttaques = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			listAttaques.add(selectionnerAttaque());
		}
		
		return listAttaques;
	}

	private static Attaque selectionnerAttaque() {
		System.out.println("1. " + attaques.get(random.nextInt(attaques.size())));
		System.out.println("2. " + attaques.get(random.nextInt(attaques.size())));
		
		return attaques.get(Tool.demanderInt("Quelle compétence ajouter ?"));
	}
}
