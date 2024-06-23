package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    @Step("Close Sign/register In Suggestion Popup")
    public MainPageSteps closeSignInPopUp(){
        if(mainPage.closeSignInButton.isDisplayed()) {
            mainPage.closeSignInButton.hover().click();
        }
        return this;
    }
}
