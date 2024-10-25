package pages;

import enums.SortBy;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage {

    private final int DEFAULTTIMEOUT = 30;

    private final By card = By.className("inventory_item_description");
    private final By productName = By.className("inventory_item_name");
    private final By productPrice = By.className("inventory_item_price");
    private final By productDescription = By.className("inventory_item_desc");
    private final By sortBtn = By.className("product_sort_container");
    private final By sortOption = By.className("active_option");

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void verifyAllProductsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));
        List<WebElement> productCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(card));
        Assert.assertFalse(productCards.isEmpty(), "No products are displayed.");

        for (WebElement card : productCards) {
            Assert.assertTrue(card.isDisplayed(), "A product card is not displayed.");
            WebElement nameElement = card.findElement(productName);
            WebElement priceElement = card.findElement(productPrice);

            Assert.assertFalse(nameElement.getText().isEmpty(), "Product name is empty.");
            Assert.assertFalse(priceElement.getText().isEmpty(), "Product price is empty.");
        }
    }


    public void productInfo(int index, String expectedProductName, String expectedProductPrice, String expectedProductDescription) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));

        List<WebElement> productCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(card));

        WebElement card = productCards.get(index);
        Assert.assertTrue(card.isDisplayed(), "Product card at index");

        WebElement nameElement = card.findElement(productName);
        String actualName = nameElement.getText();
        Assert.assertEquals(actualName, expectedProductName);

        WebElement priceElement = card.findElement(productPrice);
        String actualPrice = priceElement.getText();
        Assert.assertEquals(actualPrice, expectedProductPrice);

        WebElement descriptionElement = card.findElement(productDescription);
        String actualDescription = descriptionElement.getText();
        Assert.assertEquals(actualDescription, expectedProductDescription);
    }

    public void sortByFunctionality (SortBy sortBy) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULTTIMEOUT));
        WebElement sortBtnElem = wait.until(ExpectedConditions.elementToBeClickable(sortBtn));
        sortBtnElem.click();

        //WebElement sortOptionsElem = wait.until(ExpectedConditions.visibilityOfElementLocated(sortOption));
        //sortOptionsElem.click();

        for (WebElement option : driver.findElements(sortOption)) {
            if (option.getText().equals(sortBy.getName())) {
                option.click();
                 break;
                }
            }
        }
 }






