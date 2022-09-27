package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.ChartTheme;

import korisnici.AplikacijaUtilities;
import korisnici.Pol;
import korisnici.Rezervacije;
import korisnici.StatusRezervacije;
import korisnici.Uloga;

public class StatusRezervacijaIzvestaj extends JFrame {

	private JPanel contentPane;
	private JTextField dolazaktxt;
	private JTextField odlazaktxt;
	private int count;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikacijaUtilities.ucitajRezervacije();
					StatusRezervacijaIzvestaj frame = new StatusRezervacijaIzvestaj();
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
	public StatusRezervacijaIzvestaj() {
		setResizable(false);
		setTitle("Brojcani izvestaj o statusima rezervacija za zeljene datumske periode");
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
		
		JLabel lblNaslov = new JLabel("Izvestaj o statusima rezervacija");
		lblNaslov.setForeground(new Color(160, 82, 45));
		lblNaslov.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_2.add(lblNaslov);
		
		JComboBox <StatusRezervacije> comboStatus = new JComboBox<StatusRezervacije>(StatusRezervacije.values());
		//JComboBox comboUloga=new JComboBox();
		comboStatus.setBounds(262, 62, 169, 21);
		panel.add(comboStatus);
		StatusRezervacije status = (StatusRezervacije) comboStatus.getSelectedItem();
		
		JLabel tipLbl = new JLabel("Zeljeni status rezervacije: ");
		tipLbl.setForeground(new Color(160, 82, 45));
		tipLbl.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		tipLbl.setBounds(99, 64, 169, 14);
		panel.add(tipLbl);
		

		JLabel lblNewLabel = new JLabel("Pocetni datum za izvestaj: ");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setBounds(99, 122, 153, 14);
		panel.add(lblNewLabel);
		
		odlazaktxt = new JTextField();
		odlazaktxt.setBounds(262, 168, 169, 20);
		panel.add(odlazaktxt);
		odlazaktxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Krajnji datum za izvestaj: ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setBounds(99, 170, 169, 14);
		panel.add(lblNewLabel_1);
		
		dolazaktxt = new JTextField();
		dolazaktxt.setBounds(262, 120, 169, 20);
		panel.add(dolazaktxt);
		dolazaktxt.setColumns(10);
		
		JButton btnRezultati = new JButton("Prikazi rezultate");
		btnRezultati.setBackground(new Color(255, 222, 173));
		btnRezultati.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnRezultati.setForeground(new Color(160, 82, 45));
		btnRezultati.setBounds(188, 272, 243, 23);
		panel.add(btnRezultati);
		
		JLabel lblIzvestaj = new JLabel("Broj rezervacija sa statusom "+status+" u zeljenom periodu je: ");
		lblIzvestaj.setForeground(new Color(139, 69, 19));
		lblIzvestaj.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblIzvestaj.setBounds(99, 317, 383, 35);
		panel.add(lblIzvestaj);
		lblIzvestaj.setVisible(false);
		

		

		
		
		btnRezultati.addActionListener(new ActionListener(){
			int brojac;

			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dolazakString=dolazaktxt.getText().trim();
				String odlazakString=odlazaktxt.getText().trim();
				StatusRezervacije status = (StatusRezervacije) comboStatus.getSelectedItem();
				
				if(validateDate(dolazakString)&&validateDate(odlazakString)) {
					LocalDate pocetniDatumIzv=LocalDate.parse(dolazakString);
					LocalDate krajnjiDatumIzv=LocalDate.parse(odlazakString);
					
					if(ValidateBeforeAndAfter(pocetniDatumIzv,krajnjiDatumIzv)) {
					
					for(Rezervacije rezervacija:AplikacijaUtilities.getRezervacije()) {
						if(rezervacija.getStatus().equals(status)) {
							
							
							if(rezervacija.getCheckIn().isAfter(pocetniDatumIzv) && rezervacija.getCheckIn().isBefore(krajnjiDatumIzv)) {
								System.out.println(rezervacija.getSifraRezervacije());
								if(rezervacija.getCheckOut().isBefore(krajnjiDatumIzv)) {
									//System.out.println("-------------------------------------------------------");
									brojac+=1;
									//System.out.println(brojac);
								}
							}
						}
					}
					
					lblIzvestaj.setText("Broj rezervacija sa statusom "+status+" u zeljenom periodu je: ");
					lblIzvestaj.setText(lblIzvestaj.getText() + brojac);
					lblIzvestaj.setVisible(true);

					
					}
					
					

					
				}

				// TODO Auto-generated method stub
				
			}
			
			
			
			
		});
		
	}
	
	
public boolean ValidateBeforeAndAfter(LocalDate pocetak, LocalDate kraj) {

		if(pocetak.isBefore(kraj)) {
				return true;
			}
		else {
			JOptionPane.showMessageDialog(null, "Unesite pocetaak i kraj izvestaja u ispravnom formatu!", "Greska", JOptionPane.ERROR_MESSAGE);
		return false;
		}
	
}


public boolean validateDate(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    try {
        sdf.parse(date);
        return true;
    }
    catch(ParseException e) {
    	JOptionPane.showMessageDialog(null, "Pogresan format datuma", "Greska", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    	
    }

}

