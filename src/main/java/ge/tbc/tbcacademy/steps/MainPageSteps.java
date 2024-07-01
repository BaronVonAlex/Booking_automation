package ge.tbc.tbcacademy.steps;


import ge.tbc.tbcacademy.pages.HomePage;
import ge.tbc.tbcacademy.pages.MainPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

import static ge.tbc.tbcacademy.data.UIConstants.*;

public class MainPageSteps extends HelperSteps<MainPageSteps> {
    MainPage mainPage = new MainPage();
    HomePage homePage = new HomePage();

    @Step("Return main Page header and subtitle")
    public String getMainPageHeader() {
        return String.format("%s %s", mainPage.mainHeader.getText(), mainPage.headerSubTitle.getText());
    }


    @Step("Validate background image's src attribute")
    public MainPageSteps validateBackgroundImageSrc() {
        validateElementValue(homePage.backgroundImage, ATTRIBUTE_SRC, BACKGROUND_IMG_SRC_VAL);
        return this;
    }

    @Step("Validate input field's placeholder attribute")
    public MainPageSteps validateInputFieldPlaceholder() {
        validateElementValue(homePage.inputField, ATTRIBUTE_PLACEHOLDER, HOME_INPUT_FIELD_ATR_VAL);
        return this;
    }

    @Step("Validate date input field's text")
    public MainPageSteps validateDateInputFieldText() {
        validateElementText(homePage.dateInputFieldText, CHECK_IN_TXT_VAL);
        return this;
    }

    @Step("Validate search submit button's text")
    public MainPageSteps validateSearchSubmitBtnText() {
        validateElementText(homePage.searchSubmitBtnText, SEARCH_TXT_VAL);
        return this;
    }

    @Step("Validate register button's text")
    public MainPageSteps validateRegisterBtnText() {
        validateElementText(homePage.registerBtnText, REGISTER_TXT_VAL);
        return this;
    }

    @Step("Validate sign in button's text")
    public MainPageSteps validateSignInBtnText() {
        validateElementText(homePage.signInBtnText, SIGN_IN_TXT_VAL);
        return this;
    }

    @Step("Validate if search submit button exists")
    public MainPageSteps validateSearchSubmitBtnExists() {
        validateIfElementExists(homePage.searchSubmitBtn);
        return this;
    }

    @Step("Validate if instant discount register button exists")
    public MainPageSteps validateInstantDiscountRegisterBtnExists() {
        validateIfElementExists(homePage.instantDiscountRegisterBtn);
        return this;
    }

    @Step("Validate if instant discount sign in button exists")
    public MainPageSteps validateInstantDiscountSignInBtnExists() {
        validateIfElementExists(homePage.instantDiscountSignInBtn);
        return this;
    }

    @Step("Validate if explore button exists")
    public MainPageSteps validateExploreBtnExists() {
        validateIfElementExists(homePage.exploreBtn);
        return this;
    }

    @Step("Validate search submit button's color")
    public MainPageSteps validateSearchSubmitBtnColor() {
        validateElementColor(homePage.searchSubmitBtn, SEARCH_BTN_COLOR_VAL);
        return this;
    }

    @Step("Validate instant discount register button's color")
    public MainPageSteps validateInstantDiscountRegisterBtnColor() {
        validateElementColor(homePage.instantDiscountRegisterBtn, INSTANT_DISCOUNT_LOG_AUTH_BTN_COLOR_VAL);
        return this;
    }

    @Step("Validate instant discount sign in button's color")
    public MainPageSteps validateInstantDiscountSignInBtnColor() {
        validateElementColor(homePage.instantDiscountSignInBtn, INSTANT_DISCOUNT_LOG_AUTH_BTN_COLOR_VAL);
        return this;
    }

    @Step("Validate hover effect color change for search submit button")
    public MainPageSteps validateHoverEffectColorChangeSearchSubmitBtn() {
        validateHoverEffectColorChange(homePage.searchSubmitBtn);
        return this;
    }

    @Step("Validate hover effect color change for explore button")
    public MainPageSteps validateHoverEffectColorChangeExploreBtn() {
        validateHoverEffectColorChange(homePage.exploreBtn);
        return this;
    }

    @Step("Validate hover effect color change for instant discount sign in button")
    public MainPageSteps validateHoverEffectColorChangeInstantDiscountSignInBtn() {
        validateHoverEffectColorChange(homePage.instantDiscountSignInBtn);
        return this;
    }

    @Step("Validate hover effect color change for instant discount register button")
    public MainPageSteps validateHoverEffectColorChangeInstantDiscountRegisterBtn() {
        validateHoverEffectColorChange(homePage.instantDiscountRegisterBtn);
        return this;
    }
}
