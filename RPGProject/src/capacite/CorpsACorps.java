package capacite;

import java.io.Serializable;

import combattant.Combattant;
/**
 *CorpsACorps est la classe repr�sentant toutes les capacit�s de corps � corps du jeu.Elle impl�mente l'interface Capacite.
 *<p>
 *Une capacit� de corps � corps est caract�ris� par :
 *<ul>
 *<li>Une description de la capacit� de corps � corps.</li>
 *<li><p>Un nom et des caract�ristiques d�finis par l'utilisateur lors de la cr�ation de la capacit�.</p></li>
 *</p>
 */
public class CorpsACorps implements Capacite, Serializable {
    
	private int impact;
	private int parade;
	private int maniabilite;
	private int protection;
	private String description;
	private String nom;
    
	/**
	 * Constructeur champs � champs de CorpsACorps.
	 * 
	 * @param impact
	 * 				l'impact de la capacit� de corps � corps.
	 * @param parade
	 * 				La parade de la capacit� de corps � corps.
	 * @param maniabilite
	 * 				La maniabilite de la capacit� de corps � corps.
	 * @param protection
	 *				La protection de la capacit� de corps � corps.
	 * @param nom
	 * 			Le nom de la capacit� de corps � corps.
	 */
	public CorpsACorps(int impact, int parade, int maniabilite, int protection, String nom) {
		this.impact = impact;
		this.parade = parade;
		this.maniabilite = maniabilite;
		this.protection = protection;
		this.setNom(nom);
	}
    
	/**
	 * Constructeur par d�faut de CorpsACorps.
	 */
	public CorpsACorps() {
		this.impact = 0;
		this.parade = 0;
		this.maniabilite = 0;
		this.protection = 0;
	}
    
    /**
     * Retourne l'etat de la capcit� de corps � corps sous forme d'une chaine de caract�res.
     */
	public String toString() {
		return "[nom" + nom + ", impact=" + impact + ", parade=" + parade
        + ", maniabilite=" + maniabilite + ", protection=" + protection
        + "\n[ description=" + description + "]";
	}
    
	/**
	 * Retourne la l'impact de la capacit� de corps � corps.
	 * 
	 * @return L'impact de CorpsACorps sous forme d'entier.
	 */
	public int getImpact() {
		return impact;
	}
    
	/**
	 * Met � jour l'impact de la capacit� de corps � corps.
	 * 
	 * @param impact
	 * 			Le nouveaux impact de CorpsACorps.
	 * 				
	 */
	public void setImpact(int impact) {
		this.impact = impact;
	}
    
	/**
	 * Retourne la parade de la capacit� de corps � corps.
	 * 
	 * @return La parade de CorpsACorps sous forme d'entier.
	 */
	public int getParade() {
		return parade;
	}
    
	/**
	 * Met � jour la parade de la capacit� de corps � corps.
	 * 
	 * @param parade
	 * 				La nouvelle parade de la capacit� de corps � corps.
	 */
	public void setParade(int parade) {
		this.parade = parade;
	}
    
	/**
	 * Retourne la maniabilite de la capacit� de corps � corps.
	 * 
	 * @return La maniabillite  de CorpsAcorps sous forme d'entier.
	 */
	public int getManiabilite() {
		return maniabilite;
	}
    
	/**
	 * Met � jour la maniabilite de la capacite de corps � corps. 
	 * 
	 * @param maniabilite
	 * 					La nouvelle maniabilite de CorpsACorps
	 */
	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}
    
	/**
	 * Retourne la protection de la capacit� de corps � corps.
	 * 
	 * @return La protection de CorpsACorps sous forme d'entier.
	 */
	public int getProtection() {
		return protection;
	}
    
	/**
	 * Met � jour la protection de la capacit� de corps � corps.
	 * 
	 * @param protection
	 * 					La nouvelle protection de CorpsACorps.
	 */
	public void setProtection(int protection) {
		this.protection = protection;
	}
    
	/**
	 * Retourne la description de la capacit� de corps � corps.
	 * 
	 * @return La description de CorpsACorps sous forme d'une chaine de caract�res.
	 */
	public String getDescription() {
		return description;
	}
    
	/**
	 * Met � jour la description de la capacit� de corps � corps.
	 * 
	 * @param description
	 * 					La nouvelle description de CorpsACorps
	 */
	public void setDescription(String description) {
		this.description = description;
	}
    
	/**
	 * 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		return false;
	}
    
	/**
	 * Calcule la probabilit� de r�ussite de l'action de la capacit� de corps � corps.
	 * 
	 * @return true si l'action r�ussi, false sinon.
	 */
	public boolean reussite(Combattant joueur) {
		int pro=(int)((joueur.getDexterite()*this.maniabilite)/1000);
		return Math.random()<=pro;
	}
    
	/**
	 * Modifier la description par "Une arme,armure au corps � corps".
	 */
	public void description() {
		this.setDescription("Une arme, armure au corps à corps");
	}
 
	public int capacite(int coup,Combattant joueur) {
		return 0;
	}
   
	/**
	 * Retourne le nom de la capacit� de corps � corps.
	 * 
	 * @return Le nom de CorpsACorps.
	 */
	public String getNom() {
		return nom;
	}
    
	/**
	 * Met � jour le nom de la capacit� de corps � corps.
	 * 
	 * @param nom
	 * 			Le nouveaux nom de CorpsACorps.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Modifier le nom de la capacit� de corps � corps par "Corps A Corps".
	 */
	public void nom(){
		this.nom="Corps A Corps";
	}
}
