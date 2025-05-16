package bdbt_bada_project.OSKApplication.Database.Stanowiska;

import bdbt_bada_project.OSKApplication.Database.Pracownicy.Pracownik;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.List;
@Repository
public class StanowiskaDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public StanowiskaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Stanowisko> list() {
        String sql = "SELECT * FROM Stanowiska";
        List<Stanowisko> listStanowisko = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Stanowisko.class));
        listStanowisko.forEach(p -> System.out.println(p.toString()));
        return listStanowisko;
    }
    public Stanowisko get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM STANOWISKA WHERE id_stanowiska = " + args[0];
        Stanowisko stanowisko = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Stanowisko.class));
        return stanowisko;
    }

    public void update(Stanowisko stanowisko) {
        String sql = "UPDATE STANOWISKA SET nazwa=:nazwa, opis=:opis WHERE id_stanowiska=:id_stanowiska";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stanowisko);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

}
