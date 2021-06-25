package helpers;

import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class UserManager {

    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    public static final String BUSINESSEMAIL = driverConfig.getBusinessEmail();
    public static final String PASSWORD = driverConfig.getPassword();

    public static final String INVALIDBUSINESSEMAIL = driverConfig.getInvalidBusinessEmail();
    public static final String INVALIDPASSWORD = driverConfig.getInvalidBusinessPassword();
}
