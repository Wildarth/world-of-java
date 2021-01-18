package fr.personnage.groupe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.personnage.Combattant;

public class Groupe implements Combattant {
	
	private List<Combattant> combattants = new ArrayList<>();
	private String nom;
	private int degat;
	private int pointDeVie;
	
	private Random random = new Random();

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public int getDegat() {
		return degat;
	}

	@Override
	public int getPointDeVie() {
		return pointDeVie;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setDegat(int degat) {
		this.degat = degat;
	}

	@Override
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public List<Combattant> getCombattants() {
		return combattants;
	}

	public void setCombattants(List<Combattant> combattants) {
		this.combattants = combattants;
	}
	
	public void addCombattant(Combattant combattant) {
		this.combattants.add(combattant);
	}
	
	public boolean estMort() {
		boolean estMort = true;
		for (Combattant combattant : combattants) {
			estMort &= combattant.estMort();
		}
		return estMort;
	}

	/**
	 * Attaque avec un combattant aléatoire du groupe.
	 */
	@Override
	public void attaquer(Combattant adversaire) {
		combattants.get(random.nextInt(combattants.size())).attaquer(adversaire);
	}

	/**
	 * Un combattant aléatoire du groupe encaisse le coup.
	 */
	@Override
	public int defendre(int degat) {
		return combattants.get(random.nextInt(combattants.size())).defendre(degat);
	}
	
}
