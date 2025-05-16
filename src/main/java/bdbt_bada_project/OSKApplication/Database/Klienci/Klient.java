package bdbt_bada_project.OSKApplication.Database.Klienci;

public class Klient {
    private int id_klienta;

    private String imie;

    private String nazwisko;
    private String pesel;
    private String numer_telefonu;
    private int id_operatora;
    private int id_adresu;

    public Klient() {
    }

    public Klient(int id_klienta, String imie, String nazwisko, String pesel, String numer_telefonu, int id_operatora, int id_adresu) {
        this.id_klienta = id_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.numer_telefonu = numer_telefonu;
        this.id_operatora = id_operatora;
        this.id_adresu = id_adresu;
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

    public int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "id_klienta=" + id_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", id_operatora=" + id_operatora +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
