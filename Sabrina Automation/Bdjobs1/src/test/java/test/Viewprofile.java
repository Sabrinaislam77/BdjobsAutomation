package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class Viewprofile {
    public static void main(String[] args) {


        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the website
            driver.get("https://www.bdjobs.com/");

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate and click the dropdown that contains the Sign In option
            WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='hidden-xs soca']//a[@role='button'][contains(text(),'Sign in')]")));
            accountDropdown.click();

            // Wait for the Sign In button within the dropdown to be clickable and click it
            WebElement signInButtonDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='hidden-xs soca open']//div[@class='cart-mbdj']//a[@class='btn slu-btn'][normalize-space()='Sign in']")));
            signInButtonDropdown.click();

            // Wait for the username field to be visible and interact with it
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("RenMondal");

            // Wait for the Continue button to be clickable and click it
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            // Wait for the password field to be visible and interact with it
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("12345678");

            // Wait for the Sign In button to be clickable and click it
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();

            // Wait for the MyBdjobs link to be clickable and click it
            WebElement mybdjobs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='mybdjobs']//span[@class='wr'][normalize-space()='Bdjobs']")));
            mybdjobs.click();

            // Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            // Wait for the Manage Profile dropdown to be clickable and click it
            WebElement manageProfileDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='manageResumeMenu']")));
            manageProfileDropdown.click();

            // Adding an explicit wait before interacting with "View Profile"
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='View Profile']")));

            // Now click the "View Profile" link
            WebElement viewProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='View Profile']")));
            viewProfile.click();

            // Wait for the "Short View" button to be clickable and click it
            WebElement shortView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Short']")));
            shortView.click();



            // Adding an explicit wait before interacting with "Details View"
            WebElement detailsView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Details']")));
            detailsView.click();

            WebElement downloadPdfButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-pdf']"))); // Adjust the XPath to match the actual download button for the PDF
            downloadPdfButton.click();
            Thread.sleep(5000);// to ensure file is downloaded

            WebElement downloadWORDButton =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-ms-word']")));
            downloadWORDButton.click();

            WebElement Edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='edit_btn']")));
            Edit.click();
            driver.navigate().back();
        } catch (Exception e) {
          ;  e.printStackTrace();
        }
    }
}
