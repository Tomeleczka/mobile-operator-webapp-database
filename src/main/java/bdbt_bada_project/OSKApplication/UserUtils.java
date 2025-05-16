package bdbt_bada_project.OSKApplication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static String getLoginText() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            // User is logged in
            return "Wyloguj";
        } else {
            // User is not logged in
            return "Zaloguj";
        }
    }
    public static Boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            // User is logged in
            return true;
        } else {
            // User is not logged in
            return false;
        }
    }
}

