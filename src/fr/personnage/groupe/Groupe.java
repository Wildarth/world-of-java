package fr.personnage.groupe;

import java.util.ArrayList;
import java.util.List;

import fr.personnage.Combattant;

public class Groupe implements Combattant {
	
	private List<Combattant> combattants = new ArrayList<>();
	private String nom;
	private int degat;
	private int pointDeVie;

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

	@Override
	public void attaquer(Combattant adversaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int defendre(int degat) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
