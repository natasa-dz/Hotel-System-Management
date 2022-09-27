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

import korisnici.AplikacijaUtilities;
import korisnici.Korisnik;

public class SobaricaWindow extends JFrame {

	private JPanel contentPane;
	private Korisnik sobarica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobaricaWindow frame = new SobaricaWindow(null);
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
	public SobaricaWindow(Korisnik sobarica) {
		this.sobarica=sobarica;
		setTitle("Sobarica|" + "korisnicko ime: " + sobarica.getkorisnickoIme() );
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
		
		JLabel recmlbl = new JLabel("Dobrodosli u glavni meni za sobarice!");
		recmlbl.setForeground(new Color(160, 82, 45));
		recmlbl.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(recmlbl);
		


		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu meni = new JMenu("APARTMANI");
		meni.setForeground(new Color(160, 82, 45));
		meni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		
		JMenuItem apartmaniSobarica = new JMenuItem("Sobe za ocistiti");
		apartmaniSobarica.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		apartmaniSobarica.setBackground(new Color(255, 248, 220));
		
		meni.add(apartmaniSobarica);
		menuBar.add(meni);
		
	
	
	apartmaniSobarica.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SobariceApartmani soba = new SobariceApartmani(sobarica);
			soba.setVisible(true);
			
		}});

}}
