package bdbt_bada_project.OSKApplication.controllers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppMainController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main_user");
        registry.addViewController("/Pomoc").setViewName("pomoc");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/plany").setViewName("plany");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/rejestracja").setViewName("rejestracja");
        registry.addViewController( "/main_admin").setViewName("admin/main_admin");
        registry.addViewController( "/logout").setViewName("/logout");
    }
    @Controller
    public class DashBoardController {

        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else{
                return "redirect:/main_user";
            }
        }

    }

}
