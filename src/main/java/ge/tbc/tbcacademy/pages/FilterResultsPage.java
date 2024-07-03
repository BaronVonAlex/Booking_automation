package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;

public class FilterResultsPage {

    public SelenideElement
            loader = $("div [data-testid*=\"skeleton-loader\"]"),
            searchResultPage = $("#b2searchresultsPage"),
            elementsConstraint = searchResultPage.$("#bodyconstraint "),
            noOffersFound = $x("//div//*[contains(text(),'No properties')]"),
            loadMoreBtn = elementsConstraint.$(withTextCaseInsensitive("Load more")).ancestor("button"),

    sortDropdownBtn = searchResultPage.$("[data-testid=\"sorters-dropdown-trigger\"]"),//aria-expanded="true"
            sortDropdownOptions = searchResultPage.$("[data-testid=\"sorters-dropdown\"]"),

    priceFilterContainer = elementsConstraint.$("[id^=\"filter_group_price_\"]"),
            priceSliderContainer = priceFilterContainer.$("[data-testid=\"filters-group-slider\"]"),
            minPricePerDay = priceSliderContainer.$(" [aria-label=\"Min.\"]"),
            maxPricePerDay = priceSliderContainer.$(" [aria-label=\"Max.\"]"),
            maxPriceSlider = priceSliderContainer.$(" .d6ed9c72b9", 1),
            minPriceSlider = priceSliderContainer.$(" .d6ed9c72b9", 0),
            propertyRatingContainer = elementsConstraint.$("[id^=\"filter_group_class_\"]"),
            propertyReviewScore = elementsConstraint.$("[id^=\"filter_group_review_score_\"]"),
            reservationPolicyContainer = elementsConstraint.$("[id^=\"filter_group_fc_\"]"),
            bedPreferenceContainer = elementsConstraint.$("[id^=\"filter_group_tdb_\"]"),
            facilitiesContainer = elementsConstraint.$("[id^=\"filter_group_hotelfacility_\"]"),
            mealPlanContainer = elementsConstraint.$("[id^=\"filter_group_mealplan_\"]"),
            footer = $("#footer_menu_track");

    public ElementsCollection
            properties = elementsConstraint.$$("[aria-label=\"Property\"]"),
            offersAvailability = elementsConstraint.$$("[data-testid=\"availability-single\"]"),
            chosenFilters = $$("[data-testid^=\"filter:\"]"),
            distances = $$("[data-testid=\"distance\"]");

    ////*[@aria-label="Property"]//span[text()='Breakfast included']
    public SelenideElement getCheckboxViaText(SelenideElement container, String option) {
//        return container.$(byText(option));
//        return $x("//*[@id='bodyconstraint']//*[@data-testid=\"filters-group-label-container\"]//*[text()='Breakfast included']");
        return container.$(withTextCaseInsensitive((option)));
    }

    public ElementsCollection getPropertyWithScore(double score) {
        return $$x("//*[@aria-label=\"Property\"]//*[@data-testid=\"review-score\"]//*[text()='" + score + "']/ancestor::*[@aria-label=\"Property\"]");
    }
}
