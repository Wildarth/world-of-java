package fr.donjon.salle;

import fr.personnage.Combattant;

public class FontaineSalle implements Salle {

	@Override
	public void entrer(Combattant combattant) {
		combattant.soigner(100);
	}
	
}
