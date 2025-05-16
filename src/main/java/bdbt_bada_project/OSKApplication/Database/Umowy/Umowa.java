package bdbt_bada_project.OSKApplication.Database.Umowy;

public class Umowa {
    private int id_umowy;
    private String data_podpisania;
    private int id_pracownika;
    private int id_klienta;
    private long id_oferty;
    private int id_placowki;

    public int getId_umowy() {
        return id_umowy;
    }

    public void setId_umowy(int id_umowy) {
        this.id_umowy = id_umowy;
    }

    @Override
    public String toString() {
        return "Umowa{" +
                "id_umowy=" + id_umowy +
                ", data_podpisania='" + data_podpisania + '\'' +
                ", id_pracownika=" + id_pracownika +
                ", id_klienta=" + id_klienta +
                ", id_oferty=" + id_oferty +
                ", id_placowki=" + id_placowki +
                '}';
    }

    public Umowa(int id_umowy, String data_podpisania, int id_pracownika, int id_klienta, long id_oferty, int id_placowki) {
        this.id_umowy = id_umowy;
        this.data_podpisania = data_podpisania;
        this.id_pracownika = id_pracownika;
        this.id_klienta = id_klienta;
        this.id_oferty = id_oferty;
        this.id_placowki = id_placowki;
    }

    public Umowa() {
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

    public Long getId_oferty() {
        return id_oferty;
    }

    public void setId_oferty(Long id_oferty) {
        this.id_oferty = id_oferty;
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


}
