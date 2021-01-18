package fr;

import fr.personnage.Personnage;
import fr.utilitaire.Tool;

public class Run {

	public static void main(String[] args) {

		Personnage personnage = personnageFactory();
		
		System.out.println(personnage);
	}
	
	
	/**
	 * Créer un personnage avec tous ses attributs. 
	 * Demande a l'utilisateur d'entrer le nom du personnage.
	 * @return une instance de la classe Personnage correctement instancié.
	 */
	public static Personnage personnageFactory(){
		
		String nom = Tool.demanderString("Entrer le nom de votre personnage :");
		
		Personnage personnage = new Personnage(50, 5, nom);
		
		return personnage;
	}
	
}
