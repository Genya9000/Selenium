package page;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchBotton;
    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    private WebElement calculatorLink;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/div[1]/div")
    private WebElement computeEngineSection;
    @FindBy(id = "input_55")
    private WebElement numberInstancesInput;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_52']")
    private WebElement instanceTypeSelect;
    @FindBy(xpath = "//div[contains(text(), '       n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
    private WebElement n1Standart8;
    @FindBy(xpath = "//div[contains(text(), '  Add GPUs.')]")
    private WebElement addGpuCheckBox;
    @FindBy(xpath = "//md-select[@id=\"select_897\"]")
    private WebElement numberOfGpusInput;
    @FindBy(xpath = "//md-option[@id='select_option_331']")
    private WebElement count1Gpu;
    @FindBy(id = "select_328")
    private WebElement gpyType;
    @FindBy(id = "select_option_338")
    private WebElement typeTeslaV100;
    @FindBy(id = "select_167")
    private WebElement localSsdField;
    @FindBy(id = "select_option_229")
    private WebElement ssdCapacity;
    @FindBy(id = "select_82")
    private WebElement dataLocationInput;
    @FindBy(id = "select_option_177")
    private WebElement locationfrankfurt;
    @FindBy(id = "select_89")
    private WebElement commitedUsageInput;
    @FindBy(id = "select_option_102")
    private WebElement usageYear;
    @FindBy(xpath = "//button[contains(text(),  \"    Add to Estimate\")][@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(text(), 'VM')]")
    private WebElement vMClassField;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(text(), 'Instance')]")
    private WebElement instanceTypeField;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(text(), 'Region')]")
    private WebElement regionField;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding'][contains(text(), 'local')]")
    private WebElement localSSDValue;
    @FindBy(xpath = "//b[@class=\"ng-binding\"][contains(text(), 'Cost:')]")
    private List<WebElement> paymentValues;





    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 50);
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        wait.until(ExpectedConditions.visibilityOf(computeEngineSection)).click();
        return this;
    }
    public CloudGoogleHomePage fillInTheForm(){
        numberInstancesInput.click();
        numberInstancesInput.sendKeys("4");
        instanceTypeSelect.click();
        wait.until(ExpectedConditions.visibilityOf(n1Standart8)).click();
        addGpuCheckBox.click();
        wait.until(ExpectedConditions.visibilityOf(numberOfGpusInput)).click();
        wait.until(ExpectedConditions.visibilityOf(count1Gpu)).click();
        gpyType.click();
        wait.until(ExpectedConditions.visibilityOf(typeTeslaV100)).click();
        localSsdField.click();
        wait.until(ExpectedConditions.visibilityOf(ssdCapacity)).click();
        dataLocationInput.click();
        wait.until(ExpectedConditions.visibilityOf(locationfrankfurt)).click();
        commitedUsageInput.click();
        wait.until(ExpectedConditions.visibilityOf(usageYear)).click();
        addToEstimateButton.click();
        return this;
    }
public boolean vmClassContainRegular(){
        return wait.until(ExpectedConditions.visibilityOf(vMClassField)).getText().contains("regular");
}
public boolean instanceTypeCheck(){
        return instanceTypeField.getText().contains("n1-standard-8");
}
public boolean regionCheck(){
        return regionField.getText().contains("Frankfurt");
}
public boolean localSSDCheck(){
        return localSSDValue.getText().contains("2x375 GB");
}
public boolean paymentCheck(){
        return paymentValues.get(0).getText().contains("1,288.71");
}

}