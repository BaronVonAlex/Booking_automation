package ge.tbc.tbcacademy.listeners;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AllureScreenshotListener implements ITestListener {

    private final AllureSelenide allureSelenide;

    public AllureScreenshotListener() {
        this.allureSelenide = new AllureSelenide()
                .screenshots(true)
                .savePageSource(false);
        SelenideLogger.addListener("AllureSelenide", allureSelenide);
    }

    private InputStream captureScreenshotAsStream(WebDriver driver) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return new ByteArrayInputStream(screenshotBytes);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        saveScreenshot("Failed test screenshot");
    }

    private void saveScreenshot(String attachmentName) {
        InputStream screenshotStream = captureScreenshotAsStream(WebDriverRunner.getWebDriver());
        Allure.addAttachment("Failed test screenshot", "image/png", screenshotStream, ".png");
    }
}


