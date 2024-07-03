package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FlightsPage {
    public SelenideElement
            backgroundDiv = $(".coverPhotoBackground"),
            languageBtn = $(".sIC5-country-picker"),
            currencyBtn = $(".sIC5-currency-picker"),
            flightsTitle = $(".title"),
            formSection = $(".form-section"),
            destinationFrom = $(".zEiP-formField.zEiP-origin"),
            destinationFromText = $x("//input[@aria-label='Flight origin input']"),
            destinationInput = $("input[aria-label=\"Flight destination input\"]"),
            switchDestinationsButton = $(".zEiP-formField.zEiP-switch"),
            destinationTo = $(".zEiP-formField.zEiP-destination"),
            datesField = $(".zEiP-formField.zEiP-dates"),
            submitButton = $(".zEiP-formField.zEiP-submit.zEiP-stretch"),
            submitBtnColor = $("button[title=\"Search\"]"),
            submitButtonText = $x("//span[@class='']"),
            footer = $(".Su1_"),
            headerBackground = $(".UIM7"),
            originPlace = $(".c_neb-item-value"),
            firstDestinationSuggestion = $x("//li[@role='option']"),
            searchButton = $("button[type=\"submit\"]"),
            returnDropDown = $x("//div/span[text()='Return' or text()='Round-trip']"),
            oneWayOption = $x("//li[@aria-label='One-way']");
}
