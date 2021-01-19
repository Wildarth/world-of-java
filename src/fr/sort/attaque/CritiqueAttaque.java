package fr.sort.attaque;

import java.util.Random;

import fr.personnage.Combattant;

public class CritiqueAttaque implements Attaque{

	private String nom;
	private String description;
	private double chanceToucher;
	private int degat;
	private double chanceCritique = 0;
	
	
	private Random random = new Random();
	

	public CritiqueAttaque(String nom, String description, double chanceToucher, int degat, double chanceCritique) {
		super();
		this.nom = nom;
		this.description = description;
		this.chanceToucher = chanceToucher;
		this.degat = degat;
		this.chanceCritique = chanceCritique;
	}

	@Override
	public void information() {
		// TODO Auto-generated method stub
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
		return chanceToucher;
	}

	@Override
	public int getDegat() {
		return degat;
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
		this.chanceToucher = chanceToucher;
	}

	@Override
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	public double getChanceCritique() {
		return chanceCritique;
	}

	@Override
	public int lancerAttaque(Combattant lanceur, Combattant cible) {
		if((random.nextDouble() * 100) < this.getChanceToucher()) {
			if(random.nextDouble() < this.chanceCritique) {
				return 2 * this.getDegat();
			} else {
				return this.getDegat();
			}
		} else {
			return 0;
		}
	}



}
