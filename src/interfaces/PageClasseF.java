package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import courses.Competition;
import courses.Coureur;

import courses.Inscription;

import courses.Transport;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class PageClasseF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PageClasseF(ArrayList<Competition> listComp, ArrayList<Coureur> listCoureur, ArrayList<Transport> listTrans, ArrayList<Inscription> listIns) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChoisirUnFormule = new JLabel("Choisir un Formule 1 : ");
		lblChoisirUnFormule.setBounds(10, 11, 122, 14);
		contentPane.add(lblChoisirUnFormule);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 8, 144, 20);
		contentPane.add(comboBox);
		for (Competition comp : listComp) {
			//if (//comp instanceof Formule1) {
				//comboBox.addItem(comp.getNomcomp());
			//}
		}
	}

}
