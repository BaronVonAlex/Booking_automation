package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.RegisterPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class RegistrationPageSteps extends HelperSteps<RegistrationPageSteps> {
    RegisterPage registerPage = new RegisterPage();

    @Step("Click on Submit Button.")
    public RegistrationPageSteps clickOnSubmitBtn() {
        registerPage.submitBtn.click();
        return this;
    }

    @Step("Clear Input Field before inputting Data {0}")
    public RegistrationPageSteps clearInputField(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        return this;
    }

    @Step("Input text on Mail input field. {0}")
    public RegistrationPageSteps inputMailAddress(String mail) {
        registerPage.emailInputField.sendKeys(mail);
        return this;
    }

    @Step("Validate if Error Message shows up on Incorrectly put Mail. {0}")
    public RegistrationPageSteps getIncorrectMailMsg(String text) {
        registerPage.gmailErrorMessage.shouldHave(text(text));
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

    @Step("Get Error Message from Un-matching Passwords and validate it. {0}")
    public RegistrationPageSteps validateIfNonMatchingPasswordsShowErrMsg(String text) {
        registerPage.confirmPasswordErrorMessage.shouldHave(text(text));
        return this;
    }

    @Step("Validate if Are you Robot Text is shown.")
    public RegistrationPageSteps validateRobotActions() {
        registerPage.areYouRobotText.shouldBe(visible);
        return this;
    }

    @Step("Clear Browsing Cookies.")
    public RegistrationPageSteps clearBrowserCookies() {
        Selenide.clearBrowserCookies();
        return this;
    }

    @Step("Press and Hold Anti-Bot button")
    public RegistrationPageSteps pressAndHoldAntiBotBtn() {
        Selenide.actions()
                .moveToElement(registerPage.robotPressAndHoldBtn)
                .clickAndHold()
                .pause(8000)
                .release()
                .perform();
        return this;
    }
}
