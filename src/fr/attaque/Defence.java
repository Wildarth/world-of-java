package fr.attaque;

import fr.personnage.Combattant;

public interface Defence extends Sort{
	
	int defence(int degat, Combattant defenceur);
	
	@Override
	String toString();

}
