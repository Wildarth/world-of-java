package fr.personnage;

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
		adversaire.defendre(this.classe.getAttaque().lancerAttaque(this, adversaire));
	}
}
