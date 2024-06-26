package ge.tbc.tbcacademy.data;

import com.github.javafaker.Faker;

public class RandomCredentials {
    private static final Faker faker = new Faker();
    public static final String
            VALID_MAIL_FORMAT = faker.internet().emailAddress(),
            PASSWORD_SHORT = faker.internet().password(1, 4, false, false, false),
            PASSWORD_NUM = faker.internet().password(10, 12, false, false, false),
            PASSWORD_WITHOUT_UPPER = faker.internet().password(10, 12, false, false, true),
            VALID_PASSWORD = faker.internet().password(10, 12, true, false, true);
}
