package ge.tbc.tbcacademy.data;

import com.github.javafaker.Faker;

public class Constants {
    private static final Faker faker = new Faker();

    /**
     *  Links
     */
    public static final String BOOKING_URL = "https://www.booking.com/";


    /**
     * Error message constants
     */
    public static final String INVALID_BROWSER_PARAMETER_MESSAGE = "Invalid browser parameter. Supported values: firefox, chrome, edge";
    public static final String INVALID_MAIL_FORMAT_ERR_MSG = "Make sure the email address you entered is correct. ";
    public static final String SHORT_PASSWORD_ERR_MSG = "Your password must be at least 10 characters";
    public static final String CHARACTERS_ONLY_PASSWORD_ERR_MSG = "Your password must include at least one number";
    public static final String PASSWORD_WITH_NO_UPPERCASE_ERR_MSG = "Your password must include at least one uppercase letter";
    public static final String PASSWORDS_DID_NOT_MATCH_ERR_MSG = "The passwords you entered didn't match – try again";


    /**
     * Input Data
     */
    public static final String INVALID_MAIL_FORMAT = "gmail.@";
    public static final String VALID_MAIL_FORMAT = faker.internet().emailAddress();
    public static final String PASSWORD_SHORT = "pass";
    public static final String PASSWORD_NUM = "randompass";
    public static final String PASSWORD_WITHOUT_UPPER = "randompass123";
    public static final String VALID_PASSWORD = "QweQweR512ASD";

    /**
     * Expected Values
     */

    public static final String EXPECTED_WELCOME_POP_TXT = "Welcome to Genius! You just unlocked Level 1";
}
