package bdbt_bada_project.OSKApplication.Database.Poczty;

public class Poczta {


    private int id_poczty;

    private String kod_poczty;

    private String poczta;
    public Poczta() {
        // You can initialize default values here if needed
    }

    public Poczta(int id_poczty, String kod_poczty, String poczta) {
        this.id_poczty = id_poczty;
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }

    public int getId_poczty() {
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

    @Override
    public String toString() {
        return "Poczta{" +
                "id_poczty=" + id_poczty +
                ", kod_poczty='" + kod_poczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }
}
