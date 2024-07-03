package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {
    public SelenideElement
            managePersonalDetailsBtn = $("#mysettings_personal_details_title"),
            accountMailAddress = $("div[data-test-id=\"mysettings-row-email\"] .my-settings-flex-grow .comp-container__element div:last-child");
}
