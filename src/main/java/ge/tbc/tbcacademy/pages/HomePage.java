package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement
            userAccount = $x("//div[contains(text(), 'Your account')]"),
            dialogXBtn = $x("//div[@role='dialog']//button"),
            inputField = $("input[id=\":re:\"]"),
            dateInputField = $("button[data-testid=\"date-display-field-start\"]"),
            dateInputFieldText = dateInputField.$("span"),
            searchSubmitBtn = $("button[type=\"submit\"]"),
            searchSubmitBtnText = searchSubmitBtn.$("span"),
            exploreBtn = $("a[data-testid=\"promotional-banner-content-cta\"]"),
            instantDiscountSignInBtn = $x("//span[text()='Sign in']/ancestor::a"),
            signInBtnText = instantDiscountSignInBtn.$("span"),
            instantDiscountRegisterBtn = $x("//span[text()='Register']/ancestor::a"),
            registerBtnText = instantDiscountRegisterBtn.$("span"),
            backgroundImage = $("img[data-testid=\"herobanner-image\"]"),
            userAccountBtn = $("div[aria-label=\"Your account menu Your account Genius Level 1\"]"),
            manageAccountBtn = $x("//span[text()='Manage account']");
}
