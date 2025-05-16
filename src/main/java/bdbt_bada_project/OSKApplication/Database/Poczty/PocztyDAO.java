package bdbt_bada_project.OSKApplication.Database.Poczty;
import bdbt_bada_project.OSKApplication.Database.Adresy.Adres;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plan_komorkowy;
import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.Uzytkownik;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PocztyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public PocztyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczta> list() {
        String sql = "SELECT * FROM Poczty";
        List<Poczta> listPoczta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        listPoczta.forEach(p -> System.out.println(p.toString()));
        return listPoczta;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Poczta poczta) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("POCZTY").usingColumns("kod_poczty","poczta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        insertActor.execute(param);
    }
    public Poczta get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM POCZTY WHERE id_poczty = " + args[0];
        Poczta poczta = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }

    public void update(Poczta poczta) {
        String sql = "UPDATE POCZTY SET kod_poczty=:kod_poczty, poczta=:poczta WHERE id_poczty=:id_poczty";
        String sql_konto = "UPDATE KONTO_DANE2 SET kod_poczty=:kod_poczty, poczta=:poczta WHERE id_poczty=:id_poczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
        template.update(sql_konto, param);
    }
    public void delete(int id_poczty) {
        String sql = "DELETE FROM POCZTY WHERE id_poczty = ?";
        jdbcTemplate.update(sql, id_poczty);
    }
    public List<Poczta> listPocztaKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Poczty  JOIN Adresy ON Poczty.id_poczty = Adresy.id_adresu JOIN KLIENCI ON Adresy.id_adresu = Klienci.id_adresu WHERE KLIENCI.NUMER_TELEFONU = ?";
        List<Poczta> listPocztaKonto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class), numer_telefonu);
        listPocztaKonto.forEach(p -> System.out.println(p.toString()));
        return listPocztaKonto;
    }
}
