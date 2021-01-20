package fr.utilitaire;

import java.util.Scanner;

public class Tool {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Affiche un message � l'utilisateur et attend qu'il saisisse un message en
	 * r�ponse.
	 * 
	 * @param message Le message a envoy� � l'utilisateur.
	 * @return Le message envoy� par l'utilisateur en r�ponse � notre message.
	 */
	public static String demanderString(String message) {
		System.out.println(message);
		String retour = sc.next();
		return retour;
	}

	/**
	 * Affiche un message � l'utilisateur et attend qu'il saisisse un entier en
	 * r�ponse.
	 * 
	 * @param message Le message a envoy� � l'utilisateur.
	 * @return L'entier envoy� par l'utilisateur en r�ponse � notre message.
	 */
	public static int demanderInt(String message) {

		System.out.println(message);
		int retour = sc.nextInt();

		return retour;
	}

}
