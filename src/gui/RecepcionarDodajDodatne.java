package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.AplikacijaUtilities;
import korisnici.DodatneUsluge;
import korisnici.Korisnik;
import korisnici.Rezervacije;

public class RecepcionarDodajDodatne extends JFrame {

	private JPanel contentPane;
	double ukupnaCena;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecepcionarDodajDodatne frame = new RecepcionarDodajDodatne(null, null, null);
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
	public RecepcionarDodajDodatne(Korisnik recepcionar, String sifraRezervacije, String ukupnacena) {
		
		Double ukupnaCenica=Double.parseDouble(ukupnacena);
		
		
		

		
		
		
		setResizable(false);
		setTitle("Dodavanje dodatnih opcija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 553, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 559, 420);
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
		
		JLabel lblNaslov = new JLabel("Dodavanje dodatnih opcija");
		lblNaslov.setForeground(new Color(160, 82, 45));
		lblNaslov.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(lblNaslov);
		
		JCheckBox checkDorucak = new JCheckBox("Dorucak-1100din");
		checkDorucak.setForeground(new Color(160, 82, 45));
		checkDorucak.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkDorucak.setBackground(new Color(255, 235, 205));
		checkDorucak.setBounds(82, 99, 115, 28);
		panel.add(checkDorucak);
		checkDorucak.setVisible(true);
		
		JCheckBox checkRucak = new JCheckBox("Rucak-1300din");
		checkRucak.setForeground(new Color(160, 82, 45));
		checkRucak.setBackground(new Color(255, 235, 205));
		checkRucak.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkRucak.setBounds(219, 102, 107, 23);
		panel.add(checkRucak);
		checkRucak.setVisible(true);
		
		JLabel lblDodatne = new JLabel("Ukoliko zelite neku od dodatnih usluga, oznacite odgovarajuce polje:");
		lblDodatne.setForeground(new Color(160, 82, 45));
		lblDodatne.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDodatne.setBounds(86, 46, 431, 46);
		panel.add(lblDodatne);
		lblDodatne.setVisible(true);
		
		JCheckBox spaCheck = new JCheckBox("Spa-3800 din");
		spaCheck.setBounds(83, 142, 99, 23);
		spaCheck.setForeground(new Color(160, 82, 45));
		spaCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		spaCheck.setBackground(new Color(255, 235, 205));
		panel.add(spaCheck);
		spaCheck.setVisible(true);
		
		JCheckBox minibarCheck = new JCheckBox("Mini-bar-4000 din");
		minibarCheck.setBounds(219, 142, 132, 23);
		minibarCheck.setForeground(new Color(160, 82, 45));
		minibarCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		minibarCheck.setBackground(new Color(255, 235, 205));
		panel.add(minibarCheck);
		minibarCheck.setVisible(true);
		
		JCheckBox masazacheck = new JCheckBox("Masaza-3400 din");
		masazacheck.setBounds(367, 102, 142, 23);
		masazacheck.setForeground(new Color(160, 82, 45));
		masazacheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		masazacheck.setBackground(new Color(255, 235, 205));
		panel.add(masazacheck);
		masazacheck.setVisible(true);
		
		JCheckBox checkSauna = new JCheckBox("Sauna-4500 din");
		checkSauna.setForeground(new Color(160, 82, 45));
		checkSauna.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkSauna.setBackground(new Color(255, 235, 205));
		checkSauna.setBounds(82, 180, 113, 23);
		panel.add(checkSauna);
		
		JCheckBox VeceraCheck = new JCheckBox("Vecera-1000 din");
		VeceraCheck.setForeground(new Color(160, 82, 45));
		VeceraCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		VeceraCheck.setVisible(false);
		VeceraCheck.setBackground(new Color(255, 235, 205));
		VeceraCheck.setBounds(219, 180, 113, 23);
		panel.add(VeceraCheck);
		
		JCheckBox OdabirBtn = new JCheckBox("Potvrdi odabir dodatnih opcija");
		OdabirBtn.setForeground(new Color(139, 69, 19));
		OdabirBtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		OdabirBtn.setBackground(new Color(222, 184, 135));
		OdabirBtn.setBounds(133, 250, 340, 23);
		panel.add(OdabirBtn);
		OdabirBtn.setVisible(true);
		checkSauna.setVisible(true);
		

		
		OdabirBtn.addActionListener(new ActionListener() {
			


			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// TODO Auto-generated method stub
				
	for (DodatneUsluge usluga:AplikacijaUtilities.getDodatneUsluge()) {
		
				
				
				masazacheck.addItemListener(new ItemListener(){
					
					public void itemStateChanged(ItemEvent e) {
					
					
					if (usluga.getNazivUsluge().equals("masaza")) {
					float cenaMasaze=Float.parseFloat(usluga.getCenaUsluge());
					ukupnaCena+=cenaMasaze;}
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
			});
				
				
	}
	
	
	double ukupnaCena1=ukupnaCenica+ukupnaCena;
	System.out.println(ukupnaCena);
	System.out.println(ukupnaCena1);
	System.out.println(ukupnaCenica);
	System.out.println("--------------------------------------------------------");
	
			if(ukupnaCena1>ukupnaCenica) {
				Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije(sifraRezervacije);
				rezervacija.setUkupnaCenaRezervacije(ukupnaCena);
				System.out.println(rezervacija.getUkupnaCenaRezervacije());
				System.out.println("--------------------------------------------------------------");
				AplikacijaUtilities.sacuvajRezervacije();
				}
			AplikacijaUtilities.sacuvajRezervacije();
			JOptionPane.showMessageDialog(null, "Uspesno izmenjena cena rezervacije!","Obavestenje", JOptionPane.INFORMATION_MESSAGE);	
			RezervacijeRecepcionar rezervacije=new RezervacijeRecepcionar(recepcionar);
			rezervacije.setVisible(true);



	
	
				
			}
			});
		
	}

}
