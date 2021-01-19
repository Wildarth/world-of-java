package fr;

import fr.monde.Monde;
import fr.personnage.Personnage;

public class Run {

	public static void main(String[] args) {
		
		Monde.initialiseMonde();
		
		//exercice1();
		//exercice2();
		//exercice4();

		
		//Monde.afficherInformations();
		
		Monde.genese();
		
		
	}
	
	@SuppressWarnings("unused")
	private static void exercice1() {
		Personnage personnage = Monde.personnageFactory();

		System.out.println(personnage);
	}
	
	@SuppressWarnings("unused")
	private static void exercice2() {
		Personnage personnage = Monde.personnageFactory();
		
		Monde.afficherInformations();
	}
	
	@SuppressWarnings("unused")
	private static void exercice4() {
		Monde.combat(Monde.personnageFactory(), Monde.monstreFactory());
	}
}
