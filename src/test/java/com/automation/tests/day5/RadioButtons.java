package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        List<WebElement>radioButtons =driver.findElements(By.tagName("input"));
        for (WebElement radioButton:radioButtons) {
            String id=radioButton.getAttribute("id");
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on : " + id);
                BrowserUtils.wait(1);
            }else{
                System.out.println(id+ " button is disabled,not clicked!!");
            }
        }

        driver.quit();

    }
}
