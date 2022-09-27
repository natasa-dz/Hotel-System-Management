package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Gost;
import korisnici.Korisnik;
import korisnici.OcisceneSobeDatumi;
import korisnici.Rezervacije;
import korisnici.StatusApartmana;
import korisnici.StatusRezervacije;
import korisnici.Uloga;
import korisnici.Zaposleni;
import javax.swing.JTextField;

public class RezervacijeRecepcionar extends JFrame {

	private Rezervacije rezervacija;
	private Apartmani apartman1;
	private JPanel contentPane;
	private JTable table_1;
	private JTextField SearchBar;
	private TableRowSorter sorter;
	private double prihodi=0;
	private double rashodi=0;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Gost gost2=new Gost("Jovan", "Jovanovic", "djole@email.com", "0634127354", "2346", "24.02.1992", "Ilije Ognjenovica 12", Pol.MUSKI);
					AplikacijaUtilities.ucitajApartmane();
					AplikacijaUtilities.ucitajCenovnik();
					AplikacijaUtilities.ucitajSveKorisnike();
					AplikacijaUtilities.ucitajRezervacije();
					RezervacijeRecepcionar frame = new RezervacijeRecepcionar(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public RezervacijeRecepcionar(Korisnik gost) {

		rezervacija=this.rezervacija;
		
		for(Rezervacije rezervacija:AplikacijaUtilities.getRezervacije()) {
			if(rezervacija.getCheckIn().isBefore(LocalDate.now())&& rezervacija.getStatus().equals(StatusRezervacije.NA_CEKANJU)) {
				rezervacija.setStatus(StatusRezervacije.ODBIJENA);
			}
		}

		
		String[] header = new String[] { "Sifra rez.", "Korisnik", "Sifra apart.","Tip apartmana", "Pocetak rez.", "Kraj rez.", "Ukupna cena rez.", "Status rez.", "Checked In", "Checked Out",};
		
		
		int brojac = AplikacijaUtilities.getRezervacije().size();
		
		
		Object[][] content = new Object[brojac][header.length];
		
		for(int i=0; i<AplikacijaUtilities.getRezervacije().size(); i++) {
			
			
			Rezervacije rezervacija = AplikacijaUtilities.getRezervacije().get(i);
			
			content[i][0] = rezervacija.getSifraRezervacije();
			content[i][1] = rezervacija.getGost().getkorisnickoIme();
			content[i][2] = rezervacija.getApartman().getSifraApartmana();
			content[i][3] = rezervacija.getApartman().getTipApartmana();
			content[i][4] = rezervacija.getCheckIn();
			content[i][5] = rezervacija.getCheckOut();
			content[i][6] = rezervacija.getUkupnaCenaRezervacije();
			content[i][7] = rezervacija.getStatus();
			content[i][8] = rezervacija.isDosao();
			content[i][9] = rezervacija.isOtisao();
			
	}

		
		
		setResizable(false);
		setTitle("Prikaz rezervacija");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 600, 1081, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1078, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(0, 0, 76, 570);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 222, 173));
		panel_2.setBounds(76, 0, 992, 35);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Prikaz gostinskih rezervacija");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		panel_2.add(lblNewLabel_1);
		
		
		JButton btnOdbij = new JButton("Odbij rezervaciju");
		btnOdbij.setBackground(new Color(255, 222, 173));
		btnOdbij.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnOdbij.setForeground(new Color(160, 82, 45));
		btnOdbij.setBounds(894, 433, 164, 23);
		panel.add(btnOdbij);
		
		JButton btnPotvrdi = new JButton("Potvrdi rezervaciju");
		btnPotvrdi.setBackground(new Color(255, 222, 173));
		btnPotvrdi.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnPotvrdi.setForeground(new Color(160, 82, 45));
		btnPotvrdi.setBounds(713, 433, 153, 23);
		panel.add(btnPotvrdi);
		
		
//		JButton dodatneUsluge = new JButton("Dodaj dodatne usluge");
//		dodatneUsluge.setBounds(96, 434, 222, 23);
//		dodatneUsluge.setBackground(new Color(255, 222, 173));
//		dodatneUsluge.setFont(new Font("Century Gothic", Font.PLAIN, 12));
//		dodatneUsluge.setForeground(new Color(160, 82, 45));
//		panel.add(dodatneUsluge);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 98, 962, 300);
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
		
