package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPage {


    private final By card = By.className("inventory_item_name");
    private final By addToCartBtn1 = By.id("add-to-cart-sauce-labs-backpack");
    private final By addToCartBtn2 = By.id("add-to-cart-sauce-labs-bike-light");
    private final By removeBtn1 = By.id("remove-sauce-labs-backpack");
    private final By removeBtn2 = By.id("remove-sauce-labs-bike-light");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By checkOutBtn = By.id("checkout");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeFiled = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By summaryInfo = By.className("summary_info");
    private final By finishBtn = By.id("finish");
    private final By completeProcess = By.className("complete-header");
    private final By nameOfProduct = By.className("inventory_item_name");
    private final By cartContainer = By.id("shopping_cart_container");

    private final int DEFAULTTIMEOUT = 30;

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToTheCart(String firstName, String lastName, String postalCode) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));

        WebElement cardElem = wait.until(ExpectedConditions.visibilityOfElementLocated(card));
        cardElem.isDisplayed();

        WebElement addToCartElem = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn1));
        addToCartElem.click();

        WebElement removeBtnElem = wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtn1));
        removeBtnElem.isDisplayed();

        WebElement cartIconElem = driver.findElement(cartIcon);
        cartIconElem.click();

        WebElement checkOutBtnElem = driver.findElement(checkOutBtn);
        checkOutBtnElem.click();

        WebElement firstNameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElem.click();
        firstNameElem.sendKeys(firstName);

        WebElement lastNameElem = driver.findElement(lastNameField);
        lastNameElem.click();
        lastNameElem.sendKeys(lastName);

        WebElement postalCodeElem = driver.findElement(zipCodeFiled);
        postalCodeElem.click();
        postalCodeElem.sendKeys(postalCode);

        WebElement continueElem = driver.findElement(continueBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueElem);
        continueElem.click();

        WebElement summaryInfoElem = wait.until(ExpectedConditions.visibilityOfElementLocated(summaryInfo));
        summaryInfoElem.isDisplayed();

        WebElement finishElem = driver.findElement(finishBtn);
        finishElem.click();

        WebElement completeTheProcessElem = wait.until(ExpectedConditions.visibilityOfElementLocated(completeProcess));
        completeTheProcessElem.getAttribute("Thank you for your order!");
    }

    public void removeProductFromTheCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));

        WebElement cardElem = wait.until(ExpectedConditions.visibilityOfElementLocated(card));
        cardElem.isDisplayed();

        WebElement addToCartElem = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn1));
        addToCartElem.click();

        WebElement cartIconElem = driver.findElement(cartIcon);
        cartIconElem.click();

        WebElement nameOfProductElem = wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfProduct));
        nameOfProductElem.isDisplayed();

        WebElement removeCardElem = driver.findElement(removeBtn1);
        removeCardElem.click();
    }

    public void cartBadgeUpdates() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));

        List<WebElement> cardElem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(card));
        cardElem.get(2);

        WebElement addToCartBtn1Elem = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn1));
        addToCartBtn1Elem.click();

        WebElement addToCartBtn2Elem = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn2));
        addToCartBtn2Elem.click();

        WebElement cartIconElem = driver.findElement(cartIcon);
        cartIconElem.click();

        WebElement cartContainerElem = driver.findElement(cartContainer);
        cartContainerElem.getSize();

        WebElement removeBtn2Elem = driver.findElement(removeBtn2);
        removeBtn2Elem.click();

        cartContainerElem.getText();
    }
}

