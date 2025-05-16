package bdbt_bada_project.OSKApplication.Database.Adresy;

public class Adres {


    private int id_adresu;

    private String miasto;

    private String ulica;
    private String nr_domu;
    private int id_poczty;

    public Adres() {

    }

    public int getId_adresu() {
        return id_adresu;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id_adresu=" + id_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_domu='" + nr_domu + '\'' +
                ", id_poczty=" + id_poczty +
                '}';
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

    public int getId_poczty() {
        return id_poczty;
    }

    public void setId_poczty(int id_poczty) {
        this.id_poczty = id_poczty;
    }

    public Adres(int id_adresu, String miasto, String ulica, String nr_domu, int id_poczty) {
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.id_poczty = id_poczty;
    }


}
