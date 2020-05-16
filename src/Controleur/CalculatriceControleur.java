package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import Modele.CalculatriceModele;
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

		this.laVue.ecouteurBoutonVerification(new RecepteurBoutonVerif());
		this.laVue.ecouteurCombobox(new RecepteurCombo());
	}

	class RecepteurBoutonVerif implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			// d�claration et initialisation des variables qui vont �tre 
			// utilis�s en param�tre de fonction
			int premierNombre = laVue.getPremierNombre();
			int deuxiemeNombre = laVue.getDeuxiemeNombre(); 

			//condition qui va faire une addition ou une soustraction 
			//en fonction de l'op�rateur selectionn�
			if (laVue.getStringOperateurs() == "+") { 			

				leModele.addition(premierNombre, deuxiemeNombre);

				//condition qui va v�rifier si le r�sultat de l'addition  
				// est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
				if (leModele.getSommeAddition() == laVue.getResultatPropose()){

					int resultat = leModele.getSommeAddition();
					laVue.setAffichageBonMauvais(" Le r�sultat choisit est BON! C'�tait bien: ", resultat);

					//  le programme se ferme 10s apr�s l'affichage 
					leModele.fermetureProgramme();

				} else {

					int resultat = leModele.getSommeAddition();	
					laVue.setAffichageBonMauvais(" Le r�sultat choisit est MAUVAIS! C'�tait : ", resultat);

					//  le programme se ferme 10s apr�s l'affichage 
					leModele.fermetureProgramme();
				}

			} else {			

				leModele.soustraction(premierNombre, deuxiemeNombre);

				//condition qui va v�rifier si le r�sultat de la soustraction  
				// est �gal au r�sultat propos� par l'�l�ve et afficher Bon ou Mauvais
				if (leModele.getSommeSoustraction() == laVue.getResultatPropose() ){

					int resultat = leModele.getSommeSoustraction();	
					laVue.setAffichageBonMauvais(" Le r�sultat choisit est BON! C'�tait bien: ", resultat);

					//  le programme se ferme 10s apr�s l'affichage 
					leModele.fermetureProgramme();

				} else {

					int resultat = leModele.getSommeSoustraction();
					laVue.setAffichageBonMauvais(" Le r�sultat choisit est MAUVAIS! C'�tait : ", resultat);

					//  le programme se ferme 10s apr�s l'affichage 
					leModele.fermetureProgramme();
				}
			}

		}
	}

	//actions qui vont restreindrent les calculs entre 0 et 10
	class RecepteurCombo implements ActionListener {
		public void actionPerformed(ActionEvent EventCombo) {

			if (EventCombo.getSource() == laVue.getComboUn()) {

				String operateur = laVue.getStringOperateurs();
				int premierNombre = laVue.getPremierNombre();
				JComboBox<Integer> JComboDeuxiemeNombre = laVue.getComboDeux();

				//en fonction du chiffre s�lectionn� dans la premiere liste, la deuxieme liste se met � jour
				// avec la var maxSize
				int maxSize = 0;

				if (operateur == "+") {

					switch (premierNombre) {

					case 0:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<11; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 1:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<10; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 2:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<9; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 3:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<8; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 4:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<7; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 5:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<6; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 6:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<5; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 7:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<4; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 8:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<3; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 9:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<2; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 10:
						JComboDeuxiemeNombre.removeAllItems();
						JComboDeuxiemeNombre.addItem(maxSize);

						break;
					}
					
					// si l'op�rateur est "-"
				} else {

					switch (premierNombre) {

					case 0:
						JComboDeuxiemeNombre.removeAllItems();
						JComboDeuxiemeNombre.addItem(maxSize);
						break;

					case 1:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<2; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 2:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<3; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 3:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<4; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 4:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<5; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 5:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<6; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 6:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<7; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 7:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<8; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 8:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<9; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 9:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<10; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 10:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<11; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;
					}

				}

			} else if(EventCombo.getSource() == laVue.getOperateurs()) {

				String operateur = laVue.getStringOperateurs();
				//pour les soustractions les restrictions sont diff�rentes
				if(operateur == "-") {

					int premierNombre = laVue.getPremierNombre();

					JComboBox<Integer> JComboDeuxiemeNombre = laVue.getComboDeux();

					//en fonction du chiffre s�lectionn� dans la premiere liste, la deuxieme liste se met � jour
					// avec la var maxSize
					int maxSize = 0;

					switch (premierNombre) {

					case 0:
						JComboDeuxiemeNombre.removeAllItems();
						JComboDeuxiemeNombre.addItem(maxSize);
						break;

					case 1:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<2; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 2:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<3; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 3:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<4; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 4:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<5; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 5:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<6; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 6:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<7; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 7:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<8; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 8:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<9; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 9:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<10; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 10:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<11; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;
					}

				} else {

					int premierNombre = laVue.getPremierNombre();
					JComboBox<Integer> JComboDeuxiemeNombre = laVue.getComboDeux();
					int maxSize = 0;

					switch (premierNombre) {

					case 0:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<11; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 1:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<10; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 2:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<9; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 3:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<8; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 4:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<7; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 5:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<6; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 6:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<5; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 7:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<4; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 8:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<3; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 9:
						JComboDeuxiemeNombre.removeAllItems();
						for (maxSize=0; maxSize<2; maxSize++ )  {
							JComboDeuxiemeNombre.addItem(maxSize);
						}
						break;

					case 10:
						JComboDeuxiemeNombre.removeAllItems();
						JComboDeuxiemeNombre.addItem(maxSize);

						break;

					}

				}
			}
		}
	}
}
