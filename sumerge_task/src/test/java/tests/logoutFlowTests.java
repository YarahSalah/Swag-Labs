package tests;

import enums.SortBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthenticatePage;
import pages.LogoutPage;
import pages.ProductsPage;

public class logoutFlowTests {

    LogoutPage logoutPage;
    AuthenticatePage authenticatePage;
    WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up the Chrome driver and navigate to the product page
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com"); // Replace with actual URL
    }

    @Test
    public void checkLogoutFunctionalityTC() throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        logoutPage = new LogoutPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        logoutPage.verifyLogoutFunctionality();

    }

    @AfterMethod
    void quit() {
        driver.close();
        driver.quit();
    }

}
