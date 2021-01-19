package fr.monde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import fr.classe.Classe;
import fr.personnage.Combattant;
import fr.personnage.Monstre;
import fr.personnage.Personnage;
import fr.personnage.groupe.Groupe;
import fr.sort.Sort;
import fr.sort.attaque.Attaque;
import fr.sort.attaque.BasicAttaque;
import fr.sort.defence.AbsorbeDefence;
import fr.sort.defence.Defence;
import fr.sort.defence.DefenceFlat;
import fr.sort.defence.DefencePourcentage;
import fr.sort.defence.ParadeDefence;
import fr.utilitaire.Tool;

public class Monde {

	public static String[] debutNom = new String[] { "chien", "loup", "bandit", "magicien" };
	public static String[] finNom = new String[] { "mechant", "de feu", "des bois", "des t�n�bres" };

	public static Map<String, Classe> dictionnaire = new HashMap<>();

	private static List<Personnage> personnages = new ArrayList<>();
	private static List<Monstre> monstres = new ArrayList<>();
	private static List<Attaque> attaques = new ArrayList<>();
	private static List<Defence> defences = new ArrayList<>();

	private static Random random = new Random();

	private Monde() {

	}

	/**
	 * Affiche un menu de s�lection initial.
	 */
	public static void genese() {
		boolean onContinue = true;

		while (onContinue) {
			System.out.println("---***--- Bonjour ---***---");
			System.out.println("Choisir une option:");
			System.out.println("1: Lancer un combat 1v1");
			System.out.println("2: Lancer un combat de groupe");
			System.out.println("3: One vs World Hardcore Edition");
			System.out.println("4: Informations");
			System.out.println("5: Cr�ation de classe");
			System.out.println("----------------------------");

			onContinue = choixJoueur();
		}

		System.out.println("Aurevoir !");
	}

