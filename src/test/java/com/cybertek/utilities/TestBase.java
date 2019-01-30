package com.cybertek.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

    protected void verifyTextContains(String str1 , String str2){
        Assert.assertTrue(str1.contains(str2));
    }


    public void verifyTextMatches(String str1 , String str2){

        Assert.assertEquals(str1,str2);

    }
    @BeforeClass
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
        softAssert.assertAll();
    }
}