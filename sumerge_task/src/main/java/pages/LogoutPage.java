package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LogoutPage {

    private final int DEFAULTTIMEOUT = 30;

    private final By sideMenu = By.id("react-burger-menu-btn");
    private final By logoutBtn = By.id("logout_sidebar_link");
    private final By logo = By.className("login_logo");

    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLogoutFunctionality() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));
        WebElement sideMenuElem = wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu));
        sideMenuElem.click();

        WebElement logoutBntElem = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
        logoutBntElem.click();

        WebElement logoElem = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        logoElem.isDisplayed();


    }

}
