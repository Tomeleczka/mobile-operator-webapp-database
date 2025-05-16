package bdbt_bada_project.OSKApplication.Database.Pracownicy;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list() {
        String sql = "SELECT * FROM Pracownicy";
        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        listPracownik.forEach(p -> System.out.println(p.toString()));
        return listPracownik;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PRACOWNICY").usingColumns("imie", "nazwisko", "pesel", "plec", "numer_telefonu", "numer_konta", "adres_email", "id_operatora", "id_placowki", "id_adresu", "id_stanowiska");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    public Pracownik get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY WHERE id_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }

    public void update(Pracownik pracownik) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, pesel=:pesel, plec=:plec, numer_telefonu=:numer_telefonu, numer_konta=:numer_konta, adres_email=:adres_email, id_operatora=:id_operatora, id_placowki=:id_placowki, id_adresu=:id_adresu, id_stanowiska=:id_stanowiska WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ?";
        jdbcTemplate.update(sql, id_pracownika);
    }

    public List<Pracownik> listPracownikKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Pracownicy JOIN Umowy ON Pracownicy.id_pracownika = Umowy.id_pracownika JOIN Klienci ON Umowy.id_klienta = Klienci.id_klienta WHERE KLIENCI.NUMER_TELEFONU  = ?";
        List<Pracownik> listPracownikKonto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class), numer_telefonu);
        listPracownikKonto.forEach(p -> System.out.println(p.toString()));
        return listPracownikKonto;
    }

}
