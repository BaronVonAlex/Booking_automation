package ge.tbc.tbcacademy.steps.axeCore;

import com.codeborne.selenide.Selenide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ge.tbc.tbcacademy.steps.common.HelperSteps;
import ge.tbc.tbcacademy.utils.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static ge.tbc.tbcacademy.data.JSScripts.AXE_RUNNER_SCRIPT;

public class AxeCoreSteps extends HelperSteps<AxeCoreSteps> {
    Object rawAxeResults;

    @Step("Run Axe-core Accessibility Library in Browser")
    public AxeCoreSteps runAxeCoreLibraryInBrowser() {
        String axeContent = null;
        try {
            axeContent = new String(Files.readAllBytes(Paths.get("src/main/resources/axe.min.js")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Selenide.executeJavaScript(axeContent);
        return this;
    }

    @Step("Retrieve Axe-core Accessibility Audit Results")
    public AxeCoreSteps getAxeCoreAccessibilityAuditResults() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Selenide.webdriver().object();
        rawAxeResults = jsExecutor.executeAsyncScript(AXE_RUNNER_SCRIPT);
        return this;
    }

    @Step("Generate Accessibility Report from JSON Results")
    public AxeCoreSteps generateReportFromJsonResults() {
        Gson gson = new Gson();
        Map<String, Object> axeResults = gson.fromJson(gson.toJson(rawAxeResults), new TypeToken<Map<String, Object>>() {
        }.getType());
        try {
            Util.generateReport(axeResults);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
