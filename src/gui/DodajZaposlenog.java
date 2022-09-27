package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import korisnici.AplikacijaUtilities;
import korisnici.Pol;
import korisnici.Sprema;
import korisnici.Uloga;
import korisnici.Zaposleni;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DodajZaposlenog extends JFrame {

	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;
	private JTextField txtBrTelefona;
	private JTextField txtkIme;
	private JTextField txtLozinka;
	private Zaposleni zaposlen;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Zaposleni menadzer =new Zaposleni("Jovan", "Jovanovic", "jovanJ@gmail.com", "0634127354", "2346659775", "24.02.1992", "Ilije Ognjenovica 12", Pol.MUSKI, Sprema.SREDNJA_SKOLA, "3", Uloga.RECEPCIONAR);
//					DodajZaposlenog frame = new DodajZaposlenog(menadzer);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	


	/**
	 * Create the frame.
	 */
	public DodajZaposlenog(Zaposleni zaposlen) {
		
		this.zaposlen=zaposlen;
//		System.out.println(this.zaposlen);
//		System.out.println("=====================================");
//		System.out.println(zaposlen);
		

		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(400, 400, 459, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(-11, 0, 481, 579);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(0, 0, 475, 29);
		panel.add(panel_1);
		
		JLabel formalbl = new JLabel("Forma za azuriranje korisnika");
		formalbl.setForeground(new Color(160, 82, 45));
		formalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel_1.add(formalbl);
		
		JLabel Imelbl = new JLabel("Ime");
		Imelbl.setForeground(new Color(160, 82, 45));
		Imelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Imelbl.setBounds(16, 47, 53, 16);
		panel.add(Imelbl);
		
		JLabel Prezimelbl = new JLabel("Prezime");
		Prezimelbl.setForeground(new Color(160, 82, 45));
		Prezimelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Prezimelbl.setBounds(16, 88, 53, 16);
		panel.add(Prezimelbl);
		
		JLabel korisnickoImelbl = new JLabel("K. ime");
		korisnickoImelbl.setBounds(16, 338, 124, 16);
		korisnickoImelbl.setForeground(new Color(160, 82, 45));
		korisnickoImelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(korisnickoImelbl);
		
		JLabel brTelefonalbl = new JLabel("Br. telefona");
		brTelefonalbl.setBounds(16, 207, 75, 16);
		brTelefonalbl.setForeground(new Color(160, 82, 45));
		brTelefonalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(brTelefonalbl);
		
		JLabel Adresalbl = new JLabel("Adresa");
		Adresalbl.setBounds(16, 248, 53, 16);
		Adresalbl.setForeground(new Color(160, 82, 45));
		Adresalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Adresalbl);
		
		JLabel Ulogalbl = new JLabel("Uloga");
		Ulogalbl.setBounds(16, 293, 53, 16);
		Ulogalbl.setForeground(new Color(160, 82, 45));
		Ulogalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Ulogalbl);
		
		JLabel Pollbl = new JLabel("Pol");
		Pollbl.setBounds(16, 127, 53, 16);
		Pollbl.setForeground(new Color(160, 82, 45));
		Pollbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Pollbl);
		
		JLabel Stazlbl = new JLabel("Staz");
		Stazlbl.setBounds(16, 467, 53, 16);
		Stazlbl.setForeground(new Color(160, 82, 45));
		Stazlbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Stazlbl);
		
		JLabel Spremalbl = new JLabel("Sprema");
		Spremalbl.setBounds(17, 420, 63, 16);
		Spremalbl.setForeground(new Color(160, 82, 45));
		Spremalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Spremalbl);
		
		JLabel Lozinkalbl = new JLabel("Lozinka");
		Lozinkalbl.setBounds(16, 379, 53, 16);
		Lozinkalbl.setForeground(new Color(160, 82, 45));
		Lozinkalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Lozinkalbl);
		
		JLabel DatumRodjenjalbl = new JLabel("Datum rodjenja");
		DatumRodjenjalbl.setBounds(16, 167, 104, 16);
		DatumRodjenjalbl.setForeground(new Color(160, 82, 45));
		DatumRodjenjalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(DatumRodjenjalbl);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(91, 242, 191, 28);
		panel.add(txtAdresa);
		txtAdresa.setColumns(10);
		
		txtBrTelefona = new JTextField();
		txtBrTelefona.setBounds(91, 201, 191, 28);
		panel.add(txtBrTelefona);
		txtBrTelefona.setColumns(10);
		
		JComboBox<Sprema> comboSprema = new JComboBox<Sprema>(Sprema.values());
		comboSprema.setBounds(92, 415, 113, 26);
		panel.add(comboSprema);
		
		JComboBox <Uloga> comboUloga = new JComboBox<Uloga>(Uloga.values());
		comboUloga.setBounds(89, 288, 124, 26);
		panel.add(comboUloga);
		
		txtkIme = new JTextField();
		txtkIme.setBounds(91, 332, 183, 28);
		panel.add(txtkIme);
		txtkIme.setColumns(10);
		
		txtLozinka = new JTextField();
		txtLozinka.setBounds(91, 373, 183, 28);
		panel.add(txtLozinka);
		txtLozinka.setColumns(10);
		
		txtIme = new JTextField();
		txtIme.setBounds(91, 41, 191, 28);
		panel.add(txtIme);
		txtIme.setColumns(10);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(90, 82, 192, 28);
		panel.add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JComboBox<Pol> comboPol = new JComboBox<Pol>(Pol.values());
		comboPol.setBounds(91, 122, 114, 26);
		panel.add(comboPol);
		
		JButton btnIzmenaKorisnika = new JButton("Sacuvaj korisnika");

		btnIzmenaKorisnika.setBackground(new Color(222, 184, 135));
		btnIzmenaKorisnika.setForeground(new Color(160, 82, 45));
		btnIzmenaKorisnika.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnIzmenaKorisnika.setBounds(152, 518, 171, 28);
		panel.add(btnIzmenaKorisnika);
		
		String[] maxStaz = new String[30]; //currentYear is an int variable
		int inc=1;
		for(int i=0;i<30;i++)
		{
		    maxStaz[i]= inc + "";
		    inc++;
		}
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(110, 167, 210, 20);
		panel.add(dateChooser);

		JComboBox comboStaz = new JComboBox(maxStaz);
		comboStaz.setBounds(91, 462, 81, 26);
		panel.add(comboStaz);
		
		
		this.zaposlen=zaposlen;
		if (this.zaposlen==null) {
			setTitle("Dodavanje zaposlenog");
		}
		else {
			setTitle("Izmena zaposlenog");
		}
		if(this.zaposlen!=null) {
			txtIme.setText(this.zaposlen.getIme());
			txtPrezime.setText(this.zaposlen.getPrezime());
			comboPol.setSelectedItem(this.zaposlen.getPol());
			comboUloga.setSelectedItem(this.zaposlen.getUloga());
			comboSprema.setSelectedItem(this.zaposlen.getSprema());
			txtLozinka.setText(this.zaposlen.getLozinka());
			txtkIme.setText(this.zaposlen.getkorisnickoIme());
			txtBrTelefona.setText(this.zaposlen.getbrojTelefona());
			txtAdresa.setText(this.zaposlen.getAdresa());
			comboStaz.setSelectedItem(this.zaposlen.getStaz());
			
			
		}
		
		
		
		
