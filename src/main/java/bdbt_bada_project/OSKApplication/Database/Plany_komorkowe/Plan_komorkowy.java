package bdbt_bada_project.OSKApplication.Database.Plany_komorkowe;

public class Plan_komorkowy {


    private int id_planu;

    private String limit_internetu;

    private String limit_internetu_eu;
    private String limit_SMS;

    private String limit_MMS;
    private String roaming;

    public Plan_komorkowy() {
    }

    public Plan_komorkowy(int id_planu, String limit_internetu, String limit_internetu_eu, String limit_SMS,
            String limit_MMS, String roaming) {
        this.id_planu = id_planu;
        this.limit_internetu = limit_internetu;
        this.limit_internetu_eu = limit_internetu_eu;
        this.limit_SMS = limit_SMS;
        this.limit_MMS = limit_MMS;
        this.roaming = roaming;
    }

    public int getId_planu() {
        return id_planu;
    }

    public void setId_planu(int id_planu) {
        this.id_planu = id_planu;
    }

    public String getLimit_internetu() {
        return limit_internetu;
    }

    public void setLimit_internetu(String limit_internetu) {
        this.limit_internetu = limit_internetu;
    }

    public String getLimit_internetu_eu() {
        return limit_internetu_eu;
    }

    public void setLimit_internetu_eu(String limit_internetu_eu) {
        this.limit_internetu_eu = limit_internetu_eu;
    }

    public String getLimit_SMS() {
        return limit_SMS;
    }

    public void setLimit_SMS(String limit_SMS) {
        this.limit_SMS = limit_SMS;
    }

    public String getLimit_MMS() {
        return limit_MMS;
    }

    public void setLimit_MMS(String limit_MMS) {
        this.limit_MMS = limit_MMS;
    }

    public String getRoaming() {
        return roaming;
    }

    public void setRoaming(String roaming) {
        this.roaming = roaming;
    }

    @Override
    public String toString() {
        return "Plan_komorkowy{" +
                "id_planu=" + id_planu +
                ", limit_internetu='" + limit_internetu + '\'' +
                ", limit_internetu_eu='" + limit_internetu_eu + '\'' +
                ", limit_SMS='" + limit_SMS + '\'' +
                ", limit_MMS='" + limit_MMS + '\'' +
                ", roaming='" + roaming + '\'' +
                '}';
    }
}
