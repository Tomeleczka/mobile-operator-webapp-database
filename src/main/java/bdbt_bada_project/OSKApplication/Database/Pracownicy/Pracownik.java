package bdbt_bada_project.OSKApplication.Database.Pracownicy;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private String numer_telefonu;
    private String numer_konta;
    private String adres_email;
    private int id_operatora;
    private int id_placowki;
    private int id_adresu;
    private int id_stanowiska;

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", plec='" + plec + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", numer_konta='" + numer_konta + '\'' +
                ", adres_email='" + adres_email + '\'' +
                ", id_operatora=" + id_operatora +
                ", id_placowki=" + id_placowki +
                ", id_adresu=" + id_adresu +
                ", id_stanowiska=" + id_stanowiska +
                '}';
    }

    public Pracownik(int id_pracownika, String imie, String nazwisko, String pesel, String plec, String numer_telefonu, String numer_konta, String adres_email,  int id_operatora, int id_placowki, int id_adresu, int id_stanowiska) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;
        this.numer_telefonu = numer_telefonu;
        this.numer_konta = numer_konta;
        this.adres_email = adres_email;
        this.id_operatora = id_operatora;
        this.id_placowki = id_placowki;
        this.id_adresu = id_adresu;
        this.id_stanowiska = id_stanowiska;
    }


    public Pracownik() {
    }



    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getNumer_konta() {
        return numer_konta;
    }

    public void setNumer_konta(String numer_konta) {
        this.numer_konta = numer_konta;
    }

    public String getAdres_email() {
        return adres_email;
    }

    public void setAdres_email(String adres_email) {
        this.adres_email = adres_email;
    }

    public int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public int getId_placowki() {
        return id_placowki;
    }

    public void setId_placowki(int id_placowki) {
        this.id_placowki = id_placowki;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

}
