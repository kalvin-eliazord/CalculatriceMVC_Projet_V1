package Vue;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//la classe qui contient la publicité 

public class CalculatricePub extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel affichagePub = new JLabel("PUBLICITE: Venez manger chez KFC!!");
	private JPanel fenetrePub = new JPanel();
	
	public CalculatricePub() {
		
		// paramétrage de l'ihm
		
		this.setTitle("PUBLICITE");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // plein écran par défaut
		fenetrePub.setBackground(Color.red);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		// ajout des objets graphiques au jpanel
		
		fenetrePub.add(affichagePub);
		this.add(fenetrePub);	
		
	}
}
