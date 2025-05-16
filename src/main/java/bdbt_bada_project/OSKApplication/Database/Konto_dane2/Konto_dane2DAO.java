package bdbt_bada_project.OSKApplication.Database.Konto_dane2;
import bdbt_bada_project.OSKApplication.Database.Klienci.KlienciDAO;
import bdbt_bada_project.OSKApplication.Database.Klienci.Klient;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Optional;

@Repository
public class Konto_dane2DAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    private final KlienciDAO klienciDAO;

    public Konto_dane2DAO(JdbcTemplate jdbcTemplate, KlienciDAO klienciDAO) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.klienciDAO = klienciDAO;

    }


    public Konto_dane2 list(String numer_telefonu) {
        String sql = "SELECT * FROM KONTO_DANE2 WHERE numer_telefonu = " + numer_telefonu;
        Konto_dane2 konto_dane2 = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Konto_dane2.class));
        return konto_dane2;
    }

    public Konto_dane2 get1(String numer_telefonu){
        String sql = "SELECT * FROM KONTO_DANE2 WHERE numer_telefonu =" + numer_telefonu;
        Konto_dane2 konto_dane = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Konto_dane2.class));
        return konto_dane;
    }

    public void update(Konto_dane2 konto_dane) {

        String sql_klient = "UPDATE KLIENCI SET imie=:imie, nazwisko=:nazwisko WHERE numer_telefonu=:numer_telefonu";

        String sql_select_id_adresu = String.valueOf(Konto_dane2.getId_adresu());
        String sql_select_id_poczty = String.valueOf(Konto_dane2.getId_poczty());

        //System.out.println(sql_select_id_adresu);

        String sql_adresy = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu WHERE id_adresu=" + sql_select_id_adresu;
        String sql_poczty = "UPDATE POCZTY SET kod_poczty=:kod_poczty, poczta=:poczta WHERE id_poczty=" + sql_select_id_poczty;
        String sql_konto = "UPDATE KONTO_DANE2 SET imie=:imie, nazwisko=:nazwisko, miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu, kod_poczty=:kod_poczty, poczta=:poczta  WHERE numer_telefonu=:numer_telefonu";

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(konto_dane);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql_klient, param);
        template.update(sql_adresy, param);
        template.update(sql_poczty, param);
        template.update(sql_konto, param);

    }


}
