package ge.tbc.tbcacademy.steps;

import ge.tbc.tbcacademy.pages.MyAccountPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static ge.tbc.tbcacademy.data.constants.SignInConstants.CORRECT_EMAIL;

public class MyAccountPageSteps {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Step
    public MyAccountPageSteps clickOnManagePersonDetails() {
        myAccountPage.managePersonalDetailsBtn.click();
        return this;
    }

    @Step
    public MyAccountPageSteps validateMailAddress() {
        myAccountPage.accountMailAddress.shouldHave(text(CORRECT_EMAIL));
        return this;
    }
}
