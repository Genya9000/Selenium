package testFromTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinHomePage;

public class BringItOn {
    private WebDriver driver;
    PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
    private String CODE_TEXT = "git config --global user.name  \\\"New Sheriff in Town\\\"\\n\" +\n" +
            "                        \"git reset $(git commit-tree HEAD^{tree} -m \\\"Legacy code\\\")\\n\" +\n" +
            "                        \"git push origin master --force";
    private String TITLE_TEXT = "how to gain dominance among developers";
    @Test
    public void createNewPasteSucces(){
        new PastebinHomePage(driver).openPage()
                .insertCode(CODE_TEXT)
                .chooseBashHighlighting()
                .choose10Minutes()
                .writePasteName(TITLE_TEXT)
                .createNewPaste();
        Assert.assertEquals(TITLE_TEXT, pastebinHomePage.getTitle(), "title is incorect");
        Assert.assertEquals("Bash", pastebinHomePage.getSintacs(), "sintacs is incorect");
        Assert.assertEquals(CODE_TEXT, pastebinHomePage.getCode(), "code is incorect");

    }
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
