package combattant;

import java.util.*;

/**
 * L'Athl�te est un combattant polyvalent.
 *<p> 
 *La classe Athlete herite de Combattant cependant elle a des contraintes sp�cifiques en plus des contraintes de Combattant
 *concernant la forcePhysique, l'intelligence, la dexterit� et la concentration.
 * </p>
 *
 */
public class Athlete extends Combattant {
    
	public static final int CONTRAINTE = 20;
	
	/**
	 * Constructeur d'Athlete.
	 * 
	 * @param nom
	 * 			Le nom de l'athl�te.
	 */
	public Athlete(String nom) {
		super(nom);
	}
	
	/**
	 * Constructeur par d�faut.
	 */
	public Athlete(){
		super();
	}
	
	/**
	 * Permet de verifier si les contraintes li�es � l'ahl�te  sont respect�es
	 * 
	 * @return true si la contrainte g�n�ral � tout les combattants et la contrainte sp�cifique aux athl�tes (la forcePhysique, la dexterit�, l'intelligence et la concentration doivent �tre sup�rieures ou �gales � 20) sont respect�es.
	 * 
	 */
	public boolean caracteristique(){
		if(super.caracteristique()){
			if(this.getForcePhysique()>=Athlete.CONTRAINTE && this.getDexterite()>=Athlete.CONTRAINTE && this.getIntelligence()>=Athlete.CONTRAINTE && this.getConcentration()>=Athlete.CONTRAINTE)
				return true;
		}
		return false;
	}
}
