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
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import korisnici.AplikacijaUtilities;
import korisnici.Gost;
import korisnici.Korisnik;
import korisnici.Pol;
import korisnici.Sprema;
import korisnici.Uloga;
import korisnici.Zaposleni;
import com.toedter.calendar.JDateChooser;

public class DodajGoste extends JFrame {

	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;
	private JTextField txtBrTelefona;
	private JTextField txtkIme;
	private JTextField txtLozinka;
	private Gost gost1;
	//private Korisnik gost1;
	private JDateChooser dateChooser;
	




	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DodajGoste frame = new DodajGoste(null);
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
	public DodajGoste(Gost gost1) {
		this.gost1=gost1;
		
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setVisible();-stavi na kraj
		setLocationRelativeTo(null);
		setBounds(400, 400, 459, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(-11, 0, 458, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(0, 0, 457, 29);
		panel.add(panel_1);
		
		JLabel formalbl = new JLabel("Forma za azuriranje korisnika");
		formalbl.setForeground(new Color(160, 82, 45));
		formalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel_1.add(formalbl);
		
		JLabel Imelbl = new JLabel("Ime");
		Imelbl.setForeground(new Color(160, 82, 45));
		Imelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Imelbl.setBounds(16, 66, 53, 16);
		panel.add(Imelbl);
		
		JLabel Prezimelbl = new JLabel("Prezime");
		Prezimelbl.setForeground(new Color(160, 82, 45));
		Prezimelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Prezimelbl.setBounds(16, 116, 53, 16);
		panel.add(Prezimelbl);
		
		JLabel korisnickoImelbl = new JLabel("K. ime");
		korisnickoImelbl.setBounds(16, 338, 124, 16);
		korisnickoImelbl.setForeground(new Color(160, 82, 45));
		korisnickoImelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(korisnickoImelbl);
		
		JLabel brTelefonalbl = new JLabel("Br. telefona");
		brTelefonalbl.setBounds(16, 225, 75, 16);
		brTelefonalbl.setForeground(new Color(160, 82, 45));
		brTelefonalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(brTelefonalbl);
		
		JLabel Adresalbl = new JLabel("Adresa");
		Adresalbl.setBounds(16, 282, 53, 16);
		Adresalbl.setForeground(new Color(160, 82, 45));
		Adresalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Adresalbl);
		
		
		JLabel Pollbl = new JLabel("Pol");
		Pollbl.setBounds(16, 423, 53, 16);
		Pollbl.setForeground(new Color(160, 82, 45));
		Pollbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Pollbl);
		

		
		
		JComboBox<Pol> comboPol = new JComboBox<Pol>(Pol.values());
		comboPol.setBounds(101, 421, 104, 22);
		panel.add(comboPol);
		
		
		JLabel Lozinkalbl = new JLabel("Lozinka");
		Lozinkalbl.setBounds(16, 379, 53, 16);
		Lozinkalbl.setForeground(new Color(160, 82, 45));
		Lozinkalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(Lozinkalbl);
		
		JLabel DatumRodjenjalbl = new JLabel("D. rodjenja");
		DatumRodjenjalbl.setBounds(16, 167, 104, 16);
		DatumRodjenjalbl.setForeground(new Color(160, 82, 45));
		DatumRodjenjalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(DatumRodjenjalbl);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(101, 277, 210, 28);
		panel.add(txtAdresa);
		txtAdresa.setColumns(10);
		
		txtBrTelefona = new JTextField();
		txtBrTelefona.setBounds(101, 220, 210, 28);
		panel.add(txtBrTelefona);
		txtBrTelefona.setColumns(10);
		
		txtkIme = new JTextField();
		txtkIme.setBounds(101, 332, 210, 28);
		panel.add(txtkIme);
		txtkIme.setColumns(10);
		
		txtLozinka = new JTextField();
		txtLozinka.setBounds(101, 374, 210, 28);
		panel.add(txtLozinka);
		txtLozinka.setColumns(10);
		
		txtIme = new JTextField();
		txtIme.setBounds(101, 61, 210, 28);
		panel.add(txtIme);
		txtIme.setColumns(10);
		
		txtPrezime = new JTextField();
		txtPrezime.setBounds(101, 111, 210, 28);
		panel.add(txtPrezime);
		txtPrezime.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(101, 167, 210, 20);
		panel.add(dateChooser);
		
		
		
		JButton btnIzmenaKorisnika = new JButton("Sacuvaj korisnika");

		btnIzmenaKorisnika.setBackground(new Color(222, 184, 135));
		btnIzmenaKorisnika.setForeground(new Color(160, 82, 45));
		btnIzmenaKorisnika.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnIzmenaKorisnika.setBounds(101, 481, 240, 28);
		panel.add(btnIzmenaKorisnika);
		
		
		
		
		if (this.gost1==null) {
			setTitle("Registracija novog gosta");
		}
		else {
			setTitle("Azuriranje gostinskog naloga");
		}
		
		if(this.gost1!=null) {
			txtIme.setText(this.gost1.getIme());
			txtPrezime.setText(this.gost1.getPrezime());
			txtLozinka.setText(this.gost1.getLozinka());
			comboPol.setSelectedItem(this.gost1.getPol());
			txtkIme.setText(this.gost1.getkorisnickoIme());
			txtBrTelefona.setText(this.gost1.getbrojTelefona());
			txtAdresa.setText(this.gost1.getAdresa());
		}
		

		
		

		
		btnIzmenaKorisnika.addActionListener(new ActionListener(){

	

			@Override
			public void actionPerformed(ActionEvent e) {
				Date datum=dateChooser.getDate();
				//System.out.println(datum);
				//Converting the date to Instant
				Instant instant = datum.toInstant();
				
				ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
					
				//Converting the Date to LocalDate
				LocalDate localDate = zonedDateTime.toLocalDate();
				LocalDate d1=LocalDate.of(2009,1,1);
				
				
				//korisnik mora imati vise od 13 godina
				
				if (validirajPodatke()==true &&localDate.isBefore(d1)) {
					
					String datumRodjenja=localDate.toString();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String adresa = txtAdresa.getText().trim();
					String brojTelefona = txtBrTelefona.getText().trim();
					String korisnickoIme = txtkIme.getText().trim();
					String lozinka = txtLozinka.getText().trim();
					Pol pol = (Pol) comboPol.getSelectedItem();
					
					
					if (gost1==null) {
						
						System.out.println("------------------------------------------------------------");
						Gost gost = new Gost(ime, prezime, korisnickoIme, brojTelefona, lozinka, datumRodjenja, adresa, pol);
						System.out.println(gost);
						AplikacijaUtilities.getGosti().add(gost);
						JOptionPane.showMessageDialog(null, "Uspesno ste dodali novog korisnika", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);

						
					}
					else {
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						gost1.setbrojTelefona(brojTelefona);
						gost1.setAdresa(adresa);
						gost1.setIme(ime);
						gost1.setPrezime(prezime);
						gost1.setLozinka(lozinka);
						gost1.setkorisnickoIme(korisnickoIme);
						gost1.setPol(pol);
						JOptionPane.showMessageDialog(null, "Uspesno ste azurirali postojeceg korisnika", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
						
					}
					AplikacijaUtilities.sacuvajGoste();
					DodajGoste.this.dispose();
					DodajGoste.this.setVisible(false);
				}
				
			}
});}
		

	
	
	
	private boolean validirajPodatke() {
		String praznoPolje="Sva polja moraju biti popunjena!\n";
		String neispravanUnos="Neispravan unos!\n";
		boolean ispravniPodaci=true;
		
//		LocalDate d1=LocalDate.of(2009,1,1);
//		
//		
//		// TODO Auto-generated method stub
//		
//		Date datum=dateChooser.getDate();
//		//System.out.println(datum);
//			
//		//Converting the date to Instant
//		Instant instant = datum.toInstant();
//		
//		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
//			
//		//Converting the Date to LocalDate
//		LocalDate localDate = zonedDateTime.toLocalDate();
//		
//		if(localDate.isAfter(d1)) {
//			JOptionPane.showMessageDialog(null, "Korisnik mora imati vise od 13 godina da bi bio u sistemu!"+"\n", "Greska", JOptionPane.WARNING_MESSAGE);
//		}
		


		if(txtIme.getText().trim().equals("")) {
			praznoPolje+="Ime;\n";
			ispravniPodaci=false;
		}
		
		if (txtkIme.getText().trim().equals("")) {
			praznoPolje+="Korisnicko ime;\n";
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
		
		 String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		 

		if (!patternMatches(txtkIme.getText().trim(), regexPattern)) {
			neispravanUnos += "Unesite email u ispravnom formatu!";
			ispravniPodaci = false;
		}
		if(txtLozinka.getText().chars().allMatch( Character::isDigit )!=true){
			neispravanUnos += "Broj pasosa mora sadrzati samo cifre!\n";
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
