package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WebDriverSeleniumHQTest {
    @Test
    public void commonSearchTermResultsNotEmpty(){
    WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");
        driver.manage().window().maximize();
        /*new WebDriverWait(driver, 20)
                .until(CustomConditions.jQueryAJAXsCompleted());*/

    WebElement searchInput = getWaitElement(driver, By.id("gsc-i-id1"));
        searchInput.sendKeys("selenium java", Keys.ENTER);

    getWaitElement(driver, By.xpath("//*[@class='gsc-webResult gsc-result']"));
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .withMessage("Timeout for waiting search result list was exceeded!");

    List<WebElement> searchResults =  wait.until(new Function<WebDriver, List<WebElement>>() {
        @Override
        public List<WebElement> apply(WebDriver driver) {
            return driver.findElements(By.xpath("//*[@class='gsc-webResult gsc-result']"));
        }
    });
        System.out.println("numders of results set is " + searchResults.size());
        Assert.assertTrue(searchResults.size()>0, "search results are empty");
        driver.quit();


}

    private static WebElement getWaitElement(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
