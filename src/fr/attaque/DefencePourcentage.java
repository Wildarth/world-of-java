package fr.attaque;

import fr.personnage.Combattant;

public class DefencePourcentage implements Defence {

	private double pourcentage;
	private String nom;
	private String description;

	public DefencePourcentage(double pourcentage, String nom, String description) {
		super();
		this.pourcentage = pourcentage;
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
		return (int) (degat * (1 - pourcentage));
	}

	@Override
	public String toString() {
		return "DefencePourcentage [pourcentage=" + pourcentage + ", nom=" + nom + ", description=" + description + "]";
	}
	
	

}
