package fr.personnage.groupe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.personnage.Combattant;

public class Groupe implements Combattant {
	
	private List<Combattant> combattants = new ArrayList<>();
	private List<Combattant> estMortAuCombat = new ArrayList<>();
	
	@SuppressWarnings("unused")
	private String nom;
	private int degat;
	private int pointDeVie;
	private int pointDeVieMax;
	
	private Random random = new Random();
	private int lastDegat;
	
	

	@Override
	public String getNom() {
		if(combattants.isEmpty()) {
			return "Groupe de " + estMortAuCombat.get(0).getNom();
		} else {
			return "Groupe de " + combattants.get(0).getNom();
		}
		
	}

	@Override
	public int getDegat() {
		return degat;
	}

	@Override
	public int getPointDeVie() {
		return pointDeVie;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setDegat(int degat) {
		this.degat = degat;
	}

	@Override
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public List<Combattant> getCombattants() {
		return combattants;
	}

	public void setCombattants(List<Combattant> combattants) {
		this.combattants = combattants;
	}
	
	public void addCombattant(Combattant combattant) {
		this.combattants.add(combattant);
	}
	
	public boolean estMort() {
		boolean estMort = true;
		List<Combattant> newList = new ArrayList<>(combattants);
		for (Combattant combattant : combattants) {
			if(combattant.estMort()) {
				newList.remove(combattant);
				estMortAuCombat.add(combattant);
			}else {
				estMort = false;
			}
		}
		combattants = newList;
		return estMort;
	}

	/**
	 * Attaque avec un combattant aléatoire du groupe.
	 */
	@Override
	public void attaquer(Combattant adversaire) {
		combattants.get(random.nextInt(combattants.size())).attaquer(adversaire);	
	}

	/**
	 * Un combattant aléatoire du groupe encaisse le coup.
	 */
	@Override
	public Combattant defendre(int degat) {
		return combattants.get(random.nextInt(combattants.size())).defendre(degat);
	}

	@Override
	public int getPointDeVieMax() {
		return pointDeVieMax;
	}

	@Override
	public void soigner(int soin) {
		for (Combattant combattant : combattants) {
			combattant.soigner(soin);
		}
	}

	@Override
	public int getLastDegat() {
		return lastDegat;
	}
	
}
