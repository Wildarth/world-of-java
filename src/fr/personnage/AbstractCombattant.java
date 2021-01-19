package fr.personnage;

public abstract class AbstractCombattant implements Combattant {

	private String nom;
	private int pointDeVie;
	private int degat;

	protected AbstractCombattant(String nom, int pointDeVie, int degat) {
		this.pointDeVie = pointDeVie;
		this.degat = degat;
		this.nom = nom;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
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

	public void attaquer(Combattant adversaire) {
		Combattant cible = adversaire.defendre(this.degat);
		
		System.out.println(this.getNom() + " inflige " + this.getDegat() + " dégats à "
				+ cible.getNom() + " (" + cible.getPointDeVie() + " PV)");
	}

	public Combattant defendre(int degat) {
		this.pointDeVie -= degat;
		return this;
	}

	@Override
	public boolean estMort() {
		return this.pointDeVie <= 0;
	}

	public String toString() {
		return "nom:[" + this.nom + "], pointDeVie:[" + this.pointDeVie + "], attaque:[" + this.degat + "]";
	}

}
