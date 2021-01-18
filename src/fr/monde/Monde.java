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
	
	public static String[] debutNom = new String[] {"chien", "loup", "bandit", "magicien"};
	public static String[] finNom = new String[] {"mechant", "de feu", "des bois", "des ténèbres"};
	
	public static Map<String, Classe> dictionnaire = new HashMap<>(); 

	private static List<Personnage> personnages = new ArrayList<>();
	private static List<Monstre> monstres = new ArrayList<>();

	private static Random random = new Random();
	
	private Monde() {

	}
	
	/**
	 * Initialise le monde.
	 */
	public static void initialiseMonde() {
		creerClasses();
		creerMonstres(5);
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
		List<Attaque> attaques = new ArrayList<>();
		attaques.add(new BasicAttaque("Boule de feu", 15, "Une petite boule de feu, forte chance de touché.", 90.0));
		attaques.add(new BasicAttaque("Grosse boule de glace", 30, "Une grosse boule de glace, chance moyenne de touché.", 50.0));
		dictionnaire.put("Mage", new Classe("Mage", attaques));
	}
	
	private static void creerGuerrier() {
		List<Attaque> attaques = new ArrayList<>();
		attaques.add(new BasicAttaque("Coup d'épée", 10, "Un simple coup d'épée, très forte chance de touché.", 95.0));
		attaques.add(new BasicAttaque("Lancer de hache", 35, "Lance une petite hachette, faible chance de touché.", 25.0));
		dictionnaire.put("Guerrier", new Classe("Guerrier", attaques));
	}
	
	private static void creerVoleur() {
		List<Attaque> attaques = new ArrayList<>();
		attaques.add(new BasicAttaque("Coup de dague", 8, "Un simple coup de dague, ne rate jamais.", 100.0));
		attaques.add(new BasicAttaque("Lancer de couteau", 25, "Lance un petit couteau, chance de touché élevé.", 80.0));
		dictionnaire.put("Voleur", new Classe("Voleur", attaques));
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
	 * @return Renvoie la classe que l'utilisateur a choisi.
	 */
	private static Classe demanderClasse() {
		
		System.out.println("Les classes suivantes sont disponibles :");
		for (String nom : dictionnaire.keySet()) {
			System.out.println(nom);
		}
		
		Classe classe = null;
		
		while(classe == null){
			classe = dictionnaire.get(Tool.demanderString("Quel classe choisis-tu ?"));
			if(classe == null) System.out.println("Nom invalide !");
		}
		
		return classe;
	}

	/**
	 * Créer un monstre avec tous ses attributs. Son nom et ses attributs son générés aléatoirement.
	 * Le monstre est ajouté à la liste des personnages du monde.
	 * 
	 * @return une instance de la classe Monstre correctement instancié.
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
		
		quiGagne(personnage, monstre);
	}

	/**
	 * Affiche le gagant du combat
	 * @param personnage
	 * @param monstre
	 */
	private static void quiGagne(Combattant personnage, Combattant monstre) {
		if(stillAlive(personnage)) {
			System.out.println("\nVictoire !!!");
			afficherDefaite(personnage, monstre);
		} else {
			System.out.println("\nDéfaite ...");
			afficherDefaite(monstre, personnage);
		}
	}
	
	
	/**
	 * Affiche un message lors de la victoire d'un combat.
	 * @param gagant Un combattant qui a gagné.
	 * @param perdant Un combattant qui a perdu.
	 */
	private static void afficherDefaite(Combattant gagant, Combattant perdant) {
		System.out.println(gagant.getNom() + " a gagné contre " + perdant.getNom() + " !!");
	}

	/**
	 * Vérifie si les 2 combattants sont toujours vivant.
	 * @param personnage Un personnage
	 * @param monstre Un monstre
	 * @return Retourne un booléen. "true" si les 2 sont toujours vivant, "false" sinon.  
	 */
	private static boolean stillAlive(Combattant personnage, Combattant monstre) {
		return stillAlive(personnage) && stillAlive(monstre);
	}
	
	/**
	 * Vérifie si un combattant est toujours vivant.
	 * @param combattant Une instance d'une classe héritant de AbstractCombattant.
	 * @return Retourne un booléen. "true" si le combattant est vivant, "false" sinon.  
	 */
	private static boolean stillAlive(Combattant combattant) {
		return combattant.getPointDeVie() > 0;
	}
	
	/**
	 * Renvoie la Classe correspondant au nom donné. 
	 * @param nom Le nom d'une classe
	 * @return La Classe demandé.
	 */
	public static Classe getClasse(String nom) {
		return dictionnaire.get(nom);
	}
	
	/**
	 * Créer un groupe de monstre sélectionné aléatoirement de la taille donné en paramètre.
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
	 * Créer un groupe de personnage de la taille donné en paramètre, le joueur créé chacun des personnages.
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
}
