package sort;
import capacite.*;
import combattant.Combattant;

/**
 * SortilegeGuerisseur r�presente tous les sortil�ges guerisseurs du jeu.Elle h�rite de Sort.
 *
 */
public class SortilegeGuerisseur extends Sort {
    
	/**
	 * Constructeur champs � champs de SortilegeGuerisseur.
	 * 
	 * @param facilite
	 * 				La facilite du sortil�ge guerisseur.
	 * @param efficacite
	 * 				L'efficacite du sortil�ge guerisseur.
	 * @param description
	 * 				La description du sortil�ge gurisseur.
	 */
	public SortilegeGuerisseur(int facilite, int efficacite, String description) {
		super(facilite, efficacite, description);
	}
	
	/**
	 * Constructeur par d�faut de SortilegeGuerisseur.
	 */
	public SortilegeGuerisseur() {
		super();
		this.description();
		this.nom();
	}
	
	/**
	 * Retourne La cat�gorie auquel appartient sortil�ge guerisseur.
	 * 
	 * @return La cat�gorie soin  sous forme d'une chaine de caract�res.
	 */
	public String categorie() {
		return "Categorie : "+Capacite.SOIN+"-"+Capacite.Categorie[Capacite.SOIN];
	}
    
	/**
	 * Modifie la description par "C'est le rem�de des magiciens".
	 */
	public void description(){
		this.setDescription("C'est le remède des magiciens ");
	}
    /**
     * Retourne l'etat du sortilege guerisseur.
     * 
     * @return L'etat du sortil�ge guerisseur  sous forme d'une chaine de caract�res.
     */
	public String toString(){
		String s = "Sortilege guerisseur :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Retourne le nombre de cat�gorie auquel appartient le sortil�ge guerisseur".
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}

	/**
	 * Verifie si le coup appartient � soin.
	 *
	 * @return  true  si la categorie est soin, false sinon.
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.SOIN){
			this.capacite(categorie,joueur);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Modifie le nom du sortil�ge guerisseur par "Sortil�ge Guerisseur".
	 * 
	 */
	public void nom(){
		this.setNom("Sortilège Guerisseur");
	}
}