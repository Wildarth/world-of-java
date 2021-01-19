package fr.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.sort.attaque.Attaque;
import fr.sort.defence.Defence;

public class Classe {

	private String nom;
	private List<Attaque> attaques = new ArrayList<>();
	
	private List<Defence> defences = new ArrayList<>();

	private Random random = new Random();

	public Classe(String nom, List<Attaque> attaques, List<Defence> defences) {
		super();
		this.nom = nom;
		this.attaques = attaques;
		this.defences = defences;
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
	
	/**
	 * Récupère une defence parmis les defences de la classe.
	 * 
	 * @return Renvoie une defence sélectionné aléatoirement.
	 */
	public Defence getDefence() {
		return defences.get(random.nextInt(defences.size()));
	}
	
	@Override
	public String toString() {
		return this.nom + "\n" + attaques.toString() + "\n" + defences.toString() + "\n";
	}
}
