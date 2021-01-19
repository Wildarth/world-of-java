package fr.sort.defence;

import fr.personnage.Combattant;

public class AbsorbeDefence implements Defence {

	private double coefDegat;
	private double coefHeal;
	private String nom;
	private String description;

	public AbsorbeDefence(double coefDegat, double coefHeal, String nom, String description) {
		super();
		this.coefDegat = coefDegat;
		this.coefHeal = coefHeal;
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

		defenceur.soigner((int) (degat * coefHeal));

		return (int) (degat * coefDegat);
	}

	@Override
	public String toString() {
		return "AbsorbeDefence [coefDegat=" + coefDegat + ", coefHeal=" + coefHeal + ", nom=" + nom + ", description="
				+ description + "]";
	}
	
	

}
