package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import korisnici.AplikacijaUtilities;
import korisnici.StatusRezervacije;
import korisnici.Zaposleni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class PrikazZaposlenih extends JFrame {
	private Zaposleni zaposlen;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajZaposlene();
					PrikazZaposlenih frame = new PrikazZaposlenih();
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
	public PrikazZaposlenih() {
		
		
		

		String[] header = new String[] { "Ime", "Prezime", "Pol", "Datum rodjenja", "Br. telefona", "Adresa",  "Korisnicko ime",
				"Lozinka", "Uloga", "Staz", "Sprema", "Plata" };
		
		int brojac = AplikacijaUtilities.getZaposleni().size();
		
		Object[][] content = new Object[brojac][header.length];
		
		for(int i=0; i<AplikacijaUtilities.getZaposleni().size()-1; i++) {
			
			Zaposleni zaposlen = AplikacijaUtilities.getZaposleni().get(i);
			
			content[i][0] = zaposlen.getIme();
			content[i][1] = zaposlen.getPrezime();
			content[i][2] = zaposlen.getPol();
			content[i][3] = zaposlen.getDatumRodjenja();
			content[i][4] = zaposlen.getbrojTelefona();
			content[i][5] = zaposlen.getAdresa();
			content[i][6] = zaposlen.getkorisnickoIme();
			content[i][7] = zaposlen.getLozinka();
			content[i][8] = zaposlen.getUloga();
			content[i][9] = zaposlen.getStaz();
			content[i][10] = zaposlen.getSprema();
			content[i][11]=zaposlen.getPlata();
			
		}
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 1070, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1058, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, 0, 76, 570);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(76, 0, 982, 35);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Prikaz zaposlenog osoblja");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		panel_2.add(lblNewLabel_1);
		
		
		
		JButton btnObrisi = new JButton("Obrisi zaposlenog");
		btnObrisi.setBackground(new Color(255, 222, 173));
		btnObrisi.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnObrisi.setForeground(new Color(160, 82, 45));
		btnObrisi.setBounds(884, 363, 164, 23);
		panel.add(btnObrisi);
		
		
		
		
		
		JButton btnIzmeni = new JButton("Izmeni zaposlenog");
		btnIzmeni.setBackground(new Color(255, 222, 173));
		btnIzmeni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnIzmeni.setForeground(new Color(160, 82, 45));
		btnIzmeni.setBounds(699, 363, 153, 23);
		panel.add(btnIzmeni);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 46, 962, 300);
		scrollPane.setBackground(new Color(255, 235, 205));
		scrollPane.setForeground(new Color(255, 235, 205));
		panel.add(scrollPane);
		
		
		DefaultTableModel model = new DefaultTableModel(content, header);
		table_1 = new JTable(model);
		table_1.setModel(model);
		table_1.setBackground(new Color(255, 248, 220));
		//table_1.setBackground(new Color(255, 235, 205));
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		scrollPane.setViewportView(table_1);
		
		
		
		
		
		
		
		
		JButton btnDodaj = new JButton("Dodaj zaposlenog");
		btnDodaj.setBounds(480, 363, 184, 23);
		panel.add(btnDodaj);
		btnDodaj.setBackground(new Color(255, 222, 173));
		btnDodaj.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnDodaj.setForeground(new Color(160, 82, 45));
		
		
		
		btnDodaj.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajZaposlenog forma=new DodajZaposlenog(zaposlen);
				forma.setVisible(true);
				dispose();
				
				
				
			}
		});
		table_1.setVisible(true);
	
	btnIzmeni.addActionListener(new ActionListener (){
		@Override
		public void actionPerformed(ActionEvent e) {
			int red=table_1.getSelectedRow();
			if(red == -1) {
				JOptionPane.showMessageDialog(null, "Odaberite i oznacite zaposlenog za izmenu!", "Greska!",
						JOptionPane.WARNING_MESSAGE);
				}
			else {
				DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				String korisnickoIme = model.getValueAt(red, 6).toString();
				Zaposleni zaposlen = AplikacijaUtilities.nadjiZaposlenog(korisnickoIme);
				
				if(zaposlen != null) {
					DodajZaposlenog izmena = new DodajZaposlenog(zaposlen);
					izmena.setVisible(true);
					
	
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog zaposlenog", "Doslo je do greske!",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
//				

			}
			
			
		}
	});
	
	
	btnObrisi.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int red = table_1.getSelectedRow();
			
			if(red == -1) {
				JOptionPane.showMessageDialog(null, "Niste oznacili red za brisanje!", "Greska",
						JOptionPane.WARNING_MESSAGE);
			}else {
				String korisnickoIme = table_1.getValueAt(red, 6).toString();
				Zaposleni zaposlen = AplikacijaUtilities.nadjiZaposlenog(korisnickoIme);
				if (zaposlen!=null) {
					int odabrani = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Molimo Vas potvrdite brisanje zaposlenog.", JOptionPane.YES_NO_OPTION);
					if(odabrani == JOptionPane.YES_OPTION) {
						AplikacijaUtilities.getZaposleni().remove(zaposlen);
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						AplikacijaUtilities.getZaposleni().remove(zaposlen);
						model.removeRow(red);
						AplikacijaUtilities.sacuvajZaposlene();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog zaposlenog!", "Greska",
							JOptionPane.WARNING_MESSAGE);
			
			
		}
			}
		
	}
	
});
	}}
