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
            destinationToText = $x("//input[@aria-label='Flight destination input']"),
            switchDestinationsButton = $(".zEiP-formField.zEiP-switch"),
            destinationTo = $(".zEiP-formField.zEiP-destination"),
            datesField = $(".zEiP-formField.zEiP-dates"),
            submitButton = $(".zEiP-formField.zEiP-submit.zEiP-stretch"),
            submitBtnColor = $x("//button[@title='Search']"),
            submitButtonColorValue = $x("//button[@class='Iqt3 Iqt3-mod-bold Button-No-Standard-Style Iqt3-mod-variant-solid Iqt3-mod-theme-progress Iqt3-mod-shape-rounded-medium Iqt3-mod-shape-mod-default Iqt3-mod-spacing-default Iqt3-mod-size-large Iqt3-mod-animation-search']"),
            submitButtonText = $x("//span[@class='']"),
            footer = $(".Su1_"),
            headerBackground = $(".UIM7"),
            originPlace = $(".c_neb-item-value");
}
