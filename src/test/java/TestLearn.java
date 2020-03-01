import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

public class TestLearn {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");
        driver.manage().window().maximize();
        new WebDriverWait(driver, 20)
                .until(CustomConditions.jQueryAJAXsCompleted());
        WebElement searchInput = getWaitElement(driver, By.id("gsc-i-id1"));
        searchInput.sendKeys("selenium java", Keys.ENTER);
        getWaitElement(driver, By.xpath("//*[@class='gsc-webResult gsc-result']"));
        List<WebElement> searchResults =  driver.findElements(By.xpath("//*[@class='gsc-webResult gsc-result']"));
        System.out.println("numders of results set is " + searchResults.size());
        driver.quit();


    }

    private static WebElement getWaitElement(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
