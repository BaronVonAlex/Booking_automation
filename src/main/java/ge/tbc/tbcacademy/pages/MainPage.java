package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement
            mainHeader = $("header h1"),
            headerSubTitle = $("p[data-testid=\"herobanner-subtitile\"]");
}
