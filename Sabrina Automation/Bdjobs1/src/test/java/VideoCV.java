import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VideoCV {

    public static void main(String[] arg) {
        // Set up ChromeOptions to include the ad blocker extension and permissions
        ChromeOptions options = new ChromeOptions();
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Suppress the "Chrome is being controlled by automated test software" message
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Validate if the extension file exists before adding it to ChromeOptions
        File extensionFile = new File(adblockerPath);
        if (extensionFile.exists() && extensionFile.isFile()) {
            options.addExtensions(extensionFile);
        }

        // Create a map to hold the preferences
        Map<String, Object> prefs = new HashMap<>();

        // Set permission for camera and microphone (1 = allow, 2 = block)
        Map<String, Object> contentSettings = new HashMap<>();
        contentSettings.put("media_stream_camera", 1); // Allow camera
        contentSettings.put("media_stream_mic", 1);    // Allow microphone

        // Add these content settings to the profile preferences
        prefs.put("profile.content_settings.exceptions.media_stream_camera.*.setting", 1);
        prefs.put("profile.content_settings.exceptions.media_stream_mic.*.setting", 1);

        // Add the preferences to ChromeOptions
        options.setExperimentalOption("prefs", prefs);

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();

            // Navigate to the SignIn page
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("avary");

            // Click Continue button
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("12345678");

            // Click Sign in button
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();

            // Wait for the Manage Profile dropdown to be clickable and click it
            WebElement manageProfileDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='manageResumeMenu']")));
            manageProfileDropdown.click();
            Thread.sleep(2000);

            // Wait for and click the Video CV link
            WebElement videoCV = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Video CV']")));
            videoCV.click();

            // Switch to the new tab for Video CV
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            // Close the popup tutorial if it appears
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='videoTutorialCloseBtn'] span[aria-hidden='true']")));
            closeButton.click();
            Thread.sleep(2000);

            // Optionally click the "Take Preparation" link
            WebElement takePreparation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Take Preparation']")));
            Thread.sleep(2000);
            takePreparation.click();
            Thread.sleep(2000);

            // Close the "Take Preparation" modal close
            WebElement crossButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoResumeTakePreparation']//button[@type='button'][normalize-space()='×']")));
            Thread.sleep(200);
            crossButton.click();
            Thread.sleep(2000);

            // Switch to the "User Guide" tab
            WebElement userGuide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='User Guide']")));
            userGuide.click();
            Thread.sleep(3000);

            // Switch to the newly opened User Guide tab
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            driver.close();

            // Switch back to the main window
            driver.switchTo().window(tabs.get(1));

            // Click on the "Video Guide" link
            WebElement videoGuide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Video Guide']")));
            videoGuide.click();
            Thread.sleep(3000);

            // Switch to the new tab for Video Guide
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            driver.close();
            Thread.sleep(2000);

            // Switch back to the main window
            driver.switchTo().window(tabs.get(1));

            // Click the "Create Video CV" button
            WebElement createVideoCv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='act-btn']")));
            createVideoCv.click();

            // Click on Sample Video
            WebElement sampleVideo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sample Video']")));
            sampleVideo.click();
            Thread.sleep(2000);

            // Close the Sample Video popup
            WebElement videoPopupClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='videoTutorialCloseBtn'] span[aria-hidden='true']")));
            videoPopupClose.click();
            Thread.sleep(2000);

            // Hover over the tooltip element
            WebElement tooltipElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='anstlnk']")));

            // Use Actions class to hover over the tooltip
            Actions action = new Actions(driver);
            action.moveToElement(tooltipElement).perform();

            // Add a delay to keep the tooltip visible for a moment
            Thread.sleep(4000);

            // Click on Record Now button
            WebElement recordNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Record Now']")));
            recordNow.click();
            Thread.sleep(2000);
           /*
            JavascriptExecutor js=(JavascriptExecutor)driver;
            //scrolling page
            WebElement startrecording = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@name='1728985482810']")));
            js.executeScript("arguments [0].scrollIntoView()",startrecording);
            */


            // Click on start Recording button
            WebElement startrecording = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@name='1728985482810']")));
            startrecording.click();
             Thread.sleep(9000);


            //  Click on Done button
            WebElement Donebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@name='1728986974274']")));
            Donebutton.click();
            Thread.sleep(5000);

        } catch (Exception e) {
            // Log the error instead of throwing it (improved error handling)
            e.printStackTrace();
        } finally {
            // Ensure the browser is closed after execution
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}
