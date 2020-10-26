package steps;

import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class BaseStep {

    public static WebDriver driver;

    private static void addScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment("Скриншот", new FileInputStream(screenshot));
        }
        catch (FileNotFoundException e) {
            Allure.addAttachment("Скриншот", "Не удалось получить скриншот");
            e.printStackTrace();
        }
    }

    public static void customAssert(String message, boolean condition, WebDriver driver) {
        try { Assert.assertTrue(message, condition); }
        catch (AssertionError assertionError) {
            addScreenshot();
            throw new AssertionError(assertionError.getMessage());
        }
    }

    public static void customAssert(String message, String expected, String actual, WebDriver driver) {
        try { Assert.assertEquals(message, expected, actual); }
        catch (AssertionError assertionError) {
            addScreenshot();
            throw new AssertionError(assertionError.getMessage());
        }
    }
}
