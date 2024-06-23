package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement
            closeSignInButton = $x("//button[@aria-label=\"Dismiss sign-in info.\"]");
}
