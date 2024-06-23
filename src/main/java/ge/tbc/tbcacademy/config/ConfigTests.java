package ge.tbc.tbcacademy.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ge.tbc.tbcacademy.data.Constants.INVALID_BROWSER_PARAMETER_MESSAGE;

@Listeners({SoftAsserts.class})
public class ConfigTests {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(INVALID_BROWSER_PARAMETER_MESSAGE);
        }
        Configuration.timeout = 3000;
        Configuration.assertionMode = SOFT;
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        closeWebDriver();
    }
}
