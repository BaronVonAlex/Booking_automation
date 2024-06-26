package ge.tbc.tbcacademy.pages.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderSection {
    public SelenideElement
            bookingHomeHeader = $x("//a[@data-testid='header-booking-logo']"),
            registerBtn = $x("//a[@data-testid='header-sign-up-button']"),
            loginBtn = $x("//a[@data-testid='header-sign-in-button']"),
            languageBtn = $x("//button[@data-testid='header-language-picker-trigger']");

    public ElementsCollection
            languages = $$x("//button[@data-testid='selection-item']");
}
