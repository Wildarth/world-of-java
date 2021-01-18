package fr.utilitaire;

import java.util.Scanner;

public class Tool {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 
	 * @param message le message a envoy� � l'utilisateur
	 * @return le message envoy� par l'utilisateur en r�ponse � notre message 
	 */
	public static String demanderString(String message) {

		System.out.println(message);	
		String retour = sc.next();

		return retour;
	}
	
	public static int demanderInt(String message) {

		System.out.println(message);	
		int retour = sc.nextInt();

		return retour;
	}
	

}
