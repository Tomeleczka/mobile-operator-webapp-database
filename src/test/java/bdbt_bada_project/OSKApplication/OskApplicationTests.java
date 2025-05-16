package bdbt_bada_project.OSKApplication;

import bdbt_bada_project.OSKApplication.Database.Adresy.AdresyDAO;
import bdbt_bada_project.OSKApplication.Database.Karty_sim.Karty_simDAO;
import bdbt_bada_project.OSKApplication.Database.Klienci.KlienciDAO;
import bdbt_bada_project.OSKApplication.Database.Klienci.Klient;
import bdbt_bada_project.OSKApplication.Database.Oferty.Oferta;
import bdbt_bada_project.OSKApplication.Database.Oferty.OfertyDAO;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plan_komorkowy;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plany_komorkoweDAO;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import bdbt_bada_project.OSKApplication.Database.Poczty.PocztyDAO;
import bdbt_bada_project.OSKApplication.Database.Pracownicy.PracownicyDAO;
import bdbt_bada_project.OSKApplication.Database.Pracownicy.Pracownik;
import bdbt_bada_project.OSKApplication.Database.Umowy.Umowa;
import bdbt_bada_project.OSKApplication.Database.Umowy.UmowyDAO;
import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.UzytkownicyDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

class PocztyDAOTest {
	private PocztyDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##emilka");
		dataSource.setPassword("123456");
		dao = new PocztyDAO(new JdbcTemplate(dataSource));

	}
	@Test
	void testList() {
		List<Poczta> listPoczta = dao.list();
		assertTrue(listPoczta.size() > 0);

	}
	/*@Test
	void testCheck() {
		Boolean o = dao.checkPoczty(2);
		System.out.println(o);

	}*/
	@Test
	void testSave() {
		Poczta poczta = new Poczta(0, "03-571","Mazowieckie");
		dao.save(poczta);
	}
	@Test
	void testGet() {
		fail("Not yet implemented");
	}
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
class KlienciDAOTest {
	private KlienciDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName( "oracle.jdbc.OracleDriver" );
		dataSource.setUrl( "jdbc:oracle:thin:@localhost:1521:xe" );
		dataSource.setUsername( "C##emilka" );
		dataSource.setPassword( "123456" );
		dao = new KlienciDAO( new JdbcTemplate( dataSource ) );

	}

	@Test
	void testList() {
		List<Klient> listKonto = dao.listKonto( "+48000000000" );
		assertTrue( listKonto.size() > 0 );

	}
}
class OfertyDAOTest {
	private OfertyDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##emilka");
		dataSource.setPassword("123456");
		dao = new OfertyDAO(new JdbcTemplate(dataSource));

	}
	@Test
	void testList() {
		List<Oferta> listOferta = dao.list();
		assertTrue(listOferta.size() > 0);
		System.out.println(listOferta);

	}
	@Test
	void testSave() {
		Oferta oferta = new Oferta(0,"okay","10","10",21,2,"1");
		dao.save(oferta);
	}@Test
	void testGet() {
		fail("Not yet implemented");
	}
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Test
	void testDelete() {
		int id = 88;
		dao.delete( 88 );
	}

}
class UmowyDAOTest {
	private UmowyDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##emilka");
		dataSource.setPassword("123456");
		dao = new UmowyDAO(new JdbcTemplate(dataSource));

	}
	/*@Test
	void testList() {
		List<Oferta> listOferta = dao.list();
		assertTrue(listOferta.size() > 0);
		System.out.println(listOferta);

	}*/
	/*@Test
	void testSave() {
		Pracownik pracownik = new Pracownik(0,"h","h",00000000,"K","+48575575575","000000000000000000000000", );
		dao.save(pracownik);
	}*/@Test
	void testGet() {
		fail("Not yet implemented");
	}
	@Test
	void testUpdate() {
		Umowa umowa = new Umowa();
		umowa.setId_umowy( 125 );
		umowa.setId_placowki( 21 );
		dao.update( umowa );
	}
	/*@Test
	void testDelete() {
		int id = 88;
		dao.delete( 88 );
	}*/

}
class Plany_komorkoweDAOTest {
	private Plany_komorkoweDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##bettkina");
		dataSource.setPassword("Db16102004!");
		dao = new Plany_komorkoweDAO(new JdbcTemplate(dataSource));

	}
	@Test
	void testList() {
		List<Plan_komorkowy> listPlanKomorkowy = dao.list();
		assertTrue(listPlanKomorkowy.size() > 0);

	}
	@Test
	void testSave() {
		fail("Not yet implemented");
	}
	@Test
	void testGet() {
		fail("Not yet implemented");
	}
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
class Karty_simDAOTest {
	private Karty_simDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##bettkina");
		dataSource.setPassword("Db16102004!");
		dao = new Karty_simDAO(new JdbcTemplate(dataSource));

	}
/*
	@Test
	void testSelect() {
		dao.getIdKartySimByPhoneNumber("+48574995441");
	}
*/

}
class AdresyDAOTest {
	private AdresyDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##emilka");
		dataSource.setPassword("123456");
		dao = new AdresyDAO(new JdbcTemplate(dataSource));

	}
	@Test
	void testSelect() {

		System.out.println(dao.checkIdAdresu( "2"));
	}

}
class UzytkownicyDAOTest {
	private UzytkownicyDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##bettkina");
		dataSource.setPassword("Db16102004!");
		dao = new UzytkownicyDAO(new JdbcTemplate(dataSource));

	}
	/*@Test
	void testSave() {
		dao.setLogin("+48575994787");
		dao.setHaslo("lol");
		dao.setIdKartySim(7);
		dao.setIdKlienta(2);
		dao.save();
	}*/

}