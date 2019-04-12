package hr.infobip.urlshortenertask.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Used for returning current user.
 */
public class AccountNameUtil {
    public static String getAuthUserAccountId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
