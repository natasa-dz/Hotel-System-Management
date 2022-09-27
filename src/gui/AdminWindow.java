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

import org.knowm.xchart.SwingWrapper;

import korisnici.Korisnik;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private Korisnik zaposlen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow(null);
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

public AdminWindow(Korisnik zaposlen) {
	//public AdminWindow() {
		this.zaposlen = zaposlen;
		setTitle("ADMINISTRATOR|" + "korisnicko ime: " + zaposlen.getkorisnickoIme() );
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
		
		JLabel recmlbl = new JLabel("Dobrodosli u administratorski meni!");
		recmlbl.setForeground(new Color(160, 82, 45));
		recmlbl.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(recmlbl);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu meni = new JMenu("REZERVACIJE");
		meni.setForeground(new Color(160, 82, 45));
		meni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem rezervacijeKorisnika = new JMenuItem("Korisnicke rezervacije");
		rezervacijeKorisnika.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rezervacijeKorisnika.setBackground(new Color(255, 248, 220));
		
		meni.add(rezervacijeKorisnika);
		menuBar.add(meni);
		
		JMenu menuZaposleni = new JMenu("ZAPOSLENI");
		menuZaposleni.setForeground(new Color(160, 82, 45));
		menuZaposleni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			
		JMenuItem prikaziZaposlene = new JMenuItem("Prikazi zaposlene");
		prikaziZaposlene.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziZaposlene.setBackground(new Color(255, 248, 220));
		
		menuZaposleni.add(prikaziZaposlene);
		menuBar.add(menuZaposleni);
		
		JMenu gostimenu = new JMenu("GOSTI");
		gostimenu.setForeground(new Color(160, 82, 45));
		gostimenu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem prikaziGoste = new JMenuItem("Prikazi goste");
		prikaziGoste.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziGoste.setBackground(new Color(255, 248, 220));
		
		gostimenu.add(prikaziGoste);
		menuBar.add(gostimenu);
		
		JMenu menuSobe = new JMenu("SOBE");
		menuSobe.setForeground(new Color(160, 82, 45));
		menuSobe.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem prikaziSobe = new JMenuItem("Prikazi sobe");
		prikaziSobe.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziSobe.setBackground(new Color(255, 248, 220));
		
		menuSobe.add(prikaziSobe);
		menuBar.add(menuSobe);
		
		JMenu menuCharts = new JMenu("CHARTOVI");
		menuCharts.setForeground(new Color(160, 82, 45));
		menuCharts.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem prikaziChartove = new JMenuItem("Sobarice Piechart");
		prikaziChartove.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziChartove.setBackground(new Color(255, 248, 220));
		
		menuCharts.add(prikaziChartove);
		menuBar.add(menuCharts);
		
		
		JMenuItem prikaziRezervacijeChart = new JMenuItem("Rezervacije Piechart");
		prikaziRezervacijeChart.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziRezervacijeChart.setBackground(new Color(255, 248, 220));
		
		menuCharts.add(prikaziRezervacijeChart);
		menuBar.add(menuCharts);
		
		
		JMenuItem RezLineChart = new JMenuItem("Rezervacije Linechart");
		RezLineChart.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		RezLineChart.setBackground(new Color(255, 248, 220));
		
		menuCharts.add(RezLineChart);
		menuBar.add(menuCharts);
		
		
		JMenu menuIzv = new JMenu("IZVESTAJI");
		menuIzv.setForeground(new Color(160, 82, 45));
		menuIzv.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem prikaziSobariceIzv = new JMenuItem("Sobarice izvestaji");
		prikaziSobariceIzv.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziSobariceIzv.setBackground(new Color(255, 248, 220));
		
		menuIzv.add(prikaziSobariceIzv);
		menuBar.add(menuIzv);
		
		
		JMenuItem prikaziSobeIzv = new JMenuItem("Sobe izvestaji");
		prikaziSobeIzv.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		prikaziSobeIzv.setBackground(new Color(255, 248, 220));
		
		menuIzv.add(prikaziSobeIzv);
		menuBar.add(menuIzv);
		
		
		JMenuItem statusRezIzv = new JMenuItem("Status rezervacija izvestaji");
		statusRezIzv.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		statusRezIzv.setBackground(new Color(255, 248, 220));
		
		menuIzv.add(statusRezIzv);
		menuBar.add(menuIzv);
		
		
		RezLineChart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					Thread newThread=new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							  RezervacijeLineChart chart= new RezervacijeLineChart();
							  new SwingWrapper(chart.getChart()).displayChart();
							
						}});
					newThread.start();
				
			
			
			
			
			
			
			
			}});
		
		statusRezIzv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StatusRezervacijaIzvestaj rez=new StatusRezervacijaIzvestaj();
				rez.setVisible(true);
				
			}});
		
		
		prikaziSobariceIzv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SobaricaOpseg rez=new SobaricaOpseg();
				rez.setVisible(true);
				
			}});
		
		
		prikaziSobeIzv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IzvestajSoba rez=new IzvestajSoba();
				rez.setVisible(true);
				
			}});
		
		
		prikaziRezervacijeChart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Thread newThread=new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						  PieChartRezervacije chart= new PieChartRezervacije();
						  new SwingWrapper(chart.getChart()).displayChart();
						
					}});
				newThread.start();
				// TODO Auto-generated method stub
				
			}});
		
		
		prikaziChartove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Thread newThread=new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						  SobaricePieChart chart= new SobaricePieChart();
						  new SwingWrapper(chart.getChart()).displayChart();
						
					}});
				newThread.start();
				// TODO Auto-generated method stub
				
			}});

		
		rezervacijeKorisnika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RezervacijeRecepcionar rez = new RezervacijeRecepcionar(zaposlen);
				rez.setVisible(true);
				
			}});
		
		prikaziZaposlene.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrikazZaposlenih zaposlen = new PrikazZaposlenih();
				zaposlen.setVisible(true);
				
			}});
		
		prikaziGoste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrikaziGoste gost = new PrikaziGoste();
				gost.setVisible(true);
				
			}});
		
		prikaziSobe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PregledApartmanaZaposleni apartman = new PregledApartmanaZaposleni();
				apartman.setVisible(true);
				
			}});
		
		

	}	
}
