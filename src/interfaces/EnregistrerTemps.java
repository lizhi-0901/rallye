package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Factory.Daofactory;
import courses.Competition;
import courses.*;


import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.DefaultListModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnregistrerTemps extends JFrame {

	private JPanel contentPane;
	private JTextField txtSs;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
	
	}

	/**
	 * Create the frame.
	 */
	public EnregistrerTemps() {
		
		/**
		 * MODELS
		 */
		DefaultListModel model = new DefaultListModel();
		
		// LOGO ==========================================================================================================
		
		/**
		 * Logo de notre application Race
		 */
		setIconImage(Toolkit.getDefaultToolkit().getImage("K:\\Semaine bloqu\u00E9e 2 (UML-JAVA)\\drapeau-damier.jpg"));
		setTitle("Race");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ===============================================================================================================
		
		// ELEMENTS ======================================================================================================
		
		/**
		 * Titre ENREGISTREMENT DES TEMPS (panel principal)
		 */
		JLabel lblEnregistremementDesTemps = new JLabel("ENREGISTREMEMENT DES TEMPS");
		lblEnregistremementDesTemps.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnregistremementDesTemps.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnregistremementDesTemps.setBounds(106, 11, 324, 14);
		contentPane.add(lblEnregistremementDesTemps);
		
		/**
		 * Label Competition
		 */
		JLabel lblCompetition = new JLabel("Competition :");
		lblCompetition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompetition.setBounds(34, 127, 116, 14);
		contentPane.add(lblCompetition);
		
		/**
		 * Label Etape 
		 */
		JLabel lblEtape = new JLabel("Etape :");
		lblEtape.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEtape.setBounds(34, 161, 116, 14);
		contentPane.add(lblEtape);
		
		/**
		 * Label Course
		 */
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCourse.setBounds(34, 196, 116, 14);
		contentPane.add(lblCourse);

		/**
		 * ComboBox Course a selectionner
		 */
		JComboBox cmbCourse = new JComboBox();
		cmbCourse.setBounds(160, 193, 64, 20);
		contentPane.add(cmbCourse);
		
		/**
		 * ComboBox Competition a selectionner
		 */
		JComboBox cmbCompetition = new JComboBox();
		List<Competition> listC=Daofactory.getCompetitionDao().findAll();
		for(int i=0;i<listC.size();i++) {
			cmbCompetition.addItem(listC.get(i).getNomcomp());
		}
		
		cmbCompetition.setBounds(160, 124, 261, 20);
		contentPane.add(cmbCompetition);
		/**
		 * ComboBox Etape a selectionner
		 */
		JComboBox cmbEtape = new JComboBox();
		

		/**
		 * ComboBox Concurrent a selectionner
		 */
		JComboBox cmbConcurrent = new JComboBox();
		cmbConcurrent.setBounds(160, 261, 261, 20);
		contentPane.add(cmbConcurrent);
		
		/**
		 * Label Concurrent
		 */
		JLabel lblConcurrent = new JLabel("Concurrent :");
		lblConcurrent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConcurrent.setBounds(34, 264, 116, 14);
		contentPane.add(lblConcurrent);
		
		/**
		 * Label Temps
		 */
		JLabel lblTemps = new JLabel("Temps en seconde :");
		lblTemps.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemps.setBounds(34, 296, 116, 14);
		contentPane.add(lblTemps);
		
		/**
		 * Label :
		 */
		JLabel label = new JLabel(":");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(202, 321, 22, 14);
		contentPane.add(label);
		
		/**
		 * Label :
		 */
		JLabel label_1 = new JLabel(":");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(256, 321, 22, 14);
		contentPane.add(label_1);
		
		/**
		 * Label Heure du temps a enregistrer
		 */
		JLabel lblHeure = new JLabel("hh");
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeure.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblHeure.setBounds(160, 321, 46, 14);
		contentPane.add(lblHeure);
		
		/**
		 * Label Minute du temps a enregistrer
		 */
		JLabel lblMinute = new JLabel("mm");
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinute.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMinute.setBounds(216, 321, 46, 14);
		contentPane.add(lblMinute);
		
		/**
		 * Label Seconde du temps a enregistrer
		 */
		JLabel lblSeconde = new JLabel("ss");
		lblSeconde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeconde.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSeconde.setBounds(272, 321, 46, 14);
		contentPane.add(lblSeconde);

		JComboBox comboBox = new JComboBox();
		
		/**
		 * Champ pour ecrire la seconde du temps a enregistrer
		 */
		txtSs = new JTextField();
		txtSs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				int resHeure = (txtSs.getText().hashCode()/(60*60));
				String resH = String.valueOf(resHeure);
				lblHeure.setText(resH);
				
				int resMinutes = ((txtSs.getText().hashCode()/60) % 60);
				String resM = String.valueOf(resMinutes);
				lblMinute.setText(resM);
				
				int resSecondes = (txtSs.getText().hashCode() % 60);
				String resS = String.valueOf(resSecondes);
				lblSeconde.setText(resS);
				
			}
		});
		txtSs.setColumns(10);
		txtSs.setBounds(160, 292, 187, 20);
		contentPane.add(txtSs);
		
		/**
		 * Bouton Enregistrer le temps 
		 */
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtComp = (String) cmbCompetition.getSelectedItem();
				System.out.println(txtComp);
				int id_comp= Daofactory.getCompetitionDao().findByNom(txtComp);
				String type= Daofactory.getCompetitionDao().returnType(txtComp);
				System.out.println(id_comp);
				System.out.println(type);
				/*if("Formule1".equals(type)) {
					lblEtape.setText("Etape: ");
					List<Etape> e1 =Daofactory.getEtapeDao().FindEtapeById(id_comp);
					// pour une etape choisi
					for(int j=0;j<e1.size();j++) {
						comboBox.addItem(e1.get(j).getOrdreEtape());
						// inscription return coureur id
						List<Integer> list = Daofactory.getInscriptionDao().findidcoureurByidcomp(id_comp);
						// pour un coureur choisi
						for(int i =0; i<list.size();i++) {
							int id=list.get(i);
							// coureur
							Coureur c= Daofactory.getCoureurDao().find(id);
							cmbConcurrent.addItem(c.getNom()+" "+c.getPrenom());
							Participer2 p2 =new Participer2(c,e1.get(j),Integer.parseInt(txtSs.getText()));
							try {
								Daofactory.getParticiper2Dao().enreigistrer(p2,  id_comp, id,  e1.get(j).getOrdreEtape() );
							}
							 catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					}
					
				}
			} */
				
				
				if("Marathon".equals(type)) {
					lblEtape.setText("Courses: ");
					List<Courses> listC= Daofactory.getCourseDao().FindCoursesCById(id_comp);
					
					for(int j=0;j<listC.size();j++) {
						comboBox.addItem(listC.get(j).getOrdreCourse());
						System.out.println("HHHH"+listC.get(j).getDistanceC());
						// inscription return coureur id
						List<Integer> list = Daofactory.getInscriptionDao().findidcoureurByidcomp(id_comp);
						for(int i =0; i<list.size();i++) {
							int id=list.get(i);
							// coureur
							Coureur c= Daofactory.getCoureurDao().find(id);
							cmbConcurrent.addItem(c.getNom()+" "+c.getPrenom());
							Participer p =new Participer(Integer.parseInt(txtSs.getText()));
							
							try {
								Daofactory.getParticiperDao().enreigistrer(p,  id_comp, id,  listC.get(j).getCodeCourse() );
							}
							 catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
						}
					}
					lblCourse.setEnabled(false);
					cmbCourse.setEditable(false);
					
					
					
					  txtSs.getText();
					
				}
		}});
		btnEnregistrer.setForeground(new Color(0, 128, 0));
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnregistrer.setBounds(306, 354, 116, 33);
		contentPane.add(btnEnregistrer);
		
		/**
		 * Bouton Vider pour remttre a zero les champs et comboBox >> pouvoir enregistrer un nouveau temps rapidement
		 */
		JButton btnValC = new JButton("valider");
		btnValC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtSs.setText("");
			}
		});
		
		JButton btnValider = new JButton("valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txtComp = (String) cmbCompetition.getSelectedItem();
				int id_comp= Daofactory.getCompetitionDao().findByNom(txtComp);
				int ordreetape =(Integer) comboBox.getSelectedItem();
				System.out.println("ordre"+ordreetape);
				// trouver idetape par id_comp et ordree
				int id_e = Daofactory.getEtapeDao().FindId(id_comp, ordreetape);
				System.out.println("id_e"+id_e);
				List<Courses> listC= Daofactory.getCourseDao().FindCoursesEById(id_e);
				System.out.println(listC.size());
				for (int k=0; k<listC.size();k++) {
					cmbCourse.addItem(listC.get(k).getOrdreCourse());
				}
				
			}
		});
		comboBox.setBounds(162, 157, 259, 22);
		contentPane.add(comboBox);
		btnValC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				// recuperer id comp 
				String txtComp = (String) cmbCompetition.getSelectedItem();
				int id_comp= Daofactory.getCompetitionDao().findByNom(txtComp);
				String type= Daofactory.getCompetitionDao().returnType(txtComp);
				System.out.println(id_comp);
				System.out.println(type);
				if("Formule1".equals(type)) {
					lblEtape.setText("Etape: ");
					List<Etape> e =Daofactory.getEtapeDao().FindEtapeById(id_comp);
					
					
					// pour une etape choisi
					for(int j=0;j<e.size();j++) {
						comboBox.addItem(e.get(j).getOrdreEtape());
						//courses
						
						
					}
					
					
					// inscription return coureur id
					List<Integer> list = Daofactory.getInscriptionDao().findidcoureurByidcomp(id_comp);
					// pour un coureur choisi
					for(int i =0; i<list.size();i++) {
						int id=list.get(i);
						// coureur
						Coureur c= Daofactory.getCoureurDao().find(id);
						cmbConcurrent.addItem(c.getNom()+" "+c.getPrenom());
					
				}
				}else {
					lblEtape.setText("Courses: ");
					List<Courses> listC= Daofactory.getCourseDao().FindCoursesCById(id_comp);
					
					for(int j=0;j<listC.size();j++) {
						comboBox.addItem(listC.get(j).getOrdreCourse());
						
						
					}
					
					// inscription return coureur id
					List<Integer> list = Daofactory.getInscriptionDao().findidcoureurByidcomp(id_comp);
					for(int i =0; i<list.size();i++) {
						int id=list.get(i);
						// coureur
						Coureur c= Daofactory.getCoureurDao().find(id);
						cmbConcurrent.addItem(c.getNom()+" "+c.getPrenom());
						
					}
					lblCourse.setEnabled(false);
					cmbCourse.setEditable(false);
					btnValider.setVisible(false);
					
					
					
					  txtSs.getText();
					
				}
				
				
				
				
              
				
				
				
				cmbEtape.setBounds(160, 158, 261, 20);
				contentPane.add(cmbEtape);
			
				cmbEtape.setEnabled(true);
				//cmbCourse.setSelectedIndex(0);
				//cmbConcurrent.setSelectedIndex(0);
			}
		});
		btnValC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValC.setForeground(new Color(128, 0, 0));
		btnValC.setBounds(433, 124, 89, 23);
		contentPane.add(btnValC);
		
		/**
		 * Label Temps en seconde
		 */
		JLabel label_3 = new JLabel("Temps en seconde :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(34, 321, 116, 14);
		contentPane.add(label_3);
		
		
		btnValider.setForeground(Color.RED);
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnValider.setBounds(425, 156, 97, 25);
		contentPane.add(btnValider);
		
		
		
		// ===============================================================================================================
	}
}
