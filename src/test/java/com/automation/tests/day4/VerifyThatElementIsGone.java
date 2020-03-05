package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyThatElementIsGone {
    /**
     * Interview question:
     *
     * How to check if element doesn't exist anymore in the DOM (Document Object Model)
     */
    public static void main(String[] args) throws Exception {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if(driver.findElements(By.id("disappearing_button")).size()== 0){
            System.out.println("Test PASSED!");
        }else{
            System.out.println("Test FAILED!!");
        }
        Thread.sleep(2000);
        //to find all buttons
        //make sure that you us findElements <--- ending is important
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for(WebElement button: buttons){
            //click on every button
            button.click();
            Thread.sleep(2000);
        }

        driver.quit();





    }
}
