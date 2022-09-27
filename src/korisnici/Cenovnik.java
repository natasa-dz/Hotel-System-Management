package korisnici;

import java.time.LocalDate;

public class Cenovnik {
	
	private Apartmani apartman;
	private String sifraCenovnika;
	private LocalDate pocetniDatumVazenja;
	private LocalDate krajnjiDatumVazenja;
	private String cena;
	
	public Cenovnik() {
		super();
	}
	
	public Cenovnik(String  sifraCenovnika, LocalDate pocetniDatumVazenja, LocalDate krajnjiDatumVazenja, String cena) {
		//this.setApartman(apartman);
		this.krajnjiDatumVazenja=krajnjiDatumVazenja;
		this.pocetniDatumVazenja=pocetniDatumVazenja;
		this.cena=cena;
		this.sifraCenovnika=sifraCenovnika;
	}

	public String getSifraCenovnika() {
		return sifraCenovnika;
	}

	public void setSifraCenovnika(String sifraCenovnika) {
		this.sifraCenovnika = sifraCenovnika;
	}

	public LocalDate getKrajnjiDatumVazenja() {
		return krajnjiDatumVazenja;
	}

	public void setKrajnjiDatumVazenja(LocalDate krajnjiDatumVazenja) {
		this.krajnjiDatumVazenja = krajnjiDatumVazenja;
	}
	
	public Apartmani getApartman() {
		return apartman;
	}

	public void setApartman(Apartmani apartman) {
		this.apartman = apartman;
	}


	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public LocalDate getPocetniDatumVazenja() {
		return pocetniDatumVazenja;
	}

	public void setPocetniDatumVazenja(LocalDate pocetniDatumVazenja) {
		this.pocetniDatumVazenja = pocetniDatumVazenja;
	}
	
	@Override
	public String toString() {
		return "\nCenovnik:" + 
				"\ncena: " + cena + 
				//"\nsifra: " + sifraCenovnika + 
				"\npocetniDatum: " + pocetniDatumVazenja+
				"\nkranjiDatum: "+krajnjiDatumVazenja;
	}


}
