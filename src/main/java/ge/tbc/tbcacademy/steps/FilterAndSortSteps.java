package ge.tbc.tbcacademy.steps;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.data.constants.FilterConstants;
import ge.tbc.tbcacademy.pages.FilterResultsPage;
import ge.tbc.tbcacademy.pages.common.HeaderSection;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FilterAndSortSteps extends HelperSteps<FilterAndSortSteps> {
    FilterResultsPage resultsPage = new FilterResultsPage();
    HeaderSection headerElements = new HeaderSection();

    @Step("Check Page Is Interactable")
    public FilterAndSortSteps pageHeaderIsLoaded() {
        headerElements.loginBtn.should(appear);
        headerElements.registerBtn.should(appear);
        return this;
    }

    @Step("Result Page Should Be Present")
    public FilterAndSortSteps checkResultsPage() {
        resultsPage.searchResultPage.shouldBe(visible);
        return this;
    }

    @Step("Check Tat Results Are Present")
    public FilterAndSortSteps checkResultsArePresent() {
        resultsPage.noOffersFound.shouldNotBe(visible);
        resultsPage.properties.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Click to open sort Dropdown")
    public FilterAndSortSteps clickOnSortDropdown() {
        resultsPage.sortDropdownBtn.shouldBe(visible).scrollTo()
                .hover().shouldBe(clickable);
        executeJavaScript("arguments[0].click();", resultsPage.sortDropdownBtn);
        return this;
    }

    @Step("choose {0} option from sort dropdown")
    public FilterAndSortSteps chooseOptionFromSortDropdown(String option) {
        resultsPage.sortDropdownOptions.shouldBe(visible);
        resultsPage.getCheckboxViaText(resultsPage.sortDropdownOptions, option)
                .shouldBe(allOf(visible, clickable)).click();
        return this;
    }

    @Step("Make sure correct option {0} was chosen in sort ")
    public FilterAndSortSteps checkCorrectOptionInChosen(String option) {
        resultsPage.sortDropdownBtn.shouldHave(innerText(option));
        return this;
    }

    @Step("Choose minimum price per day with slider {0}")
    public FilterAndSortSteps setMinPricePerDay(String minPrice) {
        while (!resultsPage.minPricePerDay.getValue().equals(minPrice)) {
            System.out.println(resultsPage.minPricePerDay.getValue());
            actions().clickAndHold(resultsPage.minPriceSlider)
                    .moveByOffset(10, 0).perform();
            actions().release().perform();
        }

        return this;
    }

    @Step("Choose maximum price per day with slider {0}")
    public FilterAndSortSteps setMaxPricePerDay(String maxPrice) {
        int i=0;
        String old = " ";
        while (!resultsPage.maxPricePerDay.getValue().equals(maxPrice)) {
            System.out.println(resultsPage.maxPricePerDay.getValue());
            if(resultsPage.maxPricePerDay.getValue().equals(old)){
                i++;
            }
            if(i > 10){
                break;
            }
            actions().clickAndHold(resultsPage.maxPriceSlider)
                    .moveByOffset(-10, 0).click().perform();
            actions().release().perform();
            old = resultsPage.maxPricePerDay.getValue();
        }

        return this;
    }

    @Step("Chose meal options {0}")
    public FilterAndSortSteps chooseMealPlan(String plan) {
        resultsPage.mealPlanContainer.should(appear).scrollTo();
        SelenideElement box = resultsPage.getCheckboxViaText(resultsPage.mealPlanContainer, plan)
                .should(exist)
                .scrollTo()
                .shouldBe(clickable)
                .shouldBe(visible)
                .hover();

        actions().click(box).perform();
        executeJavaScript("arguments[0].checked = true;", box.parent());
        return this;
    }

    @Step("Check filter has option {0} ")
    public FilterAndSortSteps checkThatOffersContain(String option) {
        for (SelenideElement offer : resultsPage.properties) {
            offer.scrollTo();
            offer.$(withTextCaseInsensitive(option)).should(exist).shouldBe(visible);
        }
        return this;
    }

    @Step("Check filter was selected")
    public FilterAndSortSteps checkFilterIsSelectedNearSortDropdown() {
        resultsPage.chosenFilters.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Make sure results are filtered by loader's appearance")
    public FilterAndSortSteps loaderAppeared() {
        resultsPage.loader.should(appear);
        if (!resultsPage.loader.isDisplayed()) {
            throw new RuntimeException("The results are not filtered, something went wrong");
        }
        return this;
    }

    @Step("Make sure filtering process is done by loader's disappearance")
    public FilterAndSortSteps loaderDisappeared() {
        resultsPage.loader.should(disappear);
        return this;
    }

    @Step("Make sure sort options dropdown was open after clicking on it")
    public FilterAndSortSteps checkDropdownIsOpen() {
        resultsPage.sortDropdownOptions.shouldBe(visible);
        return this;
    }

    @Step("Check that offers are sorted with ascending order from city center")
    public boolean ditanceIsSorted() {
        List<Double> dist = new ArrayList<>();
        try {
            for (SelenideElement d : resultsPage.distances) {
                d.scrollTo().shouldNotBe(empty);
                dist.add(Util.convertToMeter(d.getText()));
            }
            return Util.isSortedDoubles(dist);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(FilterConstants.FOROZE_MSG);
        }
    }

    @Step("Make sure offers reopen by star rating")
    public boolean areSortedByRating() {
        //[data-testid="rating-stars"] svg
        List<Integer> ratings = new ArrayList<>();
        for (SelenideElement d : resultsPage.properties) {
            d.scrollTo();
            ratings.add(Util.countStars(d, FilterConstants.STAR_LOCATOR));
        }
        System.out.println(ratings);
        return Util.isSorted(ratings);
    }

    @Step("Check offers are sorted via Price ascending order")
    public boolean priceIsSorted() {
        List<Integer> prices = Util.gerPropertyPrice(resultsPage.properties, FilterConstants.PROPERTY_PRICE_SELECTOR);

        return Util.isSorted(prices);
    }

    @Step("Check offers are sorted via review score ascending order")
    public boolean isSortedByReview() {
        Allure.addAttachment("Text Attachment", "text/plain", Util.getListOfScores(resultsPage.properties, FilterConstants.REVIE_SCORE_SELECTOR).toString());
        return Util.isSortedDoubles(Util.getListOfScores(resultsPage.properties, FilterConstants.REVIE_SCORE_SELECTOR));
    }

    @Step("Check offers are sorted via price ascending order and review score descending order")
    public boolean priceReviewPriceSortIsCorrect() {

        Set<Double> reviewScores = new HashSet<>(Util.getListOfScores(resultsPage.properties, FilterConstants.REVIE_SCORE_SELECTOR));
        System.out.println(reviewScores.stream().toList());

        boolean isSorted = true;

        for (double score : reviewScores) {
            ElementsCollection props = resultsPage.getPropertyWithScore(score);
            isSorted &= Util.isSorted(Util.gerPropertyPrice(props, FilterConstants.PROPERTY_PRICE_SELECTOR));
        }

        return isSorted;
    }

    @Step("Make sure prices are in range of {0} - {1}")
    public boolean pricesAreInPriceRange(String min, String max, int numberOfDays) {
        int minPrice = Util.parseStringToInt(min) / numberOfDays;
        int maxPrice = Util.parseStringToInt(max) / numberOfDays;
        List<Integer> prices = Util.gerPropertyPrice(resultsPage.properties, FilterConstants.PROPERTY_PRICE_SELECTOR);
        return minPrice <= Collections.min(prices) && maxPrice <= Collections.max(prices);
    }

}
