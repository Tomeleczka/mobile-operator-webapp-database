package bdbt_bada_project.OSKApplication.Database.Uzytkownicy;

import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import bdbt_bada_project.OSKApplication.Database.Umowy.Umowa;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UzytkownicyDAO {

    private final JdbcTemplate jdbcTemplate;
    private final List<Object> userData;

    public UzytkownicyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userData = new ArrayList<>();
    }

    public List<Uzytkownik> list() {
        String sql = "SELECT login, haslo FROM UZYTKOWNICY";
        List<Uzytkownik> listUzytkownikSecurity = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Uzytkownik.class));
        listUzytkownikSecurity.forEach(p -> System.out.println(p.toString()));
        return listUzytkownikSecurity;
    }

    /*public void save() {
        if (userData.size() == 4) { // Ensure all parameters are set
            Uzytkownik uzytkownik = new Uzytkownik();
            uzytkownik.setId_uzytkownika(0);
            uzytkownik.setLogin((String) userData.get(0));
            uzytkownik.setHaslo((String) userData.get(1));
            uzytkownik.setId_karty_sim((int) userData.get(2));
            uzytkownik.setId_klienta((int) userData.get(3));

            SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
            insertActor.withTableName("UZYTKOWNICY").usingColumns("login", "haslo", "id_karty_sim", "id_klienta");

            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uzytkownik);
            insertActor.execute(param);

            // Clear the userData list after saving
            userData.clear();
        } else {
            // Handle incomplete userData
            System.err.println("Incomplete userData. Cannot save.");
        }
    }*/

    public void save(Uzytkownik uzytkownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("UZYTKOWNICY").usingColumns("login", "haslo");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uzytkownik);
        insertActor.execute(param);
    }

    public void setLogin(String login) {
        System.out.println(login);
        userData.add(login);
    }

    public void setHaslo(String haslo) {
        System.out.println(haslo);
        userData.add(haslo);
    }

    public void setIdKartySim(int id_karty_sim) {
        System.out.println(id_karty_sim);
        userData.add(id_karty_sim);
    }

    public void setIdKlienta(int id_klienta) {
        System.out.println(id_klienta);
        userData.add(id_klienta);
    }

    public Uzytkownik get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM UZYTKOWNICY WHERE id_uzytkownika = " + args[0];
        Uzytkownik uzytkownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Uzytkownik.class));
        return uzytkownik;
    }

    public void update(Uzytkownik uzytkownik) {
        String sql = "UPDATE UZYTKOWNICY SET login=:login, haslo=:haslo WHERE id_uzytkownika=:id_uzytkownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uzytkownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
}
