package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Factory.Daofactory;
import courses.*;
import utils.ConnectionUtilite;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Connexion() {
		
		/**
		 * Fenetre
		 */
		setTitle("Race");
		setIconImage(Toolkit.getDefaultToolkit().getImage("K:\\Semaine bloqu\u00E9e 2 (UML-JAVA)\\drapeau-damier.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 549);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Titre de la fenetre
		 */
		JLabel lblAuthentification = new JLabel("AUTHENTIFICATION");
		lblAuthentification.setForeground(new Color(255, 255, 255));
		lblAuthentification.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthentification.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthentification.setBounds(152, 11, 172, 19);
		contentPane.add(lblAuthentification);
		
		/**
		 * Label Login
		 */
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(0, 188, 128, 40);
		contentPane.add(lblLogin);
		
		/**
		 * Label mot de passe
		 */
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotDePasse.setBounds(35, 275, 147, 30);
		contentPane.add(lblMotDePasse);
		
		/**
		 * Champ pour ecrire le login
		 */
		txtLogin = new JTextField();
		txtLogin.setBounds(203, 192, 214, 30);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		/**
		 * Champ pour ecrire le mot de passe
		 */
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(203, 283, 214, 30);
		contentPane.add(txtPassword);

		/**
		 * Bouton pour se connecter au reseau
		 */
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//recuperer les variables
				String login =txtLogin.getText();
				String pass =txtPassword.getText();
				
				//rechercher pour type utilisateur
				Coureur c=Daofactory.getCoureurDao().findByLoginAndPwd(login, pass);
				Organisateur o=Daofactory.getOrganisateurDao().findByLoginAndPwd(login, pass);
				//
				while(!Coureur.connecte()&&!Organisateur.connecte()) {
					
					ConnectionUtilite.seConnecter(login, pass);
					if (!Coureur.connecte()&&!Organisateur.connecte()) {
						System.out.println(" login ou mot de passe incorrecte" );
						break;
					}
				else {
				if(c==null) {
					// CONNEXION ORGANISATEUR
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								pageorganisateur frame = new pageorganisateur();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					
					
					dispose();
							}
				
				else {
					
					// CONNEXION COUREUR
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ArrayList<Competition> listComp = new ArrayList<Competition>();
								ArrayList<Coureur> listCoureur = new ArrayList<Coureur>();
								ArrayList<Transport> listTrans = new ArrayList<Transport>();
								ArrayList<Inscription> listIns = new ArrayList<Inscription>();
								
								PageInscription frame = new PageInscription(c,listComp, listCoureur, listTrans, listIns);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
					}
					}
				}
				
				
				
				
			}
		});
		btnConnexion.setBounds(291, 409, 109, 40);
		contentPane.add(btnConnexion);

		/**
		 * CheckBox pour montrer/cacher le mot de passe tape
		 */
		char hideMDP = txtPassword.getEchoChar(); 
		JCheckBox chckbxMontrerPassword = new JCheckBox("Montrer");
		chckbxMontrerPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxMontrerPassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
				} else {
					
					txtPassword.setEchoChar(hideMDP);
				}
			}
		});
		chckbxMontrerPassword.setBackground(SystemColor.menu);
		chckbxMontrerPassword.setBounds(452, 282, 77, 23);
		contentPane.add(chckbxMontrerPassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 852, 59);
		contentPane.add(panel);
		
		JLabel lblPasEncoreInscrit = new JLabel("Pas encore inscrit");
		lblPasEncoreInscrit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Inscription frame = new Inscription();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblPasEncoreInscrit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasEncoreInscrit.setForeground(new Color(255, 69, 0));
		lblPasEncoreInscrit.setBackground(Color.ORANGE);
		lblPasEncoreInscrit.setBounds(105, 432, 178, 16);
		contentPane.add(lblPasEncoreInscrit);
	}
}
