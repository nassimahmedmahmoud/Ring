package cac;

import java.util.Scanner;

import capacite.*;
import combattant.*;

/**
 * Bouclier represente un bouclier dans le jeu.Elle h�rite de CorpsACorps.
 *
 */
public class Bouclier extends CorpsACorps{
    /**
     * Constructeur champs � champs de Bouclier.
     * 
     * @param impact
     * 				L'impact du bouclier.
     * @param parade
     * 				La parade du bouclier.
     * @param maniabilite
     * 				La maniabilite du bouclier.
     * @param protection
     * 				La protection du bouclier.
     */
	public Bouclier(int impact, int parade, int maniabilite, int protection) {
		super(impact, parade, maniabilite, protection,"Bouclier");
	}
	
	/**
	 * Constructeur par d�faut de Bouclier.
	 */
	public Bouclier() {
		super();
		this.description();
		this.nom();
	}
	
	/**
	 * Verifie que l'action est une parade et effectue la parade si oui.
	 * 
	 * @return true si l'action est une parade, false sinon 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.PARADE){
			this.capacite(joueur);
			return true;
		}
		else
			return false;
	}
    /**
     * Calcule l'Impact  du bouclier.
     * 
     * @param joueur
     * 				Le combattant poss�dant le bouclier.
     * @return L"Impact sous forme d'entier.
     */
	public int efficacite(Combattant joueur){
		return ((joueur.getForcePhysique()* this.getProtection())/100);
	}
	
	/**
	 * Modifie la description par "Son efficacit�e est divis�e par 3  si l'attaque est un sortil�ge ".
	 */
	public void description(){
		this.setDescription("Son efficacité est divisé par 3 si l'attaque est un sortilège ");
	}
    /**
     * Retourne l'etat du bouclier.
     * 
     * @return L'etat du bouclier sous forme d'une chaine de caract�res.
     */
	public String toString(){
		String s = "Bouclier :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Utilisation du bouclier.
	 * @param joueur
	 * 			Le combattant poss�dant le bouclier.
	 * @return La reduction du bouclier sous forme d'entier si l'utilisation du bouclier r�ussie, 0 sinon
	 */
	public int capacite(Combattant joueur){
		if(this.reussite(joueur)){
			return this.efficacite(joueur);
		}
		return 0;
	}
	/**
	 * <b>Verifie si la contrainte li�e aux boucliers est respect�e.</b>
	 * <b>protection et maniabilite <=20 et protection + maniabilite <=100.
	 * @return true si la contrainte est respect�, false sinon.
	 */
	public boolean caracteristique(){
		if(this.getProtection()+this.getManiabilite()<=100 && this.getManiabilite()>=20 && this.getProtection()>=20){
			return true;
		}
		return false;
	}
	/**
	 * Retourne le nombre de categories auquel le bouclier appartient.
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	/**
	 * Modifier le nom par " Bouclier".
	 */
	public void nom(){
		this.setNom("Bouclier");
	}
}