package fr.utilitaire;

import java.util.Scanner;

public class Tool {
	
	/**
	 * 
	 * @param message le message a envoy� � l'utilisateur
	 * @return le message envoy� par l'utilisateur en r�ponse � notre message 
	 */
	public static String demanderString(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);	
		String retour = sc.next();
		//sc.close();
		return retour;
	}
	

}
