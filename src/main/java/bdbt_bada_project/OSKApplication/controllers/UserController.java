package bdbt_bada_project.OSKApplication.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bdbt_bada_project.OSKApplication.Database.Adresy.AdresyDAO;
import bdbt_bada_project.OSKApplication.Database.Klienci.KlienciDAO;
import bdbt_bada_project.OSKApplication.Database.Konto_dane2.Konto_dane2;
import bdbt_bada_project.OSKApplication.Database.Konto_dane2.Konto_dane2DAO;
import bdbt_bada_project.OSKApplication.Database.Konto_umowy.Konto_umowy;
import bdbt_bada_project.OSKApplication.Database.Konto_umowy.Konto_umowyDAO;
import bdbt_bada_project.OSKApplication.Database.Oferty.OfertyDAO;
import bdbt_bada_project.OSKApplication.Database.Poczty.PocztyDAO;
import bdbt_bada_project.OSKApplication.Database.Pracownicy.PracownicyDAO;
import bdbt_bada_project.OSKApplication.Database.Umowy.UmowyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


	@Controller
	public class kontoController {
		@Autowired  // Add this annotation to autowire the Plany_komorkoweDAO
		private KlienciDAO klienciDAO;
		@Autowired  // Add this annotation to autowire the Plany_komorkoweDAO
		private AdresyDAO adresyDAO;
		@Autowired  // Add this annotation to autowire the Plany_komorkoweDAO
		private PocztyDAO pocztyDAO;
		@Autowired  // Add this annotation to autowire the Plany_komorkoweDAO
		private UmowyDAO umowyDAO;
		@Autowired  // Add this annotation to autowire the Plany_komorkoweDAO
		private OfertyDAO ofertyDAO;
		@Autowired  // Add this annotation to autowire the Plany_komorkoweDAO
		private PracownicyDAO pracownicyDAO;

		@Autowired
		private Konto_dane2DAO konto_dane2DAO;
		@Autowired
		private Konto_umowyDAO konto_umowyDAO;

		@RequestMapping("/konto")
		public String showUserPage(Model model, HttpServletRequest httpServletRequest) {
			String user = httpServletRequest.getRemoteUser();

			Konto_dane2 konto_dane2 = konto_dane2DAO.list(user);
			model.addAttribute("konto_dane2", konto_dane2);

			List<Konto_umowy> listKontoUmowy = konto_umowyDAO.list(user);
			model.addAttribute("listKontoUmowy", listKontoUmowy);
			return "user/konto";
		}

		@RequestMapping("/konto_edit")
		public ModelAndView showEditForm(HttpServletRequest httpServletRequest) {
			ModelAndView mav = new ModelAndView("user/konto_edit");
			String user = httpServletRequest.getRemoteUser();


//            Klient klient = klienciDAO.get_konto(user);
//            mav.addObject("klient", klient);


			Konto_dane2 konto_dane = konto_dane2DAO.list(user);
			mav.addObject("konto_dane2", konto_dane);


			return mav;
		}

		@RequestMapping(value = "/konto_update", method = RequestMethod.POST)
		public String update(@ModelAttribute("konto_dane2") Konto_dane2 konto_dane) {
			konto_dane2DAO.update(konto_dane);

			return "redirect:konto";
		}


	}
}
