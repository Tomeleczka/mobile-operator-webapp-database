package bdbt_bada_project.OSKApplication.Database.Placowki;

public class Placowka {




    private int id_placowki;

    private String telefon;

    private String adres_email;
    private int id_operatora;

    private  int id_adresu;

    public Placowka() {
    }

    public int getId_placowki() {
        return id_placowki;
    }

    public Placowka(int id_placowki, String telefon, String adres_email, int id_operatora, int id_adresu) {
        this.id_placowki = id_placowki;
        this.telefon = telefon;
        this.adres_email = adres_email;
        this.id_operatora = id_operatora;
        this.id_adresu = id_adresu;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getAdres_email() {
        return adres_email;
    }

    public int getId_operatora() {
        return id_operatora;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_placowki(int id_placowki) {
        this.id_placowki = id_placowki;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setAdres_email(String adres_email) {
        this.adres_email = adres_email;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Placowka{" +
                "id_placowki=" + id_placowki +
                ", telefon='" + telefon + '\'' +
                ", adres_email='" + adres_email + '\'' +
                ", id_operatora=" + id_operatora +
                ", id_adresu=" + id_adresu +
                '}';
    }
}