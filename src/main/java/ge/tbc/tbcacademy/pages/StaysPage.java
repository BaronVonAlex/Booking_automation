package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.utils.Util;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StaysPage {
    public SelenideElement searchContainer = $(".hero-banner-searchbox");

    public SelenideElement destinationInput = searchContainer.$("div[data-testid='destination-container']").$("input"),
            searchDatePicker = $("[data-testid=\"searchbox-dates-container\"] "),
            calendar = $("#calendar-searchboxdatepicker"),
            prevMonthArrowBtn = $("[aria-label=\"Previous month\"]"),
            nextMonthArrowBtn = $("[aria-label=\"Next month\"]"),
            flexibleDatesContainer = $("[data-testid='flexible-dates-container']"),
            sataPickerCalendarTab = searchDatePicker.$("[aria-controls=\"calendar-searchboxdatepicker\"]"),
            sataPickerFlexibleTab = searchDatePicker.$("[aria-controls=\"flexible-searchboxdatepicker\"]"),
            searchButton = searchContainer.$("[type=\"submit\"]"),
            startDate = searchDatePicker.$("[data-testid=\"date-display-field-start\"] span"),
            endDate = searchDatePicker.$("[data-testid=\"date-display-field-end\"] span"),


    occupancyConfiguration = $("[data-testid=\"occupancy-config\"]"),
            occupancyPopup = $("[data-testid=\"occupancy-popup\"]"),
            occupancyConfigSummery = $("[data-testid=\"occupancy-config-icon\"]").parent(),

    childrenOptions = $("input[id=\"group_children\"]"),
            addChild = childrenOptions.parent().$("div button", 1),
            removeChild = childrenOptions.parent().$("div button", 0),
            childrenCount = childrenOptions.parent().$("div button ~span");

    public SelenideElement childAgeDropdown = occupancyPopup.$("[data-testid=\"kids-ages\"] div:last-child div:last-child select");
    public SelenideElement
            searchResult = $x("//div[text()=\"Search results\"]"),
            moreResultsBtn = $x("//*[text()='Load more results']/..");
    public ElementsCollection
            properties = $$("[data-testid=\"property-card\"]"),
            offerLocations = $$("[data-testid=\"address\"]"),
            occupancyConfigs = $$("[data-testid=\"price-for-x-nights\"]");    public SelenideElement adultsOptions = $x("//input[@id=\"group_adults\"]").parent(),
            removeAdults = adultsOptions.$("button", 0),
            addAdults = adultsOptions.$("button", 1),
            adultsCount = adultsOptions.$("div button ~span"),

    roomOptions = $("#no_rooms").parent(),
            addRoom = roomOptions.$("button", 1),
            removeRoom = roomOptions.$("button", 0),
            roomCount = roomOptions.$("button ~span"),

    withPets = occupancyPopup.$("[for=\"pets\"]"),
            occupancyConfigDoneBtn = occupancyPopup.$(byText("Done")).parent();
    public ElementsCollection destinationDropdown = $$("[data-testid=\"autocomplete-results-options\"] [id*='autocomplete-result']");

    public SelenideElement findInDestDropDown(String destination) {
        return destinationDropdown.find(Condition.text(destination));
    }

    public SelenideElement getDateFormCalendar(String date, String month, String year) {
        return $("[aria-label='" + Util.getCalendarFormatDate(date, month, year) + "']");
    }




}
