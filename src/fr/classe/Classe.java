package fr.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.attaque.Attaque;

public class Classe {

	private String nom;
	private List<Attaque> attaques = new ArrayList<>();

	private Random random = new Random();

	public Classe(String nom, List<Attaque> attaques) {
		super();
		this.nom = nom;
		this.attaques = attaques;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Attaque> getAttaques() {
		return attaques;
	}

	public void setAttaques(List<Attaque> attaques) {
		this.attaques = attaques;
	}

	/**
	 * Récupère une attaque parmis les attaques de la classe.
	 * 
	 * @return Renvoie une attaque sélectionné aléatoirement.
	 */
	public Attaque getAttaque() {
		return attaques.get(random.nextInt(attaques.size()));
	}
}
