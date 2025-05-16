package bdbt_bada_project.OSKApplication.Database.Stanowiska;

public class Stanowisko {
    private int id_stanowiska;
    private String nazwa;
    private String opis;

    public Stanowisko() {
    }

    public Stanowisko(int id_stanowiska, String nazwa, String opis) {
        this.id_stanowiska = id_stanowiska;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Stanowisko{" +
                "id_stanowiska=" + id_stanowiska +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
