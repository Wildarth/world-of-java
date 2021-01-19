package fr.attaque;

import java.util.Random;

import fr.personnage.Combattant;

public class BasicAttaque implements Attaque{
	
	private String nom;
	private int degat;
	private String description;
	private double chanceToucher;
	
	Random random = new Random();

	
	
	public BasicAttaque(String nom, int degat, String description, double chanceToucher) {
		super();
		this.nom = nom;
		this.degat = degat;
		this.description = description;
		this.chanceToucher = chanceToucher;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double getChanceToucher() {
		return this.chanceToucher;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setChanceToucher(double chanceToucher) {
		if(chanceToucher >= 0 && chanceToucher <= 100) 
			this.chanceToucher = chanceToucher;
	}
	
	@Override
	public int getDegat() {
		return this.degat;
	}

	@Override
	public void setDegat(int degat) {
		this.degat = degat;
	}

	@Override
	public int lancerAttaque(Combattant lanceur, Combattant cible) {
		if((random.nextDouble() * 100) < this.getChanceToucher()) {
			return this.getDegat();
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "BasicAttaque [nom=" + nom + ", degat=" + degat + ", description=" + description + ", chanceToucher="
				+ chanceToucher + "]\n";
	}

	

}
