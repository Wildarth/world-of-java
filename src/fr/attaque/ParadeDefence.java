package fr.attaque;

import java.util.Random;

import fr.personnage.Combattant;

public class ParadeDefence implements Defence {

	private double parade;
	private String nom;
	private String description;
	private Random  random = new Random();

	public ParadeDefence(double parade, String nom, String description) {
		super();
		this.parade = parade;
		this.nom = nom;
		this.description = description;
	}

	public double getParade() {
		return parade;
	}

	public void setParade(double parade) {
		if (parade >= 0 && parade <= 1)
			this.parade = parade;
	}

	
	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public String getDescription() {
		return description;
	}


	@Override
	public void information() {
		// TODO Auto-generated method stub

	}

	@Override
	public int defence(int degat, Combattant defenceur) {		
		if(random.nextDouble() <= parade) {
			return 0;
		} else {
			return degat;
		}
	}

	@Override
	public String toString() {
		return "ParadeDefence [parade=" + parade + ", nom=" + nom + ", description=" + description + "]";
	}
	
	

}
