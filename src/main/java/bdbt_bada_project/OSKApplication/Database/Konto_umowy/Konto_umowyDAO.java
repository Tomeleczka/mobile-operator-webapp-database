package bdbt_bada_project.OSKApplication.Database.Konto_umowy;

import bdbt_bada_project.OSKApplication.Database.Klienci.Klient;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class Konto_umowyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public Konto_umowyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Konto_umowy> list(String numer_telefonu) {
        Klient klient = jdbcTemplate.queryForObject("SELECT * FROM Klienci WHERE numer_telefonu = ?", new Object[]{numer_telefonu}, new BeanPropertyRowMapper<>(Klient.class));
        String sql = "SELECT * FROM Konto_umowy WHERE id_klienta = ?";
        List<Konto_umowy> listKontoUmowy = jdbcTemplate.query(sql, new Object[]{klient.getId_klienta()}, BeanPropertyRowMapper.newInstance(Konto_umowy.class));
        listKontoUmowy.forEach(p -> System.out.println(p.toString()));
        return listKontoUmowy;
    }

//    public List<Konto_umowy> get(String numer_telefonu) {
//        Klient klient = jdbcTemplate.queryForObject("SELECT * FROM Klienci WHERE numer_telefonu = ?", new Object[]{numer_telefonu}, new BeanPropertyRowMapper<>(Klient.class));
//        String sql = "SELECT * FROM Konto_umowy WHERE id_klienta = ?";
//        List<Konto_umowy> konto_umowyList = jdbcTemplate.query(sql, new Object[]{klient.getId_klienta()}, BeanPropertyRowMapper.newInstance(Konto_umowy.class));
//        return konto_umowyList;
//    }
}