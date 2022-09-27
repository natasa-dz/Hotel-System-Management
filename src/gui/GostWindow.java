package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.Korisnik;

public class GostWindow extends JFrame {

	private JPanel contentPane;
	private Korisnik gost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GostWindow frame = new GostWindow(null);
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
	public GostWindow(Korisnik gost) {
		this.gost=gost;
		setTitle("Gost|" + "korisnicko ime: " + gost.getkorisnickoIme() );
		setVisible(true);
		setResizable(false);
		setBounds(600, 600, 427, 457);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 423, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, 0, 76, 570);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(76, 0, 337, 35);
		panel.add(panel_2);
		
		JLabel recmlbl = new JLabel("Dobrodosli u gostinski meni!");
		recmlbl.setForeground(new Color(160, 82, 45));
		recmlbl.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(recmlbl);
		


		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu meni = new JMenu("REZERVACIJE");
		meni.setForeground(new Color(160, 82, 45));
		meni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem rezervacijeKorisnika = new JMenuItem("Vase rezervacije");
		rezervacijeKorisnika.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rezervacijeKorisnika.setBackground(new Color(255, 248, 220));
		
		meni.add(rezervacijeKorisnika);
		menuBar.add(meni);
		
		JMenu menuApartmani = new JMenu("APARTMANI");
		menuApartmani.setForeground(new Color(160, 82, 45));
		menuApartmani.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			
		JMenuItem prikaziApartmane = new JMenuItem("Prikazi apartmane-osnvni tip rezervacije");
		prikaziApartmane.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziApartmane.setBackground(new Color(255, 248, 220));
		
		menuApartmani.add(prikaziApartmane);
		menuBar.add(menuApartmani);
		
		
		JMenuItem naprednaPretraga = new JMenuItem("Visekriterijumski tip pretrage");
		naprednaPretraga.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		naprednaPretraga.setBackground(new Color(255, 248, 220));
		
		menuApartmani.add(naprednaPretraga);
		menuBar.add(menuApartmani);
		
		
		naprednaPretraga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodatniKriterijumPretraga dod=new DodatniKriterijumPretraga(gost);
				dod.setVisible(true);	
			}});
		
		
		rezervacijeKorisnika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RezervacijeKorisnika rez = new RezervacijeKorisnika(gost);
				rez.setVisible(true);
				
			}});
		
		prikaziApartmane.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrikaziSobe soba = new PrikaziSobe(gost);
				soba.setVisible(true);
				
			}});
		

		
		

	}	
}
