package bdbt_bada_project.OSKApplication.Database.Konto_dane2;

public class Konto_dane2 {

    private int id_klienta;

    private String imie;
    private String nazwisko;
    private String pesel;
    private String numer_telefonu;

    private static int id_operatora;

    private static int id_adresu;

    private String miasto;
    private String ulica;
    private String nr_domu;

    private static int id_poczty;
    private String kod_poczty;

    private String poczta;

    public Konto_dane2() {
    }

    public Konto_dane2(int id_klienta, String imie, String nazwisko, String pesel, String numer_telefonu, int id_operatora, int id_adresu, String miasto, String ulica, String nr_domu, int id_poczty, String kod_poczty, String poczta) {
        this.id_klienta = id_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.numer_telefonu = numer_telefonu;
        this.id_operatora = id_operatora;
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.id_poczty = id_poczty;
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public static int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public static int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public static int getId_poczty() {
        return id_poczty;
    }

    public void setId_poczty(int id_poczty) {
        this.id_poczty = id_poczty;
    }

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Konto_dane2{" +
                "id_klienta=" + id_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", id_operatora=" + id_operatora +
                ", id_adresu=" + id_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_domu='" + nr_domu + '\'' +
                ", id_poczty=" + id_poczty +
                ", kod_poczty='" + kod_poczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}