	private static boolean choixJoueur() {

		int retour = Tool.demanderInt(">>>");

		switch (retour) {
		case 1:
			combat1v1();
			return true;

		case 2:
			combatGroupe(Tool.demanderInt("Quelle taille pour le groupe de personnage ?"),
					Tool.demanderInt("Quelle taille pour le groupe de monstre ?"));
			return true;

		case 3:
			combatSolo(Tool.demanderInt("Quelle taille pour le groupe de monstre ?"));
			return true;

		case 4:
			afficherInformations();
			return true;

		case 5:
			creationClasse();
			return true;

		default:
			return false;

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
		Groupe listPersonnages = new Groupe();
		Groupe listMonstres = new Groupe();

		for (int i = 0; i < tailleGroupePersonnage; i++) {
			listPersonnages.addCombattant(personnageFactory());
		}

		for (int i = 0; i < tailleGroupeMonstre; i++) {
			listMonstres.addCombattant(monstreFactory());
		}

		combat(listPersonnages, listMonstres);
	}

	/**
	 * Lance un combat entre un personnage et un groupe de monstres.
	 * 
	 * @param tailleGroupeMonstre
	 */
	public static void combatSolo(int tailleGroupeMonstre) {
		Groupe listMonstres = new Groupe();

		for (int i = 0; i < tailleGroupeMonstre; i++) {
			listMonstres.addCombattant(monstreFactory());
		}

		combat(personnageFactory(), listMonstres);
	}

	/**
	 * Initialise le monde.
	 */
	public static void initialiseMonde() {
		creerAttaques();
		creerDefences();
		creerClasses();
		creerMonstres(5);
		
	}
	
	private static void creerDefences() {
		defences.add(new DefenceFlat(4, "Bouclier en bois", "Un petit bouclier de bois."));
		defences.add(new DefencePourcentage(0.25, "Bouclier en cuir", "Un petit bouclier en cuir."));
		defences.add(new AbsorbeDefence(0.8, 0.2, "Armure d'absorption", "Une armure qui soigne le porteur lorsqu'il subit des d�gats."));
		defences.add(new ParadeDefence(0.5, "Cape d'agilit�", "Une cape qui augmente l'esquive du porteur."));
	}

	private static void creerAttaques() {
		attaques.add(new BasicAttaque("Boule de feu", 15, "Une petite boule de feu, forte chance de touch�.", 90.0));
		attaques.add(new BasicAttaque("Grosse boule de glace", 30,
				"Une grosse boule de glace, chance moyenne de touch�.", 50.0));
		attaques.add(new BasicAttaque("Coup d'�p�e", 10, "Un simple coup d'�p�e, tr�s forte chance de touch�.", 95.0));
		attaques.add(
				new BasicAttaque("Lancer de hache", 35, "Lance une petite hachette, faible chance de touch�.", 25.0));
		attaques.add(new BasicAttaque("Coup de dague", 8, "Un simple coup de dague, ne rate jamais.", 100.0));
		attaques.add(
				new BasicAttaque("Lancer de couteau", 25, "Lance un petit couteau, chance de touch� �lev�.", 80.0));
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
		List<Defence> listDefences = new ArrayList<>();
		listDefences.add(defences.get(1));
		listDefences.add(defences.get(2));
		dictionnaire.put("Mage", new Classe("Mage", listAttaques, listDefences));
	}

	private static void creerGuerrier() {
		List<Attaque> listAttaques = new ArrayList<>();
		listAttaques.add(attaques.get(2));
		listAttaques.add(attaques.get(3));
		List<Defence> listDefences = new ArrayList<>();
		listDefences.add(defences.get(0));
		dictionnaire.put("Guerrier", new Classe("Guerrier", listAttaques, listDefences));
	}

	private static void creerVoleur() {
		List<Attaque> listAttaques = new ArrayList<>();
		listAttaques.add(attaques.get(4));
		listAttaques.add(attaques.get(5));
		List<Defence> listDefences = new ArrayList<>();
		listDefences.add(defences.get(3));
		dictionnaire.put("Voleur", new Classe("Voleur", listAttaques, listDefences));
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

		Personnage personnage = new Personnage(nom, 50, 5, demanderClasse());

		personnages.add(personnage);

		return personnage;
	}

	/**
	 * Demande � l'utilisateur le nom de classe qu'il veut.
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
	 * Cr�er un monstre avec tous ses attributs. Son nom et ses attributs son
	 * g�n�r�s al�atoirement. Le monstre est ajout� � la liste des personnages du
	 * monde.
	 * 
	 * @return une instance de la classe Monstre correctement instanci�.
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
		while (!(personnage.estMort() || monstre.estMort())) {
			if (turn) {
				personnage.attaquer(monstre);
			} else {
				monstre.attaquer(personnage);
			}
			turn =! turn;
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
		if (!personnage.estMort()) {
			System.out.println("\nVictoire !!!");
			afficherDefaite(personnage, monstre);
		} else {
			System.out.println("\nD�faite ...");
			afficherDefaite(monstre, personnage);
		}
	}

	/**
	 * Affiche un message lors de la victoire d'un combat.
	 * 
	 * @param gagant  Un combattant qui a gagn�.
	 * @param perdant Un combattant qui a perdu.
	 */
	private static void afficherDefaite(Combattant gagant, Combattant perdant) {
		System.out.println(gagant.getNom() + " a gagn� contre " + perdant.getNom() + " !!");
	}

	/**
	 * Renvoie la Classe correspondant au nom donn�.
	 * 
	 * @param nom Le nom d'une classe
	 * @return La Classe demand�.
	 */
	public static Classe getClasse(String nom) {
		return dictionnaire.get(nom);
	}

	/**
	 * Cr�er un groupe de monstre s�lectionn� al�atoirement de la taille donn� en
	 * param�tre.
	 * 
	 * @param nombreMonstre Le nombre de monstre dans le groupe.
	 * @return La groupe de monstre g�n�r�.
	 */
	public Groupe creationGroupeMonstre(int nombreMonstre) {
		Groupe groupe = new Groupe();
		for (int i = 0; i < nombreMonstre; i++) {
			groupe.addCombattant(monstres.get(random.nextInt(monstres.size())));
		}
		return groupe;
	}

	/**
	 * Cr�er un groupe de personnage de la taille donn� en param�tre, le joueur cr��
	 * chacun des personnages.
	 * 
	 * @param nombrePersonnage
	 * @return La groupe de personnage cr��.
	 */
	public Groupe creationGroupePersonnage(int nombrePersonnage) {
		Groupe groupe = new Groupe();
		for (int i = 0; i < nombrePersonnage; i++) {
			groupe.addCombattant(personnageFactory());
		}
		return groupe;
	}

	/**
	 * Cr�e une classe
	 * 
	 * @return la classe cr��
	 */
	public static Classe creationClasse() {
		String nom = Tool.demanderString("Donner un nom � la classe :");
		
		List<Attaque> listAttaques = new ArrayList<>();
		List<Defence> listDefences = new ArrayList<>();
		selectionnerSort(listAttaques, listDefences);

		Classe classe = new Classe(nom, listAttaques, listDefences);

		dictionnaire.put(nom, classe);

		return classe;
	}

	private static void selectionnerSort(List<Attaque> listAttaques, List<Defence> listDefences) {

		for (int i = 0; i < 4; i++) {
			Sort sort = selectionnerSort();
			
			if(sort instanceof Attaque) {
				listAttaques.add((Attaque) sort);
			} else {
				listDefences.add((Defence) sort);
			}	
		}
	}

	private static Sort selectionnerSort() {
		Attaque attaque = attaques.get(random.nextInt(attaques.size()));
		Defence defence = defences.get(random.nextInt(defences.size()));
		System.out.println("1. " + attaque);
		System.out.println("2. " + defence);
		
		if(Tool.demanderInt("Quelle comp�tence ajouter ?") == 1) {
			return attaque;
		} else {
			return defence;
		}
	}

}
