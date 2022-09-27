package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Cenovnik;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DodajCenovnik extends JFrame {
	private Cenovnik cenovnik;

	private JPanel contentPane;
	private JTextField txtPocetak;
	private JTextField txtKraj;
	private JTextField txtCena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajCenovnik frame = new DodajCenovnik(null);
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
	public DodajCenovnik(Cenovnik cenovnik) {
		this.cenovnik=cenovnik;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(400, 400, 459, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(-11, 0, 481, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(0, 0, 475, 29);
		panel.add(panel_1);
		
		JLabel formalbl = new JLabel("Forma za azuriranje cenovnika");
		formalbl.setForeground(new Color(160, 82, 45));
		formalbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel_1.add(formalbl);
		
		
		JLabel Imelbl = new JLabel("Sifra cenovnika: ");
		Imelbl.setForeground(new Color(160, 82, 45));
		Imelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Imelbl.setBounds(16, 47, 138, 16);
		panel.add(Imelbl);
		
		JLabel Prezimelbl = new JLabel("Pocetak vazenja: ");
		Prezimelbl.setForeground(new Color(160, 82, 45));
		Prezimelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Prezimelbl.setBounds(16, 88, 124, 16);
		panel.add(Prezimelbl);
		
		JLabel korisnickoImelbl = new JLabel("Kraj vazenja: ");
		korisnickoImelbl.setBounds(16, 137, 124, 16);
		korisnickoImelbl.setForeground(new Color(160, 82, 45));
		korisnickoImelbl.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panel.add(korisnickoImelbl);
		
		//AplikacijaUtilities.ucitajApartmane();
		JComboBox<String> comboSifra = new JComboBox<String>();
		for(
			Apartmani apartman:AplikacijaUtilities.getApartmani()) {
			comboSifra.addItem(apartman.getTipApartmana());
			
		}
		comboSifra.setBounds(169, 45, 204, 22);
		panel.add(comboSifra);
		
		txtPocetak = new JTextField();
		txtPocetak.setBounds(169, 87, 204, 20);
		panel.add(txtPocetak);
		txtPocetak.setColumns(10);
		
		txtKraj = new JTextField();
		txtKraj.setBounds(169, 136, 204, 20);
		panel.add(txtKraj);
		txtKraj.setColumns(10);
		
		JButton btnCenovnik = new JButton("Izmeni/Dodaj cenovnik");
		btnCenovnik.setBounds(125, 225, 228, 23);
		panel.add(btnCenovnik);
		
		JLabel lblNewLabel = new JLabel("Cena nocenja (RSD):");
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(16, 182, 138, 14);
		panel.add(lblNewLabel);
		
		txtCena = new JTextField();
		txtCena.setBounds(169, 179, 129, 20);
		panel.add(txtCena);
		txtCena.setColumns(10);
		
		
		if (this.cenovnik==null) {
			setTitle("Dodavanje cenovnika");
		}
		else {
			setTitle("Izmena cenovnika");
		}
		
		

	
	
	if(this.cenovnik!=null) {
		comboSifra.setSelectedItem(this.cenovnik.getSifraCenovnika());
		txtPocetak.setText(this.cenovnik.getPocetniDatumVazenja().toString());
		txtKraj.setText(this.cenovnik.getKrajnjiDatumVazenja().toString());
		txtCena.setText(cenovnik.getCena());
		
	}
	
	
	btnCenovnik.addActionListener(new ActionListener(){

		@Override
		//NE ZABORAVI DA DODAS INPUT DATUMA, I ONDA MEMORISANJE ZAPOSLENOG
		public void actionPerformed(ActionEvent e) {
			
			String pocetakVazenja = txtPocetak.getText().trim();
			String krajVazenja = txtKraj.getText().trim();
			
			if (validirajPodatke()==true && validateDate(pocetakVazenja) && validateDate(pocetakVazenja) ) {
				LocalDate pocetak=LocalDate.parse(pocetakVazenja);
				LocalDate kraj=LocalDate.parse(krajVazenja);
				if(ValidateBeforeAndAfter(pocetak, kraj)) {
				

				String cena = txtCena.getText().trim();
				String sifraApartmana=comboSifra.getSelectedItem().toString();
				
				
				if(cenovnik!=null) {
					
					cenovnik.setCena(cena);
					cenovnik.setKrajnjiDatumVazenja(LocalDate.parse(krajVazenja));
					cenovnik.setPocetniDatumVazenja(LocalDate.parse(pocetakVazenja));
					cenovnik.setSifraCenovnika(sifraApartmana);
					AplikacijaUtilities.sacuvajCenovnik();
			    	JOptionPane.showMessageDialog(null, "Uspesno ste azurirali postojeci cenovnik", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);

						
				}
				else {
					Cenovnik cenovnik1=new Cenovnik(sifraApartmana, LocalDate.parse(pocetakVazenja), LocalDate.parse(krajVazenja), cena);
					AplikacijaUtilities.getCenovnik().add(cenovnik1);
					AplikacijaUtilities.sacuvajCenovnik();
					JOptionPane.showMessageDialog(null, "Uspesno ste dodali novi cenovnik", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				}}
				else {
					JOptionPane.showMessageDialog(null, "Unesite pocetaak i kraj izvestaja u ispravnom formatu!", "Greska", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				
				DodajCenovnik.this.dispose();
				DodajCenovnik.this.setVisible(false);
			}
			else {
			JOptionPane.showMessageDialog(null, "Pokusajte ponovo!", "Greska", JOptionPane.ERROR_MESSAGE);}
			
			
			
			
			
		}});

}	
	private boolean validirajPodatke() {
		String praznoPolje="Sva polja moraju biti popunjena!\n";
		String neispravanUnos="Neispravan unos!\n";
		boolean ispravniPodaci=true;
		
		if(txtPocetak.getText().trim().equals("")) {
			praznoPolje+="Ime;\n";
			ispravniPodaci=false;
		}
		if (txtKraj.getText().trim().equals("")) {
			praznoPolje+="Prezime;\n";
			ispravniPodaci=false;
		}
		if (txtCena.getText().trim().equals("")) {
			praznoPolje+="Prezime;\n";
			ispravniPodaci=false;
		}
		
		if(txtCena.getText().chars().allMatch( Character::isDigit )!=true) {
			neispravanUnos += "Br. telefona mora sadrzati samo cifre!\n";
			ispravniPodaci = false;
		}
		return ispravniPodaci;
	}
	public boolean ValidateBeforeAndAfter(LocalDate pocetak, LocalDate kraj) {

		if(pocetak.isBefore(kraj)) {
				return true;
			}

		return false;
		
	
}
	public boolean validateDate(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	    try {
	        sdf.parse(date);
	        return true;
	    }
	    catch(ParseException e) {
	    	JOptionPane.showMessageDialog(null, "Pogresan format datuma", "Greska", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }}
}
