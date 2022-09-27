package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import korisnici.AplikacijaUtilities;
import korisnici.Gost;
import korisnici.Zaposleni;

public class PrikaziGoste extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private Gost gost1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajGoste();
					PrikaziGoste frame = new PrikaziGoste();
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
	public PrikaziGoste() {
		
		String[] header = new String[] { "Ime", "Prezime", "Pol", "Datum rodjenja", "Br. telefona", "Adresa",  "Korisnicko ime",
				"Lozinka"};
		
		int brojac = AplikacijaUtilities.getGosti().size();
		
		
		Object[][] content = new Object[brojac][header.length];
		
		for(int i=0; i<AplikacijaUtilities.getGosti().size(); i++) {
			
			
			Gost gost1 = AplikacijaUtilities.getGosti().get(i);
			
			content[i][0] = gost1.getIme();
			content[i][1] = gost1.getPrezime();
			content[i][2] = gost1.getPol();
			content[i][3] = gost1.getDatumRodjenja();
			content[i][4] = gost1.getbrojTelefona();
			content[i][5] = gost1.getAdresa();
			content[i][6] = gost1.getkorisnickoIme();
			content[i][7] = gost1.getLozinka();
			
		}
		
		
		setResizable(false);
		setTitle("Azuriranje gostiju");
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
		
		JLabel lblNewLabel_1 = new JLabel("Prikaz gostiju");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		panel_2.add(lblNewLabel_1);
		
		
		
		JButton btnObrisi = new JButton("Obrisi gosta");
		btnObrisi.setBackground(new Color(255, 222, 173));
		btnObrisi.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnObrisi.setForeground(new Color(160, 82, 45));
		btnObrisi.setBounds(884, 363, 164, 23);
		panel.add(btnObrisi);
		
		
		
		
		
		JButton btnIzmeni = new JButton("Izmeni gosta");
		btnIzmeni.setBackground(new Color(255, 222, 173));
		btnIzmeni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnIzmeni.setForeground(new Color(160, 82, 45));
		btnIzmeni.setBounds(699, 363, 153, 23);
		panel.add(btnIzmeni);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 46, 962, 306);
		panel.add(scrollPane);
		
		
		DefaultTableModel model = new DefaultTableModel(content, header);
		table_1 = new JTable(model);
		table_1.setModel(model);
		table_1.setBackground(new Color(255, 248, 220));
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		scrollPane.setViewportView(table_1);
		
		
		JButton btnDodaj = new JButton("Dodaj novog gosta");
		btnDodaj.setBounds(480, 363, 184, 23);
		panel.add(btnDodaj);
		btnDodaj.setBackground(new Color(255, 222, 173));
		btnDodaj.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnDodaj.setForeground(new Color(160, 82, 45));
		
		
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajGoste forma=new DodajGoste(gost1);
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
					JOptionPane.showMessageDialog(null, "Odaberite i oznacite gosta za izmenu!", "Greska!",
							JOptionPane.WARNING_MESSAGE);
					}
				else {
					DefaultTableModel model=(DefaultTableModel) table_1.getModel();
					String korisnickoIme = model.getValueAt(red, 6).toString();
					//System.out.println(korisnickoIme);
					//System.out.println("===============================================");
					Gost gost1 = AplikacijaUtilities.nadjiGosta(korisnickoIme);
					
					if(gost1 != null) {
						//System.out.println(gost1.getkorisnickoIme());
						DodajGoste izmena = new DodajGoste(gost1);
						izmena.setVisible(true);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog gosta", "Doslo je do greske!",
								JOptionPane.ERROR_MESSAGE);
					}
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
					Gost gost1 = AplikacijaUtilities.nadjiGosta(korisnickoIme);
					if (gost1!=null) {
						int odabrani = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Molimo Vas potvrdite brisanje gosta.", JOptionPane.YES_NO_OPTION);
						if(odabrani == JOptionPane.YES_OPTION) {
							AplikacijaUtilities.getGosti().remove(gost1);
							DefaultTableModel model = (DefaultTableModel) table_1.getModel();
							AplikacijaUtilities.getGosti().remove(gost1);
							model.removeRow(red);
							AplikacijaUtilities.sacuvajGoste();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog gosta!", "Greska",
								JOptionPane.WARNING_MESSAGE);
				
				
			}
				}
			
		}
		
	});
		
		
	}

}
