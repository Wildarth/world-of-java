package fr.personnage;

public interface Combattant {

	
	
	public String getNom();
	
	public int getDegat();
	public int getPointDeVie();
	public int getPointDeVieMax();
	public int getLastDegat();
	
	public void setNom(String nom);
	public void setDegat(int degat);
	public void setPointDeVie(int pointDeVie);
	
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
	public Combattant defendre(int degat);
	
	/**
	 * Indique si un combattant est mort ou non.
	 * @return True si le combattant est mort, sinon False.
	 */
	public boolean estMort();
	
	/**
	 * Permet de soigner un combattant, les points de vie d'un combattant ne pourront jamais dépasser son maximum.
	 * @param soin Le montant de vie soigné.
	 */
	public void soigner(int soin);
	
	public String affichageCombatUnique();
	
}
