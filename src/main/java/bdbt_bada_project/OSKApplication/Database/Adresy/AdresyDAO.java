package bdbt_bada_project.OSKApplication.Database.Adresy;
import bdbt_bada_project.OSKApplication.Database.Klienci.Klient;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AdresyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list() {
        String sql = "SELECT * FROM Adresy";
        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        listAdres.forEach(p -> System.out.println(p.toString()));
        return listAdres;
    }
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADRESY").usingColumns("Miasto","ulica", "nr_domu", "id_poczty");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }

    public Adres get1(int id_adresu){
        Object[] args = {id_adresu};
        String sql = "SELECT * FROM ADRESY WHERE id_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu, id_poczty=:id_poczty WHERE id_adresu=:id_adresu";
        String sql_konto = "UPDATE KONTO_DANE2 SET miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu, id_poczty=:id_poczty WHERE id_adresu=:id_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
        template.update(sql_konto, param);
    }

    public void delete(int id_adresu) {
        String sql = "DELETE FROM ADRESY WHERE id_adresu = ?";
        jdbcTemplate.update(sql, id_adresu);
    }

    public List<Adres> listAdresKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Adresy  JOIN KLIENCI ON Adresy.id_adresu = Klienci.id_adresu WHERE KLIENCI.NUMER_TELEFONU = ?";
        List<Adres> listAdresKonto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class), numer_telefonu);
        listAdresKonto.forEach(p -> System.out.println(p.toString()));
        return listAdresKonto;
    }

    public List<Adres> listPlacowkaAdresKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Adresy JOIN Placowki ON Adresy.id_adresu = Placowki.id_adresu JOIN Umowy ON Placowki.id_placowki = Umowy.id_placowki JOIN Klienci ON Umowy.id_klienta = Klienci.id_klienta WHERE KLIENCI.NUMER_TELEFONU = ?";
        List<Adres> listPlacowkaAdresKonto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class), numer_telefonu);
        listPlacowkaAdresKonto.forEach(p -> System.out.println(p.toString()));
        return listPlacowkaAdresKonto;
    }

    public List<String> checkIdAdresu(String id_adresu) {
        String[] arrayDependencies={"OPERATORZY","WLASCICIELE","PLACOWKI","PRACOWNICY", "KLIENCI"};
        List<String> listDependencies=new ArrayList<String>();
        for (int i=0; i<5; i++) {
            String sql = "SELECT COUNT(*) FROM " + arrayDependencies[i] + " WHERE id_adresu = ?";
            if(jdbcTemplate.queryForObject( sql, Integer.class, id_adresu )>0) {
                listDependencies.add(arrayDependencies[i]);
            }
        }
        return  listDependencies;
    }

}
