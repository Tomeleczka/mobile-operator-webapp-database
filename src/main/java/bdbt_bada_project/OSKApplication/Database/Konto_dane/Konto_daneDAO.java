package bdbt_bada_project.OSKApplication.Database.Konto_dane;

import bdbt_bada_project.OSKApplication.Database.Klienci.Klient;
import bdbt_bada_project.OSKApplication.Database.Konto_dane.Konto_dane;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Konto_daneDAO {
	private final JdbcTemplate jdbcTemplate;
	public Konto_daneDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Konto_dane> list() {
		String sql = "SELECT * FROM KONTO_DANE";
		List<Konto_dane> listKontoDane = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Konto_dane.class));
		listKontoDane.forEach(p -> System.out.println(p.toString()));
		return listKontoDane;
	}

	public Konto_dane get1(){
		String sql = "SELECT * FROM KONTO_DANE";
		Konto_dane konto_dane = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Konto_dane.class));
		return konto_dane;
	}
}

