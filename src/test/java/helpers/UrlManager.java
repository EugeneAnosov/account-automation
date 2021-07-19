package helpers;

import static helpers.UserManager.driverConfig;

public class UrlManager {

    public static final String BASEURL = driverConfig.getBaseUrl();;
    public static final String LOGINPAGE = "login";
    public static final String FORGOTPASSWORD = "forgotpassword";
    public static final String REGISTRATIONPAGE = "registration";
    public static final String LEGALPAGE = "corp/legal/terms";
    public static final String PRIVACYPOLICY = "corp/legal/privacy-policy/";
}
