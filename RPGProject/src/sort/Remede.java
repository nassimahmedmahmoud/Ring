package sort;
import capacite.*;
import combattant.*;
/**
 * Remede r�presente les rem�des dans le jeu.Elle h�rite de Sort.
 *
 */
public class Remede extends Sort{
	
    /**
     * Constructeur champs � champs de Remede.
     * 
     * @param facilite
     * 				La facilite du remede.
     * @param efficacite
     * 				L'efficacite du remede.
     * @param description
     * 				La description du remede.
     */
	public Remede(int facilite, int efficacite,
                  String description) {
		super(facilite, efficacite, description);
	}
	
	/**
	 * Constructeur par d�faut de Remede.
	 */
	public Remede() {
		super();
		this.description();
		this.nom();
	}
	/**
	 * Calcule la r�ussite  du rem�de.
	 * 
	 *@return  true si l'utilisation du rem�de reussie, false sinon. 
	 */
	public boolean reussite(Combattant joueur) {
		int pro=(int)((joueur.getDexterite()*this.getFacilite())/100);
		return Math.random()<=pro;
	}
    
	/**
	 * Modifie la description du rem�de par "Attention c'est de l'auto-medication".
	 */
	public void description() {
		this.setDescription("Attention c'est de l'auto-medication");
	}
	
	/**
	 * Calcule l'efficacite du rem�de.
	 * 
	 * @return L'efficacite du rem�de sous forme d'un entier.
	 */
	public int efficacite(Combattant joueur){
		return ((joueur.getDexterite()* this.getEfficacite())/100);
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
	 * Retourne l'etat du rem�de.
	 * 
	 * @return L'etat du rem�de sous forme d'une chaine de caract�res.
	 */
	public String toString(){
		String s = "Remede : ";
		s=s+super.toString();
		return s;
	}
	
	/**
	 * Retourne la cat�gorie auquel appartient le rem�de.
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	
	/**
	 * Modifie  le nom par "Remede".
	 * 
	 */
	public void nom(){
		this.setNom("Remede");
	}
}