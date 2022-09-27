package gui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Cenovnik;
import korisnici.DodatneUsluge;
import korisnici.Gost;
import korisnici.Korisnik;
import korisnici.Rezervacije;
import korisnici.StatusApartmana;
import korisnici.StatusRezervacije;
import korisnici.Uloga;
import korisnici.Zaposleni;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;




public class PrikaziSobe extends JFrame {

	private JPanel contentPane;
	private JTextField odlazaktxt;
	private JTextField dolazaktxt;
	private Apartmani apartman;
	private Rezervacije rezervacija;
	private JTable tabelaSobe;
	private Gost gost;
	float cena=0;
	float ukupnaCena=0;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajSveKorisnike();
					AplikacijaUtilities.ucitajDodatneUsluge();
					AplikacijaUtilities.ucitajCenovnik();
					AplikacijaUtilities.ucitajApartmane();
					AplikacijaUtilities.ucitajRezervacije();

					
					PrikaziSobe frame = new PrikaziSobe(null);
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
	public PrikaziSobe(Korisnik gost) {
		
		
		setResizable(false);
		setTitle("Prikaz apartmana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 553, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 559, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, -11, 76, 620);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(66, 0, 485, 35);
		panel.add(panel_2);
		
		JLabel lblNaslov = new JLabel("Pretraga apartmana");
		lblNaslov.setForeground(new Color(160, 82, 45));
		lblNaslov.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(lblNaslov);
		
		JLabel tipLbl = new JLabel("Tip apartmana");
		tipLbl.setForeground(new Color(160, 82, 45));
		tipLbl.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		tipLbl.setBounds(99, 64, 90, 14);
		panel.add(tipLbl);
			

		
		JLabel lblNewLabel = new JLabel("Datum dolaska");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setBounds(99, 122, 98, 14);
		panel.add(lblNewLabel);
		
		odlazaktxt = new JTextField();
		odlazaktxt.setBounds(281, 147, 132, 20);
		panel.add(odlazaktxt);
		odlazaktxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Datum odlaska");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setBounds(281, 122, 90, 14);
		panel.add(lblNewLabel_1);
		
		dolazaktxt = new JTextField();
		dolazaktxt.setBounds(99, 147, 134, 20);
		panel.add(dolazaktxt);
		dolazaktxt.setColumns(10);
		
		JButton btnRezultati = new JButton("Rezervisi odabrani apartman");
		btnRezultati.setBackground(new Color(255, 222, 173));
		btnRezultati.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRezultati.setForeground(new Color(160, 82, 45));
		btnRezultati.setBounds(181, 219, 209, 23);
		panel.add(btnRezultati);
		

		
		//JList prikaziApartmane = new JList();
		//prikaziApartmane.setBounds(132, 441, 264, -134);
		//panel.add(prikaziApartmane);
		
		
        JComboBox<String> comboBox = new JComboBox<>(); 
        
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>();
        comboBox.setModel(defaultComboBoxModel);
        for (Apartmani apartman:AplikacijaUtilities.getApartmani()) {
        	defaultComboBoxModel.addElement(apartman.getTipApartmana());
        }
		comboBox.setBounds(99, 89, 314, 22);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 341, 431, -86);
		panel.add(scrollPane);
		

		
		
		JCheckBox checkDorucak = new JCheckBox("Dorucak-1100din");
		checkDorucak.setForeground(new Color(160, 82, 45));
		checkDorucak.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkDorucak.setBackground(new Color(255, 235, 205));
		checkDorucak.setBounds(82, 311, 115, 28);
		panel.add(checkDorucak);
		checkDorucak.setVisible(false);
		
		JCheckBox checkRucak = new JCheckBox("Rucak-1300din");
		checkRucak.setForeground(new Color(160, 82, 45));
		checkRucak.setBackground(new Color(255, 235, 205));
		checkRucak.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkRucak.setBounds(199, 314, 107, 23);
		panel.add(checkRucak);
		checkRucak.setVisible(false);
		
		JLabel lblDodatne = new JLabel("Ukoliko zelite neku od dodatnih usluga, oznacite odgovarajuce polje:");
		lblDodatne.setForeground(new Color(160, 82, 45));
		lblDodatne.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDodatne.setBounds(86, 253, 431, 46);
		panel.add(lblDodatne);
		lblDodatne.setVisible(false);
		
		JCheckBox spaCheck = new JCheckBox("Spa-3800 din");
		spaCheck.setBounds(82, 353, 99, 23);
		spaCheck.setForeground(new Color(160, 82, 45));
		spaCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		spaCheck.setBackground(new Color(255, 235, 205));
		panel.add(spaCheck);
		spaCheck.setVisible(false);
		
		JCheckBox minibarCheck = new JCheckBox("Mini-bar-4000 din");
		minibarCheck.setBounds(199, 353, 132, 23);
		minibarCheck.setForeground(new Color(160, 82, 45));
		minibarCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		minibarCheck.setBackground(new Color(255, 235, 205));
		panel.add(minibarCheck);
		minibarCheck.setVisible(false);
		
		JCheckBox masazacheck = new JCheckBox("Masaza-3400 din");
		masazacheck.setBounds(333, 353, 142, 23);
		masazacheck.setForeground(new Color(160, 82, 45));
		masazacheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		masazacheck.setBackground(new Color(255, 235, 205));
		panel.add(masazacheck);
		masazacheck.setVisible(false);
		
		JCheckBox checkSauna = new JCheckBox("Sauna-4500 din");
		checkSauna.setForeground(new Color(160, 82, 45));
		checkSauna.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkSauna.setBackground(new Color(255, 235, 205));
		checkSauna.setBounds(82, 392, 113, 23);
		panel.add(checkSauna);
		
		JCheckBox VeceraCheck = new JCheckBox("Vecera-1000 din");
		VeceraCheck.setForeground(new Color(160, 82, 45));
		VeceraCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		VeceraCheck.setVisible(false);
		VeceraCheck.setBackground(new Color(255, 235, 205));
		VeceraCheck.setBounds(333, 311, 113, 23);
		panel.add(VeceraCheck);
		
		JCheckBox OdabirOpcijaCheck = new JCheckBox("Potvrdi odabir dodatnih opcija");
		OdabirOpcijaCheck.setForeground(new Color(139, 69, 19));
		OdabirOpcijaCheck.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		OdabirOpcijaCheck.setBackground(new Color(222, 184, 135));
		OdabirOpcijaCheck.setBounds(135, 465, 340, 23);
		panel.add(OdabirOpcijaCheck);
		OdabirOpcijaCheck.setVisible(false);
		checkSauna.setVisible(false);
		
		
		
		
		
		

//popravi situaciju akada ne postoji rezervacija, uopste za odredjeni tip sobe!!!!!!!!!!!!		
//uzmi u obzir da ti cenovnik dolazak moze biti before kraja vazenja i after pocetka, a kraj rezervacije after poceka vazenja i before kraja vazenja
	
		
		btnRezultati.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	float cenaNocenjaPrviDeo=0;
		    	float cenaNocenjaDrugiDeo=0;
		    	

		        if (validateDate(dolazaktxt.getText()) && validateDate(odlazaktxt.getText())) {
		        	
		        	LocalDate dolazak=LocalDate.parse(dolazaktxt.getText());
		        	LocalDate odlazak=LocalDate.parse(odlazaktxt.getText());
		        	
		        	if(dolazak.isBefore(odlazak) && dolazak.isAfter(LocalDate.now())){
		        		
		        		if(!AplikacijaUtilities.proveriRezervacije(dolazak, odlazak, comboBox.getSelectedItem().toString())){
		        			
		        			
		        			for (Cenovnik cenovnik:AplikacijaUtilities.getCenovnik()) {
		        				
		        				if(cenovnik.getSifraCenovnika().equals(comboBox.getSelectedItem().toString())) {
		        					
		        					if(dolazak.isAfter(cenovnik.getPocetniDatumVazenja())&& dolazak.isBefore(cenovnik.getKrajnjiDatumVazenja())) {
		        						
		        					
		        					
		        					float brojDanaDolazakKrajCenovnika=ChronoUnit.DAYS.between(dolazak, cenovnik.getKrajnjiDatumVazenja());
		        					
		        					long brojDanaRezervacije = ChronoUnit.DAYS.between(dolazak, odlazak);
		        					
		        					//slucaj kada se preklapa u dva cenovnika
		        					if(brojDanaDolazakKrajCenovnika<brojDanaRezervacije) {
		        						cenaNocenjaPrviDeo+=Float.parseFloat(cenovnik.getCena())*brojDanaDolazakKrajCenovnika;
		        						
		        						for(Cenovnik cenovnik1:AplikacijaUtilities.getCenovnik()){
		        							if(odlazak.isAfter(cenovnik1.getPocetniDatumVazenja())&& odlazak.isBefore(cenovnik1.getKrajnjiDatumVazenja())) {
		        								float brojDanaPocetakCenovnikaKrajRez=ChronoUnit.DAYS.between(cenovnik1.getPocetniDatumVazenja(), odlazak );
		        								cenaNocenjaDrugiDeo+=Float.parseFloat(cenovnik1.getCena())*brojDanaPocetakCenovnikaKrajRez;
		        								
		        							}
		        						}
		        						ukupnaCena = cenaNocenjaPrviDeo+cenaNocenjaDrugiDeo;
		        					}
		        					
		        					//slucaj kada radimo samo sa jednim cenovnikom
		        					else {
									    float cenaNocenja=Float.parseFloat(cenovnik.getCena());
									    ukupnaCena=cenaNocenja*brojDanaRezervacije;
		        						
		        					}
		        					
		        					int dialogButton = JOptionPane.showConfirmDialog(null, "Odabrani apartman je slobodan u odabranom terminu'\n'Ukupna cena za "+brojDanaRezervacije+" nocenja je: "+ukupnaCena+" din.'\n'Da li zelite da nastavite sa rezervacijom?","Predracun", JOptionPane.YES_NO_OPTION);
		        					
		        					if(dialogButton == JOptionPane.YES_OPTION) {
		        						
		        						//ponudi opciju odabira dodatnih opcija
		        						lblDodatne.setVisible(true);
		        						masazacheck.setVisible(true);
		        						checkSauna.setVisible(true);
		        						minibarCheck.setVisible(true);
		        						spaCheck.setVisible(true);
		        						checkRucak.setVisible(true);
		        						checkDorucak.setVisible(true);
		        						VeceraCheck.setVisible(true);
		        						OdabirOpcijaCheck.setVisible(true);
		        						
		        						
		        						for (DodatneUsluge usluga:AplikacijaUtilities.getDodatneUsluge()) {
											
											
											masazacheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
												
												
												if (usluga.getNazivUsluge().equals("masaza")) {
												float cenaMasaze=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaMasaze;
												System.out.println(ukupnaCena);
												}
												}});
											
											checkSauna.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
												
												if (usluga.getNazivUsluge().equals("sauna")) {
												float cenaSaune=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaSaune;}}
											});
											
											minibarCheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
													
												
												if (usluga.getNazivUsluge().equals("mini-bar")) {
												float cenaBara=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaBara;}
											}});
											
											spaCheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
												
												if (usluga.getNazivUsluge().equals("spa")) {
												float cenaSpa=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaSpa;}
											}});
											
											checkRucak.addItemListener(new ItemListener(){
												
	
												public void itemStateChanged(ItemEvent e) {
											
												
												if (usluga.getNazivUsluge().equals("rucak")) {
												float cenaRucak=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaRucak;}}
												});
											
											checkDorucak.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
											
												
												if (usluga.getNazivUsluge().equals("dorucak")) {
												float cenaDorucak=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaDorucak;
												}
												
											}});
											VeceraCheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
											
												
												if (usluga.getNazivUsluge().equals("vecera")) {
												float cenaVecera=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaVecera;
												}
											}
										});}
		        						
		        						OdabirOpcijaCheck.addItemListener(new ItemListener() {
		        					         public void itemStateChanged(ItemEvent e) {
		        					        	 if(OdabirOpcijaCheck.isSelected()){
		        					        	 	Rezervacije rezervacija1=new Rezervacije();
											    	rezervacija1.setCheckIn(dolazak);
											    	rezervacija1.setCheckOut(odlazak);
											    	Apartmani apartman=AplikacijaUtilities.vratiApartmanNaseRez(dolazak, odlazak, comboBox.getSelectedItem().toString());

											    	
											    	rezervacija1.setApartman(apartman);
											    	Zaposleni sobarica=AplikacijaUtilities.pronadjiSobaricuKojaCisti();

											    	rezervacija1.setGost(gost);
											    	rezervacija1.setDosao(false);
											    	rezervacija1.setOtisao(false);
											    	rezervacija1.setStatus(StatusRezervacije.NA_CEKANJU);
											    	rezervacija1.setUkupnaCenaRezervacije(ukupnaCena);
											    	rezervacija1.setSifraRezervacije(AplikacijaUtilities.IDGeneratorRezervacije());
											    	
											    	
											    	
											    	AplikacijaUtilities.getRezervacije().add(rezervacija1);
											    	AplikacijaUtilities.sacuvajRezervacije();
											    	
												    JOptionPane.showMessageDialog(null, "Uspesno kreirana rezervacija!'\n'Ukupna cena apartmana sa zeljenim dodatnim uslugama iznosi: "+ukupnaCena+" din.'\n'","Konacni racun", JOptionPane.INFORMATION_MESSAGE);
		        					        	 }  
		        					         }});
		        					}
		        					
		        				} else if (!(dolazak.isAfter(cenovnik.getPocetniDatumVazenja())&& dolazak.isBefore(cenovnik.getKrajnjiDatumVazenja()))) {
		        					System.out.println("-------------------------------------------------------------------");
		        					JOptionPane.showMessageDialog(null, "Zao nam je! Nemamo formiran cenovnik za dati period, te ne mozemo izvrsiti rezervaciju :(","Obavestenje", JOptionPane.INFORMATION_MESSAGE);	
		        				}
		        					
		        			}
		        				
		        			}
		        		}
		        		
		        		else if(AplikacijaUtilities.proveriDaLiJeRezervacijaUOpseguRezervisanih(dolazak, odlazak, comboBox.getSelectedItem().toString())) {
		        			JOptionPane.showMessageDialog(null, "Zao nam je! Nemamo apartmane odabarnog tipa u zeljenom periodu :(","Obavestenje", JOptionPane.INFORMATION_MESSAGE);
		        			
		        		}
		        		
		        		
		        		//soba nije pronadjena u rezervacijama, znaci svaki termin je free
		        		else {
		        			for (Cenovnik cenovnik:AplikacijaUtilities.getCenovnik()) {
		        				
		        				if(cenovnik.getSifraCenovnika().equals(comboBox.getSelectedItem().toString())) {
		        					
		        					if(dolazak.isAfter(cenovnik.getPocetniDatumVazenja())&& dolazak.isBefore(cenovnik.getKrajnjiDatumVazenja())) {
		        						
		        					
		        					
		        					float brojDanaDolazakKrajCenovnika=ChronoUnit.DAYS.between(dolazak, cenovnik.getKrajnjiDatumVazenja());
		        					
		        					long brojDanaRezervacije = ChronoUnit.DAYS.between(dolazak, odlazak);
		        					
		        					//slucaj kada se preklapa u dva cenovnika
		        					if(brojDanaDolazakKrajCenovnika<brojDanaRezervacije) {
		        						cenaNocenjaPrviDeo+=Float.parseFloat(cenovnik.getCena())*brojDanaDolazakKrajCenovnika;
		        						
		        						for(Cenovnik cenovnik1:AplikacijaUtilities.getCenovnik()){
		        							if(odlazak.isAfter(cenovnik1.getPocetniDatumVazenja())&& odlazak.isBefore(cenovnik1.getKrajnjiDatumVazenja())) {
		        								float brojDanaPocetakCenovnikaKrajRez=ChronoUnit.DAYS.between(cenovnik1.getPocetniDatumVazenja(), odlazak );
		        								cenaNocenjaDrugiDeo+=Float.parseFloat(cenovnik1.getCena())*brojDanaPocetakCenovnikaKrajRez;
		        								
		        							}
		        						}
		        						ukupnaCena = cenaNocenjaPrviDeo+cenaNocenjaDrugiDeo;
		        					}
		        					
		        					//slucaj kada radimo samo sa jednim cenovnikom
		        					else {
									    float cenaNocenja=Float.parseFloat(cenovnik.getCena());
									    ukupnaCena=cenaNocenja*brojDanaRezervacije;
		        						
		        					}
		        					int dialogButton = JOptionPane.showConfirmDialog(null, "Odabrani apartman je slobodan u odabranom terminu'\n'Ukupna cena za "+brojDanaRezervacije+" nocenja je: "+ukupnaCena+" din.'\n'Da li zelite da nastavite sa rezervacijom?","Predracun", JOptionPane.YES_NO_OPTION);
		        					if(dialogButton == JOptionPane.YES_OPTION) {
		        						
		        						//ponudi opciju odabira dodatnih opcija
		        						lblDodatne.setVisible(true);
		        						masazacheck.setVisible(true);
		        						checkSauna.setVisible(true);
		        						minibarCheck.setVisible(true);
		        						spaCheck.setVisible(true);
		        						checkRucak.setVisible(true);
		        						checkDorucak.setVisible(true);
		        						VeceraCheck.setVisible(true);
		        						OdabirOpcijaCheck.setVisible(true);
		        						
		        						for (DodatneUsluge usluga:AplikacijaUtilities.getDodatneUsluge()) {
											
											
											masazacheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
												
												
												if (usluga.getNazivUsluge().equals("masaza")) {
												float cenaMasaze=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaMasaze;
												System.out.println(ukupnaCena);
												}
												}});
											
											checkSauna.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
												
												if (usluga.getNazivUsluge().equals("sauna")) {
												float cenaSaune=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaSaune;}}
											});
											
											minibarCheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
													
												
												if (usluga.getNazivUsluge().equals("mini-bar")) {
												float cenaBara=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaBara;}
											}});
											
											spaCheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
												
												if (usluga.getNazivUsluge().equals("spa")) {
												float cenaSpa=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaSpa;}
											}});
											
											checkRucak.addItemListener(new ItemListener(){
												
	
												public void itemStateChanged(ItemEvent e) {
											
												
												if (usluga.getNazivUsluge().equals("rucak")) {
												float cenaRucak=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaRucak;}}
												});
											
											checkDorucak.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
											
												
												if (usluga.getNazivUsluge().equals("dorucak")) {
												float cenaDorucak=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaDorucak;
												}
												
											}});
											VeceraCheck.addItemListener(new ItemListener(){
												public void itemStateChanged(ItemEvent e) {
											
												
												if (usluga.getNazivUsluge().equals("vecera")) {
												float cenaVecera=Float.parseFloat(usluga.getCenaUsluge());
												ukupnaCena+=cenaVecera;
												}
											}
										});}
		        						
		        						OdabirOpcijaCheck.addItemListener(new ItemListener() {
		        					         public void itemStateChanged(ItemEvent e) {
		        					        	 if(OdabirOpcijaCheck.isSelected()){
		        					        	 	Rezervacije rezervacija1=new Rezervacije();
											    	rezervacija1.setCheckIn(dolazak);
											    	rezervacija1.setCheckOut(odlazak);
											    	Apartmani apartman=AplikacijaUtilities.vratiApartmanNaseRez(dolazak, odlazak, comboBox.getSelectedItem().toString());

											    	
											    	rezervacija1.setApartman(apartman);
											    	Zaposleni sobarica=AplikacijaUtilities.pronadjiSobaricuKojaCisti();

											    	rezervacija1.setGost(gost);
											    	rezervacija1.setDosao(false);
											    	rezervacija1.setOtisao(false);
											    	rezervacija1.setStatus(StatusRezervacije.NA_CEKANJU);
											    	rezervacija1.setUkupnaCenaRezervacije(ukupnaCena);
											    	rezervacija1.setSifraRezervacije(AplikacijaUtilities.IDGeneratorRezervacije());
											    	
											    	
											    	
											    	AplikacijaUtilities.getRezervacije().add(rezervacija1);
											    	AplikacijaUtilities.sacuvajRezervacije();
											    	
												    JOptionPane.showMessageDialog(null, "Uspesno kreirana rezervacija!'\n'Ukupna cena apartmana sa zeljenim dodatnim uslugama iznosi: "+ukupnaCena+" din.'\n'","Konacni racun", JOptionPane.INFORMATION_MESSAGE);
		        					        	 }  
		        					         }});
		        					}}
		        					}
		        				}


		        		}
		        		
		        		
		        		
		        		
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(null, "Greska! Ne mozete izvrsiti rezervaciju za datume u proslosti!","Obavestenje", JOptionPane.ERROR_MESSAGE);
		        		
		        	}
		        	
		        }
		        
		    }


		});
		}
	public boolean validateDate(String date) {
		try 
		{
		    LocalDate ld = LocalDate.parse( date ) ;
		    return true;
		}
		catch ( DateTimeException e )
		{
			JOptionPane.showMessageDialog(null, "Unesite pocetaak i kraj izvestaja u ispravnom formatu!", "Greska", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	    	
	    }
	}

