package fr.personnage;

public abstract class AbstractCombattant implements Combattant {

	private String nom;
	private int pointDeVie;
	private int pointDeVieMax;
	private int degat;
	
	private int lastDegat = 0;

	protected AbstractCombattant(String nom, int pointDeVie, int degat) {
		this.pointDeVie = pointDeVie;
		this.pointDeVieMax = pointDeVie;
		this.degat = degat;
		this.nom = nom;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}
	
	@Override
	public int getPointDeVieMax() {
		return this.pointDeVieMax;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getLastDegat() {
		return this.lastDegat;
	}

	public void attaquer(Combattant adversaire) {
		Combattant cible = adversaire.defendre(this.degat);
		
		System.out.println(this.getNom() + " inflige " + cible.getLastDegat() + " dégats à "
				+ cible.getNom() + " (" + cible.getPointDeVie() + " PV)");
	}

	public Combattant defendre(int degat) {
		this.lastDegat =  degat;
		this.pointDeVie -= degat;
		return this;
	}

	@Override
	public boolean estMort() {
		return this.pointDeVie <= 0;
	}
	
	@Override
	public void soigner(int soin) {
		if((soin + this.pointDeVie) < this.pointDeVieMax ) {
			this.pointDeVie += soin; 
			System.out.println(this.getNom() + " se soigne de " + soin);
		} else {
			System.out.println(this.getNom() + " se soigne de " + (this.pointDeVieMax - this.pointDeVie));
			this.pointDeVie = this.pointDeVieMax;
		}
	}
	
	public String affichageCombatUnique() {
		return this.getNom() + " " + this.getPointDeVie() + "/" + this.getPointDeVieMax() + " PV";
	}

	public String toString() {
		return this.nom + ", " + this.pointDeVieMax + " PV, " + this.degat + " ATK";
	}

}
