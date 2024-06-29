package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.config.ConfigTests;
import ge.tbc.tbcacademy.data.dataproviders.LanguageDataProvider;
import ge.tbc.tbcacademy.steps.MainPageSteps;
import ge.tbc.tbcacademy.steps.common.HeaderSectionSteps;
import ge.tbc.tbcacademy.steps.detectLanguageApi.DetectLanguageApiSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Website Localization")
public class LanguageTests extends ConfigTests {
    HeaderSectionSteps headerSectionSteps;
    MainPageSteps mainPageSteps;
    DetectLanguageApiSteps detectLanguageApiSteps;

    @BeforeMethod
    public void setUp() {
        headerSectionSteps = new HeaderSectionSteps();
        mainPageSteps = new MainPageSteps();
        detectLanguageApiSteps = new DetectLanguageApiSteps();
        mainPageSteps.openBookingWebPage();
    }

    @Test(description = "Language Change Test", dataProvider = "languageDataProvider", dataProviderClass = LanguageDataProvider.class)
    @Feature("Language Settings")
    @Story("Language Change Functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Changes the website language to Spanish and verifies that the page content is displayed in Spanish.")
    public void languageChangeTest(String language, String code) {
        mainPageSteps.closeSignInPopUp();
        headerSectionSteps
                .clickLanguageFlag()
                .chooseFlag(language);
        mainPageSteps.closeSignInPopUp();

        detectLanguageApiSteps
                .detectLanguage(mainPageSteps.getMainPageHeader())
                .validateLanguageWithCode(code);
    }
}
