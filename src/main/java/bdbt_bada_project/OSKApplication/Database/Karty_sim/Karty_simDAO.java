package bdbt_bada_project.OSKApplication.Database.Karty_sim;

import bdbt_bada_project.OSKApplication.Database.Adresy.Adres;
import bdbt_bada_project.OSKApplication.Database.Umowy.Umowa;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public class Karty_simDAO {

    private final JdbcTemplate jdbcTemplate;

    public Karty_simDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Karta_sim> list() {
        String sql = "SELECT * FROM KARTY_SIM"; // Adjust the SQL query based on your database schema
        List<Karta_sim> listKartaSim = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Karta_sim.class));
        listKartaSim.forEach(p -> System.out.println(p.toString()));
        return listKartaSim;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        String sql = "SELECT COUNT(*) FROM KARTY_SIM WHERE numer_telefonu = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, phoneNumber);
        return count > 0;
    }
    public void save(Karta_sim kartaSim) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KARTY_SIM").usingColumns("numer_telefonu", "rodzaj", "rozmiar", "id_umowy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kartaSim);
        insertActor.execute(param);
    }

    public Karta_sim get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM KARTY_SIM WHERE id_karty_sim = " + args[0];
        Karta_sim karta_sim = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Karta_sim.class));
        return karta_sim;
    }

    public void update(Karta_sim karta_sim) {
        String sql = "UPDATE KARTY_SIM SET numer_telefonu=:numer_telefonu, rodzaj=:rodzaj, rozmiar=:rozmiar, id_umowy=:id_umowy WHERE id_karty_sim=:id_karty_sim";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(karta_sim);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id_karty_sim) {
        String sql = "DELETE FROM KARTY_SIM WHERE id_karty_sim = ?";
        jdbcTemplate.update(sql, id_karty_sim);
    }



}
