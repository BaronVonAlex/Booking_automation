package ge.tbc.tbcacademy.pages.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderSection {
    public SelenideElement
            headerLogo = $("a[data-testid=\"header-booking-logo\"]"),
            headerBackground = $("div[data-testid=\"web-shell-header-mfe\"] > header "),
            bookingHomeHeader = $("a[data-testid=\"header-booking-logo\"]"),
            registerBtn = $("a[data-testid=\"header-sign-up-button\"]"),
            loginBtn = $("a[data-testid=\"header-sign-in-button\"]"),
            languageBtn = $("button[data-testid=\"header-language-picker-trigger\"]"),
            listPropertyBtn = $("a[data-testid=\"header-custom-action-button\"]"),
            customerSupportBtn = $("a[data-testid=\"header-help-center\"]"),
            changeLangBtn = $("button[data-testid=\"header-language-picker-trigger\"]"),
            changeCurrencyBtn = $("button[data-testid=\"header-currency-picker-trigger\"]"),
            flightsBtn = $("#flights"),
            carRentalBtn = $("#cars"),
            attractionsBtn = $("#attractions"),
            airportTaxisBtn = $("#airport_taxis"),
            carRental = $("a[href='https://www.booking.com/cars.html']");

    public ElementsCollection
            languages = $$("button[data-testid=\"selection-item\"]"),
            navbarItems = $$("div[data-testid=\"web-shell-header-mfe\"] header li a ");
}
