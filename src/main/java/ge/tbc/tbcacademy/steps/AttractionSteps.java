package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.AttractionsPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AttractionSteps extends HelperSteps<AttractionSteps> {
    AttractionsPage attractionsPage = new AttractionsPage();
    @Step("Navigate To Attraction Page")
    public AttractionSteps goToAttractions(){
        attractionsPage.attractionsBtn.should(appear)
                .shouldBe(clickable).click();
        return this;
    }
    @Step("Page Is Laded")
    public AttractionSteps checkPageIsLoaded(){
        attractionsPage.registerBtn.should(appear);
        return this;
    }
    @Step("Page Is Laded")
    public AttractionSteps checkResultsAreReady(){
        attractionsPage.products.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("CLick On destination Search input")
    public AttractionSteps clickOnDestinatoinInput(){
        attractionsPage.destinationSearchInput.should(exist)
                .shouldBe(visible).shouldBe(clickable).scrollTo().click();
        return this;
    }
    @Step("type in input {0}")
    public AttractionSteps enterInput(String dest){
        attractionsPage.destinationSearchInput.sendKeys(dest);
        return this;
    }

    @Step("Select Locstion with text {0}")
    public AttractionSteps selectOption(String dest){
        attractionsPage.selectLocatoinOption(dest).shouldBe(visible);
        executeJavaScript("arguments[0].click();", attractionsPage.selectLocatoinOption(dest));

        return this;
    }

    @Step("click on search")
    public AttractionSteps clickOnSearch(){
        attractionsPage.searchBtn.shouldBe(visible).shouldBe(clickable).hover();
        executeJavaScript("arguments[0].click();", attractionsPage.searchBtn);

        return this;
    }

    @Step("Check all have same location {0}")
    public void allAttractionsShouldContainDest(String dest) {
        for(SelenideElement p : attractionsPage.products){
            p.scrollTo();
            p.$(withText(dest)).should(exist);
        }
    }
}
