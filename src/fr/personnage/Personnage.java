package fr.personnage;

import fr.attaque.Attaque;
import fr.classe.Classe;

public class Personnage extends AbstractCombattant {

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
		
		Attaque attaque = this.classe.getAttaque();
		int degat = attaque.lancerAttaque(this, adversaire);
		Combattant cible = adversaire.defendre(degat);
		
		
		if (degat == 0) {
			System.out.println(this.getNom() + " rate " + attaque.getNom());
		} else {

			System.out.println(this.getNom() + " utilise " + attaque.getNom() + " et inflige " + this.getDegat()
					+ " dégats à " + cible.getNom() + " (" + cible.getPointDeVie() + " PV)") ;
		}
	}
}
