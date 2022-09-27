package korisnici;

import java.util.ArrayList;
import java.util.List;

public class Apartmani {
	private String sifraApartmana;
	private StatusApartmana statusApartmana;
	private String tipApartmana;
	private DodatneUsluge dodatneUsluge;
	private Rezervacije rezervacija;
	private Cenovnik cenovnik;
	private Zaposleni sobarica;
	private List<String> dodatniSadrzaj;
	
	//prodji kroz apartmane, pronadji broj pojavljivanja imena spremacice u statusu sobe spremanje, incline za jedan brojac, brojac za tu spremacicu, ako je jednak nuli/veci je od najmanjeg brojaca dodeli njoj sobu za cicscenje
	public Apartmani() {
		super();
	}
	
	
//	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana, DodatneUsluge dodatneUsluge, Rezervacije rezervacija) {
//		this.sifraApartmana=sifraApartmana;
//		this.tipApartmana=tipApartmana;
//		this.statusApartmana=statusApartmana;
//		this.dodatneUsluge=dodatneUsluge;
//		this.rezervacija=rezervacija;
//	}
//	
//	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana) {
//		this.sifraApartmana=sifraApartmana;
//		this.tipApartmana=tipApartmana;
//		this.statusApartmana=statusApartmana;
//	}
	
	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana, Cenovnik cenovnik) {
		this.sifraApartmana=sifraApartmana;
		this.tipApartmana=tipApartmana;
		this.statusApartmana=statusApartmana;
		this.cenovnik=cenovnik;
		//this.SpremanjeDatumi=new ArrayList<String[]>();
	}
	
	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana, Cenovnik cenovnik, Zaposleni sobarica) {
		this.sifraApartmana=sifraApartmana;
		this.tipApartmana=tipApartmana;
		this.statusApartmana=statusApartmana;
		this.cenovnik=cenovnik;
		this.setSobarica(sobarica);
		//this.SpremanjeDatumi=new ArrayList<String[]>();
	}
	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana, Cenovnik cenovnik, Zaposleni sobarica, List<String> dodatniSadrzaj) {
		this.sifraApartmana=sifraApartmana;
		this.tipApartmana=tipApartmana;
		this.statusApartmana=statusApartmana;
		this.cenovnik=cenovnik;
		this.dodatniSadrzaj=dodatniSadrzaj;
		this.setSobarica(sobarica);
		//this.SpremanjeDatumi=new ArrayList<String[]>();
	}
	
//	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana, DodatneUsluge dodatneUsluge) {
//		this.sifraApartmana=sifraApartmana;
//		this.tipApartmana=tipApartmana;
//		this.statusApartmana=statusApartmana;
//		this.dodatneUsluge=dodatneUsluge;
//	}
//	
//	public Apartmani(String sifraApartmana, StatusApartmana statusApartmana, String tipApartmana, Cenovnik cenovnik, DodatneUsluge dodatneUsluge) {
//		this.sifraApartmana=sifraApartmana;
//		this.tipApartmana=tipApartmana;
//		this.statusApartmana=statusApartmana;
//		this.cenovnik=cenovnik;
//		this.dodatneUsluge=dodatneUsluge;
//	}


	public StatusApartmana getStatusApartmana() {
		return statusApartmana;
	}


	public void setStatusApartmana(StatusApartmana statusApartmana) {
		this.statusApartmana = statusApartmana;
	}


	public String getSifraApartmana() {
		return sifraApartmana;
	}


	public void setSifraApartmana(String sifraApartmana) {
		this.sifraApartmana = sifraApartmana;
	}


	public String getTipApartmana() {
		return tipApartmana;
	}


	public void setTipApartmana(String tipApartmana) {
		this.tipApartmana = tipApartmana;
	}
	
	

	public void setDodatneUsluge(DodatneUsluge dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}

	public Rezervacije getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacije rezervacija) {
		this.rezervacija = rezervacija;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}
	
	@Override
	public String toString() {
		return "\nAPARTMANI:" + 
				"\n-----------------------------------"+
				"\nSifra apartmana: " + sifraApartmana + 
				"\nstatusApartmana: " + statusApartmana + 
				"\nTip apartmana: " + tipApartmana;
				//"\nCena apartmana: "+this.cenovnik;
	}


	public DodatneUsluge getDodatneUsluge() {
		return dodatneUsluge;
	}


	public Zaposleni getSobarica() {
		return sobarica;
	}


	public void setSobarica(Zaposleni sobarica) {
		this.sobarica = sobarica;
	}



	public List<String> getDodatniSadrzaj() {
		return dodatniSadrzaj;
	}


	public void setDodatniSadrzaj(List<String> dodatniSadrzaj) {
		this.dodatniSadrzaj = dodatniSadrzaj;
	}



	




}

