package ge.tbc.tbcacademy.booking;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ge.tbc.tbcacademy.booking.config.ConfigTests;
import ge.tbc.tbcacademy.data.constants.FilterConstants;
import ge.tbc.tbcacademy.steps.FilterAndSortSteps;
import ge.tbc.tbcacademy.steps.StaysPageSteps;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

@Epic("Functional Tests")
public class FilterAndSortTests extends ConfigTests {
    FilterAndSortSteps filterAndSort = new FilterAndSortSteps();
    SoftAssert softAssert = new SoftAssert();
    String URL;
    int stayDuration;

    public FilterAndSortTests(String url, int stayDuration) {
        this.URL = url;
        this.stayDuration = stayDuration;
    }


    @BeforeMethod(description = "Open browser and go to navigated page")
    public void launchBrowser() {
        open(URL);
        Configuration.timeout = 5000;
    }

    @Feature("Filter Functional")
    @Story("on property page choose breakfast included option from filters and check that all filtered options have it")
    @Severity(SeverityLevel.NORMAL)
    @Description("make sure all offers contain breakfast included option")
    @Test(groups = "filters")
    public void filterByBreakfastIncluded() {
        filterAndSort
                .pageHeaderIsLoaded()
                .chooseMealPlan(FilterConstants.BREAKFAST_INCLUDE)
                .loaderAppeared()
                .loaderDisappeared()
                .checkFilterIsSelectedNearSortDropdown()
                .checkThatOffersContain(FilterConstants.BREAKFAST_INCLUDE);
        // Breakfast Included
        Configuration.holdBrowserOpen = true;
        softAssert.assertAll();
    }

    @Feature("Sort Functional")
    @Story("On Offers page sort offers by distance form city center and that they are indeed sorted")
    @Severity(SeverityLevel.NORMAL)
    @Description("make sure that offers are sorted by distance from city center")
    @Test(groups = "sorting")
    public void sortByDistanceFromCenter() {
        filterAndSort
                .pageHeaderIsLoaded()
                .checkResultsPage()
                .checkResultsArePresent()
                .clickOnSortDropdown()
                .chooseOptionFromSortDropdown(FilterConstants.DISTANCE)
                .loaderAppeared()
                .loaderDisappeared()
                .checkCorrectOptionInChosen(FilterConstants.DISTANCE);

        Assert.assertTrue(filterAndSort.ditanceIsSorted(), FilterConstants.PROPERTY_NOT_SORTED_VIA_DISTANCE_MSG);
    }

    @Feature("Sort Functional")
    @Story("On Offers page sort offers by property star rating")
    @Severity(SeverityLevel.NORMAL)
    @Description("sort offers by property rating ascending and make sure offers are sorted")
    @Test(groups = "sorting")
    public void sortByRatingAsc() {
        Configuration.holdBrowserOpen = true;
        filterAndSort
                .pageHeaderIsLoaded()
                .checkResultsPage()
                .checkResultsArePresent()
                .clickOnSortDropdown()
                .checkDropdownIsOpen()
                .chooseOptionFromSortDropdown(FilterConstants.PROPERTY_RATING)
                .loaderAppeared()
                .loaderDisappeared()
                .checkCorrectOptionInChosen(FilterConstants.PROPERTY_RATING);

        Assert.assertTrue(filterAndSort.areSortedByRating(), FilterConstants.PROPERTY_NOT_SORTED_VIA_RATING);

    }

    @Flaky
    @Feature("Sort Functional")
    @Story("On Offers page sort offers by user rating")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sort offers by user review")
    @Test(groups = "sorting")
    public void sortByReviewAsc() {
        // sometimes appears, option sometimes not
        filterAndSort
                .pageHeaderIsLoaded()
                .checkResultsPage()
                .checkResultsArePresent()
                .clickOnSortDropdown()
                .checkDropdownIsOpen()
                .chooseOptionFromSortDropdown(FilterConstants.GUEST_REV)
                .loaderAppeared()
                .loaderDisappeared()
                .checkCorrectOptionInChosen(FilterConstants.GUEST_REV)
                .checkResultsArePresent();
        softAssert.assertTrue(filterAndSort.isSortedByReview(), FilterConstants.NOT_SORTED_REVS);


    }

