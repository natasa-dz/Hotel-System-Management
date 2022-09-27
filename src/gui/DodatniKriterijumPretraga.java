package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.junit.platform.commons.util.CollectionUtils;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Gost;
import korisnici.Korisnik;
import korisnici.Rezervacije;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class DodatniKriterijumPretraga extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajSveKorisnike();
					AplikacijaUtilities.ucitajCenovnik();
					AplikacijaUtilities.ucitajApartmane();
					DodatniKriterijumPretraga frame = new DodatniKriterijumPretraga(null);
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
	public DodatniKriterijumPretraga(Korisnik gost) {
		setResizable(false);
		setTitle("Kriterijumska pretraga apartmana");
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
		
		JLabel lblNaslov = new JLabel("Kriterijumska pretraga apartmana");
		lblNaslov.setForeground(new Color(160, 82, 45));
		lblNaslov.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(lblNaslov);
		
		JLabel dodatneLbl = new JLabel("Odaberi dodatne kriterijume za pretragu: ");
		dodatneLbl.setForeground(new Color(160, 82, 45));
		dodatneLbl.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		dodatneLbl.setBounds(86, 46, 303, 35);
		panel.add(dodatneLbl);
		
		JCheckBox checkPusacka = new JCheckBox("Pusacka soba");
		checkPusacka.setForeground(new Color(160, 82, 45));
		checkPusacka.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkPusacka.setBackground(new Color(255, 235, 205));
		checkPusacka.setBounds(96, 88, 137, 23);
		panel.add(checkPusacka);
		
		JCheckBox checkNepusacka= new JCheckBox("Nepusacka soba");
		checkNepusacka.setForeground(new Color(160, 82, 45));
		checkNepusacka.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		checkNepusacka.setBackground(new Color(255, 235, 205));
		checkNepusacka.setBounds(96, 131, 137, 23);
		panel.add(checkNepusacka);
		
		JCheckBox Balkoncheck = new JCheckBox("Balkon");
		Balkoncheck.setForeground(new Color(160, 82, 45));
		Balkoncheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		Balkoncheck.setBackground(new Color(255, 235, 205));
		Balkoncheck.setBounds(265, 88, 124, 23);
		panel.add(Balkoncheck);
		
		
		JCheckBox TVCheck = new JCheckBox("TV");
		TVCheck.setForeground(new Color(160, 82, 45));
		TVCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		TVCheck.setBackground(new Color(255, 235, 205));
		TVCheck.setBounds(391, 110, 118, 23);
		panel.add(TVCheck);
		
		JCheckBox KlimaCheck = new JCheckBox("Klima");
		KlimaCheck.setBounds(265, 131, 118, 23);
		KlimaCheck.setForeground(new Color(160, 82, 45));
		KlimaCheck.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		KlimaCheck.setBackground(new Color(255, 235, 205));
		panel.add(KlimaCheck);
		
		JButton btnNewButton = new JButton("Prikazi apartmane");
		btnNewButton.setForeground(new Color(160, 82, 45));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setBounds(180, 202, 231, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(363, 211, -224, 56);
		panel.add(lblNewLabel);
		
		JLabel lblOpcije = new JLabel("");
		lblOpcije.setForeground(new Color(160, 82, 45));
		lblOpcije.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblOpcije.setBounds(86, 236, 436, 31);
		panel.add(lblOpcije);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(96, 294, 426, 274);
		textArea.setForeground(new Color(160, 82, 45));
		textArea.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textArea.setEditable(false);
		panel.add(textArea);
		
		JButton Rezervacijabtn = new JButton("Nastavi sa rezervacijom");
		Rezervacijabtn.setBounds(180, 579, 256, 23);
		Rezervacijabtn.setForeground(new Color(160, 82, 45));
		Rezervacijabtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		Rezervacijabtn.setBackground(new Color(255, 228, 181));
		Rezervacijabtn.setVisible(false);
		panel.add(Rezervacijabtn);
		
		

		textArea.setVisible(false);
		
		Rezervacijabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrikaziSobe soba=new PrikaziSobe(gost);
				soba.setVisible(true);
				
			}});
		
		
		
		
		btnNewButton.addActionListener(new ActionListener(){
			
			List<String> praznaLista=new ArrayList();
			

			@Override
			public void actionPerformed(ActionEvent e) {

						if(checkPusacka.isSelected()) {
							praznaLista.add("PUSACKA");
						}
						if(checkNepusacka.isSelected()) {
							praznaLista.add("NEPUSACKA");

						}

						if(Balkoncheck.isSelected()) {
							praznaLista.add("BALKON");

						}
						if(TVCheck.isSelected()) {
							praznaLista.add("TV");
							
						}

						if(KlimaCheck.isSelected()) {
							praznaLista.add("KLIMA");
						}	
						

			ArrayList <Apartmani> listaApartmana=new ArrayList<Apartmani>();
			
			for (Apartmani apartman:AplikacijaUtilities.getApartmani()) {
				
				List<String> DodatniSadrzaj=apartman.getDodatniSadrzaj();

//				System.out.println(praznaLista);
//				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
				List<String> noviSadrzaj=new ArrayList<String>();
				for (String sadrzaj:DodatniSadrzaj) {
					
					noviSadrzaj.add(sadrzaj.strip());

					
				}
				
				
				//praznaLista.size()==DodatniSadrzaj.size() &&
				if(noviSadrzaj.containsAll(praznaLista)&& praznaLista.containsAll(noviSadrzaj)) {
					
					//System.out.println("----------------------------------------------------------");
					
					textArea.setVisible(true);
					
					
					listaApartmana.add(apartman);
					lblOpcije.setText("Apartman(i) koji odgovaraju vasim kriterijumima: ");
					textArea.setVisible(true);
					Rezervacijabtn.setVisible(true);
					praznaLista.clear();
					
					
					StringBuilder sb=new StringBuilder();
					for(Apartmani a : listaApartmana){
						// sb.append(a.getSifraApartmana()+" "+a.getTipApartmana()+" " +a.getCenovnik().getCena()+"\n");
						textArea.append(a.toString()+"\n");
						}
					
					
					
		
					

				}

				
				
			}
			
			
			}});
		
	
	}
}



