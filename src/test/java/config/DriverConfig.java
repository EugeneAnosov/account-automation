package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/driver.properties"})
public interface DriverConfig extends Config {
    @Key("get.businessemail")
    String getBusinessEmail();

    @Key("get.password")
    String getPassword();

    @Key("get.invalidemail")
    String getInvalidBusinessEmail();

    @Key("get.invalidpassword")
    String getInvalidBusinessPassword();

    @Key("get.baseurl")
    String getBaseUrl();
}