package bdbt_bada_project.OSKApplication.Database.Konto_dane;

public class Konto_dane {

	private int id_adresu;

	private String numer_telefonu;

	private String imie;
	private String nazwisko;
	private String miasto;
	private String ulica;
	private String nr_domu;
	private String kod_poczty;

	public Konto_dane() {
	}

	public int getId_adresu() {
		return id_adresu;
	}

	public String getNumer_telefonu() {
		return numer_telefonu;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public String getMiasto() {
		return miasto;
	}

	public String getUlica() {
		return ulica;
	}

	public String getNr_domu() {
		return nr_domu;
	}

//	public String getKod_poczty() {
//		return kod_poczty;
//	}

	public void setId_adresu(int id_adresu) {
		this.id_adresu = id_adresu;
	}

	public void setNumer_telefonu(String numer_telefonu) {
		this.numer_telefonu = numer_telefonu;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public void setNr_domu(String nr_domu) {
		this.nr_domu = nr_domu;
	}

//	public void setKod_poczty(String kod_poczty) {
//		this.kod_poczty = kod_poczty;
//	}

	public Konto_dane(int id_adresu, String numer_telefonu, String imie, String nazwisko, String miasto, String ulica,
			String nr_domu) {
		this.id_adresu = id_adresu;
		this.numer_telefonu = numer_telefonu;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miasto = miasto;
		this.ulica = ulica;
		this.nr_domu = nr_domu;
		//this.kod_poczty = kod_poczty;
	}


}
