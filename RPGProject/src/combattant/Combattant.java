package combattant;
import java.util.*;

import java.io.*;
import capacite.*;

/**
 * RPGProject est un programme qui consiste à retranscrire un combat entre deux joueurs
 * @version 2.7
 * <b>Combattant est la classe repr�sentant un combattant du jeu.</b>
 * <p>
 * Un combattant est caract�ris� par les information suivantes :
 * <ul>
 * <li>Une vitalite maximal correspondant a la vitalite initialis� en d�but de combat et qui ne change pas tout le long du combat</li>
 * <li>Une vitalite correspondant aux points de vie du Combattant qui est initialis� au d�but du combat</li>
 * <li>Une experience qui augmente ou diminue selon le r�sultat du combat</li>
 * <li>Une liste de capacit�s qu'il peut utiliser en combat</li>
 * </ul>
 * </p>
 * <p>
 * De plus, un Combattant poss�de des caract�risques telle qu'une intelligence, une dexterite, une concentration
 * une forcePhysique et un nom qui sont d�finis par le joueur lors de la cr�ation.
 * </p>  
 * @author Galante David & Ahmed Mahmoud Nassim
 * @version 2.7
*/
public class Combattant implements Serializable{
    
	private int vitaliteMax;
    private int vitalite ;
    private int intelligence ;
    private int dexterite;
    private int concentration ;
    private int experience ;
    private int forcePhysique ;
    private String nom ;
    private boolean capituler = false;
    private ArrayList<Capacite> capacite = new ArrayList<Capacite>();
    private int parade=0;
    private static ArrayList <Combattant>sauvegarde = new ArrayList<Combattant>();
    public static final int XPMAX=20;
	public static final int XPMIN=1;
    
    
 
    /**
     * Constructeur champs � champs du Combattant.
     * 
     * @param vitalite 
     *					La vitalite du combattant.
     * @param intelligence
     * 					L"intelligence du combattant.
     * @param dexterite
     * 					La dexterite du combattant.
     * @param concentration
     *					La concentration du combattant.
     * @param experience
     * 					L'experience du combattant.
     * @param forcePhysique
     * 					La force Physique du combattant.
     * @param nom
     * 					Le nom du combattant.
     */
    public Combattant(int vitalite, int intelligence, int dexterite,
                      int concentration, int experience, int forcePhysique, String nom) {
        this.intelligence = intelligence;
        this.dexterite = dexterite;
        this.concentration = concentration;
        this.experience = experience;
        this.forcePhysique = forcePhysique;
        this.nom = nom;
        this.vitalite = vitalite;
        this.vitaliteMax=this.vitalite;
    }
    /**
     * Constructeur par recopie.
     * 
     * @param combattant
     * 				Le Combattant qui est copi�.
     */
    public Combattant(Combattant combattant){
    	this.intelligence=combattant.intelligence;
    	this.dexterite = combattant.dexterite;
        this.concentration = combattant.concentration;
        this.experience = combattant.experience;
        this.forcePhysique = combattant.forcePhysique;
        this.nom = new String(combattant.nom);
        this.vitalite = combattant.vitalite;
        this.vitaliteMax=this.vitalite;
        this.capacite = new ArrayList<Capacite>(combattant.capacite);
    }
    
    /**
     * Retourne la liste de capacit�s du combattant.
     * 
     * @return La liste de capacit�s du combattant sous forme d'une collection de capacit�s
     */
    public ArrayList<Capacite> getCapacite() {
		return capacite;
	}
    
