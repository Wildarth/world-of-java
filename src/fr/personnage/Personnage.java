package fr.personnage;

import fr.attaque.Attaque;
import fr.classe.Classe;

public class Personnage extends AbstractCombattant{	
	
	private Classe classe;
	
	public Personnage(String nom, int pointDeVie, int degat, Classe classe) {
		super(nom, pointDeVie, degat);
		this.classe = classe;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	
	@Override
	public void attaquer(Combattant adversaire) {
		System.out.println(this.getNom() + " attaque " + adversaire.getNom());
		
		Attaque attaque = classe.getAttaque();
		int degat = attaque.lancerAttaque(this, adversaire);
		
		System.out.println(adversaire.getNom() + " : " + adversaire.getPointDeVie() + " -(" + degat + ") -> "
				+ (adversaire.defendre(degat)));
		
	}
}
