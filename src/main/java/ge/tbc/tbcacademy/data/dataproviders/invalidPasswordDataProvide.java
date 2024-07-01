package ge.tbc.tbcacademy.data.dataproviders;

import org.testng.annotations.DataProvider;

import static ge.tbc.tbcacademy.data.RandomCredentials.*;
import static ge.tbc.tbcacademy.data.constants.RegistrationConstants.*;

public class invalidPasswordDataProvide {
    @DataProvider(name = "invalidPasswordData")
    public Object[][] invalidPasswordData() {
        return new Object[][]{
                {PASSWORD_SHORT, SHORT_PASSWORD_ERR_MSG},
                {PASSWORD_NUM, CHARACTERS_ONLY_PASSWORD_ERR_MSG},
                {PASSWORD_WITHOUT_UPPER, PASSWORD_WITH_NO_UPPERCASE_ERR_MSG}
        };
    }
}