    /**
     * Met � jour la liste de capacit�s du combattant.
     * 
     * @param capacite
     * 					La nouvel liste de capacit�s.
     */
	public void setCapacite(ArrayList<Capacite> capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Met � jour une capacit� dans la liste de capacit�s du combattant.
	 * 
	 * @param capacite
	 * 					La nouvel capacit�
	 * @param i
	 * 			Le rang de la capacit� �  mettre jour.
	 */
	public void setCapacite(Capacite capacite , int i){
		this.capacite.set(i, capacite);
	}
	
	/**
	 * Retourne une capacit� dans la liste de  capacit�s du combattant.
	 * 
	 * @param i
	 * 			Le rang de la capacit� qui doit �tre retourn�e.
	 * @return  Une capacit� dans la liste de capacit�s du combattant.
	 */
	public Capacite getCapacite(int i){
		return this.capacite.get(i);
	}
	
	/**
	 * Constructeur Combattant.
	 * 
	 * @param nom Le nom du combattant.
	 */
	public Combattant (String nom){
        this.intelligence = 0;
        this.dexterite = 0;
        this.concentration = 0;
        this.experience = 0;
        this.forcePhysique = 0;
        this.nom = nom;
        this.vitalite = 0;
        this.vitaliteMax=this.vitalite;
    }
	
	/**
	 * Constructeur par d�faut de Combattant.
	 */
    public Combattant(){
        this.intelligence = 0;
        this.dexterite = 0;
        this.concentration = 0;
        this.experience = 0;
        this.forcePhysique = 0;
        this.nom = "defaut";
        this.vitalite = 0;
        this.vitaliteMax=this.vitalite;
    }
    
    
    /**
     * Retourne un boolean en fonction de la partie, si elle est finie ou non.
     * 
     * @return false si le combattant a captituler ou si il n'a plus de points de vies, true sinon.
     */
    public boolean finPartie(){
        if(this.capituler==true || this.vitalite<=0){
            return false ;
        }
        return true;
    }
    
    /**
     * Retourne si le combattant � capituler ou non.
     * 
     * @return capituler du combattant.
     */
    public boolean getCapituler() {
        return capituler;
    }
    
    /**
     * Met a jour capituler du combattant.
     * 
     * @param capituler
     */
    public void setCapituler(boolean capituler) {
        this.capituler = capituler;
    }
    
    /**
     * Retourne le nombre de points de vie du combattant.
     * 
     * @return La vitalite du combattant.
     */
    public int getVitalite() {
        return vitalite;
    }
    
    /**
     * Met � jour la vitalite du combattant.
     * 
     * @param vitalite
     * 				La nouvelle vitalite du combattant.
     */
    public void setVitalite(int vitalite) {
        this.vitalite = vitalite;
    }
    /**
     * Retourne l'intelligence du combattant.
     * 
     * @return l'intelligence du combattant sous forme d'entier.
     */
    public int getIntelligence() {
        return intelligence;
    }
    
    /**
     * Met � jour l'intelligence du combattant.
     * 
     * @param intelligence
     * 						La nouvelle intelligence du combattant.
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    /**
     * Retourne la dexterite du combattant.
     * 
     * @return  La dexterite du combattant sous forme d'entier.
     */
    public int getDexterite() {
        return dexterite;
    }
    
    /**
     * Met � jour la dexterite du combattant.
     * 
     * @param dexterite
     * 					La nouvelle dexterite du combattant.
     */
    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }
    
    /**
     * Retourne la concentration du combattant.
     * 
     * @return La concentration du combattant sous forme d'entier.
     */
    public int getConcentration() {
        return concentration;
    }
    
