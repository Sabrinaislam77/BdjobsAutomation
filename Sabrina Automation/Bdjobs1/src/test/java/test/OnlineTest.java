package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class OnlineTest {
    public static void main(String[] arg) {
        // Set up ChromeOptions to include the ad blocker extension and permissions
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

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("Avaryren");

            // Click Continue button
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("12345678");

            // Click Sign in button
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();
            Thread.sleep(2000);

            // After signing in, check if the home popup is displayed
            try {
                // Wait for the popup to be visible, adjust the timeout according to your needs
                WebElement popupviewbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='View']")));
                popupviewbutton.click();  // Popup is found and clicked
            } catch (Exception e) {
                // If popup is not found, click on the Home link in the left panel
                System.out.println("Popup not found. Clicking on Home page from the left panel.");

                // Click on the Home page from the left panel
                WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Home']")));
                homeLink.click();
                Thread.sleep(2000);

                // Now try clicking the popup again after navigating to Home page
                WebElement popupviewbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='View']")));
                popupviewbutton.click();
                Thread.sleep(2000);
            }

            // Switch to invite interview tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            // Click on ViewDetails link
            WebElement ViewDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='itivw-cart-cont']//div[2]//div[1]//div[5]//a[1]")));
            ViewDetails.click();

            // Click Test instruction link
            WebElement testinstructions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Instructions']")));
            testinstructions.click();
            Thread.sleep(3000);

            // Close the modal
            WebElement modalclose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='inscont0']//span[@aria-hidden='true'][normalize-space()='X']")));
            modalclose.click();
            Thread.sleep(2000);

            // Click Demo link
            WebElement Demotest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Demo test']")));
            Demotest.click();

            // Click Continue button
            WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));
            continuebutton.click();
            Thread.sleep(5000);

            // Click Demo test
            WebElement starttest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body")));
            starttest.click();

            // Optional: Additional wait to observe interaction before closing
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the WebDriver closes, even in case of an exception
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}
