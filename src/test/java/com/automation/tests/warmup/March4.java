package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    public static void main(String[] args) throws Exception{
        ebayTest();
        amazonTest();
        wikiTest();
    }
//    Go to ebay
//    enter search term
//    click on search button
//    print number of results
    public static void ebayTest(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement search=driver.findElement(By.id("gh-ac"));
        search.sendKeys("Iphone case");
        driver.findElement(By.id("gh-btn")).click();
       WebElement searcResult= driver.findElement(By.tagName("h1"));
        System.out.println("searcResult = " + searcResult.getText().split(" ")[0]);

     driver.quit();


    }
//    go to amazon
//    enter search term
//    click on search button
//    verify title contains search term
    public static void amazonTest(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("water bottle", Keys.ENTER);
        String title=driver.getTitle();
        if(title.contains("water bottle")){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!!");
        }
      driver.quit();

    }
//    Go to wikipedia.org
//    enter search term `selenium webdriver`
//    click on search button
//    click on search result `Selenium (software)`
//    verify url ends with `Selenium_(software)`
    public static void wikiTest(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        String link =driver.getCurrentUrl();
        if(link.contains("Selenium_(software)")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}
