package test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import korisnici.Apartmani;
import korisnici.AplikacijaUtilities;
import korisnici.Cenovnik;
import korisnici.DodatneUsluge;
import korisnici.Gost;
import korisnici.Pol;
import korisnici.Rezervacije;
import korisnici.Sprema;
import korisnici.StatusApartmana;
import korisnici.Uloga;
import korisnici.Zaposleni;

class MenadzeriTest {
	

	@Test
	void ucitajZaposlene() {
		AplikacijaUtilities.ucitajZaposlene();
		int brZaposlenih=AplikacijaUtilities.getZaposleni().size();
		assertTrue(brZaposlenih!=0);
	}
	
	@Test
	void ucitajGoste() {
		AplikacijaUtilities.ucitajGoste();
		int brGostiju=AplikacijaUtilities.getGosti().size();
		assertTrue(brGostiju!=0);
	}
	
	@Test
	void ucitajApartmane() {
		AplikacijaUtilities.ucitajApartmane();
		int brApartmana=AplikacijaUtilities.getApartmani().size();
		assertTrue(brApartmana!=0);
		
	}
	
	@Test
	void ucitajCenovnik() {
		AplikacijaUtilities.ucitajCenovnik();
		int brCenovnika=AplikacijaUtilities.getCenovnik().size();
		assertTrue(brCenovnika!=0);
	}
	@Test
	void ucitajDodatneUsluge() {
		AplikacijaUtilities.ucitajDodatneUsluge();
		int brDodatneUsluge=AplikacijaUtilities.getDodatneUsluge().size();
		assertTrue(brDodatneUsluge!=0);
		
	}
	@Test
	void ucitajRezervacije() {
		AplikacijaUtilities.ucitajRezervacije();
		int brRez=AplikacijaUtilities.getRezervacije().size();
		assertTrue(brRez!=0);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Test
	void DodajZaposlenog() {
		Zaposleni zaposlen=new Zaposleni("Tanja", "MIlic", "tanja4@gmail.com","0698222345","6789","14.04.1998", "Skadarska 12, Vrbas", Pol.ZENSKI, Sprema.SREDNJA_SKOLA, "7", Uloga.SOBARICA, 0);
		int brojZaposlenih=AplikacijaUtilities.getZaposleni().size();
		AplikacijaUtilities.getZaposleni().add(zaposlen);
		int noviBrojZaposlenih=AplikacijaUtilities.getZaposleni().size();
		assertTrue(noviBrojZaposlenih==(brojZaposlenih+1));
		
	}
	
	@Test 
	void DodajGosta(){
		Gost gost=new Gost("Tanja", "MIlic", "tanja4@gmail.com","0698222345","6789","14.04.1998", "Skadarska 12, Vrbas", Pol.ZENSKI);
		int brojGostiju=AplikacijaUtilities.getGosti().size();
		AplikacijaUtilities.getGosti().add(gost);
		int noviBrojGostiju=AplikacijaUtilities.getGosti().size();
		assertTrue(noviBrojGostiju==(brojGostiju+1));
		
	}
	
	@Test
	void dodajCenovnik() {
		Cenovnik cenovnik=new Cenovnik("10", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 3, 3), "1000");
		int brojCenovnika=AplikacijaUtilities.getCenovnik().size();
		AplikacijaUtilities.getCenovnik().add(cenovnik);
		int noviBrojCenovnika=AplikacijaUtilities.getCenovnik().size();
		assertTrue(noviBrojCenovnika==(brojCenovnika+1));
	}
	