//===============================================================================================================================================		
		
		
		btnIzmenaKorisnika.addActionListener(new ActionListener(){

			@Override
			//NE ZABORAVI DA DODAS INPUT DATUMA, I ONDA MEMORISANJE ZAPOSLENOG
			public void actionPerformed(ActionEvent e) {
				//System.out.println(this.zaposlen);
				//System.out.println(zaposlen);
				
				
				Date datum=dateChooser.getDate();
				
				//Converting the date to Instant
				Instant instant = datum.toInstant();
				
				ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
					
				//Converting the Date to LocalDate
				LocalDate localDate = zonedDateTime.toLocalDate();
				
				// TODO Auto-generated method stub
				if (validirajPodatke()==true) {
					String datumRodjenja=localDate.toString();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					Pol pol = (Pol) comboPol.getSelectedItem();
					String adresa = txtAdresa.getText().trim();
					String brojTelefona = txtBrTelefona.getText().trim();
					String korisnickoIme = txtkIme.getText().trim();
					
					String lozinka = txtLozinka.getText().trim();
					Uloga uloga = (Uloga) comboUloga.getSelectedItem();
					Sprema sprema= (Sprema) comboSprema.getSelectedItem();
					String staz= comboStaz.getSelectedItem().toString();
					
					
					if (zaposlen!=null) {
						
						System.out.println("---------------------------------------");
						
						zaposlen.setbrojTelefona(brojTelefona);
						zaposlen.setAdresa(adresa);
						zaposlen.setIme(ime);
						zaposlen.setPrezime(prezime);
						zaposlen.setLozinka(lozinka);
						zaposlen.setPol(pol);
						zaposlen.setkorisnickoIme(korisnickoIme);
						zaposlen.setSprema(sprema);
						zaposlen.setUloga(uloga);
						zaposlen.setStaz(staz);
						
						

					}
					
					else {
						//System.out.println("=====================================================================");
						Zaposleni zaposlen=new Zaposleni(ime, prezime, korisnickoIme, brojTelefona, lozinka, datumRodjenja, adresa, pol, sprema, staz, uloga);
						AplikacijaUtilities.getZaposleni().add(zaposlen);
						AplikacijaUtilities.sacuvajZaposlene();
						
					}
					AplikacijaUtilities.sacuvajZaposlene();
					DodajZaposlenog.this.dispose();
					DodajZaposlenog.this.setVisible(false);
					PrikazZaposlenih prikaz=new PrikazZaposlenih();
					prikaz.setVisible(true);
				}
				
			}});
		
		

		

		
		
	}
	
	private boolean validirajPodatke() {
		
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		String praznoPolje="Sva polja moraju biti popunjena!\n";
		String neispravanUnos="Neispravan unos!\n";
		boolean ispravniPodaci=true;
		if(txtIme.getText().trim().equals("")) {
			praznoPolje+="Ime;\n";
			ispravniPodaci=false;
		}
		if (txtPrezime.getText().trim().equals("")) {
			praznoPolje+="Prezime;\n";
			ispravniPodaci=false;
		}
		if (txtLozinka.getText().trim().equals("")) {
			praznoPolje+="Lozinka;\n";
			ispravniPodaci=false;
			
		}
		if (txtkIme.getText().trim().equals("")) {
			praznoPolje+="Korisnicko ime;\n";
			ispravniPodaci=false;
			
		}
		if (txtBrTelefona.getText().trim().equals("")) {
			praznoPolje+="Broj telefona;\n";
			ispravniPodaci=false;
			
		}
		if (txtAdresa.getText().trim().equals("")) {
			praznoPolje+="Adresa;\n";
			ispravniPodaci=false;
		}

		
		if(txtLozinka.getText().chars().allMatch( Character::isDigit )!=true){
			neispravanUnos += "Broj pasosa mora sadrzati samo cifre!";
			ispravniPodaci = false;
		}
		if(txtBrTelefona.getText().chars().allMatch( Character::isDigit )!=true) {
			neispravanUnos += "Br. telefona mora sadrzati samo cifre!\n";
			ispravniPodaci = false;
		}
		if(txtLozinka.getText().chars().count()!=4){
			neispravanUnos += "Broj pasosa-lozinka mora imati tacno 4 cifre!\n";
			ispravniPodaci = false;
		}
		if(txtBrTelefona.getText().chars().count()!=10){
			neispravanUnos += "Broj telefona mora imati 10 cifara!\n";
			ispravniPodaci = false;
		}
		
		if (!patternMatches(txtkIme.getText().trim(), regexPattern)) {
			neispravanUnos += "Unesite email u ispravnom formatu!";
			ispravniPodaci = false;
		}
		
		if (ispravniPodaci==false) {
			JOptionPane.showMessageDialog(null, praznoPolje+"\n"+"\n"+neispravanUnos, "Greska", JOptionPane.WARNING_MESSAGE);
		}

		
		return ispravniPodaci;
	}
	
	
	public static boolean patternMatches(String emailAddress, String regexPattern) {
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
}
