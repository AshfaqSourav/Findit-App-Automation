package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

        public static void captureScreenshot(WebDriver driver, String testName) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String screenshotPath = "failureScreenshots/" + testName + "_" + timestamp + ".png";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);

            try {
                FileUtils.copyFile(srcFile, destFile);
                System.out.println("✅ Screenshot saved at: " + destFile.getAbsolutePath()); // Debugging log
            } catch (IOException e) {
                System.out.println("❌ Failed to save screenshot: " + e.getMessage());
            }
        }
    public static void attachScreenshotToAllure(WebDriver driver, String name) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        if (driver instanceof TakesScreenshot) {
            Allure.addAttachment("Failure ScreenShot - "+ name + "_"+timestamp,
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            System.out.println("✅ Screenshot successfully attached to Allure via Lifecycle.");
        } else {
            System.out.println("❌ WebDriver does not support screenshots.");
        }
    }
}