	@Test
	void dodajApartman() {
		Cenovnik cenovnik=new Cenovnik("10", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 3, 3), "1000");
		Apartmani apartman=new Apartmani("120", StatusApartmana.SLOBODNO, "dvokrevetna(1+1)", cenovnik);
		int brojApt=AplikacijaUtilities.getApartmani().size();
		AplikacijaUtilities.getApartmani().add(apartman);
		int noviBrojApt=AplikacijaUtilities.getApartmani().size();
		assertTrue(noviBrojApt==(brojApt+1));
	}
	@Test
	void dodajDodatneUsluge() {
		DodatneUsluge dodatna=new DodatneUsluge("10", "vatromet", "3200");
		int brojDodatna=AplikacijaUtilities.getDodatneUsluge().size();
		AplikacijaUtilities.getDodatneUsluge().add(dodatna);
		int noviBrojDodatne=AplikacijaUtilities.getDodatneUsluge().size();
		assertTrue(noviBrojDodatne==(brojDodatna+1));
	}
	
	@Test
	void DodajRezervaciju() {
		Rezervacije rezrvacija=new Rezervacije();
		int brojRez=AplikacijaUtilities.getRezervacije().size();
		AplikacijaUtilities.getRezervacije().add(rezrvacija);
		int novibrojRez=AplikacijaUtilities.getRezervacije().size();
		assertTrue(novibrojRez==(brojRez+1));
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Test
	void izmeniZaposlenog() {
		Zaposleni zaposlen=AplikacijaUtilities.nadjiZaposlenog("anja1@gmail.com");
		zaposlen.setkorisnickoIme("anja");
		assertTrue(zaposlen.getkorisnickoIme().equals("anja"));
		
	}
	
	@Test
	void izmeniApartman() {
		Apartmani apartman=AplikacijaUtilities.nadjiApartman("10");
		apartman.setSifraApartmana("200");
		assertTrue(apartman.getSifraApartmana().equals("200"));
	}
	
	
	@Test 
	void izmeniGosta(){
		AplikacijaUtilities.ucitajGoste();
		Gost gost=AplikacijaUtilities.nadjiGosta("djole@email.com");
		gost.setkorisnickoIme("djolica@email.com");
		assertTrue(gost.getkorisnickoIme().equals("djolica@email.com"));
	}
//	@Test
//	void izmeniCenovnik() {
//		AplikacijaUtilities.ucitajCenovnik();
//		Cenovnik cenovnik=AplikacijaUtilities.nadjiCenovnik("jednokrevetna(1)");
//		cenovnik.setSifraCenovnika("dvokrevetna(2)");
//		assertTrue(cenovnik.getSifraCenovnika().equals("dvokrevetna(2)"));
//		
//	}
	
	@Test
	void izmeniRezervaciju() {
		AplikacijaUtilities.ucitajRezervacije();
		Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije("4");
		rezervacija.setSifraRezervacije("5");
		assertTrue(rezervacija.getSifraRezervacije().equals("5"));
	}
	
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Test
	void obrisiGosta() {
		Gost gost=AplikacijaUtilities.nadjiGosta("djole@email.com");
		AplikacijaUtilities.getGosti().remove(gost);
		assertTrue(!(AplikacijaUtilities.getGosti().contains(gost)));
	}
	
	@Test
	void obrisiApartman() {
		Apartmani apartman=AplikacijaUtilities.nadjiApartman("10");
		AplikacijaUtilities.getApartmani().remove(apartman);
		assertTrue(!(AplikacijaUtilities.getApartmani().contains(apartman)));
	}
	
	@Test
	void obrisiZaposlenog() {
		Zaposleni zaposlen=AplikacijaUtilities.nadjiZaposlenog("anja1@gmail.com");
		AplikacijaUtilities.getZaposleni().remove(zaposlen);
		assertTrue(!(AplikacijaUtilities.getZaposleni().contains(zaposlen)));
	}
	
	@Test
	void obrisiCenovnik() {
		Cenovnik cenovnik=AplikacijaUtilities.nadjiCenovnik("9");
		AplikacijaUtilities.getCenovnik().remove(cenovnik);
		assertTrue(!(AplikacijaUtilities.getCenovnik().contains(cenovnik)));
		
		
	}
	
	@Test
	void obrisiRezervaciju(){
		Rezervacije rezervacija=AplikacijaUtilities.nadjiRezervacije("1");
		AplikacijaUtilities.getRezervacije().remove(rezervacija);
		assertTrue(!(AplikacijaUtilities.getRezervacije().contains(rezervacija)));
	}

}
