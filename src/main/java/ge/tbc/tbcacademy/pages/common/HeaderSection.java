package ge.tbc.tbcacademy.pages.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderSection {
    public SelenideElement
            headerLogo = $x("//a[@data-testid='header-booking-logo']"),
            headerBackground = $x("//div[@data-testid='web-shell-header-mfe']/header"),
            bookingHomeHeader = $x("//a[@data-testid='header-booking-logo']"),
            registerBtn = $x("//a[@data-testid='header-sign-up-button']"),
            loginBtn = $x("//a[@data-testid='header-sign-in-button']"),
            listPropertyBtn = $x("//a[@data-testid='header-custom-action-button']"),
            customerSupportBtn = $x("//a[@data-testid='header-help-center']"),
            changeLangBtn = $x("//button[@data-testid='header-language-picker-trigger']"),
            changeCurrencyBtn = $x("//button[@data-testid='header-currency-picker-trigger']"),
            flightsBtn = $("#flights"),
            carRentalBtn = $("#cars"),
            attractionsBtn = $("#attractions"),
            airportTaxisBtn = $("#airport_taxis");
}
