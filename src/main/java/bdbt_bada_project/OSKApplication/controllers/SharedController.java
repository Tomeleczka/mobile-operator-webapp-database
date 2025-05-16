package bdbt_bada_project.OSKApplication.controllers;

import java.util.List;

import bdbt_bada_project.OSKApplication.Database.Karty_sim.Karta_sim;
import bdbt_bada_project.OSKApplication.Database.Karty_sim.Karty_simDAO;
import bdbt_bada_project.OSKApplication.Database.Oferty.Oferta;
import bdbt_bada_project.OSKApplication.Database.Oferty.OfertyDAO;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plan_komorkowy;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plany_komorkoweDAO;
import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.UzytkownicyDAO;
import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.Uzytkownik;
import bdbt_bada_project.OSKApplication.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Controller
@Configuration
public class SharedController implements WebMvcConfigurer {
		@Autowired
		private Karty_simDAO kartySimDAO;
		@Autowired
		private UzytkownicyDAO uzytkownicyDAO;
		@Autowired
		private OfertyDAO dao;

		@Autowired
		private Plany_komorkoweDAO dao2;

		@RequestMapping("/main_user")
		public String showUserPage(Model model) {
			List<Plan_komorkowy> listPlan = dao2.list();
			model.addAttribute("listPlan", listPlan);

			List<Oferta> listOferta = dao.listSpecial();
			model.addAttribute("listOferta", listOferta);
			model.addAttribute("isLoggedIn", UserUtils.isLoggedIn());
			return "main_user";
		}
		@RequestMapping("/rejestracja")
		public String showNewForm(Model model) {
			List<Karta_sim> listKartaSim = kartySimDAO.list();
			model.addAttribute("listKartaSim", listKartaSim);
			List<Uzytkownik> listUzytkownik = uzytkownicyDAO.list();
			model.addAttribute("listUzytkownik", listUzytkownik);
			Uzytkownik uzytkownik = new Uzytkownik();
			model.addAttribute("uzytkownik", uzytkownik);
			return "rejestracja";
		}


		@RequestMapping(value = "/saveUzytkownik", method = RequestMethod.POST)
		public String save(@ModelAttribute("Uzytkownik") Uzytkownik uzytkownik) {
			uzytkownicyDAO.save(uzytkownik);
			return "redirect:main";
		}
	@RequestMapping("/plany")
	public String showPlanyPage(Model model) {
		List<Plan_komorkowy> listPlan = dao2.list();
		model.addAttribute("listPlan", listPlan);
		return "plany";
	}
}