package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.BrowserInitiation.driver;

public class TestRunnerClass {

    @BeforeTest
    public void lauchBrowser(){
        FunctionUtility.reportGeneration();
        FunctionUtility.configureReport();
        BrowserInitiation.initiateBrowser("chrome");


    }
//     @Test(dataProvider = "testdata", priority = 2,dataProviderClass = DataDriven.class)
//    @Test(priority = 2)
//    public void enterValue()
//    {
//        WebElement emailId  = driver.findElement(By.id("email"));
//        if (emailId.isEnabled()) {
//            emailId.sendKeys(email);
//        } else {
//            System.out.println("Element is not enabled.");
//        }
//        ProductData.enterData();
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class, priority = 1)
    public void TC1_Sample_Test_Case_1(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);

        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 2)
    public void TC2_Sample_Test_Case_2(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
       // ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
//        Assert.assertEquals(driver.getTitle(),"Enter Product Data");
//        driver.get("");
        Assert.assertTrue(driver.findElement(By.id("tricentis_logo")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.id("tricentis_logo")).isDisplayed());
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 3)
    public void TC3_Sample_Test_Case_3(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
        Assert.assertEquals(driver.getTitle(),"Enter Product Data");
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 4)
    public void TC4_Sample_Test_Case_4(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
       // Assert.assertEquals(driver.findElement(By.id("legalDefenseInsurance")));
        try {
            Assert.assertTrue(driver.findElement(By.id("entervehicledata")).isDisplayed());
        }catch (NoSuchElementException e)
        {
            Assert.assertFalse(driver.findElement(By.id("entervehicledata")).isDisplayed(),"No element found - entervehicledata");
        }
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 5)
    public void TC5_Sample_Test_Case_5(String url,String startdate, String insurancesum,String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        //ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
        Assert.assertEquals(driver.getCurrentUrl(),"https://sampleapp.tricentis.com/101/app.php#");
        Thread.sleep(5000);
    }
    @Test(dataProvider="testdata", dataProviderClass = DataDriven.class,priority = 6)
    public void TC6_Sample_Test_Case_6(String url, String startdate, String insurancesum, String mertirating, String damageinsurance, String curtesycar) throws InterruptedException {
        // ProductData.enterData(url,startdate, insurancesum, mertirating,damageinsurance,curtesycar);
//        throw new SkipException("Skip test");
        //Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.id("visitsupport")).isEnabled());
    }
    @AfterTest
    public void finish(){
        FunctionUtility.flushMethod();
        driver.quit();
    }



}

