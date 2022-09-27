package gui;

import java.time.temporal.ChronoUnit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.annotation.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.ChartTheme;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Pol;
import korisnici.Rezervacije;
import korisnici.StatusRezervacije;
import korisnici.Uloga;

public class IzvestajSoba extends JFrame {

	private JPanel contentPane;
	private JTextField pocetniDatum;
	private JTextField krajnjiDatum;
	private int count;
	private JTextField sifraApartmana;
	private Rezervacije rezervacija;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajCenovnik();
					AplikacijaUtilities.ucitajApartmane();

					AplikacijaUtilities.ucitajSveKorisnike();
					AplikacijaUtilities.ucitajDodatneUsluge();
					AplikacijaUtilities.ucitajRezervacije();

					IzvestajSoba frame = new IzvestajSoba();
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
	public IzvestajSoba() {
		setResizable(false);
		setTitle("Apartmani izvestaj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 553, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 559, 466);
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
		
		JLabel lblNaslov = new JLabel("Izvestaj o apartmanima");
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
		btnRezultati.setBounds(183, 226, 243, 23);
		panel.add(btnRezultati);
		
		JLabel sifraApt = new JLabel("Sifra apartmana za koji se formira izvestaj: ");
		sifraApt.setForeground(new Color(160, 82, 45));
		sifraApt.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		sifraApt.setBounds(86, 157, 243, 14);
		panel.add(sifraApt);
		
		sifraApartmana = new JTextField();
		sifraApartmana.setBounds(86, 182, 169, 20);
		panel.add(sifraApartmana);
		sifraApartmana.setColumns(10);
		
		JLabel lblPrihod = new JLabel("Prihod za trazenu sobu u odabranom periodu je: ");
		lblPrihod.setForeground(new Color(160, 82, 45));
		lblPrihod.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblPrihod.setBounds(98, 311, 439, 35);
		panel.add(lblPrihod);
		lblPrihod.setVisible(false);
		
		JLabel lblNocenja = new JLabel("Ukupan broj nocenja u datoj sobi za zeljeni period je: ");
		lblNocenja.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNocenja.setForeground(new Color(160, 82, 45));
		lblNocenja.setBounds(98, 370, 439, 29);
		panel.add(lblNocenja);
		lblNocenja.setVisible(false);
		
//		JLabel lblIzvestaj = new JLabel("Broj rezervacija sa statusom "+status+" u zeljenom periodu je: ");
//		lblIzvestaj.setForeground(new Color(139, 69, 19));
//		lblIzvestaj.setFont(new Font("Century Gothic", Font.PLAIN, 11));
//		lblIzvestaj.setBounds(99, 317, 383, 35);
//		panel.add(lblIzvestaj);
//		lblIzvestaj.setVisible(false);
		

		

		
		
		btnRezultati.addActionListener(new ActionListener(){
			int brojac;

			

			@Override
			public void actionPerformed(ActionEvent e) {
				int ukupanBrojNocenja=0;
				double prihodZaSobu=0;
				String sifra=sifraApartmana.getText().trim();
				
				
				String dolazakString=pocetniDatum.getText().trim();
				String odlazakString=krajnjiDatum.getText().trim();
				if(ValidirajSifruApartmana(sifra)) {
					
					Apartmani apartman=AplikacijaUtilities.nadjiApartman(sifra);
					//System.out.println(apartman.getSifraApartmana());
				
				if(validateDate(dolazakString)&&validateDate(odlazakString)) {
					
					LocalDate pocetniDatumIzv=LocalDate.parse(dolazakString);
					LocalDate krajnjiDatumIzv=LocalDate.parse(odlazakString);
					
					if(ValidateBeforeAndAfter(pocetniDatumIzv,krajnjiDatumIzv)) {
						
						for (Rezervacije rezervacija:AplikacijaUtilities.getRezervacije()) {
							
							
							
							if(rezervacija.getApartman().getSifraApartmana().equals(sifra)) {
								
								if(rezervacija.getCheckIn().isAfter(pocetniDatumIzv) && rezervacija.getCheckIn().isBefore(krajnjiDatumIzv)) {
									
									if(rezervacija.getCheckOut().isBefore(krajnjiDatumIzv)) {
								
										if(rezervacija.getStatus().equals(StatusRezervacije.OTKAZANA)) {

											prihodZaSobu+=rezervacija.getUkupnaCenaRezervacije();
										}

											
										if(rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)&& rezervacija.isDosao() && rezervacija.isOtisao() ) {

											long BrojNocenja=nadjiBrojNocenja(rezervacija.getCheckIn(),rezervacija.getCheckOut());
											ukupanBrojNocenja+=BrojNocenja;
											prihodZaSobu+=rezervacija.getUkupnaCenaRezervacije();
											}
										
										lblNocenja.setText("Ukupan broj nocenja u datoj sobi za zeljeni period je: ");
										lblNocenja.setText("Ukupan broj nocenja u datoj sobi za zeljeni period je: "+ukupanBrojNocenja+" DANA");
										lblNocenja.setVisible(true);
										lblPrihod.setText("Prihod za trazenu sobu u odabranom periodu je: ");
										lblPrihod.setText("Prihod za trazenu sobu u odabranom periodu je: "+prihodZaSobu+" RSD");
										lblPrihod.setVisible(true);
										
									
									}
									

								}
								
								else {
									JOptionPane.showMessageDialog(null, "Zao nam je, ali u odabranom periodu ne postoji izvestaj za prikaz!", "Greska", JOptionPane.ERROR_MESSAGE);
									break;
								}
								
							}
						}
					
				
					}}
				}}
			});
		
	}
	
	
public long nadjiBrojNocenja(LocalDate checkIn, LocalDate checkOut) {
		// TODO Auto-generated method stub
		long daysCount=ChronoUnit.DAYS.between(checkIn, checkOut);
		return daysCount;
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

public boolean ValidirajSifruApartmana(String sifra) {
	for(Apartmani apartman:AplikacijaUtilities.getApartmani()) {
		if(apartman.getSifraApartmana().equals(sifra)) {
			return true;
		}
		
		
	}
	JOptionPane.showMessageDialog(null, "Uneli ste nepostojecu sifru apartmana!", "Greska", JOptionPane.ERROR_MESSAGE);
	return false;
	
	
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
}
