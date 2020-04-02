package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import Mod�le.CalculatriceModele;
import Vue.CalculatricePub;
import Vue.CalculatriceVue;

// le controleur fait le pont 
// entre la pub, la vue et le mod�le

public class CalculatriceControleur {
	
	// attributs
	
	private CalculatriceVue laVue;
	private CalculatriceModele leModele;
	private CalculatricePub laPub;
	
	// constructeur qui prend en param�tre une instance de la classe Vue, du Modele et de la classe
	
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
			// utilis�es en param�tre de fonction

			int premierNombre = laVue.getPremierNombre();
			int deuxiemeNombre = laVue.getDeuxiemeNombre();  
			
			int resultatAddition = leModele.getSommeAddition();
			int resultatSoustraction = leModele.getSommeSoustraction();
			
				//condition qui va faire une addition ou une soustraction 
				//en fonction de l'op�rateur selectionn�
				
			if (laVue.getOperateurs() == "+") { 			
				
				leModele.addition(premierNombre, deuxiemeNombre);
				
				//condition qui va v�rifier si le r�sultat de l'addition  
				// est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais et
				//qui v�rifie pour emp�cher d'afficher une r�ponse si la somme est > 10
				
				if (resultatAddition == laVue.getResultatPropose() && resultatAddition <= 10){

					laVue.setAffichageAddition(" Le r�sultat choisit est BON! C'�tait bien: ", resultatAddition);
					
				// le programme se ferme 10s apr�s l'affichage 
					
					CalculatriceModele.fermetureProgramme();
					
				} // si le r�sultat propos� n'est pas �gal au r�sultat de l'op�ration
				
				 else if (resultatAddition != laVue.getResultatPropose() && resultatAddition <= 10){
				
					laVue.setAffichageAddition(" Le r�sultat choisit est MAUVAIS! C'�tait: ", resultatAddition);
					
					CalculatriceModele.fermetureProgramme();
					}
				}
				else {			
					
					leModele.soustraction(premierNombre, deuxiemeNombre);
					
					//condition qui va v�rifier si le r�sultat de la soustraction  
					// est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
					// et pour emp�cher d'afficher une r�ponse si la somme est < 0
					
					if (resultatSoustraction == laVue.getResultatPropose() && resultatSoustraction >= 0 ){
					
						laVue.setAffichageSoustraction(" Le r�sultat choisit est BON! C'�tait bien: ", resultatSoustraction);
						
					//  le programme se ferme 10s apr�s l'affichage 
						
						CalculatriceModele.fermetureProgramme();
				
					// emp�che d'afficher une r�ponse si la somme de l'op�ration est < 0 et si elle est diff�rente du r�sultat propos�
						
					} else if (resultatSoustraction != laVue.getResultatPropose() && resultatSoustraction >= 0) {
	
						laVue.setAffichageSoustraction(" Le r�sultat choisit est MAUVAIS! C'�tait: ", resultatSoustraction);
						
						//  le programme se ferme 10s apr�s l'affichage 
						
						CalculatriceModele.fermetureProgramme();
					}
			     }
		
			// condition qui va afficher un msg d'erreur si les r�sultats de l'op�ration sont > 10 ou < 0
			
			if (resultatAddition > 10 || resultatSoustraction < 0) {
				
				// le r�sultat ne s'affiche pas si il est >10 ou <0
				laVue.setAffichageResultatNettoyage();
				laVue.affichageMsgErreur("Le r�sultat ne doit pas d�passer 10 ou descendre en dessous de 0! Choisis une autre op�ration!");	
			}		

		}
	}
		
}
