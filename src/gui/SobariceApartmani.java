package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import korisnici.Korisnik;
import korisnici.OcisceneSobeDatumi;
import korisnici.Rezervacije;
import korisnici.StatusApartmana;
import korisnici.StatusRezervacije;
import korisnici.Zaposleni;

public class SobariceApartmani extends JFrame {

	private JPanel contentPane;
	private Apartmani apartman;
	private JTable table_1;
	private static ArrayList<Apartmani> apartmaniNaSpremanju=new ArrayList<Apartmani>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AplikacijaUtilities.ucitajApartmane();
//					AplikacijaUtilities.ucitajZaposlene();
//					SobariceApartmani frame = new SobariceApartmani(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param sobarica 
	 */
	public SobariceApartmani(Korisnik sobarica) {
		apartman=this.apartman;
		
		String kIme=sobarica.getkorisnickoIme();
		Zaposleni nasaSobarica=AplikacijaUtilities.nadjiZaposlenog(kIme);
		apartmaniNaSpremanju.clear();
		
		for(Apartmani apartman1:AplikacijaUtilities.getApartmani()) {
			if(apartman1.getStatusApartmana().equals(StatusApartmana.SPREMANJE)) {
				System.out.println(apartman1);
				if(apartman1.getSobarica().equals(nasaSobarica)){
				apartmaniNaSpremanju.add(apartman1);
			}
		}
			}
		
		String[] header = new String[] { "Sifra apartmana.", "Tip", "Status"};
		
		
		int brojac = apartmaniNaSpremanju.size();
			
		Object[][] content = new Object[brojac][header.length];
		
		for(int i=0; i<brojac; i++) {
			
			
			Apartmani apartman = apartmaniNaSpremanju.get(i);
			content[i][0] = apartman.getSifraApartmana();
			content[i][1] = apartman.getTipApartmana();
			content[i][2] = apartman.getStatusApartmana();}
			
	
		
		
		setResizable(false);
		setTitle("Prikaz rezervacija");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblNewLabel_1 = new JLabel("Prikaz vasih soba za ciscenje");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		panel_2.add(lblNewLabel_1);
		
		
		JButton btnOcisti = new JButton("Soba spremljena");
		btnOcisti.setBackground(new Color(255, 222, 173));
		btnOcisti.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnOcisti.setForeground(new Color(160, 82, 45));
		btnOcisti.setBounds(884, 363, 164, 23);
		panel.add(btnOcisti);
		
		JLabel lblNewLabel = new JLabel("- kada zavrsite sa ciscenjem sobe, odaberite je u tabeli i izmenite status klikom na dugme ispod -");
		lblNewLabel.setBounds(286, 45, 972, 16);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		panel.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 72, 962, 274);
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
		
		btnOcisti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				int red = table_1.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Selektujte red za izmenu.", "Greska",
							JOptionPane.WARNING_MESSAGE);
				}
				else {
					String id=table_1.getValueAt(red, 0).toString();
					Apartmani apartman=AplikacijaUtilities.nadjiApartman(id);
					if (apartman!=null) {
						int obrisi = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da azurirate status sobe?", "Potvrdite ociscenu sobu", JOptionPane.YES_NO_OPTION);
						if (obrisi==JOptionPane.YES_OPTION) {
							
						apartman.setStatusApartmana(StatusApartmana.SLOBODNO);
						model.setValueAt(StatusApartmana.SLOBODNO,red,2 );
						model.fireTableCellUpdated(red, 2);
						String kIme=sobarica.getkorisnickoIme();
						Zaposleni nasaSobarica=AplikacijaUtilities.nadjiZaposlenog(kIme);
						int brojac=AplikacijaUtilities.nadjiNasBrojOciscenihSoba(nasaSobarica)+1;
						nasaSobarica.setBrOciscenihSoba(brojac);
						
//						List <String[]> spremanja=apartman.getSpremanjeDatumi();
						
						LocalDate datumSpremanja=LocalDate.now();
						String datum=datumSpremanja.toString();
						
						ArrayList<String> datumi=new ArrayList();
						datumi.add(datum);
						
						OcisceneSobeDatumi ociscenaSobarica = new OcisceneSobeDatumi(sobarica.getkorisnickoIme(), datum);
						AplikacijaUtilities.getDatumi().add(ociscenaSobarica);
						

						
//						for(String datum1:nasaSobarica.getDatumCiscenja()) {
//							System.out.println(datum1);
//						}
						
//						String[] pomocni= {kIme, datumSpremanja.toString()};
//						spremanja.add(pomocni);
//						apartman.setSpremanjeDatumi(spremanja);
						AplikacijaUtilities.sacuvajApartmane();
						AplikacijaUtilities.sacuvajZaposlene();}
						AplikacijaUtilities.sacuvajOcisceneSobe();
						}
						
					else {
						JOptionPane.showMessageDialog(null, "Greska prilikom pokusaja unosa novog statusa sobe!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}			
				}});
		
		
		
	}
	
	
}

