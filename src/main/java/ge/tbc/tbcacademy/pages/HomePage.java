package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement
            welcomeUserPopupMsg = $("h2[id$='-title'] strong"),
            dialogXBtn = $x("//div[@role='dialog']//button");
}
