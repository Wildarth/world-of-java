package fr.utilitaire;

import java.util.Scanner;

public class Tool {
	
	/**
	 * 
	 * @param message le message a envoyé à l'utilisateur
	 * @return le message envoyé par l'utilisateur en réponse à notre message 
	 */
	public static String demanderString(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);	
		String retour = sc.next();
		//sc.close();
		return retour;
	}
	

}
