package sort;
import capacite.*;
import combattant.Combattant;

/**
 * SortilegeDefensif repr�sente tous les sortil�ges d�fensifs du jeu.Elle h�rite de Sort.
 *
 */
public class SortilegeDefensif extends Sort {
    /**
     * Constructeur champs � champs de SortilegeDefensif.
     * 
     * @param facilite
     * 				La facilite du sortil�ge d�fensif
     * @param efficacite
     * 				L'efficacite du sortil�ge d�fensif.
     * @param description
     * 				La description du sortil�ge d�fensif.
     */
	public SortilegeDefensif(int facilite, int efficacite, String description) {
		super(facilite, efficacite, description);
	}
    
	/**
	 * Constructeur par d�faut de SortilegeDefensif.
	 */
	public SortilegeDefensif() {
		super();
		this.description();
		this.nom();
	}
    /**
     * Retourne l'etat du sortil�ge d�fensif.
     * 
     * @return L'etat du sortil�ge d�fensif sous forme d'une chaine de caract�res.
     */
	public String toString(){
		String s = "Sortilege defensif : ";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Retourne la cat�gorie auquel appartient  le sortil�ge d�fensif.
	 * 
	 * @return La cat�gorie auquel appartien le sortil�ge d�fensif sous forme d'une chaine de caract�res.
	 */
	public String categorie() {
		return "Categorie : "+Capacite.PARADE+"-"+Capacite.Categorie[Capacite.PARADE];
	}
    
    /**
     * Modifie la description du sortil�ge d�fensif par "Bouclier des attaques magiques,son efficacit�e est divis�e par 3 si l'lattaque ne l'est pas ".
     */
	public void description(){
		this.setDescription("Bouclier des attaques magiques, son efficacité est divisée par 3 si l'attaque ne l'est pas ");
	}
	
	/**
	 * Retourne le nombre de cat�gories auquel appartient le sortil�ge d�fensif.
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	
	/**
	 * Verifie que l'action est une parade et effectue la parade si oui.
	 * 
	 * @return true si l'action est une parade, false sinon 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.PARADE){
			joueur.parade(this.capacite(categorie,joueur));
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Modifie le nom par "Sortil�ge Defensif"	 
	 */
	public void nom(){
		this.setNom("Sortilège Defensif");
	}
}