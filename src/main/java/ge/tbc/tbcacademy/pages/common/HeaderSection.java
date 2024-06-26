package ge.tbc.tbcacademy.pages.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderSection {
    public SelenideElement
            registerBtn = $x("//a[@data-testid='header-sign-up-button']"),
            loginBtn = $x("//a[@data-testid='header-sign-in-button']");
}
