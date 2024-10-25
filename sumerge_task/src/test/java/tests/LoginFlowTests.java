package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AuthenticatePage;

public class LoginFlowTests {

    AuthenticatePage authenticatePage;
    WebDriver driver;
    private WebDriverWait wait;


    @BeforeTest
    public void LaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void LoginSuccessTC() throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        authenticatePage.login("standard_user", "secret_sauce", false, "");
    }

    @Test
    public void loginWithInvalidUsernameTC() throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        authenticatePage.login("standard789", "secret_sauce", true, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidPasswordTC () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        authenticatePage.login("standard_user", "secret_sauce78798", true, "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginWithEmptyUsernameFieldTC () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        authenticatePage.login("", "secret_sauce78798", true, "Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyPasswordFieldTC () throws InterruptedException {
        authenticatePage = new AuthenticatePage(driver);
        authenticatePage.login("standard_user", "", true, "Epic sadface: Password is required");
    }

    @AfterMethod
    void quit()
    {
        driver.close();
        driver.quit();
    }
}
