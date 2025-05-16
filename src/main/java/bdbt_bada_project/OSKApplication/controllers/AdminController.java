package bdbt_bada_project.OSKApplication.controllers;


import java.util.List;

import bdbt_bada_project.OSKApplication.Database.Adresy.Adres;
import bdbt_bada_project.OSKApplication.Database.Adresy.AdresyDAO;
import bdbt_bada_project.OSKApplication.Database.Karty_sim.Karta_sim;
import bdbt_bada_project.OSKApplication.Database.Karty_sim.Karty_simDAO;
import bdbt_bada_project.OSKApplication.Database.Klienci.KlienciDAO;
import bdbt_bada_project.OSKApplication.Database.Klienci.Klient;
import bdbt_bada_project.OSKApplication.Database.Oferty.Oferta;
import bdbt_bada_project.OSKApplication.Database.Oferty.OfertyDAO;
import bdbt_bada_project.OSKApplication.Database.Operatorzy.Operator;
import bdbt_bada_project.OSKApplication.Database.Operatorzy.OperatorzyDAO;
import bdbt_bada_project.OSKApplication.Database.Placowki.Placowka;
import bdbt_bada_project.OSKApplication.Database.Placowki.PlacowkiDAO;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plan_komorkowy;
import bdbt_bada_project.OSKApplication.Database.Plany_komorkowe.Plany_komorkoweDAO;
import bdbt_bada_project.OSKApplication.Database.Poczty.Poczta;
import bdbt_bada_project.OSKApplication.Database.Poczty.PocztyDAO;
import bdbt_bada_project.OSKApplication.Database.Pracownicy.PracownicyDAO;
import bdbt_bada_project.OSKApplication.Database.Pracownicy.Pracownik;
import bdbt_bada_project.OSKApplication.Database.Stanowiska.StanowiskaDAO;
import bdbt_bada_project.OSKApplication.Database.Stanowiska.Stanowisko;
import bdbt_bada_project.OSKApplication.Database.Umowy.Umowa;
import bdbt_bada_project.OSKApplication.Database.Umowy.UmowyDAO;
import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.UzytkownicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AdminController implements WebMvcConfigurer {

	@Autowired
	private AdresyDAO adresyDAO;
	@Autowired
	private Karty_simDAO kartySimDAO;
	@Autowired
	private KlienciDAO klienciDAO;
	@Autowired
	private OfertyDAO ofertyDAO;
	@Autowired
	private OperatorzyDAO operatorzyDAO;
	@Autowired
	private PlacowkiDAO placowkiDAO;
	@Autowired
	private Plany_komorkoweDAO planyKomorkoweDAO;
	@Autowired
	private PocztyDAO pocztyDAO;
	@Autowired
	private PracownicyDAO pracownicyDAO;
	@Autowired
	private StanowiskaDAO stanowiskaDAO;
	@Autowired
	private UmowyDAO umowyDAO;
	@Autowired
	private UzytkownicyDAO uzytkownicyDAO;
	@RequestMapping("/main_admin")
	public String showAdminPage() {
		return "admin/main_admin";
	}
	@Controller
	public class adresyController {
		@RequestMapping("/adresy_new")
		public String showNewForm(Model model) {
			Adres adres = new Adres();
			model.addAttribute("adres", adres);
			List<Poczta> listPoczta = pocztyDAO.list();
			model.addAttribute("listPoczta", listPoczta);
			return "admin/adresy_new";
		}

		@RequestMapping("/adresy_admin")
		public String showAdresyAdminPage(Model model) {
			List<Adres> listAdres = adresyDAO.list();
			model.addAttribute("listAdres", listAdres);
			List<Operator> listOperator = operatorzyDAO.list();
			model.addAttribute("listOperator", listOperator);
			List<Placowka> listPlacowka = placowkiDAO.list();
			model.addAttribute("listPlacowka", listPlacowka);
			List<Pracownik> listPracownik = pracownicyDAO.list();
			model.addAttribute("listPracownik", listPracownik);
			List<Klient> listKlient = klienciDAO.list();
			model.addAttribute("listKlient", listKlient);
			return "admin/adresy_admin";
		}


		@RequestMapping(value = "/saveAdres", method = RequestMethod.POST)
		public String save(@ModelAttribute("adres") Adres adres) {
			adresyDAO.save(adres);
			return "redirect:adresy_admin";
		}
		int id_adresuVar = 0;
		@RequestMapping("/adresy_edit/{id_adresu}")
		public ModelAndView showEditForm(@PathVariable(name = "id_adresu") int id_adresu) {
			ModelAndView mav = new ModelAndView("admin/adresy_edit");
			Adres adres = adresyDAO.get1(id_adresu);
			id_adresuVar = id_adresu;
			mav.addObject("adres", adres);

			List<Poczta> listPoczta = pocztyDAO.list();
			mav.addObject("listPoczta", listPoczta);

			return mav;
		}

		@RequestMapping(value = "/adresy_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("adres") Adres adres){
			adres.setId_adresu(id_adresuVar);
			System.out.println(adres);
			adresyDAO.update(adres);

			return "redirect:adresy_admin";
		}


		@RequestMapping("/adresy_delete/{id_adresu}")
		public String delete(@PathVariable(name = "id_adresu") int id_adresu){
				adresyDAO.delete(id_adresu);
				return "redirect:/adresy_admin";
		}
	}
	@Controller
	public class kartySimController {
		@RequestMapping("/karty_sim_new")
		public String showNewForm(Model model) {
			List<Umowa> listUmowa = umowyDAO.list();
			model.addAttribute("listUmowa", listUmowa);
			Karta_sim kartaSim = new Karta_sim();
			model.addAttribute("kartaSim", kartaSim);
			return "admin/karty_sim_new";
		}

		@RequestMapping("/karty_sim_admin")
		public String showAdresyAdminPage(Model model) {
			List<Karta_sim> listKartaSim = kartySimDAO.list();
			model.addAttribute("listKartaSim", listKartaSim);
			return "admin/karty_sim_admin";
		}


		@RequestMapping(value = "/saveKartaSim", method = RequestMethod.POST)
		public String save(@ModelAttribute("kartaSim") Karta_sim kartaSim) {
			kartySimDAO.save(kartaSim);
			return "redirect:karty_sim_admin";

		}

		int id_karty_simVar = 0;
		@RequestMapping("/karty_sim_edit/{id_karty_sim}")
		public ModelAndView showEditForm(@PathVariable(name = "id_karty_sim") int id_karty_sim){
			ModelAndView mav = new ModelAndView("admin/karty_sim_edit");

			Karta_sim karta_sim = kartySimDAO.get1(id_karty_sim);
			id_karty_simVar = id_karty_sim;
			mav.addObject("karta_sim", karta_sim);

			List<Umowa> listUmowa = umowyDAO.list();
			mav.addObject("listUmowa", listUmowa);

			return mav;
		}

		@RequestMapping(value = "/karty_sim_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("karta_sim") Karta_sim karta_sim){
			karta_sim.setId_karty_sim(id_karty_simVar);
			kartySimDAO.update(karta_sim);

			return "redirect:karty_sim_admin";
		}

		@RequestMapping("/karty_sim_delete/{id_karty_sim}")
		public String delete(@PathVariable(name = "id_karty_sim") int id_karty_sim){
			kartySimDAO.delete(id_karty_sim);
			return "redirect:/karty_sim_admin";
		}
	}
	@Controller
	public class klienciController {
		@RequestMapping("/klienci_new")
		public String showNewForm(Model model) {
			Klient klient = new Klient();
			model.addAttribute("klient", klient);
			List<Adres> listAdres = adresyDAO.list();
			model.addAttribute("listAdres", listAdres);
			List<Operator> listOperator = operatorzyDAO.list();
			model.addAttribute("listOperator", listOperator);
			return "admin/klienci_new";
		}

		@RequestMapping("/klienci_admin")
		public String showKlienciAdminPage(Model model) {
			List<Klient> listKlient = klienciDAO.list();
			model.addAttribute("listKlient", listKlient);

			List<Umowa> listUmowa = umowyDAO.list();
			model.addAttribute("listUmowa", listUmowa);
			return "admin/klienci_admin";
		}


		@RequestMapping(value = "/saveKlient", method = RequestMethod.POST)
		public String save(@ModelAttribute("klient") Klient klient) {
			klienciDAO.save(klient);
			return "redirect:klienci_admin";
		}

		int id_klientaVar = 0;
		@RequestMapping("/klienci_edit/{id_klienta}")
		public ModelAndView showEditForm(@PathVariable(name = "id_klienta") int id_klienta){
			ModelAndView mav = new ModelAndView("admin/klienci_edit");
			id_klientaVar = id_klienta;

			Klient klient = klienciDAO.get1(id_klienta);
			mav.addObject("klient", klient);

			List<Adres> listAdres = adresyDAO.list();
			mav.addObject("listAdres", listAdres);
			List<Operator> listOperator = operatorzyDAO.list();
			mav.addObject("listOperator", listOperator);
			List<Placowka> listPlacowka = placowkiDAO.list();
			mav.addObject( "listPlacowka", listPlacowka );

			return mav;
		}

		@RequestMapping(value = "/klienci_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("klient") Klient klient){
			klient.setId_klienta(id_klientaVar);
			klienciDAO.update(klient);

			return "redirect:klienci_admin";
		}

		@RequestMapping("/klienci_delete/{id_klienta}")
		public String delete(@PathVariable(name = "id_klienta") int id_klienta){
			klienciDAO.delete(id_klienta);

			return "redirect:/klienci_admin";
		}
	}
	@Controller
	public class ofertyController {

		@RequestMapping("/oferty_admin")
		public String showOfertyAdminPage(Model model) {
			List<Oferta> listOferta = ofertyDAO.list();
			model.addAttribute("listOferta", listOferta);

			List<Umowa> listUmowa = umowyDAO.list();
			model.addAttribute("listUmowa", listUmowa);
			return "admin/oferty_admin";

		}



		@RequestMapping("/oferty_new")
		public String showNewForm(Model model) {
			List<Plan_komorkowy> listPlan = planyKomorkoweDAO.list();
			model.addAttribute("listPlan", listPlan);

			List<Operator> listOperator = operatorzyDAO.list();
			model.addAttribute("listOperator", listOperator);



			Oferta oferta = new Oferta();
			model.addAttribute("oferta", oferta);
			return "admin/oferty_new";
		}


		@RequestMapping(value = "/saveOferta", method = RequestMethod.POST)
		public String save(@ModelAttribute("oferta") Oferta oferta) {
			ofertyDAO.save(oferta);
			return "redirect:oferty_admin";
		}

		int id_ofertyVar = 0;
		@RequestMapping("/oferty_edit/{id_oferty}")
		public ModelAndView showEditForm(@PathVariable(name = "id_oferty") int id_oferty){
			ModelAndView mav = new ModelAndView("admin/oferty_edit");


			Oferta oferta = ofertyDAO.get1(id_oferty);

			id_ofertyVar = id_oferty;
			mav.addObject("oferta", oferta);

			List<Plan_komorkowy> listPlan = planyKomorkoweDAO.list();
			mav.addObject("listPlan", listPlan);

			List<Operator> listOperator = operatorzyDAO.list();
			mav.addObject("listOperator", listOperator);

			return mav;
		}

		@RequestMapping(value = "/oferty_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("oferta") Oferta oferta){
			oferta.setId_oferty(id_ofertyVar);
			ofertyDAO.update(oferta);

			return "redirect:oferty_admin";
		}
		@RequestMapping("/oferty_delete/{id_oferty}")
		public String delete(@PathVariable(name = "id_oferty") int id_oferty){
			ofertyDAO.delete(id_oferty);
			return "redirect:/oferty_admin";
		}
	}

	@Controller
	public class planyController {

		@RequestMapping("/plany_komorkowe_new")
		public String showNewForm(Model model) {
			Plan_komorkowy plan_komorkowy = new Plan_komorkowy();
			model.addAttribute("planKomorkowy", plan_komorkowy);
			return "admin/plany_komorkowe_new";
		}

		@RequestMapping("/plany_komorkowe_admin")
		public String showPlanydminPage(Model model) {
			List<Plan_komorkowy> listPlan = planyKomorkoweDAO.list();
			model.addAttribute("listPlan", listPlan);
			List<Oferta> listOferta = ofertyDAO.list();
			model.addAttribute("listOferta", listOferta);
			return "admin/plany_komorkowe_admin";
		}


		@RequestMapping(value = "/savePlan", method = RequestMethod.POST)
		public String save(@ModelAttribute("plan_komorkowy") Plan_komorkowy plan_komorkowy) {
			planyKomorkoweDAO.save(plan_komorkowy);
			return "redirect:plany_komorkowe_admin";
		}


		int id_planuVar = 0;
		@RequestMapping("/plany_edit/{id_planu}")
		public ModelAndView showEditForm(@PathVariable(name = "id_planu") int id_planu){
			ModelAndView mav = new ModelAndView("admin/plany_komorkowe_edit");
			Plan_komorkowy plan_komorkowy = planyKomorkoweDAO.get1(id_planu);

			id_planuVar = id_planu;
			mav.addObject("plan_komorkowy", plan_komorkowy);

			return mav;
		}

		@RequestMapping(value = "/plany_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("plan_komorkowy") Plan_komorkowy plan_komorkowy){
			plan_komorkowy.setId_planu(id_planuVar);
			planyKomorkoweDAO.update(plan_komorkowy);

			return "redirect:plany_komorkowe_admin";
		}

		@RequestMapping("/plany_delete/{id_planu}")
		public String delete(@PathVariable(name = "id_planu") int id_planu){
			planyKomorkoweDAO.delete(id_planu);
			return "redirect:/plany_komorkowe_admin";
		}
	}
	@Controller
	public class pocztyController {
		@RequestMapping("/poczty_new")
		public String showNewForm(Model model) {
			Poczta poczta = new Poczta();
			model.addAttribute("poczta", poczta);
			return "admin/poczty_new";
		}

		@RequestMapping("/poczty_admin")
		public String showPocztyAdminPage(Model model) {
			List<Poczta> listPoczta = pocztyDAO.list();
			model.addAttribute("listPoczta", listPoczta);
			List<Adres> listAdres = adresyDAO.list();
			model.addAttribute("listAdres", listAdres);
			return "admin/poczty_admin";
		}


		@RequestMapping(value = "/savePoczta", method = RequestMethod.POST)
		public String save(@ModelAttribute("poczta") Poczta poczta) {
			pocztyDAO.save(poczta);
			return "redirect:poczty_admin";
		}

		int id_pocztyVar = 0;
		@RequestMapping("/poczty_edit/{id_poczty}")
		public ModelAndView showEditForm(@PathVariable(name = "id_poczty") int id_poczty){
			ModelAndView mav = new ModelAndView("admin/poczty_edit");
			Poczta poczta = pocztyDAO.get1(id_poczty);
			id_pocztyVar = id_poczty;
			mav.addObject("poczta", poczta);

			return mav;
		}

		@RequestMapping(value = "/poczty_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("poczta") Poczta poczta){
			poczta.setId_poczty(id_pocztyVar);
			pocztyDAO.update(poczta);

			return "redirect:poczty_admin";
		}

		@RequestMapping("/poczty_delete/{id_poczty}")
		public String delete(@PathVariable(name = "id_poczty") int id_poczty){
			pocztyDAO.delete(id_poczty);
			return "redirect:/poczty_admin";
		}
	}
	@Controller
	public class pracownicyController {
		@RequestMapping("/pracownicy_new")
		public String showNewForm(Model model) {
			List<Operator> listOperator = operatorzyDAO.list();
			model.addAttribute("listOperator", listOperator);

			List<Adres> listAdres = adresyDAO.list();
			model.addAttribute("listAdres", listAdres);

			List<Stanowisko> listStanowisko = stanowiskaDAO.list();
			model.addAttribute("listStanowisko", listStanowisko);

			List<Placowka> listPlacowka = placowkiDAO.list();
			model.addAttribute("listPlacowka", listPlacowka);

			Pracownik pracownik = new Pracownik();
			model.addAttribute("pracownik", pracownik);
			return "admin/pracownicy_new";
		}

		@RequestMapping("/pracownicy_admin")
		public String showPracownicyAdminPage(Model model) {
			List<Pracownik> listPracownik = pracownicyDAO.list();
			model.addAttribute("listPracownik", listPracownik);
			List<Umowa> listUmowa = umowyDAO.list();
			model.addAttribute("listUmowa", listUmowa);

			return "admin/pracownicy_admin";
		}


		@RequestMapping(value = "/savePracownik", method = RequestMethod.POST)
		public String save(@ModelAttribute("pracownik") Pracownik pracownik) {
			pracownicyDAO.save(pracownik);
			return "redirect:/pracownicy_admin";
		}

		int id_pracownikaVar = 0;
		@RequestMapping("/pracownicy_edit/{id_pracownika}")
		public ModelAndView showEditForm(@PathVariable(name = "id_pracownika") int id_pracownika){
			ModelAndView mav = new ModelAndView("admin/pracownicy_edit");
			Pracownik pracownik = pracownicyDAO.get1(id_pracownika);

			id_pracownikaVar = id_pracownika;
			mav.addObject("pracownik", pracownik);

			List<Operator> listOperator = operatorzyDAO.list();
			mav.addObject("listOperator", listOperator);

			List<Adres> listAdres = adresyDAO.list();
			mav.addObject("listAdres", listAdres);

			List<Stanowisko> listStanowisko = stanowiskaDAO.list();
			mav.addObject("listStanowisko", listStanowisko);

			List<Placowka> listPlacowka = placowkiDAO.list();
			mav.addObject("listPlacowka", listPlacowka);

			return mav;
		}

		@RequestMapping(value = "/pracownicy_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("pracownik") Pracownik pracownik){
			pracownik.setId_pracownika(id_pracownikaVar);
			pracownicyDAO.update(pracownik);

			return "redirect:/pracownicy_admin";
		}

		@RequestMapping("/pracownicy_delete/{id_pracownika}")
		public String delete(@PathVariable(name = "id_pracownika") int id_pracownika){
			pracownicyDAO.delete(id_pracownika);

			return "redirect:/pracownicy_admin";
		}
	}
	@Controller
	public class umowyController {
		@RequestMapping("/umowy_new")
		public String showNewForm(Model model) {
			Umowa umowa = new Umowa();
			model.addAttribute("umowa", umowa);

			List<Pracownik> listPracownik = pracownicyDAO.list();
			model.addAttribute("listPracownik", listPracownik);

			List<Oferta> listOferta = ofertyDAO.list();
			model.addAttribute("listOferta", listOferta);

			List<Klient> listKlient = klienciDAO.list();
			model.addAttribute("listKlient", listKlient);

			List<Placowka> listPlacowka = placowkiDAO.list();
			model.addAttribute("listPlacowka", listPlacowka);

			return "admin/umowy_new";
		}

		@RequestMapping("/umowy_admin")

		public String showUmowyAdminPage(Model model) {
			List<Umowa> listUmowa = umowyDAO.list();
			model.addAttribute("listUmowa", listUmowa);

			List<Karta_sim> listKartaSim = kartySimDAO.list();
			model.addAttribute("listKartaSim", listKartaSim);
			return "admin/umowy_admin";
		}


		@RequestMapping(value = "/saveUmowa", method = RequestMethod.POST)
		public String save(@ModelAttribute("umowa") Umowa umowa) {
			umowyDAO.save(umowa);
			return "redirect:/umowy_admin";
		}

		int id_umowyVar = 0;
		String data_podpisaniaVar = "";
		@RequestMapping("/umowy_edit/{id_umowy}")
		public ModelAndView showEditForm(@PathVariable(name = "id_umowy") int id_umowy){
			ModelAndView mav = new ModelAndView("admin/umowy_edit");
			Umowa umowa = umowyDAO.get1(id_umowy);
			id_umowyVar = id_umowy;
			data_podpisaniaVar = umowa.getData_podpisania();
			mav.addObject("umowa", umowa);

			List<Pracownik> listPracownik = pracownicyDAO.list();
			mav.addObject("listPracownik", listPracownik);

			List<Oferta> listOferta = ofertyDAO.list();
			mav.addObject("listOferta", listOferta);

			List<Klient> listKlient = klienciDAO.list();
			mav.addObject("listKlient", listKlient);

			List<Placowka> listPlacowka = placowkiDAO.list();
			mav.addObject("listPlacowka", listPlacowka);

			return mav;
		}

		@RequestMapping(value = "/umowy_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("umowa") Umowa umowa){
			umowa.setId_umowy(id_umowyVar);
			umowa.setData_podpisania( data_podpisaniaVar );
			System.out.println("hello "+id_umowyVar);
			umowyDAO.update(umowa);
			return "redirect:/umowy_admin";
		}

		@RequestMapping("/umowy_delete/{id_umowy}")
		public String delete(@PathVariable(name = "id_umowy") int id_umowy){
			umowyDAO.delete(id_umowy);

			return "redirect:/umowy_admin";
		}
	}
}