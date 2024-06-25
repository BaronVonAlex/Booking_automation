package ge.tbc.tbcacademy.steps.common;

import com.codeborne.selenide.WebElementCondition;
import ge.tbc.tbcacademy.pages.PopUps;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PopUpSteps extends HelperSteps {
    protected PopUps popUps = new PopUps();

    @Step("Check google Sign in popup is present")
    public boolean googlePopupIsDisplayed() throws InterruptedException {

        return popUps.googleSignInPopup.isDisplayed();
    }
    @Step("Dismiss google Sign in popup if present")
    public PopUpSteps closeGoogleSignInPopUp(){
        popUps.googleSignInPopUpX.shouldBe(clickable).click();
        return this;
    }
    @Step("Make Sure the Popup Is Displayed")
    public void popupIsPresent(){
        popUps.geniusSignInPopUp.shouldBe(visible);
    }
    @Step("Check Genius sign in to save popup is present")
    public boolean geniusPopUpIsDisplayed(){
        //popUps.geniusSignInPopUp.shouldBe(visible);
        return  popUps.geniusSignInPopUp.isDisplayed();
    }
    @Step("Dismiss Genius sign in to save popup if present")
    public PopUpSteps dismissGeniusSaveUpPopUp(){
        $("body").shouldBe(interactable);
        popUps.geniusSignInPopUpXBtn.shouldBe(clickable).click();
        return this;
    }
}
