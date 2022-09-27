package gui;


import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import korisnici.Rezervacije;
import korisnici.AplikacijaUtilities;
public class PieChartRezervacije {
	Rezervacije rezervacija;

//						  public static void main(String[] args) {
//							  AplikacijaUtilities.ucitajSveKorisnike();
//							  AplikacijaUtilities.ucitajDodatneUsluge();
//							  AplikacijaUtilities.ucitajCenovnik();
//							  AplikacijaUtilities.ucitajApartmane();
//							  AplikacijaUtilities.ucitajRezervacije();
//							  PieChartRezervacije chart= new PieChartRezervacije();
//							  chart.getChart();
//
//							  }
	  
	
	public PieChart getChart() {
		  AplikacijaUtilities.ucitajSveKorisnike();
		  AplikacijaUtilities.ucitajDodatneUsluge();
		  AplikacijaUtilities.ucitajCenovnik();
		  AplikacijaUtilities.ucitajApartmane();
		  AplikacijaUtilities.ucitajRezervacije();
		
		String title="Prikaz statusa rezervacija za prethodnih 30 dana";
	
		PieChart chart = new PieChartBuilder().width(800).height(600).title(title).build();

		
		// Customize Chart
	    Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
	    chart.getStyler().setSeriesColors(sliceColors);
	 
		
		HashMap<String, Integer> hesMapa = AplikacijaUtilities.prikazBrojaRezervacijaZeljenogTipa();
		for(String string1:hesMapa.keySet()) {
			chart.addSeries(string1, hesMapa.get(string1));
		}
		
		new SwingWrapper(chart).displayChart();


    return chart;
  }

}
