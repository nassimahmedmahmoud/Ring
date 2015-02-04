package cac;

import java.util.Scanner;

import capacite.*;
import combattant.*;
/**
 * Epee represente une �pee dans le jeu.Elle h�rite de CorpsACorps.
 *
 */
public class Epee extends CorpsACorps {
	
	/**
	 * Constructeur champs � champs d'Epee.
	 * 
	 * @param impact
	 * 				L' impact d'Epee.
	 * @param parade
	 * 				La parade d'Epee.
	 * @param maniabilite
	 * 				La maniabilite d'Epee.
	 * @param protection
	 * 				La protection d'Epee.
	 */
	public Epee(int impact, int parade, int maniabilite, int protection) {
		super(impact, parade, maniabilite, protection,"Epee");
	}
	/**
	 * Constructeur par d�faut d'Epee.
	 */
	public Epee() {
		super();
		this.description();
		this.nom();
	}
	/**
	 * Retourne le nombre de cat�gories auquel l'�p�e appartient.
	 * 
	 * @return 2.
	 */
	public int nbCategorie(){
		return 2;
	}
	/**
	 * Retourne les cat�gories de l'ep�e.
	 * 
	 * @return Les cat�gories de l'ep�e sous forme d'une chaine de caract�res.
	 */
	public String categorie(){
		return "Categorie : \n"+Capacite.ATTAQUE+"-"+Capacite.Categorie[Capacite.ATTAQUE]+"\n"+Capacite.PARADE+"-"+Capacite.Categorie[Capacite.PARADE];
	}
	/**
	 * Calcule l'attaque avec l'ep�e.
	 * 
	 * @param joueur
	 * 				Le combattant poss�dant l'�p�e.
	 * 
	 * @return La puissance de l'attaque sous forme d'entier.
	 */
	public int efficaciteAttaque(Combattant joueur){
		return ((joueur.getForcePhysique()* this.getImpact())/100);
	}
	/**
	 * Calcule la parade avec l'�p�e.
	 * 
	 * @param joueur
	 * 				Le combattant poss�dant l'�p�e.
	 * @return L 'efficacit� de la parade sous forme d'entier.
	 */
	public int efficaciteParade(Combattant joueur){
		return ((joueur.getForcePhysique()* this.getParade())/100);
	}
	
	/**
	 * Modifie la description de l'�p�e par"A la fois arme offensive et defensife son efficacit�e est divisi�e par 3 en cas de parade d'un sortilege".
	 */
	public void description(){
		this.setDescription("A la fois arme offensive et defensive son efficacité est divisée en par 3 en cas de parade d'un sortilege");
	}
	
	/**
	 * Retourne l'etat de l'�p�e.
	 * 
	 * @return L'�tat de l'�p�e sous forme d'une chaine de caract�res.
	 */
	public String toString(){
		String s = "Epée :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Retourne le nom de l'�p�e.
	 * 
	 * @return Le nom de l'�p�e sous forme d'une chaine de caract�res.
	 * 
	 */
	public String getNom(){
		this.setNom("Epee");
		return "Epee";
	}
	/**
	 * Utilisation de l'�p�e soit en attaque ou parade.
	 * 
	 * @return La puissance de l'attaque ou l'efficacite de la parade sous forme d'un entier,0 sinon.
	 */
	public int capacite(int coup,Combattant joueur){
		if(this.reussite(joueur)){
			if(coup==Capacite.ATTAQUE)
				return this.efficaciteAttaque(joueur);
			else if(coup==Capacite.PARADE)
				return this.efficaciteParade(joueur);
		}
		return 0;
	}
    
	/**
	 * Verifie si le coup est une attaque ou une parade et l'effectue.
	 * 
	 * @return true si le coup appartient a la categorie attaque ou parade, false sinon.
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.ATTAQUE || categorie==Capacite.PARADE){
			this.capacite(categorie,joueur);
			return true;
		}
		else
			return false;
	}
	
	/**
	 *Verifie la contrainte li�e aux �p�es.
	 *<b>La contrainte est : l'impact + la parade +la maniabilite <=100 et l'impact,la parade et la maniabilite >=20.</b> 
	 *
	 * @return true si la contrainte est respect�e, false sinon.
	 */
	public boolean caracteristique(){
		if(this.getImpact()+this.getParade()+this.getManiabilite()<=100 && this.getImpact()>=20 && this.getParade()>=20 && this.getManiabilite()>=20){
			return true;
		}
		return false;
	}
	/**
	 * Modifie le nom par "Ep�e".
	 */
	public void nom(){
		this.setNom("Epée");
	}
}
