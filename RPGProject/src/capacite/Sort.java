package capacite;

import java.io.Serializable;
import java.util.*;

import combattant.*;

/**
 * La class Sort repr�sente tous les sort du jeu.
 * <p>
 * Un sort est d�fini par :
 * <ul>
 * <li>Une description du sort</li>
 * <li><p>Un nom et des caract�ristiques  facilite et efficacite  d�finies par l'utilisateur lors de la creations du sort.</p></li>
 *</ul>
 */
public class Sort implements Capacite, Serializable {
    
	private int facilite;
	private int efficacite;
	private String description;
	private String nom;
	/**
	 * Constructeur champs � champs de Sort.
	 * 
	 * @param facilite
	 * 				La facilite de Sort.
	 * @param efficacite
	 * 				L'efficacite de Sort.
	 * @param description
	 * 				La description de Sort.
	 */
	public Sort(int facilite, int efficacite,
                String description) {
		super();
		this.facilite = facilite;
		this.efficacite = efficacite;
		this.description = description;
	}
    
	/**
	 * Constructeur par d�faut de Sort.
	 */
	public Sort() {
		this(0, 0, "Sort");
	}
    
	public boolean categorie(int categorie,Combattant joueur) {
		return false;
	}
    /**
     * Retourne l'etat du sort sous forme d'une chaine de caract�res.
     * 
     */
	public String toString() {
		return "Sort [facilite=" + facilite + ", efficacite=" + efficacite
        + ", description=" + description + "]";
	}
    
	/**
	 * Retourne la facilite du sort.
	 * 
	 * @return La facilite de Sort sous forme d'entier.
	 */
	public int getFacilite() {
		return facilite;
	}
    /**
     * Met � jour facilite du sort.
     * 
     * @param facilite
     * 				La nouvelle facilite du sort.
     */
	public void setFacilite(int facilite) {
		this.facilite = facilite;
	}
    
	/**
	 * Retourne une description du sort sous forme d'une chaine de caract�res.
	 */
	public String getDescription() {
		return description;
	}
    
	/**
	 * Met � jour la description du sort.
	 * 
	 * @param description
	 * 					La nouvelle description du sort.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
    
	/**
	 * Retourne l'efficacite du sort.
	 * 
	 * @return L'efficacite sous forme d'entier.
	 */
	public int getEfficacite() {
		return efficacite;
	}
    
	/**
	 * Met � jour l'efficacite du sort.
	 * 
	 * @param efficacite
	 * 					La nouvelle efficacite du sort.
	 */
	public void setEfficacite(int efficacite) {
		this.efficacite = efficacite;
	}
    
	/**
	 * Calcule la probabilite de r�ussite du sort.
	 * @return true si le sort r�ussi, false sinon.
	 */
	public boolean reussite(Combattant joueur) {
		int pro=(int)((joueur.getConcentration()*this.facilite)/1000);
		return Math.random()<=pro;
	}
    
	/**
	 * Modifie la description du sort par :"arme de type magie ou de type soin ...");
	 */
	public void description() {
		this.setDescription("arme de type magie ou de type soin ... ");
	}
    
	/**
	 * Retourne la puissance du sort.
	 * 
	 * @param joueur
	 * 			Le combattant poss�dant le sort.
	 * @return Un entier correspondant � la puissance du sort.
	 */
	public int efficacite(Combattant joueur) {
		return ((joueur.getIntelligence() * this.getEfficacite()) / 100);
	}
    
	/**
	 * Utilisation du sort.
	 * @return La puissance du sort si il a reussi, 0 sinon.
	 */
	public int capacite(int coup,Combattant joueur) {
		if (this.reussite(joueur)) {
			return this.efficacite(joueur);
		}
		return 0;
	}
    /**
     * <b>Verifie si la contrainte li�e aux sort est respect�.</b>
     * <b>La contrainte li�e au sort est : facilite et efficacite >=20,facilite + efficacite <=100.</b>
     * @return true si la contrainte est respect�e, false sinon.
     */
	public boolean caracteristique() {
		if (this.facilite + this.efficacite <= 100
            && (this.facilite >= 20 && this.efficacite >= 20)) {
			return true;
		}
		return false;
	}
    
	/**
	 * Retourne le nom du sort.
	 * 
	 * @return Le nom du sort sous forme d'une chaine de caract�res.
	 *
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * Met a jour le nom du sort.
	 * @param nom
	 * 			Le nouveau nom du sort.
	 */
	public void setNom(String nom){
		this.nom=nom;
	}
	/**
	 * Modifie le nom de sort par "Sort".
	 */
	public void nom(){
		this.nom="Sort";
	}
	
}
