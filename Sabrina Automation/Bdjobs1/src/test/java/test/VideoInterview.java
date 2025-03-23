package test;

import org.openqa.selenium.Alert;
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

public class VideoInterview {
    public static void main(String[] args) {

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
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the website
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp");

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("bdjobspixel@gmail.com");

            // Click Continue button
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("123456789");

            // Click Sign in button
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();
            Thread.sleep(2000);

            // Wait for the view button to be clickable and click it
            WebElement Viewbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='View']")));
            Viewbutton.click();
            Thread.sleep(2000);

            // Switch to the new tab for Video CV
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

           // Wait for the View details link to be clickable and click it
            WebElement Viewdetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='itivw-cart-cont']//div[2]//div[1]//div[5]//a[1]")));
            Viewdetails.click();
            Thread.sleep(2000);

            // Wait for the Proceed To Record button to be clickable and click it
            WebElement Proceedtorecord = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='act-btn']")));
            Proceedtorecord.click();
            Thread.sleep(2000);

            // Wait for the Next button to be clickable and click it
            WebElement Nextbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")));
            Nextbutton.click();
            Thread.sleep(2000);

            // Wait for the Record button to be clickable and click it
            WebElement Recordbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='recs']")));
            Recordbutton.click();


            //webcam permission
            Alert myalert=driver.switchTo().alert();
            myalert.accept();


        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace to help debug if needed
        } finally {
            // Close the browser after execution
            if (driver != null) {
                //driver.quit();  // Uncomment this line to close the browser after execution
            }
        }
    }
}
