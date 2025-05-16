package bdbt_bada_project.OSKApplication.Database.Operatorzy;

import bdbt_bada_project.OSKApplication.Database.Operatorzy.Operator;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OperatorzyDAO {
    /* Import org.springframework.jd....Template */
    private final JdbcTemplate jdbcTemplate;
    public OperatorzyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Operator> list() {
        String sql = "SELECT * FROM Operatorzy";
        List<Operator> listOperator = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Operator.class));
        listOperator.forEach(p -> System.out.println(p.toString()));
        return listOperator;
    }



}

