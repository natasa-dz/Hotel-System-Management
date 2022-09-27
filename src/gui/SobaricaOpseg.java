package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.OcisceneSobeDatumi;
import korisnici.Uloga;
import korisnici.Zaposleni;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class SobaricaOpseg extends JFrame {

	private JPanel contentPane;
	private JTextField krajnjiDatum;
	private JTextField pocetniDatum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajZaposlene();
					AplikacijaUtilities.ucitajOcisceneSobe();
					SobaricaOpseg frame = new SobaricaOpseg();
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
	public SobaricaOpseg() {
		setResizable(false);
		setTitle("Sobarice izvestaj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 571, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 559, 582);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, -11, 66, 620);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(66, 0, 485, 35);
		panel.add(panel_2);
		
		JLabel lblNaslov = new JLabel("Opterecenost sobarica za izabrani opseg datuma");
		lblNaslov.setForeground(new Color(160, 82, 45));
		lblNaslov.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(lblNaslov);

		

		JLabel lblNewLabel = new JLabel("Pocetni datum za izvestaj: ");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setBounds(86, 62, 153, 14);
		panel.add(lblNewLabel);
		
		krajnjiDatum = new JTextField();
		krajnjiDatum.setBounds(326, 99, 169, 20);
		panel.add(krajnjiDatum);
		krajnjiDatum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Krajnji datum za izvestaj: ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setBounds(326, 62, 169, 14);
		panel.add(lblNewLabel_1);
		
		pocetniDatum = new JTextField();
		pocetniDatum.setBounds(86, 99, 169, 20);
		panel.add(pocetniDatum);
		pocetniDatum.setColumns(10);
		
		JButton btnRezultati = new JButton("Prikazi rezultate");
		btnRezultati.setBackground(new Color(255, 222, 173));
		btnRezultati.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRezultati.setForeground(new Color(160, 82, 45));
		btnRezultati.setBounds(183, 210, 243, 23);
		panel.add(btnRezultati);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 250));
		textArea.setBounds(86, 296, 450, 251);
		textArea.setEditable(false);
		textArea.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textArea.setForeground(new Color(160, 82, 45));
		panel.add(textArea);
		
		JLabel lblRezultati = new JLabel("Rezultati za dati period su: ");
		lblRezultati.setForeground(new Color(139, 69, 19));
		lblRezultati.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblRezultati.setBounds(86, 271, 450, 14);
		panel.add(lblRezultati);
		
		JLabel lblNewLabel_2 = new JLabel("Odaberite sobaricu: ");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(new Color(160, 82, 45));
		lblNewLabel_2.setBounds(88, 141, 151, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>();
        comboBox.setModel(defaultComboBoxModel);
        for (Zaposleni zaposlen:AplikacijaUtilities.getZaposleni()) {
        	if(zaposlen.getUloga().equals(Uloga.SOBARICA)) {
        	defaultComboBoxModel.addElement(zaposlen.getkorisnickoIme().toString());
        }}
		
		comboBox.setBounds(86, 166, 169, 22);
		panel.add(comboBox);
		lblRezultati.setVisible(false);
		textArea.setVisible(false);
	
	
	btnRezultati.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String pocetakIzv=pocetniDatum.getText().trim();
			String krajIzv=krajnjiDatum.getText().trim();
			
			if(validateDate(pocetakIzv)&&validateDate(krajIzv)) {
				
				LocalDate pocetniDatumIzv=LocalDate.parse(pocetakIzv);
				LocalDate krajnjiDatumIzv=LocalDate.parse(krajIzv);
				
				if(ValidateBeforeAndAfter(pocetniDatumIzv,krajnjiDatumIzv)) {
					for(OcisceneSobeDatumi ociscenaSoba:AplikacijaUtilities.getDatumi()) {
						if(ociscenaSoba.getkIme().equals(comboBox.getSelectedItem().toString())){
						LocalDate datumCiscenja=LocalDate.parse(ociscenaSoba.getDatumCiscenja());
						
						if(pocetniDatumIzv.isBefore(datumCiscenja)&&krajnjiDatumIzv.isAfter(datumCiscenja)) {
							
							lblRezultati.setVisible(true);
							textArea.setVisible(true);
							String linija="----------------------------------------------------------------";
							
							textArea.setText("");
							textArea.append("Sobarica: "+ociscenaSoba.getkIme()+"\n"+"Broj spremljenih soba: "+brojSpremljenihSoba(comboBox.getSelectedItem().toString())+"\n"+linija+"\n");
							}
							
						}
						
						}

					
						
		}}}

	});

}
	
	public int brojSpremljenihSoba(String kIme) {
		int brojac=0;
		for (OcisceneSobeDatumi ociscenaSoba:AplikacijaUtilities.getDatumi()) {
			if(ociscenaSoba.getkIme().equals(kIme)) {
				brojac++;
			}
		}
		return brojac;
	}

	public boolean validateDate(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	    try {
	        sdf.parse(date);
	        return true;
	    }
	    catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "Pogresan format datuma", "Greska", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    	
	    }
	
	public boolean ValidateBeforeAndAfter(LocalDate pocetak, LocalDate kraj) {

		if(pocetak.isBefore(kraj)) {
				return true;
			}
		else {
			JOptionPane.showMessageDialog(null, "Unesite pocetaak i kraj izvestaja u ispravnom formatu!", "Greska", JOptionPane.ERROR_MESSAGE);
		return false;
		}
	
}
}
