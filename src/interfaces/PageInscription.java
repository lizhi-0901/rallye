package interfaces;
import courses.*;
import java.util.Date;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Factory.Daofactory;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PageInscription extends JFrame {

	private JPanel contentPane;
	private JTextField textMot;
	private JTextField textCam;
	private JTextField textVoit;
	private JTextField textNom;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PageInscription(Coureur c,ArrayList<Competition> listComp, ArrayList<Coureur> listCoureur, ArrayList<Transport> listTrans, ArrayList<Inscription> listIns) {
		String nom;
		String prenom;
		String dateN;
		String groupSang;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 569, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose a competition : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 22, 160, 29);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 22, 170, 29);
		contentPane.add(comboBox);
		List<Competition> listC=Daofactory.getCompetitionDao().findAll();
		for(int i=0;i<listC.size();i++) {
			comboBox.addItem(listC.get(i).getNomcomp());
		}
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNom.setBounds(30, 75, 160, 29);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPrenom.setBounds(30, 135, 160, 29);
		contentPane.add(lblPrenom);
		

		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnVoiture = new JRadioButton("Voiture");
		rdbtnVoiture.setBounds(30, 252, 66, 23);
		contentPane.add(rdbtnVoiture);
		
		JRadioButton rdbtnCamion = new JRadioButton("Camion");
		rdbtnCamion.setBounds(30, 278, 66, 23);
		contentPane.add(rdbtnCamion);
		
		JRadioButton rdbtnMoto = new JRadioButton("Moto");
		rdbtnMoto.setBounds(30, 304, 66, 23);
		contentPane.add(rdbtnMoto);
		group.add(rdbtnCamion);
		group.add(rdbtnMoto);
		group.add(rdbtnVoiture);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnVoiture.setEnabled(false);
		
		JLabel lblPuissance = new JLabel("Puissance : ");
		lblPuissance.setBounds(112, 256, 109, 14);
		contentPane.add(lblPuissance);
		
		JLabel lblPoid = new JLabel("Poid : ");
		lblPoid.setBounds(112, 282, 46, 14);
		contentPane.add(lblPoid);
		
		JLabel lblCylindree = new JLabel("Cylindree : ");
		lblCylindree.setBounds(112, 308, 60, 14);
		contentPane.add(lblCylindree);
		
		textMot = new JTextField();
		textMot.setBounds(267, 305, 86, 20);
		contentPane.add(textMot);
		textMot.setColumns(10);
		textMot.setEnabled(false);
		
		textCam = new JTextField();
		textCam.setBounds(267, 279, 86, 20);
		contentPane.add(textCam);
		textCam.setColumns(10);
		textCam.setEnabled(false);
		
		textVoit = new JTextField();
		textVoit.setBounds(267, 256, 86, 20);
		contentPane.add(textVoit);
		textVoit.setColumns(10);
		textVoit.setEnabled(false);
		
		JLabel lblNomTransport = new JLabel("Nom Transport : ");
		lblNomTransport.setBounds(112, 350, 121, 14);
		contentPane.add(lblNomTransport);
		
		textNom = new JTextField();
		textNom.setBounds(267, 347, 86, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		textNom.setEnabled(false);
		for (Competition competition : listComp) {
			comboBox.addItem(competition.getNomcomp());
		}
		
		JLabel lblConstructeur = new JLabel("Constructeur : ");
		lblConstructeur.setBounds(419, 282, 100, 14);
		contentPane.add(lblConstructeur);
		
		textField_4 = new JTextField();
		textField_4.setBounds(408, 305, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEnabled(false);
		
		JButton btnConfirmerInfoPersonnel = new JButton("Confirmer");
		btnConfirmerInfoPersonnel.setBounds(30, 200, 180, 23);
		contentPane.add(btnConfirmerInfoPersonnel);
		
		JButton btnNewButton = new JButton("Submit Inscription");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMYYYY");
				String dateNow = dateFormat.format(now);
				
				
				if (textNom.getText() != "") {
					String txtComp = (String)comboBox.getSelectedItem();
					String type = Daofactory.getCompetitionDao().returnType(txtComp);
					int id_com=Daofactory.getCompetitionDao().findByNom(txtComp);
					int id_c=c.getId();
					Transport transport=null;
					if ("Marathon".equals(type)) {
						transport =new pied();
						transport=Daofactory.getTransportDao().save(transport, "pied");
						int id_t = transport.getIdTransport();
						Daofactory.getInscriptionDao().save(id_c, id_com, id_t);
						System.out.println("Inscription OK!");
						btnNewButton.setEnabled(false);
					}
					
					if ("Formule1".equals(type)) {
						
						transport =new Voiture(textNom.getText(),Double.parseDouble(textVoit.getText()));
						System.out.println(transport.getImm());
						transport = Daofactory.getTransportDao().save(transport, "Voiture");
						int id_t = transport.getIdTransport();
						System.out.println("id_coueur"+id_c);
						System.out.println("id_comp"+id_com);
						System.out.println("id_trans"+id_t);
						Daofactory.getInscriptionDao().save(id_c, id_com, id_t);
						System.out.println("Inscription OK!");
						btnNewButton.setEnabled(false);
						//listTrans.add(myV);
					}
					
					if ("Rallye".equals(type)) {
						Transport trans = null;
						/*
						if (rdbtnVoiture.isSelected()) {
							trans = new Voiture(1, textNom.getText(), listCoureur.get(listCoureur.size() - 1), Integer.parseInt(textVoit.getText()), textField_4.getText().toUpperCase());
						}
						if (rdbtnMoto.isSelected()) {
							trans = new Moto(1, textNom.getText(), Integer.parseInt(textMot.getText()), listCoureur.get(listCoureur.size() - 1), textField_4.getText().toUpperCase());
						}
						if (rdbtnCamion.isSelected()) {
							trans = new Camion(1, textNom.getText(), Integer.parseInt(textCam.getText()), listCoureur.get(listCoureur.size() - 1), textField_4.getText().toUpperCase());
						}
						
						Inscription myIns = new Inscription(listCoureur.get(listCoureur.size() - 1), dateNow, trans, myComp);
						myComp.addInscription(myIns);
						listIns.add(myIns);
						*/
						System.out.println("Inscription OK!");
						btnNewButton.setEnabled(false);
						listTrans.add(trans);
						
					}
					
					
				}
				
			}
		});
		btnNewButton.setBounds(112, 441, 180, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnReturn.setBounds(309, 440, 97, 25);
		contentPane.add(btnReturn);
		
		JLabel labelnom = new JLabel("");
		labelnom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelnom.setText(c.getNom());
		labelnom.setBounds(187, 81, 143, 23);
		contentPane.add(labelnom);
		
		
		
		JLabel labelprenom = new JLabel("");
		labelprenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelprenom.setText(c.getPrenom());
		labelprenom.setBounds(187, 141, 143, 23);
		contentPane.add(labelprenom);
		
	
		

		btnConfirmerInfoPersonnel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txtComp = (String)comboBox.getSelectedItem();
				String type = Daofactory.getCompetitionDao().returnType(txtComp);
				System.out.println(type);
			
					comboBox.setEnabled(false);
					btnConfirmerInfoPersonnel.setEnabled(false);
					if ( "Marathon".equals(type)) {
						
					}
					
					if ("Formule1".equals(type)) {
						
						rdbtnVoiture.setEnabled(true);
						textNom.setEnabled(true);
						textVoit.setEnabled(true);
						textField_4.setEnabled(true);
					}
					
					if ("Rallye".equals(type)) {
						rdbtnCamion.setEnabled(true);
						rdbtnMoto.setEnabled(true);
						rdbtnVoiture.setEnabled(true);
						textNom.setEnabled(true);
						textCam.setEnabled(true);
						textMot.setEnabled(true);
						textVoit.setEnabled(true);
						textField_4.setEnabled(true);
					}
				}
			
		});

	}
}
