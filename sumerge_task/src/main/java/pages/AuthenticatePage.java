package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AuthenticatePage {

    private final By pageLogo = By.className("login_logo");
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.className("error-message-container");

    private WebDriver driver;
    private WebDriverWait wait;

    public AuthenticatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userNameField, String passwordField, boolean invalidLoginWithInvalidUsername, String expectedErrorMessage) throws InterruptedException {
        int DEFAULTTIMEOUT = 30;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));

        WebElement pageLogoElem = wait.until(ExpectedConditions.visibilityOfElementLocated(pageLogo));
        pageLogoElem.isDisplayed();

        WebElement userNameElem = driver.findElement(userName);
        userNameElem.click();
        userNameElem.sendKeys(userNameField);


        WebElement passwordElem = driver.findElement(password);
        userNameElem.click();
        passwordElem.sendKeys(passwordField);

        WebElement loginBntElem = driver.findElement(loginBtn);
        loginBntElem.click();

        if (invalidLoginWithInvalidUsername) {
            WebElement errorMsgElem = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            Assert.assertEquals(errorMsgElem.getText(), expectedErrorMessage, "Error message does not match the expected message.");
        }

    }
}
