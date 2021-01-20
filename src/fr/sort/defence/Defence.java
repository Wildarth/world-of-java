package fr.sort.defence;

import fr.personnage.Combattant;
import fr.sort.Sort;

public interface Defence extends Sort{
	
	/**
	 * Renvoie les d�gats que doit subir le defenceur.
	 * @param degat Les d�gats subits.
	 * @param defenceur Le Combattant qui subit l'attaque.
	 * @return
	 */
	int defence(int degat, Combattant defenceur);
	
	@Override
	String toString();

}
