package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Factory.Daofactory;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import courses.*;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textDtNa;
	private JTextField textGroupS;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNom = new JTextField();
		textNom.setBounds(213, 78, 270, 30);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(42, 76, 127, 30);
		contentPane.add(lblNewLabel);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(213, 145, 270, 30);
		contentPane.add(textPrenom);
		textPrenom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(42, 147, 127, 27);
		contentPane.add(lblNewLabel_1);
		
		textDtNa = new JTextField();
		textDtNa.setBounds(213, 211, 270, 30);
		contentPane.add(textDtNa);
		textDtNa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date Naissance");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(42, 211, 127, 30);
		contentPane.add(lblNewLabel_2);
		
		textGroupS = new JTextField();
		textGroupS.setColumns(10);
		textGroupS.setBounds(213, 282, 270, 30);
		contentPane.add(textGroupS);
		
		JLabel lblGroupSanguin = new JLabel("Group Sanguin");
		lblGroupSanguin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGroupSanguin.setBounds(42, 282, 127, 30);
		contentPane.add(lblGroupSanguin);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 663, 43);
		contentPane.add(panel);
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblInscription);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textNom.getText();
				String prenom = textPrenom.getText();
				String dateN = textDtNa.getText();
				String groupSang = textGroupS.getText();
				 
					Coureur c=new Coureur(nom, prenom, dateN, groupSang);
					System.out.println(c.getPrenom());
					c= Daofactory.getCoureurDao().save(c);
					JOptionPane.showMessageDialog(null, "vous êtes inscrit");

			}
		});
		btnValider.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnValider.setForeground(Color.ORANGE);
		btnValider.setBackground(Color.ORANGE);
		btnValider.setBounds(213, 354, 189, 30);
		contentPane.add(btnValider);
	}
}