    @Flaky
    @Feature("Sort Functional")
    @Story("On Offers page sort offers by user rating")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sort offers by user review")
    @Test(groups = "sorting")
    public void sortByTopReviewed() {
        // sometimes appears, option sometimes not
        filterAndSort
                .pageHeaderIsLoaded()
                .checkResultsPage()
                .checkResultsArePresent()
                .clickOnSortDropdown()
                .checkDropdownIsOpen()
                .chooseOptionFromSortDropdown(FilterConstants.REV_TOP)
                .loaderAppeared()
                .loaderDisappeared()
                .checkCorrectOptionInChosen(FilterConstants.REV_TOP)
                .checkResultsArePresent();
        softAssert.assertTrue(filterAndSort.isSortedByReview(), FilterConstants.NOT_SORTED_REVS);


    }

    @Feature("Sort Functional")
    @Story("On Offers page sort offers by price ascending")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sort offers by price ascending and make sure they are sorted")
    @Test(groups = "sorting")
    public void sortByPriceAsc() {
        filterAndSort
                .pageHeaderIsLoaded()
                .checkResultsPage()
                .checkResultsArePresent()
                .clickOnSortDropdown()
                .checkDropdownIsOpen()
                .chooseOptionFromSortDropdown(FilterConstants.PRICE_ASC)
                .loaderAppeared()
                .loaderDisappeared()
                .checkCorrectOptionInChosen(FilterConstants.PRICE_ASC);

        Assert.assertTrue(filterAndSort.priceIsSorted(), FilterConstants.PRICE_NOT_ACS);

    }

    @Feature("Sort Functional")
    @Story("On Offers page sort offers by price and review")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sort offers by Best reviewed and lowest price and make sure offers are sorted by review and those offers with same review are sorted by price ascending")
    @Test(groups = "sorting")
    public void sortByBestReviewAndLowestPriced() {
        filterAndSort
                .pageHeaderIsLoaded()
                .checkResultsPage()
                .checkResultsArePresent()
                .clickOnSortDropdown()
                .chooseOptionFromSortDropdown(FilterConstants.REV_PRICE)
                .loaderAppeared()
                .loaderDisappeared()
                .checkCorrectOptionInChosen(FilterConstants.REV_PRICE);

        softAssert.assertTrue(filterAndSort.priceReviewPriceSortIsCorrect(), FilterConstants.NOT_SORTED_REV_PRICE);
        softAssert.assertTrue(filterAndSort.isSortedByReview(), FilterConstants.NOT_SORTED_REVS);
        softAssert.assertAll();
        Configuration.holdBrowserOpen = true;
    }


    @Flaky
    @Feature("Filtering Functional")
    @Story("On Offers page choose price range and make sure the offers are in this range")
    @Severity(SeverityLevel.NORMAL)
    @Description("Offers are appropriately sorted after choosing price range")
    @Test(groups = "filters")
    public void filterByPriceRange() {
        filterAndSort
                .pageHeaderIsLoaded()
                .setMinPricePerDay(FilterConstants.MIN_PRICE)
                .loaderAppeared()
                .loaderDisappeared()
                .setMaxPricePerDay(FilterConstants.MAX_Price)
                .loaderAppeared()
                .loaderDisappeared()
                .checkResultsArePresent();

//        Assert.assertTrue(filterAndSort.pricesAreInPriceRange(FilterConstants.MIN_PRICE, FilterConstants.maxPrice, stayDuration));
        Assert.assertTrue(filterAndSort.pricesAreInPriceRange(FilterConstants.MIN_PRICE, FilterConstants.MAX_Price, stayDuration));

    }

    @AfterMethod(alwaysRun = true, description = "close browser")
    public void teardown() {
        Selenide.closeWindow();
    }

}
