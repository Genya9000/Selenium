package page;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CloudGoogleHomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ArrayList<String> tabs;
    private Actions actions;
    private String oldTab;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/ ";
    private static final String MAILPAGE_URL = " https://10minutemail.com";
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
    @FindBy(xpath = "//md-select-value[@id=\"select_value_label_326\"]")
    private WebElement numberOfGpusInput;
    @FindBy(xpath = "//md-option[@id='select_option_333']")
    private WebElement count1Gpu;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_327']")
    private WebElement gpyType;
    @FindBy(xpath = "//div[@class='md-text ng-binding'][contains(text(), 'NVIDIA Tesla V100')]")
    private WebElement typeTeslaV100;
    @FindBy(id = "select_167")
    private WebElement localSsdField;
    @FindBy(id = "select_option_229")
    private WebElement ssdCapacity;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_53']")
    private WebElement dataLocationInput;
    @FindBy(id = "select_option_177")
    private WebElement locationfrankfurt;
    @FindBy(id = "select_89")
    private WebElement commitedUsageInput;
    @FindBy(xpath = "//*[@id=\"select_option_87\"]/div[1]")
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
    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;
    @FindBy(id = "copy_address")
    private WebElement copyButton;
    @FindBy(id = "input_367")
    private WebElement inputMail;
    @FindBy(xpath = "//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"][@ng-click=\"emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()\"]")
    private WebElement sendMailButton;
    @FindBy(xpath = "//div[@class='small_sender']")
    private WebElement openMailLink;
    @FindBy(xpath = "//span[@id='inbox_count_number']")
    private WebElement inboxCaunt;
    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost: ')]")
    private WebElement peymentCauntFromMail;




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
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        wait.until(ExpectedConditions.visibilityOf(computeEngineSection)).click();
        return this;
    }
    public CloudGoogleHomePage fillInTheForm(){
        numberInstancesInput.click();
        numberInstancesInput.sendKeys("4");
        instanceTypeSelect.click();
        wait.until(ExpectedConditions.visibilityOf(n1Standart8)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addGpuCheckBox)).click();
        wait.until(ExpectedConditions.visibilityOf(numberOfGpusInput)).click();
        actions = new Actions(driver);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.elementToBeClickable(count1Gpu)).click();
        actions.moveToElement(gpyType).perform();
        wait.until(ExpectedConditions.elementToBeClickable(gpyType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(typeTeslaV100));
        actions.moveToElement(typeTeslaV100).click();
        wait.until(ExpectedConditions.elementToBeClickable(localSsdField));
        actions.moveToElement(localSsdField).click();
        actions.moveToElement(ssdCapacity).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ssdCapacity)).click();
        actions.moveToElement(dataLocationInput).perform();
        wait.until(ExpectedConditions.elementToBeClickable(dataLocationInput)).click();
        actions.moveToElement(locationfrankfurt).perform();
        wait.until(ExpectedConditions.elementToBeClickable(locationfrankfurt)).click();
        actions.moveToElement(commitedUsageInput).perform();
        wait.until(ExpectedConditions.elementToBeClickable(commitedUsageInput)).click();
        actions.moveToElement(usageYear).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(usageYear)).click();
        actions.moveToElement(addToEstimateButton).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton)).click();
        return this;
    }
    public CloudGoogleHomePage emailEstimateButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return this;
    }
    public  CloudGoogleHomePage openMailservice(){
        oldTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open()");
         tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(MAILPAGE_URL);
        return this;
    }
    public CloudGoogleHomePage copyMailAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(copyButton)).click();
        return this;
    }
    public CloudGoogleHomePage insertMail(){

        driver.switchTo().window(oldTab);
        wait.until(ExpectedConditions.elementToBeClickable(inputMail)).click();
        actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();
        return this;
    }
    public CloudGoogleHomePage sendMail(){
        wait.until(ExpectedConditions.elementToBeClickable(sendMailButton)).click();
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
        return paymentValues.get(0).getText().contains("1,082.77");
}
public boolean paymentCheckFromMail(){
    driver.switchTo().window(tabs.get(1));
    boolean ifSend = wait.until(ExpectedConditions.textToBePresentInElement(inboxCaunt, "1"));
    if (ifSend) inboxCaunt.click();
    wait.until(ExpectedConditions.elementToBeClickable(openMailLink)).click();
    return wait.until(ExpectedConditions.visibilityOf(typeTeslaV100)).getText().contains("1,082.77");
}

}