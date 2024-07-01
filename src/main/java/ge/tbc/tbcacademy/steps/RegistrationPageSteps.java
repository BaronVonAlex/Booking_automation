package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.RegisterPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static ge.tbc.tbcacademy.data.constants.RegistrationConstants.*;

public class RegistrationPageSteps extends HelperSteps<RegistrationPageSteps> {
    RegisterPage registerPage = new RegisterPage();

    @Step("Click on Submit Button.")
    public RegistrationPageSteps clickOnSubmitBtn() {
        registerPage.submitBtn.click();
        return this;
    }

    @Step("Clear Input Field before inputting Data {0}")
    public RegistrationPageSteps clearInputField(SelenideElement element) {
        if (Util.isMacOS()){
            element.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        }else {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
        return this;
    }

    @Step("Input text on Mail input field. {0}")
    public RegistrationPageSteps inputMailAddress(String mail) {
        registerPage.emailInputField.sendKeys(mail);
        return this;
    }

    @Step("Validate if Error Message shows up on Incorrectly put Mail.")
    public RegistrationPageSteps getIncorrectMailMsg(){
        registerPage.gmailErrorMessage.shouldHave(anyOf(
                text(INVALID_MAIL_FORMAT_ERR_MSG_SECOND_VARIANT),
                text(INVALID_MAIL_FORMAT_ERR_MSG)
        ));
        return this;
    }

    @Step("Input Password on Main Password Field. {0}")
    public RegistrationPageSteps inputPassword(String password) {
        registerPage.passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Input Password on Confirmation Password Field. {0}")
    public RegistrationPageSteps inputConfirmationPassword(String password) {
        registerPage.confirmationPasswordInputField.sendKeys(password);
        return this;
    }

    @Step("Return Error Message from Incorrectly put Password. {0}")
    public RegistrationPageSteps validateIncorrectFormatPasswordFields(String text) {
        registerPage.passwordErrorMessage.shouldHave(text(text));
        return this;
    }

    @Step("Get Error Message from Un-matching Passwords and validate it.")
    public RegistrationPageSteps validateIfNonMatchingPasswordsShowErrMsg() {
        registerPage.confirmPasswordErrorMessage.shouldHave(anyOf(
                text(PASSWORDS_DID_NOT_MATCH_ERR_MSG_SECOND_VARIANT),
                text(PASSWORDS_DID_NOT_MATCH_ERR_MSG)));
        return this;
    }

    @Step("Validate if Are you Robot Text is shown.")
    public RegistrationPageSteps validateRobotActions() {
        registerPage.areYouRobotText.shouldBe(visible);
        return this;
    }
}
