package bdbt_bada_project.OSKApplication.Database.Uzytkownicy;

public class Uzytkownik {


    private int id_uzytkownika;

    private String login;

    private String haslo;

    public Uzytkownik(int id_uzytkownika, String login, String haslo) {
        this.id_uzytkownika = id_uzytkownika;
        this.login = login;
        this.haslo = haslo;
    }

    public Uzytkownik() {
    }

    public int getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(int id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }


    @Override
    public String toString() {
        return "Uzytkownik{" +
                "id_uzytkownika=" + id_uzytkownika +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }
}