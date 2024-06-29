package ge.tbc.tbcacademy.steps.detectLanguageApi;

import ge.tbc.tbcacademy.data.models.ApiResponse;
import io.qameta.allure.Step;
import org.testng.Assert;

import static ge.tbc.tbcacademy.data.LanguageConstants.LANGUAGE_CODE_IS_NOT_SAME;
import static ge.tbc.tbcacademy.data.specBuilders.requestSpecs.detectLanguageRequestSpec;
import static io.restassured.RestAssured.given;

public class DetectLanguageApiSteps {
    ApiResponse apiResponse;

    @Step("Detect the language of the text: '{0}'")
    public DetectLanguageApiSteps detectLanguage(String text) {
        apiResponse = given()
                .spec(detectLanguageRequestSpec())
                .queryParam("q", text)
                .post()
                .as(ApiResponse.class);
        return this;
    }

    @Step("Validate that the detected language code is '{0}'")
    public void validateLanguageWithCode(String code) {
        Assert.assertEquals(apiResponse.data().detections().get(0).language(), code, LANGUAGE_CODE_IS_NOT_SAME);
    }
}
