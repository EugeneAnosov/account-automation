package helpers;

public class UserManager {

    public enum User {
        BUSINESSEMAIL("yevhen.anosov+automation@similarweb.com"),
        PASSWORD("Qwerty1"),

        INVALIDBUSINESSEMAIL("yevhen.anosov+automation1@similarweb.com"),
        INVALIDPASSWORD("Test1234");

        private String user;

        User(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }
}
