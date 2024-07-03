package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement
            welcomeUserPopupMsg = $x("//div[@role='dialog']"),
            dialogXBtn = $x("//div[@role='dialog']//button"),
            inputField = $x("//input[@id=':re:']"),
            dateInputField = $x("//button[@data-testid='date-display-field-start']"),
            dateInputFieldText = dateInputField.$("span"),
            searchSubmitBtn = $x("//button[@type='submit']"),
            searchSubmitBtnText = searchSubmitBtn.$("span"),
            exploreBtn = $x("//a[@data-testid='promotional-banner-content-cta']"),
            instantDiscountSignInBtn = $x("//span[text()='Sign in']/ancestor::a"),
            signInBtnText = instantDiscountSignInBtn.$("span"),
            instantDiscountRegisterBtn = $x("//span[text()='Register']/ancestor::a"),
            registerBtnText = instantDiscountRegisterBtn.$("span"),
            backgroundImage = $x("//img[@data-testid='herobanner-image']"),
            userAccountBtn = $x("//div[@aria-label='Your account menu Your account Genius Level 1']"),
            manageAccountBtn = $x("//span[text()='Manage account']");
}
