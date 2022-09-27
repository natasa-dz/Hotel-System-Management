package korisnici;

public class Gost extends Korisnik {
	
	public Gost(){
		super();
	}


public Gost(String ime, String prezime, String korIme, String brTel,
		  String lozinka, String datumRodjenja, String adresa, Pol pol) {
	super(ime, prezime, korIme, brTel,lozinka, datumRodjenja, adresa,  pol);
	
}}