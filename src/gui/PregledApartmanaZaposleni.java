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

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Rezervacije;
import korisnici.Cenovnik;

public class PregledApartmanaZaposleni extends JFrame {

	private Rezervacije rezervacija;
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
					AplikacijaUtilities.ucitajCenovnik();
					AplikacijaUtilities.ucitajApartmane();
					PregledApartmanaZaposleni frame = new PregledApartmanaZaposleni();
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
	public PregledApartmanaZaposleni() {
		Cenovnik cenovnik;
		
		
		
		String[] header = new String[] { "Sifra apartmana.", "Tip apartmana", "Cena nocenja", "Pocetni datum vazenja cen.", "Krajnji datum vazenja cen.", "Dodatni sadrzaj"};
		
		
		int brojac = AplikacijaUtilities.getApartmani().size();
		
		
		Object[][] content = new Object[brojac][header.length];
		
		for(int i=0; i<AplikacijaUtilities.getApartmani().size(); i++) {
			
			
			Apartmani apartman = AplikacijaUtilities.getApartmani().get(i);
			
			content[i][0] = apartman.getSifraApartmana();
			content[i][1] = apartman.getTipApartmana();
			cenovnik=AplikacijaUtilities.nadjiCenovnik(apartman.getTipApartmana());
			//content[i][2] = apartman.getCenovnik().getCena();
			content[i][2] =cenovnik.getCena();
			content[i][3] =cenovnik.getPocetniDatumVazenja();
			content[i][4] =cenovnik.getKrajnjiDatumVazenja();
			content[i][5]=apartman.getDodatniSadrzaj().toString().replace("[", "").replace("]", "");
			//content[i][3] = apartman.getCenovnik().getPocetniDatumVazenja();
			//content[i][4] = apartman.getCenovnik().getKrajnjiDatumVazenja();
			
	}
		
		
		setResizable(false);
		setTitle("Prikaz informacija o apartmanima");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 600, 1182, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1196, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, 0, 76, 570);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(74, 0, 1112, 35);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Prikaz informacija o sobama");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		panel_2.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 47, 1074, 179);
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
		
		
		JButton btnDodaj = new JButton("Dodaj novu sobu");
		btnDodaj.setBackground(new Color(255, 222, 173));
		btnDodaj.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnDodaj.setForeground(new Color(160, 82, 45));
		btnDodaj.setBounds(894, 249, 164, 23);
		panel.add(btnDodaj);
		
		JButton btnIzmeni = new JButton("Izmeni sobu");
		btnIzmeni.setBackground(new Color(255, 222, 173));
		btnIzmeni.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnIzmeni.setForeground(new Color(160, 82, 45));
		btnIzmeni.setBounds(705, 249, 153, 23);
		panel.add(btnIzmeni);
		
		JButton btnIzvestaj = new JButton("Prikazi izvestaj za sobe");
		btnIzvestaj.setForeground(new Color(160, 82, 45));
		btnIzvestaj.setBackground(new Color(255, 222, 173));
		btnIzvestaj.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIzvestaj.setBounds(499, 249, 164, 23);
		panel.add(btnIzvestaj);
		
		JButton cenovnikDodaj = new JButton("Dodaj cenovnik");
		cenovnikDodaj.setForeground(new Color(160, 82, 45));
		cenovnikDodaj.setBackground(new Color(255, 222, 173));
		cenovnikDodaj.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cenovnikDodaj.setBounds(318, 250, 153, 23);
		panel.add(cenovnikDodaj);
		
		JButton cenovnikIzmeni = new JButton("Izmeni cenovnik");
		cenovnikIzmeni.setForeground(new Color(160, 82, 45));
		cenovnikIzmeni.setBackground(new Color(255, 222, 173));
		cenovnikIzmeni.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cenovnikIzmeni.setBounds(107, 250, 164, 23);
		panel.add(cenovnikIzmeni);
		
		
		cenovnikDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					DodajCenovnik dodaj=new DodajCenovnik(null);
					dodaj.setVisible(true);
			}});
		
		
		cenovnikIzmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int red=table_1.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite i oznacite cenovnik za izmenu!", "Greska!",
							JOptionPane.WARNING_MESSAGE);
					}
				else {
					DefaultTableModel model=(DefaultTableModel) table_1.getModel();
					String id = model.getValueAt(red, 1).toString();
					Cenovnik cenovnik=AplikacijaUtilities.nadjiCenovnik(id);
					
					if(cenovnik != null) {
						DodajCenovnik dodaj=new DodajCenovnik(cenovnik);
						dodaj.setVisible(true);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabrani cenovnik", "Doslo je do greske!",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}});
	
	
	btnIzvestaj.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			IzvestajSoba izv=new IzvestajSoba();
			izv.setVisible(true);
		}});
	
	btnIzmeni.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int red=table_1.getSelectedRow();
			if(red == -1) {
				JOptionPane.showMessageDialog(null, "Odaberite i oznacite apartman za izmenu!", "Greska!",
						JOptionPane.WARNING_MESSAGE);
				}
			else {
				DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				String id = model.getValueAt(red, 0).toString();
				Apartmani apartman=AplikacijaUtilities.nadjiApartman(id);
				
				if(apartman != null) {
					DodajIzmeniApartman novi=new DodajIzmeniApartman(apartman);
					novi.setVisible(true);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog apartman", "Doslo je do greske!",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}}
		});
	
	btnDodaj.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DodajIzmeniApartman novi=new DodajIzmeniApartman(null);
			novi.setVisible(true);
			
		}});
}	
}
