package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AuthenticatePage;
import pages.CartPage;

public class cartFlowTests {

    CartPage cartPage;
    AuthenticatePage authenticatePage;
    WebDriver driver;

    @BeforeTest
    public void LaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void cartFlowAddProductToCartTC () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        cartPage = new CartPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false,"");
        cartPage.addProductToTheCart("Yarah", "Salah", "02");
    }

    @Test
    public void cartFlowRemoveProductFromTheCartTC () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        cartPage = new CartPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        cartPage.removeProductFromTheCart();
        Thread.sleep(3000);

    }

    @Test
    public void cartFlowCheckCartContainerTC () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        cartPage = new CartPage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
        cartPage.cartBadgeUpdates();
    }

    @AfterMethod
    void quit() {
        driver.close();
        driver.quit();
    }

}
