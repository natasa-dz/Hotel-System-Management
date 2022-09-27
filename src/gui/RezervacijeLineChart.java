package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;

import korisnici.AplikacijaUtilities;
import korisnici.Meseci;
import korisnici.Rezervacije;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.knowm.xchart.AnnotationImage;
import org.knowm.xchart.AnnotationLine;
import org.knowm.xchart.AnnotationText;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.markers.None;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.LegendPosition;

/**
 * Cursor
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Cursor
 *   <li>Setting custom cursor tool tip text
 *   <li>Building a Chart with ChartBuilder
 */
public class RezervacijeLineChart implements ExampleChart<XYChart> {

  public static void main(String[] args) {
	  AplikacijaUtilities.ucitajApartmane();
	  AplikacijaUtilities.ucitajCenovnik();
	  AplikacijaUtilities.ucitajRezervacije();

    ExampleChart<XYChart> exampleChart = new RezervacijeLineChart();
    XYChart chart = exampleChart.getChart();
    new SwingWrapper<>(chart).displayChart();
  }

  @Override
  public XYChart getChart() {

    // Create Chart
    XYChart chart =
        new XYChartBuilder()
            .width(800)
            .height(600)
            .title("Prihodi po tipu sobe")
            .xAxisTitle("MESECI")
            .yAxisTitle("PRIHOD").theme(ChartTheme.GGPlot2)
            .build();

    // Customize Chart
    chart.getStyler().setLegendPosition(LegendPosition.InsideSE);
    chart.getStyler().setLegendFont(new Font(Font.SERIF, Font.PLAIN, 18));
    chart.getStyler().setAxisTitlesVisible(false);
    chart.getStyler().setLegendPosition(LegendPosition.OutsideS);
    chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);

