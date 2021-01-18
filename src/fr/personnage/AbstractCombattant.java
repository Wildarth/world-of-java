package fr.personnage;

public abstract class AbstractCombattant {
	
	public String nom;
    public int pointDeVie;
    public int degat;

    public AbstractCombattant(String nom, int pointDeVie, int degat) {
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
    
    public String toString()
    {
    	return "nom:["+ this.nom+ "], pointDeVie:[" + this.pointDeVie + "], attaque:[" + this.degat + "]";
    }
    
}