	      sorter = new TableRowSorter<>(model);
	      table_1.setRowSorter(sorter);
		
		JButton CheckOutbtn = new JButton("CheckOut-uj korisnika");
		CheckOutbtn.setForeground(new Color(160, 82, 45));
		CheckOutbtn.setBackground(new Color(255, 222, 173));
		CheckOutbtn.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		CheckOutbtn.setBounds(515, 433, 163, 23);
		panel.add(CheckOutbtn);
		
		JButton CheckInbtn = new JButton("CheckIn-uj korisnika");
		CheckInbtn.setBackground(new Color(255, 222, 173));
		CheckInbtn.setForeground(new Color(160, 82, 45));
		CheckInbtn.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		CheckInbtn.setBounds(342, 433, 142, 23);
		panel.add(CheckInbtn);
		
		JLabel rezervacijeSearch = new JLabel("Pretrazi rezervacije: ");
		rezervacijeSearch.setForeground(new Color(160, 82, 45));
		rezervacijeSearch.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rezervacijeSearch.setBounds(86, 56, 164, 31);
		panel.add(rezervacijeSearch);
		
		SearchBar = new JTextField();
		SearchBar.setBounds(229, 62, 333, 20);
		panel.add(SearchBar);
		SearchBar.setColumns(10);
		
		
		
		
		SearchBar.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				search(SearchBar.getText());
				
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				search(SearchBar.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				search(SearchBar.getText());
				
			}
	         public void search(String str) {
		             if (str.length() == 0) {
		                sorter.setRowFilter(null);
		             } else {
		                sorter.setRowFilter(RowFilter.regexFilter(str));
		             }
		          }
			
		});
		
		

		
		
		

		btnPotvrdi.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int red = table_1.getSelectedRow();
						if(red == -1) {
							JOptionPane.showMessageDialog(null, "Oznacite red za izmenu!", "Greska",
									JOptionPane.WARNING_MESSAGE);
						}else {
							
							ArrayList<Rezervacije> rezervacije = AplikacijaUtilities.getRezervacije();
							
							DefaultTableModel model = (DefaultTableModel) table_1.getModel();
							String id = model.getValueAt(red, 0).toString();
							
							//nasa rezervacija
							Rezervacije rezervacija = AplikacijaUtilities.nadjiRezervacije(id);

							String nasaSifraApartmana=rezervacija.getApartman().getSifraApartmana();
							StatusRezervacije statusNaserez=rezervacija.getStatus();
							//
							System.out.println(statusNaserez);
							System.out.println("");
							if(!(statusNaserez.equals(StatusRezervacije.NA_CEKANJU))){
								JOptionPane.showMessageDialog(null, "Ne mozete potvrditi rezervaciju ciji status nije NA_CEKANJU!", "Greska", JOptionPane.ERROR_MESSAGE);
							}

							else if(AplikacijaUtilities.proveriDatumskiRezervacije(rezervacija)){
								
								rezervacija.setStatus(StatusRezervacije.POTVRDJENA);
								
								//odavde kopiraj ova dva reda
								
								model.setValueAt(StatusRezervacije.POTVRDJENA,red,7 );
								model.fireTableCellUpdated(red, 7);
								
								rezervacija.getApartman().setStatusApartmana(StatusApartmana.ZAUZETO);
								AplikacijaUtilities.sacuvajRezervacije();
								
								JOptionPane.showMessageDialog(null, "Rezervacija je uspesno potvrdjena", "Status azuriran", JOptionPane.INFORMATION_MESSAGE);
								
								DefaultTableModel dm = (DefaultTableModel)table_1.getModel();
								dm.fireTableDataChanged();

							}
							else{
								JOptionPane.showMessageDialog(null, "Rezervacija ne moze biti potvrdjena!", "Greska", JOptionPane.ERROR_MESSAGE);

							}


							}


							}});
		
		btnOdbij.addActionListener(new ActionListener() {	
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = table_1.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Oznacite rezervaciju za odbijanje!", "Greska",
							JOptionPane.WARNING_MESSAGE);
				}
					else {
						
						String sifraRez = table_1.getValueAt(red, 0).toString();
						Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije(sifraRez);
						if (rezervacija!=null && rezervacija.getStatus().equals(StatusRezervacije.NA_CEKANJU)) {
							int obrisi = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrdite odbijanje rezervacije", JOptionPane.YES_NO_OPTION);
							if(obrisi == JOptionPane.YES_OPTION) {
							rezervacija.setStatus(StatusRezervacije.ODBIJENA);
							model.setValueAt(StatusRezervacije.ODBIJENA,red,7 );
							model.fireTableCellUpdated(red, 7);

							rezervacija.setUkupnaCenaRezervacije(0);
							AplikacijaUtilities.sacuvajRezervacije();
							model.fireTableDataChanged();
							//System.out.println("Uspesno odbijena rezervacija");
						}
							}
						else {
							JOptionPane.showMessageDialog(null, "Ne mozete odbiti vec potvrdjenu ili odbijenu/otkazanu rezervaciju!", "Greska", JOptionPane.ERROR_MESSAGE);
						}
					}			
				}
		});
	
		CheckInbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AplikacijaUtilities.ucitajApartmane();
				// TODO Auto-generated method stub
				int red = table_1.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Oznacite red za izmenu!", "Greska",
							JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					String sifraRez = table_1.getValueAt(red, 0).toString();
					
					Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije(sifraRez);
					
					if(rezervacija.isDosao()==true) {
						JOptionPane.showMessageDialog(null, "Izabrani gost je vec prijavljen u hotel!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					
					else if (rezervacija!=null && rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
						
							int CheckIn = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da potvrdite rezervaciju?", "Potvrdi CheckIn klijenta", JOptionPane.YES_NO_OPTION);
							
							if(CheckIn == JOptionPane.YES_OPTION) {
							rezervacija.setDosao(true);
							model.setValueAt(true,red,8 );
							model.fireTableCellUpdated(red, 8);
							

							AplikacijaUtilities.sacuvajRezervacije();
							String nasaSifra=rezervacija.getApartman().getSifraApartmana();
							Apartmani apartman=AplikacijaUtilities.nadjiApartman(nasaSifra);
							
							//for(Apartmani apartman:apartmani) {
								//if(apartman.getSifraApartmana().equals(nasaSifra)) {
									apartman.setStatusApartmana(StatusApartmana.ZAUZETO);
									
								//}
								
							//}
							AplikacijaUtilities.sacuvajApartmane();
							
							//AplikacijaUtilities.sacuvajApartmane();
							model.fireTableDataChanged();
							
							JOptionPane.showMessageDialog(null, "Gost je uspesno prijavljen u hotel!", "Checked-In", JOptionPane.INFORMATION_MESSAGE);
					}

							
			}

			else if(!rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
						JOptionPane.showMessageDialog(null, "Ne mozete prijaviti gosta u hotel na NEPOTVRDJENU rezervaciju!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				
			}}});
		//prodji kroz apartmane, pronadji broj pojavljivanja imena spremacice u statusu sobe spremanje, incline za jedan brojac, brojac za tu spremacicu, ako je jednak nuli/veci je od najmanjeg brojaca dodeli njoj sobu za cicscenje

