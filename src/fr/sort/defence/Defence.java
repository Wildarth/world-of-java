package fr.sort.defence;

import fr.personnage.Combattant;
import fr.sort.Sort;

public interface Defence extends Sort{
	
	int defence(int degat, Combattant defenceur);
	
	@Override
	String toString();

}
