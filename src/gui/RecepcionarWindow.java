package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import korisnici.Korisnik;
import korisnici.Zaposleni;
import gui.RezervacijeRecepcionar;
import java.awt.Font;
import javax.swing.JLabel;

public class RecepcionarWindow extends JFrame{

private Korisnik zaposlen;
	
	public RecepcionarWindow(Korisnik zaposlen) {
		this.zaposlen = zaposlen;
		setTitle("RECEPCIONAR|" + "korisnicko ime: " + zaposlen.getkorisnickoIme() );
		setVisible(true);
		setResizable(false);
		setBounds(600, 600, 408, 457);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 402, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, 0, 76, 570);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(76, 0, 326, 35);
		panel.add(panel_2);
		
		JLabel recmlbl = new JLabel("Dobrodosli u recepcionarski meni!");
		recmlbl.setForeground(new Color(160, 82, 45));
		recmlbl.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(recmlbl);
		


		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu meni = new JMenu("REZERVACIJE");
		meni.setForeground(new Color(160, 82, 45));
		meni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		meni.setBackground(new Color(255, 239, 213));
		
		JMenuItem rezervacijeKorisnika = new JMenuItem("Korisnicke rezervacije");
		rezervacijeKorisnika.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rezervacijeKorisnika.setBackground(new Color(160, 82, 45));
		
		meni.add(rezervacijeKorisnika);
		menuBar.add(meni);
		
		
		JMenu meniGost = new JMenu("GOSTI");
		meniGost.setForeground(new Color(160, 82, 45));
		meniGost.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		meniGost.setBackground(new Color(255, 239, 213));
		
		JMenuItem dodajGosta = new JMenuItem("Dodaj gosta");
		dodajGosta.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		dodajGosta.setBackground(new Color(160, 82, 45));
		
		meniGost.add(dodajGosta);
		menuBar.add(meniGost);
		
		rezervacijeKorisnika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RezervacijeRecepcionar rez = new RezervacijeRecepcionar(zaposlen);
				rez.setVisible(true);
				
			}
		});
		
		dodajGosta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DodajGoste gost = new DodajGoste(null);
				gost.setVisible(true);
				
			}
		});
		
	}

}
