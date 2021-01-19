package fr.attaque;

import fr.personnage.Combattant;

public class DefenceFlat implements Defence {

	private int flat;
	private String nom;
	private String description;

	public DefenceFlat(int flat, String nom, String description) {
		super();
		this.flat = flat;
		this.nom = nom;
		this.description = description;
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
		if (degat - flat < 0) {
			return 0;
		} else {
			return degat - flat;
		}
	}

	@Override
	public String toString() {
		return "DefenceFlat [flat=" + flat + ", nom=" + nom + ", description=" + description + "]";
	}
	
	

}
