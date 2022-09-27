package korisnici;

public class OcisceneSobeDatumi {
	private String kIme;
	private String datumCiscenja;
	
	public OcisceneSobeDatumi(){
		super();
	}
	
	public OcisceneSobeDatumi(String kIme, String datumCiscenja ){
		this.kIme=kIme;
		this.datumCiscenja=datumCiscenja;
	}
	
	public String getDatumCiscenja() {
		return datumCiscenja;
	}
	public void setDatumCiscenja(String datumCiscenja) {
		this.datumCiscenja = datumCiscenja;
	}
	public String getkIme() {
		return kIme;
	}
	public void setkIme(String kIme) {
		this.kIme = kIme;
	}

}
