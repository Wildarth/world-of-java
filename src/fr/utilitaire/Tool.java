package fr.utilitaire;

import java.util.Scanner;

public class Tool {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Affiche un message à l'utilisateur et attend qu'il saisisse un message en
	 * réponse.
	 * 
	 * @param message Le message a envoyé à l'utilisateur.
	 * @return Le message envoyé par l'utilisateur en réponse à notre message.
	 */
	public static String demanderString(String message) {
		System.out.println(message);
		String retour = sc.next();
		return retour;
	}

	/**
	 * Affiche un message à l'utilisateur et attend qu'il saisisse un entier en
	 * réponse.
	 * 
	 * @param message Le message a envoyé à l'utilisateur.
	 * @return L'entier envoyé par l'utilisateur en réponse à notre message.
	 */
	public static int demanderInt(String message) {

		System.out.println(message);
		int retour = sc.nextInt();

		return retour;
	}

}
