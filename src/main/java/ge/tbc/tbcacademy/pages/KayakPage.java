package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class KayakPage {
    public SelenideElement
            airlinesOnlyCheckBox = $x("//input[@name='ONLY_DIRECT']"),
            cheapest = $x("//span[contains(text(), 'Cheapest')]"),
            searchResultsContainer = $x("//div[@class='resultsListCover tl']");

    public ElementsCollection
            prices = $$x("//div[@class='above-button']//span[@class='price-text']"),
            deals = $$x("//a[@aria-label='View Deal']");
}
