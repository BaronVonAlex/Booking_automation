package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.HomePage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;

public class HomePageSteps extends HelperSteps<HomePageSteps> {
    HomePage homePage = new HomePage();

    @Step("Validate that Account was created.")
    public HomePageSteps validateIfAccountWasCreated() {
        homePage.welcomeUserPopupMsg.should(exist);
        return this;
    }

    @Step("Click no Profile")
    public HomePageSteps clickOnProfile() {
        homePage.userAccountBtn.should(exist);
        homePage.userAccountBtn.click();
        return this;
    }

    @Step("Click on Manage Account")
    public HomePageSteps clickOnManageAccount() {
        homePage.manageAccountBtn.click();
        return this;
    }
}
