package ge.tbc.tbcacademy.data.specBuilders;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static ge.tbc.tbcacademy.data.constants.LanguageConstants.DETECT_LANGUAGE_API;
import static ge.tbc.tbcacademy.data.constants.LanguageConstants.DETECT_LANGUAGE_API_KEY;

public class requestSpecs {
    public static RequestSpecification detectLanguageRequestSpec() {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .addHeader("Authorization", "Bearer " + DETECT_LANGUAGE_API_KEY)
                .setBaseUri(DETECT_LANGUAGE_API)
                .build();
    }
}
