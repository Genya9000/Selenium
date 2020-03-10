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
    @FindBy(xpath = "//span[text()='None']")
    private WebElement syntaxHighlightingInput;
    @FindBy(xpath = "//li[text()='Bash'][1]")
    private WebElement bashButton;
    @FindBy(xpath = "//a[contains(text(),'Bash')]")
    private WebElement highlightingText;
    @FindBy(xpath = "//div[@class='paste_box_line1'])")
    private WebElement title;
    @FindBy(xpath = "//textarea[@id='paste_code']")
    private WebElement codeTextArea;


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
    public PastebinHomePage chooseBashHighlighting(){
        syntaxHighlightingInput.click();
        bashButton.click();
        return this;
    }
    public String getTitle(){
        WebElement element =  new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='paste_box_line1']")));
        return element.getText();
    }
    public String getSintacs(){
        return highlightingText.getText();
    }
    public String getCode(){
        return codeTextArea.getText();
    }


}
