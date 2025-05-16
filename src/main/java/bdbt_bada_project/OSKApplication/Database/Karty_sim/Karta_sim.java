
package bdbt_bada_project.OSKApplication.Database.Karty_sim;

public class Karta_sim {
    private int id_karty_sim;

    private String numer_telefonu;

    private String rodzaj;
    private String rozmiar;
    private int id_umowy;

    public Karta_sim() {
    }

    public Karta_sim(int id_karty_sim, String numer_telefonu, String rodzaj, String rozmiar, int id_umowy) {
        this.id_karty_sim = id_karty_sim;
        this.numer_telefonu = numer_telefonu;
        this.rodzaj = rodzaj;
        this.rozmiar = rozmiar;
        this.id_umowy = id_umowy;
    }

    public int getId_karty_sim() {
        return id_karty_sim;
    }

    public void setId_karty_sim(int id_karty_sim) {
        this.id_karty_sim = id_karty_sim;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public int getId_umowy() {
        return id_umowy;
    }

    public void setId_umowy(int id_umowy) {
        this.id_umowy = id_umowy;
    }

    @Override
    public String toString() {
        return "Karta_sim{" +
                "id_karty_sim=" + id_karty_sim +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", rodzaj='" + rodzaj + '\'' +
                ", rozmir='" + rozmiar + '\'' +
                ", id_umowy=" + id_umowy +
                '}';
    }
}