//validacija- ne moze check out, ako nema check in-a, ako su oba odradjena, posalji da soba ima status spremanje, proveri da li je prethodno rezervacija potvrdjena		
		CheckOutbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int red = table_1.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Oznacite red za izmenu!", "Greska",
							JOptionPane.WARNING_MESSAGE);
				}else {
					
					String sifraRez = table_1.getValueAt(red, 0).toString();
					Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije(sifraRez);
					
					if (rezervacija!=null && rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
						
						
						if(rezervacija.isOtisao()==true) {
							JOptionPane.showMessageDialog(null, "Ne mozete odjaviti vec ODJAVLJENOG gosta!", "Greska", JOptionPane.ERROR_MESSAGE);

							
						}
						
					else if(rezervacija.isDosao()==true && rezervacija.isOtisao()==false) {
						
							int CheckOut = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da zavrsite boravak korisnika?", "Potvrdi CheckOut klijenta", JOptionPane.YES_NO_OPTION);
							
							if(CheckOut == JOptionPane.YES_OPTION) {
								
								rezervacija.setOtisao(true);
								model.setValueAt(true, red, 9);
								model.fireTableCellUpdated(red, 9);
								String SifraApartman=rezervacija.getApartman().getSifraApartmana();
								

								
								Apartmani apartman=AplikacijaUtilities.nadjiApartman(SifraApartman);
								
								apartman.setStatusApartmana(StatusApartmana.SPREMANJE);
								Zaposleni sobarica=AplikacijaUtilities.pronadjiSobaricuKojaCisti();
								LocalDate danas=LocalDate.now();
								OcisceneSobeDatumi sobaZaCiscenje=new OcisceneSobeDatumi(sobarica.getkorisnickoIme(), danas.toString());
								AplikacijaUtilities.getDatumi().add(sobaZaCiscenje);
								AplikacijaUtilities.sacuvajOcisceneSobe();
								apartman.setSobarica(sobarica);
								AplikacijaUtilities.sacuvajRezervacije();
								AplikacijaUtilities.sacuvajApartmane();
								
								
								model.fireTableDataChanged();
								
								JOptionPane.showMessageDialog(null, "Gost je uspesno odjavljen iz hotela!", "Checked-Out", JOptionPane.INFORMATION_MESSAGE);
					
						}
							}


							
			
				}
					else if(!rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
						JOptionPane.showMessageDialog(null, "Ne mozete odjaviti gosta na NEPOTVRDJENU rezervaciju!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				
	}}});
		
		
		
		
		String korisnickoIme=gost.getkorisnickoIme();
		Zaposleni zaposlen1=AplikacijaUtilities.nadjiZaposlenog(korisnickoIme);
		
		if(zaposlen1.getUloga().equals(Uloga.ADMINISTRATOR)) {

		
		
		JButton btnIzvestaj = new JButton("Izvestaji o rezervacijama");
		btnIzvestaj.setBackground(new Color(255, 222, 173));
		btnIzvestaj.setForeground(new Color(160, 82, 45));
		btnIzvestaj.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIzvestaj.setBounds(131, 434, 176, 23);
		panel.add(btnIzvestaj);
		
		
		btnIzvestaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StatusRezervacijaIzvestaj status=new StatusRezervacijaIzvestaj();
				RezervacijeRecepcionar.this.dispose();
				RezervacijeRecepcionar.this.setVisible(false);
				status.setVisible(true);
				
			}});
		
		for(Rezervacije rezervacija:AplikacijaUtilities.getRezervacije()) {
			if(rezervacija.getStatus().equals(StatusRezervacije.OTKAZANA) || rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
				prihodi+=rezervacija.getUkupnaCenaRezervacije();
			}
			if(rezervacija.getStatus().equals(StatusRezervacije.ODBIJENA)) {
				rashodi+=rezervacija.getUkupnaCenaRezervacije();
			}
		}
		for(Zaposleni zaposlen:AplikacijaUtilities.getZaposleni()) {
			rashodi+=zaposlen.getPlata();
		}
		
		}
		
		JLabel lblPrihodi = new JLabel("Ukupni prihodi su: "+prihodi+" RSD");
		lblPrihodi.setForeground(new Color(139, 69, 19));
		lblPrihodi.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrihodi.setBounds(86, 525, 398, 23);
		panel.add(lblPrihodi);
		
		JLabel lblRashodi = new JLabel("Ukupni rashodi su: "+rashodi+" RSD");
		lblRashodi.setBounds(515, 521, 543, 31);
		lblRashodi.setForeground(new Color(139, 69, 19));
		lblRashodi.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel.add(lblRashodi);
		

		

		
		
		
		
		

}
}
