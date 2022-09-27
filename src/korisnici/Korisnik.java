package korisnici;

public abstract class Korisnik {
	private String ime;
	private String prezime;
	private Pol pol;
	private String korisnickoIme;
	private String brojTelefona;
	private String lozinka;
	private String datumRodjenja;
	private String adresa;


public Korisnik() {
	super();
}
public Korisnik(String ime, String prezime, String korisnickoIme, String brojTelefona, String lozinka, String datumRodjenja, String adresa, Pol pol) {
	super();
	this.ime=ime;
	this.prezime=prezime;
	this.korisnickoIme=korisnickoIme;
	this.adresa=adresa;
	this.brojTelefona=brojTelefona;
	this.lozinka=lozinka;
	this.datumRodjenja=datumRodjenja;
	this.pol=pol;
}

public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}

public Pol getPol() {
	return pol;
}

public void setPol(Pol pol) {
	this.pol = pol;
}

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public String getkorisnickoIme() {
	return korisnickoIme;
}

public void setkorisnickoIme(String korisnickoIme) {
	this.korisnickoIme = korisnickoIme;
}

public String getbrojTelefona() {
	return brojTelefona;
}

public void setbrojTelefona(String brojTelefona) {
	this.brojTelefona = brojTelefona;
}
public String getAdresa() {
	return adresa;
}
public void setAdresa(String adresa) {
	this.adresa = adresa;
}
public String getDatumRodjenja() {
	return datumRodjenja;
}
public void setDatumRodjenja(String datumRodjenja) {
	this.datumRodjenja = datumRodjenja;
}
public String getLozinka() {
	return lozinka;
}
public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

@Override
public String toString() {
	return "\nkorisnik:" + 
			"\nime: " + ime + 
			"\nprezime: " + prezime + 
			"\nbrTel: " + brojTelefona + 
			"\ndatumRodjenja: " + datumRodjenja + 
			"\nadresa: " + adresa + 
			"\nkorIme: " + korisnickoIme + 
			"\nlozinka: " + lozinka + 
			"\npol: " + pol;
}
}