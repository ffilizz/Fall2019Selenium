package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alert {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(3);
        String popupText=driver.switchTo().alert().getText();
        System.out.println("popupText = " + popupText);

        driver.switchTo().alert().accept();

        String expected="You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("Test PASSED!");
        }else{
            System.out.println("Test FAILED!!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
        BrowserUtils.wait(3);
        buttons.get(1).click();
        driver.switchTo().alert().dismiss(); // result must be: You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual:   "+actual2);
        }
        BrowserUtils.wait(3);
        buttons.get(2).click();
        driver.switchTo().alert().sendKeys("Hello, world!");
        driver.switchTo().alert().accept();

        String expected3 = "You entered: Hello, world!";
        String actual3 = driver.findElement(By.id("result")).getText();

        if(expected3.equals(actual3)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: " + expected3);
            System.out.println("Actual:   " + actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();


    }
}