    /**
     * Met � jour la concentration du combattant.
     * 
     * @param concentration
     * 						La nouvelle concentration du combattant.
     */
    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }
    
    /**
     * Retourne l'experience du combattant.
     * 
     * @return L'experience du combattant sous forme d'entier.
     */
    public int getExperience() {
        return experience;
    }
    
    /**
     * Met � jour l'experience du combattant.
     * 
     * @param experience
     * 					La nouvelle experience du combattant.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    /**
     * Retourne la force physique du combattant.
     * 
     * @return la forcePhysique du combattant sous forme d'entier.
     */
    public int getForcePhysique() {
        return forcePhysique;
    }
    
    /**
     * Met � jour la force physique du combattant.
     * 
     * @param forcePhysique
     * 						La nouvelle forcePhysique du combattant.
     */
    public void setForcePhysique(int forcePhysique) {
        this.forcePhysique = forcePhysique;
    }
    
    /**
     * Retourne le nom du combattant.
     * 
     * @return Le nom du combattant sous forme d'une chaine de caract�res.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Met � jour le nom du combattant.
     * 
     * @param nom
     * 			Le nouveaux nom du combattant.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Retourne l'etat du combattant sous forme d'une chaine de caract�res.
     */
	public String toString() {
		return "Combattant [vitaliteMax=" + vitaliteMax + ", vitalite="
        + vitalite + ", intelligence=" + intelligence + ", dexterite="
        + dexterite + ", concentration=" + concentration
        + ", experience=" + experience + ", forcePhysique="
        + forcePhysique + ", nom=" + nom + ", capituler=" + capituler
        + ", capacite=" + capacite + ", parade=" + parade + "]";
	}
    
	/**
	 * Permet de verifier si les contraintes li�es aux combattants sont respect�es
	 * 
	 * @return true si la forcephysique + la dexterite + l'intelligence et la concentration  du combattant est inf�rieur ou �gale � 100 + son experience.
	 */
	public boolean caracteristique(){
        if((this.forcePhysique+this.dexterite+this.intelligence+this.concentration)<=(100+this.getExperience()) && this.experience>=1 && this.experience<=20){
            return true;
        }
        return false;
    }
    
    /**
     * Initialise la vitalit� et la vitaliteMax du combattant.
     */
    public void vitaliteCombattant(){
        this.vitalite=(200-this.forcePhysique-this.concentration-this.intelligence-this.dexterite)+this.experience*3;
        this.vitaliteMax=this.vitalite;
    }
    /**
     * Retourne le nombre de capacites que poss�de le combattant.
     * 
     * @return Le nombre de capacit�s sous forme d'entier.
     */
    public int nbCapacite(){
        if(this.experience/2>2)
            return this.experience/2;
        return 2;
    }
    
    /**
     * Soigne le combattant
     * 
     * @param soin
     * 			Le nombre de point de vie que le combattant r�cupere.
     */
    public void soin(int soin){
    	this.setParade(0);
    	if((this.getVitalite()+soin)<=this.getVitaliteMax())
    		this.setVitalite(this.getVitalite()+ soin);
    	else
    		this.setVitalite(this.getVitaliteMax());
    }
    
    /**
     * Permet au combattant de faire une parade.
     * 
     * @param parade
     * 				Le nombre de dommages que le combattant pare.
     */
    public void parade(int parade){
    	if(this.parade>0){
    		this.setParade(this.parade);
    	}
    	this.setParade(parade);
    }
    
    /**
     * Supprime toute les capacit�s du combattant.
     */
    public void supprimerCapacite(){
		this.capacite.removeAll(capacite);
    }
    
    /**
     * Permet au combattant d'attaquer.
     * 
     * @param ennemi
     * 				Le combattant cibl� par l'attaque.
     * @param degat
     * 				Le dommages qui seront inflig�s.
     */
    public void attaque(Combattant ennemi,int degat){
    	this.setParade(0);
    	if(degat>=ennemi.getParade())
    		degat-=ennemi.getParade();
   		else
   			degat=0;
    	if(degat>=ennemi.getVitalite())
    		ennemi.setVitalite(0);
    	else
    		ennemi.setVitalite(ennemi.getVitalite()-degat);
    }
    /**
     * R�cup�re les d�gats,r�ductions ou soin de la capacit� et coup choisis.
     * 
     * @param choix
     * 			Le choix de la capacit�.
     * @param coup
     * 			Le type de coup choisi.
     * @return Les d�gats,soins ou r�duction sous forme d'entier.
     */
    public int degat(int choix,int coup){
    	return this.getCapacite().get(choix).capacite(coup,this);
    }
    
    /**
     * 
     * @param choix
     * @param coup
     * @return
     */
    public boolean choixCategorie(int choix,int coup){
    	return this.getCapacite().get(choix).categorie(coup,this);
    }
    
    /**
     * Permet de lancer une attaque,parade ou un soin sur le combattant ennemi
     * 
     * @param ennemi
     * 				Le combattant ennemi.
     * @param coup
     * 				Le type d'action effectu�.
     * @param degat
     * 				La puissance de l'action effetu�.
     */
    public void choixCapCat(Combattant ennemi,int coup,int degat){
    	if(coup==Capacite.ATTAQUE){
			this.attaque(ennemi, degat);
		}
		else if(coup==Capacite.PARADE){
			this.parade(degat);
		}
		else if(coup==Capacite.SOIN){
			this.soin(degat);
		}
    }
    
    /**
     * Permet de sauvegarder un combattant si il est vivant.
     * 
     * @return false si le combattant est mort, true sinon. 
     */
    public boolean sauvegarde(){
    	if(this.vitalite>0){
    		getSauvegarde().add(this);
    		FileOutputStream fichier = null;
    		try{
    			fichier = new FileOutputStream("combattants.txt");
     			ObjectOutputStream objet = new ObjectOutputStream(fichier);
    			objet.writeObject(Combattant.sauvegarde);
    			objet.close();
   				fichier.close();
    		}
    		catch(Exception e){  e.printStackTrace();   	}
    		return true;
    	}
    	return false;
    }
    
    /**
     * Initialise la liste de combattants avec un fichier contenant une liste de combattant.
     */
	@SuppressWarnings("unchecked")
	public static void lire(){
    	FileInputStream fichier = null;
    	try{
    		fichier = new FileInputStream("combattants.txt");
    		try{
    			ObjectInputStream ois = new ObjectInputStream(fichier);
    			ArrayList list = (ArrayList<Combattant>)ois.readObject();
                Set set = new HashSet() ;
                set.addAll(list);
                Combattant.sauvegarde = new ArrayList<Combattant>(set);
    			ois.close();
    			fichier.close();
    		}
    		catch(FileNotFoundException e){ e.printStackTrace();
    		}
    		catch(Exception e){
                e.printStackTrace();
    		}
    	}
    	catch(Exception e){   e.printStackTrace(); 	}
    }
	
    /**
     * Incremente l'exp�rience du joueur  si elle est sup�rieur � l'exp�rience maximal.
     */
    public void incrExp(){
    	if(this.experience<XPMAX )
    	this.experience++;
    }
    
    /**
     * Decremente l'exp�rience du joueur si elle est sup�rieur � l'exp�rience minimum.
     */
    public void decrExp(){
    	if(this.experience>XPMIN)
        this.experience--;
    }
    
    /**
     * Supprime la derni�re capacit� de la liste de capacit�s.
     */
    public void perdreCap(){
    	this.capacite.remove(this.capacite.size());
    }
    
    /**
     * Retourne le nombre de dommages que r�duit le combattant.
     * 
     * @return parade sous forme d'entier.
     */
	public int getParade() {
		return parade;
	}
    
	/**
	 * Met � jour le nombre de dommages que r�duit le combattant.
	 * 
	 * @param parade
	 * 				La nouvelle valeur de parade.
	 */
	public void setParade(int parade) {
		this.parade = parade;
	}
    
	/**
	 * Retour la vitalite maximale du combattant.
	 * 
	 * @return vitaliteMax du combattant sous forme d'entier.
	 */
	public int getVitaliteMax() {
		return vitaliteMax;
	}
    
	/**
	 * Met � jour la vitalite maximal du combattant.
	 * 
	 * @param vitaliteMax
	 * 					La nouvelle vitaliteMax du combattant.
	 */
	public void setVitaliteMax(int vitaliteMax) {
		this.vitaliteMax = vitaliteMax;
	}
	
    /** Retourne la liste de combattants sauvegard�s.
     * 
     * @return La liste de combattants
     */
	public static ArrayList <Combattant> getSauvegarde() {
		return sauvegarde;
	}
    
	/**
	 * Met � jour la liste de combattants sauvegard�s.
	 * 
	 * @param sauvegarde
	 * 					La nouvelle liste de combattants.
	 */
	public static void setSauvegarde(ArrayList <Combattant> sauvegarde) {
		Combattant.sauvegarde = sauvegarde;
	}
    
    
}