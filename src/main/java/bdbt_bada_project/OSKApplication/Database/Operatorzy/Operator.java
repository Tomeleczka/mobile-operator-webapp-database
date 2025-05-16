package bdbt_bada_project.OSKApplication.Database.Operatorzy;

public class Operator {
    private int id_operatora;
    private String nazwa;
    private String data_zalozenia;
    private int id_adresu;

    public Operator() {
    }

    public Operator(int id_operatora, String nazwa, String data_zalozenia, int id_adresu) {
        this.id_operatora = id_operatora;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.id_adresu = id_adresu;
    }

    public int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(String data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id_operatora=" + id_operatora +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia='" + data_zalozenia + '\'' +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
