package ge.tbc.tbcacademy.data.dataproviders;

import org.testng.annotations.DataProvider;

public class LanguageDataProvider {
    @DataProvider(name = "languageDataProvider")
    public static Object[][] languageData() {
        return new Object[][]{
                {"Español", "es"},
                {"Deutsch", "de"},
                {"Türkçe", "tr"}
        };
    }
}
