package Modele;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

// Le modèle reçoit toute les valeurs et fait tout les calculs
// il n'intéragit pas avec la vue

public class CalculatriceModele {

	// variables qui permettent d'obtenir la valeur de la somme des calculs
	// entrez dans la vue

	private int sommeAddition, sommeSoustraction;

	// méthodes d'addition et de soustraction
	
	public void addition(int premierNombre, int deuxiemeNombre){
						
		 sommeAddition = premierNombre + deuxiemeNombre;
		}
	
	public void soustraction(int premierNombre, int deuxiemeNombre) {
		
		sommeSoustraction = premierNombre - deuxiemeNombre;
	}
	
	// méthode qui va fermer le programme au bout de 10s
	
	public static void fermetureProgramme() {
		
		Timer fermetureApresResultat = new Timer();  
		fermetureApresResultat.schedule(new TimerTask() {
			
			public void run() {
				
				System.exit(0);
		}
			
	},10000 // les milisecondes du délais
				
		);
	}
	
	public void pauseProgramme() {

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	// getter des sommes des résultats 
	
	public int getSommeAddition() {
		
		return sommeAddition;
	}
	
	public int getSommeSoustraction() {
		
		return sommeSoustraction;
	}
}
