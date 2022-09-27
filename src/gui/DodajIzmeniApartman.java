package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Cenovnik;
import korisnici.Pol;
import korisnici.Sprema;
import korisnici.StatusApartmana;
import korisnici.Uloga;
import korisnici.Zaposleni;

public class DodajIzmeniApartman extends JFrame {

	private JPanel contentPane;
	private JTextField txtCena;
	private JTextField txtTipApartmana;
	private Apartmani apartman;
	private Cenovnik cenovnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajApartmane();
					DodajIzmeniApartman frame = new DodajIzmeniApartman(null);
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
	public DodajIzmeniApartman(Apartmani apartman) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(400, 400, 459, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(-11, 0, 481, 416);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(0, 0, 475, 29);
		panel.add(panel_1);
		
		JLabel formalbl = new JLabel("Forma za azuriranje apartmana");
		formalbl.setForeground(new Color(160, 82, 45));
		formalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel_1.add(formalbl);
		
		JLabel Tiplbl = new JLabel("Tip apartmana: ");
		Tiplbl.setForeground(new Color(160, 82, 45));
		Tiplbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Tiplbl.setBounds(16, 47, 130, 16);
		panel.add(Tiplbl);
		
		
		
		txtTipApartmana = new JTextField();
		txtTipApartmana.setBounds(156, 46, 275, 21);
		panel.add(txtTipApartmana);
		txtTipApartmana.setColumns(10);
		

		


		
		JButton btnIzmenaApartmana = new JButton("Sacuvaj apartman");

		btnIzmenaApartmana.setBackground(new Color(222, 184, 135));
		btnIzmenaApartmana.setForeground(new Color(160, 82, 45));
		btnIzmenaApartmana.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnIzmenaApartmana.setBounds(125, 192, 220, 28);
		panel.add(btnIzmenaApartmana);
		
		
		JLabel DodatnaLbl = new JLabel("Dodatna opremljenost apartmana:");
		DodatnaLbl.setBounds(16, 103, 220, 14);
		DodatnaLbl.setForeground(new Color(160, 82, 45));
		DodatnaLbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(DodatnaLbl);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addItem("TV");
		comboBox.addItem("KLIMA");
		comboBox.addItem("BALKON");
		comboBox.addItem("NEPUSACKA");
		comboBox.addItem("PUSACKA");
		//-------------------------------------------------------
		comboBox.addItem("TV, KLIMA");
		comboBox.addItem("TV, NEPUSACKA");
		comboBox.addItem("TV, PUSACKA");
		comboBox.addItem("TV, BALKON");
		comboBox.addItem("KLIMA, BALKON");
		comboBox.addItem("PUSACKA, KLIMA");
		comboBox.addItem("NEPUSACKA, KLIMA");
		comboBox.addItem("PUSACKA, BALKON");
		comboBox.addItem("NEPUSACKA, BALKON");
		//--------------------------------------------------------

		comboBox.addItem("TV, KLIMA, BALKON");
		comboBox.addItem("TV, KLIMA, NEPUSACKA");
		comboBox.addItem("TV, KLIMA, PUSACKA");
		comboBox.addItem("TV, BALKON, NEPUSACKA");
		comboBox.addItem("TV, BALKON, PUSACKA");
		comboBox.addItem("NEPUSACKA, KLIMA, BALKON");
		comboBox.addItem("PUSACKA, KLIMA, BALKON");
		
		//-------------------------------------------------------------
		
		comboBox.setBounds(235, 100, 220, 22);
		panel.add(comboBox);
	
		
		
		btnIzmenaApartmana.addActionListener(new ActionListener(){
			
			private Cenovnik cenovnik;

			@Override
			public void actionPerformed(ActionEvent e) {
				
//				
//				
//				
//				// TODO Auto-generated method stub
				if (validirajPodatke()==true) {
					String TipApartmana=txtTipApartmana.getText().toString();
					//String Cena=txtCena.getText().toString();
						
				
				if(apartman==null) {
					
					Apartmani apartman1=new Apartmani();
					
					List<String> novaLista=new ArrayList<String>();
					String linija=comboBox.getSelectedItem().toString();
					
					if(linija!=null) {
					for (String podatak:linija.trim().split(",")) {
						novaLista.add(podatak);
					}
					apartman1.setDodatniSadrzaj(novaLista);
					}
					
					apartman1.setTipApartmana(TipApartmana);
					String sifraApartmana=AplikacijaUtilities.IDGeneratorApartmani();
					apartman1.setSifraApartmana(sifraApartmana);
					StatusApartmana status=StatusApartmana.SLOBODNO;
					apartman1.setStatusApartmana(status);
					//cenovnik=new Cenovnik(TipApartmana, localOd, localKrajnji, Cena);
					cenovnik=AplikacijaUtilities.nadjiCenovnik(TipApartmana);
					apartman1.setCenovnik(cenovnik);
					Zaposleni sobarica=AplikacijaUtilities.pronadjiSobaricuKojaCisti();
					apartman1.setSobarica(sobarica);
					//apartman=new Apartmani(sifraApartmana, status, TipApartmana, cenovnik, sobarica, dodatniSadrzaj);
					AplikacijaUtilities.getApartmani().add(apartman1);
					AplikacijaUtilities.sacuvajApartmane();
					PregledApartmanaZaposleni apartmani=new PregledApartmanaZaposleni();
					apartmani.setVisible(true);
				}
				
				else if(apartman!=null) {
					
					List<String> novaLista=new ArrayList<String>();
					String linija=comboBox.getSelectedItem().toString();
					
					if(linija!=null) {
						
					for (String podatak:linija.trim().split(",")) {
						novaLista.add(podatak);
						
					}
					apartman.setDodatniSadrzaj(novaLista);
					
					}
					
					apartman.setTipApartmana(TipApartmana);
					
					AplikacijaUtilities.sacuvajApartmane();
					PregledApartmanaZaposleni apartmani=new PregledApartmanaZaposleni();
					apartmani.setVisible(true);
				}
				
				}
				else{
					JOptionPane.showMessageDialog(null, "Nije moguce sacuvati unesene podatke!", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				//AplikacijaUtilities.ucitajApartmane();
				
				//AplikacijaUtilities.sacuvajCenovnik();
				DodajIzmeniApartman.this.dispose();
				DodajIzmeniApartman.this.setVisible(false);
				
			}});
		this.apartman=apartman;
		if (this.apartman==null) {
			setTitle("Dodavanje apartmana");
		}
		else {
			setTitle("Izmena apartmana");
		}
		if(this.apartman!=null) {
			txtTipApartmana.setText(this.apartman.getTipApartmana());
			
		}
		
	}
		
private boolean proveriPostojanjeTipa(String tip) {
	
	for(Apartmani apartman:AplikacijaUtilities.getApartmani()) {
		
		if(tip.equals(apartman.getTipApartmana())) {
			return true;
		}
		
	}
	return false;
}
	
private boolean validirajPodatke() {
		
		String praznoPolje="Sva polja moraju biti popunjena!\n";
		String neispravanUnos="Neispravan unos!\n";
		boolean ispravniPodaci=true;
		
		if(txtTipApartmana.getText().trim().equals("") || !proveriPostojanjeTipa(txtTipApartmana.getText().trim())) {
			praznoPolje+="Tip apartmana;\n";
			ispravniPodaci=false;
		}
		
		if (ispravniPodaci==false) {
			JOptionPane.showMessageDialog(null, praznoPolje+"\n"+"\n"+neispravanUnos, "Greska", JOptionPane.WARNING_MESSAGE);
		}

		
		return ispravniPodaci;
	}
}
