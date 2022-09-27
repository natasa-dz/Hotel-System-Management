package korisnici;

import java.time.LocalDate;

public class Rezervacije {
	private String sifraRezervacije;
	private StatusRezervacije status;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Korisnik gosti;
	private Apartmani apartman;
	private boolean dosao;
	private boolean otisao;
	private DodatneUsluge dodatneUsluge;
	private double ukupnaCenaRezervacije;
	
	public Rezervacije() {
		super();
	}
	
	public 	Rezervacije(String sifraRezervacije, Korisnik gosti, Apartmani apartman, LocalDate checkIn, LocalDate checkOut, StatusRezervacije status, boolean dosao, boolean otisao) {
		this.gosti=gosti;
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		this.sifraRezervacije=sifraRezervacije;
		this.status=status;
		this.apartman=apartman;
		this.dosao=dosao;
		this.otisao=otisao;
	}
	
	public 	Rezervacije(String sifraRezervacije, Korisnik gosti, Apartmani apartman, LocalDate checkIn, LocalDate checkOut, double ukupnaCenaRezervacije, StatusRezervacije status, boolean dosao, boolean otisao) {
		this.gosti=gosti;
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		this.sifraRezervacije=sifraRezervacije;
		this.status=status;
		this.apartman=apartman;
		this.dosao=dosao;
		this.otisao=otisao;
		this.ukupnaCenaRezervacije=ukupnaCenaRezervacije;
	}
	
	public 	Rezervacije(String sifraRezervacije, Korisnik gosti, Apartmani apartman, LocalDate checkIn, LocalDate checkOut, StatusRezervacije status, boolean dosao, boolean otisao, DodatneUsluge dodatneUsluge ) {
		this.gosti=gosti;
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		this.sifraRezervacije=sifraRezervacije;
		this.status=status;
		this.apartman=apartman;
		this.dosao=dosao;
		this.otisao=otisao;
		this.dodatneUsluge=dodatneUsluge;
	}
	
	
	public Korisnik getGost() {
		return gosti;
	}

	public void setGost(Korisnik gosti) {
		this.gosti = gosti;
	}
	
	
	public String getSifraRezervacije() {
		return sifraRezervacije;
	}

	public void setSifraRezervacije(String sifraRezervacije) {
		this.sifraRezervacije = sifraRezervacije;
	}

	public StatusRezervacije getStatus() {
		return status;
	}

	public void setStatus(StatusRezervacije status) {
		this.status = status;
	}


	public LocalDate getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}


	public LocalDate getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	public Apartmani getApartman() {
		return apartman;
	}

	public void setApartman(Apartmani apartman) {
		this.apartman = apartman;
	}
	

	public boolean isDosao() {
		return dosao;
	}

	public void setDosao(boolean dosao) {
		this.dosao = dosao;
	}

	public boolean isOtisao() {
		return otisao;
	}

	public void setOtisao(boolean otisao) {
		this.otisao = otisao;
	}
	
	@Override
	public String toString() {
		return "\nREZERVACIJA:" + 
				"\ncheckIn: " + checkIn + 
				"\ncheckOut: " + checkOut + 
				"\nsifraRezervacije: " + sifraRezervacije + 
				"\nstatus: " + status+
				"\ngost: "+gosti+
				"\napartman:"+apartman;
				//"\nsifra apartmana: "+apartman.getSifraApartmana();
	}

	public DodatneUsluge getDodatneUsluge() {
		return dodatneUsluge;
	}

	public void setDodatneUsluge(DodatneUsluge dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}

	public double getUkupnaCenaRezervacije() {
		return ukupnaCenaRezervacije;
	}

	public void setUkupnaCenaRezervacije(double ukupnaCenaRezervacije) {
		this.ukupnaCenaRezervacije = ukupnaCenaRezervacije;
	}


	

}
