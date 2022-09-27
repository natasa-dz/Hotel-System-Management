package korisnici;

public enum Meseci {

	Januar(1), Fabruar(2), Mart(3), April(4), Maj(5), Jun(6), Jul(7), Avgust(8), Septembar(9), Oktobar(10), Novembar(11), Decembar(12);
	
	private int broj;
	
	Meseci(int broj){
		this.broj=broj;
	}
	
	public static Meseci Int(int brojMeseca) {
		for(Meseci mesec:values()) {
			if(mesec.broj==brojMeseca) {
				return mesec;
			}
		}
		return null;
	}
	
	public int getVrednost() {
		return broj;
	}

}
