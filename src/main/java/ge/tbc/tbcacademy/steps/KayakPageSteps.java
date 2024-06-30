package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcacademy.pages.KayakPage;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class KayakPageSteps extends HelperSteps<KayakPageSteps> {
    KayakPage kayakPage = new KayakPage();

    @Step("Scroll to and check the 'Airlines Only' checkbox to filter results")
    public KayakPageSteps checkAirlinesOnlyCheckBox() {
        scrollToElementUsingJavascript(kayakPage.airlinesOnlyCheckBox);
        executeJavaScript("arguments[0].click();", kayakPage.airlinesOnlyCheckBox);
        return this;
    }

    @Step("Scroll to and click the 'Cheapest' button to sort by price")
    public KayakPageSteps clickCheapestButton() {
        scrollToElementUsingJavascript(kayakPage.cheapest);
        kayakPage.cheapest.click();
        return this;
    }

    @Step("Get a list of flight prices as integers from the search results")
    public List<Integer> getPrices() {
        List<Integer> prices = new ArrayList<>();
        kayakPage.prices.forEach(element -> {
            String text = element.getText();
            // get integer from text
            Matcher matcher = Pattern.compile("\\d+").matcher(text);
            if (matcher.find()) {
                int price = Integer.parseInt(matcher.group());
                prices.add(price);
            }
        });
        return prices;
    }

    @Step("Wait for the search results container to load")
    public KayakPageSteps waitForComponentLoad() {
        kayakPage.searchResultsContainer.shouldBe(visible);
        return this;
    }

    @Step("Click the first deal in the list of search results")
    public KayakPageSteps clickFirstDeal() {
        kayakPage.deals.first().click();
        return this;
    }

    @Step("Validate that a new browser window has opened")
    public KayakPageSteps validateThatNewWindowOpened() {
        Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        Assert.assertTrue(windowHandles.size() > 1);
        return this;
    }


}
