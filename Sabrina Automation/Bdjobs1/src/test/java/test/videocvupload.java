import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class videocvupload {

    public static void main(String[] arg) {
        // Set up ChromeOptions to include the ad blocker extension
        ChromeOptions options = new ChromeOptions();
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Validate if the extension file exists before adding it to ChromeOptions
        File extensionFile = new File(adblockerPath);

        if (extensionFile.exists() && extensionFile.isFile()) {
            options.addExtensions(extensionFile);
        }
        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();

            // Navigate to the SignIn page
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("01980855752");

            // Click Continue button
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("123456789");

            // Click Sign in button
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();

            // Wait for the Manage Profile dropdown to be clickable and click it
            WebElement manageProfileDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='manageResumeMenu']")));
            manageProfileDropdown.click();

            // Wait for and click the Video CV link
            WebElement videoCV = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Video CV']")));
            videoCV.click();

            // Switch to the new tab for Video CV
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            // Close the popup tutorial if it appears
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='videoTutorialCloseBtn'] span[aria-hidden='true']")));
            closeButton.click();

            // Optionally click the "Take Preparation" button
            WebElement takePreparation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Take Preparation']")));
            Thread.sleep(2000);
            takePreparation.click();

            // Close the "Take Preparation" modal
            WebElement crossButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoResumeTakePreparation']//button[@type='button'][normalize-space()='×']")));
            Thread.sleep(200);
            crossButton.click();

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
            Thread.sleep(2000);

            // Click on the "Video Guide" link
            WebElement videoGuide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Video Guide']")));
            videoGuide.click();
            Thread.sleep(3000);

            // Switch to the new tab for Video Guide
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(3000);
            driver.close();

            // Switch back to the main window
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            //click on create video cv
            WebElement createvideocv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='act-btn']")));
            createvideocv.click();

            //click on samplevideos
            WebElement samplevideos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sample Video']")));
            samplevideos.click();
            Thread.sleep(2000);

            //click on sample videos popup close
            WebElement sampleiconclose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='videoTutorialCloseBtn']//span[@aria-hidden='true'][normalize-space()='×']")));
            sampleiconclose.click();

            // Hover over the tooltip element
            WebElement tooltipElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='anstlnk']")));

            // Use Actions class to hover over the tooltip
            Actions action = new Actions(driver);
            action.moveToElement(tooltipElement).perform();

            // Add a delay to keep the tooltip visible for a moment
            Thread.sleep(3000);

            //click on Record Now button
            WebElement Recordnow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='no-vid-er-wrap']//div[2]//button[1]")));
            Recordnow.click();
            Thread.sleep(5000);

            // Wait for the popup to appear (adjust the timeout as needed)
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(3000);

            // will click on Record button
            WebElement startrecording = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("input[value='Start Recording']")));
            startrecording.click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser after execution
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}
