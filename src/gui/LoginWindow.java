package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.AplikacijaUtilities;
import korisnici.Gost;
import korisnici.Korisnik;
import korisnici.Uloga;
import korisnici.Zaposleni;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
				
					//System.out.println(sifra);
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
	public LoginWindow() {
		
		setBackground(new Color(222, 184, 135));
		setForeground(new Color(222, 184, 135));
		setFont(new Font("Century Gothic", Font.PLAIN, 12));
		setTitle("LoginWindow");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 6, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Korisnicko ime:");
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 67, 114, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lozinka:");
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(38, 142, 125, 32);
		contentPane.add(lblNewLabel_1);
		
		JFormattedTextField logintxt = new JFormattedTextField();
		logintxt.setBounds(151, 80, 213, 20);
		contentPane.add(logintxt);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(151, 150, 213, 20);
		contentPane.add(passwordtxt);
		
		JButton btnNewButton = new JButton("Uloguj se");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = logintxt.getText().trim();
				String lozinka = new String(passwordtxt.getPassword());
				
				AplikacijaUtilities.ucitajOcisceneSobe();
				//AplikacijaUtilities.ucitajGoste();
				AplikacijaUtilities.ucitajSveKorisnike();
				AplikacijaUtilities.ucitajApartmane();
				AplikacijaUtilities.ucitajRezervacije();
				AplikacijaUtilities.ucitajDodatneUsluge();
				AplikacijaUtilities.ucitajCenovnik();
				
				boolean uspesnoUlogovan=false;
				for(Korisnik korisnik1 : AplikacijaUtilities.getKorisnici()) {
					
					if(korisnik1.getkorisnickoIme().equals(korisnickoIme) &&
							(korisnik1.getLozinka().equals(lozinka))) {
						
						if (korisnik1 instanceof Zaposleni){

							if (((Zaposleni) korisnik1).getUloga()==Uloga.ADMINISTRATOR){
								
								LoginWindow.this.setVisible(false);
								LoginWindow.this.dispose();
								AdminWindow admin=new AdminWindow(korisnik1);
								admin.setVisible(true);
								
							}
							else if  (((Zaposleni) korisnik1).getUloga()==Uloga.RECEPCIONAR) {
								
								LoginWindow.this.setVisible(false);
								LoginWindow.this.dispose();
								
								RecepcionarWindow recepcionar=new RecepcionarWindow(korisnik1);
								
								recepcionar.setVisible(true);
								
							}
							
							else if  (((Zaposleni) korisnik1).getUloga()==Uloga.SOBARICA) {
								LoginWindow.this.setVisible(false);
								LoginWindow.this.dispose();
								SobaricaWindow sobarica=new SobaricaWindow(korisnik1);
								sobarica.setVisible(true);
							}
						}
						else if(korisnik1 instanceof Gost) {
							LoginWindow.this.setVisible(false);
							LoginWindow.this.dispose();
							GostWindow gost=new GostWindow(korisnik1);
							gost.setVisible(true);
						}
						
						else if (korisnickoIme.equals("") || lozinka.equals("")) {
							JOptionPane.showMessageDialog(null, "Niste uneli sve podatke");
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Ne postoji", "Poruka",JOptionPane.WARNING_MESSAGE);
						}
						uspesnoUlogovan=true;
						break;
						
					}}
					if (uspesnoUlogovan != true) {
						JOptionPane.showMessageDialog(null, "Pogresan unos", "Greska", JOptionPane.WARNING_MESSAGE);
					}
			}
			});
		btnNewButton.setForeground(new Color(160, 82, 45));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setBounds(92, 218, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Odustani");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Kliknuto na odustani!");
				
				//obrisano sve iz txt polja
				logintxt.setText("");
				passwordtxt.setText("");
				//zatvaramo loginWindow i program
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(160, 82, 45));
		btnNewButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setBounds(248, 218, 89, 23);
		contentPane.add(btnNewButton_1);
		

		
		JCheckBox showPassword = new JCheckBox("Prikazi lozinku");
		showPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == showPassword) {
		            if (showPassword.isSelected()) {
		                passwordtxt.setEchoChar((char) 0);
		            } else {
		                passwordtxt.setEchoChar('*');
		            }
			}
			}});
		showPassword.setForeground(new Color(160, 82, 45));
		showPassword.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		showPassword.setBackground(new Color(255, 245, 238));
		showPassword.setBounds(151, 181, 140, 23);
		contentPane.add(showPassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 438, 74);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Dobrodosli u Forza Hotel!");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Projekat-Hotelski servis\\src\\Database\\icons8-hotel-star-64.png"));
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setLabelFor(contentPane);
		lblNewLabel_2.setForeground(new Color(160, 82, 45));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_2.setBackground(new Color(255, 245, 238));
		
	}

}
