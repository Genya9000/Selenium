package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloudGoogleHomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/ ";
    @FindBy(xpath = "//div[@class='devsite-search-image material-icons']")
    private WebElement searchBotton;
    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    private WebElement calculatorLink;
    @FindBy(xpath = "//div[@class='name ng-binding'][text()='Compute Engine']")
    private List<WebElement> computeEngineSection;
    @FindBy(xpath = "//input[@id='input_55']")
    private WebElement numberInstancesInput;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_52']")
    private WebElement instanceTypeSelect;



    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }
    public CloudGoogleHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public CloudGoogleHomePage enterInSearchBox(String text){
        wait.until(ExpectedConditions.visibilityOf(searchBotton)).click();
        searchBotton.sendKeys(text, Keys.ENTER);
        return this;
    }
    public CloudGoogleHomePage clickOnCalcolatorLink(){
        wait.until(ExpectedConditions.visibilityOf(calculatorLink)).click();
        return this;
    }
    public CloudGoogleHomePage selectComputeEngineSection(){
        wait.until(ExpectedConditions.visibilityOf(computeEngineSection.get(0))).click();
        return this;
    }
    public CloudGoogleHomePage fillInTheForm(){
        numberInstancesInput.sendKeys("4");

    }


}