    chart.getStyler().setCursorEnabled(true);
    //    chart.getStyler().setCursorColor(Color.GREEN);
    //    chart.getStyler().setCursorLineWidth(30f);
    //    chart.getStyler().setCursorFont(new Font("Verdana", Font.BOLD, 12));
    //    chart.getStyler().setCursorFontColor(Color.ORANGE);
    //    chart.getStyler().setCursorBackgroundColor(Color.BLUE);
    //    chart.getStyler().setCustomCursorXDataFormattingFunction(x -> "hello xvalue: " + x);
    //    chart
    //        .getStyler()
    //        .setCustomCursorYDataFormattingFunction(y -> "hello yvalue divided by 2: " + y / 2);
    double ukupno410=AplikacijaUtilities.prihodTipSobe(Month.OCTOBER, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.OCTOBER, "cetvorokrevetna(2+1+1)");
    double ukupno411=AplikacijaUtilities.prihodTipSobe(Month.NOVEMBER, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.NOVEMBER, "cetvorokrevetna(2+1+1)");
    double ukupno412=AplikacijaUtilities.prihodTipSobe(Month.DECEMBER, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.DECEMBER, "cetvorokrevetna(2+1+1)");
    double ukupno41=AplikacijaUtilities.prihodTipSobe(Month.JANUARY, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.JANUARY, "cetvorokrevetna(2+1+1)");
    double ukupno42=AplikacijaUtilities.prihodTipSobe(Month.FEBRUARY, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.FEBRUARY, "cetvorokrevetna(2+1+1)");
    double ukupno43=AplikacijaUtilities.prihodTipSobe(Month.MARCH, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.MARCH, "cetvorokrevetna(2+1+1)");
    double ukupno44=AplikacijaUtilities.prihodTipSobe(Month.APRIL, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.APRIL, "cetvorokrevetna(2+1+1)");
    double ukupno45=AplikacijaUtilities.prihodTipSobe(Month.MAY, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.MAY, "cetvorokrevetna(2+1+1)");
    double ukupno46=AplikacijaUtilities.prihodTipSobe(Month.JUNE, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.JUNE, "cetvorokrevetna(2+1+1)");
    double ukupno47=AplikacijaUtilities.prihodTipSobe(Month.JULY, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.JULY, "cetvorokrevetna(2+1+1)");
    double ukupno48=AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "cetvorokrevetna(2+1+1)");
    double ukupno49=AplikacijaUtilities.prihodTipSobe(Month.SEPTEMBER, "cetvorokrevetna(2+2)")+ AplikacijaUtilities.prihodTipSobe(Month.SEPTEMBER, "cetvorokrevetna(2+1+1)");
    
    //=====================================================================================================================================================================================
    
    double ukupno210=AplikacijaUtilities.prihodTipSobe(Month.OCTOBER, "dvokrevetna sa jednim lezajem(2)")+AplikacijaUtilities.prihodTipSobe(Month.OCTOBER, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno211=AplikacijaUtilities.prihodTipSobe(Month.NOVEMBER, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.NOVEMBER,"dvokrevetna sa dva lezaja(1+1)");
    double ukupno212=AplikacijaUtilities.prihodTipSobe(Month.DECEMBER, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.DECEMBER, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno21=AplikacijaUtilities.prihodTipSobe(Month.JANUARY, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.JANUARY, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno22=AplikacijaUtilities.prihodTipSobe(Month.FEBRUARY, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.FEBRUARY,"dvokrevetna sa dva lezaja(1+1)");
    double ukupno23=AplikacijaUtilities.prihodTipSobe(Month.MARCH,"dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.MARCH, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno24=AplikacijaUtilities.prihodTipSobe(Month.APRIL, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.APRIL, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno25=AplikacijaUtilities.prihodTipSobe(Month.MAY, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.MAY, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno26=AplikacijaUtilities.prihodTipSobe(Month.JUNE, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.JUNE, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno27=AplikacijaUtilities.prihodTipSobe(Month.JULY, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno28=AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "dvokrevetna sa dva lezaja(1+1)");
    double ukupno29=AplikacijaUtilities.prihodTipSobe(Month.SEPTEMBER,"dvokrevetna sa jednim lezajem(2)")+ AplikacijaUtilities.prihodTipSobe(Month.SEPTEMBER, "dvokrevetna sa dva lezaja(1+1)");
    
    //==============================================================================================================================================================================================
    double ukupno310=AplikacijaUtilities.prihodTipSobe(Month.OCTOBER, "trokrevetna(2+1)")+AplikacijaUtilities.prihodTipSobe(Month.OCTOBER, "trokrevetna(1+1+1)");
    double ukupno311=AplikacijaUtilities.prihodTipSobe(Month.NOVEMBER, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.NOVEMBER,"trokrevetna(1+1+1)");
    double ukupno312=AplikacijaUtilities.prihodTipSobe(Month.DECEMBER, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.DECEMBER, "trokrevetna(1+1+1)");
    double ukupno31=AplikacijaUtilities.prihodTipSobe(Month.JANUARY, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.JANUARY, "trokrevetna(1+1+1)");
    double ukupno32=AplikacijaUtilities.prihodTipSobe(Month.FEBRUARY, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.FEBRUARY,"trokrevetna(1+1+1)");
    double ukupno33=AplikacijaUtilities.prihodTipSobe(Month.MARCH,"trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.MARCH, "trokrevetna(1+1+1)");
    double ukupno34=AplikacijaUtilities.prihodTipSobe(Month.APRIL, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.APRIL, "trokrevetna(1+1+1)");
    double ukupno35=AplikacijaUtilities.prihodTipSobe(Month.MAY, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.MAY, "trokrevetna(1+1+1)");
    double ukupno36=AplikacijaUtilities.prihodTipSobe(Month.JUNE, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.JUNE, "trokrevetna(1+1+1)");
    double ukupno37=AplikacijaUtilities.prihodTipSobe(Month.JULY, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "trokrevetna(1+1+1)");
    double ukupno38=AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.AUGUST, "trokrevetna(1+1+1)");
    double ukupno39=AplikacijaUtilities.prihodTipSobe(Month.SEPTEMBER,"trokrevetna(2+1)")+ AplikacijaUtilities.prihodTipSobe(Month.SEPTEMBER, "trokrevetna(1+1+1)");
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Series
    chart.addSeries("TROKREVETNA", new double[] {10, 11, 12, 1, 2,3, 4,5, 6, 7, 8, 9}, new double[]  {ukupno310,ukupno311,ukupno312,ukupno31,ukupno32,ukupno33,ukupno34,ukupno35,ukupno36,ukupno37, ukupno38,  ukupno39});
    chart.addSeries("DVOKREVETNA", new double[] {10, 11, 12, 1, 2,3, 4,5, 6, 7, 8, 9}, new double[] {ukupno210,ukupno211,ukupno212,ukupno21,ukupno22,ukupno23,ukupno24,ukupno25,ukupno26,ukupno27, ukupno28,  ukupno29});
    //chart.addSeries("JEDNOKREVETNA", new double[] {10, 11, 12, 1, 2,3, 4,5, 6, 7, 8, 9}, new double[] {-2,34,56,86,89,34,23,45,78,8, -1, 1});
    chart.addSeries("CETVOROKREVETNA", new double[] {10, 11, 12, 1, 2,3, 4,5, 6, 7, 8, 9}, new double[]{ukupno410,ukupno411,ukupno412,ukupno41,ukupno42,ukupno43,ukupno44,ukupno45,ukupno46,ukupno47, ukupno48, ukupno49});
    chart.addSeries("UKUPNO", new double[] {10, 11, 12, 1, 2,3, 4,5, 6, 7, 8, 9}, new double[]{AplikacijaUtilities.prihodUkupno(Month.OCTOBER),AplikacijaUtilities.prihodUkupno(Month.NOVEMBER),AplikacijaUtilities.prihodUkupno(Month.DECEMBER),AplikacijaUtilities.prihodUkupno(Month.JANUARY),AplikacijaUtilities.prihodUkupno(Month.FEBRUARY),AplikacijaUtilities.prihodUkupno(Month.MARCH),AplikacijaUtilities.prihodUkupno(Month.APRIL),AplikacijaUtilities.prihodUkupno(Month.MAY),AplikacijaUtilities.prihodUkupno(Month.JUNE),AplikacijaUtilities.prihodUkupno(Month.JULY), AplikacijaUtilities.prihodUkupno(Month.AUGUST), AplikacijaUtilities.prihodUkupno(Month.SEPTEMBER)});
    


    return chart;
  }

  @Override
  public String getExampleChartName() {

    return getClass().getSimpleName() + " - Cursor";
  }
}
