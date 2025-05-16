package bdbt_bada_project.OSKApplication.Database.Konto_umowy;

public class Konto_umowy {
    private int id_umowy;
    private String data_podpisania;
    private int id_pracownika;
    private int id_klienta;
    private int id_oferty;
    private int id_placowki;
    private String telefon;
    private String adres_email;
    private int id_operatora;
    private int id_adresu;
    private String nazwa;
    private String okres;
    private String cena;
    private int id_planu;
    private String specjalna;

    public Konto_umowy() {
    }

    public Konto_umowy(int id_umowy, String data_podpisania, int id_pracownika, int id_klienta, int id_oferty, int id_placowki, String telefon, String adres_email, int id_operatora, int id_adresu, String nazwa, String okres, String cena, int id_planu, String specjalna) {
        this.id_umowy = id_umowy;
        this.data_podpisania = data_podpisania;
        this.id_pracownika = id_pracownika;
        this.id_klienta = id_klienta;
        this.id_oferty = id_oferty;
        this.id_placowki = id_placowki;
        this.telefon = telefon;
        this.adres_email = adres_email;
        this.id_operatora = id_operatora;
        this.id_adresu = id_adresu;
        this.nazwa = nazwa;
        this.okres = okres;
        this.cena = cena;
        this.id_planu = id_planu;
        this.specjalna = specjalna;
    }

    public int getId_umowy() {
        return id_umowy;
    }

    public void setId_umowy(int id_umowy) {
        this.id_umowy = id_umowy;
    }

    public String getData_podpisania() {
        return data_podpisania;
    }

    public void setData_podpisania(String data_podpisania) {
        this.data_podpisania = data_podpisania;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public int getId_oferty() {
        return id_oferty;
    }

    public void setId_oferty(int id_oferty) {
        this.id_oferty = id_oferty;
    }

    public int getId_placowki() {
        return id_placowki;
    }

    public void setId_placowki(int id_placowki) {
        this.id_placowki = id_placowki;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOkres() {
        return okres;
    }

    public void setOkres(String okres) {
        this.okres = okres;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public int getId_planu() {
        return id_planu;
    }

    public void setId_planu(int id_planu) {
        this.id_planu = id_planu;
    }

    public String getSpecjalna() {
        return specjalna;
    }

    public void setSpecjalna(String specjalna) {
        this.specjalna = specjalna;
    }

    @Override
    public String toString() {
        return "Konto_umowy{" +
                "id_umowy=" + id_umowy +
                ", data_podpisania='" + data_podpisania + '\'' +
                ", id_pracownika=" + id_pracownika +
                ", id_klienta=" + id_klienta +
                ", id_oferty=" + id_oferty +
                ", id_placowki=" + id_placowki +
                ", telefon='" + telefon + '\'' +
                ", adres_email='" + adres_email + '\'' +
                ", id_operatora=" + id_operatora +
                ", id_adresu=" + id_adresu +
                ", nazwa='" + nazwa + '\'' +
                ", okres='" + okres + '\'' +
                ", cena='" + cena + '\'' +
                ", id_planu=" + id_planu +
                ", specjalna='" + specjalna + '\'' +
                '}';
    }
}
