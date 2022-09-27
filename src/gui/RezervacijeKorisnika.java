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

import korisnici.AplikacijaUtilities;
import korisnici.Gost;
import korisnici.Korisnik;
import korisnici.Pol;
import korisnici.Rezervacije;
import korisnici.StatusRezervacije;

public class RezervacijeKorisnika extends JFrame {

	private Korisnik gost1;
	private Rezervacije rezervacija;
	private JPanel contentPane;
	private JTable table;
	private static ArrayList<Rezervacije> rezervacijee=new ArrayList<Rezervacije>();
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Gost gost2=new Gost("Jovan", "Jovanovic", "djole@email.com", "0634127354", "2346", "24.02.1992", "Ilije Ognjenovica 12", Pol.MUSKI);
					//RezervacijeKorisnika frame = new RezervacijeKorisnika(gost2);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RezervacijeKorisnika(Korisnik gost1) {
		this.gost1=gost1;
		double suma=0;
		
		rezervacijee.clear();
		for (Rezervacije rez:AplikacijaUtilities.getRezervacije()) {
			if(rez.getGost().getkorisnickoIme().equals(gost1.getkorisnickoIme())){
				rezervacijee.add(rez);
			}
		}
		
		for(Rezervacije rez:rezervacijee) {
			if(rez.getCheckIn().isBefore(LocalDate.now())&& rez.getStatus().equals(StatusRezervacije.NA_CEKANJU)) {
				rez.setStatus(StatusRezervacije.ODBIJENA);
			}
		}
		
		for(Rezervacije rez:rezervacijee) {
			if(!(rez.getStatus().equals(StatusRezervacije.ODBIJENA))) {
			suma+=rez.getUkupnaCenaRezervacije();
			}
		}
		
		String[] header = new String[] { "Sifra rez.", "Korisnik", "Tip apartmana", "Check In", "Check Out", "Status Rezervacije", "Ukupna cena rezervacije"};
		
		
		int brojac = rezervacijee.size();
		
		
		Object[][] content = new Object[brojac][header.length];
		
		for(int i=0; i<rezervacijee.size(); i++) {
			
			Rezervacije rez=rezervacijee.get(i);
			content[i][0] = rez.getSifraRezervacije();
			content[i][1] = rez.getGost().getkorisnickoIme();
			content[i][2] = rez.getApartman().getTipApartmana();
			content[i][3] = rez.getCheckIn();
			content[i][4] = rez.getCheckOut();
			content[i][5] = rez.getStatus();
			content[i][6]=rez.getUkupnaCenaRezervacije();
			
	}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Vase rezervacije: " + this.gost1.getkorisnickoIme());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 1070, 374);
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
		
		JLabel lblNewLabel_1 = new JLabel("Prikaz Vasih rezervacija");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		panel_2.add(lblNewLabel_1);
		
		
		JButton btnOdbij = new JButton("Otkazi rezervaciju");
		btnOdbij.setBackground(new Color(255, 222, 173));
		btnOdbij.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnOdbij.setForeground(new Color(160, 82, 45));
		btnOdbij.setBounds(884, 208, 164, 23);
		panel.add(btnOdbij);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 46, 962, 134);
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
		
		JLabel lblNewLabel = new JLabel("Ukupna cena svih Vasih rezervacija iznosi: "+suma);
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel.setBounds(86, 212, 355, 14);
		panel.add(lblNewLabel);
		
		
		
		
		btnOdbij.addActionListener(new ActionListener() {

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
					Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije(id);
					if (rezervacija!=null && rezervacija.getStatus().equals(StatusRezervacije.NA_CEKANJU)) {
						int obrisi = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrdite otkazivanje rezervacije", JOptionPane.YES_NO_OPTION);
						if (obrisi==JOptionPane.YES_OPTION) {
						rezervacija.setStatus(StatusRezervacije.OTKAZANA);
						model.setValueAt(StatusRezervacije.OTKAZANA,red,5 );
						model.fireTableCellUpdated(red, 5);
						AplikacijaUtilities.sacuvajRezervacije();}}
						
					else {
						JOptionPane.showMessageDialog(null, "Ne mozete odbiti vec potvrdjenu ili odbijenu/otkazanu rezervaciju!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}			
				}
				
			
			
			
			
			
		});

	}
	
//	public void setValueAt(Object value, int row, int column) {
//		new DefaultTableModel(columns, 0);
//
//		Set the value
//
//		model.setValueAt(value, row, column);
//
//		Fire update event
//
//		model.fireTableCellUpdate(row, column);
//	}

}
