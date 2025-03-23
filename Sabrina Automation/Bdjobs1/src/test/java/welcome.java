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

public class welcome {
    public static void main(String[] args) {

        // Update this path to the actual location of the uBlock-Origin-Chrome-Web-Store.crx file
        String adblockerPath = "src/main/resources/uBlock-Origin-Chrome-Web-Store.crx";

        // Initialize WebDriver and ChromeOptions
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();

        // Validate if the extension file exists before adding it to ChromeOptions
        File extensionFile = new File(adblockerPath);
        if (extensionFile.exists() && extensionFile.isFile()) {
            options.addExtensions(extensionFile);
        }

        driver = new ChromeDriver(options);

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the SignIn page
            driver.get("https://mybdjobs.bdjobs.com/mybdjobs/signin.asp");

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Login steps
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTUSERNAME']")));
            usernameField.sendKeys("avary");

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
            continueButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TXTPASS']")));
            passwordField.sendKeys("12345678");

            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']")));
            signInButton.click();

            // Waiting and clicking popup "View" button
            WebElement popupView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='View']")));
            popupView.click();
            Thread.sleep(10000);


            // Switch to the new tab and close it
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(tabs.get(0));  // Switch back to the original tab

             //will click on  rightpopup crossicon
            WebElement crossicon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='chat-box-toggle']//i[@class='icon-times-o']")));
            crossicon.click();

            // Perform actions with wait for each step
            WebElement myPointsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary upb uppoints']")));
            myPointsButton.click();

            // Navigating back and interacting with balance
            driver.navigate().back();


            WebElement checkBalance = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary upb uppoints']")));
            checkBalance.click();
            driver.navigate().back();

           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bdjobs Pro']"))).click();

             //will  click on GeneralTab
            WebElement generalTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='General']")));
            generalTab.click();
            Thread.sleep(2000);

            WebElement thisMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tab-thismonth']")));
            thisMonth.click();//will click this month tab

            WebElement lastOneYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tab-alltime']")));
            lastOneYear.click();
            Thread.sleep(2000);

            WebElement manageProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='alltime']//a[@class='mres'][normalize-space()='Manage Profile']")));
            manageProfile.click();

            driver.navigate().back();

            // Click change button
            WebElement change = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='alltime']//a[@class='csvact'][normalize-space()='Change']")));
            change.click();

            driver.navigate().back();


            // Click "How can I buy points" link
            WebElement buyPointslink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='hdieplnk']")));
            buyPointslink.click();
            Thread.sleep(2000);

            // Switch to the new tab and close it
            ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab2.get(1));
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(tab2.get(0));  // Switch back to the original tab




            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cleanup: close the browser
            //driver.quit();


        }
    }





}