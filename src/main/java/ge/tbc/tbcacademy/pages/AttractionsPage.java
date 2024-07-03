package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.common.HeaderSection;

import static com.codeborne.selenide.Selectors.withTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AttractionsPage extends HeaderSection {
    public SelenideElement destinationSearchInput = $("[name=\"query\"]"),
            searchBtn = $("button[type=\"submit\"]");
    public ElementsCollection products = $$("[aria-label=\"Product\"]");

    public SelenideElement selectLocatoinOption(String loc) {
        return $("div").find(withTextCaseInsensitive(loc));
    }
}
