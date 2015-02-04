package sort;
import capacite.*;
import combattant.Combattant;

/**
 * 
 *SortilegeOffensif repr�sente tous les sortil�ges offensifs du jeu.Elle h�rite de Sort.
 *
 */
public class SortilegeOffensif extends Sort{
    
	/**
	 * Consctructeur champs � champs.
	 * 
	 * @param facilite
	 * 				La facilite du sortil�ge offensif.
	 * @param efficacite
	 * 				L'efficacite du sortil�ge offensif.
	 * @param description
	 * 				La description de sortil�ge offensif.
	 */
	public SortilegeOffensif(int facilite, int efficacite, String description) {
		super(facilite, efficacite, description);
	}
    
	/**
	 * Constructeur par d�faut de SortilegeOffensif.
	 */
	public SortilegeOffensif() {
		super();
		this.description();
		this.nom();
	}
	
	/**
	 * Retourne le nombre de cat�gories auquel appartien le sortil�ge offensif
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	
	/**
	 * Retourne la cat�gorie auquel appartient le sortil�ge offensif.
	 * 
	 * @return La categorie attaque sous forme d'une chaine de caract�res.
	 */
	public String categorie(){
		return "Categorie : "+Capacite.ATTAQUE+"-"+Capacite.Categorie[Capacite.ATTAQUE];
	}
	
	/**
	 * Modife la description par "C'est l'arme des magiciens".
	 */
	public void description(){
		this.setDescription("C'est l'arme des magiciens ");
	}
    
	/**
	 * Retourne l'etat du sortilege offensif.
	 * 
	 * @return L'etat du sortil�ge offensif sous forme d'une chaine de caract�res.
	 */
	public String toString(){
		String s = "Sortilege offensif :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Verifie que l'action est une attaque et effectue l'attaque si oui.
	 * 
	 * @return true si l'action est une attaque, false sinon 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.ATTAQUE){
			this.capacite(categorie,joueur);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Modifie le nom du sortil�ge offensif par "Sortil�ge Offensif".
	 */
	public void nom(){
		this.setNom("Sortilège Offensif");
	}
}