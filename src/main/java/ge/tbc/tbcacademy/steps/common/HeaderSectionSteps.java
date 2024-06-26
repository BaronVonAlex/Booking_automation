package ge.tbc.tbcacademy.steps.common;

import ge.tbc.tbcacademy.pages.common.HeaderSection;
import io.qameta.allure.Step;


public class HeaderSectionSteps extends HelperSteps<HeaderSectionSteps> {
    HeaderSection headerSection = new HeaderSection();
    @Step("Click on Register button.")
    public HeaderSectionSteps clickOnRegisterBtn() {
        headerSection.registerBtn.click();
        return this;
    }
    @Step("Click on Login button.")
    public HeaderSectionSteps clickSingInButton() {
        headerSection.loginBtn.click();
        return this;
    }
}
