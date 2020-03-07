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
        driver.switchTo().frame("mce_0_ifr");
        WebElement textInput=driver.findElement(By.id("tinymce"));
        System.out.println("textInput.getText() = " + textInput.getText());

        driver.quit();
    }
}
