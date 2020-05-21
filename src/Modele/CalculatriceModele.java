package Modele;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CalculatriceModele {

	private int sommeAddition, sommeSoustraction;

	public void addition(int premierNombre, int deuxiemeNombre){
		 sommeAddition = premierNombre + deuxiemeNombre;
		}
	
	public void soustraction(int premierNombre, int deuxiemeNombre) {
		sommeSoustraction = premierNombre - deuxiemeNombre;
	}
	
	// méthode qui va fermer le programme au bout de 10s
	public void fermetureProgramme() {
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
	
	public int getSommeAddition() {
		return sommeAddition;
	}
	
	public int getSommeSoustraction() {
		return sommeSoustraction;
	}
}
