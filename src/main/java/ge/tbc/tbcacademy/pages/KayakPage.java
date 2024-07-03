package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class KayakPage {
    public SelenideElement
            airlinesOnlyCheckBox = $("input[name=\"ONLY_DIRECT\"]"),
            cheapest = $x("//span[contains(text(), 'Cheapest')]"),
            searchResultsContainer = $("div.resultsListCover.tl");

    public ElementsCollection
            prices = $$("div.above-button span.price-text"),
            deals = $$("a[aria-label=\"View Deal\"]");
}
