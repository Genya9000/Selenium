package testFromTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CloudGoogleHomePage;
import page.PastebinHomePage;
import java.util.concurrent.TimeUnit;

public class HurtMePlentyTest {
    private WebDriver driver;
    private CloudGoogleHomePage cloudGoogleHomePage;
    private String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    private String TITLE_TEXT = "how to gain dominance among developers";
    @Test
    public void fieldCheck(){
        cloudGoogleHomePage.openPage()
                .enterInSearchBox(SEARCH_TEXT)
                .clickOnCalcolatorLink()
                .selectComputeEngineSection()
                .fillInTheForm();
        Assert.assertEquals(true, cloudGoogleHomePage.vmClassContainRegular());
        Assert.assertEquals(true, cloudGoogleHomePage.instanceTypeCheck());
        Assert.assertEquals(true, cloudGoogleHomePage.localSSDCheck());
        Assert.assertEquals(true, cloudGoogleHomePage.regionCheck());
        Assert.assertEquals(true, cloudGoogleHomePage.paymentCheck());
    }

    @Test
    public void fieldCheck1(){
        cloudGoogleHomePage.openPage()
                .enterInSearchBox(SEARCH_TEXT)
                .clickOnCalcolatorLink()
                .selectComputeEngineSection()
                .fillInTheForm()
                .emailEstimateButtonClick()
                .openMailservice()
                .copyMailAddress()
                .insertMail()
                .sendMail();
        Assert.assertEquals(true, cloudGoogleHomePage.paymentCheckFromMail());


    }


    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cloudGoogleHomePage = new CloudGoogleHomePage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
