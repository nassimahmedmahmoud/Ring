package combattant;

import dialogueConsole.*;

/**
 * 
 * TestCombattant est la classe permettant de d�marrer le jeu.
 *
 */
public class TestCombattant {
	public static void main(String[] args)
	{
		CombattantConsole joueur1 = new CombattantConsole();
    	System.out.println("\n\n---\t---Vous jouez à RPGProject---\t---");
    	try{
    		joueur1.menu();
    	}catch(Exception e){
    		System.out.println("Saisie incorrecte !");
    		joueur1.menu();
    		
    	}
        
	}
    
}
