package fr.personnage;

public interface Combattant {
	
	/**
	 * Le combattant attaque un autre.
	 * @param adversaire Le combattant a attaquer
	 */
	public void attaquer(Combattant adversaire);
	
	/**
	 * Le combattant encaisse des dégats. 
	 * @param degat L'entier que subit le combattant.
	 * @return Renvoie la vie restante du combattant.
	 */
	public int defendre(int degat);
	
	public String getNom();
	public int getDegat();
	public int getPointDeVie();
	
	public void setNom(String nom);
	public void setDegat(int degat);
	public void setPointDeVie(int pointDeVie);
}
