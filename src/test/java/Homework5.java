import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43");
    }

    @Test
    public void checkCart(){
        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();
        WebElement cart = driver.findElement(By.xpath("//button[contains(@class, \"btn btn-inverse btn-block btn-lg dropdown-toggle\")]"));
        cart.click();
        By locator = By.xpath("//strong/i[contains(@class, \"fa fa-share\")]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement checkout = driver.findElement(locator);
        checkout.click();
        String titleNameOfCheckoutPage = driver.getTitle();
        Assert.assertEquals(titleNameOfCheckoutPage, "Checkout");
      }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
