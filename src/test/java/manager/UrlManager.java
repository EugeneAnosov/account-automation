package manager;

public class UrlManager {

    public enum Url{
        BASEURL("https://services601-account.sandbox.similarweb.com/"),
        LOGINPAGE("login"),
        FORGOTPASSWORD("forgotpassword"),
        REGISTRATIONPAGE("registration"),
        LEGALPAGE("corp/legal/terms"),
        PRIVACYPOLICY("corp/legal/privacy-policy/");

        private String url;

        Url(String url){
            this.url = url;
        }

        public String getUrl() {
            return url;}
        }
}
