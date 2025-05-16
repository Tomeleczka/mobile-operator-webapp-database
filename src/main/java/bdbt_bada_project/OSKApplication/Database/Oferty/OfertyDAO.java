package bdbt_bada_project.OSKApplication.Database.Oferty;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OfertyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public OfertyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Oferta> list() {
        String sql = "SELECT * FROM Oferty";
        List<Oferta> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));
        listOferta.forEach(p -> System.out.println(p.toString()));
        return listOferta;
    }
    public List<Oferta> listSpecial() {
        String sql = "SELECT * FROM Oferty WHERE specjalna = 1";
        List<Oferta> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));
        listOferta.forEach(p -> System.out.println(p.toString()));
        return listOferta;
    }
    public void save(Oferta oferta) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("OFERTY").usingColumns("nazwa","okres", "cena", "specjalna","id_operatora", "id_planu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oferta);
        insertActor.execute(param);
    }

    /* Insert – wstawianie nowego wiersza do bazy */

    public Oferta get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM OFERTY WHERE id_oferty = " + args[0];
        Oferta oferta = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Oferta.class));
        return oferta;
    }

    public void update(Oferta oferta) {
        String sql = "UPDATE OFERTY SET nazwa=:nazwa, okres=:okres, cena=:cena, specjalna=:specjalna, id_operatora=:id_operatora, id_planu=:id_planu WHERE id_oferty=:id_oferty";
        String sql_konto = "UPDATE KONTO_UMOWY SET nazwa=:nazwa, okres=:okres, cena=:cena, specjalna=:specjalna, id_operatora=:id_operatora, id_planu=:id_planu WHERE id_oferty=:id_oferty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oferta);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
        template.update(sql_konto, param);

    }
    public void delete(int id_oferty) {
        String sql = "DELETE oferty WHERE id_oferty = ?";
        jdbcTemplate.update(sql, id_oferty);
    }
    public List<Oferta> listOfertaKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Oferty JOIN Umowy ON Oferty.id_oferty = Umowy.id_oferty JOIN Klienci ON Umowy.id_klienta = Klienci.id_klienta WHERE KLIENCI.NUMER_TELEFONU = ?";
        List<Oferta> listOfertaKonto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class), numer_telefonu);
        listOfertaKonto.forEach(p -> System.out.println(p.toString()));
        return listOfertaKonto;
    }
}
