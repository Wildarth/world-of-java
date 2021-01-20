package fr.donjon.salle;

import fr.monde.Monde;
import fr.personnage.Combattant;

public class MonstreCombatSalle implements Salle{

	@Override
	public void entrer(Combattant combattant) {
		Monde.combatGroupeRandom(combattant);
	}

}
