package interfaces;
import courses.*;

import Factory.Daofactory;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import Factory.Daofactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class comp extends JFrame {

	private JPanel contentPane;
	private JLabel lblCompetitions;
	private JLabel lblNom;
	private JTextField nom;
	private JLabel lblVille;
	private JTextField ville;
	private JLabel lblPays;
	private JTextField pays;
	private JLabel lblDateDebut;
	private JLabel lblDateFin;
	private JTextField txtNiveauDiffE;
	private JTextField txtOrdreC;
	private JTextField txtDistanceC;
	private JTextField txtTpsMaxC;
	private JPanel panelEtape;
	private JTextField txtDistanceE;
	private JTextField txtOrdreE;


	public comp(ArrayList<Competition> listC, ArrayList<Etape> listE) {
		setTitle("Race");
		
		/**
		 * Creation de l'interface
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Titre du panel principal
		 */
		lblCompetitions = new JLabel("CREATION D'UNE COMPETITION");
		lblCompetitions.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCompetitions.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompetitions.setBounds(292, 13, 321, 25);
		contentPane.add(lblCompetitions);
		
		
		/**
		 * Label nom d'une competition
		 */
		lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(124, 164, 46, 14);
		contentPane.add(lblNom);
		
		/**
		 * Champ textuel pour ecrire nom d'une competition
		 */
		nom = new JTextField();
		nom.setBounds(174, 164, 145, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		/**
		 * Label ville d'une competition
		 */
		lblVille = new JLabel("Ville :");
		lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVille.setBounds(124, 189, 46, 14);
		contentPane.add(lblVille);
		
		/**
		 * Champ textuel pour ecrire la ville d'une competition
		 */
		ville = new JTextField();
		ville.setBounds(174, 189, 145, 20);
		contentPane.add(ville);
		ville.setColumns(10);
		
		/**
		 * Label pays d'une competition
		 */
		lblPays = new JLabel("Pays :");
		lblPays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPays.setBounds(383, 187, 46, 14);
		contentPane.add(lblPays);
		
		/**
		 * Champ textuel pour ecrire le pays d'une competition
		 */
		pays = new JTextField();
		pays.setBounds(438, 184, 157, 20);
		contentPane.add(pays);
		pays.setColumns(10);
		
		/**
		 * Label date de debut d'une competition
		 */
		lblDateDebut = new JLabel("Date de debut :");
		lblDateDebut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateDebut.setBounds(48, 218, 122, 14);
		contentPane.add(lblDateDebut);
		
		/**
		 * Choisir une date de debut d'une competition
		 */
		JDateChooser dateDeb = new JDateChooser();
		dateDeb.setBounds(174, 215, 137, 20);
		contentPane.add(dateDeb);
		
		/**
		 * Label date de fin d'une competition
		 */
		lblDateFin = new JLabel("Date de fin :");
		lblDateFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateFin.setBounds(334, 216, 95, 14);
		contentPane.add(lblDateFin);
		
		/**
		 * Choisir une date de fin d'une competition
		 */
		JDateChooser dateFin = new JDateChooser();
		dateFin.setBounds(438, 212, 157, 20);
		contentPane.add(dateFin);
		
		// PANELS ======================================================================
		
		/**
		 * Control du panel Etape
		 */
		JPanel panelEtape = new JPanel();
		panelEtape.setBounds(48, 417, 294, 272);
		contentPane.add(panelEtape);
		panelEtape.setLayout(null);	
		
		/**
		 * Control du panel Course
		 */
		JPanel panelCourse = new JPanel();
		panelCourse.setBounds(354, 417, 346, 272);
		contentPane.add(panelCourse);
		panelCourse.setLayout(null);
		panelCourse.setVisible(false);;
		
		// FIN PANELS ==================================================================
		
		// ELEMENTS ====================================================================
		/**
		 * ComboBox de l'etape a selectionner (panelCourse)
		 */
		JComboBox cmbCodeEtape = new JComboBox();
		cmbCodeEtape.setBounds(177, 47, 86, 20);
		panelCourse.add(cmbCodeEtape);
		
		
		
		/**
		 * ComboBox de la liste de competitions a selectionner
		 */
		JComboBox cmbListeC = new JComboBox();
		cmbListeC.setFont(new Font("Calibri", Font.PLAIN, 12));
		cmbListeC.setBounds(280, 364, 315, 20);
		contentPane.add(cmbListeC);
		
		/**
		/**
		 * Label Type de course
		 */
		JLabel lblTypeDeCourse = new JLabel("Type de course :");
		lblTypeDeCourse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTypeDeCourse.setBounds(48, 121, 122, 20);
		contentPane.add(lblTypeDeCourse);
		
		/**
		 * ComboBox Type de course a selectionner
		 */
		JComboBox cmbTypeCourse = new JComboBox();
		cmbTypeCourse.setModel(new DefaultComboBoxModel(new String[] {"Marathon", "Rallye", "Formule1"}));
		cmbTypeCourse.setBounds(174, 121, 509, 37);
		contentPane.add(cmbTypeCourse);
		
		/**
		 * Champ pour ecrire l'ordre d'une course
		 */
		txtOrdreC = new JTextField();
		txtOrdreC.setBounds(177, 83, 86, 20);
		panelCourse.add(txtOrdreC);
		txtOrdreC.setColumns(10);
		
		/**
		 * Champ pour ecrire la distance d'une course
		 */
		txtDistanceC = new JTextField();
		txtDistanceC.setBounds(177, 114, 86, 20);
		panelCourse.add(txtDistanceC);
		txtDistanceC.setColumns(10);
		
		/**
		 * Champ pour ecrire le temps max d'une course
		 */
		txtTpsMaxC = new JTextField();
		txtTpsMaxC.setBounds(177, 145, 86, 20);
		panelCourse.add(txtTpsMaxC);
		txtTpsMaxC.setColumns(10);
		
		/**
		 * Label Ordre d'une course
		 */
		JLabel lblOrdreC = new JLabel("Ordre :");
		lblOrdreC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrdreC.setBounds(81, 86, 86, 14);
		panelCourse.add(lblOrdreC);
		
		/**
		 * Label Distance d'une course
		 */
		JLabel lblDistanceC = new JLabel("Distance  :");
		lblDistanceC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistanceC.setBounds(92, 117, 75, 14);
		panelCourse.add(lblDistanceC);
		
		/**
		 * Label Temps max d'une course
		 */
		JLabel lblTpsMaxC = new JLabel("Temps max. :");
		lblTpsMaxC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTpsMaxC.setBounds(81, 148, 86, 14);
		panelCourse.add(lblTpsMaxC);
		
		/**
		 * Bouton Ajouter une course du panelCourse
		 */
		JButton btnAjouterC = new JButton("Ajouter");
		btnAjouterC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// recuperer nom de competition
				String nomcomp=cmbListeC.getSelectedItem().toString();
				// rechercher le id pour cette competion
				int idcomp = Daofactory.getCompetitionDao().findByNom(nomcomp);
				Courses c = new Courses(Integer.parseInt(txtOrdreC.getText()),Double.parseDouble(txtDistanceC.getText()),Double.parseDouble(txtTpsMaxC.getText()));
				//Etape etape = new Etape(idcomp,Integer.parseInt(txtOrdreE.getText()),Double.parseDouble(txtDistanceE.getText()),txtNiveauDiffE.getText());
				//recuperer id d'etape
				
				//
					if(cmbCodeEtape.isEnabled()) { // etape
						int ordre_etape=Integer.parseInt(txtOrdreE.getText());
						int id_etape = Daofactory.getEtapeDao().FindId(idcomp, ordre_etape);
						System.out.println(id_etape);
					c =Daofactory.getCourseDao().saveE(c, id_etape);
				}else { //no etape
					
					c =Daofactory.getCourseDao().saveC(c, idcomp);
				}
				
				
				
				
				
			}
		});
		btnAjouterC.setFont(new Font("Calibri", Font.BOLD, 13));
		btnAjouterC.setForeground(new Color(128, 0, 0));
		btnAjouterC.setBounds(177, 188, 86, 23);
		panelCourse.add(btnAjouterC);
		
		/**
		 * Titre : Informations d'une course (panelCourse)
		 */
		JLabel lblInformationsDuneCourse = new JLabel("Informations d'une course :");
		lblInformationsDuneCourse.setForeground(new Color(128, 0, 0));
		lblInformationsDuneCourse.setFont(new Font("Calibri", Font.BOLD, 15));
		lblInformationsDuneCourse.setBounds(10, 11, 189, 14);
		panelCourse.add(lblInformationsDuneCourse);
		
		/**
		 * Label Code de l'etape a selectionner (panelCourse)
		 */
		JLabel lblCodeEtape = new JLabel("Code Etape :");
		lblCodeEtape.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodeEtape.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodeEtape.setBounds(35, 30, 114, 53);
		panelCourse.add(lblCodeEtape);
		
		
		
		/**
		 * Label Liste de competitions
		 */
		JLabel lblListeComptitions = new JLabel("Liste des comp\u00E9titions :");
		lblListeComptitions.setHorizontalAlignment(SwingConstants.RIGHT);
		lblListeComptitions.setBounds(86, 370, 183, 14);
		contentPane.add(lblListeComptitions);
		
		
		 /* Champ pour ecrire le niveau de difficulte d'une etape
		 */
		txtNiveauDiffE = new JTextField();
		txtNiveauDiffE.setBounds(147, 157, 86, 20);
		panelEtape.add(txtNiveauDiffE);
		txtNiveauDiffE.setColumns(10);
		
		/**
		 * Champ pour ecrire la distance d'une etape
		 */
		txtDistanceE = new JTextField();
		txtDistanceE.setBounds(147, 113, 86, 20);
		panelEtape.add(txtDistanceE);
		txtDistanceE.setColumns(10);
		
		
		/**
		 * Champ pour ecrire l'ordre d'une etape
		 */
		txtOrdreE = new JTextField();
		txtOrdreE.setBounds(147, 63, 86, 20);
		panelEtape.add(txtOrdreE);
		txtOrdreE.setColumns(10);
		
		
		/**
		 * Label Ordre d'une etape
		 */
		JLabel lblOrdreE = new JLabel("Ordre : ");
		lblOrdreE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrdreE.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrdreE.setBounds(10, 51, 127, 42);
		panelEtape.add(lblOrdreE);
		
		/**
		 * Label Distance d'une etape
		 */
		JLabel lblDistanceE = new JLabel("Distance : ");
		lblDistanceE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDistanceE.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistanceE.setBounds(20, 106, 106, 27);
		panelEtape.add(lblDistanceE);
		
		/**
		 * Label Niveau de difficulte d'une etape
		 */
		JLabel lblNiveauDiffE = new JLabel("Niveau de difficult\u00E9 :");
		lblNiveauDiffE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNiveauDiffE.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNiveauDiffE.setBounds(0, 152, 151, 28);
		panelEtape.add(lblNiveauDiffE);
		
		/**
		 * Bouton Ajouter une etape à une competition choisie dans la cmbListeC
		 */
		JButton btnAjouterE = new JButton("Ajouter");
		btnAjouterE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// recuperer nom de competition
				String nomcomp=cmbListeC.getSelectedItem().toString();
				// rechercher le id pour cette competion
				int idcomp = Daofactory.getCompetitionDao().findByNom(nomcomp);
				
				// creation d'une nouvelle etape
				Etape etape = new Etape(idcomp,Integer.parseInt(txtOrdreE.getText()),Double.parseDouble(txtDistanceE.getText()),txtNiveauDiffE.getText());
				etape =Daofactory.getEtapeDao().save(etape, idcomp);
			}
			
			
		});
		btnAjouterE.setForeground(new Color(128, 0, 0));
		btnAjouterE.setFont(new Font("Calibri", Font.BOLD, 13));
		btnAjouterE.setBounds(147, 204, 86, 23);
		panelEtape.add(btnAjouterE);
		
		/**
		 * Titre Informations d'une etape (panelEtape)
		 */
		JLabel lblInformationsDunetape = new JLabel("Informations d'une \u00E9tape :");
		lblInformationsDunetape.setForeground(new Color(128, 0, 0));
		lblInformationsDunetape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblInformationsDunetape.setBounds(10, 11, 199, 14);
		panelEtape.add(lblInformationsDunetape);

		/**
		 * Titre Creer une competition (panel principal)
		 */
		JLabel lblCreerUneCompetition = new JLabel("CREER UNE COMPETITION");
		lblCreerUneCompetition.setForeground(new Color(128, 0, 0));
		lblCreerUneCompetition.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCreerUneCompetition.setBounds(50, 80, 240, 25);
		contentPane.add(lblCreerUneCompetition);
		
		/**
		 * Barre de separation : partie Creer une competition
		 */
		JPanel barreCreerCompetition = new JPanel();
		barreCreerCompetition.setBackground(new Color(0, 0, 0));
		barreCreerCompetition.setBounds(336, 91, 406, 3);
		contentPane.add(barreCreerCompetition);
		
		/**
		 * Titre Ajouter une etape (panel principal)
		 */
		JLabel lblAjouterUneEtape = new JLabel("AJOUTER UNE ETAPE");
		lblAjouterUneEtape.setForeground(new Color(128, 0, 0));
		lblAjouterUneEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAjouterUneEtape.setBounds(48, 325, 137, 14);
		contentPane.add(lblAjouterUneEtape);
		
		/**
		 * Barre de separation : partie Ajouter une etape 
		 */
		JPanel barreAjouterEtape = new JPanel();
		barreAjouterEtape.setBackground(Color.BLACK);
		barreAjouterEtape.setBounds(191, 333, 438, 3);
		contentPane.add(barreAjouterEtape);
		panelEtape.setVisible(false);
			
			// FIN RADIOBUTTONS ============================================================
		
		// FIN ELEMENTS ================================================================
			
		// CREER UNE COMPETITION =======================================================
		
		/**
		 * Bouton Creer une competition (action : ajout a la cmbListeC)
		 */
		JButton btnCreer = new JButton("Cr\u00E9er");
		lblAjouterUneEtape.setVisible(false);
		barreAjouterEtape.setVisible(false);
		cmbListeC.setVisible(false);
		lblListeComptitions.setVisible(false);
		// action bouton Creer
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String dated  = ((JTextField)dateDeb.getDateEditor().getUiComponent()).getText();
				String datef  = ((JTextField)dateFin.getDateEditor().getUiComponent()).getText();
				
				// Condition de selection dans la cmbTypeCourse
				if(cmbTypeCourse.getSelectedItem() == "Marathon") {
					Competition marathon = new Competition(nom.getText(),ville.getText(),pays.getText(),"Marathon",dated,datef) ;
					
					// creation base de donnee
					marathon = Daofactory.getCompetitionDao().save(marathon);
					//insertion dans competition
					
					// Recuperer dans la bd
					List<Competition> listC = Daofactory.getCompetitionDao().findByType("Marathon");
					for (int i =0; i<listC.size();i++) {
					cmbListeC.addItem(listC.get(i).getNomcomp());
					}
					// Acces panels
					panelEtape.setVisible(false);
					panelCourse.setVisible(true);
					cmbCodeEtape.setEnabled(false);
				} else if (cmbTypeCourse.getSelectedItem() == "Rallye") {
					
					// Acces panels
					//panelEtape.setVisible(true);
					//panelCourse.setVisible(true);
				} else if (cmbTypeCourse.getSelectedItem() == "Formule1") {
					Competition formule = new Competition(nom.getText(),ville.getText(),pays.getText(),"Formule1",dated,datef) ;
					
					// creation base de donnee
					formule = Daofactory.getCompetitionDao().save(formule);
					//insertion dans competition
					
					// Recuperer dans la bd
					List<Competition> listC = Daofactory.getCompetitionDao().findByType("Formule1");
					for (int i =0; i<listC.size();i++) {
					cmbListeC.addItem(listC.get(i).getNomcomp());
					}
					// Acces panels
					panelEtape.setVisible(true);
					panelCourse.setVisible(true);
					cmbCodeEtape.setEnabled(true);
				}
				lblAjouterUneEtape.setVisible(true);
				barreAjouterEtape.setVisible(true);
				cmbListeC.setVisible(true);
				lblListeComptitions.setVisible(true);
			}
		});
		btnCreer.setFont(new Font("Calibri", Font.BOLD, 13));
		btnCreer.setForeground(new Color(128, 0, 0));
		btnCreer.setBounds(174, 276, 89, 23);
		contentPane.add(btnCreer);
		
		JButton btnReturn = new JButton("return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				dispose();
			}
		});
		btnReturn.setBounds(742, 44, 97, 25);
		contentPane.add(btnReturn);
		
		// =============================================================================
	}
}









