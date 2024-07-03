package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {
    public SelenideElement
            managePersonalDetailsBtn = $("#mysettings_personal_details_title"),
            accountMailAddress = $("div[data-test-id=\"mysettings-row-email\"] .my-settings-flex-grow .comp-container__element div:last-child");
}
