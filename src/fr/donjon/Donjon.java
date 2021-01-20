package fr.donjon;

import java.util.ArrayList;
import java.util.List;

import fr.donjon.salle.Salle;
import fr.personnage.Combattant;

public class Donjon {

	private String nom;
	private String definition;
	private List<Salle> salles = new ArrayList<>();

	public Donjon(String nom, String definition) {
		super();
		this.nom = nom;
		this.definition = definition;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public void entrer(Combattant combattant) {
		int numeroSalle = 1;

		for (Salle salle : salles) {

			if (combattant.estMort()) {
				System.out.println("ECHEC - Fin du donjon");
				return;
			}

			System.out.println("Salle numero " + numeroSalle++ + " du donjon.");

			salle.entrer(combattant);
		}
		if (combattant.estMort()) {
			System.out.println("ECHEC - Fin du donjon");
		} else {
			System.out.println("VICTOIRE - Fin du donjon");
		}
	}

	public void ajouterSalle(Salle salle) {
		salles.add(salle);
	}

}
