package gui;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.HashMap;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import korisnici.AplikacijaUtilities;
import korisnici.OcisceneSobeDatumi;
import korisnici.Uloga;
import korisnici.Zaposleni;

public class SobaricePieChart {
	
	  public static void main(String[] args) {

		  SobaricePieChart chart= new SobaricePieChart();
		  chart.getChart();

  }

	
	
public PieChart getChart() {
	  AplikacijaUtilities.ucitajSveKorisnike();
	  AplikacijaUtilities.ucitajOcisceneSobe();
	  AplikacijaUtilities.ucitajDodatneUsluge();
	  AplikacijaUtilities.ucitajCenovnik();
	  AplikacijaUtilities.ucitajApartmane();
	  AplikacijaUtilities.ucitajRezervacije();
	OcisceneSobeDatumi opterecenost;
	

		String title="Prikaz opterecenosti sobarica u prethodnih 30 dana";
	
		PieChart chart = new PieChartBuilder().width(800).height(600).title(title).build();

		
		// Customize Chart
	    Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
	    chart.getStyler().setSeriesColors(sliceColors);
	    
	    for(Zaposleni zaposlen:AplikacijaUtilities.getZaposleni()) {
	    	if(zaposlen.getUloga().equals(Uloga.SOBARICA)) {
	    		int Sobe=AplikacijaUtilities.brojOciscenihSobaZaposlenog(zaposlen.getkorisnickoIme());
	    		String brSoba=String.valueOf(Sobe);
	    		Integer broj=Integer.parseInt(brSoba);
	    		chart.addSeries(zaposlen.getkorisnickoIme(), broj);
	    	}
	    }
		
		new SwingWrapper(chart).displayChart();


    return chart;
  }

}
