import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Convertisseur extends JFrame implements ActionListener
{
	private JButton btAc = new JButton("AC");
	private JButton btEuros = new JButton("Euros");
	private JButton btDevise = new JButton("Devise");
	private JButton btQuitter = new JButton("Quitter");
	private JButton btTaux = new JButton("Nouveau");
	private JButton btAide = new JButton("Aide");
	
	private JTextField txtMontant = new JTextField();
	
	private JLabel lbTitre = new JLabel("Mon convertisseur 2019");
	
	private float taux;
	private String devise;
	
	private JMenuBar uneBarre = new JMenuBar();
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenu mnOperation = new JMenu("Operation");
	private JMenu mnAide = new JMenu("Aide");
	
	private JMenuItem itemAc = new JMenuItem("Ac");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemEuros = new JMenuItem("Euros");
	private JMenuItem itemDevise = new JMenuItem("Devise");
	private JMenuItem itemTaux = new JMenuItem("Taux");
	private JMenuItem itemAide = new JMenuItem("Aide");
	
	public Convertisseur()
	{
		this.setTitle("Mon convertisseur");
		this.setBounds(200, 200, 450, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.taux = (float)6.54;
		this.devise = "Francs";
		
		//Placement des objets graphiques
		this.lbTitre.setBounds(50, 40, 350, 30);
		Font unePolice = new Font("Arial", Font.ITALIC, 30);
		this.lbTitre.setFont(unePolice);
		this.add(this.lbTitre);
		
		this.btEuros.setBounds(50, 100, 80, 20);
		this.add(this.btEuros);
		
		this.txtMontant.setBounds(150, 100, 80, 20);
		this.add(this.txtMontant);
		
		this.btDevise.setBounds(250, 100, 80, 20);
		this.add(this.btDevise);
		
		this.btAc.setBounds(50, 150, 80, 20);
		this.add(this.btAc);
		
		this.btTaux.setBounds(150, 150, 80, 20);
		this.add(this.btTaux);
		
		this.btAide.setBounds(50, 220, 110, 20);
		this.add(this.btAide);
		
		this.btQuitter.setBounds(220, 220, 150, 20);
		this.add(this.btQuitter);
		
		//Rendre les Boutons cliquable
		this.btAc.addActionListener(this);
		this.btEuros.addActionListener(this);
		this.btDevise.addActionListener(this);
		this.btTaux.addActionListener(this);
		this.btAide.addActionListener(this);
		this.btQuitter.addActionListener(this);
		

		
		//Construction des menus
		this.mnFichier.add(this.itemQuitter);
		this.mnOperation.add(this.itemAc);
		this.mnOperation.add(this.itemEuros);
		this.mnOperation.add(this.itemDevise);
		this.mnOperation.add(this.itemTaux);
		this.mnAide.add(this.itemAide);
		
		this.uneBarre.add(this.mnFichier);
		this.uneBarre.add(this.mnOperation);
		this.uneBarre.add(this.mnAide);
		
		this.setJMenuBar(this.uneBarre);
		
		//Rendre les items de menus écoutable
		this.itemAc.addActionListener(this);
		this.itemAide.addActionListener(this);
		this.itemEuros.addActionListener(this);
		this.itemDevise.addActionListener(this);
		this.itemTaux.addActionListener(this);
		this.itemQuitter.addActionListener(this);
			
		this.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new Convertisseur();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btAc)
		{
			this.txtMontant.setText("");
		}
		
		else if(e.getSource() == this.btQuitter || e.getSource() == this.itemQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?", "Quitter l'application", JOptionPane.YES_NO_OPTION);
			
			if(retour == 0)
			{
				this.dispose();
			}
		}
		
		else if(e.getSource() == this.btAide || e.getSource() == this.itemAide)
		{
			JOptionPane.showMessageDialog(this, "Logiciel réalisé par l'école IRIS" 
			+ "\n Janvier 2019"
			+ "\n Sasorishi",
			"Tout Droit réserver par IRIS",
			JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getSource() == this.btEuros)
		{
			float nt = 0;
			
			try
			{
				nt = Float.parseFloat(this.txtMontant.getText());
				nt = nt / this.taux;
			}
			
			catch(NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Attention à la saisie de votre montant !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}

			this.txtMontant.setText(nt + "");
		}
		
		else if(e.getSource() == this.btDevise || e.getSource() == this.itemDevise)
		{
			float nt = 0;
			
			try
			{
				nt = Float.parseFloat(this.txtMontant.getText());
				nt = nt * this.taux;
			}
			
			catch(NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Attention à la saisie de votre montant !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}

			this.txtMontant.setText(nt + "");
		}
		
		else if(e.getSource() == this.btTaux || e.getSource() == this.itemTaux)
		{
			try
			{
				this.devise = JOptionPane.showInputDialog(this, "Veuillez saisir la nouvelle devise ?", "Saisie de la nouvelle devise", JOptionPane.INFORMATION_MESSAGE);
				this.taux = Float.parseFloat(JOptionPane.showInputDialog(this, "Veuillez saisir le taux de la devise", "Saisie de la devise", JOptionPane.INFORMATION_MESSAGE));
			}
			
			catch(NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Attention à la saisie des données !", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.taux = (float) 6.56;
				this.devise = "Francs";
			}
			
			catch(NullPointerException exp)
			{
				JOptionPane.showMessageDialog(this, "Attention à la saisie des données !", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.taux = (float) 6.56;
				this.devise = "Francs";
			}
			
			if(this.devise.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Attention à la saisie des données !", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.taux = (float) 6.56;
				this.devise = "Francs";
			}
		}
	}
}
