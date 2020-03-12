package testFromTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CloudGoogleHomePage;
import page.PastebinHomePage;

public class HurtMePlentyTest {
    private WebDriver driver;
    private CloudGoogleHomePage cloudGoogleHomePage;
    private String CODE_TEXT = "git config --global user.name  \\\"New Sheriff in Town\\\"\\n\" +\n" +
            "                        \"git reset $(git commit-tree HEAD^{tree} -m \\\"Legacy code\\\")\\n\" +\n" +
            "                        \"git push origin master --force";
    private String TITLE_TEXT = "how to gain dominance among developers";
    @Test



    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cloudGoogleHomePage = new CloudGoogleHomePage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
