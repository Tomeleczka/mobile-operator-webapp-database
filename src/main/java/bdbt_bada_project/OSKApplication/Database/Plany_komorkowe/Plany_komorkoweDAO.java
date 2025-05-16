package bdbt_bada_project.OSKApplication.Database.Plany_komorkowe;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Plany_komorkoweDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public Plany_komorkoweDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Plan_komorkowy> list() {
        String sql = "SELECT * FROM Plany_komorkowe";
        List<Plan_komorkowy> listPlanKomorkowy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Plan_komorkowy.class));
        listPlanKomorkowy.forEach(p -> System.out.println(p.toString()));
        return listPlanKomorkowy;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Plan_komorkowy planKomorkowy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PLANY_KOMORKOWE").usingColumns("limit_internetu","limit_internetu_eu", "limit_SMS", "limit_MMS", "roaming");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(planKomorkowy);
        insertActor.execute(param);
    }
    public Plan_komorkowy get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM PLANY_KOMORKOWE WHERE id_planu = " + args[0];
        Plan_komorkowy plan_komorkowy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Plan_komorkowy.class));
        return plan_komorkowy;
    }

    public void update(Plan_komorkowy plan_komorkowy) {
        String sql = "UPDATE PLANY_KOMORKOWE SET limit_internetu=:limit_internetu, limit_internetu_eu=:limit_internetu_eu, limit_SMS=:limit_SMS, limit_MMS=:limit_MMS, roaming=:roaming WHERE id_planu=:id_planu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(plan_komorkowy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id_planu) {
        String sql = "DELETE FROM PLANY_KOMORKOWE WHERE id_planu = ?";
        jdbcTemplate.update(sql, id_planu);
    }
}
