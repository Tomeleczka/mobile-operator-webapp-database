package bdbt_bada_project.OSKApplication;

import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.Uzytkownik;
import bdbt_bada_project.OSKApplication.Database.Uzytkownicy.UzytkownicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UzytkownicyDAO uzytkownicyDAO;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        List<Uzytkownik> listUzytkownikSecurity = uzytkownicyDAO.list();

        for (Uzytkownik uzytkownik : listUzytkownikSecurity) {
            auth.inMemoryAuthentication()
                    .withUser(uzytkownik.getLogin())
                    .password(uzytkownik.getHaslo())
                    .roles("USER", "ID_" + uzytkownik.getId_uzytkownika());
        }
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }



    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<Uzytkownik> listUzytkownikSecurity = uzytkownicyDAO.list();

        for (Uzytkownik uzytkownik : listUzytkownikSecurity) {
            http
                    .csrf()
                    .csrfTokenRepository( CookieCsrfTokenRepository.withHttpOnlyFalse() )
                    .and()
                    .authorizeRequests()
//                    .antMatchers( "/resources/templates/admin/**" ).access( "hasRole('USER' )")

                    .antMatchers("/main_admin").hasRole("ADMIN")
                    .antMatchers("/adresy_admin").hasRole("ADMIN")
                    .antMatchers("/karty_sim_admin").hasRole("ADMIN")
                    .antMatchers("/klienci_admin").hasRole("ADMIN")
                    .antMatchers("/oferty_admin").hasRole("ADMIN")
                    .antMatchers("/plany_komorkowe_admin").hasRole("ADMIN")
                    .antMatchers("/poczty_admin").hasRole("ADMIN")
                    .antMatchers("/pracownicy_admin").hasRole("ADMIN")
                    .antMatchers("/umowy_admin").hasRole("ADMIN")

                    .antMatchers("/adresy_new").hasRole("ADMIN")
                    .antMatchers("/karty_sim_new").hasRole("ADMIN")
                    .antMatchers("/klienci_new").hasRole("ADMIN")
                    .antMatchers("/oferty_new").hasRole("ADMIN")
                    .antMatchers("/plany_komorkowe_new").hasRole("ADMIN")
                    .antMatchers("/poczty_new").hasRole("ADMIN")
                    .antMatchers("/pracownicy_new").hasRole("ADMIN")
                    .antMatchers("/umowy_new").hasRole("ADMIN")

                    .antMatchers("/adresy_edit").hasRole("ADMIN")
                    .antMatchers("/karty_sim_edit").hasRole("ADMIN")
                    .antMatchers("/klienci_edit").hasRole("ADMIN")
                    .antMatchers("/oferty_edit").hasRole("ADMIN")
                    .antMatchers("/plany_komorkowe_edit").hasRole("ADMIN")
                    .antMatchers("/poczty_edit").hasRole("ADMIN")
                    .antMatchers("/pracownicy_edit").hasRole("ADMIN")
                    .antMatchers("/umowy_edit").hasRole("ADMIN")

                    .antMatchers("/adresy_update").hasRole("ADMIN")
                    .antMatchers("/karty_update").hasRole("ADMIN")
                    .antMatchers("/klienci_update").hasRole("ADMIN")
                    .antMatchers("/oferty_update").hasRole("ADMIN")
                    .antMatchers("/plany_komorkowe_update").hasRole("ADMIN")
                    .antMatchers("/poczty_update").hasRole("ADMIN")
                    .antMatchers("/pracownicy_update").hasRole("ADMIN")
                    .antMatchers("/umowy_update").hasRole("ADMIN")
                    .antMatchers("/adresy_delete").hasRole("ADMIN")
                    .antMatchers("/karty_sim_delete").hasRole("ADMIN")
                    .antMatchers("/klienci_delete").hasRole("ADMIN")
                    .antMatchers("/oferty_delete").hasRole("ADMIN")
                    .antMatchers("/plany_komorkowe_delete").hasRole("ADMIN")
                    .antMatchers("/poczty_delete").hasRole("ADMIN")
                    .antMatchers("/pracownicy_delete").hasRole("ADMIN")
                    .antMatchers("/umowy_delete").hasRole("ADMIN")

                    .antMatchers( "/konto" ).access( "hasRole('USER' )")
                    .antMatchers( "/konto_edit" ).access( "hasRole('USER' )")
                    .antMatchers( "/main_user", "/rejestracja", "plany", "pomoc" ).permitAll()
                    .antMatchers( "/resources/static/**" ).permitAll()

//                .antMatchers("/main_user").access("hasRole('USER')")
                    .and()
                    .formLogin()
                    .loginPage( "/login" )
                    .defaultSuccessUrl( "/main" )
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl( "/logout" )
                    .logoutSuccessUrl( "/main" )
                    .permitAll();
        }
    }
}
