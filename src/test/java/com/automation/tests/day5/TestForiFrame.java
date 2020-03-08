package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForiFrame {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);
        //before looking for that element, we need to jump to that frame
        //you can specify: name, id, index or webelement of the frame
        //it's like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");
        //now, this content will be visible
        WebElement textInput=driver.findElement(By.id("tinymce"));
        System.out.println("textInput = " + textInput.getText());
        textInput.clear();
        BrowserUtils.wait(2);
        textInput.sendKeys("Hello World!!!");
        BrowserUtils.wait(2);
        //exit from the frame
        driver.switchTo().defaultContent();
        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        driver.quit();
    }
}