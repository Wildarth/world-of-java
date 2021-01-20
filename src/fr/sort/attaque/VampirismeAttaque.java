package fr.sort.attaque;

import java.util.Random;

import fr.personnage.Combattant;

public class VampirismeAttaque implements Attaque {

	private String nom;
	private String description;
	private double chanceToucher;
	private int degat;
	private double coefHeal = 0;

	private Random random = new Random();

	public VampirismeAttaque(String nom, String description, double chanceToucher, int degat, double coefHeal) {
		super();
		this.nom = nom;
		this.description = description;
		this.chanceToucher = chanceToucher;
		this.degat = degat;
		this.coefHeal = coefHeal;
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

	@Override
	public int lancerAttaque(Combattant lanceur, Combattant cible) {
		if ((random.nextDouble() * 100) < this.getChanceToucher()) {
			lanceur.soigner((int) (getDegat() * coefHeal));
			return this.getDegat();
		} else {
			return 0;
		}
	}

}
