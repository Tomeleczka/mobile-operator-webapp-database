package bdbt_bada_project.OSKApplication.Database.Umowy;

import bdbt_bada_project.OSKApplication.Database.Adresy.Adres;
import bdbt_bada_project.OSKApplication.Database.Oferty.Oferta;
import bdbt_bada_project.OSKApplication.Database.Placowki.Placowka;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UmowyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;

    public UmowyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Umowa> list() {
        String sql = "SELECT * FROM Umowy";
        List<Umowa> listUmowa = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
        listUmowa.forEach(p -> System.out.println(p.toString()));
        return listUmowa;
    }


    public void save(Umowa umowa) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("UMOWY")
                .usingColumns("data_podpisania", "id_pracownika", "id_klienta", "id_oferty", "id_placowki")
                .usingGeneratedKeyColumns("id_umowy");



        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowa);

        Number generatedId = insertActor.executeAndReturnKey(param);

        Placowka placowka = jdbcTemplate.queryForObject("SELECT * FROM PLACOWKI WHERE id_placowki = ?", new Object[]{umowa.getId_placowki()}, new BeanPropertyRowMapper<>(Placowka.class));

        Oferta oferta = jdbcTemplate.queryForObject("SELECT * FROM OFERTY WHERE id_oferty = ?", new Object[]{umowa.getId_oferty()}, new BeanPropertyRowMapper<>(Oferta.class));

        SimpleJdbcInsert insertKonto = new SimpleJdbcInsert(jdbcTemplate);
        insertKonto.withTableName("KONTO_UMOWY").usingColumns("id_umowy", "data_podpisania", "id_pracownika", "id_klienta", "id_oferty", "id_placowki", "telefon", "adres_email", "id_operatora", "id_adresu", "nazwa", "okres", "cena", "id_planu", "specjalna");

        Map<String, Object> kontoUmowyParams = new HashMap<>();
        kontoUmowyParams.put("id_umowy", generatedId.longValue());

        String fixedDate = "2024.12.12 00:00:00";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(fixedDate);
            Date dataPodpisania = new Date(parsedDate.getTime());

            kontoUmowyParams.put("data_podpisania", new Timestamp(dataPodpisania.getTime()));
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();  // You might want to log or handle the exception according to your application's requirements
        }

        kontoUmowyParams.put("id_pracownika", umowa.getId_pracownika());
        kontoUmowyParams.put("id_klienta", umowa.getId_klienta());
        kontoUmowyParams.put("id_oferty", umowa.getId_oferty());
        kontoUmowyParams.put("id_placowki", umowa.getId_placowki());
        kontoUmowyParams.put("telefon", placowka.getTelefon());
        kontoUmowyParams.put("adres_email", placowka.getAdres_email());
        kontoUmowyParams.put("id_operatora", placowka.getId_operatora());
        kontoUmowyParams.put("id_adresu", placowka.getId_adresu());
        kontoUmowyParams.put("nazwa", oferta.getNazwa());
        kontoUmowyParams.put("okres", oferta.getOkres());
        kontoUmowyParams.put("cena", oferta.getCena());
        kontoUmowyParams.put("id_planu", oferta.getId_planu());
        kontoUmowyParams.put("specjalna", oferta.getSpecjalna());

        insertKonto.execute(kontoUmowyParams);
    }





    public Umowa get1(int id){
        Object[] args = {id};
        String sql = "SELECT * FROM UMOWY WHERE id_umowy = " + args[0];
        Umowa umowa = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Umowa.class));
        return umowa;
    }

    public void update(Umowa umowa) {
        String sql = "UPDATE UMOWY SET id_pracownika=:id_pracownika, id_klienta=:id_klienta, id_oferty=:id_oferty, id_placowki=:id_placowki WHERE id_umowy=:id_umowy";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(umowa);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id_umowy) {
        String sql = "DELETE FROM UMOWY WHERE id_umowy = ?";
        jdbcTemplate.update(sql, id_umowy);
    }
    public List<Umowa> listUmowaKonto(String numer_telefonu) {
        String sql = "SELECT * FROM Umowy JOIN Klienci ON Umowy.id_klienta = Klienci.id_klienta WHERE KLIENCI.NUMER_TELEFONU = ?";
        List<Umowa> listUmowaKonto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class), numer_telefonu);
        listUmowaKonto.forEach(p -> System.out.println(p.toString()));
        return listUmowaKonto;
    }
}
