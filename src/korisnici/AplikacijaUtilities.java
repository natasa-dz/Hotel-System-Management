package korisnici;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class AplikacijaUtilities {
	
	public static ArrayList<Zaposleni> zaposleni=new ArrayList<Zaposleni>();
	public static ArrayList<Apartmani> apartmani=new ArrayList<Apartmani>();
	public static ArrayList<Rezervacije> rezervacije=new ArrayList<Rezervacije>();
	public static ArrayList<Gost> gosti=new ArrayList<Gost>();
	public static ArrayList<DodatneUsluge> usluge=new ArrayList<DodatneUsluge>();	
	public static ArrayList<Cenovnik> cenovnici=new ArrayList<Cenovnik>();
	public static ArrayList<Korisnik> sviKorisnici=new ArrayList<Korisnik>();
	public static ArrayList<String> tipoviApartmana=new ArrayList<String>();
	public static ArrayList<OcisceneSobeDatumi> ocisceneSobe=new ArrayList<OcisceneSobeDatumi>();
	
	
//----------------------------------------------------- UCITAVANJE I CUVANJE PODATAKA -----------------------------------------------------------------------
	
	public static void ucitajOcisceneSobe() {
		ocisceneSobe.clear();
		try {
			File file=new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//ocisceneSobe.txt/");
			BufferedReader reader=new BufferedReader((new FileReader(file)));
			String linija;
			while ((linija=reader.readLine())!=null) {
				String[] podaci=linija.split("\\|");
				String kIme=podaci[0];
				String datumCiscenja=podaci[1];
				OcisceneSobeDatumi ciscenje=new OcisceneSobeDatumi(kIme, datumCiscenja);
				ocisceneSobe.add(ciscenje);
			}
		
		reader.close();}
		
	catch (IOException e) {
		System.out.println("Greska prilikom ucitavanja zaposlenih.");
		e.printStackTrace();
	}}
	
	public static void sacuvajOcisceneSobe() {
		// TODO Auto-generated method stub
		try {
			File ociscenoFajl = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//ocisceneSobe.txt/");
			String content = "";
			for(OcisceneSobeDatumi ocisceno:ocisceneSobe) {
				content +=  ocisceno.getkIme()+ "|" + ocisceno.getDatumCiscenja() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(ociscenoFajl));
			writer.write(content);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Greska prilikom upisa u fajla", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		
	}
		
	
	public static void ucitajZaposlene() {
		zaposleni.clear();
		
		try {
			File file = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//zaposleni.txt/");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija;
			while ((linija = reader.readLine()) !=null) {
				String[] podaci = linija.split("\\|");
				String ime = podaci[0];
				String prezime = podaci[1];
				String pol = podaci[2];
				String datumRodjenja=podaci[3];
				String brTel = podaci[4];
				String adresa = podaci[5];
				String korIme = podaci[6];
				String lozinka = podaci[7];
				String ulogaKor = podaci[8];
				String staz=podaci[9];
				String spremaZaposlenog=podaci[10];
				String brojOciscenihSoba=podaci[11];
				int brOSoba=Integer.parseInt(brojOciscenihSoba);
				Sprema sprema= Sprema.valueOf(spremaZaposlenog);
				Uloga uloga = Uloga.valueOf(ulogaKor);
				Pol p = Pol.valueOf(pol);
				Zaposleni zaposlen = new Zaposleni(ime, prezime, korIme, brTel, lozinka, datumRodjenja, adresa, 
										 p ,sprema, staz, uloga, brOSoba);
				zaposleni.add(zaposlen);
				
			}
			reader.close();
			
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja zaposlenih.");
			e.printStackTrace();
		}
		
//		for(Zaposleni zaposlen:zaposleni) {
//			System.out.println(zaposlen);
//		}
	}
	

	public static void ucitajGoste() {
		
		gosti.clear();
		
		try {
			File file = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//gosti.txt/");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija;
			while ((linija = reader.readLine()) !=null) {
				String[] podaci = linija.split("\\|");
				String ime = podaci[0];
				String prezime = podaci[1];
				String pol = podaci[2];
				String datumRodjenja=podaci[3];
				String brTel = podaci[4];
				String adresa = podaci[5];
				String korIme = podaci[6];
				String lozinka = podaci[7];
				Pol p = Pol.valueOf(pol);
				Gost gost1 = new Gost(ime, prezime, korIme, brTel, lozinka, datumRodjenja, adresa, 
						 p);
				gosti.add(gost1);
				}
			reader.close();
		}
		
		catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja gostiju.");
			e.printStackTrace();
			}
		
//		for(Gost gost1:gosti) {
//			System.out.println(gost1);
//		}
		
	}

	
	public static void ucitajRezervacije() {
		rezervacije.clear();
		
		try {
			File file = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//rezervacije.txt/");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija;
			while ((linija = reader.readLine()) !=null) {
				
				String[] podaci = linija.split("\\|");
				rezervacije=getRezervacije();
				
				Rezervacije rez=new Rezervacije();
				rez.setSifraRezervacije(podaci[0]);
				
				rez.setGost(nadjiGosta(podaci[1]));
				rez.setApartman(nadjiApartman(podaci[2]));
				
				String korisnickoImeGosta=podaci[1];
				String sifraApartmana=podaci[2];
				rez.setGost(nadjiGosta(korisnickoImeGosta));
				rez.setApartman(nadjiApartman(sifraApartmana));
				
				String checkIn = podaci[3];
				LocalDate pocetak=LocalDate.parse(checkIn);
				rez.setCheckIn(pocetak);
				
				String checkOut = podaci[4];
				LocalDate kraj=LocalDate.parse(checkOut);
				rez.setCheckOut(kraj);
				String statusRezervacija=podaci[5];
				StatusRezervacije status= StatusRezervacije.valueOf(statusRezervacija);
				
				String dosao=podaci[6];


				String otisao=podaci[7];


				
				double ukupnaCena=Double.parseDouble(podaci[8]);
				rez.setUkupnaCenaRezervacije(ukupnaCena);
				
				boolean checkedIn=Boolean.parseBoolean(dosao);
				
				rez.setDosao(checkedIn);
				boolean checkedOut=Boolean.parseBoolean(otisao);
				rez.setOtisao(checkedOut);

				
				
				rez.setStatus(status);
				rezervacije.add(rez);
				
			}
			reader.close();
			
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja rezervacije.");
			e.printStackTrace();
		}
		//for(Rezervacije rezervacija:rezervacije) {
		//	System.out.println(rezervacija);
		//}
	}
	

	public static void ucitajApartmane() {
		apartmani.clear();
		try {
			File file=new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//apartmani.txt/");
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String linija;
			while ((linija=reader.readLine())!=null) {
				
				apartmani=getApartmani();
				Apartmani apartman=new Apartmani();
				String[] podaci=linija.split("\\|");
				
				String sifraApartmana=podaci[0];
				apartman.setSifraApartmana(sifraApartmana);
				
				String tipApartmana=podaci[1];
				apartman.setTipApartmana(tipApartmana);
				
				String statusAp=podaci[2];
				//System.out.println(statusAp);
				
				String sobarica=podaci[3];
				//System.out.println(sobarica);
				
				apartman.setCenovnik(nadjiCenovnik(podaci[1]));
				apartman.setSobarica(nadjiZaposlenog(sobarica));
				
				StatusApartmana status=StatusApartmana.valueOf(statusAp);
				apartman.setStatusApartmana(status);
				
				String [] sadrzaj=podaci[4].split(",");
				List<String> sadrzajLista=Arrays.asList(sadrzaj);
//				for(String podatak:sadrzaj) {
//					System.out.println(podatak);
//				}
//				System.out.println("------------------------------------------------------");
				apartman.setDodatniSadrzaj(sadrzajLista);
				apartmani.add(apartman);
				}
			reader.close();
		}
		catch(IOException e){
			System.out.println("Greska prilikom ucitavanja apartmana!");
			e.printStackTrace();
			
		}
//		for(Apartmani apartman:apartmani) {
//			System.out.println(apartman);
//		}
//		
	}

	
	
	public static void ucitajDodatneUsluge() {
		usluge.clear();
		  try { 
			  File file=new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//dodatne usluge.txt/");
			  BufferedReader reader=new BufferedReader(new FileReader(file));
			  String linija;
			  while ((linija=reader.readLine())!=null) {
				  String[] podaci=linija.split("\\|");
				  String sifra =podaci[0];
				  String usluga =podaci[1];
				  String cena=podaci[2];
				  DodatneUsluge usluga1=new DodatneUsluge(sifra, usluga, cena);
				  usluge.add(usluga1);  
			  }
			  reader.close();
			  }
		  
		  catch(IOException e){
			  System.out.println("Greska prilikom ucitavanja dodatnih usluga!");
			  e.printStackTrace();
		  }
		  
//		  for (DodatneUsluge usluga1:usluge) {
//			  System.out.println(usluga1);
//		  }
		 
	}


	public static void ucitajCenovnik() {
		cenovnici.clear();
		  try { 
			  
			  File file=new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//cenovnik.txt/"); 
			  BufferedReader reader=new BufferedReader(new FileReader(file));
				String linija;
				//datum ti kada splitujes po :, prvo vraca kobasicu, a drugo krajVazenja, docepaj se samo pocetakVazenja iz kobasice
				
				while ((linija=reader.readLine())!=null) {
					
					String[] podaci = linija.split("\\|");
					String [] datumi=linija.split(":");
					String [] test=linija.split("[|:]");

					cenovnici=getCenovnik();
					Cenovnik cenovnik=new Cenovnik();
					
					String tipApartmana= test[0];
					String cenaNocenja=test[1];
					LocalDate pocetakCenovnika=LocalDate.parse(test[2]);
					LocalDate krajCenovnika=LocalDate.parse(test[3]);

					
					cenovnik.setCena(cenaNocenja);
					cenovnik.setKrajnjiDatumVazenja(krajCenovnika);
					cenovnik.setPocetniDatumVazenja(pocetakCenovnika);
					cenovnik.setSifraCenovnika(tipApartmana);
					
					System.out.println(cenovnik);
					System.out.println("------------------------------------------------");
					cenovnici.add(cenovnik);	
					
					
					}
				reader.close();
				

				}
		  catch(IOException e){
			  System.out.println("Greska prilikom ucitavanja cenovnika!");
		  }
//		  for (Cenovnik cenovnik:cenovnici) {
//			  System.out.println(cenovnik);
//		  }

	}
	
	
	public static void ucitajSveKorisnike() {
		ucitajZaposlene();
		ucitajGoste();
		
		for (Zaposleni zaposlen:zaposleni) {
			sviKorisnici.add(zaposlen);
		}
		
		for (Gost gost1:gosti) {
			sviKorisnici.add(gost1);
		}	
	}
	
	
	//--------------------------------------------------------------- GET I SET ZA ARRAYLISTE ----------------------------------------------------
	
	public static ArrayList<Korisnik> getKorisnici(){
		return sviKorisnici;
	}
	
	public static ArrayList<Korisnik> setKorisnici(ArrayList<Korisnik> sviKorisnici){
		return AplikacijaUtilities.sviKorisnici=sviKorisnici;
	}
	
	
	public static ArrayList<Zaposleni> getZaposleni(){
		return zaposleni;
	}
	
	public static ArrayList<Zaposleni> setZaposleni(ArrayList<Zaposleni> zaposleni){
		return AplikacijaUtilities.zaposleni=zaposleni;
	}

	
	public static ArrayList<Gost> getGosti(){
		return gosti;
	}
	
	public static ArrayList<Gost> setGosti(ArrayList<Gost> gosti){
		return AplikacijaUtilities.gosti=gosti;
	}
	
	
	public static ArrayList<Cenovnik> getCenovnik(){
		return cenovnici;
	}
	
	public static ArrayList<Cenovnik> setCenovnik(ArrayList<Cenovnik> cenovnici){
		return AplikacijaUtilities.cenovnici=cenovnici;
	}
	
	public static ArrayList<Rezervacije> getRezervacije(){
		return rezervacije;
	}
	
	public static ArrayList<Rezervacije> setRezervacije(ArrayList<Rezervacije> rezervacije){
		return AplikacijaUtilities.rezervacije=rezervacije;
	}
	
	public static ArrayList<DodatneUsluge> getDodatneUsluge(){
		return usluge;
	}
	
	public static ArrayList<DodatneUsluge> setDodatneUsluge(ArrayList<DodatneUsluge> usluge){
		return AplikacijaUtilities.usluge=usluge;
	}
	
	public static ArrayList<Apartmani> setApartmani(ArrayList<Apartmani> apartmani){
		return AplikacijaUtilities.apartmani=apartmani;
	}
	public static ArrayList<Apartmani> getApartmani(){
		return apartmani;
	}
	
	public static ArrayList<OcisceneSobeDatumi> setDatumi(ArrayList<OcisceneSobeDatumi> ocisceneSobe){
		return AplikacijaUtilities.ocisceneSobe=ocisceneSobe;
	}
	public static ArrayList<OcisceneSobeDatumi> getDatumi(){
		return ocisceneSobe;
	}
	
	
	//----------------------------------------------- nalazenje trazenih objekata putem id-a ----------------------------------------------------------
	
	public static Zaposleni nadjiZaposlenog(String korisnickoIme) {
		for (Zaposleni zaposlen:zaposleni) {
			if(zaposlen.getkorisnickoIme().equals(korisnickoIme)) {
				return zaposlen;
			}
		}
		return null;
	}
	
	
	public static Gost nadjiGosta(String korisnickoIme) {
		for (Gost gost1:gosti) {
			if(gost1.getkorisnickoIme().equals(korisnickoIme)) {
				return gost1;
			}
		}
		return null;
	}
	
	public static Apartmani nadjiApartmanTip(String tipApartmana) {
		for(Apartmani apartman:apartmani) {
			if(apartman.getTipApartmana().equals(tipApartmana)) {
				return apartman;
			}
		}
		return null;
	}
	
	public static Cenovnik nadjiCenovnik(String tipApartmana) {
		
		for (Cenovnik cenovnik:cenovnici) {
			if(cenovnik.getSifraCenovnika().equals(tipApartmana)) {
				//System.out.println(cenovnik);
				return cenovnik;
			}
			
		}
		return null;
		
	}
	
	public static Apartmani nadjiApartman(String sifraApartmana) {
		for (Apartmani apartman:apartmani) {
			if(apartman.getSifraApartmana().equals(sifraApartmana)) {
				return apartman;
			}
		}
		return null;
	}
	
	public static boolean nadjiPoTipu(String tipApartmana) {
		for (Rezervacije rezervacija:rezervacije) {
			if (rezervacija.getApartman().equals(null)) {
				return false;
			}
			else if(rezervacija.getApartman().getTipApartmana().equals(tipApartmana)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static ArrayList<String> ucitajTipoveApartmana() {
		
		for(Apartmani apartman:apartmani) {
			tipoviApartmana.add(apartman.getTipApartmana().toString());
			return tipoviApartmana;
		}
		
		return null;
	}
	
	// ----------------------------------------------------- REZERVACIJE -----------------------------------------------------------
	public static boolean RezGlaseNaIstiApartman(Rezervacije rezervacija){

		String sifraApartmana=rezervacija.getApartman().getSifraApartmana();
		
		for(Rezervacije rezervacija1:rezervacije){

			if (!(rezervacija1.equals(rezervacija))){
				//System.out.println(rezervacija1.getApartman().getSifraApartmana());
			if (rezervacija1.getApartman().getSifraApartmana().equals(sifraApartmana)){
				return true;
			}
		}
		}
		return false;
	}
	
	//da li mozemo dobiti zeljeni opseg za zeljeni tip Apartmana
	
	public static boolean proveriDaLiJeRezervacijaVanOpsegaRezervisanih(LocalDate dolazak, LocalDate odlazak, String TipApartmana) {
		
		for(Rezervacije rezervacija:rezervacije) {

			
			//kada je sifra apartmana ista sa sifrom u rezervacijama, tj. vec postoji
			//obradi slucaj kada sifra apartmana uopste ne postoji u rezervacijama, tj. not in rezervacije, ne moze ! jer vraca sve one posotojece koje nisu ta!!!!
			if(TipApartmana.equals(rezervacija.getApartman().getTipApartmana())) {
				
			LocalDate pocetakRezervacije=rezervacija.getCheckIn();
			LocalDate krajRezervacije=rezervacija.getCheckOut();
			
			
			System.out.println(dolazak);
			System.out.println(odlazak);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(pocetakRezervacije);
			System.out.println(krajRezervacije);

			if((dolazak.isBefore(pocetakRezervacije)&& odlazak.isBefore(pocetakRezervacije)) || (dolazak.isAfter(krajRezervacije)&& odlazak.isAfter(krajRezervacije))) {
				return true;
				
			}
			
		}
			
		}
		return false;
	}
	
	public static Apartmani vratiApartmanNaseRez(LocalDate dolazak, LocalDate odlazak, String TipApartmana) {
		for(Rezervacije rezervacija:rezervacije) {

			
			//kada je sifra apartmana ista sa sifrom u rezervacijama, tj. vec postoji
			//obradi slucaj kada sifra apartmana uopste ne postoji u rezervacijama, tj. not in rezervacije, ne moze ! jer vraca sve one posotojece koje nisu ta!!!!
			if(TipApartmana.equals(rezervacija.getApartman().getTipApartmana())) {
				
			LocalDate pocetakRezervacije=rezervacija.getCheckIn();
			LocalDate krajRezervacije=rezervacija.getCheckOut();

			if((dolazak.isBefore(pocetakRezervacije)&& odlazak.isBefore(pocetakRezervacije)) || (dolazak.isAfter(krajRezervacije)&& odlazak.isAfter(krajRezervacije))) {
				return rezervacija.getApartman();
			}
			
		}
			
		}
		return null;
	}

			

	
	
	public static boolean proveriDaLiJeRezervacijaUOpseguRezervisanih(LocalDate dolazak, LocalDate odlazak, String TipApartmana) {
		
		for(Rezervacije rezervacija:rezervacije) {

			
			//kada je sifra apartmana ista sa sifrom u rezervacijama, tj. vec postoji
			//obradi slucaj kada sifra apartmana uopste ne postoji u rezervacijama, tj. not in rezervacije, ne moze ! jer vraca sve one posotojece koje nisu ta!!!!
			if(TipApartmana.equals(rezervacija.getApartman().getTipApartmana())) {
				
			LocalDate pocetakRezervacije=rezervacija.getCheckIn();
			LocalDate krajRezervacije=rezervacija.getCheckOut();
			
				if(!((dolazak.isBefore(pocetakRezervacije)&& odlazak.isBefore(pocetakRezervacije)) || (dolazak.isAfter(krajRezervacije)&& odlazak.isAfter(krajRezervacije)))) {
					return true;
					
			}
			
		}
			
		}
		return false;
	}
	
	//opseg i statusi
	public static boolean proveriRezervacije(LocalDate dolazak, LocalDate odlazak, String TipApartmana) {
		
		for(Rezervacije rezervacija:rezervacije) {

			if(TipApartmana.equals(rezervacija.getApartman().getTipApartmana())) {
				
			LocalDate pocetakRezervacije=rezervacija.getCheckIn();
			LocalDate krajRezervacije=rezervacija.getCheckOut();
			
				if(!((dolazak.isBefore(pocetakRezervacije)&& odlazak.isBefore(pocetakRezervacije)) || (dolazak.isAfter(krajRezervacije)&& odlazak.isAfter(krajRezervacije)))) {
					if(rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
					return true;
					}
					
			}
			
		}
			
		}
		return false;
	}
	
	
	
	
	
	public static boolean proveriDatumskiRezervacije(Rezervacije rezervacija){
		LocalDate dolazak=rezervacija.getCheckIn();
		LocalDate odlazak=rezervacija.getCheckOut();
		for (Rezervacije rezervacija1:rezervacije){

			if (!(rezervacija1.equals(rezervacija))){

		if (RezGlaseNaIstiApartman(rezervacija)){
			if (StatusiRezKriticni(rezervacija)){
				System.out.println("----------------------------------------------------------");
				if (!(dolazak.isBefore(rezervacija1.getCheckIn()) && odlazak.isBefore(rezervacija1.getCheckIn()) || (dolazak.isAfter(rezervacija1.getCheckOut()) && dolazak.isAfter(rezervacija1.getCheckOut())))){
					return false;
				}
			}
		}}
	}
		return true;
	}

	public static boolean StatusiRezKriticni(Rezervacije rezervacija){
		StatusRezervacije nasStatus=rezervacija.getStatus();
		for (Rezervacije rezervacija1:rezervacije){ 
			if (!(rezervacija1.equals(rezervacija))){
				if(RezGlaseNaIstiApartman(rezervacija)){
			if(rezervacija1.getStatus().equals(StatusRezervacije.POTVRDJENA) && nasStatus.equals(StatusRezervacije.NA_CEKANJU)){
				//System.out.println("kriticni");
				return true;
				
			}
		}}}
		return false;
	}
	
	public static Rezervacije nadjiRezervacije(String sifraRezervacije) {
		
		for (Rezervacije rezervacija:rezervacije) {
			if(rezervacija.getSifraRezervacije().equals(sifraRezervacije)) {
				return rezervacija;
			}
		}
		return null;
	}

	
//------------------------------------------------------------------- ID GENERATORI ----------------------------------------------------------------
	public static String IDGeneratorRezervacije() {
		int velicina=getRezervacije().size();
		int sifra=velicina+1;
		String sifraRez=Integer.toString(sifra);
		return sifraRez;
		
	}
	
	public static String IDGeneratorApartmani() {
		int velicina=getApartmani().size();
		int sifra=velicina*10+10;
		String sifraRez=Integer.toString(sifra);
		return sifraRez;
		
	}
	
	
	public static int nadjiNasBrojOciscenihSoba(Zaposleni sobarica) {
		for (Zaposleni zaposlen:zaposleni) {
			if (zaposlen.equals(sobarica)) {
				int BrSoba=sobarica.getBrOciscenihSoba();
				return BrSoba;
			}
		}
		return 0;
	}
	
	
	public static int[] convertIntegers(List<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}

	
	
	
//nadji najmanji broj ociscenih soba medju sobaricama
	public static int minOciscenihSoba() {
		
		ArrayList<Integer> BrojeviOciscenihSoba = new ArrayList<Integer>();
		
		for (Zaposleni zaposlen:zaposleni) {
			if (zaposlen.getUloga().equals(Uloga.SOBARICA)){
				int Broj=zaposlen.getBrOciscenihSoba();
				BrojeviOciscenihSoba.add(Broj);
				//System.out.println(Broj);
			}
		}
		int min=Collections.min(BrojeviOciscenihSoba);
		return min;
	}
	
	
//vrati nam sobaricu sa najmanje soba
	public static Zaposleni pronadjiSobaricuKojaCisti() {
		for (Zaposleni zaposlen:zaposleni) {
			if(zaposlen.getUloga().equals(Uloga.SOBARICA)) {
				if(zaposlen.getBrOciscenihSoba()<=minOciscenihSoba()) {
					return zaposlen;
				}
			}
		}
		return null;
	}
	
	public static ArrayList<Zaposleni> VratiListuSobarica() {
		ArrayList<Zaposleni> zaposleni = getZaposleni();
		ArrayList<Zaposleni> sobarice = new ArrayList<Zaposleni>();
		 for(Zaposleni zaposlen:zaposleni) {
			 if(zaposlen.getUloga().equals(Uloga.SOBARICA)) {
				 sobarice.add(zaposlen);
			 }
		 }
		 return sobarice;
		
	}

	
	
	//==================================IZVESTAJ ODBIJENE I OTKAZANE REZERVACIJE =============================================
	
	
	//admin ce uneti dane za koje ga interesuje da se gleda opseg, ovde su status handleri, val. datuma radi u samoj funkciji
	
	public static int nadjiBrojZeljenogStatusaRezervacija(StatusRezervacije status) {
		int brojac=0;
		for (Rezervacije rezervacija:rezervacije) {
			if(rezervacija.getStatus().equals(status)) {
				brojac++;
			}
		}
		return brojac;
	}
	
	public static int mesecDanaBrojRez(StatusRezervacije status) {
		int broj=0;
		LocalDate danasnjiDatum=java.time.LocalDate.now(); 
		LocalDate donjaGranica=danasnjiDatum.minusDays(30);
		for (Rezervacije rezervacija:AplikacijaUtilities.getRezervacije()) {
			if(rezervacija.getStatus().equals(status)) {
				if(rezervacija.getCheckIn().isAfter(donjaGranica) && rezervacija.getCheckOut().isBefore(danasnjiDatum)) {
					broj+=1;
				}
			}
		}
		return broj;
	}
	
	public static int brojOciscenihSobaZaposlenog(String korisnickoIme) {
		int broj=0;
		LocalDate sada=LocalDate.now();
		LocalDate preMesecDanaDate=sada.minusDays(30);
		for(OcisceneSobeDatumi spremacice:ocisceneSobe) {
			if(korisnickoIme.equals(spremacice.getkIme())) {
				LocalDate datumCiscenja=LocalDate.parse(spremacice.getDatumCiscenja());
				if(datumCiscenja.isAfter(preMesecDanaDate) && datumCiscenja.isBefore(sada)) {
				broj++;
				}
			}
		}
		return broj;}
	
	public static HashMap<String, Integer> prikazBrojaRezervacijaZeljenogTipa(){
		HashMap<String, Integer> hesMapa = new HashMap<String, Integer>();
		
		
		int RezNaCekanju=mesecDanaBrojRez(StatusRezervacije.NA_CEKANJU);
		int PotvrdjeneRez=mesecDanaBrojRez(StatusRezervacije.POTVRDJENA);
		int OdbijeneRez=mesecDanaBrojRez(StatusRezervacije.ODBIJENA);
		int OtkazaneRez=mesecDanaBrojRez(StatusRezervacije.OTKAZANA);
		hesMapa.put("POTVRDJENA",PotvrdjeneRez);
		hesMapa.put("OTKAZANA",OtkazaneRez);
		hesMapa.put("ODBIJENA",OdbijeneRez);
		hesMapa.put("NA CEKANJU",RezNaCekanju);
		return hesMapa;
	}
	
	public static int datumRezervacijeOpsegAdmina(LocalDate odPeriod, LocalDate doPeriod, StatusRezervacije status) {
		for (Rezervacije rezervacija:rezervacije) {
			if(rezervacija.getStatus().equals(status)) {
			if(odPeriod.isBefore(rezervacija.getCheckIn())&&doPeriod.isAfter(rezervacija.getCheckOut())) {
				int broj=nadjiBrojZeljenogStatusaRezervacija(status);
				return broj;
			}
		}
	}
		return 0;
	}
	//--------------------------------------------------- REZERVACIJE LINE-CHART ----------------------------------------------------------------------
	
//	public static List<Date> VratiDatume(){
//		 List<Date> allDates = new ArrayList<Date>();
//	
//	String maxDate = "Jan-2016";
//	SimpleDateFormat monthDate = new SimpleDateFormat("M");
//	
////	Calendar cal = Calendar.getInstance();
////	//cal.setTime(monthDate.parse(maxDate));
////	for (int i = 1; i <= 12; i++) {
////	    SimpleDateFormat month_name1 = monthDate;
////	    allDates.add(month_name1);
////	    cal.add(Calendar.MONTH, -1);
////	}
//	
//	Month danas=LocalDate.now().getMonth();
//	for(int m=0;m<12;m++) {
//		Month predjasnji=danas.minus(m);
//		System.out.println(predjasnji);
//		allDates.add(predjasnji);
//	}
//	System.out.println(allDates);
//	return allDates;
//	}
	
	
	public static double prihodTipSobe(Month month, String tipSobe) {
		double ukupanPrihodzaMesec=0;
		for (Rezervacije rezervacija:rezervacije) {
			if(rezervacija.getStatus().equals(StatusRezervacije.OTKAZANA) || rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
				if(rezervacija.getCheckOut().isBefore(LocalDate.now())) {
				if(rezervacija.getCheckIn().getMonth().equals(month) && rezervacija.getCheckOut().getMonth().equals(month)) {
					if(rezervacija.getApartman().getTipApartmana().equals(tipSobe)) {
					ukupanPrihodzaMesec+=rezervacija.getUkupnaCenaRezervacije();}
					
				}
			}}
		}
		return ukupanPrihodzaMesec;
		
	}
	
	public static double prihodUkupno(Month month){
		double ukupanPrihodzaMesec=0;
		for (Rezervacije rezervacija:rezervacije) {
			if(rezervacija.getStatus().equals(StatusRezervacije.OTKAZANA) || rezervacija.getStatus().equals(StatusRezervacije.POTVRDJENA)) {
				if(rezervacija.getCheckOut().isBefore(LocalDate.now())) {
				if(rezervacija.getCheckIn().getMonth().equals(month) && rezervacija.getCheckOut().getMonth().equals(month)) {
					ukupanPrihodzaMesec+=rezervacija.getUkupnaCenaRezervacije();
					
				}
			}}
		}
		return ukupanPrihodzaMesec;
	}
	
	public static double prihodOdRezervacijaZaZeljeniMesec(Month month) {
		return 0;
		
	}
	
	
	
	//------------------------------------------------------ CUVANJE PODATAKA ------------------------------------------------------------------
	
	public static void sacuvajZaposlene() {
		try {
			File zaposleniFajl = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//zaposleni.txt/");
			String content = "";
			//System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			for(Zaposleni zaposlen:zaposleni) {
				content += zaposlen.getIme() + "|" + zaposlen.getPrezime() + "|"  + zaposlen.getPol() + "|" + zaposlen.getDatumRodjenja() + "|" +
						zaposlen.getbrojTelefona()+"|" + zaposlen.getAdresa() + "|" + zaposlen.getkorisnickoIme()+ "|" + zaposlen.getLozinka() + "|" + zaposlen.getUloga() + "|" +zaposlen.getStaz() + "|" + zaposlen.getSprema() +"|"+zaposlen.getBrOciscenihSoba()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(zaposleniFajl));
			writer.write(content);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Greska prilikom upisa u fajla", "Greska", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void sacuvajApartmane() {
		try {
			File apartmaniFajl = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//apartmani.txt/");
			String content = "";
			for(Apartmani apartman:apartmani) {
			String sadrzaj=sacuvajListuBezZagrada(apartman.getDodatniSadrzaj());

				
				content += apartman.getSifraApartmana() + "|" + apartman.getTipApartmana() + "|"  + apartman.getStatusApartmana() + "|" + apartman.getSobarica().getkorisnickoIme() +"|"+sadrzaj+"\n";
				
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(apartmaniFajl));
			writer.write(content);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Greska prilikom upisa u fajla", "Greska", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void sacuvajGoste() {
		try {
			File gostFajl = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//gosti.txt/");
			String content = "";
			for(Gost gost1:gosti) {
				content += gost1.getIme() + "|" + gost1.getPrezime() + "|"  + gost1.getPol() + "|" + gost1.getDatumRodjenja() + "|" +
						gost1.getbrojTelefona()+"|" + gost1.getAdresa() + "|" + gost1.getkorisnickoIme()+ "|" + gost1.getLozinka() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(gostFajl));
			writer.write(content);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Greska prilikom upisa u fajla", "Greska", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void sacuvajRezervacije() {
		try {
			File rezervacijaFajl = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//rezervacije.txt/");
			String content = "";
			for(Rezervacije rezervacija:rezervacije) {
//				System.out.println(rezervacija.getSifraRezervacije());
//				System.out.println(rezervacija.getGost().getkorisnickoIme());
//				System.out.println(rezervacija.getApartman().getSifraApartmana());
//				System.out.println(rezervacija.getCheckIn());
//				System.out.println(rezervacija.getCheckOut());
//				System.out.println(rezervacija.getStatus());
//				System.out.println(rezervacija.isDosao());
//				System.out.println(rezervacija.isOtisao());
//				System.out.println(rezervacija.getUkupnaCenaRezervacije());
				content += rezervacija.getSifraRezervacije() + "|" + rezervacija.getGost().getkorisnickoIme() + "|"  + rezervacija.getApartman().getSifraApartmana() + "|" + rezervacija.getCheckIn() + "|" +
						rezervacija.getCheckOut()+"|" + rezervacija.getStatus() +"|"+ rezervacija.isDosao()+"|"+rezervacija.isOtisao()+"|"+rezervacija.getUkupnaCenaRezervacije()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(rezervacijaFajl));
			writer.write(content);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Greska prilikom upisa u fajla", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		

	}
	
	
	public static String sacuvajListuBezZagrada(List<String> niz) {
		String listAsStr = niz.toString(); // get list as string
		listAsStr = listAsStr.substring(1,listAsStr.length()-1);
		return listAsStr;
		//System.out.println(listAsStr);
	}

	public static void sacuvajCenovnik() {
		// TODO Auto-generated method stub
		try {
			File rezervacijaFajl = new File("C://Users//User//eclipse-workspace//Projekat-Hotelski servis//src//Database//cenovnik.txt/");
			String content = "";
			for(Cenovnik cenovnik:cenovnici) {
				content += cenovnik.getSifraCenovnika() + "|" + cenovnik.getCena() + "|"  + cenovnik.getPocetniDatumVazenja() + "|" + cenovnik.getKrajnjiDatumVazenja() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(rezervacijaFajl));
			writer.write(content);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Greska prilikom upisa u fajla", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		
	}


	

	

}