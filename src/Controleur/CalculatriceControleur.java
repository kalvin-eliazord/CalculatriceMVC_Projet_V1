package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import Modèle.CalculatriceModele;
import Vue.CalculatricePub;
import Vue.CalculatriceVue;

// le controleur fait le pont 
// entre la pub, la vue et le modèle

public class CalculatriceControleur {
	
	// attributs
	
	private CalculatriceVue laVue;
	private CalculatriceModele leModele;
	private CalculatricePub laPub;
	
	// constructeur qui prend en paramètre une instance de la classe Vue, du Modele et de la classe
	
	public CalculatriceControleur(CalculatriceVue laVue, CalculatriceModele leModele, CalculatricePub laPub) {
		
		this.laVue = laVue;
		this.leModele = leModele;
		this.laPub = laPub;
		
		// méthode qui va bloquer le programme pendant 10s pour la publicité 
		
		this.leModele.pauseProgramme();
		
		// je rend visible la calculatrice et je fais disparaitre la pub 
		
		this.laVue.setVisible(true);
		this.laPub.setVisible(false);
		
		// je met en paramètre la classe ActionBoutonVerif dans l'actionlistener de mon bouton Verification
		
		this.laVue.ecouteurBoutonVerification(new ActionBoutonVerif());

	}
	
	class ActionBoutonVerif implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				
			// déclaration et initialisation des variables qui vont être 
			// utilisées en paramètre de fonction

			int premierNombre = laVue.getPremierNombre();
			int deuxiemeNombre = laVue.getDeuxiemeNombre();  
			
			int resultatAddition = leModele.getSommeAddition();
			int resultatSoustraction = leModele.getSommeSoustraction();
			
				//condition qui va faire une addition ou une soustraction 
				//en fonction de l'opérateur selectionné
				
			if (laVue.getOperateurs() == "+") { 			
				
				leModele.addition(premierNombre, deuxiemeNombre);
				
				//condition qui va vérifier si le résultat de l'addition  
				// est égal au résultat proposé par l'élève et afficher Bon ou Mauvais et
				//qui vérifie pour empêcher d'afficher une réponse si la somme est > 10
				
				if (resultatAddition == laVue.getResultatPropose() && resultatAddition <= 10){

					laVue.setAffichageAddition(" Le résultat choisit est BON! C'était bien: ", resultatAddition);
					
				// le programme se ferme 10s après l'affichage 
					
					CalculatriceModele.fermetureProgramme();
					
				} // si le résultat proposé n'est pas égal au résultat de l'opération
				
				 else if (resultatAddition != laVue.getResultatPropose() && resultatAddition <= 10){
				
					laVue.setAffichageAddition(" Le résultat choisit est MAUVAIS! C'était: ", resultatAddition);
					
					CalculatriceModele.fermetureProgramme();
					}
				}
				else {			
					
					leModele.soustraction(premierNombre, deuxiemeNombre);
					
					//condition qui va vérifier si le résultat de la soustraction  
					// est égal au résultat proposé par l'élève et afficher Bon ou Mauvais
					// et pour empêcher d'afficher une réponse si la somme est < 0
					
					if (resultatSoustraction == laVue.getResultatPropose() && resultatSoustraction >= 0 ){
					
						laVue.setAffichageSoustraction(" Le résultat choisit est BON! C'était bien: ", resultatSoustraction);
						
					//  le programme se ferme 10s après l'affichage 
						
						CalculatriceModele.fermetureProgramme();
				
					// empêche d'afficher une réponse si la somme de l'opération est < 0 et si elle est différente du résultat proposé
						
					} else if (resultatSoustraction != laVue.getResultatPropose() && resultatSoustraction >= 0) {
	
						laVue.setAffichageSoustraction(" Le résultat choisit est MAUVAIS! C'était: ", resultatSoustraction);
						
						//  le programme se ferme 10s après l'affichage 
						
						CalculatriceModele.fermetureProgramme();
					}
			     }
		
			// condition qui va afficher un msg d'erreur si les résultats de l'opération sont > 10 ou < 0
			
			if (resultatAddition > 10 || resultatSoustraction < 0) {
				
				// le résultat ne s'affiche pas si il est >10 ou <0
				laVue.setAffichageResultatNettoyage();
				laVue.affichageMsgErreur("Le résultat ne doit pas dépasser 10 ou descendre en dessous de 0! Choisis une autre opération!");	
			}		

		}
	}
		
}
