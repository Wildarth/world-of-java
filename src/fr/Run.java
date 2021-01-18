package fr;

import fr.monde.Monde;
import fr.personnage.Personnage;

public class Run {

	public static void main(String[] args) {
		//exercice1();
		exercice2();
		
	}
	
	private static void exercice1() {
		Personnage personnage = Monde.personnageFactory();

		System.out.println(personnage);
	}
	
	private static void exercice2() {
		Personnage personnage = Monde.personnageFactory();
		
		Monde.afficherInformations();
	}
}
