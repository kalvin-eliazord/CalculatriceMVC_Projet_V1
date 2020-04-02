package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import Mod�le.CalculatriceModele;
import Vue.CalculatricePub;
import Vue.CalculatriceVue;

// le controleur fait le pont 
// entre la vue et le mod�le

public class CalculatriceControleur {
	
	// attributs
	
	private CalculatriceVue laVue;
	private CalculatriceModele leModele;
	private CalculatricePub laPub;
	
	// constructeur qui prend en param�tre une instance de la classe Vue et du Modele
	
	public CalculatriceControleur(CalculatriceVue laVue, CalculatriceModele leModele, CalculatricePub laPub) {
		
		this.laVue = laVue;
		this.leModele = leModele;
		this.laPub = laPub;
		
		// m�thode qui va bloquer le programme pendant 10s pour la publicit� 
		
		this.leModele.pauseProgramme();
		
		// je rend visible la calculatrice et je fais disparaitre la pub 
		
		this.laVue.setVisible(true);
		this.laPub.setVisible(false);
		
		// je met en param�tre la classe ActionBoutonVerif dans l'actionlistener de mon bouton Verification
		
		this.laVue.ecouteurBoutonVerification(new ActionBoutonVerif());

	}
	
	class ActionBoutonVerif implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				
			// d�claration et initialisation des variables qui vont �tre 
			// utilis�s en param�tre de fonction

			int premierNombre = laVue.getPremierNombre();
			int deuxiemeNombre = laVue.getDeuxiemeNombre();  
			
				//condition qui va faire une addition ou une soustraction 
				//en fonction de l'op�rateur selectionn�
				
			if (laVue.getOperateurs() == "+") { 			
				
				leModele.addition(premierNombre, deuxiemeNombre);
				
				//condition qui va v�rifier si le r�sultat de l'addition  
				// est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
				
				if (leModele.getSommeAddition() == laVue.getResultatPropose()){

					// condition pour emp�cher d'afficher une r�ponse si la somme est > 10
					
					if (leModele.getSommeAddition() <= 10) {
					
					laVue.setAffichageBonMauvais(" Le r�sultat choisit est BON!");
					
				//  le programme se ferme 10s apr�s l'affichage 
					
					CalculatriceModele.fermetureProgramme();
					
					}
				} else {
					
					// condition pour emp�cher d'afficher une r�ponse si la somme est > 10
					
					if (leModele.getSommeAddition() <= 10){
						
					laVue.setAffichageBonMauvais(" Le r�sultat choisit est MAUVAIS!");
					
				//  le programme se ferme 10s apr�s l'affichage 
					
					CalculatriceModele.fermetureProgramme();
					
					}
						}
			
				} else {			
					
					leModele.soustraction(premierNombre, deuxiemeNombre);
					
					//condition qui va v�rifier si le r�sultat de la soustraction  
					// est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
					
					if (leModele.getSommeSoustraction() == laVue.getResultatPropose()){
						
						// condition pour emp�cher d'afficher une r�ponse si la somme est < 0
						
						if (leModele.getSommeSoustraction() >= 0) {
							
						laVue.setAffichageBonMauvais(" Le r�sultat choisit est BON!");
						
					//  le programme se ferme 10s apr�s l'affichage 
						
						CalculatriceModele.fermetureProgramme();
						
						}
					} else {
						
						// condition pour emp�cher d'afficher une r�ponse si la somme est < 0
						
						if (leModele.getSommeSoustraction() >= 0) {
						
						laVue.setAffichageBonMauvais(" Le r�sultat choisit est MAUVAIS!");
						
						//  le programme se ferme 10s apr�s l'affichage 
						
						CalculatriceModele.fermetureProgramme();
						
						}
					}
			}
			
			// condition qui va afficher un msg d'erreur si les r�sultats de l'op�ration sont > 10 ou < 0
			
			if (leModele.getSommeAddition() > 10 || leModele.getSommeSoustraction() < 0) {
				
				// le r�sultat ne s'affiche pas si il est >10 ou <0
				laVue.setAffichageResultatNettoyage();
				
				laVue.affichageMsgErreur("Le r�sultat ne doit pas d�passer 10 ou descendre en dessous de 0! Choisis une autre op�ration!");
				
			}		

		}
	}
		
}
