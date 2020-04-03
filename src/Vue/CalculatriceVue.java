 package Vue;

import java.awt.event.ActionListener;
import javax.swing.*;

//la seule fonctionnalit� de la vue est d'afficher 
//ce que l'utilisateur va voir, aucun calculs ne sera fait

public class CalculatriceVue extends JFrame{
	
	// ATTRIBUTS 
	
	private JComboBox<Integer> premierNombre  = new JComboBox<Integer>();
	private JComboBox<String> operateurs = new JComboBox<String>();
	private JComboBox<Integer> deuxiemeNombre = new JComboBox<Integer>();
	private JLabel labelEgal = new JLabel(" = ");
	private JComboBox<Integer> resultatPropose = new JComboBox<Integer>();
	private JButton boutonVerification = new JButton("V�rifier le R�sultat");
	private JLabel affichageBonMauvais = new JLabel(" ");
	private JPanel fenetreCalcul = new JPanel();
	
	//constructeur de la classe CalculatriceVue
	
	public CalculatriceVue(){
		
		// ihm param�tres
     
		this.setTitle("EditCALC V1 - par Kalvin ELIAZORD");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // plein �cran par d�faut
		
		// Affectation des valeurs des listes de JCombobox
		
		Integer[] listeNombre = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 String[] listeOperateur = new String[] {"+", "-"};
		
		// affectation des JCombobox qui poss�de une liste � une variable 
		// pour pouvoir l'ajouter � la fenetreCalcul 
		 
		premierNombre = new JComboBox<Integer>(listeNombre);
		operateurs = new JComboBox<String>(listeOperateur);
		deuxiemeNombre = new JComboBox<Integer>(listeNombre);
		resultatPropose = new JComboBox<Integer>(listeNombre);
		
		// ajout des objets graphiques de l'ihm calculatrice dans le conteneur
		
		fenetreCalcul.add(premierNombre);
		fenetreCalcul.add(operateurs);
		fenetreCalcul.add(deuxiemeNombre);
		fenetreCalcul.add(labelEgal);
		fenetreCalcul.add(resultatPropose);
		fenetreCalcul.add(boutonVerification);
		fenetreCalcul.add(affichageBonMauvais);
		
		this.add(fenetreCalcul);
	
	}

	// les getter retourne la valeur de l'index s�lectionn� dans le JCombobox
	
	public int getPremierNombre(){ 
		
		return (int) premierNombre.getSelectedItem();
	}

	public int getDeuxiemeNombre(){
		
		return (int) deuxiemeNombre.getSelectedItem();
	}
	
	public String getOperateurs() {
		
		return (String) operateurs.getSelectedItem();
	}

	public int getResultatPropose() {
		
		return (int) resultatPropose.getSelectedItem();
	}

	// affiche le r�sultat du calcul dans le label Resultat
	
	public void setAffichageAddition(String BonOuMauvais, int resultatAddition){

		affichageBonMauvais.setText(BonOuMauvais+resultatAddition);

	}
	public void setAffichageSoustraction(String BonOuMauvais, int resultatSoustraction){

		affichageBonMauvais.setText(BonOuMauvais+resultatSoustraction);

	}
	
	// m�thode qui va vider l'affichage
	
	public void setAffichageResultatNettoyage(){

		affichageBonMauvais.setText(" ");
		
	}

	// m�thode qui ajoute une action de type event � un boutton 
	
	public void ecouteurBoutonVerification(ActionListener ActionBoutonVerif){

		boutonVerification.addActionListener(ActionBoutonVerif);

	}

	// Ouvre une fen�tre qui va alerter le msg d'erreur

	public void affichageMsgErreur(String messageErreur){

		JOptionPane.showMessageDialog(this, messageErreur);
	}
}
