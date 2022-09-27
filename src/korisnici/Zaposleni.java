package korisnici;

import java.time.LocalDate;
import java.util.ArrayList;

public class Zaposleni extends Korisnik {
	private String staz;
	private Sprema sprema;
	private Uloga uloga;
	Zaposleni zaposlen;
	private int BrOciscenihSoba;
	
	public Zaposleni(Sprema sprema, String staz, Uloga uloga) {
		super();
		this.uloga=uloga;
		this.sprema=sprema;
		this.staz=staz;

	}
	public Zaposleni(String ime, String prezime, String korisnickoIme, String brojTelefona, String lozinka, String datumRodjenja, String adresa, Pol pol, Sprema sprema, String staz, Uloga uloga) {
		super(ime,prezime,korisnickoIme, brojTelefona, lozinka, datumRodjenja, adresa, pol);
		this.uloga=uloga;
		this.sprema=sprema;
		this.staz=staz;

	}
	public Zaposleni(String ime, String prezime, String korisnickoIme, String brojTelefona, String lozinka, String datumRodjenja, String adresa, Pol pol, Sprema sprema, String staz, Uloga uloga, int BrOciscenihSoba) {
		super(ime,prezime,korisnickoIme, brojTelefona, lozinka, datumRodjenja, adresa, pol);
		this.uloga=uloga;
		this.sprema=sprema;
		this.staz=staz;
		this.BrOciscenihSoba=BrOciscenihSoba;

	}
	
	public Sprema getSprema() {
		return sprema;
	}
	public void setSprema(Sprema sprema) {
		this.sprema = sprema;
	}
	public String getStaz() {
		return staz;
	}
	public void setStaz(String staz) {
		this.staz = staz;
	}
	public Uloga getUloga() {
		return uloga;
	}
	
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	
	public int getBrOciscenihSoba() {
		// TODO Auto-generated method stub
		return BrOciscenihSoba;
	}
	public void setBrOciscenihSoba(int BrOciscenihSoba) {
		this.BrOciscenihSoba = BrOciscenihSoba;
	}
	
	////////////////////////////////////////////////////////////////// NAPISI METODU ZA IZRACUNAVANJE PLATE ////////////////////////////////////////////

	public double getPlata() {
		double plata = 0;
		
		if (this.getUloga().equals(Uloga.SOBARICA)) {
			staz=this.getStaz();
			int koeficijent=Integer.parseInt(staz);
			plata=koeficijent*3000+35000;
		}
		else if(this.getUloga().equals(Uloga.ADMINISTRATOR)) {
			staz=this.getStaz();
			int koeficijent=Integer.parseInt(staz);
			plata=koeficijent*4000+70000;
		}
		
		else if(this.getUloga().equals(Uloga.RECEPCIONAR)) {
			staz=this.getStaz();
			int koeficijent=Integer.parseInt(staz);
			plata=koeficijent*3500+55000;
		}
		return plata;
		
		
	}
	

@Override
public String toString() {
	//double plata1=getPlata();
	//String prihod=String.valueOf(plata1);
	return "\nZAPOSLENI:" + 
			"\nime: " + getIme() + 
			"\nprezime: " + getPrezime() + 
			"\nbrTel: " + getbrojTelefona() + 
			"\ndatumRodjenja: " + getDatumRodjenja() + 
			"\nadresa: " + getAdresa() + 
			"\nkorIme: " + getkorisnickoIme() + 
			"\nlozinka: " + getLozinka() + 
			"\npol: " + getPol()+
			"\nsprema: " + getSprema() + 
			"\nstaz: " + getStaz() + 
			"\nplata: " +getPlata()+ 
			"\nuloga: " + getUloga();
	
	
}
}
