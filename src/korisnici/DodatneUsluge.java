package korisnici;

public class DodatneUsluge {
	
	private String sifraUsluge;
	private String nazivUsluge;
	private String cenaUsluge;
	
	public DodatneUsluge(String sifraUsluge, String nazivUsluge, String cenaUsluge) {
		this.sifraUsluge=sifraUsluge;
		this.nazivUsluge=nazivUsluge;
		this.cenaUsluge=cenaUsluge;
	}
	
	
	public String getCenaUsluge() {
		return cenaUsluge;
	}
	public void setCenaUsluge(String cenaUsluge) {
		this.cenaUsluge = cenaUsluge;
	}
	public String getNazivUsluge() {
		return nazivUsluge;
	}
	public void setNazivUsluge(String nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}
	public String getSifraUsluge() {
		return sifraUsluge;
	}
	public void setSifraUsluge(String sifraUsluge) {
		this.sifraUsluge = sifraUsluge;
	}
	
	
	@Override
	public String toString() {
		return "\nDodatne Usluge:" + 
				"\nsifra: " + sifraUsluge + 
				"\nnaziv: " + nazivUsluge + 
				"\ncena: " + cenaUsluge;
	}
	

}
