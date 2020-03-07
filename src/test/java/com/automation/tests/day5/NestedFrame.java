package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame {

    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement content = driver.findElement(By.id("content"));
        System.out.println("content is = " + content.getText());

        driver.quit();







    }
}
