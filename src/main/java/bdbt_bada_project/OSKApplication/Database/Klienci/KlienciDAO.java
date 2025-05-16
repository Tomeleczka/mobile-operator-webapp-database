package bdbt_bada_project.OSKApplication.Database.Klienci;


import bdbt_bada_project.OSKApplication.Database.Adresy.AdresyDAO;
import bdbt_bada_project.OSKApplication.Database.Adresy.Adres;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import bdbt_bada_project.OSKApplication.Database.Poczty.PocztyDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KlienciDAO {

    private final JdbcTemplate jdbcTemplate;
    private AdresyDAO adresyDAO;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }



    public List<Klient> list() {
        String sql = "SELECT * FROM Klienci";
        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        listKlient.forEach(p -> System.out.println(p.toString()));
        return listKlient;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klient klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("KLIENCI")
                .usingColumns("imie", "nazwisko", "pesel", "numer_telefonu", "id_operatora", "id_adresu")
                .usingGeneratedKeyColumns("id_klienta");  // Specify the name of the generated key column

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        Number generatedId = insertActor.executeAndReturnKey(param);


        Adres adres = jdbcTemplate.queryForObject("SELECT * FROM ADRESY WHERE id_adresu = ?", new Object[]{klient.getId_adresu()}, new BeanPropertyRowMapper<>(Adres.class));


        Poczta poczta = jdbcTemplate.queryForObject("SELECT * FROM POCZTY WHERE id_poczty = ?", new Object[]{adres.getId_poczty()}, new BeanPropertyRowMapper<>(Poczta.class));

        SimpleJdbcInsert insertKonto = new SimpleJdbcInsert(jdbcTemplate);
        insertKonto.withTableName("KONTO_DANE2").usingColumns("id_klienta", "imie", "nazwisko", "pesel", "numer_telefonu", "id_operatora", "id_adresu", "miasto", "ulica", "nr_domu", "id_poczty", "kod_poczty", "poczta");


        Map<String, Object> params = new HashMap<>();
        params.put("id_klienta", generatedId.longValue());
        params.put("imie", klient.getImie());
        params.put("nazwisko", klient.getNazwisko());
        params.put("pesel", klient.getPesel());
        params.put("numer_telefonu", klient.getNumer_telefonu());
        params.put("id_operatora", klient.getId_operatora());
        params.put("id_adresu", klient.getId_adresu());
        params.put("miasto", adres.getMiasto());
        params.put("ulica", adres.getUlica());
        params.put("nr_domu", adres.getNr_domu());
        params.put("id_poczty", poczta.getId_poczty());
        params.put("kod_poczty", poczta.getKod_poczty());
        params.put("poczta", poczta.getPoczta());

        insertKonto.execute(params);
    }


    public int getIdKlientaByPhoneNumber(String phoneNumber) {
        String sql = "SELECT id_klienta FROM KLIENCI WHERE numer_telefonu = ?";
        try {
            System.out.println(jdbcTemplate.queryForObject(sql, Integer.class, phoneNumber));
            return jdbcTemplate.queryForObject(sql, Integer.class, phoneNumber);
        } catch (EmptyResultDataAccessException e) {
            // Handle the case when no record is found for the given phone number
            return 0;
        }
    }

    public Klient get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM KLIENCI WHERE id_klienta = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }

    public void update(Klient klient) {
        String sql = "UPDATE KLIENCI SET imie=:imie, nazwisko=:nazwisko, pesel=:pesel, numer_telefonu=:numer_telefonu, id_operatora=:id_operatora, id_adresu=:id_adresu WHERE id_klienta=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id_klienta) {
        String sql = "DELETE FROM KLIENCI WHERE id_klienta = ?";
        jdbcTemplate.update(sql, id_klienta);
    }


    public List<Klient> listKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Klienci WHERE NUMER_TELEFONU = ?";
        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class), numer_telefonu);
        listKlient.forEach(p -> System.out.println(p.toString()));
        return listKlient;
    }
}
