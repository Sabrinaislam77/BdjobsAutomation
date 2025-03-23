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

public class AIAssessment {
    public static void main(String[] args) {
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

            // (Optional) Click on login button if there's one to submit the form
            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signIn.click();
            Thread.sleep(2000);

            // click the cross button
            WebElement crossbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content vinstruction']//button[@type='button'][normalize-space()='×']")));
            crossbutton.click();

            // click the invitation dropdown
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='invitationsMenu']")));
            dropdown.click();
            Thread.sleep(200);

            // click the AI Assessment
            WebElement AIAssessment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-ai-audio iaudio']")));
            AIAssessment.click();

            // click the AI details
            WebElement Assessmentdetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cart n-viewed']//a[@class='vdet-lnk'][normalize-space()='View Details']")));
            Assessmentdetails.click();

            //microphone permission
            //Alert myalert=driver.switchTo().alert();
            //myalert.accept();

            // Add arguments to bypass permission prompts
            options.addArguments("--use-fake-ui-for-media-stream"); // Automatically allows mic/camera
            //options.addArguments("--allow-file-access-from-files"); // Additional permissions if testing locally

            // click Employer instructions
            //WebElement EMinstructions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Employer’s Instructions.')]")));
            //EMinstructions.click();
            //Thread.sleep(200);

            // click cross of the Modal
            //WebElement crossicon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='assess_btn_cls close']//span[@aria-hidden='true'][normalize-space()='×']")));
            //crossicon.click();

            // click the proceed button
            //webElement proceedbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Proceed to Record'])[1]")));
            //proceedbutton.click();



        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace to help debug if needed
        } finally {
            // Close the browser after execution
            if (driver != null) {
                //driver.quit();  // Ensure the browser is closed after execution
            }
        }
    }
}
