package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;
    @FindBy(id = "paste_code")
    private WebElement codeInput;
    @FindBy(xpath = "//span[text()='Never']")
    private WebElement pasteExpirationInput;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMinutesButton;
    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement pasteNameInput;
    @FindBy(xpath = "//input[@id='submit']")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public PastebinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        return this;
    }
    public PastebinHomePage insertCode(String code){
        codeInput.sendKeys(code);
        return this;
    }
    public PastebinHomePage choose10Minutes(){

        pasteExpirationInput.click();
        tenMinutesButton.click();
        return this;
    }
    public PastebinHomePage writePasteName(String name){
        pasteNameInput.sendKeys(name);
        return this;
    }
    public PastebinHomePage createNewPaste(){
        createNewPasteButton.click();
        return this;
    }


}
