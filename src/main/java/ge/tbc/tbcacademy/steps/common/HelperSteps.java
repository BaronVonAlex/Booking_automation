package ge.tbc.tbcacademy.steps.common;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcacademy.data.Constants.BOOKING_URL;
import static ge.tbc.tbcacademy.data.JSScripts.REMOVE_DIALOG_ELEMENT_SCRIPT;
import static ge.tbc.tbcacademy.utils.Util.getPseudoElementStyle;
import static org.testng.Assert.assertNotEquals;

public class HelperSteps<T> {

    HomePage homePage = new HomePage();

    @Step("Open Booking.com Webpage.")
    public T openBookingWebPage() {
        open(BOOKING_URL);

        return (T) this;
    }

    @Step("Close Login/Register Prompt Popup.")
    public T closeSignInPopUp() {
        executeJavaScript(REMOVE_DIALOG_ELEMENT_SCRIPT);

        if (homePage.dialogXBtn.is(visible)) {
            homePage.dialogXBtn.click();
            homePage.dialogXBtn.should(disappear);
        }
        return (T) this;
    }

    @Step("Validate Element Value: Element {0}, Attribute {1}, Attr. Value: {2}")
    public T validateElementValue(SelenideElement element, String attribute, String attributeValue) {
        element.shouldHave(attribute(attribute, attributeValue));
        return (T) this;
    }

    @Step("Validate if element is present on webpage. {0}")
    public T validateIfElementExists(SelenideElement element) {
        element.shouldBe(visible);
        element.should(exist);
        return (T) this;
    }

    @Step("Validate if Element has proper Color. {0}")
    public T validateElementColor(SelenideElement element, String expectedColor) {
        element.shouldHave(cssValue("background-color", expectedColor));
        return (T) this;
    }

    @Step("Validate if Color Changes while Hovering Element. {0}")
    public T validateHoverEffectColorChange(SelenideElement element) {
        String originalColorValue = getPseudoElementStyle(element);
        element.hover();
        String afterHoverColor = getPseudoElementStyle(element);

        assertNotEquals(originalColorValue, afterHoverColor);

        return (T) this;
    }

    @Step("Validate if Element has proper Text. {1}")
    public T validateElementText(SelenideElement element, String expectedText) {
        element.shouldHave(text(expectedText));
        return (T) this;
    }
}
