package fr.sort.attaque;

import fr.personnage.Combattant;
import fr.sort.Sort;

public interface Attaque extends Sort {
	
    public String getNom();
    public String getDescription();
    public double getChanceToucher();
    public int getDegat();
    
    public void setNom(String nom);
    public void setDescription(String description);
    public void setDegat(int degat);
    
    /**
     * Défini la chance de toucher de l'attaque
     * @param chanceToucher Est un double compris entre 0 et 100
     */
    public void setChanceToucher(double chanceToucher);
    
    
    /**
     * Génère un nombre aléatoire compris entre 0 et 100, si celui ci est inférieur au chance de toucher
     * on retourne les degats du lanceur, sinon on renvoie 0.
     * @param lanceur
     * @param cible
     * @return Les degats du lanceur ou 0 en cas d'échec.
     */
    public int lancerAttaque(Combattant lanceur, Combattant cible);

    @Override
    String toString();
}
