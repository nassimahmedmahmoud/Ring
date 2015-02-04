package combattant;
import java.util.*;

/**
 * Le guerrier est un combattant ax� sur la force physique et la dext�rit�.
 * <p>
 *La classe Guerrier herite de Combattant cependant elle a des contraintes sp�cifiques en plus des contraintes de Combattant
 *concernant la forcePhysique, l'intelligence, la dexterit� et la concentration.
 *</p>
 */
public class Guerrier extends Combattant{
    
	/**
	 * Constructeur de Guerrier.
	 * 
	 * @param nom
	 * 			Le nom du Guerrier.
	 */
	public Guerrier(String nom) {
		super(nom);
	}
	
	/**
	 * Constructeur par d�faut de Guerrier.
	 * 
	 */
	public Guerrier(){
		super();
	}
	/**
	 * Permet de verifier si la contraintes li�e aux combattants est  respect�es plus la contrainte sp�cifique aux guerriers.
	 * <p>
	 * La contrainte des guerriers est : la forcePhysique est sup�rieure ou �gale � la dexterite +10 et la dexterite est sup�rieure ou �gale � l'intelligence et l'intelligence +10 est sup�rieure ou �gale � la concentration.
	 * </p>   
	 * @return true si la contrainte des  combattants et la contrainte des guerriers sont respect�es, false sinon.
	 */
	public boolean caracteristique(){
		if(super.caracteristique()){
			if(this.getForcePhysique()>=this.getDexterite()+10 && this.getDexterite()>=this.getIntelligence() && this.getIntelligence()+10>=this.getConcentration())
				return true;
		}
		return false;
	}
}
