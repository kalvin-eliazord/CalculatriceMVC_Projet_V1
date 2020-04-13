package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CalculatriceModele;
import Vue.CalculatricePub;
import Vue.CalculatriceVue;

// le controleur fait le pont 
// entre la vue et le modèle

public class CalculatriceControleur {
	
	// attributs
	
	private CalculatriceVue laVue;
	private CalculatriceModele leModele;
	private CalculatricePub laPub;
	
	// constructeur qui prend en paramètre une instance de la classe Vue et du Modele
	
	public CalculatriceControleur(CalculatriceVue laVue, CalculatriceModele leModele, CalculatricePub laPub) {
		
		this.laVue = laVue;
		this.leModele = leModele;
		this.laPub = laPub;
		
		// méthode qui va bloquer le programme pendant 10s pour la publicité 
		
		this.leModele.pauseProgramme();
				
		// je rend visible la calculatrice et je fais disparaitre la pub 
				
		this.laVue.setVisible(true);
		this.laPub.setVisible(false);
		
		this.laVue.ecouteurBoutonVerification(new RecepteurBoutonVerif());
	}
	
	class RecepteurBoutonVerif implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
				
			// déclaration et initialisation des variables qui vont être 
			// utilisés en paramètre de fonction

			int premierNombre = laVue.getPremierNombre();
			int deuxiemeNombre = laVue.getDeuxiemeNombre(); 
			
				
				//condition qui va faire une addition ou une soustraction 
				//en fonction de l'opérateur selectionné
				
			if (laVue.getOperateurs() == "+") { 			
				
				leModele.addition(premierNombre, deuxiemeNombre);
				
				//condition qui va vérifier si le résultat de l'addition  
				// est égal au résultat proposé par l'élève et afficher Bon ou Mauvais
				
				if (leModele.getSommeAddition() == laVue.getResultatPropose()){
					
					int resultat = leModele.getSommeAddition();
					laVue.setAffichageBonMauvais(" Le résultat choisit est BON! C'était bien: ", resultat);
	
				    //  le programme se ferme 10s après l'affichage 
					
					CalculatriceModele.fermetureProgramme();
					
					
				} else {
					
					// condition pour empêcher d'afficher une réponse si la somme est > 10
					
					if (leModele.getSommeAddition() <= 10) {
					
						int resultat = leModele.getSommeAddition();	
						laVue.setAffichageBonMauvais(" Le résultat choisit est MAUVAIS! C'était : ", resultat);
					
					   //  le programme se ferme 10s après l'affichage 
						
						CalculatriceModele.fermetureProgramme();
					}
						}
			
				} else {			
					
					leModele.soustraction(premierNombre, deuxiemeNombre);
					
					//condition qui va vérifier si le résultat de la soustraction  
					// est égal au résultat proposé par l'élève et afficher Bon ou Mauvais
					
					if (leModele.getSommeSoustraction() == laVue.getResultatPropose() && leModele.getSommeSoustraction() >= 0 ){
							
						int resultat = leModele.getSommeSoustraction();	
						laVue.setAffichageBonMauvais(" Le résultat choisit est BON! C'était bien: ", resultat);
						
					    //  le programme se ferme 10s après l'affichage 
						
						CalculatriceModele.fermetureProgramme();
							
					} else {
						
						// condition pour empêcher d'afficher une réponse si la somme est < 0
						
						if (leModele.getSommeSoustraction() >= 0) {
						
							int resultat = leModele.getSommeSoustraction();
							laVue.setAffichageBonMauvais(" Le résultat choisit est MAUVAIS! C'était : ", resultat);
						
						    //  le programme se ferme 10s après l'affichage 
						
							CalculatriceModele.fermetureProgramme();
						}
					}
			}
			
			// condition qui va afficher un msg d'erreur si les résultats de l'opération sont > 10 ou < 0
			
			if (leModele.getSommeAddition() > 10 || leModele.getSommeSoustraction() < 0) {
				
				// le résultat ne s'affiche pas si il est >10 ou <0
				
				laVue.setAffichageBonMauvaisNettoyage();
				laVue.affichageMsgErreur("Le résultat ne doit pas dépasser 10 ou descendre en dessous de 0! Choisis une autre opération!");		
			}		

		}
	}
		
}
