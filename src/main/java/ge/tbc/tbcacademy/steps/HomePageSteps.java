package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.HomePage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

public class HomePageSteps extends HelperSteps<HomePageSteps> {
    HomePage homePage = new HomePage();

    @Step("Validate that Account was created.")
    public String validateIfAccountWasCreated() {
        return homePage.welcomeUserPopupMsg.getText();
    }
}
