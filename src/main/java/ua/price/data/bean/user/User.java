package ua.price.data.bean.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ua.price.properties.PropertyReader;

@Accessors(fluent = true, chain = true)
@Getter
@Setter
public class User {
    private String email;
    private String password;
    private String regEmail;
    private String regPassword;

    public User() {
        this.email = PropertyReader.getProperty("login_email");
        this.password = PropertyReader.getProperty("login_password");
        this.regEmail = PropertyReader.getProperty("reg_email");
        this.regPassword = PropertyReader.getProperty("reg_password");
    }
}
