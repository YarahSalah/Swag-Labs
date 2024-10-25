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
import pages.ProductsPage;

import java.util.List;

public class productsFlowTests {

    ProductsPage productsPage;
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
    public void productsFlowCheckAllProductsDisplayed() throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        productsPage = new ProductsPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        productsPage.verifyAllProductsDisplayed();
    }

    @Test
    public void productsFlowCheckInfoOfCard () throws InterruptedException{
        authenticatePage = new AuthenticatePage(driver);
        productsPage = new ProductsPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        productsPage.productInfo(0,"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
    }

    @Test
    public void productsFlowCheckSortFunctionalityUsingAToZ () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        productsPage = new ProductsPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        productsPage.sortByFunctionality(SortBy.A_Z);
        Thread.sleep(5000);
    }

    @Test
    public void productsFlowCheckSortFunctionalityUsingZToA () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        productsPage = new ProductsPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        productsPage.sortByFunctionality(SortBy.Z_A);
        Thread.sleep(5000);
    }

    @Test
    public void productsFlowCheckSortFunctionalityUsingHighToLow () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        productsPage = new ProductsPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        productsPage.sortByFunctionality(SortBy.HIGH_TO_LOW);
        Thread.sleep(5000);
    }

    @Test
    public void productsFlowCheckSortFunctionalityUsingLowToHigh () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        productsPage = new ProductsPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        productsPage.sortByFunctionality(SortBy.LOW_TO_HIGH);
        Thread.sleep(5000);
    }

    @AfterMethod
    void quit() {
        driver.close();
        driver.quit();
    }
}
