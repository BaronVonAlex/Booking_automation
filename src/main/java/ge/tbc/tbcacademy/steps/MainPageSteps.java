package ge.tbc.tbcacademy.steps;


import ge.tbc.tbcacademy.pages.MainPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

public class MainPageSteps extends HelperSteps<MainPageSteps> {
    MainPage mainPage = new MainPage();

    @Step("Return main Page header and subtitle")
    public String getMainPageHeader() {
        return String.format("%s %s", mainPage.mainHeader.getText(), mainPage.headerSubTitle.getText());
    }
}
