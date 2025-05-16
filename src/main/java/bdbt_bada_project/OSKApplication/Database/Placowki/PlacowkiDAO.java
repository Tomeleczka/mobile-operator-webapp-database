package bdbt_bada_project.OSKApplication.Database.Placowki;

import bdbt_bada_project.OSKApplication.Database.Placowki.Placowka;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PlacowkiDAO {

    private final JdbcTemplate jdbcTemplate;
    public PlacowkiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Placowka> list() {
        String sql = "SELECT * FROM Placowki";
        List<Placowka> listPlacowka = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Placowka.class));
        listPlacowka.forEach(p -> System.out.println(p.toString()));
        return listPlacowka;
    }



}